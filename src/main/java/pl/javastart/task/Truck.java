package pl.javastart.task;

public class Truck extends Vehicle {
    public static final String DESIGNATION = "ciężarówka";

    public Truck(String brand, String model, int year, double mileage, String vinNumber) {
        super(brand, model, year, mileage, vinNumber);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }

    public String toString2() {
        return DESIGNATION;
    }
}
