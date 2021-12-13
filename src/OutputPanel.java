import javax.swing.*;

public class OutputPanel extends JPanel {
    JLabel dataStructureName = new JLabel("Data Structure: ");
    JLabel processName = new JLabel("Process: ");
    JLabel timeMemory = new JLabel("Time taken/ Memory Usage: ");
    JButton resetButton = new JButton("Reset Search");
    JButton restartButton = new JButton("Restart Program");
    JTextArea results = new JTextArea("");

    public OutputPanel() {
        add(Box.createHorizontalStrut(75));
        add(dataStructureName);
        add(Box.createHorizontalStrut(50));
        add(processName);
        add(Box.createHorizontalStrut(75));
        add(timeMemory);
        add(results);
        add(Box.createHorizontalStrut(200));
        add(Box.createVerticalStrut(100));
        add(resetButton);
        add(restartButton);
    }
}
