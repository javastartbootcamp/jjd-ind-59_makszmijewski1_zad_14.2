package pl.javastart.task;

public class Main {
    public static void main(String[] args) {
        VehicleControlStation vehicleControlStation = new VehicleControlStation();
        QueueReader queueReader = new QueueReader();
        queueReader.readFileAndSaveVehiclesToQueue(vehicleControlStation.getVehicles());
        vehicleControlStation.runSystem();
    }
}
