import java.util.*;

public class App {
    private static int numberOfGroups;
    private static int[] groupSizes;
    private static int[] tableCounts;
    private static List<List<Integer>> seatingPlan;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seating Plan Program");
            System.out.println("1. Enter the number of groups and their sizes");
            System.out.println("2. Create seating plan");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterGroupSizes(scanner);
                    break;
                case 2:
                    createSeatingPlan();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void enterGroupSizes(Scanner scanner) {
        System.out.print("Enter the number of groups: ");
        numberOfGroups = scanner.nextInt();

        groupSizes = new int[numberOfGroups];
        tableCounts = new int[2]; // One table size for 6 people, one for 8 people

        for (int i = 0; i < numberOfGroups; i++) {
            System.out.print("Enter the size of group " + (i + 1) + ": ");
            groupSizes[i] = scanner.nextInt();
            updateTableCounts(groupSizes[i]);
        }
    }

    private static void updateTableCounts(int groupSize) {
        if (groupSize <= 6) {
            tableCounts[0] += 1;
        } else if (groupSize <= 8) {
            tableCounts[1] += 1;
        } else {
            // Handle larger group sizes if needed
        }
    }

    private static void createSeatingPlan() {
        List<Integer> tables = new ArrayList<>();

        for (int i = 0; i < tableCounts[1]; i++) {
            tables.add(8);
        }

        for (int i = 0; i < tableCounts[0]; i++) {
            tables.add(6);
        }

        Collections.sort(tables);

        seatingPlan = new ArrayList<>();
        for (int i = 0; i < numberOfGroups; i++) {
            seatingPlan.add(new ArrayList<>());
        }

        // Assign groups to tables based on availability and group size
        for (Integer tableSize : tables) {
            for (int i = 0; i < numberOfGroups; i++) {
                if (groupSizes[i] <= tableSize && seatingPlan.get(i).isEmpty()) {
                    seatingPlan.get(i).add(tableSize);
                    tableSize -= groupSizes[i];
                }
            }
        }

        int totalPeople = Arrays.stream(groupSizes).sum();
        int totalTables = seatingPlan.stream().mapToInt(List::size).sum();
        int vacantSeats = totalTables * 8 - totalPeople;

        System.out.println("Seating plan:");
        System.out.println("Total people: " + totalPeople);
        System.out.println("Total tables: " + totalTables);
        System.out.println("Vacant seats: " + vacantSeats);

        System.out.println("Table configuration:");
        for (int i = 0; i < numberOfGroups; i++) {
            System.out.println("Group " + (i + 1) + ": " + seatingPlan.get(i));
        

        }  
    }
}     
