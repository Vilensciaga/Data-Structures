/**
* Creates the queue using doubly linked list.
*
* @author <Vilens Senat>
* @version <10/04/19>
*/
package project3;


/**
 *
 * @author vilens557
 */
public class Queue {
    
    /**
     * create a class Link for next and prev
     */
    public class Link{
    Country data;
    Link next;
    Link prev;
  
}

    Link first ;
    Link last; 
    Link current;
    int size;
    
    // constructor
    public Queue(){
        this.first = null;
        this.last = null;
        this.current = null;
        
    }
    
    /**
     * Inserts country object at the front of the queue
     * @params country object
     */
    public void insertFront(Country country){
        Link newLink = new Link();
         newLink.data = country;
         
     if(isEmpty()){        
         first = last = newLink;
     }  
     else{
         first.prev = newLink;
         newLink.next = first;
         first = newLink;
     }
    }
    
    /**
     * Inserts country object at the end of the queue
     * @params country object
     */
    public void insertEnd(Country country){
        Link newLink = new Link();
         newLink.data = country;
         
         
        if(isEmpty()){
          last = first = newLink;
        }
        else{ 
            last.next = newLink;
            newLink.prev = last;
            last = newLink;
            
        }
    }
    
    /**
     * remove country object from front of the queue queue
     * @return the country object that was removed
     */
    public Country removeFront(){
     if(isEmpty()){
         System.out.println("Queue is empty, cannot remove.");
         return null;
     }
     Link temp = first;
      Country c = temp.data;
     if(first.next == null){
       first = last = null;
     }
     else{
        first.next.prev = null;
        first = first.next;
     }
      
      return c;    
    }
    
    /**
     * remove country object from the end of the queue queue
     * @return the country object that was removed
     */
    public Country removeEnd(){
       if(isEmpty()){
         System.out.println("Queue is empty, cannot remove.");
         return null;
     } 
       Link temp = last;
       Country c = temp.data;
     
       if(last.prev == null)
    	   first = last = null;
       
       else {
    	   last.prev.next = null;
    	   last = last.prev;
       }
       
      return c;
    }
   
   
    /**
     * delete a country if it was found
     * @param takes string parameter
     */
  
    public boolean findDelete( String x){
      Link current = first;
      
        while(!current.data.getName().equals(x)) {
            
            if(current.next == null){
                return false;
            }
            else{
            current = current.next;
            }
        }  
        if(current == first){
           first.next.prev = null; 
           first = first.next;
        }
        else if(current == last){
            last.prev.next = null;
            last = last.prev;
        }     
        else {
           
         current.prev.next = current.next;
              current.next.prev = current.prev;
        }
        return true;
        
    }
    
    /**
     * delete all countries with a GDPperCapita in a certain range
     * @param no parameter
     */
    public Link deleteHighGDPperCapita(){  
      System.out.println("");
      System.out.println("");
      System.out.println("Deleting countries with GDP per Capita between 30000 and 40000.");
      System.out.println("");
      
   Link current = first;
 
    while(isEmpty()){
       
          if(current.data.getGDPperCapita() < 30000 || current.data.getGDPperCapita() > 40000){
              current = current.next;
          }
          
          else{
          if(current == first){
              first.next.prev = null;
          first = first.next;
          }
          
          else if(current == last){
              last.prev.next = null;
              last = last.prev;
          }
         
          else{
              current.prev.next = current.next;
              current.next.prev = current.prev;
          }
            
          current = current.next; 
          }
    }
    return current;
    }
 
  /**
     * Prints the whole queue
     */
    
     public void printQueue(){
     System.out.println("Queue Contents:");
       System.out.println("");
       System.out.println("Name                              Code         Capital            Population           GDP                    HappinessRank");
       System.out.println("---------------------------------------------------------------------------------------------------------------------------");
          String format = "%-33s %-12s %-18s %-20s %-22s %-9s";
          
          Link temp = first;
          while(temp != null){
               System.out.printf(format, temp.data.getName(), temp.data.getCode(), temp.data.getCapital(), temp.data.getPopulation(), temp.data.getGDP(), temp.data.getHR() );
               temp = temp.next;
               System.out.println("");
          }
                
          
            System.out.println("");
            System.out.println("");
 }
     
  /**
     * check if it is empty
     * @return returns true if it is, false otherwise
     */
 public boolean isEmpty(){
     return  first == null && last == null;
 }
 
 
 /**
     * checks if its full
     * @return always return false
     */public boolean isFull(){
     return false;
 }
            
    
}
