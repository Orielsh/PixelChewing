import javax.swing.*;
import java.awt.*;

public class Tester {

    public static void main(String[] args){

        //Ask user parameters
        String result = JOptionPane.showInputDialog("Insert picture edge size");
        int size = Integer.parseInt(result);
        Picture picture = new Picture(size);

        result = JOptionPane.showInputDialog("How many transitions?");
        int transitions = Integer.parseInt(result);

        result = JOptionPane.showInputDialog("How many threads?");
        int threadsAmount = Integer.parseInt(result);

        //Creating Picture & Buttons panel
        PicturePanel picturePanel = new PicturePanel(picture);
        ButtonsPanel buttons = new ButtonsPanel(picture, picturePanel, threadsAmount, transitions);

        //Layout config of main frame
        JFrame frame = new JFrame("Shrink");
        frame.setLayout(new BorderLayout());

        //Add panels
        frame.add(picturePanel, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.SOUTH);
        frame.pack();

        //Config of main frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
