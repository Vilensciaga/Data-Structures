/**
* Creates the stack using singly list.
*
* @author <Vilens Senat>
* @version <10/04/19>
*/
package project3;


/**
 *
 * @author vilens557
 */
public class Stack {
   
     /**
     * create a class Link for next 
     */
    public class Link{
      Country data;
      Link next;
    }
    
    Link top;
    
    // constructor
   public  Stack(){
    this.top = null;  
}
   
       /**
* insert country object in stack
* @param type country
*/
   public void push(Country country){
       Link newLink = new Link();
       
       
       newLink.data = country;
       newLink.next = top;
       top = newLink;
      
   }
   
     /**
* removes country object from stack
* @return the object removed
*/ 
   public Country pop(){
       if(isEmpty()){
           System.out.println("Stack is empty, can't pop");
           return null;
       }
     Country country = top.data; 
     top = top.next;
     return country;
       
       
   }
 
   /**
* checks if stack is empty
* @return true if empty, false otherwise
*/
   public boolean isEmpty(){
       return top == null;
   }
   
 /**
* checks if stack is full
* @return always return false
*/
   public boolean isFull(){
      return false;
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
        
          Link temp = top;
          
          while(temp != null){
              System.out.printf(format, temp.data.getName(), temp.data.getCode(), temp.data.getCapital(), temp.data.getPopulation(), temp.data.getGDP(), temp.data.getHR());
              temp = temp.next;
              System.out.println("");
          }
           System.out.println("");
            System.out.println("");
   }

}
