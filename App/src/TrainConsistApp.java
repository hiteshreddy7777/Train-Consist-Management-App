import java.util.Scanner;

public class TrainConsistApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie " + searchKey + " found in the consist.");
        } else {
            System.out.println("Bogie " + searchKey + " not found.");
        }

        sc.close();
    }
}