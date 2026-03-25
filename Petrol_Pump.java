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

 