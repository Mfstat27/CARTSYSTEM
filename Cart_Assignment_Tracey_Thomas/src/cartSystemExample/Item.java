package cartSystemExample;

public class Item {
	private String itemName;
	private String itemDesc;
	private Double itemPrice;
	private int quantity;
	private Integer availableQuantity;

	public Item() {
	quantity++;
	}

	public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		quantity++;
		this.availableQuantity = availableQuantity;
	}
	
	public Item(String itemDesc, double itemPrice, Integer availableQuantity) {
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.availableQuantity = availableQuantity;
		quantity++;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Integer getQuantity() {
		return quantity++;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Override
	public String toString() {
		return String.format("%s %s %.2f %d", itemName, itemDesc, itemPrice,availableQuantity);
	}



}
