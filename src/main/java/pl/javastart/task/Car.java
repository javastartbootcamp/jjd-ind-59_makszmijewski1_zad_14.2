package pl.javastart.task;

public class Car extends Vehicle {
    public static final String DESIGNATION = "samochód osobowy";

    public Car(String brand, String model, int year, double mileage, String vinNumber) {
        super(brand, model, year, mileage, vinNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }

    @Override
    public String toString2() {
        return DESIGNATION;
    }
}
