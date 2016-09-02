package net.tofweb.jann.measurement;

import java.math.BigDecimal;

public class MilliAmpere {

	private BigDecimal milliamperes;

	public MilliAmpere(BigDecimal milliamperes) {
		super();
		this.milliamperes = milliamperes;
	}

	public BigDecimal getMilliamperes() {
		return milliamperes;
	}

	public BigDecimal getAmperes() {
		return milliamperes.divide(new BigDecimal("1000"));
	}

	public void setMilliamperes(BigDecimal milliamperes) {
		this.milliamperes = milliamperes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((milliamperes == null) ? 0 : milliamperes.hashCode());
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
		MilliAmpere other = (MilliAmpere) obj;
		if (milliamperes == null) {
			if (other.milliamperes != null)
				return false;
		} else if (!milliamperes.equals(other.milliamperes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MilliAmperes [milliamperes=" + milliamperes + "]";
	}

}
