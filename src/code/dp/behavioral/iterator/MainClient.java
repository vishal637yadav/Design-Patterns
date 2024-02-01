package code.dp.behavioral.iterator;

// Driver Class
public class MainClient {

    public static void main(String args[]) {
        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();
    }
    
}
