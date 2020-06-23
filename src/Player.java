/**
 * Player Class
 * 
 * @author Lehlogonolo mAsubelele
 * @version 2020-06-23
 */
public class Player {
    // instance variables - replace the example below with your own
    private int betNumber;
    private String betString;
    private int cnt;
    private Double winnings;
    private String name;
    private String outcome;

    /**
     * Constructor for objects of class MyClass
     */
    public Player() {
        // initialise instance variables
        betNumber = 0;
        cnt = 0;
        winnings = 0.0;
        name = "Player";
        outcome = "LOSE";
        betString = "";
    }

    // Getters

    public Double getWinnings() {

        return winnings;
    }

    public int getCnt() {

        return cnt;
    }

    public int getBetNumber() {

        return betNumber;
    }

    public String getBetString() {

        return betString;
    }

    public String getPlayerName() {
        return name;
    }

    public String getOutcome(){
        return outcome;
    }

    

    // Setters

    public void setPlayerName(String playerName) {
        this.name = playerName;
    }

    public void setWinnings(Double playerWinnings) {
        this.winnings = playerWinnings;
    }

    public void setCnt(int newCnt) {
        this.cnt = newCnt;
    }

    public void setOutcome(String newOutcome) {
        this.outcome = newOutcome;
    }

    public void setBetNumber(int newBetNumber) {
        this.betNumber = newBetNumber;
    }
    public void setBetString(String newBetString) {
        this.betString = newBetString;
    }

}