package Assignment;

import javax.swing.JOptionPane;

public class DisplayMenuOriginal {
 
    public static int displayMenu() {
       
        String choiceString = JOptionPane.showInputDialog(" 1. Enter the number of groups including the group size that are attending an event\n" +
        " 2. Create seating plan \n " +
        " 3. Exit\n " +
        " Please Enter Your Choice : ");
        int choiceMenu = Integer.parseInt(choiceString);             
       return choiceMenu;         
    }
    public static int readInteger() {
        String reading = JOptionPane.showInputDialog("Enter the total number of groups attending the event : ");
        int choiceGroup = Integer.parseInt(reading);         
            return choiceGroup;   
    }
    public static int readgroups(int i) {        
        String reading = JOptionPane.showInputDialog("Enter the size of group " + (i + 1) + ": ");
        int groupsize = Integer.parseInt(reading);
        return groupsize;
    }
    public static void groupOverload() {
        JOptionPane.showMessageDialog(null," Groups can be between 2 to 6 people. Please enter a value between 2 to 6.... ", " Wrong Entry for Group size Error..", JOptionPane.ERROR_MESSAGE);
    }

    public static void entergroupagain() {
        JOptionPane.showMessageDialog(null," No groups entered. Please enter groups first. . ", " No Group Selected Error..", JOptionPane.ERROR_MESSAGE);
    }

    public static void toomanypeople() {
        JOptionPane.showMessageDialog(null," Total number of people exceeds maximum capacity... \nPlease Enter Total number of Groups and group sizes again... ", " Too many People Selected Error..", JOptionPane.ERROR_MESSAGE);
    }

    public static void insufficientPeople() {
        JOptionPane.showMessageDialog(null," insufficient number of people. Please enter more groups... ", " Insufficent People Selected Error..", JOptionPane.ERROR_MESSAGE);
    }

    public static void exit() {
        JOptionPane.showMessageDialog(null," Thanks you For Using the Program .....BYE..... ", " ..Exitting the Program..", JOptionPane.PLAIN_MESSAGE);
    }

    public static void invalidentry() {
        JOptionPane.showMessageDialog(null," Invalid choice... Please choose a valid option... ", " ..Invalid Entry Error..", JOptionPane.ERROR_MESSAGE);
    }

    public static void seatimgplan(int tableSize6Count, int tableSize8Count, int emptySeats) {
        JOptionPane.showMessageDialog(null," Table Size 6 : " + tableSize6Count + " Tables..\n" +
        " Table Size 8 : " + tableSize8Count + " Tables \n" + " Total Empty Seats : " + emptySeats + ".\n", " ..Seating Plan Display..", JOptionPane.PLAIN_MESSAGE);        
    }    
}