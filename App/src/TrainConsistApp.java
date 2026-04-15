class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {

        // Valid bogie
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + sleeper.getType() +
                    " with capacity " + sleeper.getCapacity());
        } catch (InvalidCapacityException e) {
            System.err.println(e.getMessage());
        }

        // Invalid bogie
        try {
            System.out.println("Attempting to create bogie with invalid capacity...");
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", -10);
        } catch (InvalidCapacityException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }
    }
}