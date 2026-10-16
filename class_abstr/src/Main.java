import java.util.*;

public class Main {

    public static <T> T findCheapest(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) return null;
        T cheapest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            if (comparator.compare(current, cheapest) < 0) {
                cheapest = current;
            }
        }
        return cheapest;
    }

    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("А123БВ77", 2500.0, 5));
        fleet.add(new Motorcycle("М456ОП77", 1200.0, 0.6));
        fleet.add(new Truck("Т789УР77", 6000.0, 10.5));
        fleet.add(new Car("К321МН78", 3000.0, 4));
        fleet.add(new Motorcycle("В987СТ77", 900.0, 0.4));

        System.out.println("=== Часть Б: Вывод автопарка ===");
        for (Vehicle v : fleet) {
            System.out.println(v);
        }

        Set<String> uniquePlates = new HashSet<>();
        for (Vehicle v : fleet) {
            uniquePlates.add(v.getPlateNumber());
        }

        System.out.println("\n=== Часть В: Set и Map ===");
        System.out.println("Размер fleet: " + fleet.size() + " | Размер uniquePlates: " + uniquePlates.size());
        System.out.println("Есть ли дубликаты номеров: " + (uniquePlates.size() < fleet.size()));

        Map<String, Vehicle> byPlate = new HashMap<>();
        for (Vehicle v : fleet) {
            byPlate.put(v.getPlateNumber(), v);
        }

        String searchKey = "Т789УР77";
        System.out.println("Найденный автомобиль по номеру " + searchKey + ": " + byPlate.get(searchKey));

        System.out.println("\n=== Часть Г: HashSet и Queue ===");
        Set<Vehicle> testSet = new HashSet<>();
        testSet.add(new Car("Х777ХХ77", 4000.0, 5));
        testSet.add(new Car("Х777ХХ77", 5500.0, 2));
        System.out.println("Размер HashSet с одинаковыми номерами (ожидается 1): " + testSet.size());

        Queue<Vehicle> serviceQueue = new LinkedList<>();
        serviceQueue.offer(fleet.get(1));
        serviceQueue.offer(fleet.get(2));

        System.out.println("Очередь на обслуживание:");
        while (!serviceQueue.isEmpty()) {
            System.out.println("Обслуживается: " + serviceQueue.poll());
        }

        System.out.println("\n=== Часть Д: Сортировка ===");
        Collections.sort(fleet);
        System.out.println("Отсортировано по цене (от дешевых к дорогим):");
        for (Vehicle v : fleet) {
            System.out.println(v);
        }

        Collections.sort(fleet, new ByPlateComparator());
        System.out.println("\nОтсортировано по гос. номеру (алфавит):");
        for (Vehicle v : fleet) {
            System.out.println(v);
        }

        System.out.println("\n=== Часть Е: Бонус (findCheapest) ===");
        Vehicle cheapest = findCheapest(fleet, Comparator.comparingDouble(Vehicle::getDailyRate));
        System.out.println("Самый дешевый автомобиль в парке: " + cheapest);
    }
}