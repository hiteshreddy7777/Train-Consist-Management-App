import java.util.Arrays;

public class TrainConsistApp {
    public static void main(String[] args) {
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        Arrays.sort(bogieTypes);

        System.out.println(Arrays.toString(bogieTypes));
    }
}