package code.dp.behavioral.chainofresponsibility;

public class TestChain {

    public static void main(String[] args) {

        Chain chain = new Chain();
        System.out.println(" Calling chain of responsibility !! ");

        chain.process(new Number(90));
        chain.process(new Number(-50));
        chain.process(new Number(0));
        chain.process(new Number(91));
    }


}
