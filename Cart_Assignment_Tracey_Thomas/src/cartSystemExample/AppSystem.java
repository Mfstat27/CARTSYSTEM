package cartSystemExample;

import java.util.HashMap;

public class AppSystem extends TheSystem {
	public AppSystem() {
		super();
	}

	@Override
	public void display() {
		HashMap<String, Item> map = getItemCollection();
		System.out.println(map.toString());
	}

	@Override
	public Boolean add(Item item) {
		if(item.equals(null)) {
			return false;
		} if(getItemCollection().containsKey(item.getItemName())) {
			System.out.println(item.getItemName() + " is already in the App System.");
			return false;
		} if(!getItemCollection().containsKey(item.getItemName())) {
			HashMap<String,Item> map = getItemCollection();
			map.put(item.getItemName(), new Item(item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getAvailableQuantity()));
			return true;
		} else return false;
	}
}
