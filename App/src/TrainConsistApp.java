import java.util.Arrays;
import java.util.List;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        List<GoodsBogie> goodsBogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Grain"),
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );

        boolean isSafe = goodsBogies.stream()
                .allMatch(bogie -> {
                    if (bogie.getType().equalsIgnoreCase("Cylindrical")) {
                        return bogie.getCargo().equalsIgnoreCase("Petroleum");
                    }
                    return true;
                });

        if (isSafe) {
            System.out.println("The train formation is safety compliant.");
        } else {
            System.out.println("Safety violation detected! Unsafe cargo configuration.");
        }
    }
}