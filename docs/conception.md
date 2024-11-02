# Conception File   

## Version 1: Basic editing functions    

### UML Use Case    

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


