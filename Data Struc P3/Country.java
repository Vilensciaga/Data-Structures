/**
* Creates country object.
*
* @author <Vilens Senat>
* @version <10/04/19>
*/
package project3;

/**
 *
 * @author vilens557
 */
public class Country {
        private	String Name;              // Declaring variables
        private	String Code;
	private	String Capital;
	private	long Population; 
	private	long GDP;
	private	String HappinessRank;
        private int GDPperCapita;
      
 
	
	/*Constructor initializing an object of type Country
         *@param Name is the name of the country
         *@param Code is the code of the country
         *@param Capital is the capital of the country
	 *@param Population is the population of the country
         *@param GDP is the GDP of the country
         *@param HappinessRank is the happinessrank of the country
         */
		
	public Country( String Name, String Code, String Capital, long  Population, long GDP, String HappinessRank, int  GDPperCapita){
			this.Name = Name;
			this.Code = Code;
			this.Capital = Capital;
			this.Population = Population;
			this.GDP = GDP;
			this.HappinessRank = HappinessRank;
                        this.GDPperCapita = GDPperCapita;
			}
        
    
		
		
	  
	  /*
	   * Setting and Getting the variables declared (Name, Code, ...)
	   * The Set functions set a value for the variable
	   * The Get functions return it
           *@param: each set function take in specific a parameter aligned with onr get function
           *@return: each get function return a specific value aligned with its set function
           * Ex: setName takes in Name as parameter and getName returns name as well
	   */
	
		public void setName(String Name) {
			this.Name = Name;
		}
		public String getName() {
			return Name;
		}
		
		
		public void setCode(String Code) {
			this.Code = Code;
		}
		public String getCode() {
			return Code;
		}
		
		
		
		public void setCapital(String Capital) {
			this.Capital = Capital;
		}
		public String getCapital() {
			return Capital;
		}
		
		
		
		public void setPopulation(long Population) {
			this.Population = Population;
		}
		public long getPopulation() {
			return Population;
		}
		
		
		
		public void setGDP(long GDP) {
			this.GDP = GDP;
		}
		public long getGDP() {
			return GDP;
		}
		
		
		public void setHR(String HappinessRank) {
			this.HappinessRank = HappinessRank;
		}
		public String getHR() {
			return HappinessRank;
		}
                
                public void setGDPperCapita(int GDPperCapita){
                    this.GDPperCapita = GDPperCapita;
                }
                
                public int getGDPperCapita(){
                    return GDPperCapita =   (int) (GDP/ Population);
                }
}

