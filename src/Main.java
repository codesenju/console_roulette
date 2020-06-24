import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

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

     
        String p1_no_or_evenodd = betPlayer1[0];// {BET-NUMBER/EVEN-ODD} PLAYER 1
        String p2_no_or_evenodd = betPlayer2[0];//{BET-NUMBER/EVEN-ODD} PLAYER 1
    
        p1_betAmount = Double.parseDouble(betPlayer1[1]);//Player 1 bet amount
        p2_betAmount = Double.parseDouble(betPlayer2[1]);//Player 2 bet amount

        RandomGenerator myRandomNumber = new RandomGenerator();
        Roulette game = new Roulette();

        //System.out.println("randon number is at: " + myRandomNumber.getNumber());
        Player p1 = game.playGame(myRandomNumber.getNumber(), p1_no_or_evenodd, p1_betAmount, p1_nameOfPalyer);
        Player p2 = game.playGame(myRandomNumber.getNumber(), p2_no_or_evenodd, p2_betAmount, p2_nameOfPalyer);

        System.out.println("Player \t\t\t\t Bet \t\t Outcome \t\t Winnings");
        System.out.println("---");
        System.out.println(p1.getPlayerName() + "\t" + p1.getBetNumber() + "" + p1.getBetString() + "\t\t" + p1.getOutcome()+ "\t\t\t\t" + p1.getWinnings());
        System.out.println(p2.getPlayerName() + "\t\t\t" + p2.getBetNumber() + "" + p2.getBetString() + "\t\t" + p2.getOutcome()+ "\t\t\t\t" + p2.getWinnings());
       
    }

    
}
