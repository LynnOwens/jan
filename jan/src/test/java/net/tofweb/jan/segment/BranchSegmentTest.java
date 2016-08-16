package net.tofweb.jan.segment;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.measurement.MicroMeterSquared;
import net.tofweb.jan.neuron.ArtificialNeuron;

public class BranchSegmentTest {

	@Test
	public void testSurfaceArea() {
		BigDecimal expectedUm2 = new BigDecimal("471.23889803850");
		
		ArtificialNeuron an = new ArtificialNeuron();
		BranchSegment s = new BranchSegment(an, new BranchSegment(an));
		s.setLength(new MicroMeter(new BigDecimal("10")));
		s.setRadius(new MicroMeter(new BigDecimal("5")));
		MicroMeterSquared um2 = s.getSurfaceArea();
		assertEquals(expectedUm2, um2.getMicroMeters());
	}

}
