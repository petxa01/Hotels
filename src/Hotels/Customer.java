package Hotels;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.io.Serializable;

/**
 * @file Customer.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 20-dic-2016
 * @Time 13:03:59
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22 in Templates/Classes/Class.java.
 * 
 */
public class Customer extends Person implements Serializable {
    private String payingMethod;
    
    //constructor
    public Customer(){
        super();
        setPayingMethod();
        
    }
    public Customer(String s){
        super("s");
        setPayingMethod("PayPal");
                
    }
    public Customer (int a){
        super(1);
    }
    
    //getters
    public String getPayingMethod(){
        return payingMethod;
    }
    
    
    //setters
    public void setPayingMethod(String newPayingMethod){
        payingMethod=newPayingMethod;
    }
    public void setPayingMethod(){
        payingMethod = Menu.payingMethodMenu();
    }

}
