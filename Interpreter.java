import java.util.*;

public class Interpreter {
    private Deque<Map<String, Object>> env = new ArrayDeque<>();
    private Map<String, MiniJSParser.FunctionDeclContext> functions = new HashMap<>();

    public Interpreter() {
        env.push(new HashMap<>()); // global scope
    }

    public void enterScope() {
        env.push(new HashMap<>());
    }

    public void exitScope() {
        env.pop();
    }

    public void setVariable(String name, Object value) {
        for (Map<String, Object> scope : env) {
            if (scope.containsKey(name)) {
                scope.put(name, value);
                return;
            }
        }
        env.peek().put(name, value); // new variable in current scope
    }

    public Object getVariable(String name) {
        for (Map<String, Object> scope : env) {
            if (scope.containsKey(name)) return scope.get(name);
        }
        throw new RuntimeException("Variable not defined: " + name);
    }

    public void print(Object obj) {
        System.out.println(obj);
    }

    public void registerFunction(String name, MiniJSParser.FunctionDeclContext ctx) {
        functions.put(name, ctx);
    }

    public MiniJSParser.FunctionDeclContext getFunction(String name) {
        return functions.get(name);
    }
}
