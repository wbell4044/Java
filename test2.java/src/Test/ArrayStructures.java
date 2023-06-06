package Test;
public class ArrayStructures {

    private int[] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray() {
        for(int i = 0; i < arraySize; i++) {
            theArray[i] = (int)(Math.random() *10 ) + 10;
        }         
    }    
    public void printArray() {

        System.out.println("----------");
        for(int i = 0; i < arraySize ; i++) {
            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }
    public int getValueAtIndex(int index) {
        if(index < arraySize) return theArray[index];
        return 0;

    }
    public boolean doesArrayContainValue(int searchValue) {
        boolean valueInArray = false;
        for(int i = 0; i < arraySize; i++) {
            if(theArray[i] == searchValue) {
                valueInArray = true;
                return valueInArray;
            }            
        }
        return valueInArray;
    }

    public void deleteIndex(int index) {
        if(index<arraySize) {
            for(int i = index; i < (arraySize -1) ; i++) {
                theArray[i] = theArray[i+1];                
            }
            arraySize--;
        }
    }
    public void insertArray(int value) {
        if(arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }
    public String lineerSearchValue(int value) {
        boolean valueInArray = false;
        String indexesWithValue = "";
        System.out.println(" The Value has been found in the index of : ");
        for(int i = 0 ; i < arraySize ; i++) {
            if(theArray[i] == value) {
                valueInArray = true;
                System.out.println( i + " ");
                indexesWithValue +=i + " ";
            }

        }
        if(!valueInArray) {
            indexesWithValue = "none";
            System.out.println(indexesWithValue);
        }
        System.out.println();
        return indexesWithValue;
    }
    public void bubleSort() {
        for(int i = arraySize -1 ; i > 1 ; i--) {
            for(int j = 0; j < i ; j++) {
                if(theArray[j] > theArray[j+1]) {
                    swapValues(j, j+1);

                   printHorzArray(i , j);
                }
            }
        }
    }
    public void swapValues(int indexOne, int indexTwo) {
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }
    public void binarySearchForValue(int value) {
        int lovIndex = 0;
        int highIndex = arraySize - 1;
        while(lovIndex <= highIndex) {
            int middleIndex = ( lovIndex + highIndex) / 2;
            if(theArray[lovIndex] < value) lovIndex = middleIndex + 1;
            else if(theArray[lovIndex] > value) highIndex = middleIndex - 1;
            else {
                System.out.println(" we found the match for : " + value + " at the index of : " + middleIndex);
                lovIndex = highIndex + 1;
        }
        printHorzArray(middleIndex, -1);
        
        }

    }
    public void printHorzArray(int i, int j){     
                 
        for(int n = 0; n < 51; n++)System.out.print("-");    
            System.out.println();     
                for(int n = 0; n < arraySize; n++){
                    System.out.print("| " + n + "  ");         
                }
               
                System.out.println("|");         
                for(int n = 0; n < 51; n++)System.out.print("-");     
                System.out.println();        
                for(int n = 0; n < arraySize; n++){       
                    System.out.print("| " + theArray[n] + " ");
                }        
                System.out.println("|");       
                for(int n = 0; n < 51; n++)System.out.print("-");
                System.out.println();
                
                if(j != -1){                                 
                for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
                     System.out.print(j);             
                }
                if(i != -1){
                    for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");                
                        System.out.print(i);                
                }                  
                    System.out.println();
                    }
                  
    public static void main(String[] args) {
        ArrayStructures newArray = new ArrayStructures();
        newArray.generateRandomArray();
        //newArray.printArray();
        //System.out.println(newArray.getValueAtIndex(3));
        //System.out.println(newArray.doesArrayContainValue(15));
        //newArray.deleteIndex(4);
        //newArray.printArray();
        //newArray.insertArray(55);
        //newArray.printArray();
        //newArray.lineerSearchValue(11); 
        newArray.bubleSort();
       // newArray.printArray();
       newArray.binarySearchForValue(15);    

    }
    
}
