import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class Bogie {
    private String id;
    private int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

class PassengerBogie extends Bogie {
    public PassengerBogie(String id, int capacity) {
        super(id, capacity);
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new PassengerBogie("B" + i, (int) (Math.random() * 100)));
        }

        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        System.out.println("Loop-based Filtering Time: " + (loopEnd - loopStart) + " ns");

        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();
        System.out.println("Stream-based Filtering Time: " + (streamEnd - streamStart) + " ns");

        System.out.println("Results Match: " + (loopFiltered.size() == streamFiltered.size()));
    }
}