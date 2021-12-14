import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel{
    JTextField searchTerm = new JTextField(30);
    JButton searchButton = new JButton("Search");
    JLabel confirmationLabel = new JLabel("");

    public SearchPanel() {

        JLabel searchTermLabel =
                new JLabel("Search Key: ");

        add(searchTermLabel);
        add(searchTerm);
        add(searchButton);
        add(confirmationLabel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing." +
                            "plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] args) {
        SearchPanel.setLookAndFeel();
    }
}
