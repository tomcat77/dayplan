package dayplan.desktop.ui;

import dayplan.desktop.model.DayPlan;
import dayplan.desktop.model.Note;
import dayplan.desktop.model.Task;
import dayplan.desktop.model.TaskStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ListView<Note> notesList;

    @FXML
    private TextField newNoteTextField;

    private DayPlan currentPlan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todayLabel.setText(String.format("%1$tA, %1$td.%1$tm.%1$tY", new Date()));

        configureTaskTable();
        configureNoteList();

        showPlan(DayPlan.createSample());
    }

    private void configureNoteList() {
        notesList.setCellFactory(new NoteListCellFactory());
    }

    private void configureTaskTable() {
        TableColumn<Task, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));

        TableColumn<Task, TaskStatus> statusColumn = new TableColumn<>();
        statusColumn.setCellValueFactory(new PropertyValueFactory<Task, TaskStatus>("status"));
        statusColumn.setCellFactory(new Callback<TableColumn<Task, TaskStatus>, TableCell<Task, TaskStatus>>() {
            @Override
            public TableCell<Task, TaskStatus> call(TableColumn<Task, TaskStatus> taskTaskStatusTableColumn) {
                return new TaskStatusCell();
            }
        });

        tasksTable.getColumns().add(statusColumn);
        tasksTable.getColumns().add(titleColumn);
    }

    public void showPlan(DayPlan dayPlan) {
        this.currentPlan = dayPlan;

        notesList.setItems(dayPlan.notesProperty());
        tasksTable.setItems(dayPlan.getTasks());
    }

    @FXML
    public void onEnterInNoteTextField() {
        String text = newNoteTextField.getText();
        if (StringUtils.isNotEmpty(text)) {
            currentPlan.addNote(text);
            newNoteTextField.setText(StringUtils.EMPTY);
        }
    }

    private static class TaskStatusCell extends TableCell<Task, TaskStatus> {

        private static final Image COMPLETE_ICON = new Image("icons/checkbox.png");
        private static final Image UNCOMPLETED_ICON = new Image("icons/bullet_square_grey.png");
        private static final Image WAITING_ICON = new Image("icons/warning.png");
        private static final Image REJECTED_ICON = new Image("icons/forbidden.png");

        @Override
        public void updateItem(TaskStatus taskStatus, boolean empty) {
            super.updateItem(taskStatus, empty);

            if (empty) {
                return;
            }

            ImageView imageView = new ImageView();
            switch (taskStatus) {
                case COMPLETE:
                    imageView.setImage(COMPLETE_ICON);
                    break;
                case REJECTED:
                    imageView.setImage(REJECTED_ICON);
                    break;
                case UNCOMPLETED:
                    imageView.setImage(UNCOMPLETED_ICON);
                    break;
                case WAITING:
                    imageView.setImage(WAITING_ICON);
                    break;
            }

            setGraphic(imageView);
        }
    }
}