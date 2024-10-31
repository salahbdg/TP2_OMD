import java.util.ArrayList;
import java.util.List;

public class Historique {
    private final List<Command> commandes = new ArrayList<>();
    private final List<Memento> etats = new ArrayList<>();
    private int currentIndex = -1;

    public void ajouterCommande(Command commande, Memento etat) {
        // Supprimer les actions futures en cas de nouvelle commande
        while (commandes.size() > currentIndex + 1) {
            commandes.remove(commandes.size() - 1);
            etats.remove(etats.size() - 1);
        }
        commandes.add(commande);
        etats.add(etat);
        currentIndex++;
    }

    public Memento defaire() {
        if (currentIndex >= 0) {
            return etats.get(currentIndex--);
        }
        return null; // Aucun état à défaire
    }

    public Memento refaire() {
        if (currentIndex + 1 < etats.size()) {
            return etats.get(++currentIndex);
        }
        return null; // Aucun état à refaire
    }
}
