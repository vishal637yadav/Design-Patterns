package code.core.enumex;

public class EnumExample4 {

    enum Season {

        WINTER(5), SPRING(10), SUMMER(15), FALL(20);

        private int value;
        private Season(int value) {
            this.value=value;
        }
    }

    public static void main(String args[]){
        System.out.println("Attribute"+" ::"+"value");
        for (Season s : Season.values())
            System.out.println(s+" ::"+s.value);

    }

}
