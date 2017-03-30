package Hotels;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @file check.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 23-feb-2017
 * @Time 10:49:28
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22
 * in Templates/Classes/Class.java.
 *
 */
public class Menu {

    public static String payingMethodMenu() {
        String payingMethod;
        int menu = 0;
        System.out.println("Choose the paying method");
        do {
            System.out.println("Enter 1 to pay with PayPal");
            menu = Read.readInt("Enter 2 to pay with credit card");
        } while (menu < 1 || menu > 2);
        if (menu == 1) {
            payingMethod = "Paypal";
        } else {
            payingMethod = "Credit card";
        }
        return payingMethod;
    }

    public static String jobTypeMenu() {
        String jobType = null;
        int menu = 0;
        System.out.println("Choose the Job type");
        do {
            System.out.println("1- Director");
            System.out.println("2- Receptionist");
            System.out.println("3- Cleaner");
            menu = Read.readInt("4- Chef");
        } while (menu < 1 || menu > 4);
        switch (menu) {
            case 1:
                jobType = "Director";
                break;
            case 2:
                jobType = "Receptionist";
                break;
            case 3:
                jobType = "Cleaner";
                break;
            case 4:
                jobType = "Chef";
                break;
        }

        return jobType;
    }

    public static String genderMenu() {
        String gender;
        int menu = 0;
        System.out.println("Choose the gender");
        do {
            System.out.println("1- Male");
            menu = Read.readInt("2- Female");
        } while (menu < 1 || menu > 2);
        if (menu == 1) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        return gender;
    }

    public static String roomTypeMenu() {
        String roomType = null;
        int menu = 0;
        System.out.println("Choose the room type");
        do {
            System.out.println("1- Single");
            System.out.println("2- Double");
            System.out.println("3- Familiar");
            menu = Read.readInt("4- Suit");
        } while (menu < 1 || menu > 4);
        switch (menu) {
            case 1:
                roomType = "Single";
                break;
            case 2:
                roomType = "Double";
                break;
            case 3:
                roomType = "Familiar";
                break;
            case 4:
                roomType = "Suit";
                break;
        }
        return roomType;
    }

}
