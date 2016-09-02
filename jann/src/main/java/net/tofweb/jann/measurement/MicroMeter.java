package net.tofweb.jann.measurement;

import java.math.BigDecimal;

public class MicroMeter {

	private BigDecimal microMeters;

	public MicroMeter(BigDecimal microMeters) {
		super();
		this.microMeters = microMeters;
	}
	
	public MicroMeterSquared square() {
		BigDecimal um = getMicroMeters();
		return new MicroMeterSquared(um.multiply(um));
	}

	public BigDecimal getMicroMeters() {
		return microMeters;
	}

	public void setMicroMeters(BigDecimal microMeters) {
		this.microMeters = microMeters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((microMeters == null) ? 0 : microMeters.hashCode());
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
		MicroMeter other = (MicroMeter) obj;
		if (microMeters == null) {
			if (other.microMeters != null)
				return false;
		} else if (!microMeters.equals(other.microMeters))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MicroMeter [um =" + microMeters + "]";
	}

}
