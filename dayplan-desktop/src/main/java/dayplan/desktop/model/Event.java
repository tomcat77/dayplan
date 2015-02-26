package dayplan.desktop.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

/**
 * @author vmuravlev
 */
public class Event {
    private StringProperty title;
    private ObjectProperty<Date> dueDate;

    public Event() {
        this.title = new SimpleStringProperty();
        this.dueDate = new SimpleObjectProperty<>();
    }

    public Event(String title, Date dueDate) {
        this();
        this.setTitle(title);
        this.setDueDate(dueDate);
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