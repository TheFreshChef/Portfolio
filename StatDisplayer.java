import java.awt.*;
import javax.swing.*;


public class StatDisplayer {
    private Wardell wardell;
    private GUI gui;
    private int count;
    private String down = "↓";
    private String up = "↑";
    private boolean win = false;
    Font font = new Font("Helvetica", Font.PLAIN, 20);


    public StatDisplayer(GUI gui, Wardell wardell) {
        this.wardell = wardell;
        this.gui = gui;
    }

    public void countTracker(int c) {
        count = c;
    }

    public void displayWin()
    {
        count++;
        win = true;
        displayStats(0, 0, 0, 0, 0, 0);
    }

    public void displayStats(int one, int two, int three, int four, int five, int six){
        PlayerInfo statGuess = wardell.guess(gui.validName);
        JPanel playerPanel = new JPanel();
        playerPanel.setBounds(120, 257 + 40 * (count - 1) + 15, 180, 40);
        playerPanel.setBackground(Color.black);

        JLabel playerLabel = new JLabel();
        playerLabel.setText(statGuess.name());
        playerLabel.setFont(font);
        playerLabel.setForeground(Color.gray);

        gui.getJFrame().getContentPane().add(playerPanel);
        playerPanel.add(playerLabel);
        if (win) {
            playerPanel.setBackground(Color.green);
        }

        if (one == 0) 
        {
            JPanel teamPanel = new JPanel();
            teamPanel.setBounds(300, 257 + 40 * (count - 1) + 15, 180, 40);
            teamPanel.setBackground(Color.green);
    
            JLabel teamLabel = new JLabel();
            teamLabel.setText(statGuess.tName());
            teamLabel.setFont(font);
            teamLabel.setForeground(Color.gray);
            
            gui.getJFrame().getContentPane().add(teamPanel);
            teamPanel.add(teamLabel);
        }
        if (one == 1) 
        {
            JPanel teamPanel = new JPanel();
            teamPanel.setBounds(300, 257 + 40 * (count - 1) + 15, 180, 40);
            teamPanel.setBackground(Color.black);
    
            JLabel teamLabel = new JLabel();
            teamLabel.setText(statGuess.tName());
            teamLabel.setFont(font);
            teamLabel.setForeground(Color.gray);
            
            gui.getJFrame().getContentPane().add(teamPanel);
            teamPanel.add(teamLabel);
        }
        
        
        
        if(two == 0)
        {
            JPanel regionPanel = new JPanel();
            regionPanel.setBounds(480, 257 + 40 * (count - 1) + 15, 180, 40);
            regionPanel.setBackground(Color.green);

            JLabel regionLabel = new JLabel();
            regionLabel.setText(statGuess.region());
            regionLabel.setFont(font);
            regionLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(regionPanel);
            regionPanel.add(regionLabel);
        }
        if(two == 1) 
        {
            JPanel regionPanel = new JPanel();
            regionPanel.setBounds(480, 257 + 40 * (count - 1) + 15, 180, 40);
            regionPanel.setBackground(Color.black);

            JLabel regionLabel = new JLabel();
            regionLabel.setText(statGuess.region());
            regionLabel.setFont(font);
            regionLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(regionPanel);
            regionPanel.add(regionLabel);
        }

    
        if(three == 0)
        {
            JPanel agentPanel = new JPanel();
            agentPanel.setBounds(660, 257 + 40 * (count - 1) + 15, 180, 40);
            agentPanel.setBackground(Color.green);

            JLabel agentLabel = new JLabel();
            agentLabel.setText(statGuess.agent());
            agentLabel.setFont(font);
            agentLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(agentPanel);
            agentPanel.add(agentLabel);
        }

        if(three == 1) {
            JPanel agentPanel = new JPanel();
            agentPanel.setBounds(660, 257 + 40 * (count - 1) + 15, 180, 40);
            agentPanel.setBackground(Color.black);

            JLabel agentLabel = new JLabel();
            agentLabel.setText(statGuess.agent());
            agentLabel.setFont(font);
            agentLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(agentPanel);
            agentPanel.add(agentLabel);
        }


        if (four == 0) 
        {
            JPanel acsPanel = new JPanel();
            acsPanel.setBounds(840, 257 + 40 * (count - 1) + 15, 180, 40);
            acsPanel.setBackground(Color.green);

            JLabel acsLabel = new JLabel();
            acsLabel.setText(statGuess.acs() + "");
            acsLabel.setFont(font);
            acsLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(acsPanel);
            acsPanel.add(acsLabel);
        }
        if (four == 1) 
        {
            JPanel acsPanel = new JPanel();
            acsPanel.setBounds(840, 257 + 40 * (count - 1) + 15, 180, 40);
            acsPanel.setBackground(Color.yellow);

            JLabel acsLabel = new JLabel();
            acsLabel.setText(statGuess.acs() + "    " + down);
            acsLabel.setFont(font);
            acsLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(acsPanel);
            acsPanel.add(acsLabel);
        }
        if (four == 2) 
        {
            JPanel acsPanel = new JPanel();
            acsPanel.setBounds(840, 257 + 40 * (count - 1) + 15, 180, 40);
            acsPanel.setBackground(Color.yellow);

            JLabel acsLabel = new JLabel();
            acsLabel.setText(statGuess.acs() + "    " + up);
            acsLabel.setFont(font);
            acsLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(acsPanel);
            acsPanel.add(acsLabel);
        }
        if (four == 3) 
        {
            JPanel acsPanel = new JPanel();
            acsPanel.setBounds(840, 257 + 40 * (count - 1) + 15, 180, 40);
            acsPanel.setBackground(Color.black);

            JLabel acsLabel = new JLabel();
            acsLabel.setText(statGuess.acs() + "");
            acsLabel.setFont(font);
            acsLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(acsPanel);
            acsPanel.add(acsLabel);
        }

        if (five == 0) 
        {
            JPanel kdPanel = new JPanel();
            kdPanel.setBounds(1020, 257 + 40 * (count - 1) + 15, 180, 40);
            kdPanel.setBackground(Color.green);

            JLabel kdLabel = new JLabel();
            kdLabel.setText(statGuess.kd() + "");
            kdLabel.setFont(font);
            kdLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(kdPanel);
            kdPanel.add(kdLabel);
        }
        if (five == 1) 
        {
            JPanel kdPanel = new JPanel();
            kdPanel.setBounds(1020, 257 + 40 * (count - 1) + 15, 180, 40);
            kdPanel.setBackground(Color.yellow);

            JLabel kdLabel = new JLabel();
            kdLabel.setText(statGuess.kd() + "  " + down);
            kdLabel.setFont(font);
            kdLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(kdPanel);
            kdPanel.add(kdLabel);
        }
        if (five == 2) 
        {
            JPanel kdPanel = new JPanel();
            kdPanel.setBounds(1020, 257 + 40 * (count - 1) + 15, 180, 40);
            kdPanel.setBackground(Color.yellow);

            JLabel kdLabel = new JLabel();
            kdLabel.setText(statGuess.kd() + "  " + up);
            kdLabel.setFont(font);
            kdLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(kdPanel);
            kdPanel.add(kdLabel);
        }
        if (five == 3) 
        {
            JPanel kdPanel = new JPanel();
            kdPanel.setBounds(1020, 257 + 40 * (count - 1) + 15, 180, 40);
            kdPanel.setBackground(Color.black);

            JLabel kdLabel = new JLabel();
            kdLabel.setText(statGuess.kd() + "");
            kdLabel.setFont(font);
            kdLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(kdPanel);
            kdPanel.add(kdLabel);
        }

        if (six == 0) 
        {
            JPanel adrPanel = new JPanel();
            adrPanel.setBounds(1200, 257 + 40 * (count - 1) + 15, 180, 40);
            adrPanel.setBackground(Color.green);

            JLabel adrLabel = new JLabel();
            adrLabel.setText(statGuess.adr() + "");
            adrLabel.setFont(font);
            adrLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(adrPanel);
            adrPanel.add(adrLabel);
        }
        if (six == 1) 
        {
            JPanel adrPanel = new JPanel();
            adrPanel.setBounds(1200, 257 + 40 * (count - 1) + 15, 180, 40);
            adrPanel.setBackground(Color.yellow);

            JLabel adrLabel = new JLabel();
            adrLabel.setText(statGuess.adr() + "    " + down);
            adrLabel.setFont(font);
            adrLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(adrPanel);
            adrPanel.add(adrLabel);
        }
        if (six == 2) 
        {
            JPanel adrPanel = new JPanel();
            adrPanel.setBounds(1200, 257 + 40 * (count - 1) + 15, 180, 40);
            adrPanel.setBackground(Color.yellow);

            JLabel adrLabel = new JLabel();
            adrLabel.setText(statGuess.adr() + "    " + up);
            adrLabel.setFont(font);
            adrLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(adrPanel);
            adrPanel.add(adrLabel);
        }
        if (six == 3) 
        {
            JPanel adrPanel = new JPanel();
            adrPanel.setBounds(1200, 257 + 40 * (count - 1) + 15, 180, 40);
            adrPanel.setBackground(Color.black);

            JLabel adrLabel = new JLabel();
            adrLabel.setText(statGuess.adr() + "");
            adrLabel.setFont(font);
            adrLabel.setForeground(Color.gray);

            gui.getJFrame().getContentPane().add(adrPanel);
            adrPanel.add(adrLabel);
        }


        JFrame frame = gui.getJFrame();
        frame.repaint();
    }
}

