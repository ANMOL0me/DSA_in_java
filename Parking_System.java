import java.util.*;

public class Parking_System {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot lot = new ParkingLot(5);

        while (true) {

            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Park Car");
            System.out.println("2. Remove Car");
            System.out.println("3. Show Cars");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Car Number: ");
                    String car = sc.next();
                    lot.parkCar(car);
                    break;

                case 2:
                    lot.removeCar();
                    break;

                case 3:
                    lot.displayCars();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

class ParkingLot {

    Queue<String> parkingQueue;
    int capacity;

    ParkingLot(int capacity) {
        this.capacity = capacity;
        parkingQueue = new LinkedList<>();
    }

    // Car enters parking
    void parkCar(String carNumber) {

        if (parkingQueue.size() == capacity) {
            System.out.println("Parking Full! Car cannot enter.");
        } else {
            parkingQueue.add(carNumber);
            System.out.println("Car " + carNumber + " parked.");
        }
    }

    // Car leaves parking.
    void removeCar() {

        if (parkingQueue.isEmpty()) {
            System.out.println("Parking is empty.");
        } else {

            String car = parkingQueue.poll();   // FIFO removal
            System.out.println("Car " + car + " left the parking.");
        }
    }

    // Display parked cars
    void displayCars() {

        if (parkingQueue.isEmpty()) {
            System.out.println("No cars in parking.");
        } else {

            System.out.println("Cars in Parking:");

            for (String car : parkingQueue) {
                System.out.println(car);
            }
        }
    }
}