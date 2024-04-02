

public class ASTBuilder extends MusicLanguageBaseVisitor<ASTNode>{
    @Override
    public ASTNode visitProgram(MusicLanguageParser.ProgramContext ctx) {
        ASTNode programNode = new ASTNode("program");
        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            programNode.addChild(visit(statementContext));
        }

        return programNode;
    }

}
