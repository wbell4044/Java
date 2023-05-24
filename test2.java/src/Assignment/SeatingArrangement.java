package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeatingArrangement {

    public static List<String> minimizeTables(List<Integer> groups) {
        Collections.sort(groups); // Sort groups in ascending order
        List<String> tables = new ArrayList<>(); // List to store tables
        int vacantSeats = 0; // Total number of vacant seats

        for (int group : groups) {
            boolean seated = false;

            // Check if there is a table with exact vacant seats
            for (int i = 0; i < tables.size(); i++) {
                String table = tables.get(i);
                int tableVacantSeats = Integer.parseInt(table.split(" ")[1]);
                if (tableVacantSeats == group) {
                    tables.set(i, table.split(" ")[0] + " " + (tableVacantSeats - group));
                    seated = true;
                    vacantSeats -= group;
                    break;
                }
            }

            // If no table with exact vacant seats, search for a larger table
            if (!seated) {
                for (int i = 0; i < tables.size(); i++) {
                    String table = tables.get(i);
                    int tableVacantSeats = Integer.parseInt(table.split(" ")[1]);
                    if (tableVacantSeats >= group && group > 6) {
                        tables.set(i, table.split(" ")[0] + " " + (tableVacantSeats - group));
                        seated = true;
                        vacantSeats -= group;
                        break;
                    }
                }
            }

            // If no suitable table, create a new table
            if (!seated) {
                if (group <= 6) {
                    tables.add("Table 6" + " " + (6 - group));
                } else {
                    tables.add("Table 8" + " " + (8 - group));
                }
                seated = true;
                vacantSeats -= group;
            }
        }

        return tables;
    }

    public static void main(String[] args) {
        List<Integer> groups = new ArrayList<>();
        groups.add(5);
        groups.add(3);
        groups.add(6);
        groups.add(2);
        groups.add(4);
        groups.add(6);
        groups.add(5);
        groups.add(2);

        List<String> tablesUsed = minimizeTables(groups);
        for (String table : tablesUsed) {
            System.out.println(table);
        }
    }
}

