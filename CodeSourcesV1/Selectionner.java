public class Selectionner implements Command {
    private Editeur buffer;
    private int start;
    private int end;

    public Selectionner(Editeur buffer, int start, int end) {
        this.buffer = buffer;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        buffer.getSelection().update(start, end);
    }
}
