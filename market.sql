create table market(
product varchar2(20) primary key
,price number not null
,product_num number not null
);

create table salesTable(
product varchar2(20) unique //null�� �� �� ���� �ƿ��� ������ ����� �� userinfo�� ���� �����ؾ� �� 
,price number not null
,numbers number not null
,constraint useraddr_fk foreign key(product)
references market(product) on delete cascade
);

���� �޴��� ���ڸ��� �� id�� �� 
������ �޴��� ��ȣ�� �����Ѵٸ� 
�̸��� ���� ����� 
create userinfo(
name varchar2(20) not null
,phone varchar2(50) not null
,address varchar2(100) not null
,price number not null
)
���� �ʼ��׸� 
�ؿ��� �����׸�
�ؿ� �Է��� ���� ���� �ֱ⶧���� null���� �� �� �ִ�
���ʿ��� �����͸� �� �����;� �ϴ� ��Ȳ
���� ������ �ϸ� null���� ������ �Ѵ� ����Ʈ�� ���� �ʴ� ��Ȳ�� ���� �� �� �ִ�
outer join�� ����� �Ѵ� 
decord�� ����� ��� �Ѵ� 
���� ���� ���� �� �� �ֵ���

outer join�� ������ �� null���� �������
null���� ���� ���������

	private String product;
	private int price;
	private int product_num;
	private String name;
	private int phone;
	private String address;
	
	create table 
