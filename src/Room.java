/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 *
 * @author Petxa
 */
public class Room implements Serializable {

    private int number;
    private int floor;
    private String typeOfRoom;

    //constructors
    public Room() {
        setNumber();
        setTypeOfRoom();
        setFloor();

    }

    public Room(int i) {

    }

    //getters
    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    //setters
    public void setNumber(int newNumber) {
        number = newNumber;
    }

    public void setNumber() {
        number = Read.readInt("Enter the room number:");

    }

    public void setFloor(int newFloor) {
        floor = newFloor;
    }

    public void setFloor() {
        floor = Read.readInt("Enter the room floor");
    }

    public void setTypeOfRoom(String newTypeOfRoom) {
        typeOfRoom = newTypeOfRoom;
    }

    public void setTypeOfRoom() {
        typeOfRoom = Menu.roomTypeMenu();
    }

}
