public class Car extends Vehicle implements Insurable {
    private int seats;

    public Car(String plateNumber, double dailyRate, int seats) {
        super(plateNumber, dailyRate);
        this.seats = seats;
    }

    @Override
    public double getInsuranceFee() {
        return dailyRate * 0.05;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days > 7) {
            return dailyRate * days * 0.9; // скидка 10%
        }
        return dailyRate * days;
    }

    @Override
    public String toString() {
        return super.toString() + " [Car, мест: " + seats + "]";
    }
}