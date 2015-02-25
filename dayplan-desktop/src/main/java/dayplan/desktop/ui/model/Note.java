package dayplan.desktop.ui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author vmuravlev
 */
public class Note {
    private StringProperty text;

    public Note(String text) {
        this();
        this.setText(text);
    }

    public Note() {
        this.text = new SimpleStringProperty();
    }

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }
}