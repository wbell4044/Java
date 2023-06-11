package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class ver4 {
    static ArrayList<Integer> groupSizes = new ArrayList<>();
    static int tableSize6Count = 0;
    static int tableSize8Count = 0;
    static boolean check = true;
    static int emptySeats = 0;

    public static void main(String[] args) {
        int totalPeople = 0;
        int totalGroups = 0;

        while (true) {
            int choiceMenu = 0;
            try {
                choiceMenu = menuDisplay();
            } catch (Exception e) {
            }

            if (choiceMenu == 1) {
                totalGroups = readgroupNumber();
                int groupSize = 0;
                totalPeople = 0;
                groupSizes.clear();
                tableSize6Count = 0;
                tableSize8Count = 0;
                emptySeats = 0;

                for (int i = 0; i < totalGroups; i++) {
                    do {
                        groupSize = readgroups(i);
                        if (groupSize > 6 || groupSize < 2)
                            groupOverload();
                    } while (groupSize > 6 || groupSize < 2);
                    groupSizes.add(groupSize);
                    totalPeople += groupSize;
                }
            } else if (choiceMenu == 2) {
                if (totalPeople == 0)
                    entergroupagain();
                else if (totalPeople > 56)
                    toomanypeople();
                else if (totalPeople < 2)
                    insufficientPeople();
                else {
                    Collections.sort(groupSizes, Collections.reverseOrder());
                    while (groupSizes.size() > 0) {
                        check = true;
                        fourGroups();
                        threeGroups();
                        twoGroups();
                        oneGroup();
                    }
                    seatimgplan(tableSize6Count, tableSize8Count, emptySeats, totalPeople);
                }
            } else if (choiceMenu == 3) {
                exit();
                break;
            } else {
                invalidentry();
            }
        }
    }

    private static void oneGroup() {
        while (groupSizes.size() > 0 && check) {
            if (groupSizes.get(0) == 2) {
                if (tableSize6Count > 0) {
                    tableSize8Count += 1;
                    tableSize6Count -= 1;
                    groupSizes.remove(0);
                } else {
                    tableSize6Count += 1;
                    emptySeats += 4;
                    groupSizes.remove(0);
                }
            } else if (groupSizes.get(0) == 6) {
                tableSize6Count += 1;
                groupSizes.remove(0);
            } else if (groupSizes.get(0) == 5) {
                tableSize6Count += 1;
                groupSizes.remove(0);
                emptySeats += 1;
            } else if (groupSizes.get(0) == 4) {
                tableSize6Count += 1;
                emptySeats += 2;
                groupSizes.remove(0);
            } else if (groupSizes.get(0) == 3) {
                tableSize6Count += 1;
                emptySeats += 3;
                groupSizes.remove(0);
            } else {
                break;
            }
        }
    }

    private static void twoGroups() {
        int i = 0;
        while (groupSizes.size() > 1 && i < (groupSizes.size() - 1)) {
            if (groupSizes.get(i) + groupSizes.get(groupSizes.size() - 1) == 8) {
                tableSize8Count += 1;
                groupSizes.remove(groupSizes.size() - 1);
                groupSizes.remove(i);
                check = true;
                break;
            }
            i++;
            check = false;
        }
    }

    private static void threeGroups() {
        int i = 0;
        while (groupSizes.size() > 2 && i < (groupSizes.size() - 2)) {
            if (groupSizes.get(i) + groupSizes.get(i + 1) + groupSizes.get(groupSizes.size() - 1) == 8) {
                tableSize8Count += 1;
                groupSizes.remove(groupSizes.size() - 1);
                groupSizes.remove(i + 1);
                groupSizes.remove(i);
                check = true;
                break;
            }
            i++;
            check = false;
        }
    }

    private static void fourGroups() {
        int i = 0;
        while (groupSizes.size() > 3 && i < (groupSizes.size() - 3)) {
            if (groupSizes.get(i) + groupSizes.get(i + 1) + groupSizes.get(i + 2) + groupSizes.get(groupSizes.size() - 1) == 8) {
                tableSize8Count += 1;
                groupSizes.remove(groupSizes.size() - 1);
                groupSizes.remove(i + 2);
                groupSizes.remove(i + 1);
                groupSizes.remove(i);
                check = true;
                break;
            }
            i++;
            check = false;
        }
    }

    private static int menuDisplay() {
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1. Enter Number of Groups\n2. Assign seats\n3. Exit\n", "Menu", JOptionPane.PLAIN_MESSAGE));
        return choice;
    }

    private static int readgroupNumber() {
        int totalGroups = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Total Number of Groups:",
                "Number of Groups", JOptionPane.PLAIN_MESSAGE));
        return totalGroups;
    }

    private static int readgroups(int i) {
        int groupSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Group Size for Group " + (i + 1),
                "Group " + (i + 1), JOptionPane.PLAIN_MESSAGE));
        return groupSize;
    }

    private static void seatimgplan(int tableSize6Count, int tableSize8Count, int emptySeats, int totalPeople) {
        String seatingPlan = "Seating Plan:\n\n" +
                "Tables with 6 seats: " + tableSize6Count + "\n" +
                "Tables with 8 seats: " + tableSize8Count + "\n" +
                "Empty seats: " + emptySeats + "\n" +
                "Total People: " + totalPeople + "\n";
        JOptionPane.showMessageDialog(null, seatingPlan, "Seating Plan", JOptionPane.PLAIN_MESSAGE);
    }

    private static void groupOverload() {
        JOptionPane.showMessageDialog(null, "Group size should be between 2 and 6", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static void entergroupagain() {
        JOptionPane.showMessageDialog(null, "Please enter the number of groups first.", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private static void toomanypeople() {
        JOptionPane.showMessageDialog(null, "Too many people. Maximum capacity is 56.", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private static void insufficientPeople() {
        JOptionPane.showMessageDialog(null, "Not enough people. Minimum required is 2.", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private static void exit() {
        JOptionPane.showMessageDialog(null, "Exiting the program.", "Exit", JOptionPane.PLAIN_MESSAGE);
    }

    private static void invalidentry() {
        JOptionPane.showMessageDialog(null, "Invalid entry. Please select a valid option.", "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

