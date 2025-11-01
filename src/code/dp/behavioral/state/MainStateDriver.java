package code.dp.behavioral.state;

public class MainStateDriver {

    public static void main(String[] args) {
        System.out.println("Main State Driver Class!!");
        Context context = new Context(new ConcreteStateA());

        context.request();
        System.out.println("1. context.getData()         ::"+context.getData());
        System.out.println("2. context.getCurrentState() ::"+context.getCurrentState());

        context.request();
        System.out.println("3. context.getData()         ::"+context.getData());
        System.out.println("4. context.getCurrentState() ::"+context.getCurrentState());

        context.request();
        System.out.println("5. context.getData()         ::"+context.getData());
        System.out.println("6. context.getCurrentState() ::"+context.getCurrentState());

        context.request();
        System.out.println("7. context.getData()         ::"+context.getData());
        System.out.println("8. context.getCurrentState() ::"+context.getCurrentState());

    }
}
