package dayplan.desktop.ui.model;

import javafx.beans.property.*;

/**
 * @author vmuravlev
 */
public class Routine {
    private StringProperty title;
    private BooleanProperty complete;
    private IntegerProperty repeatQty;

    public Routine() {
        this.title = new SimpleStringProperty();
        this.complete = new SimpleBooleanProperty();
        this.repeatQty = new SimpleIntegerProperty();
    }

    public Routine(String title) {
        this();
        this.setTitle(title);
        this.setRepeatQty(3);
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

    public boolean getComplete() {
        return complete.get();
    }

    public BooleanProperty completeProperty() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete.set(complete);
    }

    public int getRepeatQty() {
        return repeatQty.get();
    }

    public IntegerProperty repeatQtyProperty() {
        return repeatQty;
    }

    public void setRepeatQty(int repeatQty) {
        this.repeatQty.set(repeatQty);
    }
}