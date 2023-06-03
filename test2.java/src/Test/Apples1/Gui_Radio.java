package Test.Apples1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Gui_Radio extends JFrame {
    private JTextField tf;
    private Font pf;
    private Font bf;
    private Font itf;
    private Font bif;
    private JRadioButton pb;
    private JRadioButton bb;
    private JRadioButton ib;
    private JRadioButton bib;
    private ButtonGroup group;

    public Gui_Radio() {
        super(" This is the Title");
        setLayout(new FlowLayout());
        tf = new JTextField("Nadir is sexy and hot...", 25);
        add(tf);

        pb = new JRadioButton("Plain", true);
        bb = new JRadioButton("Bold", false);
        ib = new JRadioButton("Italic", false);
        bib = new JRadioButton("Bold - italic ", false);
        add(pb);
        add(bb);
        add(ib);
        add(bib);
        group = new ButtonGroup();
        group.add(pb);
        group.add(bb);
        group.add(ib);
        group.add(bib);

        pf = new Font("Shefif", Font.PLAIN, 14);
        bf = new Font("Shefif", Font.BOLD, 14);
        itf = new Font("Shefif", Font.ITALIC, 14);
        bif = new Font("Shefif", Font.BOLD + Font.ITALIC, 14);
        tf.setFont(pf);

        pb.addItemListener(new HandlerClass(pf));
        bb.addItemListener(new HandlerClass(bf));
        ib.addItemListener(new HandlerClass(itf));
        bib.addItemListener(new HandlerClass(bif));

    }
    private class HandlerClass implements ItemListener {
        private Font font;
        public HandlerClass(Font f) {
            font = f;
            
        }
        public void itemStateChanged(ItemEvent event) {
            tf.setFont(font);
        }



    }


    

    
}
