import javax.swing.*;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    MainMenu mainMenu = new MainMenu();
    SearchPanel searchPanel = new SearchPanel();
    DataStructuresPanel dataStructuresPanel = new DataStructuresPanel();
    DataPanel dataPanel = new DataPanel();

    String DataStructureChoice;
    String FileSizeChoice;
    String SearchKey;
    String SearchResult;

    CsvReader reader = new CsvReader();
    DataStructureStorage storage = new DataStructureStorage();

    public Main() {
        super("DS Final Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 420));
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
            FileSizeChoice = dataStructuresPanel.fileSizeChoices.getSelection().getActionCommand();
            reader.readFile(DataStructureChoice, FileSizeChoice, storage);
            remove(dataStructuresPanel);
            add(searchPanel, BorderLayout.CENTER);
            pack();
        });

        searchPanel.searchButton.addActionListener(e -> {
            if (searchPanel.searchTerm.getText().length() == 0)
                searchPanel.confirmationLabel.setText("You must enter something into the field in order to search!");
            else {
                SearchKey = searchPanel.searchTerm.getText();
                System.out.println(SearchKey);
                remove(searchPanel);
                add(dataPanel, BorderLayout.CENTER);
                pack();

//                storage.searchDataStructure(DataStructureChoice ,SearchKey, SearchResult);
                SearchResult = storage.searchDataStructure(DataStructureChoice, SearchKey);
                System.out.println(SearchResult);
                dataPanel.results.setText(SearchResult);
            }
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