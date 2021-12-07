import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    JButton partOne;
    JButton partTwo;

    public MainMenu() {
        setOpaque(true);
        partOne = new JButton("Click for Part 1");
        partTwo = new JButton("Click for Part 2");

        add(partOne);
        add(partTwo);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] arguments) {
        MainMenu.setLookAndFeel();
    }
}
