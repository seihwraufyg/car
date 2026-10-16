import java.util.Comparator;

public class ByPlateComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getPlateNumber().compareTo(v2.getPlateNumber());
    }
}