/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gorka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menu = 0, repeat = 0;
        do {
            System.out.println("Enter 1 to work with employees");
            System.out.println("Enter 2 to work with customers");
            System.out.println("Enter 3 to work with rooms");
            menu = Read.readInt("Enter 4 to work with reservations");
            switch (menu) {
                case 1:
                    MainMenu.employeeMenu();
                    break;
                case 2:
                    MainMenu.customerMenu();
                    break;
                case 3:
                    MainMenu.roomMenu();
                    break;
                case 4:
                    MainMenu.reservationMenu();
                    break;
            }
            do {
                repeat = Read.readInt("Enter 1 to go to the main menu. 2 to exit.");
            } while (repeat < 1 || repeat > 2);
        } while (repeat == 1);
    }
    
    
    }
    
    
    

