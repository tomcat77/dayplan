package dayplan.desktop.ui.model;

import javafx.beans.property.ObjectProperty;

import java.util.Date;
import java.util.List;

/**
 * @author vmuravlev
 */
public class DayPlan {
    private ObjectProperty<Date> date;
    private List<Task> tasks;
    private List<Event> events;
    private List<Routine> routines;
    private List<Note> notes;

    public DayPlan() {
    }

    public Date getDate() {
        return date.get();
    }

    public ObjectProperty<Date> dateProperty() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }
}