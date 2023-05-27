import java.util.*;

public class plan {
    private static int[] groupSizes;
    private static int[] tableCounts;
    private static List<List<Integer>> seatingPlan;

    public static void main(String[] args) {
        // Sample group sizes for event booking 1
        groupSizes = new int[]{4, 1, 0, 3, 5, 13};
        // Initialize tableCounts based on the maximum group size (6)
        tableCounts = new int[2]; // One table size for 6 people, one for 8 people
        seatingPlan = calculateSeatingPlan(groupSizes);

        // Print the seating plan
        for (int i = 0; i < seatingPlan.size(); i++) {
            System.out.println("Table " + (i + 1) + ": " + seatingPlan.get(i));
        }

        // Calculate and print the total number of tables and vacant seats
        int totalTables = seatingPlan.size();
        int totalPeople = Arrays.stream(groupSizes).sum();
        int totalSeats = (tableCounts[0] * 6) + (tableCounts[1] * 8);
        int vacantSeats = totalSeats - totalPeople;
        System.out.println("Total tables: " + totalTables);
        System.out.println("Total vacant seats: " + vacantSeats);
    }

    private static List<List<Integer>> calculateSeatingPlan(int[] groupSizes) {
        List<List<Integer>> seatingPlan = new ArrayList<>();
        List<Integer> tables = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];

            if (groupSize <= 6) {
                // Try to find a table with enough vacant seats for the group
                boolean allocated = false;
                for (int j = 0; j < tables.size(); j++) {
                    int vacantSeats = tables.get(j);
                    if (vacantSeats >= groupSize) {
                        seatingPlan.get(j).add(groupSize);
                        tables.set(j, vacantSeats - groupSize);
                        allocated = true;
                        break;
                    }
                }

                if (!allocated) {
                    // Create a new table and allocate the group
                    seatingPlan.add(new ArrayList<>(Collections.singletonList(groupSize)));
                    tables.add(6 - groupSize);
                }
            } else if (groupSize <= 8) {
                // Try to find a table with enough vacant seats for the group
                boolean allocated = false;
                for (int j = 0; j < tables.size(); j++) {
                    int vacantSeats = tables.get(j);
                    if (vacantSeats >= groupSize) {
                        seatingPlan.get(j).add(groupSize);
                        tables.set(j, vacantSeats - groupSize);
                        allocated = true;
                        break;
                    }
                }

                if (!allocated) {
                    // Create a new table and allocate the group
                    seatingPlan.add(new ArrayList<>(Collections.singletonList(groupSize)));
                    tables.add(8 - groupSize);
                }
            }
        }

        return seatingPlan;
    }
}
