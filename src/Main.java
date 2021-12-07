import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    MainMenu mainMenu = new MainMenu();
    SearchPanel searchPanel = new SearchPanel();
    DataStructuresPanel dataStructuresPanel = new DataStructuresPanel();

    public Main() {
        super("DS Final Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchPanel.setPreferredSize(new Dimension(500, 420));

    }

    private void displayGUI()
    {
        mainMenu.partOne.addActionListener(e -> {
            remove(mainMenu);
            add(dataStructuresPanel, BorderLayout.CENTER);
            pack();
        });

        dataStructuresPanel.confirmButton.addActionListener(e -> {
            dataStructuresPanel.dataStructureChoice
            remove(dataStructuresPanel);
            add(searchPanel, BorderLayout.CENTER);
            pack();
        });

        searchPanel.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPanel.confirmationLabel.setText("Search Button was clicked");
            }
        });
        setLocation(10, 200);
        add(mainMenu, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.displayGUI();
    }
}