public class Selectionner implements Command {
    private Editeur editeur;
    private int start;
    private int end;

    public Selectionner(Editeur editeur, int start, int end) {
        this.editeur = editeur;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        editeur.getSelection().update(start, end);
    }
}
