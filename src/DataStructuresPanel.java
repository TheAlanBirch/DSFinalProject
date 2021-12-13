import javax.swing.*;
import javax.xml.crypto.Data;

public class DataStructuresPanel extends JPanel {
    JRadioButton tinyFile = new JRadioButton("Tiny File");
    JRadioButton smallFile = new JRadioButton("Small File");
    JRadioButton mediumFile = new JRadioButton("Medium File");
    JRadioButton largeFile = new JRadioButton("Large File");

    JButton confirmButton = new JButton("Confirm Choice");
    String[] dataStructures = {"Array", "Linked List",
            "Red-Black Tree", "Hashtable", "Custom"};
    JComboBox<String> dataStructureBox = new JComboBox<>(dataStructures);
    ButtonGroup fileSizeChoices = new ButtonGroup();

    public DataStructuresPanel() {

        JLabel dataStructureLabel = new JLabel(
                "Data Structures to search:"
        );

        JLabel fileSizeLabel = new JLabel("File sizes that can be loaded: ");

        fileSizeChoices.add(tinyFile);
        fileSizeChoices.add(smallFile);
        fileSizeChoices.add(mediumFile);
        fileSizeChoices.add(largeFile);
        fileSizeChoices.setSelected(tinyFile.getModel(), true);

        tinyFile.setActionCommand("data/tiny.csv");
        smallFile.setActionCommand("data/small.csv");
        mediumFile.setActionCommand("data/medium.csv");
        largeFile.setActionCommand("data/large.csv");

        add(Box.createHorizontalStrut(100));
        add(dataStructureLabel);
        add(dataStructureBox);
        add(Box.createHorizontalStrut(100));

        add(fileSizeLabel);
        add(tinyFile);
        add(smallFile);
        add(mediumFile);
        add(largeFile);
        add(confirmButton);
        setVisible(true);
    }
}
