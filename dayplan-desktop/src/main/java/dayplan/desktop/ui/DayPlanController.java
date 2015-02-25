package dayplan.desktop.ui;

import dayplan.desktop.ui.model.DayPlan;
import dayplan.desktop.ui.model.Note;
import dayplan.desktop.ui.model.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author vmuravlev
 */
public class DayPlanController implements Initializable {

    @FXML
    private Label todayLabel;

    @FXML
    private TableView<Task> tasksTable;

    @FXML
    private ListView<Note> notesList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todayLabel.setText(String.format("%1$tA, %1$td.%1$tm.%1$tY", new Date()));

        showPlan(DayPlan.createSample());
    }

    public void showPlan(DayPlan dayPlan) {
//        todayLabel.textProperty().bind(dayPlan.dateProperty().);

        notesList.setItems(dayPlan.notesProperty());
        tasksTable.setItems(dayPlan.getTasks());
    }
}