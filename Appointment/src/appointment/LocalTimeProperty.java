package appointment;

import javafx.beans.property.ObjectPropertyBase;

import java.io.Serializable;
import java.time.LocalTime;

/** Created by GuoJunjun <junjunguo.com> on 01/02/15. */

public class LocalTimeProperty extends ObjectPropertyBase<LocalTime> implements Serializable {
    @Override
    public Object getBean() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
