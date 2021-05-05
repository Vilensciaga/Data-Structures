package project2;
/**
* COP 3990: Project 2 – Stacks and Priority Queues
* Takes data from a file then prints in a stack and priority queues.
*
* @author <Vilens Senat>
* @version <10/04/19>
* public class Project2
 */


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.lang.NullPointerException;
/**
 *
 * @author vilens557
 */
public class Project2 {

    // declaring variables of type string, int, Stack and Priority
    private static String fName;
    private static int Size;
    private static Stack stack;
    private static Priority POOR;
    private static Priority FAIR;
    private static Priority GOOD;
    private static Priority VGOOD;
    private static Priority EXCELLENT;

  
    /**
     * @param args main function, calls other functions
     */
    
    public static void main(String[] args)  {
         intro();
        
        stack = new Stack(Size);
        POOR = new Priority(Size);
        FAIR = new Priority(Size);
        GOOD = new Priority(Size);
        VGOOD = new Priority(Size);
        EXCELLENT = new Priority(Size);
        
        openF();

  System.out.println("Poor Priority Queue Contents: ");
  System.out.println("");
    POOR.printQueue();
    System.out.println("");
    
  System.out.println("Fair Priority Queue Contents: ");
  System.out.println("");
    FAIR.printQueue();
    System.out.println("");
    
  System.out.println("Good Priority Queue Contents: ");  
  System.out.println("");
    GOOD.printQueue();
    System.out.println("");
    
  System.out.println("VGood Priority Queue Contents: ");
  System.out.println("");
    VGOOD.printQueue();
    System.out.println("");
    
  System.out.println("Excellent Priority Queue Contents: ");
  System.out.println("");
    EXCELLENT.printQueue();
    System.out.println("");
    
    QtoS();
  System.out.println("");
    stack.print();
        
   
      
    }
    
    /*
 * Prints the header of the project
 * Prompt user to enter file name
 *@param: takes user input as parameter 
 */
    
    public static void intro(){
        
        System.out.println("COP3990 Project 2");
        System.out.println("Instructor: Xudong Liu");
        System.out.println("");
        System.out.println("Stacks and Priority Queues");
        System.out.print("Enter the file name: ");
        Scanner input = new Scanner(System.in);
        fName = input.next();
      Size = getSize();
      
    }
    
    
   /*
*gets the number of line entries in the given file
*@ return the number of lines in the file
*/
    
   public static int getSize(){
   Scanner input;
   
   
   File f = new File(fName);
 
   
   int size = 0;
   
   try{
       input = new Scanner(f);
       input.nextLine();
       
       while(input.hasNextLine()){
           input.nextLine();
           size++;
         
       }
       input.close();
   }catch (IOException e){
       e.printStackTrace();
   }
   return size;
}
   /*
 * Creates a file
 * Creates and populates stack 
 */ 
   
    public static void openF(){
        Scanner in = new Scanner(System.in);
        
        String Name;
	String Code;
	String Capital;
	long Population;
	long GDP;
	String HappinessRank;
        int GDPperCapita;
      
        
        Country country;
        
        
        Scanner stream;
        
        File file = new File(fName);
        
        if(!file.exists()){
            System.out.println("File does not exist.");
        }
        else

        
        try{
            stream = new Scanner(file);
            stream.nextLine();
            stream.useDelimiter(",|\\n");
            
            while(stream.hasNext()){
                Name = stream.next();
                Code = stream.next();
                Capital = stream.next();
                Population    = Long.parseLong(stream.next());
                GDP           = new BigDecimal(stream.next()).longValue();
                HappinessRank = NumberFormat.getIntegerInstance(Locale.US).format(stream.nextInt());
                GDPperCapita = (int) (GDP/ Population);
                
             
               
                   country = new Country (Name, Code, Capital, Population, GDP, HappinessRank, GDPperCapita);
                  
              
            
 
                   
                   if(country.getGDPperCapita()< 1000)
                       POOR.insert(country);
              
                   
                   else if(country.getGDPperCapita() >= 1000 && country.getGDPperCapita() < 5000)
                       FAIR.insert(country);
                 
                   
                   else if(country.getGDPperCapita() >= 5000 && country.getGDPperCapita() < 20000)
                       GOOD.insert(country);
                  
                   
                   else if(country.getGDPperCapita() >= 20000 && country.getGDPperCapita() < 50000)
                       VGOOD.insert(country);
                   
           
                 else 
                 EXCELLENT.insert(country);
             
                   
          
        
            }  stream.close();
  System.out.println("");
  
            }
              
        catch(IOException e){
            e.printStackTrace();
        }    
        
    }
    
    
   
   
   /*
   remove country from queues from worst gdp per capita to best and push back into the stack
   */
 public static void QtoS(){
       while(!POOR.isEmpty()){
           stack.push(POOR.remove());
       }
       while(!FAIR.isEmpty()){
           stack.push(FAIR.remove());
       }
       while(!GOOD.isEmpty()){
           stack.push(GOOD.remove());
       }
       while(!VGOOD.isEmpty()){
           stack.push(VGOOD.remove());
       }
       while(!EXCELLENT.isEmpty()){
       stack.push(EXCELLENT.remove());
   }
    
   
}
   

}
    
