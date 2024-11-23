import railway.*;

import java.util.List;

/**
 * Головний клас програми.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Створення потяга
            Train train = new Train();
            train.addCar(new PassengerCar(3, 50, 20));
            train.addCar(new SleepingCar(4, 20));
            train.addCar(new BaggageCar(2, 100));
            train.addCar(new PassengerCar(5, 80, 40));

            // Виведення початкового складу потяга
            System.out.println(train);

            // Розрахунок кількості пасажирів і багажу
            System.out.println("Загальна кількість пасажирів: " + train.getTotalPassengers());
            System.out.println("Загальна кількість багажу: " + train.getTotalBaggage());

            // Сортування вагонів за рівнем комфортності
            train.sortCarsByComfort();
            System.out.println("\nВагони після сортування за рівнем комфортності:");
            System.out.println(train);

            // Пошук вагонів за діапазоном пасажирів
            int minPassengers = 30;
            int maxPassengers = 60;
            List<RollingStock> filteredCars = train.findCarsByPassengerRange(minPassengers, maxPassengers);
            System.out.println("\nВагони з кількістю пасажирів від " + minPassengers + " до " + maxPassengers + ":");
            for (RollingStock car : filteredCars) {
                System.out.println(car);
            }

        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        }
    }
}
