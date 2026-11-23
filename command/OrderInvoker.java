package command;

public class OrderInvoker {

    private OrderCommand command;

    public void setCommand(OrderCommand command) {
        this.command = command;
    }

    public void executeCommand() {

        if (command != null) {
            command.execute();
        } else {
            System.out.println("Tidak ada perintah.");
        }
    }
}