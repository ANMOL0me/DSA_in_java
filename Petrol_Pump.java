import java.util.Scanner;

class PetrolPump {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double petrolPrice = 106.5;
        double dieselPrice = 94.2;

        int choice;
        double liters, amount;

        System.out.println("===== Welcome to Petrol Pump =====");
        System.out.println("1. Petrol");
        System.out.println("2. Diesel");
        System.out.print("Select Fuel Type: ");
        choice = sc.nextInt();

        System.out.print("Enter Number of Liters: ");
        liters = sc.nextDouble();

        if (choice == 1) {
            amount = liters * petrolPrice;
            System.out.println("\nFuel Type : Petrol");
            System.out.println("Price per Liter : " + petrolPrice);
            System.out.println("Liters : " + liters);
            System.out.println("Total Amount : ₹" + amount);
        } 
        else if (choice == 2) {
            amount = liters * dieselPrice;
            System.out.println("\nFuel Type : Diesel");
            System.out.println("Price per Liter : " + dieselPrice);
            System.out.println("Liters : " + liters);
            System.out.println("Total Amount : ₹" + amount);
        } 
        else {
            System.out.println("Invalid Choice!");
        }

        System.out.println("===== Thank You Visit Again =====");
    }
}