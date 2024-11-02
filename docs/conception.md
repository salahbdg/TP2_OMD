# Conception File   

## Version 1: Basic editing functions    

### UML Use Case (V1)    

![image](https://github.com/user-attachments/assets/fcfd6cad-992f-4101-b83f-03663cb11242)


###   UML Class Model (V1)   


![image](https://github.com/user-attachments/assets/7a0a068e-7332-4751-96ee-8b43170e0689)
    

### Explanations    
- `Editeur` : The main class that handles text and editing operations.
- `Command` : Interface for the Command pattern, with concrete implementations (`Copy`, `Cut`, `Paste`, `Select`).
- `InterfaceGraphique` : Manages the user interface with keyboard shortcuts for editing actions.


### UML Sequence Model (V1)  

![image](https://github.com/user-attachments/assets/f19c6ed7-6239-43c0-9e79-077b16f2a63d)    

This diagram shows the sequence of actions for a `Coller` command, illustrating the interaction between `InterfaceGraphique`, `Editeur`, and `PressePapier`.


### Version 2: Recording Actions and Undo/Redo


### UML Use Case (V2)    

![image](https://github.com/user-attachments/assets/2dd3b5d7-ad72-4598-b257-8254757c7311)


### UML Class Model (V2)

![image](https://github.com/user-attachments/assets/8580c053-8e86-4978-933c-4ca632a80b1b)    

### Explanations    
- `Memento` : Stores editor state for undo/redo functionality.
- `Historique` : Handles saving and retrieving states for undo/redo.
- `Defaire` et `Refaire` : Commands to navigate the editing history.
- `InterfaceGraphique` : Updated to handle `CTRL+shift+Z` (undo) and `CTRL+shift+Y` (redo) shortcuts.


### UML Sequence Model (V2)   
![image](https://github.com/user-attachments/assets/dc51e06b-ce5a-434f-91d9-58eedfe3cb70)    

This diagram shows the sequence of actions for the `Defaire` command, including saving state to `Memento` and restoring state via `Historique`.





