import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = "test.js";
        InputStream is = new FileInputStream(inputFile);
        CharStream input = CharStreams.fromStream(is);

        MiniJSLexer lexer = new MiniJSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJSParser parser = new MiniJSParser(tokens);

        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));

        MiniJSVisitorFull visitor = new MiniJSVisitorFull();
        visitor.visit(tree);
    }
}
