package gui;

//import java.awt.Color; //if the color of the frame is needed
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Gui {
    public Gui() {
        JLabel label = new JLabel();
        ImageIcon pig = new ImageIcon("src/gui/pig.jpg");
        Image resizedImage =pig.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        label.setIcon(resizedIcon);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text center

        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton pigButton = new JRadioButton("Pig");
        
        int spacing = 20;
        birdButton.setBorder(new EmptyBorder(30, spacing, 10, 40));
        catButton.setBorder(new EmptyBorder(30, spacing, 10, 40));
        dogButton.setBorder(new EmptyBorder(30, spacing, 10, 40));
        pigButton.setBorder(new EmptyBorder(30, spacing, 10, 40));


        //panel to hold the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(pigButton);

        //Grouping of  the radio buttons to prevent multiple selection
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(pigButton);
        group.add(dogButton);

        JFrame frame = new JFrame();
        frame.setTitle("RadioButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new FlowLayout());
        //frame.setSize(600, 500);

        //frame.getContentPane().setBackground(new Color(254, 251, 234)); //Set the background color to cream i think

        //Add the label and radio panel to the frame
        frame.add(radioPanel, BorderLayout.WEST);
        frame.add(label, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}
