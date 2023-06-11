package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class AssignmentVer2 {
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
            choiceMenu = menuDisplay();    // Displaying the Main Menu to chose 1. Enter groups, 2. Enter group sizes 3. Exit  and reading the value for below if statement.      
             } catch(Exception e) {}            
            
            if (choiceMenu == 1) {   
                totalGroups = 0;                         
                totalGroups = readgroupNumber();   // Entering the number of groups.                 
                int groupSize =0;
                totalPeople = 0;  
                groupSizes.clear(); 
                tableSize6Count = 0 ; // Defining the table size 6.
                tableSize8Count = 0 ; // Definig the table size 8. 
                emptySeats = 0 ;      // Defining the empty seats.          
            
                for (int i = 0; i < totalGroups; i++) {      // For Loop to enter every group size 
                    do {                      
                    groupSize = readgroups(i);   // Reading each group number and returning that spesific group number to add them in Array.                                        
                    if(groupSize > 6 || groupSize < 2)      // Chechking if groups are bigger than 6 people of less than 2 people.
                        groupOverload();         // if wrong number of groups entered will display error mesage in screen.          
                       }     
                    while (groupSize > 6 || groupSize < 2);    // While Loop runs untill all group sizes entered correctly between 2 to 6 people.          
                    groupSizes.add(groupSize);                 // If group size entered correctly add and store it in Array 
                    totalPeople += groupSize;                  // Increasing total people count with every seccesfull entry by adding them to total people.
                }
            } 
                else if (choiceMenu == 2) {            // if option 2 chosen from menu         
                if (totalPeople == 0)                  // checking if totap people is equal to 0 or not,
                    entergroupagain();     // Displaying the error mesage  to enter groups again                            
                    else if (totalPeople > 56)          // Checking if total people more than 56, because its our maximum.
                    toomanypeople();       // Displaying error mesage if total people exceeds 56 people.         
                    else if (totalPeople < 2)           // checking if total people less than 2
                    insufficientPeople();   // Displaying error mesage if total people less than 2.                                         
                    
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
                        else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 5) {                                                  
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1); 
                            tableSize6Count += 1;  
                            emptySeats +=1;                                         
                        } 
                        else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 4) {                                                  
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1); 
                            tableSize6Count += 1;
                            emptySeats +=2;                                           
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
               seatimgplan(tableSize6Count,tableSize8Count,emptySeats, totalPeople);
                
            } else if (choiceMenu == 3) {
                exit();                
                break;
            }            
            else {
                invalidentry();

            }
        }    
    }

    static int menuDisplay() {  
        String menuOption = JOptionPane.showInputDialog("1. Enter the number of groups including the group size that are attending an event\n" +
        "2. Create seating plan \n " +
        "3. Exit\n " +
        " Please Enter Your Choice : \n");
        int optionMenu = Integer.parseInt(menuOption);             
        return optionMenu;         
   }
   static int readgroupNumber() {
       int numberOfGroups = 0;  
       while(!(numberOfGroups > 0 && numberOfGroups < 28)) {     
       String reading = JOptionPane.showInputDialog("Enter the total number of groups attending the event : ");
       try {
       numberOfGroups = Integer.parseInt(reading);   
       } catch(Exception e) {
           errorhandling();
       }  
       if(numberOfGroups > 28 || numberOfGroups < 1) {
           JOptionPane.showMessageDialog(null," Minimum Groups can be 1 and Maximum 28. Please enter a value between 1 to 28.... ", " Wrong Entry for number of Groups Error..", JOptionPane.ERROR_MESSAGE);
       }
   }
   return numberOfGroups;
   }    
   static int readgroups(int i) {        
       int groupsize = 0;
       String reading = JOptionPane.showInputDialog("Enter the size of group " + (i + 1) + ": ");
       try {
       groupsize = Integer.parseInt(reading);
       } catch(Exception e) {
           errorhandling();
       }
   return groupsize;
   }
   static void groupOverload() {
       JOptionPane.showMessageDialog(null," Groups can be between 2 to 6 people. Please enter a value between 2 to 6.... ", " Wrong Entry for Group size Error..", JOptionPane.ERROR_MESSAGE);
   }

   static void entergroupagain() {
       JOptionPane.showMessageDialog(null," No groups entered. Please enter groups first. . ", " No Group Selected Error..", JOptionPane.ERROR_MESSAGE);
   }

   static void toomanypeople() {
       JOptionPane.showMessageDialog(null," Total number of people exceeds maximum capacity... \nPlease Enter Total number of Groups and group sizes again... ", " Too many People Selected Error..", JOptionPane.ERROR_MESSAGE);
   }

   static void insufficientPeople() {
       JOptionPane.showMessageDialog(null," insufficient number of people. Please enter more groups... ", " Insufficent People Selected Error..", JOptionPane.ERROR_MESSAGE);
   }

   static void exit() {
       JOptionPane.showMessageDialog(null," Thanks you For Using the Program .....BYE..... ", " ..Exitting the Program..", JOptionPane.PLAIN_MESSAGE);
   }

   static void invalidentry() {
       JOptionPane.showMessageDialog(null," Invalid choice... Please choose a valid option... ", " ..Invalid Entry Error..", JOptionPane.ERROR_MESSAGE);
   }

   static void seatimgplan(int tableSize6Count, int tableSize8Count, int emptySeats, int totalPeople) {       
       JOptionPane.showMessageDialog(null," Table Size 6 : " + tableSize6Count + " Tables..\n" +
       " Table Size 8 : " + tableSize8Count + " Tables \n" + " Total Empty Seats : " + emptySeats + ".\n" +
       " Total People : " + totalPeople + ".\n", " ..Seating Plan Display..", JOptionPane.PLAIN_MESSAGE);        
   }
   static void errorhandling() {
       JOptionPane.showMessageDialog(null,"  !!!!!! ..Please Enter only Integer... !!!!! ", " ..String Entry Error..", JOptionPane.ERROR_MESSAGE);
   }
}






    

