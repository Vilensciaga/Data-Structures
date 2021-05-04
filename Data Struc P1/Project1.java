
/**
* COP 3538: Project 1 – Array Searches and Sorts
* Uses data from a given file
* uses bubble sort, selection sort, insertion sort to sort file based on specific requirements and prints report
* uses binary and sequential search to search for a specific index and print report
* @author <Vilens Senat>
* @version <09/15/2019>
*/
package project1;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Project1 {

		private static int Size;  // declaring my static variables
	private static String fileN;   
        private static Country country;  
	public static Scanner input = new Scanner(System.in);
        
        
	
public static void main(String[] args) throws IOException {
    
    header(input);
    country = new Country(Size);   
    openF();
    console(input);
    input.close();
    
}
/*
 * Prints the header of the project
 * Prompt user to enter file name
 *@param: takes user input as parameter 
 */
public static void header(Scanner Input) {
	 System.out.println("COP3538 Project 1");
     System.out.println("Instructor: Xudong Liu");
     System.out.println("");
     System.out.println("Array Searches and Sorts");
     System.out.print("Enter the file name: ");
   
     fileN = input.nextLine();
 
     Size = getArraySize();
     
     System.out.println("");
}


/*
 * Creates a file,  pass data from file to a country object
 */
public static void openF() {
    
    
	String Name;
	String Code;
	String Capital;
	int Population;
	String GDP;
	int HappinessRank;
        
      
       
	File file = new File(fileN);
	
	try {
		Scanner stream = new Scanner(file);
		stream.nextLine();
		stream.useDelimiter(",|\\n");
		
		while(stream.hasNext()) {
			Name = stream.next();
			Code = stream.next();
			Capital = stream.next();
			Population = Integer.parseInt(stream.next());
			GDP = stream.next();
			HappinessRank = Integer.parseInt(stream.next());
			country.arrVals(Name, Code, Capital, Population, GDP, HappinessRank);
			
		}
		stream.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
	
}

/*
*prints the menu for user
*gives user ability to interact with code using switch statement, like sort, search, print
*/
public static void console(Scanner input) {
	 int choice;
	
	 System.out.println("There were " + country.size() + " country records read.");
	
	 do {
     	 System.out.println("");
         System.out.println("1. Print a countries report");
         System.out.println("2. Sort by Name");
         System.out.println("3. Sort by Hapinness");
         System.out.println("4. Sort by GDP per capita");
         System.out.println("5. Find and print a given country");
         System.out.println("6. Quit");
         System.out.print("Enter your choice: ");
         
         input = new Scanner(System.in);
         
	 
	 while(!input.hasNextInt()) {
             System.out.print("Invalid Choice enter 1-6: ");
             input = new Scanner(System.in);
         }
	 
         
         choice = input.nextInt();
         
         while(choice < 1 || choice > 6) {
             System.out.print("Invalid Choice enter 1-6: ");
             input = new Scanner(System.in);
             
             while(!input.hasNextInt()) {
             System.out.print("Invalid Choice enter 1-6: ");
             input = new Scanner(System.in);
             }
             
             choice = input.nextInt();
         }
         
         switch(choice) {
         case 1: printReport();
              break;
         case 2: country.bubbleSort();
        System.out.print("Countries sorted by Name");
         break;
         case 3: country.selectionSort();
    System.out.print("Countries sorted by Happiness");
         break;
         case 4: country.insertionSort();
     System.out.print("Countries sorted by GDP");
         break;
         case 5: countrySearch();
         }
	
      }while(choice != 6);
     input.close();
     System.out.println("\nHave a good day!");
}

/*
*gets the number of line entries in the given file
*@ return the number of lines in the file
*/
public static int getArraySize() {
    File file = new File(fileN);
    Scanner Input;
    int arrSize = 0;
    
    try {
        Input = new Scanner(file);
        Input.nextLine();
        
        while(Input.hasNextLine()) {
            Input.nextLine();
            arrSize++;
        }
        
        Input.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return arrSize;  
    
}

/*
prints the report and calls on display from from country class to print the file data
*/
 public static void printReport() {
        String format = "%-35s %-13s %-17s %-20s %-20s %-8s";
        System.out.println("");
        System.out.printf(format, "Name", "Code", "Capital", "Population", "GDP", "HappinessRank");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        country.display();
    }

 /*
 *prompts user to enter a country name
 * calls on printGivenCountry() to print output.
 */
public static void countrySearch() {
    System.out.print("\nEnter the Country name: ");
    
    @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
    String x = input.next();
    
    if(country.isSorted()) {
        System.out.println("Binary search");
    } else 
        System.out.println("Sequencial search");
    
   country. printGivenCountry(x);
    
} 

}





