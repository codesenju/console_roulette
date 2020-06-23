import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static  Player playGame(int randomNumber, String no_or_evenodd, Double betAmount, String playerName) {
        String outcome = "LOSE";
        Player casinoPlayer = new Player();
        casinoPlayer.setPlayerName(playerName);
        int betNumber;
        if (no_or_evenodd.toUpperCase().contains("EVEN") || no_or_evenodd.toUpperCase().contains("ODD")) {
            System.out.println("Player 1 betted on EVEN or ODD");

            if (randomNumber % 2 == 0) {
                System.out.println("The given number " + randomNumber + " is Even ");
                if (no_or_evenodd.toUpperCase().contains("EVEN")) {
                    // /If the number is even, any bet on EVEN wins, and the player wins 2x the
                    // bet's amount.
                    winAmount = betAmount * 2;
                    outcome = "WIN";

                    casinoPlayer.setOutcome(outcome);
                    casinoPlayer.setWinnings(winAmount);
                    casinoPlayer.setBetString("EVEN");
                }
            } else {
                System.out.println("The given number " + randomNumber + " is Odd ");
                if (no_or_evenodd.toUpperCase().contains("ODD")) {
                    // /If the number is odd, any bet on EVEN wins, and the player wins 2x the bet's
                    // amount.
                    winAmount = betAmount * 2;
                    outcome = "WIN";

                    casinoPlayer.setOutcome(outcome);
                    casinoPlayer.setWinnings(winAmount);
                    casinoPlayer.setBetString("ODD");
                }
            }

        } else {
            System.out.println("The NEW Player 1 betted on 1 - 36");
            betNumber = Integer.parseInt(no_or_evenodd);
            casinoPlayer.setBetNumber(betNumber);
            if (betNumber == randomNumber) {
                // If the number is 1-36 then any bet on that number wins, and the player wins
                // 36x the bet's amount.
                winAmount = betAmount * 36;
                outcome = "WIN";
                System.out.println(betNumber);
                casinoPlayer.setOutcome(outcome);
                casinoPlayer.setWinnings(winAmount);
                System.out.println(casinoPlayer.getBetNumber());
            }
        }
        return casinoPlayer;
    }

    

    public static Double winAmount;

    public static void main(String[] args) throws IOException {

        int rand_int1; // random number
        Double p1_betAmount = 0.0;
        Double p2_betAmount = 0.0;

        FileReader file = new FileReader(System.getProperty("user.dir") + "\\file.txt");
        BufferedReader reader = new BufferedReader(file);

        ArrayList<String> players = new ArrayList<String>();
        int cnt = 0;
        //get player names from file.txt
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

        String p1_nameOfPalyer = players.get(0);
        System.out.print(p1_nameOfPalyer + " "); // Player1 {BET-NUMBER/EVEN-ODD} {BET-AMOUNT}
        String[] betPlayer1 = input.nextLine().split(" ");
        /*
                betPlayer1[0] = {BET-NUMBER/EVEN-ODD}
                betPlayer1[1] = {BET-AMOUNT}
        */


        String p2_nameOfPalyer = players.get(2);
        System.out.print(p2_nameOfPalyer + " "); // Player1 {BET-NUMBER/EVEN-ODD} {BET-AMOUNT}
        String[] betPlayer2 = input.nextLine().split(" ");
        /*
                betPlayer2[0] = {BET-NUMBER/EVEN-ODD}
                betPlayer2[1] = {BET-AMOUNT}
        */
        input.close();

        Random rand = new Random();
        // Generate random integers in range 0 to 3
        rand_int1 = rand.nextInt(3);
        
        System.out.println("random : " + rand_int1);

        String p1_no_or_evenodd = betPlayer1[0];// {BET-NUMBER/EVEN-ODD} PLAYER 1
        String p2_no_or_evenodd = betPlayer2[0];//{BET-NUMBER/EVEN-ODD} PLAYER 1
    
        p1_betAmount = Double.parseDouble(betPlayer1[1]);//Player 1 bet amount
        p2_betAmount = Double.parseDouble(betPlayer2[1]);//Player 2 bet amount

        Player p1 = playGame(rand_int1, p1_no_or_evenodd, p1_betAmount, p1_nameOfPalyer);
        Player p2 = playGame(rand_int1, p2_no_or_evenodd, p2_betAmount, p2_nameOfPalyer);

   
        System.out.println("Player \t\t\t\t Bet \t\t Outcome \t\t Winnings");
        System.out.println("---");
        System.out.println(p1.getPlayerName() + "\t" + p1.getBetNumber() + "" + p1.getBetString() + "\t\t" + p1.getOutcome()+ "\t\t\t\t" + p1.getWinnings());
        System.out.println(p2.getPlayerName() + "\t\t\t" + p2.getBetNumber() + "" + p2.getBetString() + "\t\t" + p2.getOutcome()+ "\t\t\t\t" + p2.getWinnings());
       
    }

    
}
