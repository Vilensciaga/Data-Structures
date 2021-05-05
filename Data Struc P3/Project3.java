/**
* COP 3990: Project 3 – Stacks and Queues usingSingly and Doubly Linked List
* Takes data from a file then prints in a stack and queues.
*
* @author <Vilens Senat>
* @version <10/25/19>
* public class Project2
 */
package project3;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;
import java.lang.NullPointerException;
import java.io.*;



/**
 *
 * @author vilens557
 */
public class Project3 {
    
      // declaring variables of type string, int, Stack and Priority
    public static String fName;
    public static Stack stack;
    public static Country country;
    public static Queue Queue;

    
    /**
     * @param args main function, calls other functions
     */
    
    public static void main(String[] args) { 
      intro();
           
      stack = new Stack();
      Queue = new Queue();
      
      openF();
      stack.print();
      
      StoQ();
      Queue.printQueue();
      
      Queue.deleteHighGDPperCapita();
      Queue.printQueue();
    
      DeleteGivenCountry();
      Queue.printQueue();
    
     
      QtoS();
      stack.print();
     
    }
    
    
    
      /*
 * Prints the header of the project
 * Prompt user to enter file name
 *@param: takes user input as parameter 
 */
    public static void intro(){
        
        System.out.println("COP3990 Project 3");
        System.out.println("Instructor: Xudong Liu");
        System.out.println("");
        System.out.println("Stacks and Priority Queues");
        System.out.print("Enter the file name: ");
        System.out.println("");
        System.out.println(""); 
        Scanner input = new Scanner(System.in);
       // fName = input.next();
        fName = "Countries3.csv";   
    }
    
    /*
 * Creates a file
 * Creates and populates stack 
 */ 
    public static void openF(){
        
        //Country country;
        
       String Name;
       String Code;
       String Capital;
       long Population;
       long GDP;
       String HR;
       int GDPperCapita;
       
       Scanner stream;
       
       File f = new File(fName);
       
       try{
           stream = new Scanner(f);
           stream.nextLine();
           stream.useDelimiter(",|\\n");
           
           while(stream.hasNext()){
               Name = stream.next();
               Code = stream.next();
               Capital = stream.next();
               Population = new BigDecimal(stream.next()).longValue();
               GDP = new BigDecimal(stream.next()).longValue();
               HR = stream.next();
               GDPperCapita = (int) (GDP / Population);
               
               
               country = new Country(Name, Code, Capital, Population, GDP, HR, GDPperCapita);
             if(country.getGDPperCapita() >= 1000 && country.getGDPperCapita() < 50000) 
              
                  stack.push(country);
             
           }
           stream.close();
           System.out.println(" ");
        
           
       }catch(IOException e){
           e.printStackTrace();
       }
    }
    
    /*
  *takes string name, calls onto function in Queue class to delete that country
  *@param: none taken
  */
  public static void DeleteGivenCountry(){
      Scanner input = new Scanner(System.in);
      String country;
      
       System.out.print("Enter the country you wish to delete: ");
      country = input.nextLine();
     
      if(Queue.findDelete(country)){
          System.out.println(country + " was successfully deleted.");
      }
      else{
          System.out.println(country + " not found.");
      }
      System.out.println("");
      
     
  }

    /*
Takes country object from stack, pops it and insert into queue
@param: none taken
*/
public static void StoQ(){
    while(!stack.isEmpty()){
      Queue.insertFront(stack.pop());
      Queue.insertEnd(stack.pop());
    }
}


  /*
Takes country object from Queue, remove front or last and push into stack
@param: none taken
*/
public static void QtoS(){
    while(!Queue.isEmpty()){
        
        if(!Queue.isEmpty()){
            stack.push(Queue.removeFront());
        }
        if(!Queue.isEmpty()){
            stack.push(Queue.removeEnd()); 
        }
             
    }
}
}
