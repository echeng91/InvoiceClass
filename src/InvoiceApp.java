import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Invoice invoice;
		InvoiceItem item;
		double price;
		boolean taxable;
		boolean continueChoice;
		
		double taxRate = inputTaxRate(sc);
		price = inputPrice(sc);
		taxable = inputYesOrNo(sc, "Is this item taxable?");
		item = new InvoiceItem(price, taxable);
		InvoiceItem[] itemsSeed = {item};
		invoice = new Invoice(itemsSeed, taxRate);
		
		continueChoice = inputYesOrNo(sc, "Add another item?");
		while(continueChoice)
		{
			price = inputPrice(sc);
			taxable = inputYesOrNo(sc, "Is this item taxable?");
			item = new InvoiceItem(price, taxable);
			invoice.addItem(item);
			continueChoice = inputYesOrNo(sc, "Add another item?");
		}
		
		System.out.println(invoice.getDisplayText());
		sc.close();
	}
	
	public static double inputTaxRate(Scanner sc)
	{
		double taxRate = -1.23;
		
		System.out.print("Input tax rate: ");
		while(taxRate == -1.23)
		{
			try
			{
				taxRate = sc.nextDouble();
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.print("Invalid Input. Input numerical value for tax rate: ");
			}
			finally
			{
				sc.nextLine();
			}
		}
		
		return taxRate;
	}
	
	public static double inputPrice(Scanner sc)
	{
		double price = -1.23;
		
		System.out.print("Input price: ");
		while(price == -1.23)
		{
			try
			{
				price = sc.nextDouble();
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.print("Invalid Input. Input numerical value for price: ");
			}
			finally
			{
				sc.nextLine();
			}
		}
		return price;
	}
	
	public static boolean inputYesOrNo(Scanner sc, String prompt)
	{
		String choice = "";
		boolean YNtoTF = false;
		
		while(!choice.equalsIgnoreCase("yes") 
				&& !choice.equalsIgnoreCase("y")
				&& !choice.equalsIgnoreCase("no")
				&& !choice.equalsIgnoreCase("n"))
		{
			System.out.print(prompt + "(yes/no): ");
			choice = sc.nextLine();
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y"))
			{
				YNtoTF = true;
			}
			else if(choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n"))
			{
				YNtoTF = false;
			}
			else
			{
				System.out.print("Invalid Input. ");
			}
		}
		return YNtoTF;
	}
}
