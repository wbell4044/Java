package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SeatingPlanCreator {
    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Enter the number of groups including the group size that are attending an event");
        System.out.println("2. Create seating plan");
        System.out.println("3. Exit");
    }

    public static void main(String[] args) {
        int totalPeople = 0;
        int totalGroups = 0;
        List<Integer> groupSizes = new ArrayList<>();

        while (true) {
            displayMenu();
            int choice = readInteger();

            if (choice == 1) {
                System.out.println("Enter the total number of groups attending the event:");
                totalGroups = readInteger();

                for (int i = 0; i < totalGroups; i++) {
                    System.out.println("Enter the size of group " + (i + 1) + ":");
                    int groupSize = readInteger();
                    groupSizes.add(groupSize);
                    totalPeople += groupSize;
                }
            } else if (choice == 2) {
                if (totalPeople == 0) {
                    System.out.println("No groups entered. Please enter groups first.");
                } else if (totalPeople > 56) {
                    System.out.println("Total number of people exceeds maximum capacity.");
                } else if (totalPeople < 2) {
                    System.out.println("Insufficient number of people. Please enter more groups.");
                } else {
                    int tableSize6Count = 0;
                    int tableSize8Count = 0;

                    Collections.sort(groupSizes, Collections.reverseOrder());

                    for (int groupSize : groupSizes) {
                        int tableSize = (groupSize <= 6) ? 6 : 8;
                        if (tableSize == 6) {
                            tableSize6Count++;
                        } else {
                            tableSize8Count++;
                        }
                    }

                    System.out.println("Seating Plan:");
                    System.out.println("Table Size 6: " + tableSize6Count + " tables");
                    System.out.println("Table Size 8: " + tableSize8Count + " tables");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}

