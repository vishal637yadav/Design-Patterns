package code.dp.creational.builder;

public class BuilderDriver {

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setName("John Doe")
                .setAge(30)
                .setAddress("123 Main St")
                .build();

        System.out.println("Person Details:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());
    }

}
