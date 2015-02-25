package dayplan.desktop.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author vmuravlev
 */
public class DayPlanController implements Initializable {

    @FXML
    private Label todayLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todayLabel.setText(String.format("%1$tA, %1$td.%1$tm.%1$tY", new Date()));
    }
}
