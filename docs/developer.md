# Developer file   

## Workspace for the version 1   
- `Editeur.java` : Contains the main editing logic.
- `PressePapier.java` : Managing copied text.
- `Selection.java` : Management of selection positions in the text.
- `Command.java` : Command interface with concrete implementations (`Copy`, `Cut`, etc.).
- `InterfaceGraphique.java` : Swing user interface with keyboard shortcuts.


### Main Methods   
- `Editeur.copier()` : Copies the selected text to the clipboard.
- `Editeur.couper()` : Cuts the selected text and copies it to the clipboard.
- `Editeur.coller()` : Pastes text from the clipboard to the selection or cursor position.


## Workspace for the version 2    


### Files Structure   
- `Memento.java` : Save text and selection state for undo/redo.
- `Historique.java` : Command storage and status history management.
- `Defaire.java`, `Refaire.java` : Implementations of history navigation commands.
-  Updated `InterfaceGraphique` to add keyboard shortcuts for undo (`CTRL+shift+ Z`) and redo (`CTRL+shift+Y`).


  ### Main Methods   
  - `Historique.ajouterCommande()` : Saves the command and associated state.
  - `Historique.defaire()` : Restores the previous state using `Memento`.
  - `Historique.refaire()` : Restores the next state using `Memento`.
