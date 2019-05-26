package com.davegreen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo
{
    public static void main(String[] args)
    {
        LinkedList<String> placeToVisit = new LinkedList<String>();                             // Linked lists are very similar to array lists but they have the added benefit of being able
                                                                                                // to insert and remove items without the need for the rest of the list to move up or down
                                                                                                // in their respective index positions in order to accommodate for the adding or removing of
                                                                                                // said items.
        addInOrder(placeToVisit, "Sydney");
        addInOrder(placeToVisit, "Melbourne");
        addInOrder(placeToVisit, "Brisbane");                                            // Here we can see all of the places that will be added to the placeToVisit linked list, but
        addInOrder(placeToVisit, "Perth");                                               // they will of course be outputted in alphabetical order by way of the addInOrder method
        addInOrder(placeToVisit, "Canberra");
        addInOrder(placeToVisit, "Adelaide");
        addInOrder(placeToVisit, "Darwin");
        
        printList(placeToVisit);
        
        addInOrder(placeToVisit, "Alice Springs");                                       // Here we see that Alice Springs rightly so gets added near the start of the linked list
        addInOrder(placeToVisit, "Darwin");                                              // And here we see that as darwin has already been added it is found to return zero during the
                                                                                                // comparison checks made in the addInOrder method and so prints out the message accordingly.
        printList(placeToVisit);
        
        visit(placeToVisit);
        
        
        
        
        
    }
    
    private static void printList(LinkedList<String> linkedList)                                // Here we create a linked list and then use an iterator which is a function of linked lists, we
    {                                                                                           // point the iterator at the linked list giving it the variable name "i".
        Iterator<String> i = linkedList.iterator();
        
        while(i.hasNext())                                                                      // Here we use a function of the iterator .hasNext(), this is a loop with the condition stating
        {                                                                                       // that as long as the linked list has a next record, then continue to iterate through the linked
            System.out.println("Now visiting " + i.next());                                     // list, each time printing out the value and moving to the next value in the linked list by using the
        }                                                                                       // .next() function, just to make sure you understand the .next function gets the current value and also
                                                                                                // iterates to the next value.
        System.out.println("######################################");
        
    }
    
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity)            // Here we create a method to sort a linked list of places in alphabetical order.
    {
        ListIterator<String> stringListIterator = linkedList.listIterator();                    // Again here we use a special function of linked list called ListIterator and we point it at
                                                                                                // our linked list which is declared as a parameter in our methods parenthesis, and of which
        while(stringListIterator.hasNext())                                                     // we give it the name of stringListIterator.
        {
            int comparison = stringListIterator.next().compareTo(newCity);                      // We then create a while loop again stating that as long as stringListIterator has a next value
                                                                                                // then continue in the loop.
            if(comparison == 0)                                                                 // We then declare a new variable using a new type of function called compareTo, and we call this
            {                                                                                   // variable comparison, this takes the value of stringListIterator.next, which is ultimately any given
                // They are equal, do not add.                                                  // value of an index position that the iterator is currently on and then compares it to the
                                                                                                // newCity value that was passed as the parameter in the method.
                System.out.println(newCity + " is already included as a destination");
                return false;                                                                   // This comparison will ultimately return a number.
            }
            else if(comparison > 0)                                                             // We then progress into a series of if else/if statements checking against the value that was returned
            {                                                                                   // If value if the same as zero the while comparing the current listIterator index value to the
                // new City should appear before this one.                                      // newCity that was passed, they were found to be the same and so prints out the message accordingly.
                // Brisbane -> Adelaide.
                                                                                                // If the value returned from the comparison was greater than zero, then the newCity value was found
                stringListIterator.previous();                                                  // to be alphabetically closer to A than the listIterators current index value, the problem now though
                stringListIterator.add(newCity);                                                // is that when using the .next() function earlier while declaring the comparison variable this has already
                return true;                                                                    // moved the ListIterator to the next index position in our linked list, so how then are we to add the
            }                                                                                   // newCity value where it should be, we use the .previous() function, this is a special function
            else if(comparison < 0)                                                             // afforded only to ListIterators, this allows us to move back to our previous index position and at which
            {                                                                                   // we then add our newCity value to the linked list.
                // Move on to next city.
            }                                                                                   // If the comparison return a number less than zero then alphabetically they are fine and the list
        }                                                                                       // iterator would move to the next city.
    
        stringListIterator.add(newCity);                                                        // If we get all the way through all the iterations of the while loop, then this means either we have
                                                                                                // either sorted the linked list into alphabetical order and all that remains is the last entry, or
                                                                                                // there was no sorting to be done and again all that remains is the last entry.
        return true;
    }
    
    private static void visit(LinkedList cities)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        
        if(cities.isEmpty())
        {
            System.out.println("No cities in the itinerary");
        }
        else
        {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        
        while(!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();
            
            switch(action)
            {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward)
                    {
                        if (listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        
                        goingForward = true;
                    }
                    
                    if (listIterator.hasNext())
                    {
                        System.out.println("Now visiting " + listIterator.next());
                    }
                    else
                    {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        
                        goingForward = false;
                    }
                    
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("now visiting " + listIterator.previous());
                    }
                    else
                    {
                        System.out.println("We are at the start of the list.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    
    private static void printMenu()
    {
        System.out.println("Available actions:\n press ");
        System.out.println("0 - to quit" +
                "\n1 - go to next city" +
                "\n2 - go to previous city" +
                "\n3 - print list of options");
    }
}
