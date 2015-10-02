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

		// This implements Bankers Rounding
		if ((tax % 2) == 1) {								// Tax is an odd amount
			if (taxCorrectionInPercentagePoints > 49) { 	// Round up anything above 0.49 cents 
				++tax;
			}
		} else {											// Tax is an even amount
			if (taxCorrectionInPercentagePoints > 50) { 	// Round up anything above 0.50 cents 
				++tax;
			}
		}
		return tax;
	}
	
	public int calculateTotalCost(int price) {
		return price + calculateTax(price);
	}
}
