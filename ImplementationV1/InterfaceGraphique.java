import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InterfaceGraphique {
    private Editeur editeur;
    private JTextArea textArea;

    public InterfaceGraphique() {
        editeur = new Editeur();
        textArea = new JTextArea();
        JFrame frame = new JFrame("Editeur");

        // Ajouter des raccourcis clavier
        textArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK), "Copier");
        textArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK), "Couper");
        textArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK), "Coller");

        // Associer les actions
//        textArea.getActionMap().put("Copier", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                editeur.getSelection().update(textArea.getSelectionStart(), textArea.getSelectionEnd());
//                editeur.copier();
//            }
//        });

        textArea.getActionMap().put("Copier", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editeur.setTexte(textArea.getText());  // Synchronise le texte de JTextArea vers Editeur
                editeur.getSelection().update(textArea.getSelectionStart(), textArea.getSelectionEnd());
                editeur.copier();
            }
        });

//        textArea.getActionMap().put("Couper", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                editeur.getSelection().update(textArea.getSelectionStart(), textArea.getSelectionEnd());
//                editeur.couper();
//                textArea.setText(editeur.getTexte()); // Met à jour JTextArea après la coupe
//            }
//        });

        textArea.getActionMap().put("Couper", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editeur.setTexte(textArea.getText());  // Synchronise le texte de JTextArea vers Editeur
                editeur.getSelection().update(textArea.getSelectionStart(), textArea.getSelectionEnd());
                editeur.couper();
                textArea.setText(editeur.getTexte());  // Mise à jour de JTextArea après couper
            }
        });

//        textArea.getActionMap().put("Coller", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Utiliser la position actuelle du curseur si aucune sélection n'est faite
//                editeur.getSelection().update(textArea.getCaretPosition(), textArea.getCaretPosition());
//                editeur.coller();
//                textArea.setText(editeur.getTexte()); // Met à jour JTextArea après le collage
//            }
//        });

        textArea.getActionMap().put("Coller", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editeur.setTexte(textArea.getText());  // Synchronise le texte de JTextArea vers Editeur
                //editeur.getSelection().update(textArea.getCaretPosition(), textArea.getCaretPosition());
                editeur.getSelection().update(textArea.getSelectionStart(), textArea.getSelectionEnd());
                editeur.coller();
                textArea.setText(editeur.getTexte());  // Mise à jour de JTextArea après coller
            }
        });


        // Configurer le JFrame
        frame.add(new JScrollPane(textArea));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfaceGraphique::new);
    }
}
