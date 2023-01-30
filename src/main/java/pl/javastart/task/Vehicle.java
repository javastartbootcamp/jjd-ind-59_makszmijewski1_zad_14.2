package pl.javastart.task;

public class Vehicle {
    private String type;
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private String vinNumber;

    public Vehicle(String type, String brand, String model, int year, double mileage, String vinNumber) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vinNumber = vinNumber;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getMileage() {
        return mileage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }
}
