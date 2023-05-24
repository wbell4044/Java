import java.util.*;

public class SeatingPlan {
    private static int[] tableSizes = {6, 8};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> groupSizes = new ArrayList<>();
    
        int choice;
      //  boolean seatingPlanCreated = false; // Keep track if seating plan has been created
        do {
            System.out.println("Menu:");
            System.out.println("1. Enter the number of groups including the group size that are attending an event");
            System.out.println("2. Create seating plan");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    groupSizes = enterGroupSizes(scanner);
                    seatingPlanCreated = false; // Reset seating plan flag
                    break;
                case 2:
                    if (!groupSizes.isEmpty()) { // Check if groups have been entered
                        createSeatingPlan(groupSizes);
                        seatingPlanCreated = true; // Set seating plan flag
                    } else {
                        System.out.println("Please enter the groups first.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            if (seatingPlanCreated) {
                System.out.println("Seating plan created. Choose option 2 again to see the plan.");
                seatingPlanCreated = false; // Reset seating plan flag after displaying it
            }
        } while (choice != 3);
    
        scanner.close();
    }
    
    
    private static List<Integer> enterGroupSizes(Scanner scanner) {
        List<Integer> groupSizes = new ArrayList<>();
        
        System.out.print("Enter the number of groups: ");
        int numGroups = scanner.nextInt();
        
        for (int i = 0; i < numGroups; i++) {
            System.out.print("Enter the size of group " + (i + 1) + ": ");
            int groupSize = scanner.nextInt();
            groupSizes.add(groupSize);
        }
        
        return groupSizes;
    }
    
    private static void createSeatingPlan(List<Integer> groupSizes) {
        List<Integer> tableCounts = new ArrayList<>();
    
        int totalPeople = 0;
        for (int groupSize : groupSizes) {
            totalPeople += groupSize;
        }
    
        while (totalPeople > 0) {
            int tableSize = findBestTableSize(totalPeople);
            int tableCount = (totalPeople + tableSize - 1) / tableSize;
    
            int remainingSeats = tableCount * tableSize;
            int filledSeats = 0;
    
            for (int i = groupSizes.size() - 1; i >= 0; i--) {
                int groupSize = groupSizes.get(i);
                if (groupSize <= remainingSeats - filledSeats && groupSize <= tableSize) {
                    filledSeats += groupSize;
                    groupSizes.remove(i);
                }
            }
    
            tableCounts.add(tableCount);
            totalPeople -= filledSeats;
        }
    
        printSeatingPlan(tableCounts);
    }
    
    
    
    private static int findBestTableSize(int totalPeople) {
        for (int tableSize : tableSizes) {
            if (totalPeople <= tableSize) {
                return tableSize;
            }
        }
        return tableSizes[tableSizes.length - 1];
    }
    
    private static void printSeatingPlan(List<Integer> tableCounts) {
        System.out.println("Seating Plan:");
        int tableIndex = 0;
        int groupIndex = 1;
    
        while (tableIndex < tableCounts.size()) {
            int tableCount = tableCounts.get(tableIndex);
            int tableSize = tableSizes[tableIndex];
    
            System.out.println("Table " + (tableIndex + 1) + " (Size: " + tableSize + "):");
            for (int i = 0; i < tableCount; i++) {
                System.out.print("Group " + groupIndex);
                groupIndex++;
                if (i < tableCount - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            tableIndex++;
        }
    }
    
    
}
