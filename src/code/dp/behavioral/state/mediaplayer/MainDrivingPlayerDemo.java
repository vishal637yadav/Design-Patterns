package code.dp.behavioral.state.mediaplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainDrivingPlayerDemo {

    public static void main(String[] args) throws IOException {
        PlayerContext player = new PlayerContext();
        System.out.println("Initial: " + player.getStateName());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        String doYouWantToContinue;
        do {
            System.out.println("=====================================================");
            System.out.println("Current State: " + player.getStateName());
            System.out.println("Choose action: 1-Play, 2-Pause, 3-Stop, 4-Exit");
            System.out.print("You have Chosen: ");
            choice = br.readLine();
            System.out.println("-----------------------------------------------------");

            switch (choice) {
                case "1":
                    try {
                        player.play();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        player.pause();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        player.stop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
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
