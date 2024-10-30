public class AddText implements Command {
    private Editeur editeur;
    private String text;

    public AddText(Editeur editeur, String text) {
        this.editeur = editeur;
        this.text = text;
    }

    @Override
    public void execute() {
        editeur.addText(text);
    }
}
