package pl.javastart.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;

public class QueueReader {
    public void readFileAndSaveVehiclesToQueue(Queue<Vehicle> vehicles) {
        try (BufferedReader reader = new BufferedReader(new FileReader("queue.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] values = s.split(";");
                vehicles.add(new Vehicle(values[0], values[1], values[2], Integer.parseInt(values[3]), Double.parseDouble(values[4]), values[5]));
            }
        } catch (IOException e) {
            System.out.println("Brak aut w kolejce");
        }
    }
}
