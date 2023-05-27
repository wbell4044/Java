package Assignment;

import java.util.*;

public class SeatingPlanProgram {
    private static final int TABLE_SIZE_6 = 6;
    private static final int TABLE_SIZE_8 = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> groupSizes = new ArrayList<>();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    groupSizes = getGroupSizes(scanner);
                    break;
                case 2:
                    if (groupSizes.isEmpty()) {
                        System.out.println("Please enter the number of groups first.");
                    } else {
                        createSeatingPlan(groupSizes);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Enter the number of groups including the group size that are attending an event");
        System.out.println("2. Create seating plan");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static List<Integer> getGroupSizes(Scanner scanner) {
        System.out.print("Enter the number of groups: ");
        int numGroups = scanner.nextInt();

        List<Integer> groupSizes = new ArrayList<>();
        for (int i = 0; i < numGroups; i++) {
            System.out.print("Enter the size of group " + (i + 1) + ": ");
            int groupSize = scanner.nextInt();
            groupSizes.add(groupSize);
        }

        return groupSizes;
    }

    private static void createSeatingPlan(List<Integer> groupSizes) {
        List<Integer> tables = new ArrayList<>();
        int totalVacantSeats = 0;

        for (int groupSize : groupSizes) {
            boolean seated = false;

            // Try to find a table with the same size as the group
            for (int i = 0; i < tables.size(); i++) {
                int tableSize = tables.get(i);
                if (tableSize == groupSize) {
                    tables.remove(i);
                    seated = true;
                    break;
                }
            }

            if (!seated) {
                // Try to find a larger table to accommodate the group
                for (int i = 0; i < tables.size(); i++) {
                    int tableSize = tables.get(i);
                    if (tableSize > groupSize) {
                        tables.set(i, tableSize - groupSize);
                        seated = true;
                        break;
                    }
                }
            }

            if (!seated) {
                // No suitable table found, add a new table
                if (groupSize <= TABLE_SIZE_6) {
                    tables.add(TABLE_SIZE_6 - groupSize);
                } else {
                    tables.add(TABLE_SIZE_8 - groupSize);
                }
            }

            totalVacantSeats += (seated ? 0 : groupSize);
        }

        int totalTables = tables.size();
        System.out.println("Seating plan created:");
        System.out.println("Total tables: " + totalTables);
        System.out.println("Total vacant seats: " + totalVacantSeats);
    }
}

