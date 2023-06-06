package Test.Apples1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame{
    private JPanel mousePanel;
    private JLabel statusBar;
    
    public Gui() {
        super(" Title of the window");

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("default");
        add(statusBar, BorderLayout.SOUTH);

        HandlerClass handler = new HandlerClass();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
        
    }
    private class HandlerClass implements MouseListener, MouseMotionListener {
        public void mouseClicked(MouseEvent event) {
            statusBar.setText(String.format("Clicked at %d %d ", event.getX(), event.getY()));            
        }
        public void mouseRelesed(MouseEvent event) {
            statusBar.setText("Mouse pressed");
        }
        public void mousePressed(MouseEvent event) {
            statusBar.setText("Mouse pressed");
        }
        public void mouseEntered(MouseEvent event) {
            statusBar.setText("You enter the area");
            mousePanel.setBackground(Color.RED);
        }
        public void mouseLeaving(MouseEvent event) {
            statusBar.setText("You leave the area");
            mousePanel.setBackground(Color.WHITE);
        }
        public void mouseDragged(MouseEvent event) {
            statusBar.setText("You are dragging thew mouse");            
        }
        public void mouseMoved(MouseEvent event) {
            statusBar.setText("You moved the mouse");
            
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }
        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        }



    }
    
}
