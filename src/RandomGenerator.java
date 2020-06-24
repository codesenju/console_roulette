import java.util.Random;

public class RandomGenerator {
    private final Random random = new Random();

    private int lastNumber;
    private long lastRefreshTime;

    public int getNumber() {
        long now = System.currentTimeMillis();

        // If it's more than 30 seconds ago, generate a new random number
        if (now - lastRefreshTime > 30000L) {
            // Generate random integers in range 0 to 36
            lastNumber = random.nextInt(36);
        }

        lastRefreshTime = now;
        return lastNumber;
    }

}
