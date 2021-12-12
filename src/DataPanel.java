import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {
    JButton resetButton = new JButton("Reset Search");
    JButton restartButton = new JButton("Restart Program");
    JLabel resultLabel = new JLabel("Results: ");
    JTextArea results = new JTextArea();

    public DataPanel() {


        add(Box.createHorizontalStrut(100));
        add(resetButton);
        add(restartButton);
        add(Box.createHorizontalStrut(100));
        add(resultLabel);
        add(results);
    }
}
