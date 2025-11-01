package code.dp.behavioral.state.document;

public class MainDocumentDriver {

    public static void main(String[] args) {
        System.out.println("-----main------");
        Document myDoc1 = new Document("1","Low Level Design","List of Topics");

        myDoc1.displayInfo();
        myDoc1.displayStateHistory();

        myDoc1.edit();

    }
}
