/**
* Creates the priority queue.
*
* @author <Vilens Senat>
* @version <10/04/19>
*/
package project2;


public class Priority {
    private int Size;
    private Country[] Queue;
    int nElems;
    
   // constructor
    public Priority(int size) {
        Size = size;
        Queue = new Country[Size];
        nElems = 0;
    }
    
    /**
     * Inserts country object in queue
     * @params country object
     */
    public void insert(Country country) {
        int j;
        if(isFull()) {
            System.out.println("Can't insert, queue is full");
        } else if(nElems == 0) {
            Queue[nElems++] = country;
        } else {
            for(j = nElems-1 ; j >= 0; j--) {
                if(country.getGDPperCapita() > (Queue[j].getGDPperCapita())) {
                    Queue[j + 1] = Queue[j];
                } else {
                    break;
                }
            }
            
             Queue[j + 1] = country;
             nElems++;
        }
    }
    
    /**
     * remove country object from queue
     * @return the country object that was removed
     */
    public Country remove() {
        if(isEmpty()) {
            System.out.println("Can't remove, queue is empty");
            return Queue[0];
        } else {
            return Queue[--nElems];
        }
    }
    
    /**
     * check if it is empty
     * @return returns true if it is, false otherwise
     */
    public boolean isEmpty() {
        return (nElems == 0);
    }
    
    /**
     * checks if its full
     * @return return true if full, false otherwise
     */
    public boolean isFull() {
        return (nElems == Size);
    }
    
    /**
     * Prints the whole queue
     */
    public void printQueue() {
        
       System.out.println("Name                              Code         Capital            Population           GDP                    HappinessRank");
       System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        
       String format = "%-33s %-12s %-18s %-20s %-22s %-9s";
        
        
        for(int i = nElems-1; i >= 0; i--) {
            System.out.printf(format, Queue[i].getName(), Queue[i].getCode(), Queue[i].getCapital(), Queue[i].getPopulation(), Queue[i].getGDP(), Queue[i].getHR());
            System.out.println("");
        }
        
        System.out.println("");
    }
}
