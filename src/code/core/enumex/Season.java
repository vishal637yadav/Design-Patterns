package code.core.enumex;

public enum Season {

    WINTER(10),SPRING(20),SUMMER(30);

    private int value;

    Season(int value){
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println("!!!--------------::-:||:-::--------------------!!!");
        Season s=Season.WINTER;
        System.out.println(s);
    }
}
