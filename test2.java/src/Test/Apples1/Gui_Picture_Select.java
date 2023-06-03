package Test.Apples1;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui_Picture_Select extends JFrame {
    private JComboBox box;
    private JLabel picture;
private static String[] filename = {"b.png", "x.png"};
private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};

public Gui_Picture_Select() {
    super(" The Title window");
    setLayout(new FlowLayout());

    box = new JComboBox(filename);

    box.addItemListener(
        new ItemListener() {           
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange() == ItemEvent.SELECTED)
                picture.setIcon(pics[box.getSelectedIndex()]);
            }
            
        }
    ); 
        
    add(box);
    picture = new JLabel(pics[0]);
    add(picture);
}
   
    
}
