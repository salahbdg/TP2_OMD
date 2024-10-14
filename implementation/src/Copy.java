// Commandes concrètes
public class Copy implements Command {
    private Editor editor;

    public Copy(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.copy();
    }
}
