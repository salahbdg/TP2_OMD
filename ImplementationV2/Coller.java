public class Coller implements Command {
    private Editeur editeur;

    public Coller(Editeur editeur) {
        this.editeur = editeur;
    }

    @Override
    public void execute() {
        String clipboardContent = editeur.getPressePapier().get();
        editeur.replaceText(clipboardContent);
    }
}
