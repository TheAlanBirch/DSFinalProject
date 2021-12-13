import javax.swing.*;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    Runtime runtime = Runtime.getRuntime();
    MainMenu mainMenu = new MainMenu();
    SearchPanel searchPanel = new SearchPanel();
    DataStructuresPanel dataStructuresPanel = new DataStructuresPanel();
    StructureMeasurementPanel structureMeasurementPanel = new StructureMeasurementPanel();
    DataPanel dataPanel = new DataPanel();

    String DataStructureChoice;
    String FileSizeChoice;
    String SearchKey;
    String SearchResult;
    String MeasurementChoice;

    OutputPanel outputPanel = new OutputPanel();

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
            revalidate();
            repaint();
            pack();
        });

        dataStructuresPanel.confirmButton.addActionListener(e -> {
            DataStructureChoice = (String) dataStructuresPanel.dataStructureBox.getSelectedItem();
            FileSizeChoice = dataStructuresPanel.fileSizeChoices.getSelection().getActionCommand();
            reader.readFile(DataStructureChoice, FileSizeChoice, storage);
            remove(dataStructuresPanel);
            add(searchPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
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
                revalidate();
                repaint();
                pack();

                SearchResult = storage.searchDataStructure(DataStructureChoice, SearchKey);
                System.out.println(SearchResult);
                dataPanel.results.setText(SearchResult);
            }
        });

        dataPanel.resetButton.addActionListener(e -> {
            SearchKey = "";
            SearchResult = "";

            remove(dataPanel);
            add(searchPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
            pack();
        });

        dataPanel.restartButton.addActionListener(e -> {
            SearchKey = null;
            SearchResult = null;
            DataStructureChoice = null;
            FileSizeChoice = null;

            storage.clearDataStructure();

            remove(dataPanel);
            add(mainMenu, BorderLayout.CENTER);
            revalidate();
            repaint();
            pack();
        });

        mainMenu.partTwo.addActionListener(e -> {
            remove(mainMenu);
            add(structureMeasurementPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
            pack();
        });

        structureMeasurementPanel.confirmButton.addActionListener(e -> {
            DataStructureChoice = (String) structureMeasurementPanel.dataStructureBox.getSelectedItem();
            MeasurementChoice = structureMeasurementPanel.fileSizeChoices.getSelection().getActionCommand();

            outputPanel.dataStructureName.setText("Data Structure: " + DataStructureChoice);
            outputPanel.processName.setText("Process: " + MeasurementChoice);

            storage.findMemoryUsage(DataStructureChoice, storage, reader, outputPanel);

            remove(structureMeasurementPanel);
            add(outputPanel);
            revalidate();
            repaint();
            pack();
        });



        setLocation(800, 400);
        add(mainMenu, BorderLayout.CENTER);
        revalidate();
        repaint();
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.displayGUI();
    }
}