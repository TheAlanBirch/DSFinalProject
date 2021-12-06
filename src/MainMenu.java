import javax.swing.*;

public class MainMenu extends JFrame {
    JButton partOne = new JButton("Part 1");
    JButton partTwo = new JButton("Part 2");

    public MainMenu() {
        super("DS Final Project");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        pane.add(partOne);
        pane.add(partTwo);
        add(pane);
        setVisible(true);
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
