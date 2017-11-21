create table market(
product varchar2(20) primary key
,price number not null
,product_num number not null
);

create table salesTable(
product varchar2(20) unique //null은 들어갈 수 있음 아우터 조인을 해줘야 함 userinfo를 통해 조인해야 함 
,price number not null
,numbers number not null
,constraint useraddr_fk foreign key(product)
references market(product) on delete cascade
);

고객의 휴대폰 뒷자리가 고객 id가 됨 
동일한 휴대폰 번호가 존재한다면 
이름을 같이 사용함 
create userinfo(
name varchar2(20) not null
,phone varchar2(50) not null
,address varchar2(100) not null
,price number not null
)
위가 필수항목 
밑에는 선택항목
밑에 입력을 안할 수도 있기때문에 null값일 수 도 있다
양쪽에서 데이터를 다 가져와야 하는 상황
동등 조인을 하면 null값이 나오면 둘다 셀렉트가 되지 않는 상황이 나올 수 도 있다
outer join을 해줘야 한다 
decord를 사용해 줘야 한다 
성별 값이 변경 될 수 있도록

outer join을 해줬을 때 null값이 출력됬을때
null값을 조절 빈공백으로

	private String product;
	private int price;
	private int product_num;
	private String name;
	private int phone;
	private String address;
	
	create table 
