package dayplan.desktop.ui;

import dayplan.desktop.ui.model.Task;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author vmuravlev
 */
public class BeanBindingDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Task task = new Task("Call mom");

        JavaBeanStringPropertyBuilder stringPropertyBuilder = JavaBeanStringPropertyBuilder.create();
        StringProperty titleProperty = stringPropertyBuilder.bean(task).name("title").build();

        System.out.printf("Title before: %s\n", task.getTitle());

        titleProperty.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                System.out.printf("Title changed from '%s' to '%s'\n", oldValue, newValue);
            }
        });

        titleProperty.set("Water plants");

        System.out.printf("Title after: %s\n", task.getTitle());
    }
}