package dayplan.desktop.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

/**
 * @author vmuravlev
 */
public class Note {
    private StringProperty text;
    private ObjectProperty<Date> createdAt;

    public Note(String text) {
        this();
        this.setText(text);
    }

    public Note() {
        this.text = new SimpleStringProperty();
        this.createdAt = new SimpleObjectProperty<>(new Date());
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

    public Date getCreatedAt() {
        return createdAt.get();
    }

    public ObjectProperty<Date> createdAtProperty() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt.set(createdAt);
    }
}