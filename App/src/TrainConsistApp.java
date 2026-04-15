class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String bogieId;
    private String shape;
    private String currentCargo;

    public GoodsBogie(String bogieId, String shape) {
        this.bogieId = bogieId;
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            System.out.println("Initiating cargo assignment for Bogie: " + bogieId);

            if (this.shape.equalsIgnoreCase("Rectangular") && cargoType.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe Assignment: Petroleum cannot be carried in a Rectangular bogie.");
            }

            this.currentCargo = cargoType;
            System.out.println("Success: " + cargoType + " assigned to bogie " + bogieId);

        } catch (CargoSafetyException e) {
            System.err.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Cargo validation process completed for Bogie: " + bogieId);
        }
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        GoodsBogie bogie1 = new GoodsBogie("B001", "Cylindrical");
        GoodsBogie bogie2 = new GoodsBogie("B002", "Rectangular");

        System.out.println("--- Scenario 1: Safe Assignment ---");
        bogie1.assignCargo("Petroleum");

        System.out.println("\n--- Scenario 2: Unsafe Assignment ---");
        bogie2.assignCargo("Petroleum");

        System.out.println("\n--- Program Execution Continues ---");
        bogie2.assignCargo("Grain");
    }
}