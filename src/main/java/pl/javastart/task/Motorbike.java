package pl.javastart.task;

public class Motorbike extends Vehicle {
    public static final String DESIGNATION = "motocykl";

    public Motorbike(String brand, String model, int year, double mileage, String vinNumber) {
        super(brand, model, year, mileage, vinNumber);
    }

    @Override
    public String toString() {
        return "Motorbike{" +
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
