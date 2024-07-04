package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Gui {

    private JLabel label;
    private ImageIcon birdIcon;
    private ImageIcon catIcon;
    private ImageIcon dogIcon;
    private ImageIcon pigIcon;
    private ImageIcon rabbitIcon;

    public Gui() {
        //Load images
        birdIcon = new ImageIcon("gui/src/gui/bird.jpeg");
        catIcon = new ImageIcon("gui/src/gui/cat.jpg");
        dogIcon = new ImageIcon("gui/src/gui/dog.jpg");
        rabbitIcon = new ImageIcon("gui/src/gui/rabbit.jpg");
        pigIcon = new ImageIcon("gui/src/gui/pig.jpg");
        
        //resize the images
        Image animalImage = birdIcon.getImage();
        Image modifiedImage = animalImage.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
        birdIcon = new ImageIcon(modifiedImage);
        
        Image catImage = catIcon.getImage();
        Image newImage = catImage.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
        catIcon = new ImageIcon(newImage);
        
        Image dogImage = dogIcon.getImage();
        Image newDogImage = dogImage.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
        dogIcon = new ImageIcon(newDogImage);
        
        Image rabbitImage = rabbitIcon.getImage();
        Image newRabbitImage = rabbitImage.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
        rabbitIcon = new ImageIcon(newRabbitImage);
        
        Image pigImage = pigIcon.getImage();
        Image newPigImage = pigImage.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
        pigIcon = new ImageIcon(newPigImage);
        
        label = new JLabel();
        label.setText("Select a radio button to display");
        label.setHorizontalTextPosition(JLabel.CENTER); // set text center

        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton rabbitButton = new JRadioButton("rabbit");
        JRadioButton pigButton = new JRadioButton("Pig");

        //Add action listeners to radio buttons
        birdButton.addActionListener(new AnimalActionListener(birdIcon));
        catButton.addActionListener(new AnimalActionListener(catIcon));
        dogButton.addActionListener(new AnimalActionListener(dogIcon));
        rabbitButton.addActionListener(new AnimalActionListener(rabbitIcon));
        pigButton.addActionListener(new AnimalActionListener(pigIcon));

        //add spacing to radio buttons
        int spacing = 10;
        birdButton.setBorder(new EmptyBorder(10, spacing, 30, 0));
        catButton.setBorder(new EmptyBorder(50, spacing, 30, 0));
        dogButton.setBorder(new EmptyBorder(50, spacing, 30, 0));
        rabbitButton.setBorder(new EmptyBorder(50, spacing, 30, 0));
        pigButton.setBorder(new EmptyBorder(50, spacing, 10, 0));

        //create a panel to hold the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        //Group the radio buttons to prevent double selecting
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(pigButton);
        group.add(rabbitButton);
        group.add(dogButton);

        JFrame frame = new JFrame();
        frame.setTitle("RadioButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 500);

        frame.getContentPane().setBackground(new Color(254, 251, 234)); // Set the background color

        //add the label and radio panel to the frame
        frame.add(radioPanel);
        frame.add(label);

        //frame.pack();
        frame.setVisible(true);
    }

    private class AnimalActionListener implements ActionListener {
        private ImageIcon animalIcon;

        public AnimalActionListener(ImageIcon animalIcon) {
            this.animalIcon = animalIcon;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("");
            label.setIcon(animalIcon);
        }
    }

    public static void main(String[] args) {
        new Gui();
    }
}
