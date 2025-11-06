// Generated from d:/Antlr/MiniJS.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJSParser}.
 */
public interface MiniJSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniJSParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniJSParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJSParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJSParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJSParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJSParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(MiniJSParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(MiniJSParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MiniJSParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MiniJSParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MiniJSParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MiniJSParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniJSParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniJSParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniJSParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniJSParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MiniJSParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MiniJSParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MiniJSParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MiniJSParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MiniJSParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MiniJSParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJSParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJSParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link MiniJSParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MiniJSParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link MiniJSParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MiniJSParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expr}
	 * labeled alternative in {@link MiniJSParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiniJSParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expr}
	 * labeled alternative in {@link MiniJSParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiniJSParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(MiniJSParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(MiniJSParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(MiniJSParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(MiniJSParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(MiniJSParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(MiniJSParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(MiniJSParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(MiniJSParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(MiniJSParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(MiniJSParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(MiniJSParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(MiniJSParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(MiniJSParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(MiniJSParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(MiniJSParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(MiniJSParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MiniJSParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MiniJSParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MiniJSParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MiniJSParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniJSParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniJSParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(MiniJSParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(MiniJSParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(MiniJSParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(MiniJSParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(MiniJSParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(MiniJSParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MiniJSParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MiniJSParser.LiteralContext ctx);
}