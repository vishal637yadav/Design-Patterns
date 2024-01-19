package code.core.enumex;

public class EnumExample1 {

    //defining enum inside class
    public enum Season{WINTER,SPRING,SUMMER,AUTOM};

    public static void main(String[] args) {
        System.out.println("This is main ...");

        for(Season s : Season.values() ) {
            System.out.println("Season::"+s);
        }

        System.out.println("------------------------------------------");
        System.out.println("Value of WINTER is: "+Season.valueOf("WINTER"));
        System.out.println("Index of WINTER is: "+Season.valueOf("WINTER").ordinal());
        System.out.println("Index of SUMMER is: "+Season.valueOf("SUMMER").ordinal());

    }
}
