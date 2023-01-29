package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VehicleControlStation {
    private static final int ZERO_CHOICE = 0;
    private static final int ONE_CHOICE = 1;
    private static final int TWO_CHOICE = 2;
    private static final int THREE_CHOICE = 3;
    private Queue<Vehicle> vehicles = new LinkedList<>();

    public static void main(String[] args) {
        VehicleControlStation vehicleControlStation = new VehicleControlStation();
        vehicleControlStation.checkQueue();
        vehicleControlStation.runSystem();
    }

    private void checkQueue() {
        try (BufferedReader reader = new BufferedReader(new FileReader("queue.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] values = s.split(";");
                switch (values[5]) {
                    case Car.DESIGNATION -> {
                        vehicles.add(new Car(values[0], values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3]), values[4]));
                    }
                    case Motorbike.DESIGNATION -> {
                        vehicles.add(new Motorbike(values[0], values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3]), values[4]));
                    }
                    case Truck.DESIGNATION -> {
                        vehicles.add(new Truck(values[0], values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3]), values[4]));
                    }
                    default -> System.out.println("błąd programu");
                }
            }
        } catch (IOException e) {
            System.out.println("Brak aut w kolejce");
        }
    }

    private void runSystem() {
        boolean condition = true;
        while (condition) {
            System.out.println("Dzień dobry, co chcesz zrobić?");
            int choice = chooseOption();
            switch (choice) {
                case ZERO_CHOICE -> {
                    if (vehicles.isEmpty()) {
                        clearQueue();
                        condition = false;
                    } else {
                        saveQueue();
                        condition = false;
                    }
                }
                case ONE_CHOICE -> vehicles.add(createVehicle());
                case TWO_CHOICE -> {
                    if (!vehicles.isEmpty()) {
                        System.out.println(vehicles.poll());
                    } else {
                        System.out.println("Brak pojazdów w kolejce");
                    }
                }
                default -> System.out.println("Błąd programu");
            }
        }
    }

    private void clearQueue() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("queue.txt"))) {
            writer.write("");
        } catch (IOException e) {
            System.out.println("błąd");
        }
    }

    private void saveQueue() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("queue.txt"));
            for (int i = 0; i <= vehicles.size(); i++) {
                String savedCartoFile = carAsString();
                writer.write(savedCartoFile + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("nie udało się zapisać");
        }
    }

    private String carAsString() {
        Vehicle vehicle = vehicles.poll();
        return vehicle.brand + ";" + vehicle.model + ";" + vehicle.year + ";" + vehicle.mileage + ";"
                + vehicle.vinNumber + ";" + vehicle.toString2();
    }

    private int chooseOption() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while (option != ZERO_CHOICE && option != ONE_CHOICE && option != TWO_CHOICE) {
            System.out.println(ZERO_CHOICE + " - koniec programu");
            System.out.println(ONE_CHOICE + " - dodaj nowy pojazd do kolejki");
            System.out.println(TWO_CHOICE + " - pobierz pojazd z kolejki do przeglądu");
            option = scanner.nextInt();
        }
        return option;
    }

    private Vehicle createVehicle() {
        Scanner scanner = new Scanner(System.in);
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
        int choice = 0;
        while (choice != ONE_CHOICE && choice != TWO_CHOICE && choice != THREE_CHOICE) {
            System.out.println("Podaj typ pojazdu: ");
            System.out.println(ONE_CHOICE + " - samochód osobowy");
            System.out.println(TWO_CHOICE + " - samochód ciężarowy");
            System.out.println(THREE_CHOICE + " - motocykl");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case ONE_CHOICE -> {
                return new Car(brand, model, year, mileage, vinNumber);
            }
            case TWO_CHOICE -> {
                return new Truck(brand, model, year, mileage, vinNumber);
            }
            case THREE_CHOICE -> {
                return new Motorbike(brand, model, year, mileage, vinNumber);
            }
            default -> {
                System.out.println("Nie udało się utworzyć pojazdu");
                return null;
            }
        }
    }
}
