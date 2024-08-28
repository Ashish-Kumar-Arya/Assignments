package bdp;

import java.util.ArrayList;
import java.util.List;

interface PaymentGateway {
	public void payment(double amt);
}

class CreditCard implements PaymentGateway
{

	private int cardNo;
	
	private String name;
	
	public CreditCard(int cardNo, String name) {
		this.cardNo = cardNo;
		this.name = name;
	}

	public void payment(double amt) {
		System.out.println("Payment done by Credit Card "+amt);
		
	}
	
	@Override
	public String toString() {
		return "CreditCard{"+"cardNo="+cardNo+",name="+name+'}';
	}
	
}

class CashOnDelivery implements PaymentGateway {
	private String address;
	
	public CashOnDelivery(String address) {
		this.address = address;
	}

	public void payment(double amt) {
		System.out.println("Payment through Cash on Delivery " + amt);
	}
	
	@Override
	public String toString() {
		return "CashOnDelivery{"+"address="+address+'}';
	}
}

class Shopping {
	private List<Product> l1;
	
	public Shopping() {
		l1=new ArrayList<>();
	}
	
	
	public void addProduct(Product p) {
		l1.add(p);
	}
	
	public void removeProduct(Product p) {
		l1.remove(p);
	}
	
	public double calculatePrice(){
		return l1.stream().mapToDouble(Product::getpPrice).sum();
	}
	
	public void pay(PaymentGateway paymentMethod) {
		double price = calculatePrice();
		System.out.println(paymentMethod);
		paymentMethod.payment(price);
	}
}

public class Strategy {
	public static void main(String[] args) {
		Shopping bag=new Shopping();
		Product p1=new Product("1111", 200.00);
		Product p2=new Product("2222", 400.00);
		bag.addProduct(p1);
		bag.addProduct(p2);
		bag.pay(new CashOnDelivery("Delhi"));
		bag.pay(new CreditCard(12345, "Ashish"));
		
	}
}
