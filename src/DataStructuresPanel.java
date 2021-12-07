import javax.swing.*;
import javax.xml.crypto.Data;

public class DataStructuresPanel extends JPanel {
    int dataStructureChoice; // 1: Array,
                             // 2: Linked List,
                             // 3: Red-Black Tree,
                             // 4: Hashtable,
                             // 5: Custom

    JButton confirmButton = new JButton("Confirm Choice");
    String[] dataStructures = {"Array", "Linked List",
            "Red-Black Tree", "Hashtable", "Custom"};
    JComboBox<String> dataStructureBox = new JComboBox<>(dataStructures);

    public DataStructuresPanel() {
        JLabel dataStructureLabel = new JLabel(
                "Data Structures to search:"
        );

        add(dataStructureLabel);
        add(dataStructureBox);
        add(confirmButton);
        setVisible(true);
    }
}
