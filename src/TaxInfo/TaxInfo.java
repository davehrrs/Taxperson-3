package TaxInfo;

public class TaxInfo {
	public enum TaxType {
		//TaxType(TaxRate in percentage)
		BASIC(1),
		LUXURY(9);
	
		TaxType(int rate) {
			this.rate = rate;
		}
		
		private int rate;
		
		private int getRate() {
			return rate;
		}
	};

	private TaxType taxType = TaxType.BASIC;
	
	public int getTaxRate() {
		return taxType.getRate();
	}

	public TaxType getTaxType() {
		return taxType;
	}
	
	public void setTaxType(TaxType type) {
		this.taxType = type;
	}
	
	public int calculateTax(int price) {
		int taxInPercentagePoints = price * taxType.getRate();
		int tax = taxInPercentagePoints / 100;
		int taxCorrectionInPercentagePoints = taxInPercentagePoints % 100;

		// This implements bankers Rounding
		if ((tax % 2) == 1) {
			if (taxCorrectionInPercentagePoints > 49) { 
				++tax;
			}
		} else {
			if (taxCorrectionInPercentagePoints > 50) { 
				++tax;
			}
		}
		return tax;
	}
	
	public int calculateTotalCost(int price) {
		return price + calculateTax(price);
	}
}
