package appointment;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appointment {

	private StringProperty formalProperty = new SimpleStringProperty();
	private StringProperty romProperty = new SimpleStringProperty();
	private IntegerProperty repetisjonProperty = new SimpleIntegerProperty();
	private Property<LocalDate> datoProperty = new ObjectPropertyBase<LocalDate>(null) {

		@Override
		public Object getBean() {
			return this;
		}

		@Override
		public String getName() {
			return "dato";
		}
	};
	private Property<LocalTime> fraProperty = new ObjectPropertyBase<LocalTime>(null) {

		@Override
		public Object getBean() {
			return this;
		}

		@Override
		public String getName() {
			return "fra";
		}
	};
	private Property<LocalTime> tilProperty = new ObjectPropertyBase<LocalTime>(null) {

		@Override
		public Object getBean() {
			return this;
		}

		@Override
		public String getName() {
			return "til";
		}
	};
	private Property<LocalDate> sluttProperty = new ObjectPropertyBase<LocalDate>(null) {

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

}
