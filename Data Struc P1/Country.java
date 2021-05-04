/**
* This class constructs the object Country
*Takes care of the sorting and searching
* @author <Vilens Senat>
* @version <09/15/2019>
*/
package project1;

public class Country {
	private	String Name;              // Declaring variables
	private	String Code;
	private	String Capital;
	private	int Population; 
	private	String GDP;
	private	int HappinessRank;
	
      private Country [] country;
      private int elms;
	
	/*Constructor initializing an object of type Country
         *@param Name is the name of the country
         *@param Code is the code of the country
         *@param Capital is the capital of the country
	     *@param Population is the population of the country
         *@param GDP is the GDP of the country
         *@param HappinessRank is the happinessrank of the country 
         */
		
	public Country( String Name, String Code, String Capital, int  Population, String GDP, int HappinessRank){
			this.Name = Name;
			this.Code = Code;
			this.Capital = Capital;
			this.Population = Population;
			this.GDP = GDP;
			this.HappinessRank = HappinessRank;
			}
        
        
       /*
        *Second constructor that initializes the size of the array object country
        *param: max is the size of the created array
        */
        public Country(int max) {
	 elms = 0;
	 country = new Country[max];
	}
	

       /*prints the layout and values when user ask for a specific country
        */	
 @Override
    public String toString() {
	 return 
	      "Name:            " + this.getName() + "\n" +
	      "Code:            " + this.getCode() + "\n" +
	      "Capital:         " + this.getCapital() + "\n" +
	      "Population:      " + this.getPopulation() + "\n" +
	      "GDP:             " + this.getGDP() + "\n" +
	      "Happiness Rank:  " + this.getHR();      
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
		
		
		
		public void setPopulation(int Population) {
			this.Population = Population;
		}
		public int getPopulation() {
			return Population;
		}
		
		
		
		public void setGDP(String GDP) {
			this.GDP = GDP;
		}
		public String getGDP() {
			return GDP;
		}
		
		
		public void setHR(int HappinessRank) {
			this.HappinessRank = HappinessRank;
		}
		public int getHR() {
			return HappinessRank;
		}
		
		/*
		 * Compares the name of 22 selected countries 
		 * * Return 0 if strings are equal
		 * return positive value if the first string is greater
		 * Return a negative value otherwise
		 */
public int compare(Country x) {
 return this.Name.compareTo(x.Name);
}
                
                
/*
 * create arrays of countries
 *@param Name is the name of the country
 *@param Code is the code of the country
 *@param Capital is the capital of the country
 *@param Population is the population of the country
 *@param GDP is the GDP of the country
 *@param HappinessRank is the happinessrank of the country
 */
public void arrVals(String Name, String Code, String Capital, int Population, String GDP, int HappinessRank) {
country[elms] = new Country(Name, Code, Capital, Population, GDP, HappinessRank);
elms++;
}


/*
 * displays and array of countries
 */
public void display() {
	String format = "%-35s %-13s %-17s %-20s %-20s %-3s";
	for(int i = 0; i< elms; i++) {
System.out.printf(format , country[i].getName(), country[i].getCode(), country[i].getCapital(), country[i].getPopulation(),country[i].getGDP(),country[i].getHR());
        System.out.println("");
}
}

/*
* uses bubble sort algorithm to sort by name
*/
public void bubbleSort() {
    int out, in;
    for(out = elms - 1; out > 1; out--)
     for(in = 0; in < out; in++)
        if( country[in].compare(country[in+1]) > 0)
           swap(in, in+1);
  }

/*
uses selection sort algorithm to sort by HappinessRank
*/
public void selectionSort() {
    int out, in, min;
    for(out = 0; out < elms - 1; out++) {
        min = out;                     
        for(in = out + 1; in < elms; in++) 
            if(country[in].getHR() < country[min].getHR() )
                min = in;
        swap(out, min);
    } 
}

/*
uses insertion sort algorithm to sort by GDP
*/
public void insertionSort() {
    int in, out;
    for(out = 1; out < elms; out++) {
        Country temp = country[out];
        in = out;
        
        while(in > 0 && (country[in - 1].getGDP().compareTo(temp.getGDP()) > 0)) {
            country[in] = country[in - 1];
            --in;
        }
         country[in] = temp;
    }
}

/*
prints a given country if input is valid, gives error message otherwise
@param: takes countries as parameter
*/
public void printGivenCountry(String countries) {
    if(this.Index(countries) != elms) {
        System.out.println("");
        System.out.println(country[this.Index(countries)]);
    }  else 
        System.out.println("\nError: Country " + countries + " not found");
}


/*
checks if an array is sorted by name
@return true if it is, false otherwise
*/
public boolean isSorted() {
    for(int i = 0; i < this.size() - 1; i++) {
        if(country[i].compare(country[i + 1]) > 0)
            return false;
    }
    return true;
}


/*
finds index of a given country using binary search if the array is sorted, sequential search otherwise
@param countries hold country name
*/
private int Index(String countries) {
    if(this.isSorted()) {
        
        int lower = 0;
        int upper = elms - 1;
        int curr;
        
        while(true) {
            curr = (lower + upper ) / 2;
            
            if(country[curr].getName().equals(countries)) {
                return curr;
            } 
            else if(lower > upper) {
                        return elms;
            } else {
                
                if(country[curr].getName().compareTo(countries) < 0)
                    lower = curr + 1;
                else
                    upper = curr - 1;
            }
        }
    } else {
        for(int i = 0; i < elms; i++) {
            if (country[i].getName().compareTo(countries) == 0) {
                return i;
            }
        }
        return elms;
    }
}

    /*
returns number of elements in object country
*/
    public int size() {
    return elms;
}

/*
    Swaps to countries
    @param x and y represent the array index of the first and second object
    */
    private void swap(int x, int y) {
    Country temp = country[x];
    country[x] = country[y];
    country[y] = temp;
}
    
}



