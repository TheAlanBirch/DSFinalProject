import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    MainMenu mainMenu = new MainMenu();
    SearchPanel searchPanel = new SearchPanel();
    DataStructuresPanel dataStructuresPanel = new DataStructuresPanel();
    String DataStructureChoice;

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
            DataStructureChoice = (String) dataStructuresPanel.dataStructureBox.getSelectedItem();
            remove(dataStructuresPanel);
            add(searchPanel, BorderLayout.CENTER);
            pack();
        });

        searchPanel.searchButton.addActionListener(e -> {
            if (searchPanel.searchTerm.getText().length() == 0)
                searchPanel.confirmationLabel.setText("You must enter something into the field in order to search!");
            else
                searchPanel.confirmationLabel.setText("The DataStructure to be searched is a " + DataStructureChoice);
        });
        setLocation(800, 400);
        add(mainMenu, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.displayGUI();
    }
}