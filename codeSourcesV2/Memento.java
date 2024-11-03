public class Memento {
    private final String texte;
    private final int start;
    private final int end;

    public Memento(String texte, int start, int end) {
        this.texte = texte;
        this.start = start;
        this.end = end;
    }

    public String getTexte() {
        return texte;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
