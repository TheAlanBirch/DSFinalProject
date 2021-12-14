import javax.swing.*;

public class StructureMeasurementPanel extends JPanel {
    String[] dataStructures = {"Array", "Linked List",
            "Red-Black Tree", "Hashtable", "Custom"};

    JRadioButton insertionButton = new JRadioButton("Insertion");
    JRadioButton lookUpButton = new JRadioButton("Look-Up");
    JRadioButton memoryUsageButton = new JRadioButton("Memory Usage");
    JButton confirmButton = new JButton("Confirm Choice");
    JLabel warningLabel = new JLabel
            ("This process could take a while so please be patient.");

    JComboBox<String> dataStructureBox = new JComboBox<>(dataStructures);
    ButtonGroup fileSizeChoices = new ButtonGroup();

    public StructureMeasurementPanel() {
        JLabel dataStructureLabel =
                new JLabel("Data Structures to utilize: ");
        JLabel fileSizeLabel =
                new JLabel("Measurements that can be taken: ");

        fileSizeChoices.add(insertionButton);
        fileSizeChoices.add(lookUpButton);
        fileSizeChoices.add(memoryUsageButton);
        fileSizeChoices.
                setSelected(insertionButton.getModel(), true);

        insertionButton.setActionCommand("Insertion");
        lookUpButton.setActionCommand("Look-Up");
        memoryUsageButton.setActionCommand("Memory");

        add(Box.createHorizontalStrut(100));
        add(dataStructureLabel);
        add(dataStructureBox);
        add(Box.createHorizontalStrut(100));
        add(Box.createVerticalStrut(50));
        add(fileSizeLabel);
        add(insertionButton);
        add(lookUpButton);
        add(memoryUsageButton);
        add(confirmButton);
        add(warningLabel);
        setVisible(true);
    }
}
