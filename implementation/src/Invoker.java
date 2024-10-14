// Classe Invoker
public class Invoker {
    private Command command;

    public void executeCommand(Command command) {
        this.command = command;
        command.execute();
    }

    public Command getCommand() {
        return command;
    }
}
