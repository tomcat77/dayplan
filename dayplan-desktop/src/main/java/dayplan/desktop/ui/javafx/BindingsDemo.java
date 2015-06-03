package dayplan.desktop.ui.javafx;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.When;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author vmuravlev
 */
public class BindingsDemo {
    public static void main(String[] args) {
        BooleanProperty task1Complete = new SimpleBooleanProperty(false);
        BooleanProperty task2Complete = new SimpleBooleanProperty(false);
        BooleanProperty task3Complete = new SimpleBooleanProperty(false);

        NumberBinding completeQty = new SimpleIntegerProperty(0)
                .add(new When(task1Complete).then(1).otherwise(0))
                .add(new When(task2Complete).then(1).otherwise(0))
                .add(new When(task3Complete).then(1).otherwise(0));

        completeQty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                System.out.printf("Complete qty was %s, now is %s\n", oldValue, newValue);
            }
        });

        task1Complete.set(true);
        task2Complete.set(true);
        task3Complete.set(true);

        task2Complete.set(false);
    }
}