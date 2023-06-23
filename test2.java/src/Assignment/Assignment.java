package Assignment;
import java.util.ArrayList;
import java.util.Collections;          // import the necessary java libraries
import javax.swing.JOptionPane;
public class Assignment {
    static ArrayList<Integer> groupSizes = new ArrayList<>();  // Defining the Array List to place every group size.
    static int tableSize6Count = 0; // Defining the table size 6.
    static int tableSize8Count = 0; // Definig the table size 8. 
    static boolean check = true;    // Setting boolean check to true will use it to exit while loops.
    static int emptySeats = 0;      // Defining the empty seats. 
    public static void main(String[] args) {                 
        int totalPeople = 0;                            // Defining the variables.
        int totalGroups = 0; 
        int menuSelection = 0;        
        while(true) {                   // Starting an infinite loop until we set the boolean false. 
            
                try {                  // catching all the errors and continue the program without crashing
                    menuSelection = menuDisplay();    // Displaying the Main Menu to chose 1. Enter groups, 2. Enter group sizes 3. Exit  and reading the value for below if statement.      
                } catch(Exception e) {}               
            
            if (menuSelection == 1) {   // First option for menuselection
                totalGroups = 0;           // reseting total groups              
                totalGroups = readGroupNumber();   // Entering the number of groups.                 
                int groupSize =0;                    // reseting groupsize to enter new groups again
                totalPeople = 0;                     // reseting total people just incase if the user enter some values before and enter again  
                groupSizes.clear(); 
                tableSize6Count = 0 ; // Defining the table size 6.
                tableSize8Count = 0 ; // Definig the table size 8. 
                emptySeats = 0 ;         // resetting the emptyseats                 
            
                for (int i = 0; i < totalGroups; i++) {      // For Loop to enter every group size 
                    do {                      
                    groupSize = readGroups(i);   // Reading each group number and returning that spesific group number to add them in Array.                                        
                    if(groupSize > 6 || groupSize < 2)      // Chechking if groups are bigger than 6 people of less than 2 people.
                        groupOverLoad();         // if wrong number of groups entered will display error mesage in screen.          
                       }     
                    while (groupSize > 6 || groupSize < 2);    // While Loop runs untill all group sizes entered correctly between 2 to 6 people.          
                    groupSizes.add(groupSize);                 // If group size entered correctly add and store it in Array 
                    totalPeople += groupSize;                  // Increasing total people count with every seccesfull entry by adding them to total people.
                }
            } 
                else if (menuSelection == 2) {            // if option 2 chosen from menu         
                    if (totalPeople == 0)                  // checking if totap people is equal to 0 or not,
                        enterGroupAgain();     // Displaying the error mesage  to enter groups again                            
                    else if (totalPeople > 56)          // Checking if total people more than 56, because its our maximum.
                        tooManyPeople();       // Displaying error mesage if total people exceeds 56 people.                                                              
                   else {}
                    Collections.sort(groupSizes, Collections.reverseOrder()); // Sorting the Array and reversing it from big to small numbers                                        
                    
                while(groupSizes.size() > 0) {  // starting a loop while Array size bigger than 0, we will remove the processed data from the Array until it's empty                          
                     fourGroups();            // running fourgrops method     to check the extreeme condition like if all groupsizes are 2 people                      
                     threeGroups();           // running threegroups method   to check if we can seat 3 groups in a table or not.  
                     twoGroups();             // running twogroups  method    to sit any two groups in the same table   
                     oneGroup();              // running onegroup  method     to see if any groups left without seating in a table and sitting then in a table
        }    
            seatimgPlan(tableSize6Count,tableSize8Count,emptySeats, totalPeople);     // displaying the number of table 6 and 8, empty seats and total people        
            } 
            else if (menuSelection == 3) {     //  menuselection option 3 is exiting the program
                exit();                        // running the  method   to display exit mesage on the screen and end the program
                break;                         // exiting the infinite while loop
            }     
            else if (menuSelection == 4) {     //  menuselection option 3 is exiting the program
                displaydata(totalPeople, totalGroups);
            }       
            else {                  // if anything else entered by user will display errror mesage and continue while loop
                invalidEntry();     // runnig the invalidentry method to display error mesage
            }
        }    
    }
    private static void oneGroup() {      // onegroup method runs after methods to find a table any groups could not find place 
        while (groupSizes.size() > 0 ) {
                                                                          
            if (groupSizes.get(0) == 6) {                 // seating 6 people in a table   
                    tableSize6Count += 1;                       // increase number of table for 6 people size
                    groupSizes.remove(0);                  // after seating the group removing it from from the array          
                }  
                else if (groupSizes.get(0) == 5 ) {     // seating 5 people in a table 
                    tableSize6Count += 1;                     // increase number of table for 6 people size
                    groupSizes.remove(0);               // after seating the group removing it from from the array 
                    emptySeats +=1;                           // increasing the empty seat by 1 because we sit 5 people in a table for 6.                      
                }  
                else if (groupSizes.get(0) == 4) {   // seating 4 people in a table 
                    tableSize6Count += 1;                  // increase number of table for 6 people size
                    emptySeats +=2;                        // increasing the empty seat by 2 because we sit 4 people in a table for 6. 
                    groupSizes.remove(0);             // after seating the group removing it from from the array        
                }                        
                else if (groupSizes.get(0) == 3 ) {   // seating 3 people in a table 
                    tableSize6Count += 1;                   // increase number of table for 6 people size
                    emptySeats +=3;                         // increasing the empty seat by 3 because we sit 3 people in a table for 6. 
                    groupSizes.remove(0);             // after seating the group removing it from from the array                                        
                }   
                else if (groupSizes.get(0) == 2 ) {    // seating 2 people in a table         
                    if (tableSize6Count > 0) {               // chechking if there is any tabel for 6 people, if there is we sit this grop of 2 people with 6 people in a bigger table for 8
                        tableSize8Count +=1;                 // we create another table for 8 people because we sit 6 people from table 6 and new group of 2 people together
                        tableSize6Count -=1;                 // removing the table for six after sitting them in table for 8 with group of 2
                        groupSizes.remove(0);           // after seating the group removing it from from the array                      
                    }
                    else {
                        tableSize6Count += 1;                // increase number of table for 6 people size
                        emptySeats +=4;                       // increasing the empty seat by 4 because we sit 2 people in a table for 6. 
                        groupSizes.remove(0);           // after seating the group removing it from from the array                                          
                    } 
                }                              
                else { } 
        } 
    }
    private static void twoGroups() {          // sitting any two groups together considering minimum empty seats.
        int i = 0 ;
        while(groupSizes.size() > 1 && i < (groupSizes.size() - 1)) {         // we need minimum 2 groups of people to run this option, it will run while we still have more than 2 groups not seated and i will increase but we dont want it to be equal or bigger than remaining arraysize  
            if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)  == 8) {     // we have the groups sorted from bigget numbers to smaller numbers thats why checking if bigget group and smaller group total makes 8 people or not 
                tableSize8Count += 1;                                              //    increase number of table for 8 people size                                  
                groupSizes.remove(i);                                               // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                              // after seating the group removing it from from the array   
            }
                        
            else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) == 7) {
                tableSize8Count += 1;                                                   //    increase number of table for 8 people size  
                emptySeats +=1;                                                          // increasing the empty seat by 1 because we sit 7 people in a table for 8. 
                groupSizes.remove(i);                                                      // after seating the group removing it from from the array  
                groupSizes.remove(groupSizes.size()-1);                                   // after seating the group removing it from from the array                                                       
            }  
            else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 6) {                                                  
                groupSizes.remove(i);                                                         // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                      // after seating the group removing it from from the array  
                tableSize6Count += 1;                                                       //    increase number of table for 6 people size                               
            } 
            else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 5) {                                                  
                groupSizes.remove(i);                                                          // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                       // after seating the group removing it from from the array 
                tableSize6Count += 1;                                                         //  increase number of table for 6 people size  
                emptySeats +=1;                                                               // increasing the empty seat by 1 because we sit 5 people in a table for 6. 
            } 
            else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 4) {                                                  
                groupSizes.remove(i);                                                         // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                       // after seating the group removing it from from the array 
                tableSize6Count += 1;                                                        //    increase number of table for 6 people size  
                emptySeats +=2;                                                              // increasing the empty seat by 2 because we sit 4 people in a table for 6. 
            } 
            else if (groupSizes.get(i) == 6) {                                               // if we cannot sit 6 people with any other groups above than we sit them in a table for 6 and remove them from array            
                tableSize6Count += 1;                                                        //    increase number of table for 6 people size              
                groupSizes.remove(i);                                                        // remove the group from the array                   
        }  
            else {
                i += 1 ;         // increase the i to check the other groups can be seated or not                  
            }
        }        
    }    
    private static void threeGroups()  {               // checking if we can seat any 3 groups together
        int i =0;
        while(groupSizes.size() > 2 && i <= (groupSizes.size()-3)) {        // should be at least 3 groups or more and if we can not find any groups suitable we need to break out from the loop by setting check to false.
            if (groupSizes.get(0) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2)  == 8) {   // chechking if we can sit 3 groups together in a table for 8
                tableSize8Count += 1;                                                                                           // increase number of table for 8 people size          
                groupSizes.remove(0);                                                                                     // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                                                          // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                                                          // after seating the group removing it from from the array                                                                         
            }
            else if (groupSizes.get(0) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) == 7) {   // chechking if we can sit 3 groups together in a table for 8
                tableSize8Count += 1;                                                                                              // increase number of table for 8 people size 
                emptySeats +=1;                                                                                                     // increasing the empty seat by 1 because we sit 7 people in a table for 8.
                groupSizes.remove(0);                                                                                        // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                                                            // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                                                            // after seating the group removing it from from the array                                                                 
            }   
            else if (groupSizes.get(0) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) == 6) {    // chechking if we can sit 3 groups together in a table for 8
                tableSize6Count += 1;                                                                                               // increase number of table for 6 people size                                                          
                groupSizes.remove(0);                                                                                         // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);                                                                             // after seating the group removing it from from the array    ( removing the last array element)
                groupSizes.remove(groupSizes.size()-1);                                                                             // after seating the group removing it from from the array    ( after removing the last element above line this one become last and remove this again)                                                             
            }  
            else 
               i++;    // incrementing i to check the next item             
        }       
    }
    private static void fourGroups() {     // checking extreeme condition only if everygroup is 2 people and numbe of groups 4 or more
       int i = 0;
        while(groupSizes.size() > 3 && i < (groupSizes.size()-4)) {    // checking if the array size. must be 4 or more and check should be true
            if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) + groupSizes.get(groupSizes.size()-3) == 8) {   // checking if 4 groups can seat in a table or not
                tableSize8Count += 1;           // increase table for 8 by 1                 
                groupSizes.remove(i);               // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);   // after seating the group removing it from from the array 
                groupSizes.remove(groupSizes.size()-1);    // after seating the group removing it from from the array   ( keep removing last element because when the program goes to next line it needs to remove the last again)
                groupSizes.remove(groupSizes.size()-1);   // after seating the group removing it from from the array 
            }
            else 
                i++;   // incrementing i to check the next item            
        }       
    }
    static int menuDisplay() {           //  Display menu medhod to display the mein menu will return integer value
        String menuOption = JOptionPane.showInputDialog("1. Enter the number of groups and group sizes that are attending an event\n" +  // will display menu in the screen and require to enter menuselection option
        "2. Create seating plan \n " +
        "3. Exit\n " +
        " Please Enter Your Choice : \n");                  //  reading the value as string
        int optionMenu = Integer.parseInt(menuOption);     // converting the entered string into integer        
        return optionMenu;                                 // returning the selection to main program 
   }
   static int readGroupNumber() {                        // entering the groups number between 1 to 28. 
       int numberOfGroups = 0;  
       while(!(numberOfGroups > 0 && numberOfGroups < 28)) {    // loop until user enter a value between 1 and 28
       String reading = JOptionPane.showInputDialog("Enter the total number of groups attending the event : ");   // reading the user input as string
       try {                                              // catching the any wrong input type 
       numberOfGroups = Integer.parseInt(reading);        // converting the entered string into integer
       } catch(Exception e) {                            // catching if the user enter any invalid entry other than numbers 
           errorHandling();                              // running the errorhandling method to display errror mesage and returning to enter groups number again
       }  
       if(numberOfGroups > 28 || numberOfGroups < 1) {    // displaying different error mesage if user enter a number which is out of the range
           JOptionPane.showMessageDialog(null," Minimum Groups can be 1 and Maximum 28. Please enter a value between 1 to 28.... ", " Wrong Entry for number of Groups Error..", JOptionPane.ERROR_MESSAGE);
       }
   }
   return numberOfGroups;                          // return number of groups as integer
   }    
   static int readGroups(int i) {                  // readgroup medhod will read every entry and store them in an array
       int groupSize = 0;
       String reading = JOptionPane.showInputDialog("Enter the size of group " + (i + 1) + ": ");    // entering the group sizes as string value
       try {
       groupSize = Integer.parseInt(reading);       // converting the entered string into integer     
       } catch(Exception e) {                         // catching if the user enter any invalid entry other than numbers 
           errorHandling();                           // Diplaying the error mesage to enter numbers only
       }
   return groupSize;                                   // returning the groupsize reading as integer 
   }
   static void groupOverLoad() {                   //  Error handling mesage will display when and where needed.
       JOptionPane.showMessageDialog(null," Groups can be between 2 to 6 people. Please enter a value between 2 to 6.... ", " Wrong Entry for Group size Error..", JOptionPane.ERROR_MESSAGE);
   }
   static void enterGroupAgain() {                 //  Error handling mesage will display when and where needed.
       JOptionPane.showMessageDialog(null," No groups entered. Please enter groups first. . ", " No Group Selected Error..", JOptionPane.ERROR_MESSAGE);
   }
   static void tooManyPeople() {                    //  Error handling mesage will display when and where needed.
       JOptionPane.showMessageDialog(null," Total number of people exceeds maximum capacity... \nPlease Enter Total number of Groups and group sizes again... ", " Too many People Selected Error..", JOptionPane.ERROR_MESSAGE);
   }
  
   static void exit() {                               //  Error handling mesage will display when and where needed.
       JOptionPane.showMessageDialog(null," Thanks you For Using the Program .....BYE..... ", " ..Exitting the Program..", JOptionPane.PLAIN_MESSAGE);
   }
   static void invalidEntry() {                         //  Error handling mesage will display when and where needed.
       JOptionPane.showMessageDialog(null," Invalid choice... Please choose a valid option... ", " ..Invalid Entry Error..", JOptionPane.ERROR_MESSAGE);
   }
   static void seatimgPlan(int tableSize6Count, int tableSize8Count, int emptySeats, int totalPeople) {                     // Displsying the seating plan for tables  for 6 and 8 people , empty seats and total people.
       JOptionPane.showMessageDialog(null," Table Size 6 : " + tableSize6Count + " Tables..\n" +            
       " Table Size 8 : " + tableSize8Count + " Tables \n" + " Total Empty Seats : " + emptySeats + ".\n" +
       " Total People : " + totalPeople + ".\n", " ..Seating Plan Display..", JOptionPane.PLAIN_MESSAGE);        
   }
   static void errorHandling() {                   //  Error handling mesage will display when and where needed.
       JOptionPane.showMessageDialog(null,"  !!!!!! ..Please Enter only Integer... !!!!! ", " ..String Entry Error..", JOptionPane.ERROR_MESSAGE);
   }
   public static void displaydata(int totalPeople, int totalGroups) {
    JOptionPane.showMessageDialog(null," Total People : " + totalPeople + "\n Number Of Groups :  " + totalGroups + "\n Groupsizes : " + groupSizes ," ..Display Data..", JOptionPane.PLAIN_MESSAGE); 
   }
}
