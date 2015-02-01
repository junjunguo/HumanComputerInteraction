package appointment;

import javafx.beans.property.ObjectPropertyBase;

import java.io.Serializable;
import java.time.LocalDate;

/** Created by GuoJunjun <junjunguo.com> on 01/02/15. */

public class LocalDateProperty extends ObjectPropertyBase<LocalDate> implements Serializable {

    @Override
    public Object getBean() {
        return this;
    }

    @Override
    public String getName() {
        return "dato";
    }
}
