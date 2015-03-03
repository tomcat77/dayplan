package dayplan.desktop.ui;

import dayplan.desktop.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.apache.commons.lang3.StringUtils;

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
    private TableView<Event> eventsTable;

    @FXML
    private ListView<Note> notesList;

    @FXML
    private TableView<RoutineJournal> routinesTable;

    @FXML
    private TextField newNoteTextField;

    private DayPlan currentPlan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todayLabel.setText(String.format("%1$tA, %1$td.%1$tm.%1$tY", new Date()));

        configureEventTable();
        configureTaskTable();
        configureNoteList();
        configureRoutineTable();

        showPlan(DayPlan.createSample());
    }

    private void configureRoutineTable() {
        TableColumn<RoutineJournal, String> titleColumn = new TableColumn<>("Routine");
        titleColumn.setCellValueFactory(new PropertyValueFactory<RoutineJournal, String>("routineTitle"));

        TableColumn<RoutineJournal, Integer> iterationsColumn = new TableColumn<>("Qty");
        iterationsColumn.setCellValueFactory(new PropertyValueFactory<RoutineJournal, Integer>("iterations"));

        routinesTable.getColumns().add(titleColumn);
        routinesTable.getColumns().add(iterationsColumn);
    }

    private void configureEventTable() {
        TableColumn<Event, Date> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<Event, Date>("dueDate"));
        timeColumn.setCellFactory(new Callback<TableColumn<Event, Date>, TableCell<Event, Date>>() {
            @Override
            public TableCell<Event, Date> call(TableColumn<Event, Date> eventDateTableColumn) {
                return new Cells.EventTimeCell();
            }
        });

        TableColumn<Event, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("title"));
        titleColumn.setPrefWidth(350);

        eventsTable.getColumns().add(timeColumn);
        eventsTable.getColumns().add(titleColumn);
    }

    private void configureNoteList() {
        notesList.setCellFactory(new NoteListCellFactory());
    }

    private void configureTaskTable() {
        TableColumn<Task, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setPrefWidth(350);
        titleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));

        TableColumn<Task, TaskStatus> statusColumn = new TableColumn<>();
        statusColumn.setCellValueFactory(new PropertyValueFactory<Task, TaskStatus>("status"));
        statusColumn.setCellFactory(new Callback<TableColumn<Task, TaskStatus>, TableCell<Task, TaskStatus>>() {
            @Override
            public TableCell<Task, TaskStatus> call(TableColumn<Task, TaskStatus> taskTaskStatusTableColumn) {
                return new Cells.TaskStatusCell();
            }
        });

        tasksTable.getColumns().add(statusColumn);
        tasksTable.getColumns().add(titleColumn);
    }

    public void showPlan(DayPlan dayPlan) {
        this.currentPlan = dayPlan;

        notesList.setItems(dayPlan.notesProperty());
        tasksTable.setItems(dayPlan.getTasks());
        eventsTable.setItems(dayPlan.getEvents());
        routinesTable.setItems(dayPlan.getRoutines());
    }

    @FXML
    public void onEnterInNoteTextField() {
        String text = newNoteTextField.getText();
        if (StringUtils.isNotEmpty(text)) {
            currentPlan.addNote(text);
            newNoteTextField.setText(StringUtils.EMPTY);
        }
    }

}