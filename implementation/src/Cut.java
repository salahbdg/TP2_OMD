public class Cut implements Command {
    private Editor editor;

    public Cut(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.cut();
    }
}
