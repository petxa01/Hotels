package Hotels;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @file Checks.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 20-mar-2017
 * @Time 12:28:53
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22
 * in Templates/Classes/Class.java.
 *
 */
public class Checks {

    public static boolean customerNanCheck(String nan) {
        boolean aurkitua = false;
        try {
            boolean eof = true;
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Customer.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true && aurkitua == false) {
                Customer cust = new Customer(1);

                cust = (Customer) so.readObject();
                int compare = nan.compareTo(cust.getNan());
                if (compare == 0) {
                    aurkitua = true;
                }

            }
        } catch (FileNotFoundException ex) {

        } catch (IOException | ClassNotFoundException ex) {

        }
        return aurkitua;
    }

    public static boolean employeeNanCheck(String nan) {
        boolean aurkitua = false;
        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Employees.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true && aurkitua == false) {
                Employee emp = new Employee(1);

                emp = (Employee) so.readObject();
                int compare = nan.compareTo(emp.getNan());
                if (compare == 0) {
                    aurkitua = true;
                }

            }
        } catch (FileNotFoundException ex) {

        } catch (IOException | ClassNotFoundException ex) {

        }
        return aurkitua;
    }

    public static boolean roomNumberCheck(int roomNumber) {
        boolean aurkitua = false;
        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Room.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true && aurkitua == false) {
                Room room = new Room(1);

                room = (Room) so.readObject();

                if (roomNumber == room.getNumber()) {
                    aurkitua = true;
                }

            }
        } catch (FileNotFoundException ex) {

        } catch (IOException | ClassNotFoundException ex) {

        }
        return aurkitua;
    }

    public static boolean dateCheck(LocalDate date) {
        boolean inRange = false;

        if (date.getYear() > LocalDate.now().getYear() + 4) {
            System.out.println("You should enter a earlier date max( " + (LocalDate.now().getYear() + 4) + ")");
        } else {
            if (date.isBefore(LocalDate.now())) {

            } else {
                inRange = true;
            }
        }

        return inRange;
    }

    public static boolean nanLengthCheck(String nan) {
        nan = nan.trim();
        int length = nan.length();
        if (length != 9) {
            return false;
        } else {
            return true;
        }

    }

    public static Reservation reservationCheck() {
        boolean eof = false, valid = true;
        int roomNumber = 0;
        int res_cod = 0;
        boolean resCodeCheck;
        LocalDate enterDate = null, leaveDate = null;
        ArrayList<Reservation> res = new ArrayList<>(); //saving here the rooms that have already a reservation
        ArrayList room = new ArrayList(); // arraylist to save the room numbers of the witch have the same roomtype that the user wants
        ArrayList resNumber = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Room.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            String roomType = Menu.roomTypeMenu();
            while (true) { //to get only the rooms with the type of room the user wants

                Room room2 = new Room(1);// object to read every room in the in the file
                room2 = (Room) so.readObject();

                int compare = roomType.compareTo(room2.getTypeOfRoom());
                if (compare == 0) {
                    room.add(room2.getNumber());
                }

            
            }
            
        } catch (FileNotFoundException ex){
            System.out.println("Cant file the file");
        } catch (ClassNotFoundException | IOException ex) {
            
        }
        do {
            eof = false;
            valid = true;
            resNumber.clear();
            try {
                FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Reservation.ser");
                MiObjectInputStream so = new MiObjectInputStream(fis);
                res.clear();
                while (true) {

                    Reservation res2 = new Reservation(1);
                    res2 = (Reservation) so.readObject();
                    //bilatu room number, room arraylistean, baldin badago, gehitu reservations arraylistera

                    if (room.contains(res2.getRoomNumber())) { //to get from reservations the rooms of the type the user wants
                        res.add(res2);
                    }

                }


            } catch (FileNotFoundException ex) {
                System.out.println("Reservations file not found");
            } catch (ClassNotFoundException | IOException ex) {
                
            }
            
            for (int i = 0; i < res.size(); i++) {//to use the .contains method
                resNumber.add(res.get(i).getRoomNumber());

            }

            enterDate = Read.readDate("Write the enter date:");

            System.out.println("This are the rooms that meet your criteria:");
            for (int i = 0; i < res.size(); i++) {
                if (enterDate.isBefore(res.get(i).getLeaveDate()) || enterDate.isEqual(res.get(i).getLeaveDate())) {//to show the rooms already reservated an in what dates
                    System.out.println("Room number: " + res.get(i).getRoomNumber());
                    System.out.println("Enter date: " + res.get(i).getEnterDate());
                    System.out.println("Leave date: " + res.get(i).getLeaveDate());
                }
            }
            for (int i = 0; i < room.size(); i++) {//to show the rooms with the same roomtype but never reservated before
                if (!resNumber.contains(room.get(i))) {
                    System.out.println("Room number: " + room.get(i));
                    System.out.println("Enter date: Empty");
                    System.out.println("Leave date: Empty");
                }

            }
            do {
                roomNumber = Read.readInt("Enter one of the rooms witch are empty when you want to stay");

            } while (!room.contains(roomNumber));//to be sure the room number is valid
            do {
                leaveDate = Read.readDate("Write the leave date:");
                if (enterDate.isAfter(leaveDate)) {
                    System.out.println("You sould leave after you entered");
                }
            } while (enterDate.isAfter(leaveDate));

            if (resNumber.contains(roomNumber)) {
                for (int i = 0; i < res.size() && valid == true; i++) {//res arraylista irakurtzeko
                    if (res.get(i).getRoomNumber() == roomNumber) {//only to look into the room the user selected
                        if ((enterDate.isBefore(res.get(i).getEnterDate()) || enterDate.isEqual(res.get(i).getEnterDate())) && (leaveDate.isAfter(res.get(i).getEnterDate())) || leaveDate.isEqual((res.get(i).getEnterDate()))) {
                            valid = false;

                        }
                        if ((enterDate.isAfter(res.get(i).getEnterDate()) || enterDate.isEqual(res.get(i).getEnterDate())) && (enterDate.isBefore(res.get(i).getLeaveDate())) || enterDate.isEqual(res.get(i).getLeaveDate())) {
                            valid = false;

                        }
                        if ((leaveDate.isAfter(res.get(i).getEnterDate()) || leaveDate.isEqual(res.get(i).getEnterDate())) && (leaveDate.isBefore(res.get(i).getLeaveDate())) || leaveDate.isEqual(res.get(i).getLeaveDate())) {
                            valid = false;

                        }
                    }//if roomNumber
                }//fin for
            }
            if (valid == false) {
                System.out.println("Those are not a valid dates for that room");
            }

        } while (valid == false);
        do {
            res_cod = Read.readInt("Enter a reservation code");
            resCodeCheck = Checks.res_codCheck(res_cod);
            if (resCodeCheck == false) {
                System.out.println("That reservation code is already in use please use another one");
            }
        } while (resCodeCheck == false);

        
        Reservation last= new Reservation(1);
        last.setRoomNumber(roomNumber);
        last.setEnterDate(enterDate);
        last.setLeaveDate(leaveDate);
        last.setRes_cod(res_cod);
        return last;
        
    }

    public static boolean res_codCheck(int OGres_cod) {
        boolean valid = true;
        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Reservation.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true) {
                Reservation res2 = new Reservation(1);
                    res2 = (Reservation) so.readObject();
                if (res2.getRes_cod()== OGres_cod) {
                    valid = false;
                }
            }

        } catch (FileNotFoundException gaizki) {
            System.out.println("File not Found.");
        } catch (ClassNotFoundException| IOException ex) {
            
        }
        return valid;
    }

}
