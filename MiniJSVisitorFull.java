import java.util.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MiniJSVisitorFull extends MiniJSBaseVisitor<Object> {
    private final Interpreter interpreter = new Interpreter();

    // دعم return في الدوال
    public static class ReturnValue extends RuntimeException {
        public final Object value;
        public ReturnValue(Object value) { this.value = value; }
    }

    @Override
    public Object visitProgram(MiniJSParser.ProgramContext ctx) {
        for (MiniJSParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        return null;
    }

    @Override
    public Object visitVariableDecl(MiniJSParser.VariableDeclContext ctx) {
        String name = ctx.Identifier().getText();
        Object value = ctx.expression() != null ? visit(ctx.expression()) : null;
        interpreter.setVariable(name, value);
        return value;
    }

    @Override
    public Object visitFunctionDecl(MiniJSParser.FunctionDeclContext ctx) {
        String name = ctx.Identifier().getText();
        interpreter.registerFunction(name, ctx);
        return null;
    }

    @Override
    public Object visitExpressionStatement(MiniJSParser.ExpressionStatementContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitAssignExpr(MiniJSParser.AssignExprContext ctx) {
        String name = ctx.leftHandSide().getText();
        Object value = visit(ctx.assignmentExpression());
        interpreter.setVariable(name, value);
        return value;
    }

    @Override
    public Object visitReturnStatement(MiniJSParser.ReturnStatementContext ctx) {
        Object value = ctx.expression() != null ? visit(ctx.expression()) : null;
        throw new ReturnValue(value);
    }

    @Override
    public Object visitLeftHandSide(MiniJSParser.LeftHandSideContext ctx) {
    Object current = interpreter.getVariable(ctx.Identifier(0).getText());
    if (current == null) {
        throw new RuntimeException("Variable not defined: " + ctx.Identifier(0).getText());
    }

    int idIndex = 1;

    for (int i = 1; i < ctx.getChildCount(); i++) {
        String token = ctx.getChild(i).getText();
        if (token.equals(".")) {
            String prop = ctx.Identifier(idIndex++).getText();
            if (current instanceof Map<?, ?>) {
                Map<?, ?> map = (Map<?, ?>) current;
                if (!map.containsKey(prop)) throw new RuntimeException("Property not found: " + prop);
                current = map.get(prop);
            } else if (current instanceof List<?> && prop.equals("length")) {
                current = ((List<?>) current).size();
            } else {
                throw new RuntimeException("Not an object: cannot access property " + prop);
            }
        } else if (token.equals("[")) {
            Object indexObj = visit(ctx.expression((i-1)/2));
            int index = ((Number) indexObj).intValue();
            if (!(current instanceof List<?>)) throw new RuntimeException("Not an array");
            current = ((List<?>) current).get(index);
        }
    }
    return current;
    }

    private void setLeftHandSide(MiniJSParser.LeftHandSideContext ctx, Object value) {
    String varName = ctx.Identifier(0).getText();
    Object current = interpreter.getVariable(varName);
    if (current == null) throw new RuntimeException("Variable not defined: " + varName);

    int idIndex = 1;
    for (int i = 1; i < ctx.getChildCount(); i++) {
        String token = ctx.getChild(i).getText();
        if (token.equals(".")) {
            String prop = ctx.Identifier(idIndex++).getText();
            if (i == ctx.getChildCount() - 2) {
                if (current instanceof Map<?, ?>) {
                    ((Map<String,Object>)current).put(prop, value);
                    return;
                } else {
                    throw new RuntimeException("Not an object: cannot set property " + prop);
                }
            } else {
                if (current instanceof Map<?, ?>) current = ((Map<String,Object>)current).get(prop);
                else throw new RuntimeException("Not an object: cannot access " + prop);
            }
        } else if (token.equals("[")) {
            int index = ((Number) visit(ctx.expression((i-1)/2))).intValue();
            if (!(current instanceof List<?>)) throw new RuntimeException("Not an array");
            if (i == ctx.getChildCount() - 2) {
                ((List<Object>)current).set(index, value);
                return;
            } else {
                current = ((List<Object>)current).get(index);
            }
        }
    }
    interpreter.setVariable(varName, value);
    }

    @Override
    public Object visitFunctionCall(MiniJSParser.FunctionCallContext ctx) {
        String funcName = ctx.leftHandSide().getText();

        // printArray خاصية
        if (funcName.equals("printArray")) {
            List<MiniJSParser.ExpressionContext> args = ctx.argumentList() != null ? ctx.argumentList().expression() : new ArrayList<>();
            for (MiniJSParser.ExpressionContext arg : args) {
                Object value = visit(arg);
                if (value instanceof List<?>) {
                    // اطبع المصفوفة كاملة بصيغة [1, 0, 2]
                    System.out.println(value);
                } else {
                    System.out.println(value);
                }
            }
            return null;
        }

        // print الأصلي
        if (funcName.equals("print")) {
            List<MiniJSParser.ExpressionContext> args = ctx.argumentList() != null ? ctx.argumentList().expression() : new ArrayList<>();
            for (MiniJSParser.ExpressionContext arg : args) {
                interpreter.print(visit(arg));
            }
            return null;
        }

        // التعامل مع الدوال المعرفة من المستخدم
        MiniJSParser.FunctionDeclContext funcCtx = interpreter.getFunction(funcName);
        if (funcCtx == null) throw new RuntimeException("Function not defined: " + funcName);

        interpreter.enterScope();
        List<TerminalNode> params = funcCtx.parameterList() != null ? funcCtx.parameterList().Identifier() : new ArrayList<>();
        List<MiniJSParser.ExpressionContext> args = ctx.argumentList() != null ? ctx.argumentList().expression() : new ArrayList<>();

        for (int i = 0; i < params.size(); i++) {
            interpreter.setVariable(params.get(i).getText(), visit(args.get(i)));
        }

        Object result = null;
        try {
            visit(funcCtx.block());
        } catch (ReturnValue rv) {
            result = rv.value;
        }

        interpreter.exitScope();
        return result;
    }

    @Override
    public Object visitObjectLiteral(MiniJSParser.ObjectLiteralContext ctx) {
        Map<String, Object> obj = new HashMap<>();
        if (ctx.property() != null) {
            for (MiniJSParser.PropertyContext prop : ctx.property()) {
                String key = prop.Identifier().getText();
                Object value = visit(prop.expression());
                obj.put(key, value);
            }
        }
        return obj;
    }

    @Override
    public Object visitArrayLiteral(MiniJSParser.ArrayLiteralContext ctx) {
        List<Object> arr = new ArrayList<>();
        for (MiniJSParser.ExpressionContext expr : ctx.expression()) {
            arr.add(visit(expr));
        }
        return arr;
    }

    @Override
    public Object visitLiteral(MiniJSParser.LiteralContext ctx) {
        if (ctx.NumberLiteral() != null) return Double.parseDouble(ctx.NumberLiteral().getText());
        if (ctx.StringLiteral() != null) return ctx.StringLiteral().getText().substring(1, ctx.StringLiteral().getText().length() - 1);
        if (ctx.BooleanLiteral() != null) return Boolean.parseBoolean(ctx.BooleanLiteral().getText());
        if (ctx.getText().equals("null")) return null;
        return null;
    }

    @Override
    public Object visitAdditiveExpression(MiniJSParser.AdditiveExpressionContext ctx) {
        Object left = visit(ctx.multiplicativeExpression(0));
        for (int i = 1; i < ctx.multiplicativeExpression().size(); i++) {
            Object right = visit(ctx.multiplicativeExpression(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (op.equals("+")) {
                if (left instanceof String || right instanceof String) {
                    left = String.valueOf(left) + String.valueOf(right);
                } else {
                    left = ((Number) left).doubleValue() + ((Number) right).doubleValue();
                }
            } else if (op.equals("-")) {
                left = ((Number) left).doubleValue() - ((Number) right).doubleValue();
            }
        }
        return left;
    }

    // لاحقًا يمكن إضافة visitMultiplicativeExpression و visitRelationalExpression و visitLogicalAndExpression و visitLogicalOrExpression بنفس الطريقة
}
