package Test.Apples1;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui_Back_Color extends JFrame{
    private JList list;
    private static String colornames[] = {"black", "blue", "red", "white", "green", "gray"};
    private static Color[] colors = {Color.BLACK , Color.BLUE , Color.RED, Color.WHITE, Color.GREEN, Color.GRAY};

    public Gui_Back_Color() {
        super(" Title ");
        setLayout(new FlowLayout());
        list = new JList(colornames);
        list.setVisibleRowCount(6);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add( new JScrollPane(list));

        list.addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    getContentPane().setBackground(colors[list.getSelectedIndex()]);
                }
                 

                 
            }


        );

    }

    
}
