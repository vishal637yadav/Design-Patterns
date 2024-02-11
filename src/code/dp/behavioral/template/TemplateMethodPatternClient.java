package code.dp.behavioral.template;

class TemplateMethodPatternClient {

    public static void main(String[] args) {

        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder(true);
        System.out.println();
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);

    }
}