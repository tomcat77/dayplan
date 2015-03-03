package dayplan.desktop.ui;

import dayplan.desktop.model.Event;
import dayplan.desktop.model.Task;
import dayplan.desktop.model.TaskStatus;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vmuravlev
 */
public class Cells {
    static class TaskStatusCell extends TableCell<Task, TaskStatus> {

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

    static class EventTimeCell extends TableCell<Event, Date> {

        private DateFormat dateFormat = new SimpleDateFormat("HH:mm");

        @Override
        protected void updateItem(Date date, boolean empty) {
            super.updateItem(date, empty);

            if (!empty) {
                setText(dateFormat.format(date));
            }

        }
    }
}
