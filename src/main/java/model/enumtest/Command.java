package model.enumtest;

public class Command {
    final Op operation;
    final String name;


    public Command(Op operation, String name) {
        this.operation = operation;
        this.name=name;
    }
}
