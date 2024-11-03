import java.util.ArrayList;
import java.util.List;

public class Historique {
    private final List<Command> coms = new ArrayList<>();
    private final List<Memento> states = new ArrayList<>();
    private int currInd = -1;

    public void ajouterCommande(Command com, Memento state) {
        while (coms.size() > currInd + 1) {
            coms.remove(coms.size() - 1);
            states.remove(states.size() - 1);
        }
        coms.add(com);
        states.add(state);
        currInd++;

    }

    public Memento defaire() {
        if (currInd > 0) {
            currInd--;
            return states.get(currInd);
        }
        return null; // Si y'a pas de state a defaire
    }

    public Memento refaire() {
        if (currInd + 1 < states.size()) {
            currInd++;
            return states.get(currInd);
        }
        return null; // Si y'a pas de state à refaire
    }
}
