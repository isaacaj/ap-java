package experiments;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 90304755 on 1/2/18.
 */
public class FrameExperiment
{
    static JFrame frame = new JFrame("Frame Title");
    static JPanel panel = new JPanel();
    static JLabel label = new JLabel("Labeltext");
    static JLabel label0 = new JLabel("textLabel");
    static JButton button1 = new JButton("Button is this");
    static JButton button2 = new JButton("Button is not this");

    public static void main(String[] args)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("/Users/90304755/Desktop/FRC/TalonIconRedMini.png").getImage());

        panel.setLayout(new GridLayout());
        panel.add(button1);
        panel.add(button2);
        panel.add(label);
        panel.add(label0);

        button1.setSize(60,60);

        frame.add(panel);
        frame.setSize(720, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
