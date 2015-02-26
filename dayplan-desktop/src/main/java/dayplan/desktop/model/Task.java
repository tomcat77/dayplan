package dayplan.desktop.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

/**
 * @author vmuravlev
 */
public class Task {
    private StringProperty title;
    private ObjectProperty<TaskStatus> status;
    private ObjectProperty<Date> dueDate;

    public Task() {
        this.title = new SimpleStringProperty();
        this.status = new SimpleObjectProperty<>();
        this.dueDate = new SimpleObjectProperty<>();
    }

    public Task(String title) {
        this();
        this.setTitle(title);
        this.setStatus(TaskStatus.UNCOMPLETED);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public TaskStatus getStatus() {
        return status.get();
    }

    public ObjectProperty<TaskStatus> statusProperty() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status.set(status);
    }

    public Date getDueDate() {
        return dueDate.get();
    }

    public ObjectProperty<Date> dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate.set(dueDate);
    }
}