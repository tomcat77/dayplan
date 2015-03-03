package dayplan.desktop.model;

import javafx.beans.property.*;

/**
 * @author vmuravlev
 */
public class RoutineJournal {
    private StringProperty routineTitle;
    private IntegerProperty iterations;

    public RoutineJournal(Routine r) {
        this.routineTitle = new SimpleStringProperty(r.getTitle());
        this.iterations = new SimpleIntegerProperty(0);
    }

    public String getRoutine() {
        return routineTitle.get();
    }

    public StringProperty routineTitleProperty() {
        return routineTitle;
    }

    public void setRoutineTitle(String title) { }

    public int getIterations() {
        return iterations.get();
    }

    public IntegerProperty iterationsProperty() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations.set(iterations);
    }
}