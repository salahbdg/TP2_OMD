public class Couper implements Command {
    private Editeur editeur;

    public Couper(Editeur editeur) {
        this.editeur = editeur;
    }

    @Override
    public void execute() {
        String selection = editeur.selectText();
        editeur.getPressePapier().set(selection);
        editeur.removeText();
    }
}
