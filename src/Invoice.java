import java.text.NumberFormat;

public class Invoice {

	private InvoiceItem[] items;
	private double taxableSubtotal;
	private double untaxableSubtotal;
	private double tax;
	private double taxRate;
	private double grandTotal;
	
	//Constructors
	public Invoice()
	{
		taxRate = 0;//set to no tax by default
	}
	public Invoice(InvoiceItem[] items_, double taxRate_)
	{
		items = items_;
		taxRate = taxRate_;
		setTotals();
		
	}
	public Invoice(InvoiceItem[] items_)
	{
		items = items_;
		taxRate = 0;//set to no tax by default
		setTotals();
		
	}
	//end Constructors
	
	//Getters
	public InvoiceItem[] getItems()
	{
		return items;
	}
	public double getTaxableSubtotal()
	{
		return taxableSubtotal;
	}
	public double getUntaxableSubtotal()
	{
		return untaxableSubtotal;
	}
	public double getTax()
	{
		return tax;
	}
	public double getTaxRate()
	{
		return taxRate;
	}
	public double getGrandTotal()
	{
		return grandTotal;
	}
	//end Getters
	
	//Setters
	public void setItems(InvoiceItem[] items_)
	{
		items = items_;
		setTotals();
	}
	public void setTaxRate(double taxRate_)
	{
		taxRate = taxRate_;
		setTotals();
	}
	//end Setters
	
	//other methods
	/*
	 * add one InvoiceItem, making the array of InvoiceItems one larger
	 */
	public void addItem(InvoiceItem item)
	{
		InvoiceItem[] temp = new InvoiceItem[items.length + 1];
		for(int i = 0; i < items.length; i++)
		{
			temp[i] = new InvoiceItem(items[i].getPrice(), items[i].getTaxable());
		}
		temp[items.length] = new InvoiceItem(item.getPrice(), item.getTaxable());
		items = temp;
		setTotals();
	}
	private void setTotals()
	{
		untaxableSubtotal = 0;
		taxableSubtotal = 0;
		for(int i = 0; i < items.length; i++)
		{
			if(items[i].getTaxable())
			{
				taxableSubtotal += items[i].getPrice();
			}
			else
			{
				untaxableSubtotal += items[i].getPrice();
			}
		}
		tax = taxableSubtotal * taxRate;
		grandTotal = untaxableSubtotal + taxableSubtotal + tax;
	}
	public String getDisplayText()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String displayText = "Price\tTaxable\n";
		for(InvoiceItem item: items)
		{
			displayText += currency.format(item.getPrice()) ;
			displayText += "\t";
			if(item.getTaxable())
			{
				displayText += "yes";
			}
			else
			{
				displayText += "no";
			}
			displayText += "\n";
		}
		displayText += "---------------------------------\n";
		displayText += "taxable subtotal: " + currency.format(taxableSubtotal) +
				"\nuntaxable subtotal: " + currency.format(untaxableSubtotal) + 
				"\ntax: " + currency.format(tax) + 
				"\nGrand Total: " + currency.format(grandTotal);
		return displayText;
	}
}
