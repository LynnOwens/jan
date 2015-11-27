package net.tofweb.jan.measurement;

import java.math.BigDecimal;

public class MilliVolt {

	private BigDecimal millivolts;

	public MilliVolt(BigDecimal millivolts) {
		super();
		this.millivolts = millivolts;
	}

	public BigDecimal getMillivolts() {
		return millivolts;
	}

	public BigDecimal getVolts() {
		return millivolts.divide(new BigDecimal("1000"));
	}

	public void setMillivolts(BigDecimal millivolts) {
		this.millivolts = millivolts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((millivolts == null) ? 0 : millivolts.hashCode());
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
		MilliVolt other = (MilliVolt) obj;
		if (millivolts == null) {
			if (other.millivolts != null)
				return false;
		} else if (!millivolts.equals(other.millivolts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MilliVolts [millivolts=" + millivolts + "]";
	}

}
