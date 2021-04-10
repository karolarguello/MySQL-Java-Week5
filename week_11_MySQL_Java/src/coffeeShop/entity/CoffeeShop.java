package coffeeShop.entity;

public class CoffeeShop {
	private long coffeeShop_Id;
	private String name;
	
	public CoffeeShop(long coffeeShop_Id, String name) {
		this.coffeeShop_Id = coffeeShop_Id;
		this.name = name;
	}
	
	public long getCoffeeShopId() {
		return coffeeShop_Id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "CoffeeShop [coffeeShop_Id=" + coffeeShop_Id + ", name=" + name + "]";
	}

}
