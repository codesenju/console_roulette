public class Roulette {

    /**
     * Roulltte Game
     * @param randomNumber
     * @param no_or_evenodd
     * @param betAmount
     * @param playerName
     * @return Player Object with winning info
     */
public Player playGame(int randomNumber, String no_or_evenodd, Double betAmount, String playerName) {
    String outcome = "LOSE";
    Player casinoPlayer = new Player();
    casinoPlayer.setPlayerName(playerName);
    int betNumber;
    Double winAmount = 0.0;
    if (no_or_evenodd.toUpperCase().contains("EVEN") || no_or_evenodd.toUpperCase().contains("ODD")) {
      //  System.out.println("Player 1 betted on EVEN or ODD");

        if (randomNumber % 2 == 0) {
            //System.out.println("The given number " + randomNumber + " is Even ");
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
            //System.out.println("The given number " + randomNumber + " is Odd ");
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
        //System.out.println("Player " + playerName + " betted on 1 - 36");
        betNumber = Integer.parseInt(no_or_evenodd);
        casinoPlayer.setBetNumber(betNumber);
        if (betNumber == randomNumber) {
            // If the number is 1-36 then any bet on that number wins, and the player wins
            // 36x the bet's amount.
            winAmount = betAmount * 36;
            outcome = "WIN";
           // System.out.println(betNumber);
            casinoPlayer.setOutcome(outcome);
            casinoPlayer.setWinnings(winAmount);
           // System.out.println(casinoPlayer.getBetNumber());
        }
    }
    return casinoPlayer;
}

}
