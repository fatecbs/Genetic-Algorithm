package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    
    public static void main(String[] args) {
        // Creating the JPanel
        JPanel panel = new Screen();
        // Creating the JFrame
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setSize(990,540);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
        jframe.add(panel);
    }
}