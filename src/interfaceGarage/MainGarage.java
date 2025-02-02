package interfaceGarage;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGarage {

    private static GarageDB garageDB;

    public static void start() {
        garageDB = new GarageDB();
        Scanner scanner = new Scanner(System.in);
        System.out.println("****Welcome to the garage!****");

        while (true){
            System.out.println("Enter a num 0-3: \n 1 - Motorcycle \n 2 - Car \n 3 - Truck \n 0 - Exit");
            int Type = scanner.nextInt();
            scanner.nextLine();

            if (Type == 0){
                break;
            }

            System.out.println("Enter the name of the Vehicle:" );
            String name = scanner.nextLine();


            Vehicle vehicle;
            switch (Type) {
                case 1:
                    garageDB.build(1, name);
                    break;
                case 2:
                    garageDB.build(2, name);
                    break;
                case 3:
                    garageDB.build(3, name);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }
            System.out.println("Vehicle added: " + name);


        }




        Garage garage = new Garage(protocolGarage);
        garage.startWork(new ArrayList<>(garageDB.getVehicles()));
        //garage.startWork(map);
    }

    private static Protocol_Garage protocolGarage = new Protocol_Garage() {
        @Override
        public void fixed() {
            System.out.println("another vehicle fixed $$");
        }
    };

    public void build(int type, String model) {
        //
    }
}
