public class Truck extends Vehicle implements Insurable {
    private double capacityTons;

    public Truck(String plateNumber, double dailyRate, double capacityTons) {
        super(plateNumber, dailyRate);
        this.capacityTons = capacityTons;
    }

    @Override
    public double getInsuranceFee() {
        return dailyRate * 0.08;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (dailyRate * days) + (500 * days); // доплата за водителя
    }

    @Override
    public String toString() {
        return super.toString() + " [Truck, грузоподъемность: " + capacityTons + "т]";
    }
}