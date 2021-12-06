import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JFrame{
    JTextField searchTerm = new JTextField(30);
    JButton searchButton = new JButton("Search");
    JLabel confirmationLabel = new JLabel("");

    String[] dataStructures = {"Array", "Linked List",
            "Red-Black Tree", "Hashtable", "Custom"};
    JComboBox<String> dataStructureBox = new JComboBox<>(dataStructures);

    public SearchPanel() {
        super("Search for a name");
        setSize(450, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationLabel.setText("Search Button was clicked");
            }
        });
        JLabel searchTermLabel = new JLabel("Search Key: ");
        JLabel dataStructureLabel = new JLabel(
                "Data Structures to search:"
        );
        panel.add(searchTermLabel);
        panel.add(searchTerm);
        panel.add(dataStructureLabel);
        panel.add(dataStructureBox);
        panel.add(searchButton);
        panel.add(confirmationLabel);
        add(panel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] args) {
        SearchPanel.setLookAndFeel();
    }
}
