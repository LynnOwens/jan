package net.tofweb.jann.measurement;

import java.math.BigDecimal;

public class MicroMeterSquared {

	private BigDecimal microMeters;

	public MicroMeterSquared(BigDecimal microMeters) {
		super();
		this.microMeters = microMeters;
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
		MicroMeterSquared other = (MicroMeterSquared) obj;
		if (microMeters == null) {
			if (other.microMeters != null)
				return false;
		} else if (!microMeters.equals(other.microMeters))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MicroMeterSquared [microMeters=" + microMeters + "]";
	}
	
}
