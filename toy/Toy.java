package toy.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Toy implements Serializable {
	private String code;	// 번호
	private String name;		// 이름
	private int price;			// 가격

	/*
	 * Constructors
	 */
	public Toy() {}
	
	public Toy(String code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	/*
	 * Getters and setters
	 */
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "[이름 = " + name + ",\t가격 = " +  price + "원,\t고유번호 = " + code;
	}
}
