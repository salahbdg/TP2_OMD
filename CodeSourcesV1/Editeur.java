public class Editeur {
    private String texte = "";
    private PressePapier clipB = new PressePapier();
    private Selection selection = new Selection();



    /*
    Fonction pour selectionner un texte, retourne la variable contenant le texte selectionne
    en utilisant le debut et la fin pour savoir ou ca commence la selection ou ca se termine
     */
    public String selectText() {
        return texte.substring(selection.getStart(), selection.getEnd());
    }

    // getter pour retourner le contenu du texte
    public String getTexte(){return texte;}

    // Pour supprimer le texte pour la commande couper
    public void removeText() {
        texte = texte.substring(0, selection.getStart()) + texte.substring(selection.getEnd());
    }

    // Pour replacer le texte pour la commande coller si on veut on replacer un texte selectionne
    public void replaceText(String text) {
        texte = texte.substring(0, selection.getStart()) + text + texte.substring(selection.getEnd());
    }


    public PressePapier getClipBoard() {
        return clipB;
    }

    public Selection getSelection() {
        return selection;
    }


    public void copier() {
        int start = selection.getStart();
        int end = selection.getEnd();

        // Afficher les indices de sélection et la longueur du texte(pour verifier si le texte a bien ete selectionne)
        System.out.println("Start: " + start + ", End: " + end + ", Texte length: " + texte.length());

        // Vérifier si la sélection est valide (si c'est un texte qui est selectionnee ou bien c'est le vide )
        if (start < end && end <= texte.length()) {
            String texteSelect = texte.substring(start, end);
            clipB.set(texteSelect);
            System.out.println(" !!!! Copied Text !!!!!: " + texteSelect);
        } else {
            System.out.println("ERROR !!!!! Invalid Selection !!!!");
        }
    }



    public void couper() {
        copier();
        deleteSelection();
        //Pour verifier si le texte a bien ete coupe ou pas (c'etait pour le debogage pour essayer de trouver des bugs si y'en a)
        System.out.println("Text after cut : " + texte);
    }



    public void coller() {
        String textPaste = clipB.get();
        if (textPaste != null && !textPaste.isEmpty()) {
            int start = selection.getStart();
            int end = selection.getEnd();

            if (start != end) {
                // Supprime la sélection si elle existe
                deleteSelection();
                start = selection.getStart(); // Maj du curseur
            }

            // Inserer le texte du presse papier dans la position du curseur (debut)
            String textBef = texte.substring(0, start);
            String textAft = texte.substring(start);
            texte = textBef + textPaste + textAft;

            // Màj de la position du curseur après avoir coller
            int newEnd = start + textPaste.length();
            selection.update(newEnd, newEnd);

            System.out.println("!!! Text after paste !!!: " + texte);
        } else {
            System.out.println("!!! ERROR !!! The ClipBoard is Empty !!!!!");
        }
    }


    private void deleteSelection() {
        int start = selection.getStart();
        int end = selection.getEnd();

        // Vérifier qu'on a bien selectionne un texte et pas un vide avant de supprimer
        if (start >= 0 && end <= texte.length() && start < end) {
            String textBef = texte.substring(0, start);
            String textAft = texte.substring(end);
            texte = textBef + textAft;

            // Màj de la sélection pour positionner le curseur au commencement de la zone supprimée.
            selection.update(start, start);
        }
    }

    // setter pour ajouter du texte
    public void setTexte(String texte) {
        this.texte = texte;
    }

}
