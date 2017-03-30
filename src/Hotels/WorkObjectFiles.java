package Hotels;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @file NewClass.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 15-mar-2017
 * @Time 13:17:13
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22
 * in Templates/Classes/Class.java.
 *
 */
public class WorkObjectFiles {

    public static void writeEmployee() {
        int repeat = 0;
        boolean aurkitua;

        do {
            Employee emp = new Employee(1);
            emp.setNan();
            aurkitua = Checks.employeeNanCheck(emp.getNan());
            if (!aurkitua) {
                emp.setName();
                emp.setSurname1();
                emp.setSurname2();
                emp.setPhone();
                emp.setEmail();
                emp.setGender();
                emp.setJobType();
                try {
                    FileOutputStream fos = new FileOutputStream("C:\\users\\Petxa\\Employees.ser", true);
                    MiObjectOutputStream so = new MiObjectOutputStream(fos);
                    so.writeObject(emp);
                    so.close();
                    fos.close();
                } catch (FileNotFoundException gaizki) {
                    System.out.println("File not Found.");
                } catch (IOException gaizki) {
                    System.out.println("Error: " + gaizki.toString());
                }
            }
            do {
                System.out.println();
                repeat = Read.readInt("1- to add another employee. 0- to exit");
            } while (repeat < 0 || repeat > 1);
        } while (repeat == 1);
    }

    public static void writeCustomer() {
        int repeat = 0;
        boolean aurkitua;
        do {
            Customer cust = new Customer(1);
            cust.setNan();
            aurkitua = Checks.customerNanCheck(cust.getNan());
            if (!aurkitua) {
                cust.setName();
                cust.setSurname1();
                cust.setSurname2();
                cust.setPhone();
                cust.setEmail();
                cust.setGender();

                try (MiObjectOutputStream so = new MiObjectOutputStream(new FileOutputStream("C:\\users\\Petxa\\Customer.ser", true))) {

                    so.writeObject(cust);

                    so.close();
                } catch (FileNotFoundException gaizki) {
                    System.out.println("File not Found.");
                } catch (IOException gaizki) {
                    System.out.println("Error: " + gaizki.toString());
                }
            }
            do {
                repeat = Read.readInt("Enter 1 to enter another customer. 0 to exit");

            } while (repeat < 0 || repeat > 1);

        } while (repeat == 1);

    }//bukatuta

    public static void writeRoom() {
        int repeat;
        boolean aurkitua;
        do {
            Room room = new Room(1);
            room.setNumber();
            aurkitua = Checks.roomNumberCheck(room.getNumber());
            if (!aurkitua) {
                room.setFloor();
                room.setTypeOfRoom();
            }

            try (MiObjectOutputStream so = new MiObjectOutputStream(new FileOutputStream("C:\\users\\Petxa\\Room.ser", true))) {

                so.writeObject(room);

                so.close();
            } catch (FileNotFoundException gaizki) {
                System.out.println("File not Found.");
            } catch (IOException gaizki) {
                System.out.println("Error: " + gaizki.toString());
            }
            do {
                repeat = Read.readInt("1. to repeat 0 to exit");
            } while (repeat < 0 || repeat > 1);
        } while (repeat == 1);

    }

    public static void writeReservation() {
        int repeat = 0;
        boolean aurkitua;
        do {
            Reservation res = new Reservation(1);
            res.setCustomerNan();
            aurkitua = Checks.customerNanCheck(res.getCustomerNan());
            if (aurkitua) {
                Reservation res2 = Checks.reservationCheck();
                res2.setCustomerNan(res.getCustomerNan());
                try (MiObjectOutputStream so = new MiObjectOutputStream(new FileOutputStream("C:\\users\\Petxa\\Reservation.ser", true))) {

                    so.writeObject(res2);

                    so.close();
                } catch (FileNotFoundException gaizki) {
                    System.out.println("File not Found.");
                } catch (IOException gaizki) {
                    System.out.println("Error: " + gaizki.toString());
                }

            } else {
                System.out.println("Please create the customer before the reservation");
            }

        } while (repeat == 1);
    }

    public static void readEmployee() {
        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Employees.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true) {
                Employee emp = new Employee(1);

                emp = (Employee) so.readObject();

                System.out.println("NAN: " + emp.getNan());
                System.out.println("Name: " + emp.getName());
                System.out.println("First surname: " + emp.getSurname1());
                System.out.println("Second surname: " + emp.getSurname2());
                System.out.println("Phone: " + emp.getPhone());
                System.out.println("Email: " + emp.getEmail());
                System.out.println("Gender: " + emp.getGender());
                System.out.println("Job type " + emp.getJobType());
                System.out.println("****************************************************");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void readCustomer() {

        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Customer.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true) {
                Customer cust = new Customer(1);

                cust = (Customer) so.readObject();

                System.out.println("NAN: " + cust.getNan());
                System.out.println("Name: " + cust.getName());
                System.out.println("First surname: " + cust.getSurname1());
                System.out.println("Second surname: " + cust.getSurname2());
                System.out.println("Phone: " + cust.getPhone());
                System.out.println("Email: " + cust.getEmail());
                System.out.println("Gender: " + cust.getGender());
                System.out.println("Paying Method: " + cust.getPayingMethod());
                System.out.println("****************************************************");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }

    }

    public static void readRoom() {
        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Room.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true) {
                Room room = new Room(1);

                room = (Room) so.readObject();

                System.out.println("Number " + room.getNumber());
                System.out.println("Floor " + room.getFloor());
                System.out.println("Type of room " + room.getTypeOfRoom());
                System.out.println("****************************************************");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void readReservation() {
        try {
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Reservation.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            while (true) {
                Reservation res = new Reservation(1);

                res = (Reservation) so.readObject();

                System.out.println("Reservation code:  " + res.getRes_cod());
                System.out.println("Room Number " + res.getRoomNumber());
                System.out.println("Enter date " + res.getEnterDate());
                System.out.println("Leave date " + res.getLeaveDate());
                System.out.println("****************************************************");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void searchEmployee() {
        try {
            boolean aurkitua = false;
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Employees.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            String nan = Read.readString("Enter the nan of the employee you want to search");
            while (true && !aurkitua) {
                Employee emp = new Employee(1);

                emp = (Employee) so.readObject();
                int compare = nan.compareTo(emp.getNan());
                if (compare == 0) {
                    System.out.println("NAN: " + emp.getNan());
                    System.out.println("Name: " + emp.getName());
                    System.out.println("First surname: " + emp.getSurname1());
                    System.out.println("Second surname: " + emp.getSurname2());
                    System.out.println("Phone: " + emp.getPhone());
                    System.out.println("Email: " + emp.getEmail());
                    System.out.println("Gender: " + emp.getGender());
                    System.out.println("Job type " + emp.getJobType());
                    System.out.println("****************************************************");
                    aurkitua = true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void searchCustomer() {
        try {
            boolean aurkitua = false;
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Customer.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            String nan = Read.readString("Enter the nan of the customer you want to search");
            while (true && !aurkitua) {
                Customer cust = new Customer(1);

                cust = (Customer) so.readObject();
                int compare = nan.compareTo(cust.getNan());
                if (compare == 0) {
                    System.out.println("NAN: " + cust.getNan());
                    System.out.println("Name: " + cust.getName());
                    System.out.println("First surname: " + cust.getSurname1());
                    System.out.println("Second surname: " + cust.getSurname2());
                    System.out.println("Phone: " + cust.getPhone());
                    System.out.println("Email: " + cust.getEmail());
                    System.out.println("Gender: " + cust.getGender());
                    System.out.println("Paying Method: " + cust.getPayingMethod());
                    System.out.println("****************************************************");
                    aurkitua = true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void searchRoom() {
        try {
            boolean aurkitua = false;
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Room.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            int roomNumber = Read.readInt("Enter the room number");
            while (true && !aurkitua) {
                Room room = new Room(1);

                room = (Room) so.readObject();
                if (room.getNumber() == roomNumber) {
                    System.out.println("Number " + room.getNumber());
                    System.out.println("Floor " + room.getFloor());
                    System.out.println("Type of room " + room.getTypeOfRoom());
                    System.out.println("****************************************************");
                    aurkitua = true;
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void searchReservation() {
        try {
            boolean aurkitua = false;
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Reservation.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            int resCod = Read.readInt("Enter the reservation code");
            while (true && !aurkitua) {
                Reservation res = new Reservation(1);

                res = (Reservation) so.readObject();
                if (res.getRes_cod() == resCod) {
                    System.out.println("Reservation code:  " + res.getRes_cod());
                    System.out.println("Room Number " + res.getRoomNumber());
                    System.out.println("Enter date " + res.getEnterDate());
                    System.out.println("Leave date " + res.getLeaveDate());
                    System.out.println("****************************************************");
                    aurkitua = true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void removeEmployee() {
        ArrayList<Employee> emp = new ArrayList<>();
        int repeat = 1;
        String ask = null;
        while (repeat == 1) {
            ask = Read.readString("Enter the nan of the employee you want to delete");
            if (!Checks.employeeNanCheck(ask)) {
                ask = null;
                System.out.println("There is no employee with that nan");
                repeat = Read.readInt("Enter 1 to delete another one. Enter 0 if you don't");
            }
        }
        if (repeat == 1) {
            try {
                FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Employees.ser");
                MiObjectInputStream so = new MiObjectInputStream(fis);
                while (true) { //Reads users from file and saves them in users arraylist
                    Employee emp2 = new Employee(1);

                    emp2 = (Employee) so.readObject();

                    int compare = emp2.getNan().compareTo(ask); //if both string are the same it returns 0

                    if (compare != 0) {

                        emp.add(emp2);
                    }

                }

            } catch (FileNotFoundException ex) {
                System.out.println("Can't find file");
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("You've typed something wrong");
            }

            try {
                FileOutputStream fos = new FileOutputStream("C:\\users\\Petxa\\Employees.ser", true);
                MiObjectOutputStream so = new MiObjectOutputStream(fos);

                for (int i = 0; i < emp.size(); i++) {

                    so.writeObject(emp.get(i));

                }
            } catch (FileNotFoundException ex) {
                System.out.println("Can't find file");

            } catch (IOException ex) {
                System.out.println("You've typed something wrong");

            }
            System.out.println("Succesfully deleted");
        } else {
            System.out.println("No employee deleted");
        }

    }

    public static void removeCustomer() {
        ArrayList<Customer> cust = new ArrayList<>();
        int repeat = 1;
        String ask = null;
        while (repeat == 1) {
            ask = Read.readString("Enter the nan of the customer you want to delete");
            if (!Checks.customerNanCheck(ask)) {
                ask = null;
                System.out.println("There is no customer with that nan");
                repeat = Read.readInt("Enter 1 to delete another one. Enter 0 if you don't");
            }
        }
        if (repeat == 1) {
            try {
                FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Customers.ser");
                MiObjectInputStream so = new MiObjectInputStream(fis);
                while (true) { //Reads users from file and saves them in users arraylist
                    Customer cust2 = new Customer(1);
                    cust2 = (Customer) so.readObject();

                    int compare = cust2.getNan().compareTo(ask); //if both string are the same it returns 0

                    if (compare != 0) {

                        cust.add(cust2);
                    }

                }

            } catch (FileNotFoundException ex) {
                System.out.println("Can't find file");
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("You've typed something wrong");
            }

            try {
                FileOutputStream fos = new FileOutputStream("C:\\users\\Petxa\\Customers.ser", true);
                MiObjectOutputStream so = new MiObjectOutputStream(fos);
                for (int i = 0; i < cust.size(); i++) {

                    so.writeObject(cust.get(i));

                }
            } catch (FileNotFoundException ex) {
                System.out.println("Can't find file");

            } catch (IOException ex) {
                System.out.println("You've typed something wrong");

            }
            System.out.println("Succesfully deleted");

        } else {
            System.out.println("No customer was deleted");
        }

    }

    public static void removeRoom() {
        ArrayList<Room> room = new ArrayList<>();
        int repeat = 1;
        int ask = 0;
        while (repeat == 1) {
            ask = Read.readInt("Enter the room number you want to delete");
            if (!Checks.roomNumberCheck(ask)) {
                ask = 0;
                System.out.println("There is no room with that number");
                repeat = Read.readInt("Enter 1 to delete another one. Enter 0 if you don't");
            }
        }
        if (repeat == 1) {
            try {
                FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Rooms.ser");
                MiObjectInputStream so = new MiObjectInputStream(fis);
                while (true) { //Reads users from file and saves them in users arraylist
                    Room room2 = new Room(1);

                    room2 = (Room) so.readObject();

                    if (room2.getNumber() != ask) {

                        room.add(room2);
                    }

                }

            } catch (FileNotFoundException | ClassNotFoundException ex) {
                System.out.println("Can't find file");
            } catch (IOException ex) {
                System.out.println("You've typed something wrong");
            }

            try {
                FileOutputStream fos = new FileOutputStream("C:\\users\\Petxa\\Rooms.ser", true);
                MiObjectOutputStream so = new MiObjectOutputStream(fos);
                for (int i = 0; i < room.size(); i++) {
                    so.writeObject(room.get(i));
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Can't find file");

            } catch (IOException ex) {
                System.out.println("You've typed something wrong");

            }
            System.out.println("Succesfully deleted");
        } else {
            System.out.println("No room was removed");
        }
    }

    public static void removeReservation() {
        ArrayList<Reservation> res = new ArrayList<>();
        int repeat = 1;
        int ask = 0;
        while (repeat == 1) {
            ask = Read.readInt("Enter the reservation code you want to delete");
            if (!Checks.roomNumberCheck(ask)) {
                ask = 0;
                System.out.println("There is no reservation code with that number");
                repeat = Read.readInt("Enter 1 to delete another one. Enter 0 if you don't");
            }
        }
        if (repeat == 1) {
            try {
                FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Customers.ser");
                MiObjectInputStream so = new MiObjectInputStream(fis);
                while (true) { //Reads users from file and saves them in users arraylist

                    Reservation res2 = new Reservation(1);
                    res2 = (Reservation) so.readObject();

                    if (ask != res2.getRes_cod()) {
                        res.add(res2);
                    }

                }

            } catch (FileNotFoundException ex) {
                System.out.println("Can't find file");
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("You've typed something wrong");
            }

            try {
                FileOutputStream fos = new FileOutputStream("C:\\users\\Petxa\\Reservation.ser", true);
                MiObjectOutputStream so = new MiObjectOutputStream(fos);
                for (int i = 0; i < res.size(); i++) {
                    so.writeObject(res.get(i));
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Can't find file");

            } catch (IOException ex) {
                System.out.println("You've typed something wrong");

            }
            System.out.println("Succesfully deleted");
        }else{
            System.out.println("No reservation was deleted");
        }
    }

}
