package code.core.enumex;

public class TestEnum {

    Days day;

    public TestEnum(Days day){
        this.day = day;
    }

    public void dayIsLike() {

        switch (this.day){

            case MONDAY:
                System.out.println("Monday is Badd!!");
                break;
            case FRIDAY:
                System.out.println("Friday is Better!!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Week-ends are best!!");
                break;
            default:
                System.out.println("Mid-Week days are so so.");
        }

    }
    public static void main(String[] args) {
        System.out.println("This is Main");

        String day = "MONDAY";
        System.out.println("-----------------------:day="+day);
        TestEnum testEnum = new TestEnum(Days.valueOf(day));
        testEnum.dayIsLike();

        day = "SUNDAY";
        System.out.println("-----------------------:day="+day);
        testEnum = new TestEnum(Days.valueOf(day));
        testEnum.dayIsLike();

        day = "SATURDAY";
        System.out.println("-----------------------:day="+day);
        testEnum = new TestEnum(Days.valueOf(day));
        testEnum.dayIsLike();

        day = "FRIDAY";
        System.out.println("-----------------------:day="+day);
        testEnum = new TestEnum(Days.valueOf(day));
        testEnum.dayIsLike();

        day = "WEDNESDAY";
        System.out.println("-----------------------:day="+day);
        testEnum = new TestEnum(Days.valueOf(day));
        testEnum.dayIsLike();

    }


}
