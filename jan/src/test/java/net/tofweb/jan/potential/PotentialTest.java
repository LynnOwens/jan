package net.tofweb.jan.potential;

import java.math.BigDecimal;

import org.junit.Test;

import net.tofweb.jan.exception.PhysicsException;
import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MilliAmpere;
import net.tofweb.jan.measurement.MilliVolt;

public class PotentialTest {

	@Test
	public void testOhmsLaw() {
		new Potential(new MilliVolt(new BigDecimal("15000")), new MilliAmpere(new BigDecimal("5000")),
				new KilohmPerCentimeterSquared(new BigDecimal(".003")));

		new Potential(new MilliVolt(new BigDecimal("15000")), new KilohmPerCentimeterSquared(new BigDecimal(".003")));
	}

	@Test(expected = PhysicsException.class)
	public void testViolationOfOhmsLaw() {
		new Potential(new MilliVolt(new BigDecimal("1")), new MilliAmpere(new BigDecimal("1")),
				new KilohmPerCentimeterSquared(new BigDecimal("1")));
	}

}
