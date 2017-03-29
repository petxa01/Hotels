/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file MainMenu.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 10-mar-2017
 * @Time 9:35:27
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22
 * in Templates/Classes/Class.java.
 *
 */
public class MainMenu {

    public static void reservationMenu() {
        int menu = 0, repeat = 0;
        do {
            System.out.println("Enter 1 to create a reservation");
            System.out.println("Enter 2 to show all reservations");
            System.out.println("Enter 3 to search a reservation");
            menu = Read.readInt("Enter 4 to delete a reservation");
            switch (menu) {
                case 1:
                    WorkObjectFiles.writeReservation();
                    break;
                case 2:
                    WorkObjectFiles.readReservation();
                    break;
                case 3:
                    WorkObjectFiles.searchReservation();
                    break;
                case 4:
                    WorkObjectFiles.removeReservation();
                    break;

            }
            do {
                repeat = Read.readInt("Enter 1 to go to the reservation menu. 2 to exit.");
            } while (repeat < 1 || repeat > 2);
        } while (repeat == 1);
    }
    public static void roomMenu() {
        int menu = 0, repeat = 0;
        do {
            System.out.println("Enter 1 to create a room");
            System.out.println("Enter 2 to show all rooms");
            System.out.println("Enter 3 to search a room");
            menu = Read.readInt("Enter 4 to delete a room");
            switch (menu) {
                case 1:
                    WorkObjectFiles.writeRoom();
                    break;
                case 2:
                    WorkObjectFiles.readRoom();
                    break;
                case 3:
                    WorkObjectFiles.searchRoom();
                    break;
                case 4:
                    WorkObjectFiles.removeRoom();
                    break;

            }
            do {
                repeat = Read.readInt("Enter 1 to go to the room menu. 2 to exit.");
            } while (repeat < 1 || repeat > 2);
        } while (repeat == 1);
    }
    public static void customerMenu() {
        int menu = 0, repeat = 0;
        do {
            System.out.println("Enter 1 to create a customer");
            System.out.println("Enter 2 to show all customers");
            System.out.println("Enter 3 to search a customer");
            menu = Read.readInt("Enter 4 to delete a customer");
            switch (menu) {
                case 1:
                    WorkObjectFiles.writeCustomer();
                    break;
                case 2:
                    WorkObjectFiles.readCustomer();
                    break;
                case 3:
                    WorkObjectFiles.searchCustomer();
                    break;
                case 4:
                    WorkObjectFiles.removeCustomer();
                    break;

            }
            do {
                repeat = Read.readInt("Enter 1 to go to the customer menu. 2 to exit.");
            } while (repeat < 1 || repeat > 2);
        } while (repeat == 1);
    }
    public static void employeeMenu() {
        int menu = 0, repeat = 0;
        do {
            System.out.println("Enter 1 to create a employee");
            System.out.println("Enter 2 to show all employees");
            System.out.println("Enter 3 to search a employee");
            menu = Read.readInt("Enter 4 to delete a employee");
            switch (menu) {
                case 1:
                    WorkObjectFiles.writeEmployee();
                    break;
                case 2:
                    WorkObjectFiles.readEmployee();
                    break;
                case 3:
                    WorkObjectFiles.searchEmployee();
                    break;
                case 4:
                    WorkObjectFiles.removeEmployee();
                    break;

            }
            do {
                repeat = Read.readInt("Enter 1 to go to the employee menu. 2 to exit.");
            } while (repeat < 1 || repeat > 2);
        } while (repeat == 1);
    }
}
