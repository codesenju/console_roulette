import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static  String playGame(int randomNumber, String no_or_evenodd, Double betAmount) {
        String outcome = "LOSE";
        int betNumber;
        if (no_or_evenodd.toUpperCase().contains("EVEN") || no_or_evenodd.toUpperCase().contains("ODD")) {
            System.out.println("Player 1 betted on EVEN or ODD");

            if (randomNumber % 2 == 0) {
                System.out.println("The given number " + randomNumber + " is Even ");
                if (no_or_evenodd.toUpperCase().contains("EVEN")) {
                    // /If the number is even, any bet on EVEN wins, and the player wins 2x the
                    // bet's amount.
                    p1_wins = betAmount * 2;
                    outcome = "WIN";
                }
            } else {
                System.out.println("The given number " + randomNumber + " is Odd ");
                if (no_or_evenodd.toUpperCase().contains("ODD")) {
                    // /If the number is odd, any bet on EVEN wins, and the player wins 2x the bet's
                    // amount.
                    p1_wins = betAmount * 2;
                    outcome = "WIN";
                }
            }

        } else {
            System.out.println("Player 1 betted on 1 - 36");
            betNumber = Integer.parseInt(no_or_evenodd);
            if (betNumber == randomNumber) {
                // If the number is 1-36 then any bet on that number wins, and the player wins
                // 36x the bet's amount.
                p1_wins = betAmount * 36;
                outcome = "WIN";
            }
        }
        return outcome;
    }

    

    public static Double p1_wins;
    public static Double p2_wins;

    public static void main(String[] args) throws IOException {

        int rand_int1; // random number
        Double betAmount = 0.0;
        FileReader file = new FileReader(System.getProperty("user.dir") + "\\file.txt");
        BufferedReader reader = new BufferedReader(file);

        ArrayList<String> players = new ArrayList<String>();
        int cnt = 0;
        String line = reader.readLine();
        while (line != null) {
            // players.get(0) = Player 1, players.get(2) = Player 2, players.get(4) = Player
            // 2, players.get(6) = Player 2 ...
            players.add(line);
            line = reader.readLine();
            cnt++;
        }
        reader.close();

        Scanner input = new Scanner(System.in);

        System.out.print(players.get(0) + " "); // Player1 {BET-NUMBER/EVEN-ODD} {BET-AMOUNT}
        String[] betPlayer1 = input.nextLine().split(" ");
        /*
                betPlayer1[0] = {BET-NUMBER/EVEN-ODD}
                betPlayer1[1] = {BET-AMOUNT}
        */


    //    System.out.print(players.get(2) + " ");//Player 2
    //    String[] betPlayer2 = input.nextLine().split(" ");
         input.close();

        Random rand = new Random();
        // Generate random integers in range 0 to 3
        rand_int1 = rand.nextInt(3);
        System.out.println("random : " + rand_int1);

        String p1_no_or_evenodd = betPlayer1[0];
        //String p2_no_or_evenodd = betPlayer2[0];
        System.out.println(p1_no_or_evenodd);
        betAmount = Double.parseDouble(betPlayer1[1]);

        System.out.println(playGame(rand_int1, p1_no_or_evenodd, betAmount));        
       
    }

    
}
