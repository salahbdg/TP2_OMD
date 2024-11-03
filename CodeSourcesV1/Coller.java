public class Coller implements Command {
    private Editeur buffer;

    public Coller(Editeur buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        String clipBCont = buffer.getClipBoard().get();
        buffer.replaceText(clipBCont);
    }
}
