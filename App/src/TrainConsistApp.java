import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("=============================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + trainIdMatcher.matches());
        System.out.println("Cargo Code Valid: " + cargoCodeMatcher.matches());

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}