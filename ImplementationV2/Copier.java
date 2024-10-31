public class Copier implements Command {
    private Editeur editeur;

    public Copier(Editeur editeur) {
        this.editeur = editeur;
    }

    @Override
    public void execute() {
        String selection = editeur.selectText();
        editeur.getPressePapier().set(selection);
    }
}
