// Classe Selection
public class Selection {
    private int start;
    private int end;

    public Selection(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void update(int newStart, int newEnd) {
        this.start = newStart;
        this.end = newEnd;
    }
}
