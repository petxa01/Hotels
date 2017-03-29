
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @file Read.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 17-ene-2017
 * @Time 13:25:06
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22
 * in Templates/Classes/Class.java.
 *
 */
public class Read {

    public static int readInt(String text) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        boolean valid;
        int a = 0;
        do {
            valid = true;
            try {
                System.out.println(text);
                s = reader.readLine();
                a = Integer.parseInt(s);
            } catch (Exception ex) {
                valid = false;
            }
        } while (valid == false);
        return a;
    }

    public static float readFloat(String text) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        float a = 0;
        try {
            System.out.println(text);
            s = reader.readLine();
            a = Float.parseFloat(s);
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        return a;
    }

    public static String readString(String text) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            System.out.println(text);
            s = reader.readLine();

        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        return s;
    }

    public static double readDouble(String text) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        double a = 0;
        try {
            System.out.println(text);
            s = reader.readLine();
            a = Double.parseDouble(s);

        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        return a;
    }

    public static LocalDate readDate(String text) {
        String s;
        LocalDate date = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.println(text + " (yyyy mm dd)");
                s = reader.readLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y M d", Locale.ENGLISH);
                date = LocalDate.parse(s, formatter);

            } catch (Exception ex) {
                System.out.println("Wrong date format");
                date = null;
            }
        } while (date == null);
        return date;
    }

}
