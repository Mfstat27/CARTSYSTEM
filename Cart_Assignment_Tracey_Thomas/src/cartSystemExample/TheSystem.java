package cartSystemExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class TheSystem {

	private HashMap<String, Item> itemCollection;

	public TheSystem() {
		itemCollection = new HashMap<String, Item>();
		if(getClass().getSimpleName().equals("AppSystem")) {
			String content = "";
			String[] itemInfo = null;
			try {
				content = new String(Files.readAllBytes(Paths.get
						("/Users/traceythomas/Desktop/eclipse-workspace/Cart_Assignment_Tracey_Thomas/src/sample.txt")));
				itemInfo = content.split("[ \t\\n\\x0B\\f\\r][ \r\n]");
				for(int i=0;i<itemInfo.length;i+=4) {
					itemCollection.put(itemInfo[i], new Item(itemInfo[i],itemInfo[i + 1], Double.parseDouble(itemInfo[i + 2]),Integer.parseInt(itemInfo[i + 3])));
				}
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
	}

	public HashMap<String, Item> getItemCollection() {
		return itemCollection;
	}

	public void setItemCollection(HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}

	public Boolean checkAvailability(Item item) {
		if(item.getAvailableQuantity() == 0 ) {
			System.out.println("Unable to add Item to the cart , no more Items available.");
			return false;
		}else return true;
	}
	
	public Boolean add(Item item) {
		boolean check = checkAvailability(item);	
		CartSystem cart = new CartSystem();
		if(item == null) {
			return false;
		}if(check == false) {
			return false;
		}
		Item fItem = new Item(item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getQuantity());
		if(getItemCollection().remove(item.getItemName(), item)) {
			fItem.setQuantity(fItem.getQuantity()-2);
		}
		if(!itemCollection.containsKey(item.getItemName())) {
			itemCollection.put(item.getItemName(), fItem);
			item.setAvailableQuantity(item.getAvailableQuantity()-1); 
			return true;
		} if(itemCollection.containsKey(item.getItemName())) {
			itemCollection.put(item.getItemName(), fItem);
			item.setAvailableQuantity(item.getAvailableQuantity()-1);
			return true;
		}else return false;
		
	}
	public Item remove(String itemName) {

		Item item = getItemCollection().get(itemName);
		CartSystem cart = new CartSystem();
		if(getItemCollection().containsKey(itemName)) {
			itemCollection.remove(itemName);
			if(cart.getItemCollection().containsKey(itemName)) {
				itemCollection.remove(itemName);
			}
			return item;
		}else return null;
	}

	public abstract void display();
}
