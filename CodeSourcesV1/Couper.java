public class Couper implements Command {
    private Editeur buffer;

    public Couper(Editeur editeur) {
        this.buffer = editeur;
    }

    @Override
    public void execute() {
        String selec = buffer.selectText();
        buffer.getClipBoard().set(selec);
        buffer.removeText();
    }
}
