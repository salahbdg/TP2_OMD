public class Couper implements Command {
    private Editeur editeur;

    public Couper(Editeur editeur) {
        this.editeur = editeur;
    }

    @Override
    public void execute() {
        String selec = editeur.selectText();
        editeur.getClipBoard().set(selec);
        editeur.removeText();
    }
}
