package dayplan.desktop.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;

/**
 * @author vmuravlev
 */
public class DayPlan {
    private ObjectProperty<Date> date;

    private ObservableList<Task> taskList;
    private ListProperty<Task> tasks;

    private ObservableList<Event> eventList;
    private ListProperty<Event> events;

    private ObservableList<Routine> routineList;
    private ListProperty<Routine> routines;

    private ObservableList<Note> noteList;
    private ListProperty<Note> notes;

    public DayPlan() {
        taskList = FXCollections.observableArrayList();
        tasks = new SimpleListProperty<>(taskList);

        eventList = FXCollections.observableArrayList();
        events = new SimpleListProperty<>(eventList);

        routineList = FXCollections.observableArrayList();
        routines = new SimpleListProperty<>(routineList);

        noteList = FXCollections.observableArrayList();
        notes = new SimpleListProperty<>(noteList);

        date = new SimpleObjectProperty<>(new Date());
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

    public ObservableList<Task> getTasks() {
        return tasks.get();
    }

    public ListProperty<Task> tasksProperty() {
        return tasks;
    }

    public void setTasks(ObservableList<Task> tasks) {
        this.tasks.set(tasks);
    }

    public ObservableList<Event> getEvents() {
        return events.get();
    }

    public ListProperty<Event> eventsProperty() {
        return events;
    }

    public void setEvents(ObservableList<Event> events) {
        this.events.set(events);
    }

    public ObservableList<Routine> getRoutines() {
        return routines.get();
    }

    public ListProperty<Routine> routinesProperty() {
        return routines;
    }

    public void setRoutines(ObservableList<Routine> routines) {
        this.routines.set(routines);
    }

    public ObservableList<Note> getNotes() {
        return notes.get();
    }

    public ListProperty<Note> notesProperty() {
        return notes;
    }

    public void setNotes(ObservableList<Note> notes) {
        this.notes.set(notes);
    }

    public static DayPlan createSample() {
        DayPlan dayPlan = new DayPlan();

        dayPlan.taskList.add(new Task("Water plants"));
        dayPlan.taskList.add(new Task("Go to gym"));

        dayPlan.eventList.add(new Event("Status meeting", new Date()));
        dayPlan.eventList.add(new Event("Lunch with Ann", new Date()));

        dayPlan.noteList.add(new Note("Daniel promised to complete report at 16:00"));
        dayPlan.noteList.add(new Note("Buy flowers for Gabriela"));

        dayPlan.routineList.add(new Routine("Eyes"));
        dayPlan.routineList.add(new Routine("Back"));
        dayPlan.routineList.add(new Routine("Push-ups"));

        return dayPlan;
    }

    public void addNote(String text) {
        this.noteList.add(new Note(text));
    }
}