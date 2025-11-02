package code.dp.behavioral.state.document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainDocumentDriver {

    public static void main(String[] args) throws IOException {

        DocumentContext documentContext = new DocumentContext("1", "Low Level Design", "List of Topics");
        System.out.println("Initial: " + documentContext);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        String doYouWantToContinue;
        do {
            System.out.println("=====================================================");
            documentContext.displayInfo();
            System.out.println("Choose action: 1-Draft, 2-Review, 3-Publish, 4-Archival, 5-Exit");
            System.out.print("You have Chosen: ");
            choice = br.readLine();
            System.out.println("-----------------------------------------------------");

            switch (choice) {
                case "1":
                    try {
                        documentContext.edit();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        documentContext.review();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        documentContext.publish();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        documentContext.archive();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Do you want to continue? (Yes - Y or y ) :");
            doYouWantToContinue = br.readLine();
        } while (doYouWantToContinue.equalsIgnoreCase("Y"));

    }
}
