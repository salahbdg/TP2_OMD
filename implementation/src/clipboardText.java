// Classe PressePapier
public class clipboardText {
    private String content;

    public void copy(String texte) {
        this.content = texte;
    }

    public String paste() {
        return this.content;
    }
}
