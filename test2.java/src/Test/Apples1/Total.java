package Test.Apples1;

import javax.swing.JOptionPane;

public class Total {
    public static void main(String[] args) {
        String fn = JOptionPane.showInputDialog("Enter First number : ");
        String sn = JOptionPane.showInputDialog("Enter Second number : ");
        // String name = JOptionPane.showInputDialog(" Please Enter Your Name : ");
        int num1 = Integer.parseInt(fn);
        int num2 = Integer.parseInt(sn);
       
        int total = num1 + num2;
        JOptionPane.showMessageDialog(null," The Total is... : " + total, " The title Bar", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null,name, " This is the name title..", JOptionPane.ERROR_MESSAGE);
        //JOptionPane.showMessageDialog(null," Power is: " + power, " This is the Power Title..", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null," The total is : " + total, " This is the Total Title ", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null, compare, " Title Compare", JOptionPane.PLAIN_MESSAGE);
        

           
     }
    
}
