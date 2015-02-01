package GreenAppointment;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Når en serialiserer et objekt, dvs. gjør det om til en sekvens med bytes, så må også alle felt være serialiserbare.
 * Feltene som knyttet til tid er av typer som ikke markert som serialiserbart, siden det er en såkalt anonym
 * indreklasse. Denne klassen må defineres som egen klasse utenfor Appointment og implementere Serializable. Du kan
 * f.eks. kalle dem ene LocalDateProperty, la den utvide (med extends) ObjectPropertyBase<LocalDate> og flytte metodene
 * dit. Tilsvarende for LocalTime-property-ene.
 */
public class Appointment implements Serializable {
    private MySimpleStringProperty formalProperty = new MySimpleStringProperty();
    private MySimpleStringProperty romProperty = new MySimpleStringProperty();
    private MySimpleIntegerProperty repetisjonProperty = new MySimpleIntegerProperty();
    private LocalDateProperty datoProperty = new LocalDateProperty();
    //            new ObjectPropertyBase<LocalDate>(null) {

    //        @Override
    //        public Object getBean() {
    //            return this;
    //        }
    //
    //        @Override
    //        public String getName() {
    //            return "dato";
    //        }
    //    };
    private LocalTimeProperty fraProperty = new LocalTimeProperty() {
        //            new ObjectPropertyBase<LocalTime>(null) {

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "fra";
        }
    };
    private LocalTimeProperty tilProperty = new LocalTimeProperty() {
        //            new ObjectPropertyBase<LocalTime>(null) {

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "til";
        }
    };
    private LocalDateProperty sluttProperty = new LocalDateProperty() {
        //            new ObjectPropertyBase<LocalDate>(null) {

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "slutt";
        }
    };

    public String getFormal() {
        return formalProperty.getValue();
    }

    public void setFormal(String formal) {
        formalProperty.setValue(formal);
    }

    public StringProperty formalProperty() {
        return formalProperty;
    }

    public String getRom() {
        return romProperty.getValue();
    }

    public void setRom(String rom) {
        romProperty.setValue(rom);
    }

    public StringProperty romProperty() {
        return romProperty;
    }

    public LocalDate getDato() {
        return datoProperty.getValue();
    }

    public void setDato(LocalDate dato) {
        datoProperty.setValue(dato);
    }

    public Property<LocalDate> DatoProperty() {
        return datoProperty;
    }

    public LocalTime getFra() {
        return fraProperty.getValue();
    }

    public void setFra(LocalTime fra) {
        fraProperty.setValue(fra);
    }

    public Property<LocalTime> fraProperty() {
        return fraProperty;
    }

    public LocalTime getTil() {
        return tilProperty.getValue();
    }

    public void setTil(LocalTime til) {
        tilProperty.setValue(til);
    }

    public Property<LocalTime> tilProperty() {
        return tilProperty;
    }

    public Integer getRepetisjon() {
        return repetisjonProperty.getValue();
    }

    public void setRepetisjon(Integer repetisjon) {
        repetisjonProperty.setValue(repetisjon);
    }

    public IntegerProperty repetisjonProperty() {
        return repetisjonProperty;
    }

    public LocalDate getSlutt() {
        return sluttProperty.getValue();
    }

    public void setSlutt(LocalDate slutt) {
        sluttProperty.setValue(slutt);
    }

    public Property<LocalDate> sluttProperty() {
        return sluttProperty;
    }

    @Override
    public String toString() {
        return "Appointment{" +
               "formalProperty=" + getFormal() +
               ", romProperty=" + getRom() +
               ", repetisjonProperty=" + getRepetisjon() +
               ", datoProperty=" + getDato() +
               ", fraProperty=" + getFra() +
               ", tilProperty=" + getTil() +
               ", sluttProperty=" + getSlutt() +
               '}';
    }
}
