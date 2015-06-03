package dayplan.desktop.ui.javafx;

import dayplan.desktop.model.Note;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * @author vmuravlev
 */
public class NoteListCellFactory implements Callback<ListView<Note>, ListCell<Note>> {

    @Override
    public ListCell<Note> call(ListView<Note> noteListView) {
        return new NoteListCell();
    }

    private static class NoteListCell extends ListCell<Note> {

        @Override
        protected void updateItem(Note note, boolean empty) {
            super.updateItem(note, empty);
            if (note != null) {
                setText(String.format("%1$tH:%1$tM  %2$s", note.getCreatedAt(), note.getText()));
            }
        }
    }
}
