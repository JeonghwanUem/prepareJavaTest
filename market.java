package market.vo;

public class market {
	private String title;// ������ ����
	private String name;// �����̸�
	private int sell;//�Ĵ°���
	private int buy;//��� ����
	private int sum;// ���Ǽ���
	private String limitdate;// �������
	private String indate;//������ �԰�� ��¥
	private String Username;// ���̸�
	private String phone;// �� ��ȭ��ȣ
	private String address;// ���ּ�
	private int point;// ����Ʈ
	private int sell_num;//�մ����� ������ �Ĵ� �ѹ�
	private int sell_money;//���� �� ��
	private String sell_date;//������ �� ��¥
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