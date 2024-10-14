public class Paste implements Command {
    private Editor editor;

    public Paste(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.paste();
    }
}
