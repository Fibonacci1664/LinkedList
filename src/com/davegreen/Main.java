package com.davegreen;

import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        Customer customer = new Customer("Dave", 150.58);           // Here we create a Customer reference to a new Customer object and define a name and balance.
        Customer anotherCustomer = customer;                                    // Here we the create a new reference but not a new object, we tell the new reference to point at the same place in
        // the memory, which is the same place that the original and ONLY Customer object is stored.
    
    
        anotherCustomer.setBalance(12.18);                                      // Here we then set the balance to 12.18 which in turn changes the balance from 150.58 to reflect our new updated
                                                                                // balance, it does this because we have not created a new object but are merely referencing the old object with
                                                                                // a new reference or pointer, we are saying that the Customer type pointer "customer" is pointing at the new Customer
                                                                                // object but the Customer type pointer "anotherCustomer" is also pointing at the same new Customer object, this is defined
                                                                                // on line 9 with the statement "Customer anotherCustomer = customer".
    
    
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());  // So although here we are calling the original customer pointer and NOT the
                                                                                                            // anotherCustomer pointer to get the name and balance we have to remember that the
                                                                                                            // balance has been updated when we used the anotherCustomer pointer with setBalance
                                                                                                            // on line 13.
    
    
        ArrayList<Integer> intList = new ArrayList<Integer>();
        
        intList.add(1);
        intList.add(3);
        intList.add(4);
        
        for(int i = 0; i < intList.size(); i ++)
        {
            System.out.println(i + ": " + intList.get(i));
        }
        
        intList.add(1, 2);
    
        for(int i = 0; i < intList.size(); i ++)
        {
            System.out.println(i + ": " + intList.get(i));
        }
        
    
    }
}
