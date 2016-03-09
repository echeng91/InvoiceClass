
public class InvoiceItem {

	private double price;
	private boolean taxable;
	
	//Constructors
	public InvoiceItem()
	{
		
	}
	public InvoiceItem(double price_, boolean taxable_)
	{
		price = price_;
		taxable = taxable_;
	}
	public InvoiceItem(double price_)
	{
		price = price_;
	}
	//end Constructors
	
	//Getters
	public double getPrice()
	{
		return price;
	}
	public boolean getTaxable()
	{
		return taxable;
	}
	//end Getters
	
	//Setters
	public void setPrice(double price_)
	{
		price = price_;
	}
	public void setTaxable(boolean taxable_)
	{
		taxable = taxable_;
	}
}
