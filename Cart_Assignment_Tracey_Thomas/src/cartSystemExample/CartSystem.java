package cartSystemExample;

import java.util.HashMap;
import java.util.Map;


public class CartSystem extends TheSystem {

	public CartSystem() {
		super();
	}



	@Override
	public void display() {
		HashMap<String, Item> map = getItemCollection();
		System.out.println(map.toString());
		double subTotal = 0;
		double tax = 0;
		double total = 0;
		for(Map.Entry<String, Item> s : map.entrySet()) {
			subTotal += s.getValue().getItemPrice()*s.getValue().getAvailableQuantity();
		}
		tax = subTotal*0.05;
		total = subTotal + tax;
		System.out.printf("Subtotal %.2f\n", subTotal);
		System.out.printf("Tax %.2f\n" , tax);
		System.out.printf("Total %.2f\n" , total);
	}



}



