package Assignment;
import java.util.ArrayList;
import java.util.Collections;

    public class nadir {    
    public static void main(String[] args) {
        int totalPeople = 0;                            // Defining the variables.
        int totalGroups = 0;
        ArrayList<Integer> groupSizes = new ArrayList<>();    // Defining the Array List to to place every group size.    
        int tableSize6Count = 0; // Defining the table size 6.
        int tableSize8Count = 0; // Definig the table size 8. 
        int emptySeats = 0 ; 
        while (true) {  
            int choiceMenu = 0;
            try {
            choiceMenu = DisplayMenu.displayMenu();    // Displaying the Main Menu to chose 1. Enter groups, 2. Enter group sizes 3. Exit  and reading the value for below if statement.      
             } catch(Exception e) {}            
            
            if (choiceMenu == 1) {   
                totalGroups = 0;                         
                totalGroups = DisplayMenu.readgroupNumber();   // Entering the number of groups.                 
                int groupSize =0;
                totalPeople = 0;  
                groupSizes.clear(); 
                tableSize6Count = 0 ; // Defining the table size 6.
                tableSize8Count = 0 ; // Definig the table size 8. 
                emptySeats = 0 ;      // Defining the empty seats.          
            
                for (int i = 0; i < totalGroups; i++) {      // For Loop to enter every group size 
                    do {                      
                    groupSize = DisplayMenu.readgroups(i);   // Reading each group number and returning that spesific group number to add them in Array.                                        
                    if(groupSize > 6 || groupSize < 2)      // Chechking if groups are bigger than 6 people of less than 2 people.
                        DisplayMenu.groupOverload();         // if wrong number of groups entered will display error mesage in screen.          
                       }     
                    while (groupSize > 6 || groupSize < 2);    // While Loop runs untill all group sizes entered correctly between 2 to 6 people.          
                    groupSizes.add(groupSize);                 // If group size entered correctly add and store it in Array 
                    totalPeople += groupSize;                  // Increasing total people count with every seccesfull entry by adding them to total people.
                }
            } 
                else if (choiceMenu == 2) {            // if option 2 chosen from menu         
                if (totalPeople == 0)                  // checking if totap people is equal to 0 or not,
                    DisplayMenu.entergroupagain();     // Displaying the error mesage  to enter groups again                            
                    else if (totalPeople > 56)          // Checking if total people more than 56, because its our maximum.
                    DisplayMenu.toomanypeople();       // Displaying error mesage if total people exceeds 56 people.         
                    else if (totalPeople < 2)           // checking if total people less than 2
                    DisplayMenu.insufficientPeople();   // Displaying error mesage if total people less than 2.                                         
                    
                    Collections.sort(groupSizes, Collections.reverseOrder()); // Sorting the Array and reversing it from big to small numbers                    
                    int i =0; 
                    boolean check = true;    
                    
                    while(check) {
                        if(groupSizes.size() <= 3) {
                            check = false;
                        }
                         else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) + groupSizes.get(groupSizes.size()-3) == 8) { 
                            tableSize8Count += 1;                            
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1);
                            groupSizes.remove(groupSizes.size()-1); 
                            groupSizes.remove(groupSizes.size()-1);
                        }
                        else 
                            check = false;                            
                    }
                    check = true ;                    

                while(check) {
                       
                        if ( groupSizes.size() <= 2) 
                            check = false;                              
                    
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2)  == 8) {
                            tableSize8Count += 1;                            
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1);
                            groupSizes.remove(groupSizes.size()-1);                                                                                
                        }
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) == 7) {
                             tableSize8Count += 1; 
                             emptySeats +=1;                                                 
                             groupSizes.remove(i);
                             groupSizes.remove(groupSizes.size()-1); 
                             groupSizes.remove(groupSizes.size()-1);                                                                      
                        }  
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) == 6) {
                            tableSize6Count += 1;                                                
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1); 
                            groupSizes.remove(groupSizes.size()-1);                                                                          
                        }  
                       else 
                            check = false ;

                        check = true ;                            
                 while(check)
                        if ((groupSizes.size() - 1) <= i) 
                            check = false; 
                       
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)  == 8) {
                            tableSize8Count += 1;                                                   
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1);                               
                        }
                            
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) == 7) {
                            tableSize8Count += 1; 
                            emptySeats +=1;                                                
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1);                                                                                        
                        }  
                        else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 6) {                                                  
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1); 
                            tableSize6Count += 1;                                            
                        }     
                        else if (groupSizes.get(i) == 6 ) {
                            tableSize6Count += 1;                        
                            groupSizes.remove(i);                                                     
                        }    
                        else if (groupSizes.get(i) == 5) {                    
                            tableSize6Count += 1;                           
                            groupSizes.remove(i);                   
                            emptySeats +=1;
                        }                   
                        else   
                            i +=1;                                                                      
                    }                      
                         i = 0;
                while (groupSizes.size() > 0) {       
                                                                
                          if (groupSizes.get(i) == 5) {                    
                        tableSize6Count += 1;                  
                        groupSizes.remove(i);                   
                        emptySeats +=1;
                    }  
                          else if (groupSizes.get(i) == 6 ) {
                        tableSize6Count += 1;                   
                        groupSizes.remove(i);                                                     
                    }  
                          else if (groupSizes.get(i) == 4) {
                        tableSize6Count += 1; 
                        emptySeats +=2;                  
                        groupSizes.remove(i);                     
                    }                        
                         else if (groupSizes.get(i) == 3 ) {
                        tableSize6Count += 1; 
                        emptySeats +=3;                
                        groupSizes.remove(i);                                                     
                    }     
                        else if (groupSizes.get(i) == 2 ) {
                                if (tableSize6Count > 0) { 
                                      tableSize8Count +=1;
                                      tableSize6Count -=1;
                                      groupSizes.remove(i);                                 
                                }
                                 else {
                                     tableSize6Count += 1; 
                                     emptySeats +=4;               
                                     groupSizes.remove(i);                                                     
                                      }        
                        }    
                        else {}                                          
                }   
                DisplayMenu.seatimgplan(tableSize6Count,tableSize8Count,emptySeats, totalPeople);
                
            } else if (choiceMenu == 3) {
                DisplayMenu.exit();                
                break;
            }            
            else {
                DisplayMenu.invalidentry();

            }
        }    
    }
}