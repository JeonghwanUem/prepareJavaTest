package toy.vo;

public class Bicycle extends Toy {
	private String type;	// 자전거 종류
	
	/*
	 * Constructors
	 */
	public Bicycle(){}
	
	public Bicycle(String code, String name, int price, String type) {
		super(code, name, price);
		this.type = type;
	}

	/*
	 * Getters and setters
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "[자전거]\t" +  super.toString() + ",\t종류 = " + type + "]";
	}
	
}
