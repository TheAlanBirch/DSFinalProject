import javax.swing.*;
import java.util.Objects;

public class LoadingPanel extends JPanel {
    JLabel loadingLabel = new JLabel("Loading ...");
    public Boolean isLoadingFinished = true;
    JLabel waitLabel = new JLabel("Please wait for the process to finish");

    public LoadingPanel() {
        add(Box.createHorizontalStrut(200));
        add(loadingLabel);
        add(Box.createHorizontalStrut(200));
        add(waitLabel);
    }
}
