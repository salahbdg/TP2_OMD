public class Editeur {
    private String texte = "";
    private PressePapier pressePapier = new PressePapier();
    private Selection selection = new Selection();

    public String selectText() {
        return texte.substring(selection.getStart(), selection.getEnd());
    }

    public String getTexte(){return texte;}
    public void removeText() {
        texte = texte.substring(0, selection.getStart()) + texte.substring(selection.getEnd());
    }

    public void replaceText(String text) {
        texte = texte.substring(0, selection.getStart()) + text + texte.substring(selection.getEnd());
    }

    public void addText(String text) {
        texte += text;
    }

    public PressePapier getPressePapier() {
        return pressePapier;
    }

    public Selection getSelection() {
        return selection;
    }

//    public void copier() {
//        String texteSelectionne = texte.substring(selection.getStart(), selection.getEnd());
//        pressePapier.set(texteSelectionne);
//    }
//public void copier() {
//    int start = selection.getStart();
//    int end = selection.getEnd();
//
//    // Vérifie que la sélection est dans les limites du texte
//    if (start >= 0 && end <= texte.length() && start < end) {
//        String texteSelectionne = texte.substring(start, end);
//        pressePapier.set(texteSelectionne);
//    } else {
//        pressePapier.set(""); // Si la sélection est invalide, on ne copie rien
//    }
//}

    public void copier() {
        int start = selection.getStart();
        int end = selection.getEnd();

        // Débogage : Affiche les indices de sélection et la longueur du texte
        System.out.println("Start: " + start + ", End: " + end + ", Texte length: " + texte.length());

        // Vérifie que la sélection est valide
        if (start < end && end <= texte.length()) {
            String texteSelectionne = texte.substring(start, end);
            pressePapier.set(texteSelectionne);
            System.out.println("Texte copié dans le presse-papiers : " + texteSelectionne);
        } else {
            System.out.println("Sélection invalide pour copier.");
        }
    }



    public void couper() {
        copier(); // Copier avant de couper
        supprimerSelection();
        System.out.println("Texte après couper : " + texte);
    }

//    public void coller() {
//        String texteColler = pressePapier.get();
//        if (texteColler != null && !texteColler.isEmpty()) {
//            int start = selection.getStart();
//            int end = selection.getEnd();
//
//            if (start != end) {
//                // Supprime la sélection si elle existe
//                supprimerSelection();
//                start = selection.getStart();
//            }
//
//            // Re-calculer la position du curseur si le texte a été supprimé
//
//
//            // Insérer le texte du presse-papiers à la position de départ
//            String texteAvant = texte.substring(0, start);
//            String texteApres = texte.substring(start);
//            texte = texteAvant + texteColler + texteApres;
//
//            // Met à jour la sélection après le collage
//            int nouvelEnd = start + texteColler.length();
//            selection.update(nouvelEnd, nouvelEnd);
//        }
//    }

    public void coller() {
        String texteColler = pressePapier.get();
        if (texteColler != null && !texteColler.isEmpty()) {
            int start = selection.getStart();
            int end = selection.getEnd();

            if (start != end) {
                // Supprime la sélection si elle existe
                supprimerSelection();
                start = selection.getStart(); // Mise à jour du curseur après suppression
            }

            // Insère le texte du presse-papiers à la position de `start`
            String texteAvant = texte.substring(0, start);
            String texteApres = texte.substring(start);
            texte = texteAvant + texteColler + texteApres;

            // Met à jour la position du curseur après le collage
            int nouvelEnd = start + texteColler.length();
            selection.update(nouvelEnd, nouvelEnd);

            System.out.println("Texte après collage : " + texte);
        } else {
            System.out.println("Presse-papiers vide, rien à coller.");
        }
    }





    //    private void supprimerSelection() {
//        String texteAvant = texte.substring(0, selection.getStart());
//        String texteApres = texte.substring(selection.getEnd());
//        texte = texteAvant + texteApres;
//    }
private void supprimerSelection() {
    int start = selection.getStart();
    int end = selection.getEnd();

    // Vérifie que la sélection est valide avant de supprimer
    if (start >= 0 && end <= texte.length() && start < end) {
        String texteAvant = texte.substring(0, start);
        String texteApres = texte.substring(end);
        texte = texteAvant + texteApres;

        // Met à jour la sélection pour placer le curseur au début de la zone supprimée
        selection.update(start, start);
    }
}

    public void setTexte(String texte) {
        this.texte = texte;
    }

}
