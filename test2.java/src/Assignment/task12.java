package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task12 {
    public static void main(String[] args) {
        // ...
    }

    public static void createSeatingPlan() {
        // Retrieve the group sizes from the user input or from Task 1
        List<Integer> groupSizes = getGroupSizes();

        int totalPeople = calculateTotalPeople(groupSizes);
        List<Table> tables = generateSeatingPlan(totalPeople, groupSizes);

        displaySeatingPlan(tables);
    }

    public static List<Table> generateSeatingPlan(int totalPeople, List<Integer> groupSizes) {
        Collections.sort(groupSizes); // Sort group sizes in ascending order

        int remainingPeople = totalPeople;
        List<Table> tables = new ArrayList<>();

        while (remainingPeople > 0) {
            int tableSize = (remainingPeople >= 6) ? 6 : 8;

            List<Integer> allocatedGroupSizes = new ArrayList<>();
            int peopleSeated = 0;

            for (int i = groupSizes.size() - 1; i >= 0; i--) {
                int groupSize = groupSizes.get(i);

                if (peopleSeated + groupSize <= tableSize) {
                    allocatedGroupSizes.add(groupSize);
                    groupSizes.remove(i);
                    peopleSeated += groupSize;
                }
            }

            int vacantSeats = tableSize - peopleSeated;
            Table table = new Table(tableSize, allocatedGroupSizes, vacantSeats);
            tables.add(table);

            remainingPeople -= peopleSeated;
        }

        return tables;
    }

    // ...
}
