
// Exemple d'utilisation
public class Main {
    public static void main(String[] args) {
        Editor editeur = new Editor();
        Invoker invoker = new Invoker();

        // Ajout de texte dans le buffer
        editeur.addText("Bonjour tout le monde .");
        editeur.setSelection(0, 7); // Sélectionne "Bonjour"

        // Copier le texte sélectionné
        Command copierCommande = new Copy(editeur);
        invoker.executeCommand(copierCommande);

        // Couper le texte sélectionné
        Command couperCommande = new Cut(editeur);
        invoker.executeCommand(couperCommande);

        // Coller le texte à une nouvelle position
        editeur.setSelection(15, 15); // Met le curseur après "tout le monde"
        Command collerCommande = new Paste(editeur);
        invoker.executeCommand(collerCommande);

        System.out.println("Contenu final du buffer : " + editeur.getTexte());
    }
}
