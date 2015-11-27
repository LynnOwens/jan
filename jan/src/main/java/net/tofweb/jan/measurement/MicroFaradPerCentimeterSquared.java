package net.tofweb.jan.measurement;

import java.math.BigDecimal;

public class MicroFaradPerCentimeterSquared {

	private BigDecimal microFarads;

	public MicroFaradPerCentimeterSquared(BigDecimal microFarads) {
		super();
		this.microFarads = microFarads;
	}

	public BigDecimal getMicroFarads() {
		return microFarads;
	}

	public void setMicroFarads(BigDecimal microFarads) {
		this.microFarads = microFarads;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((microFarads == null) ? 0 : microFarads.hashCode());
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
		MicroFaradPerCentimeterSquared other = (MicroFaradPerCentimeterSquared) obj;
		if (microFarads == null) {
			if (other.microFarads != null)
				return false;
		} else if (!microFarads.equals(other.microFarads))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MicroFaradPerCentimeterSquared [uF / cm2 = " + microFarads + "]";
	}

}
