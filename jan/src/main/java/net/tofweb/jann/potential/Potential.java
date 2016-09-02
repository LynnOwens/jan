package net.tofweb.jann.potential;

import java.math.BigDecimal;

import net.tofweb.jann.exception.PhysicsException;
import net.tofweb.jann.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jann.measurement.MilliAmpere;
import net.tofweb.jann.measurement.MilliVolt;

public class Potential {

	private MilliVolt voltage;
	private MilliAmpere amperage;
	private KilohmPerCentimeterSquared kilohms;

	public Potential(MilliVolt voltage, MilliAmpere amperage, KilohmPerCentimeterSquared resistance) {
		super();

		applyOhmsLaw(voltage, amperage, resistance);

		this.voltage = voltage;
		this.amperage = amperage;
		this.kilohms = resistance;
	}

	public Potential(MilliVolt voltage, KilohmPerCentimeterSquared resistance) {
		BigDecimal amperes = voltage.getVolts().divide(resistance.getOhms());
		MilliAmpere amperage = new MilliAmpere(amperes.multiply(new BigDecimal("1000")));
		applyOhmsLaw(voltage, amperage, resistance);

		this.voltage = voltage;
		this.amperage = amperage;
		this.kilohms = resistance;
	}

	private void applyOhmsLaw(MilliVolt voltage, MilliAmpere amperage, KilohmPerCentimeterSquared resistance) {
		if (!amperage.getAmperes().equals(voltage.getVolts().divide(resistance.getOhms()))) {
			throw new PhysicsException("Violation of Ohms Law, amps do not equal volts divided by ohms");
		}
	}

	public MilliVolt getVoltage() {
		return voltage;
	}

	public void setVoltage(MilliVolt milivolts) {
		this.voltage = milivolts;
	}

	public MilliAmpere getMilliamps() {
		return amperage;
	}

	public void setMilliamps(MilliAmpere miliamps) {
		this.amperage = miliamps;
	}

	public KilohmPerCentimeterSquared getKilohms() {
		return kilohms;
	}

	public void setKilohms(KilohmPerCentimeterSquared kilohms) {
		this.kilohms = kilohms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kilohms == null) ? 0 : kilohms.hashCode());
		result = prime * result + ((amperage == null) ? 0 : amperage.hashCode());
		result = prime * result + ((voltage == null) ? 0 : voltage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Potential other = (Potential) obj;
		if (kilohms == null) {
			if (other.kilohms != null)
				return false;
		} else if (!kilohms.equals(other.kilohms))
			return false;
		if (amperage == null) {
			if (other.amperage != null)
				return false;
		} else if (!amperage.equals(other.amperage))
			return false;
		if (voltage == null) {
			if (other.voltage != null)
				return false;
		} else if (!voltage.equals(other.voltage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Potential [voltage=" + voltage + ", miliamps=" + amperage + ", kilohms=" + kilohms + "]";
	}

}
