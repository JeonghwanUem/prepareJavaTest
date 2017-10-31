package toy.vo;

public class GameConsole extends Toy {
	private String company;
	
	public GameConsole(String code, String name, int price, String company) {
		super(code, name, price);
		this.company = company;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "[게임콘솔]" +  super.toString() + ",\t제조사 = " + company + "]";
	}
}
