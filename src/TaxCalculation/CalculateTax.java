package TaxCalculation;

import TaxInfo.TaxInfo;

public class CalculateTax {

	public static void main(String[] args) {
		String itemName = "Basic Item";
		
		TaxInfo taxInfo = new TaxInfo();
		taxInfo.setTaxType(TaxInfo.TaxType.BASIC);
		
		int price = 500;
		int tax = taxInfo.calculateTax(price);
		int totalCost = taxInfo.calculateTotalCost(price);
		
		System.out.println("Item: " + itemName);
		System.out.println("Price in cents: " + price);
		System.out.println("Tax in cents: " + tax);
		System.out.println("Total price in cents: " + totalCost + "\n");
		
		itemName = "Luxury Item";
		
		taxInfo.setTaxType(TaxInfo.TaxType.LUXURY);
		
		price = 500;
		tax = taxInfo.calculateTax(price);
		totalCost = taxInfo.calculateTotalCost(price);
		
		System.out.println("Item: " + itemName);
		System.out.println("Price in cents: " + price);
		System.out.println("Tax in cents: " + tax);
		System.out.println("Total price in cents: " + totalCost + "\n");
	}

}
