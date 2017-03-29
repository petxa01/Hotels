/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @file Reservation.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 20-dic-2016
 * @Time 13:11:25
 * @encoding UTF-8
 * 
 **/
public class Reservation implements Serializable{
    private int res_cod;
    private String customerNan;
    private int roomNumber;
    private LocalDate enterDate;
    private LocalDate leaveDate;
    
    
    //constructor
    public Reservation(){
        setRes_cod();
        setCustomerNan();
        setRoomNumber();
        setEnterDate();
        setLeaveDate();
        
    }
    public Reservation(String s){
        
        setCustomerNan();
        setRoomNumber(101);
        setEnterDate();
        setLeaveDate();
    }
    public Reservation(int i){
        
    }
    
    //getters
    public int getRes_cod(){
        return res_cod;
    }
    public String getCustomerNan(){
        return customerNan;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public LocalDate getEnterDate()
    {
        return enterDate;
    }
    public LocalDate getLeaveDate()
    {
        return leaveDate;
    }
    
    //setters
    public void setCustomerNan()
    {
        Boolean length = null;
        do{
        customerNan = Read.readString("Enter the customers NAN:");
        length = Checks.nanLengthCheck(customerNan);
        }while(length == false);
        
    }
    public void setRes_cod(){
        res_cod=Read.readInt("Enter the reservation code");
    }
    public void setRes_cod(int newRes_Cod){
        res_cod=newRes_Cod;
    }

    public void setCustomerNan(String newCustomerNan)
    {
        customerNan = newCustomerNan;
    }
    public void setRoomNumber()
    {
        roomNumber= Read.readInt("Enter the room number:");
    }

    public void setRoomNumber(int newRoomNumber)
    {
        roomNumber = newRoomNumber;
    }
    public void setEnterDate(){
        LocalDate date;
        do{
            date = Read.readDate("Enter the \"enter date\"");
        }while (Checks.dateCheck(date)==false);
        
        enterDate=date;
    }
    public void setEnterDate(LocalDate newEnterDate){
        enterDate = newEnterDate;
    }
    public void setEnterDate(String enter){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y M d", Locale.ENGLISH);
        
        enter=enter.replace("-", " ");
        
        enterDate=LocalDate.parse(enter, formatter);

    }
    public void setLeaveDate(){
        LocalDate date;
        do{
            date = Read.readDate("Enter the leave date");
        }while (Checks.dateCheck(date)==false);
        
        leaveDate=date;
    }
    public void setLeaveDate(String enter){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y M d", Locale.ENGLISH);
        
        enter=enter.replace("-", " ");
        
        leaveDate=LocalDate.parse(enter, formatter);

    }
    public void setLeaveDate(LocalDate newLeaveDate){
        leaveDate = newLeaveDate;
    }
    public static LocalDate checkEnterDate(LocalDate date){
        
        
       
        return date;
    }

}
