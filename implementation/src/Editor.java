// Classe Editeur (Buffer principal)
public class Editor {
    private String texte;
    private clipboardText clipboardText;
    private Selection selection;

    public Editor() {
        this.texte = "";
        this.clipboardText = new clipboardText();
        this.selection = new Selection(0, 0);
    }

    public String selectText() {
        return texte.substring(selection.getStart(), selection.getEnd());
    }

    public void removeText() {
        String before = texte.substring(0, selection.getStart());
        String after = texte.substring(selection.getEnd());
        texte = before + after;
    }

    public void replaceText(String newText) {
        removeText();
        String before = texte.substring(0, selection.getStart());
        texte = before + newText;
    }

    public void addText(String newText) {
        String before = texte.substring(0, selection.getStart());
        String after = texte.substring(selection.getStart());
        texte = before + newText + after;
    }

    public void copy() {
        String selectedText = selectText();
        clipboardText.copy(selectedText);
    }

    public void cut() {
        String selectedText = selectText();
        clipboardText.copy(selectedText);
        removeText();
    }

    public void paste() {
        String clipboardTextText = clipboardText.paste();
        replaceText(clipboardTextText);
    }

    public void setSelection(int start, int end) {
        selection.update(start, end);
    }

    public String getTexte() {
        return texte;
    }
}
