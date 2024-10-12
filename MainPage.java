import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MainPage {
    Image logo = Toolkit.getDefaultToolkit().getImage("WardellLogo.png");  
    Font valorantLogoFont = null;
    Color valcolor = new Color(197, 177, 116);
    Wardell wardell;

    public static void main(String[] args) {
        new MainPage();
    }
    
    public MainPage() {
        
        
        
        JFrame frame = new JFrame();
        frame.setSize(1500, 800);
        frame.setTitle("WARDELL");
        frame.setLayout(null);
        frame.setIconImage(logo);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        try {
            valorantLogoFont = Font.createFont(Font.TRUETYPE_FONT, new File("Valorant Font.ttf")).deriveFont(100f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Valorant Font.ttf")));
        } catch (IOException | FontFormatException e) {
            //TODO: handle exception
        }


        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(504, 200, 492, 110);
        titlePanel.setBackground(Color.black);
        
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Wardell");
        titleLabel.setFont(valorantLogoFont);
        titleLabel.setForeground(valcolor);

        frame.getContentPane().add(titlePanel);
        titlePanel.add(titleLabel);

        System.out.print(titleLabel.getPreferredSize());

        JButton playButton = new JButton();
        playButton.setText("Play");
        playButton.setFont(valorantLogoFont.deriveFont(20f));
        playButton.setBounds(600, 325, 300, 50);
        playButton.setBackground(valcolor);
        frame.add(playButton);

        JButton htpButton = new JButton();
        htpButton.setText("How To Play");
        htpButton.setFont(valorantLogoFont.deriveFont(20f));
        htpButton.setBounds(600, 385, 300, 50);
        htpButton.setBackground(valcolor);
        frame.add(htpButton);

        frame.setVisible(true);

        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                wardell.startGame();
            }
            
        };

        playButton.addActionListener(action);
    }
}
