package net.tofweb.jann.measurement;

import java.math.BigDecimal;

public class KilohmPerCentimeterSquared {

	private BigDecimal kilohms;

	public KilohmPerCentimeterSquared(Integer kilohms) {
		super();
		this.kilohms = new BigDecimal(kilohms);
	}

	public KilohmPerCentimeterSquared(BigDecimal kilohms) {
		super();
		this.kilohms = kilohms;
	}

	public BigDecimal getKilohms() {
		return kilohms;
	}

	public BigDecimal getMilliOhms() {
		return kilohms.multiply(new BigDecimal("1000000"));
	}

	public BigDecimal getOhms() {
		return kilohms.multiply(new BigDecimal("1000"));
	}

	public void setKilohms(BigDecimal kiloOhms) {
		this.kilohms = kiloOhms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kilohms == null) ? 0 : kilohms.hashCode());
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
		KilohmPerCentimeterSquared other = (KilohmPerCentimeterSquared) obj;
		if (kilohms == null) {
			if (other.kilohms != null)
				return false;
		} else if (!kilohms.equals(other.kilohms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KilohmPerCentimeterSquared [kΩ / cm2 = " + kilohms + "]";
	}

}
