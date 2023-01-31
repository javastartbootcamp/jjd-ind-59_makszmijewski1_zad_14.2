package pl.javastart.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class QueueWriter {
    public void clearQueue() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("queue.txt"))) {
            writer.write("");
        } catch (IOException e) {
            System.out.println("błąd");
        }
    }

    public void saveQueue(VehicleControlStation vehicleControlStation) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("queue.txt"));
            int loopsieze = vehicleControlStation.getVehicles().size();
            for (int i = 0; i < loopsieze; i++) {
                String savedCarToFile = vehicleControlStation.carAsString();
                writer.write(savedCarToFile + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("nie udało się zapisać");
        }
    }
}
