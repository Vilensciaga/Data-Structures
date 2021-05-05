/**
* Creates the stack.
*
* @author <Vilens Senat>
* @version <10/04/19>
*/
package project2;

/**
 *
 * @author vilens557
 */
public class Stack {
    
   private int size ;
   private Country Stack[];
   private int top;
    
   //constructor
   public Stack(int s){
       top = -1;
       size = s;
       Stack = new Country [size];
   }
   
   
     /**
* checks if stack is empty
* @return true if empty, false otherwise
*/
   public boolean isEmpty(){
       return (top == -1); 
   }
   
   
        /**
* checks if stack is full
* @return true if empty, false otherwise
*/
   public boolean isFull(){
    return (top == size -1);
   }
   
     /**
* insert country object in stack
* @param type country
*/
   public void push(Country country){
       if(isFull()){
           System.out.println("Can't push, stack is full");   
       }
       else {
            Stack[++top] = country;
       }
   }
   
    /**
* removes country object from stack
* @return the object removed
*/ 
   public Country pop(){
       if(isEmpty()){
           System.out.println("Cant pop, Stack is empty");
           return Stack[0];
       }
       else{
           return Stack[top--]; 
       }
   }
   
     /**
* print the stack
*/
   public void print(){
       
       System.out.println("Stack Contents:");
       System.out.println("");
       System.out.println("Name                              Code         Capital            Population           GDP                    HappinessRank");
       System.out.println("---------------------------------------------------------------------------------------------------------------------------");
          String format = "%-33s %-12s %-18s %-20s %-22s %-9s";
         for(int i = top; i >= 0; i--){ 
          System.out.printf(format, Stack[i].getName(), Stack[i].getCode(), Stack[i].getCapital(), Stack[i].getPopulation(), Stack[i].getGDP(),Stack[i].getHR(), Stack[i].getGDPperCapita());
          System.out.println("");
   }
   }
 
   
   
}

