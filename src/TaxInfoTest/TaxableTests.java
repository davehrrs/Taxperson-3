package TaxInfoTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import TaxInfo.TaxInfo;

public class TaxableTests {
	private TaxInfo item = null;
	
	@BeforeClass
	public void initialize() {
		item = new TaxInfo();
	}
	
	@Test
	public void DefaultTaxTypeIs1Basic() {

		assert (item.getTaxType() == TaxInfo.TaxType.BASIC);
	}
	
	@Test
	public void DefaultTaxRateIs1() {
		assert (item.getTaxRate() == 1);
	}
	
	@Test
	public void TaxrateIs1ForBasic() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.getTaxRate() == 1);
	}
	
	@Test
	public void TaxrateIs9ForLuxury() {
		item.setTaxType(TaxInfo.TaxType.LUXURY);
		assert (item.getTaxRate() == 9);
	}
	
	@Test
	public void calculateTaxFor100BasicIs1() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.calculateTax(100) == 1);
	}
	
	@Test
	public void calculateTaxFor150BasicIs2() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.calculateTax(150) == 2);
	}
	
	@Test
	public void calculateTaxFor200BasicIs2() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.calculateTax(200) == 2);
	}
	
	@Test
	public void calculateTaxFor250BasicIs2() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.calculateTax(250) == 2);
	}
	
	@Test
	public void calculateTaxFor251BasicIs3() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.calculateTax(251) == 3);
	}
	
	@Test
	public void calculateTotalCost251BasicIs254() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.calculateTotalCost(251) == 254);
	}
	
	@Test
	public void calculateTaxFor149LuxuryIs13() {
		item.setTaxType(TaxInfo.TaxType.LUXURY);
		assert (item.calculateTax(149) == 13);
	}

	@Test
	public void calculateTaxFor149BasicIs1() {
		item.setTaxType(TaxInfo.TaxType.BASIC);
		assert (item.calculateTax(149) == 1);
	}
}