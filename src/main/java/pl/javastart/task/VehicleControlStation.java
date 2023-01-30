package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VehicleControlStation {
    private static final int END_OF_PROGRAM = 0;
    private static final int ADD_CAR_TO_QUEUE = 1;
    private static final int PICK_UP_VEHICLE_FROM_QUEUE = 2;
    private Queue<Vehicle> vehicles = new LinkedList<>();

    public Queue<Vehicle> getVehicles() {
        return vehicles;
    }

    public void runSystem() {
        boolean exit = true;
        while (exit) {
            System.out.println("Dzień dobry, co chcesz zrobić?");
            int option = chooseOption();
            switch (option) {
                case END_OF_PROGRAM -> {
                    exitProgram();
                    exit = false;
                }
                case ADD_CAR_TO_QUEUE -> {
                    Vehicle vehicle = createVehicle();
                    vehicles.add(vehicle);
                }
                case PICK_UP_VEHICLE_FROM_QUEUE -> {
                    if (!vehicles.isEmpty()) {
                        System.out.println(vehicles.poll());
                    } else {
                        System.out.println("Brak pojazdów w kolejce");
                    }
                }
                default -> System.out.println("Nieporpawna opcja");
            }
        }
    }

    private void exitProgram() {
        QueueWriter queueWriter = new QueueWriter();
        if (vehicles.isEmpty()) {
            queueWriter.clearQueue();
        } else {
            queueWriter.saveQueue(this);
        }
    }

    public String carAsString() {
        Vehicle vehicle = vehicles.poll();
        return vehicle.getType() + ";" + vehicle.getBrand() + ";" + vehicle.getModel() + ";" + vehicle.getYear() + ";" + vehicle.getMileage() + ";"
                + vehicle.getVinNumber();
    }

    private int chooseOption() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while (option != END_OF_PROGRAM && option != ADD_CAR_TO_QUEUE && option != PICK_UP_VEHICLE_FROM_QUEUE) {
            System.out.println(END_OF_PROGRAM + " - koniec programu");
            System.out.println(ADD_CAR_TO_QUEUE + " - dodaj nowy pojazd do kolejki");
            System.out.println(PICK_UP_VEHICLE_FROM_QUEUE + " - pobierz pojazd z kolejki do przeglądu");
            option = scanner.nextInt();
        }
        return option;
    }

    private Vehicle createVehicle() {
        Scanner scanner = new Scanner(System.in);
        String type;
        System.out.println("Podaj typ pojazdu: ");
        type = scanner.nextLine();
        String brand;
        System.out.println("Podaj markę pojazdu: ");
        brand = scanner.nextLine();
        String model;
        System.out.println("Podaj model pojazdu: ");
        model = scanner.nextLine();
        int year;
        System.out.println("Podaj rok produkcji pojazdu: ");
        year = scanner.nextInt();
        scanner.nextLine();
        double mileage;
        System.out.println("Podaj przebieg pojazdu: ");
        mileage = scanner.nextDouble();
        scanner.nextLine();
        String vinNumber;
        System.out.println("Podaj vin pojazdu: ");
        vinNumber = scanner.nextLine();
        return new Vehicle(type, brand, model, year, mileage, vinNumber);
    }
}
