import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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

        System.out.print(players.get(0) + " ");
        String[] betPlayer1 = input.nextLine().split(" ");

        System.out.print(players.get(2) + " ");
        String[] betPlayer2 = input.nextLine().split(" ");

        Random rand = new Random();
        // Generate random integers in range 0 to 36
        int rand_int1 = rand.nextInt(36);
        System.out.println("random : " + rand_int1);

        //
        String p1_no_or_evenodd = betPlayer1[0];
        String p2_no_or_evenodd = betPlayer2[0];
        System.out.println(p1_no_or_evenodd);

        if (p1_no_or_evenodd.toUpperCase().contains("EVEN") || p1_no_or_evenodd.toUpperCase().contains("ODD")){
        System.out.println("Player 1 betted on EVEN or ODD");
        } else {
            System.out.println("Player 1 betted on 1 - 36");
        }

           
        if (p2_no_or_evenodd.toUpperCase().contains("EVEN") || p2_no_or_evenodd.toUpperCase().contains("ODD")){
            System.out.println("Player 2 betted on EVEN or ODD");
            } else {
                System.out.println("Player 2 betted on 1 - 36");
            }
    

        //
        String p1_bet = betPlayer1[1];
       // double p2_bet = Double.parseDouble(betPlayer2[1]);

    }

}
