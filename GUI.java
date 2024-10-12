import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javafx.scene.media.*;

public class GUI {
    Wardell wardell;
    ListRefresh player;
    ActionEvent e;
    Color valcolor = new Color(197, 177, 116);
    Font valorantLogoFont = null;
    Image logo = Toolkit.getDefaultToolkit().getImage("WardellLogo.png");  
    String guessedName = "";
    String validName = "";
    private static boolean active = true;
    public JFrame frame;
    

    public static void main(String[] args) {
        new GUI(null);
    }

    // public String getGuess() {
    //     player.getGuess();
    // }


    public GUI(Wardell wardell) {
        this.wardell = wardell;   
        
        String musicFile = "Wardell Background Song.mp3"; 
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound); 
        mediaPlayer.play();

        frame = new JFrame();
        frame.setSize(1500, 800);
        frame.setTitle("WARDELL");
        frame.setLayout(null);
        frame.setIconImage(logo);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        try {
            valorantLogoFont = Font.createFont(Font.TRUETYPE_FONT, new File("Valorant Font.ttf")).deriveFont(80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Valorant Font.ttf")));
        } catch (IOException | FontFormatException e) {
            //TODO: handle exception
        }

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(553, 0, 394, 75);
        titlePanel.setBackground(Color.black);
        
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Wardell");
        titleLabel.setFont(valorantLogoFont);
        titleLabel.setForeground(valcolor);


        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBounds(485, 75, 529, 31);
        descriptionPanel.setBackground(Color.black);

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Valorant Player Guessing Game");
        descriptionLabel.setFont(valorantLogoFont.deriveFont(28f));
        descriptionLabel.setForeground(valcolor);


        JPanel playerCategoryPanel = new JPanel();
        playerCategoryPanel.setBounds(120, 235, 180, 18);
        playerCategoryPanel.setBackground(Color.black);

        JLabel playerCategoryLabel = new JLabel();
        playerCategoryLabel.setText("Player");
        playerCategoryLabel.setFont(valorantLogoFont.deriveFont(14f));
        playerCategoryLabel.setForeground(valcolor);

        JPanel teamCategoryPanel = new JPanel();
        teamCategoryPanel.setBounds(300, 235, 180, 18);
        teamCategoryPanel.setBackground(Color.black);

        JLabel teamCategoryLabel = new JLabel();
        teamCategoryLabel.setText("Team");
        teamCategoryLabel.setFont(valorantLogoFont.deriveFont(14f));
        teamCategoryLabel.setForeground(valcolor);

        JPanel regionCategoryPanel = new JPanel();
        regionCategoryPanel.setBounds(480, 235, 180, 18);
        regionCategoryPanel.setBackground(Color.black);

        JLabel regionCategoryLabel = new JLabel();
        regionCategoryLabel.setText("Region");
        regionCategoryLabel.setFont(valorantLogoFont.deriveFont(14f));
        regionCategoryLabel.setForeground(valcolor);

        JPanel agentCategoryPanel = new JPanel();
        agentCategoryPanel.setBounds(660, 235, 180, 18);
        agentCategoryPanel.setBackground(Color.black);

        JLabel agentCategoryLabel = new JLabel();
        agentCategoryLabel.setText("Agent");
        agentCategoryLabel.setFont(valorantLogoFont.deriveFont(14f));
        agentCategoryLabel.setForeground(valcolor);

        JPanel acsCategoryPanel = new JPanel();
        acsCategoryPanel.setBounds(840, 235, 180, 18);
        acsCategoryPanel.setBackground(Color.black);

        JLabel acsCategoryLabel = new JLabel();
        acsCategoryLabel.setText("ACS");
        acsCategoryLabel.setFont(valorantLogoFont.deriveFont(14f));
        acsCategoryLabel.setForeground(valcolor);

        JPanel kdCategoryPanel = new JPanel();
        kdCategoryPanel.setBounds(1020, 235, 180, 18);
        kdCategoryPanel.setBackground(Color.black);

        JLabel kdCategoryLabel = new JLabel();
        kdCategoryLabel.setText("K:D");
        kdCategoryLabel.setFont(valorantLogoFont.deriveFont(14f));
        kdCategoryLabel.setForeground(valcolor);

        JPanel adrCategoryPanel = new JPanel();
        adrCategoryPanel.setBounds(1200, 235, 180, 18);
        adrCategoryPanel.setBackground(Color.black);

        JLabel adrCategoryLabel = new JLabel();
        adrCategoryLabel.setText("ADR");
        adrCategoryLabel.setFont(valorantLogoFont.deriveFont(14f));
        adrCategoryLabel.setForeground(valcolor);


        JPanel borderPanel = new JPanel();
        borderPanel.setBounds(100, 253, 1300, 3);
        borderPanel.setBackground(valcolor);

        frame.getContentPane().add(borderPanel);

        frame.getContentPane().add(titlePanel);
        titlePanel.add(titleLabel);
       
        frame.getContentPane().add(descriptionPanel);
        descriptionPanel.add(descriptionLabel);

        frame.getContentPane().add(playerCategoryPanel);
        playerCategoryPanel.add(playerCategoryLabel);

        frame.getContentPane().add(teamCategoryPanel);
        teamCategoryPanel.add(teamCategoryLabel);

        frame.getContentPane().add(regionCategoryPanel);
        regionCategoryPanel.add(regionCategoryLabel);

        frame.getContentPane().add(agentCategoryPanel);
        agentCategoryPanel.add(agentCategoryLabel);

        frame.getContentPane().add(acsCategoryPanel);
        acsCategoryPanel.add(acsCategoryLabel);

        frame.getContentPane().add(kdCategoryPanel);
        kdCategoryPanel.add(kdCategoryLabel);

        frame.getContentPane().add(adrCategoryPanel);
        adrCategoryPanel.add(adrCategoryLabel);

        

        player = new ListRefresh(frame);

        frame.setVisible(true);
        
    }
    

    public JFrame getJFrame() {
        return frame;
    }



    private class ListRefresh {

        Font ValorantTextFont = null; {
        try{
            // load a custom font in your project folder
            ValorantTextFont = Font.createFont(Font.TRUETYPE_FONT, new File("Valorant Font.ttf")).deriveFont(12f);    
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Valorant Font.ttf")));            
        }
        catch(IOException | FontFormatException e){
            
            }
        }
    
        private String[] nameList =  {
            "FNS", "Marved", "yay", "crashies", "Victor", 
            "valyn", "trent", "JonahP", "neT", "Sayaplayer", 
            "vanity", "Xeppaa", "mitch", "xeta", "leaf", 
            "dephh", "zekken", "BcJ", "Cryocells", "AYRIN", 
            "ShahZaM", "TenZ", "dapr", "Kanpeki", "SicK",
            "SUYGETSU", "ANGE1", "ardiis", "Zyppan", "Shao", 
            "hoody", "AvovA", "nukkye", "Meddo", "Mixwell", 
            "Jamppi", "soulcas", "L1NK", "Nivera", "ScreaM", 
            "Redgar", "d3ffo", "Chronicle", "nAts", "sheydos", 
            "zeek", "cNed", "starxo", "vakk", "MONSTEERR", 
            "Benkai", "f0rsakeN", "d4v41", "mindfreak", "Jinggg", 
            "foxz", "sScary", "Sushiboys", "Surf", "Crws", 
            "stax", "MaKo", "Rb", "Zest", "BuZz", 
            "Laz", "Dep", "Crow", "SugarZ3ro", "TENNN", 
            "Sacy", "Aspas", "saadhak", "pancada", "Less", 
            "xand", "bnj", "bezn1", "cauanzin", "Jonn", 
            "delz1k", "NagZ", "Klaus", "Mazino", "Keznit"};
        
        private JList jList = createJList();
        JTextField field = createTextField();
        JScrollPane pane = new JScrollPane(jList);
        JButton enterButton = new JButton("Enter");
        

        String guess;
        int count = 0;

        public ListRefresh(JFrame frame) {
            frame.add(pane);
            pane.setBounds(465, 180, 500, 50);
            jList.setBounds(465,180,500,50);
            frame.add(field, BorderLayout.PAGE_END);
            field.setBounds(465,150,500,30);
            field.setFont(ValorantTextFont.deriveFont(23f));

            JPanel guessPanel = new JPanel();
            guessPanel.setBounds(670, 115, 160, 22);
            guessPanel.setBackground(Color.black);
            JLabel guessLabel = new JLabel();
            guessLabel.setText("0 of 6 guesses");
            guessLabel.setFont(valorantLogoFont.deriveFont(20f));
            guessLabel.setForeground(valcolor);
            frame.getContentPane().add(guessPanel);
            guessPanel.add(guessLabel);

            frame.add(enterButton);
            enterButton.setBounds(965, 150, 70, 80);
            enterButton.setForeground(Color.gray);

            ActionListener action = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    active = true;
                    if (!active) {
                        return;
                    }
                    for (String name : nameList) {
                        guessedName = field.getText();
                        if (guessedName.toLowerCase().equals(name.toLowerCase())) {
                            validName = name;
                            field.setText("");
                            count++;
                            if (count <= 6) {
                                guessLabel.setText(count + " of 6 guesses");
                                boolean isCorrect = wardell.runRound(name, count);
                            }
                            else {
                                active = false;
                            }
                        }
                    }
                }
            };

            field.addActionListener(action);
           
            enterButton.addActionListener(action);
        }


        private JTextField createTextField() {
            final JTextField field = new JTextField(85);
            field.getDocument().addDocumentListener(new DocumentListener(){
                
                @Override 
                public void insertUpdate(DocumentEvent e) { 
                    filter(); 
                }
                
                @Override 
                public void removeUpdate(DocumentEvent e) { 
                    filter(); 
                }
                
                @Override 
                public void changedUpdate(DocumentEvent e) {

                }
                
                private void filter() {
                    String filter = field.getText();
                    filterModel((DefaultListModel<String>)jList.getModel(), filter);
                }
            });
            return field;
        }

        private JList createJList() {
            JList list = new JList(createDefaultListModel());
            list.setVisibleRowCount(2);
            list.setFont(ValorantTextFont);
            MouseListener mouseListener = new MouseInputAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        int index = list.locationToIndex(e.getPoint());
                        if (list.getModel().getElementAt(index) != null && list.getModel().getElementAt(index) instanceof String)
                        {   
                            field.setText((String) list.getModel().getElementAt (index));
                        }
                     }
                }
            };
            list.addMouseListener(mouseListener);
            return list;
        }

        private ListModel<String> createDefaultListModel() {
            DefaultListModel<String> model = new DefaultListModel<>();
            for (String s : nameList) {
                model.addElement(s);
            }
            return model;
        }

        public void filterModel(DefaultListModel<String> model, String filter) {
            for (String s : nameList) {
                if (!s.toLowerCase().startsWith(filter.toLowerCase())) {
                    if (model.contains(s)) {
                        model.removeElement(s);
                    }
                } else {
                    if (!model.contains(s)) {
                        model.addElement(s);
                    }
                }
            }
        

       
        
    }
}




}


