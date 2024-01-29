package code.dp.creational.abstractfactory;

abstract class AbstractFactory {

    public abstract Bank getBank(String bank);

    public abstract Loan getLoan(String loan);

}
