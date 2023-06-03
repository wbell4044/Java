package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SeatingPlanCreator {
    private static int readInteger() {
        Scanner scanner = new Scanner(System.in); {
                        return scanner.nextInt();
        }
    }

    private static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Enter the number of groups including the group size that are attending an event");
        System.out.println("2. Create seating plan");
        System.out.println("3. Exit\n");
        System.out.print("Please Enter Your Choice : ");
    }

    public static void main(String[] args) {
        int totalPeople = 0;
        int totalGroups = 0;
        List<Integer> groupSizes = new ArrayList<>();

        while (true) {
            displayMenu();
            int choice = readInteger();
            
            
            if (choice == 1) {
                System.out.print("\nEnter the total number of groups attending the event: ");
                totalGroups = readInteger();
                int groupSize =0;
                totalPeople = 0;
            
                for (int i = 0; i < totalGroups; i++) {
                    do {
                    System.out.print("Enter the size of group " + (i + 1) + ": ");
                    groupSize = readInteger();
                    if(groupSize > 6 || groupSize < 2) {
                    System.out.println("Groups can be between 2 to 6 people. Please enter a value between 2 to 6.... ");
                    }                               
                       }      
                    while (groupSize > 6 || groupSize < 2);                     
               
                    groupSizes.add(groupSize);
                    totalPeople += groupSize;
                }
            } 
                else if (choice == 2) {
                if (totalPeople == 0) {
                    System.out.println("\n\n\nNo groups entered. Please enter groups first. \n");
                } else if (totalPeople > 56) {
                    System.out.println("\n\n\nTotal number of people exceeds maximum capacity... \n\nPlease Enter Total number of Groups and group sizes again...\n");
                } else if (totalPeople < 2) {
                    System.out.println("\n\n\nInsufficient number of people. Please enter more groups. \n");
                } else {
                    int tableSize6Count = 0;
                    int tableSize8Count = 0;
                    int emptySeats = 0;

                    Collections.sort(groupSizes, Collections.reverseOrder());
                    System.out.println(groupSizes);
                    int i =0; 
                    boolean check = true;                   
                    while(check) {
                       
                        if ( groupSizes.size() <= 2) {
                            check = false;
                          break;  
                        }
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2)  == 8) {
                            tableSize8Count += 1; 
                            System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1) + " and " + groupSizes.get(groupSizes.size()-2));
                            System.out.println("before remove size : " + groupSizes.size() + " and i = : " + i);                          
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1);
                            groupSizes.remove(groupSizes.size()-1); 
                            System.out.println(groupSizes);
                            System.out.println(" after remove size : " + groupSizes.size() + " and i = : " + i);
                            continue;                                                        
                    }
                    else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) == 7) {
                        tableSize8Count += 1; 
                        emptySeats +=1;
                        System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1) + " and " + groupSizes.get(groupSizes.size()-1));                          
                        groupSizes.remove(i);
                        groupSizes.remove(groupSizes.size()-1); 
                        groupSizes.remove(groupSizes.size()-1); 
                        System.out.println(groupSizes);
                        continue;                                                    
                    }  
                    else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) + groupSizes.get(groupSizes.size()-2) == 6) {
                        tableSize6Count += 1;                         
                        System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1) + " and " + groupSizes.get(groupSizes.size()-1));                          
                        groupSizes.remove(i);
                        groupSizes.remove(groupSizes.size()-1); 
                        groupSizes.remove(groupSizes.size()-1); 
                        System.out.println(groupSizes);
                        continue;                                                    
                    }  
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)  == 8) {
                            tableSize8Count += 1; 
                            System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1)); 
                            System.out.println("before remove size : " + groupSizes.size() + " and i = : " + i);                            
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1); 
                            System.out.println(groupSizes);
                            System.out.println(" after remove size : " + groupSizes.size() + " and i = : " + i);
                            continue;  
                        }
                            
                        else if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1) == 7) {
                            tableSize8Count += 1; 
                            emptySeats +=1;
                            System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1));                            
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1); 
                            System.out.println(groupSizes);
                            continue;                                                   
                        }  
                        else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 6) {
                            System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1));                            
                                groupSizes.remove(i);
                                groupSizes.remove(groupSizes.size()-1); 
                                tableSize6Count += 1; 
                                System.out.println(groupSizes); 
                                continue;                    
                            }     
                            else if (groupSizes.get(i) == 6 ) {
                                tableSize6Count += 1; 
                                System.out.println(" removed " + groupSizes.get(i));
                                groupSizes.remove(i);                                                     
                            }    
                            else if (groupSizes.get(i) == 5) {                    
                                tableSize6Count += 1; 
                                System.out.println(" removed " + groupSizes.get(i));
                                groupSizes.remove(i);                   
                                emptySeats +=1;
                            }                   
                            else if (groupSizes.size() == 1 || groupSizes.size() == 0 ) {
                                check = false;
                                break;
                            }
                        
                        else   {
                            i +=1; 
                        }                                             
                    }                      
                    
               i = 0;
                while (groupSizes.size() > 0) {        
                 if (groupSizes.size() >=2 ) {      
                if (groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)  == 8) {
                    tableSize8Count += 1; 
                    System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1)); 
                    groupSizes.remove(i);
                    groupSizes.remove(groupSizes.size()-1);   
                }
                else if ((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 7) {
                    System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1));
                    groupSizes.remove(i);
                    groupSizes.remove(groupSizes.size()-1); 
                    tableSize8Count += 1;
                    emptySeats +=1;                       
                } 
                else if ((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 6) {
                    System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1));
                    groupSizes.remove(i);
                    groupSizes.remove(groupSizes.size()-1); 
                    tableSize6Count += 1;                                        
                } 
                else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 5) {
                    System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1));                            
                        groupSizes.remove(i);
                        groupSizes.remove(groupSizes.size()-1); 
                        tableSize6Count += 1; 
                        emptySeats +=1; 
                        System.out.println(groupSizes); 
                        continue;                    
                    }  
                    else if((groupSizes.get(i) + groupSizes.get(groupSizes.size()-1)) == 4) {
                        System.out.println(" removed " + groupSizes.get(i) + " and " + groupSizes.get(groupSizes.size()-1));                            
                            groupSizes.remove(i);
                            groupSizes.remove(groupSizes.size()-1); 
                            tableSize6Count += 1; 
                            emptySeats +=2; 
                            System.out.println(groupSizes); 
                            continue;                    
                        } 
                        else if (groupSizes.get(i) == 5) {                    
                            tableSize6Count += 1; 
                            System.out.println(" removed " + groupSizes.get(i));
                            groupSizes.remove(i);                   
                            emptySeats +=1;
                        }  
                        else if (groupSizes.get(i) == 6 ) {
                            tableSize6Count += 1; 
                            System.out.println(" removed " + groupSizes.get(i));
                            groupSizes.remove(i);                                                     
                        }  
               else {
               }                
            }
            else {        
                  
                    if (groupSizes.get(i) == 5) {                    
                        tableSize6Count += 1; 
                        System.out.println(" removed " + groupSizes.get(i));
                        groupSizes.remove(i);                   
                        emptySeats +=1;
                    }  
                    else if (groupSizes.get(i) == 6 ) {
                        tableSize6Count += 1; 
                        System.out.println(" removed " + groupSizes.get(i));
                        groupSizes.remove(i);                                                     
                    }  
                    else if (groupSizes.get(i) == 4) {
                        tableSize6Count += 1; 
                        emptySeats +=2;
                        System.out.println(" removed " + groupSizes.get(i));
                        groupSizes.remove(i);                     
                    }                        
                    else if (groupSizes.get(i) == 3 ) {
                        tableSize6Count += 1; 
                        emptySeats +=3;
                        System.out.println(" removed " + groupSizes.get(i));
                        groupSizes.remove(i);                                                     
                    }     
                    else if (groupSizes.get(i) == 2 ) {
                        if (tableSize6Count > 0) { 
                            tableSize8Count +=1;
                            tableSize6Count -=1;
                            groupSizes.remove(i); 
                            break;
                        }
                        else {
                        tableSize6Count += 1; 
                        emptySeats +=4;
                        System.out.println(" removed " + groupSizes.get(i));
                        groupSizes.remove(i);                                                     
                    }        
                }    
                else { }   
                }                     
            }   
                    System.out.println("\nSeating Plan:");
                    System.out.println("Table Size 6: " + tableSize6Count + " tables");
                    System.out.println("Table Size 8: " + tableSize8Count + " tables");
                    System.out.println("Total Tables : " + (tableSize6Count + tableSize8Count));
                    System.out.println("Total Empty Seats : " + emptySeats);
                    System.out.println("Total people : " + totalPeople);
                    System.out.println("Group Sizes : " + groupSizes);                                    
                }
        
            } else if (choice == 3) {
                System.out.println("\nThanks you For Using the Program .....BYE.....\n");
                break;
            } else {
                System.out.println("\nInvalid choice... Please choose a valid option...");
            }
        }
    }
}

