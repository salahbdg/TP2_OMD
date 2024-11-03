public class Copier implements Command {
    private Editeur buffer;

    public Copier(Editeur buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        String selec = buffer.selectText();
        buffer.getClipBoard().set(selec);
    }
}
