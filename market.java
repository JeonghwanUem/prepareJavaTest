package market.vo;

public class market {
	private String title;// 물건의 종류
	private String name;// 물건이름
	private int sell;//파는가격
	private int buy;//사는 가격
	private int sum;// 물건수량
	private String limitdate;// 유통기한
	private String indate;//물건이 입고된 날짜
	private String Username;// 고객이름
	private String phone;// 고객 전화번호
	private String address;// 고객주소
	private int point;// 포인트
	private int sell_num;//손님한테 물건을 파는 넘버
	private int sell_money;//물건 판 값
	private String sell_date;//물건을 판 날짜
	private int sellNum;
	
	public market() {
		super();
	}


	public market(String title, String name, int sell, int buy, int sum, String limitdate, String indate,
			String username, String phone, String address, int point, int sell_num, int sell_money, String sell_date,int sellNum) {
		super();
		this.title = title;
		this.name = name;
		this.sell = sell;
		this.buy = buy;
		this.sum = sum;
		this.limitdate = limitdate;
		this.indate = indate;
		Username = username;
		this.phone = phone;
		this.address = address;
		this.point = point;
		this.sell_num = sell_num;
		this.sell_money = sell_money;
		this.sell_date = sell_date;
		this.sellNum = sellNum;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSell() {
		return sell;
	}


	public void setSell(int sell) {
		this.sell = sell;
	}


	public int getBuy() {
		return buy;
	}


	public void setBuy(int buy) {
		this.buy = buy;
	}


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	public String getLimitdate() {
		return limitdate;
	}


	public void setLimitdate(String limitdate) {
		this.limitdate = limitdate;
	}


	public String getIndate() {
		return indate;
	}


	public void setIndate(String indate) {
		this.indate = indate;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public int getSell_num() {
		return sell_num;
	}


	public void setSell_num(int sell_num) {
		this.sell_num = sell_num;
	}


	public int getSell_money() {
		return sell_money;
	}


	public void setSell_money(int sell_money) {
		this.sell_money = sell_money;
	}


	public String getSell_date() {
		return sell_date;
	}


	public void setSell_date(String sell_date) {
		this.sell_date = sell_date;
	}
	
	public int getSellNum() {
		return sellNum;
	}


	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}


	@Override
	public String toString() {
		return "market [title=" + title + ", name=" + name + ", sell=" + sell + ", buy=" + buy + ", sum=" + sum
				+ ", limitdate=" + limitdate + ", indate=" + indate + ", Username=" + Username + ", phone=" + phone
				+ ", address=" + address + ", point=" + point + ", sell_num=" + sell_num + ", sell_money=" + sell_money
				+ ", sell_date=" + sell_date + ", sellNum=" + sellNum + "]";
	}

	

	
	
	
	
	}