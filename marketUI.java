package market.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import market.dao.marketDAO;
import market.vo.market;

public class marketUI {
	boolean whereAreYouFrom = true;

	boolean areYouGoingToSave = true;

	private Scanner sc = new Scanner(System.in);

	private marketDAO dao = new marketDAO();
	
	int sum=0;
	int totalPrice;

	public marketUI() {

		while (true) {

			printMainMenu();

			int no = 0;

			try {

				no = sc.nextInt();

			} catch (Exception e) {

				sc.nextLine();// 한번 비워주는 코드

			}

			switch (no) {

			case 1:
				// 제품을 검색하고 구매
				searchProduct();
				break;

			case 2:
				// 제품의 검색없이 바로 구매
				buyNow();
				break;

			case 3:
				// 회원등록
				int num = 0;

				insertUser(num);

				break;

			case 4:
				// 회원검색
				selectOneUser();

				break;
			case 5:
				// 회원 삭제

			case 6:
				// 회원 구매 목록

			case 9:

				System.out.println("슈퍼마켓을 나갑니다.");

				System.exit(0);

				break;

			default:

				System.out.println("번호를 다시 선택 하세요");

				break;
			}

		}

	}

	public void printMainMenu() {

		System.out.println("마트에 오신 것을 환영합니다.");

		System.out.println("1. 제품 검색");

		System.out.println("2. 제품 구매");

		System.out.println("3. 회원등록");

		System.out.println("4. 회원 검색");

		System.out.println("9. 프로그램 종료");

		System.out.println("* 메뉴 번호를 선택하세요");

		/*
		 * market market = new market(); market market2 = dao.selectPrice(market);
		 * System.out.println(market.getUsername()+market2.getName());
		 */
		// 이렇게 하면 널 값이 뜬다 당연히 찾아 주는 값이 지정이 되어 있지 않기 때문이다
	}

	public void salesTable(String name) {
		market market;
		market = dao.selectSumAndSell(name);
		// 이 값을 리스트로해서 찾아줘야 한다
		int howMany = 0;

		System.out.println("[알림]검색하신 물건을 구매하시겠습니까?(Y/N)");
		sc.nextLine();// 물건검색시 숫자 넣어주는 것을 무효화 시켜주기 위해 사용한다
		String sayYesOrNo = sc.next();// 물건을 구매할지 정한다

		if (sayYesOrNo.equals("Y") || sayYesOrNo.equals("y")) {
			System.out.println("[알림]구매 수량을 입력해 주세요.");
			howMany = sc.nextInt();// 수량을 입력받는다
			/*
			 * if (market.getSum() < howMany) { System.out.println("제품의 수량이 충분하지 않습니다.");
			 * 
			 * } else if (market.getSum() - howMany == 0) { dao.deleteName(market); } else
			 * if (market.getSum() > howMany) { market m3 = dao.updateSum(market);
			 * m3.setSum(market.getSum() - howMany); }
			 */
		} else {
			System.out.println("[알림]검색기능으로 돌아갑니다");
			searchProduct();
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@여기서 buynow에서 왔다면 거기로
			// 다시 돌아가줘야 하는데 어케하는 지 모르겠다
		}
		// 이걸 왜 넣어줬지 시바, 셀렉트 문으로 다시 작성해줘야한다
		// market M = dao.insertMarket(name);

		// String title = M.getTitle();

		// M.getSell();// 아마 가격 테이블이 없어서 널이 뜸
		// 구입한 물건의 총 가격은
		totalPrice = market.getSell() * howMany;
		System.out.println("[알림]구매하신 상품의 가격은" + totalPrice + "입니다.");
		System.out.println("[알림]쇼핑을 계속 하시겠습니까?(Y/N)");
		String keepOn = sc.next();
		if (keepOn.equals("y") || keepOn.equals("Y")) {
			if (whereAreYouFrom == true) {
				searchProduct();
			} else {
				buyNow();
				sum = + totalPrice;
			}
		} else {
			System.out.println("[알림]회원이십니까?(Y/N)");

			String confirm = sc.next();

			if (confirm.equals("Y") || confirm.equals("y")) {

				userLogIn();

			} else {

				System.out.println("[알림]회원가입을 하시겠습니까?(Y/N)");

				areYouGoingToSave = false;

				String decision = sc.next();

				if (decision.equals("y") || decision.equals("Y")) {

					insertUser(totalPrice);
					
					System.out.println("가입해 주셔서 감사합니다.");
					
					System.out.println("총 금액은 " + sum + "원 입니다.");

					System.out.println("이용해 주셔서 감사합니다.");


					return;

				} else {

					System.out.println("총 금액은 " + sum + "원 입니다.");

					System.out.println("이용해 주셔서 감사합니다.");
				}

			}
		}
		// market m3 = dao.sel//selltable에 insert 넣어 줘야 한다
		market m2 = new market();

		// 판매금액, 누가 사 갔는지, 만약 로그인 하지 않고 그냥 샀다면
		// 손님으로 저장하고
		// 로그인하고 구매했다면
		// 손님의 이름을 받는다 그건 로그인 메소드에서 해줘야 한다
		//

		// m2.setTitle(title);

		// m2.setName(name);

		m2.setSell(market.getSell() * howMany);// 판매금액

		// m2.setSum(market.getSum()-howMany);
		// main테이블에 수량 팔린 만큼 빼줌
		m2.setSum(market.getSum() - howMany);// 판매수량

		market m3 = dao.insertSell(name);

		m3.setSell_num(howMany);
		m3.setName(name);
		m3.setSell_date(null);// 널 값을 넣으면 오늘 날짜가 나오도록 설정해 놨음
	}

	// 여기서 물건의 종류와 수량 구입 일자를 입력시켜 줘야 한다

	// 회원 가입테이블 완성
	public void insertUser(int price) {

		market market;

		market = new market();

		String name = "";

		String phone;

		String address;

		int point; // 포인트는 고객 구매금액의 일부만큼 자동으로 적용됨

		sc.nextLine();

		System.out.println("[고객정보 입력]");

		System.out.println("이름: ");

		// try {

		name = sc.next();

		// } catch (Exception e) {

		// System.out.println("[알림]특수문자나 숫자는 입력할 수 없습니다.");

		// }

		System.out.println("전화번호: ");

		phone = sc.next();

		StringBuffer sb = new StringBuffer(phone); // 생성

		sb.insert(3, "-");// 버퍼를 생성해서 -를 자동으로 붙여주고 그 값을 테이블에 저장해 주면 보기 좋다

		sb.insert(8, "-");// 3번째 자리와 8번째 자리에 각각 넣어 준다

		System.out.println("주소: ");

		address = sc.next();

		sc.nextLine();

		point = price / 10 + market.getPoint();
		// 물건의 구매 창에서 가져올수 있는 가격을 가져와서 곱해준다
		System.out.println("[알림]회원 가입이 완료 되었습니다.");
		// System.out.println("포인트: " + point);

		market.setUsername(name);// 값을 하나씩 vo에 저장 해준다

		market.setPhone(phone);

		market.setAddress(address);

		market.setPoint(point);

		dao.insertUser(market);// 그렇게 모인 값들을 mapper를 통해 table로 저장 시켜 준다
		/*
		 * boolean flag = dao.insertUser(market); if (flag) {
		 * System.out.println("[알림]고객등록이 완료 되었습니다."); } else {
		 * System.out.println("[알림]등록에 실패하였습니다. \t 다시한번 시도해 주세요.");
		 * 
		 * }
		 */

		if (areYouGoingToSave == false) {

			market market2 = dao.insertSell(name);
			market2.setUsername(name);

		}
		return;
	}

	// 위에서 쓰고있는 전화번호를 리턴 받아와서 사용한다
	// 전화번호 전체를 다 쓰지 않고 뒤 4자리만 쓰기 때문에 잘라 낼 수 있는 코드를 알아야 한다
	//
	public void userLogIn() {

		ArrayList<market> list = dao.selectUser();

		market market = new market();

		boolean flag = true;

		boolean innerFlag = true;

		while (flag) {

			System.out.println("[알림]전화번호 뒷자리를 입력하세요.>");

			String phone = sc.next();

			for (market m : list) {// 리스트에서 같은 번호가 있는지 확인해 준다

				if (phone.equals(m.getPhone().substring(7))) {// 리스트에 있는 전화번호중 같은게 있다면

					int count = 0;
					count++;

					if (count > 1) {// count가 2이상이 된다면 같은 번호가 2개 이상이라면

						System.out.println("[알림]동일한 전화번호가 존재하니, 이름을 입력하세요.>");

						String name = sc.next();// 회원의 이름을 이용하여 회원을 검색한다.

						if (name.equals(m.getUsername())) {// 화원의 이름을 검색해 준다

							System.out.println("[알림]회원 확인 되었습니다.");
							System.out.println("이용해 주셔서 감사합니다.");

							flag = false;// 같으면 while문을 탈줄한다

							break;

						} else {

							System.out.println("[알림]이름을 잘못 입력하셨습니다.");

							System.out.println("[알림]다시 입력하시겠습니까?(Y/N)");

							String tryAgain = sc.next();

							if (tryAgain.equals("Y") || tryAgain.equals("y")) {
								continue; // continue를 사용서 다시for 반복문으로 올려준다
											// 일단 한번 늘어난 count는 한번더 늘어나도 상관없다
											// 이름으로 한번더 검색해 줄 것이기 때문에
											// 가입일도 알아줘야 할 것같다
											// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

							} else {
								System.out.println(m.getUsername() + "님, 회원 확인 되었습니다.");
								System.out.println("[알림]메뉴로 돌아갑니다.");
								flag = false;
								break;
							}

						}

					} else {

						System.out.println("[알림]이용해 주셔서 감사합니다.");

						market.getUsername();
						
						market market2 = dao.insertSell(market);
						
						flag = false;

						break;
					}

				} else {

					System.out.println("[알림]번호를 잘못 입력하셨습니다.");

					System.out.println("[알림]회원가입 창으로 가시겠습니까?(Y/N)");

					String confirm = sc.next();

					if (confirm.equals("Y") || confirm.equals("y")) {

						int num = 0;

						insertUser(num);

					} else {

						System.out.println("[알림]다시 시도 하시겠습나까?(Y/N)");

						confirm = sc.next();

						if (confirm.equals("Y") || confirm.equals("y")) {

							userLogIn();

						} else {

							System.out.println("[알림]메뉴로 복귀합니다");

							flag = false;

						}
					}

					flag = false;
				}
			}
		}

	}

	// 유저 검색기능 완성
	public void selectOneUser() {
		// 회원의 이름과 전화 번호 주소로 회원을 검색하는 기능
		// hashmap사용
		// usersinfo테이블을 사용한다
		System.out.println("[회원 검색]");
		String col = "";
		String text = "";

		System.out.println("*검색대상: 1.이름 2.전화번호  3.주소 ");
		col = sc.next();
		System.out.println("*검색어>");
		sc.nextLine();
		text = sc.nextLine();

		HashMap<String, String> map = new HashMap<>();
		map.put("col", col);
		map.put("text", text);

		ArrayList<market> list = dao.selectOneUser(map);

		if (list == null || list.size() == 0) {
			System.out.println("검색결과가 없습니다");
			return;
		} else {
			for (market m : list) {
				System.out.println("이름: " + m.getName() + "\t");
				System.out.println("전화번호: " + m.getPhone() + "\t");
				System.out.println("주소: " + m.getAddress() + "\t");

			}
		}
	}

	// 고객이 물건을 구매 할려면 어떤 물건이 있는지 알아야 하기 때문에 물건의 선택조회 창에서 물건을 보고 물건을 고르고
	// 수량을 선택할 수 있는 메소드를 만들어 줘야 한다
	public void searchProduct() {
		System.out.println("[알림]구매하실 물건을 찾아주세요.");
		String col = "";
		String sol = "";
		sc.nextLine();
		System.out.println("                  [목록 ]");
		System.out.println("[1.채소  2.과일 3.유제품 4.라면 5.과자    ]");
		System.out.println("[6.아이스크림 7.음료수 8.소스 9.생활용품 ]");
		System.out.print("사장님의 선택은? : ");
		col = sc.next();
		if (col.equals("1")) {
			System.out.println("                <==채소==>");
			System.out.println("[1.호박 2.오이 3.고추 4.배추 5.미나리 6.토마토 ]");
			System.out.println("[7.양송이버섯 8.표고버섯9.감자 0.당근                ]");
			System.out.print("사장님의 선택은? : ");
			System.out.println();
		}
		if (col.equals("2")) {
			System.out.println("            <==과일==>           ");
			System.out.println("[1.코코넛 2.배 3.복숭아 4.아보카도 5.사과 ]");
			System.out.println("[6.바나나7.자두 8.파인애플 9.메론 0.밤     ]");
			System.out.print("사장님의 선택은? : ");
		}
		if (col.equals("3")) {
			System.out.println("           <==유제품==>");
			System.out.println("[1.치즈 2.요플레 3.요구르트 4.라코타치즈 5.흰우유  ]");
			System.out.println("[6.앙팡 7.분유 8.바나나우유 9.딸기 0.초코우유        ]");
			System.out.print("사장님의 선택은? : ");
		}
		if (col.equals("4")) {
			System.out.println("            <==라면==>");
			System.out.println("[1.신라면 2.진라면 3.너구리 4.무파마 5.참깨라면                ]");
			System.out.println("[6.짜파게티 7.삼양라면 8.팔도비빔면 9.오징어짬뽕 0.새우탕 ]");
			System.out.print("사장님의 선택은? : ");
		}
		if (col.equals("5")) {
			System.out.println("          <==과자==>");
			System.out.println("[1.새우깡 2.빼빼로 3.초코파이 4.과자선물세트 5.콘칩]");
			System.out.println("[6.몽쉘 7.바나나킥 8.초코송이 9.자갈치 0.고래밥      ]");
			System.out.print("사장님의 선택은? : ");
		}
		if (col.equals("6")) {
			System.out.println("          <==아이스크림==>");
			System.out.println("[1.붕어싸만코 2.멜론바 3.스쿠류바 4.수박바 5.요맘때]");
			System.out.println("[6.죠스바 7.보석바 8.바밤바 9.돼지바 0.구구콘         ]");
			System.out.print("사장님의 선택은? : ");
		}
		if (col.equals("7")) {
			System.out.println("            <==음료수==>");
			System.out.println("[1.콜라 2.펩시 3.콤비콜라 4.맥콜 5.오로나민C    ]");
			System.out.println("[6.게토레이 7.포카리 8.2% 9.트로피카나 0.암바사 ]");
			System.out.print("사장님의 선택은? : ");
		}
		if (col.equals("8")) {
			System.out.println("            <==소스==>");
			System.out.println("[1.케찹 2.머스타드 3.간장 4.고추장 5.오사비    ]");
			System.out.println("[6.초고추장 7.식초 8.굴소스 9.핫소스 0.타바스코 ]");
			System.out.print("사장님의 선택은? : ");
		}
		if (col.equals("9")) {
			System.out.println("            <==생활용품==>");
			System.out.println("[1.뚫어뻥 2.식칼 3.도마 4.컵 5.그릇 6.냄비]");
			System.out.println("[7.국자 8.수저 9.쓰레기통 0.수세미             ]");
			System.out.print("사장님의 선택은? : ");
		}

		sc.nextLine();
		sol = sc.next();

		HashMap<String, String> buyer = new HashMap<>();
		buyer = makeMap(col, sol);

		ArrayList<market> list = dao.AllMenu();

		if (list == null || list.size() == 0) {
			System.out.println("시스템 결과가 없습니다.");
			return;
		} else {
			for (market m : list) {
				// 여기서 vo에 다시 필드를 설정해줘야 한다
				// 테이블을 받아야 구동이 가능하다.
				// 선택한 종류에 제품에 수량과 유통기한 가격도 보이게 해야 한다
				System.out.print("종류 : " + m.getTitle() + "\t");

				System.out.print("이름 : " + m.getName() + "\t");

				System.out.println("가격: " + m.getSell() + "\t");

				System.out.print("수량 : " + m.getSum() + "\t");

				System.out.print("유통기한 : " + m.getLimitdate() + "\t");

				System.out.println();

				// 여기에 구매 문구를 넣어 줘야 한다.
				whereAreYouFrom = true;
				salesTable(m.getName());

				/*
				 * market market = new market();
				 * 
				 * System.out.println("[알림]구매하실 수량을 입력해 주세요.>");
				 * 
				 * int buyingNum = sc.nextInt();
				 * 
				 * int modifiedNum = m.getSum() - buyingNum;
				 * 
				 * market.setSum(modifiedNum);
				 * 
				 * int totalBuyingPrice = buyingNum * m.getSell();
				 * 
				 * System.out.println("[알림]총 금액은" + totalBuyingPrice + "");
				 */

				// 개인의 총 구매 금액을 테이블에 저장해 줘야 한다.
				// 테이블도 따로 하나 만들어 줘야 한다
				// 고객이름 (만약 없다면 디폴트 값으로 일반 고객이라는 값을 넣어 줘야 한다)
				// 나머지 고객정보와 고객이 구매한 제품과 제품의 가격 수량 ,총 액수를 받아줘야 한다.
				// 고객이 구매한 제품의 수량은 main table의 수량에서 제한 다음 modifiedBum이란
				// 이름으로 수정하여 저장해준다
			}

		}

	}

	public HashMap<String, String> makeMap(String num1, String num2) {

		HashMap<String, String> buyer = new HashMap<>();

		String title = "";

		String name = "";

		if (num1.equals("1")) {

			title = "채소";

			if (num2.equals("1")) {

				name = "호박";

			} else if (num2.equals("2")) {

				name = "오이";

			} else if (num2.equals("3")) {

				name = "고추";

			} else if (num2.equals("4")) {

				name = "배추";

			} else if (num2.equals("5")) {

				name = "미나리";

			} else if (num2.equals("6")) {

				name = "토마토";

			} else if (num2.equals("7")) {

				name = "양송이버섯";

			} else if (num2.equals("8")) {

				name = "표고버섯";

			} else if (num2.equals("9")) {

				name = "감자";

			} else if (num2.equals("0")) {

				name = "당근";
			}
		}
		if (num1.equals("2")) {

			title = "과일";

			if (num2.equals("1")) {

				name = "코코넛";

			} else if (num2.equals("2")) {

				name = "배";

			} else if (num2.equals("3")) {

				name = "복숭아";

			} else if (num2.equals("4")) {

				name = "아보카도";

			} else if (num2.equals("5")) {

				name = "사과";

			} else if (num2.equals("6")) {

				name = "바나나";

			} else if (num2.equals("7")) {

				name = "자두";

			} else if (num2.equals("8")) {

				name = "파인애플";

			} else if (num2.equals("9")) {

				name = "메론";

			} else if (num2.equals("0")) {

				name = "밤";
			}
		}
		if (num1.equals("3")) {

			title = "유제품";

			if (num2.equals("1")) {

				name = "치즈";

			} else if (num2.equals("2")) {

				name = "요플레";

			} else if (num2.equals("3")) {

				name = "요구르트";

			} else if (num2.equals("4")) {

				name = "라코타치즈";

			} else if (num2.equals("5")) {

				name = "흰우유";

			} else if (num2.equals("6")) {

				name = "앙팡";

			} else if (num2.equals("7")) {

				name = "분유";

			} else if (num2.equals("8")) {

				name = "바나나우유";

			} else if (num2.equals("9")) {

				name = "딸기우유";

			} else if (num2.equals("0")) {

				name = "초코우유";
			}
		}
		if (num1.equals("4")) {

			title = "라면";

			if (num2.equals("1")) {

				name = "신라면";

			} else if (num2.equals("2")) {

				name = "진라면";

			} else if (num2.equals("3")) {

				name = "너구리";

			} else if (num2.equals("4")) {

				name = "무파마";

			} else if (num2.equals("5")) {

				name = "참깨라면";

			} else if (num2.equals("6")) {

				name = "짜파게티";

			} else if (num2.equals("7")) {

				name = "삼양라면";

			} else if (num2.equals("8")) {

				name = "팔도비빔면";

			} else if (num2.equals("9")) {

				name = "오징어짬뽕";

			} else if (num2.equals("0")) {

				name = "새우탕";
			}
		}

		if (num1.equals("5")) {

			title = "과자";

			if (num2.equals("1")) {

				name = "새우깡";

			} else if (num2.equals("2")) {

				name = "빼빼로";

			} else if (num2.equals("3")) {

				name = "초코파이";

			} else if (num2.equals("4")) {

				name = "과자선물세트";

			} else if (num2.equals("5")) {

				name = "콘칩";

			} else if (num2.equals("6")) {

				name = "몽쉘";

			} else if (num2.equals("7")) {

				name = "바나나킥";

			} else if (num2.equals("8")) {

				name = "초코송이";

			} else if (num2.equals("9")) {

				name = "자갈치";

			} else if (num2.equals("0")) {

				name = "고래밥";
			}
		}
		if (num1.equals("6")) {

			title = "아이스크림";

			if (num2.equals("1")) {

				name = "붕어싸만코";

			} else if (num2.equals("2")) {

				name = "멜론바";

			} else if (num2.equals("3")) {

				name = "스쿠류바";

			} else if (num2.equals("4")) {

				name = "수박바";

			} else if (num2.equals("5")) {

				name = "요맘때";

			} else if (num2.equals("6")) {

				name = "죠스바";

			} else if (num2.equals("7")) {

				name = "보석바";

			} else if (num2.equals("8")) {

				name = "바밤바";

			} else if (num2.equals("9")) {

				name = "돼지바";

			} else if (num2.equals("0")) {

				name = "구구콘";
			}
		}
		if (num1.equals("7")) {
			title = "음료수";
			if (num2.equals("1")) {
				name = "콜라";
			} else if (num2.equals("2")) {
				name = "팹시";
			} else if (num2.equals("3")) {
				name = "콤비콜라";
			} else if (num2.equals("4")) {
				name = "맥콜";
			} else if (num2.equals("5")) {
				name = "오로나민C";
			} else if (num2.equals("6")) {
				name = "게토레이";
			} else if (num2.equals("7")) {
				name = "포카리";
			} else if (num2.equals("8")) {
				name = "2%";
			} else if (num2.equals("9")) {
				name = "트로피카나";
			} else if (num2.equals("0")) {
				name = "암바사";
			}
		}
		if (num1.equals("8")) {
			title = "소스";
			if (num2.equals("1")) {
				name = "케찹";
			} else if (num2.equals("2")) {
				name = "머스타드";
			} else if (num2.equals("3")) {
				name = "간장";
			} else if (num2.equals("4")) {
				name = "고추장";
			} else if (num2.equals("5")) {
				name = "와사비";
			} else if (num2.equals("6")) {
				name = "초고추장";
			} else if (num2.equals("7")) {
				name = "식초";
			} else if (num2.equals("8")) {
				name = "굴소스";
			} else if (num2.equals("9")) {
				name = "핫소스";
			} else if (num2.equals("0")) {
				name = "타바스코";
			}
		}
		if (num1.equals("9")) {
			title = "생활용품";
			if (num2.equals("1")) {
				name = "뚫어뻥";
			} else if (num2.equals("2")) {
				name = "식칼";
			} else if (num2.equals("3")) {
				name = "도마";
			} else if (num2.equals("4")) {
				name = "컵";
			} else if (num2.equals("5")) {
				name = "그릇";
			} else if (num2.equals("6")) {
				name = "냄비";
			} else if (num2.equals("7")) {
				name = "국자";
			} else if (num2.equals("8")) {
				name = "수저";
			} else if (num2.equals("9")) {
				name = "쓰레기통";
			} else if (num2.equals("0")) {
				name = "수세미";
			}
		}

		buyer.put("title", title);
		buyer.put("name", name);

		return buyer;
	}

	public void refund() {

	}

	// 자신이 구매하고 싶은 물건을 안다면 바로 구매할 수 있도록 만들어 놓아야 한다

	public void buyNow() {
		whereAreYouFrom = false;
		market market = new market();

		// System.out.println("[알림]구매하실 제품 종류를 입력해 주세요.");

		// col = sc.next();

		System.out.println("[알림]구매하실 제품명을 입력해 주세요.");
		String name = sc.next();

		// text = sc.next();// 상품명을 입력하면 상품의 정보를 출력해 줄 수 있어야 한다.

		// HashMap<String, String> map = new HashMap<>();
		// map.put("col", col);
		// map.put("text", text);

		ArrayList<market> list = dao.selectAll();

		for (market m : list) {
			if (name.equals(m.getName())) {

				System.out.println(m.getTitle());
				System.out.println(m.getName());
				System.out.println(m.getSell());
				System.out.println(m.getLimitdate());
				System.out.println(m.getSum());
			}
		}
		salesTable(name);
	}

	/*
	 * System.out.println("[알림]구매하실 제품의 갯수를 입력해 주세요.");
	 * 
	 * int productNumber = sc.nextInt(); // main에 새롭게 저장해 줘야 한다 int
	 * modifiedProductNumber = market.getSum() - productNumber;
	 * 
	 * int totalPrice = market.getSell() * productNumber;
	 * 
	 * System.out.println("총 가격은 " + totalPrice + "입니다");
	 * 
	 * System.out.println("[알림]구매를 계속 하시겠습니까?(Y/N)");
	 * 
	 * String keepShop = sc.next();
	 * 
	 * int sum = +totalPrice;
	 * 
	 * if (keepShop.equals("Y") || keepShop.equals("y")) { continue;
	 * 
	 * } else {
	 * 
	 * System.out.println("총 구매 가격은" + sum); System.out.println("[알림]회원이십니까?(Y/N)");
	 * String answer = sc.next(); if (answer.equals("Y") || answer.equals("y")) {
	 * System.out.println("[알림]로그인 하시겠습니까?(Y/N)"); String answer2 = sc.next(); if
	 * (answer2.equals("Y") || answer2.equals("y")) { userLogIn(); if
	 * (market.getPoint() != 0) { System.out.println("[알림]사용가능한 포인트가 존재합니다.");
	 * System.out.println("사용 하시겠습니까?(Y/N)"); String answer3 = sc.next(); if
	 * (answer3.equals("Y") || answer3.equals("y")) {
	 * 
	 * System.out.println(sum - market.getPoint() + "원 입니다."); // 구매 테이블을 만들어서
	 * mapper에 연결 시켜줘서 // 만들어 줘야 한다 System.out.println("이용해 주셔서 감사합니다."); int point
	 * = (sum - market.getPoint()) / 10; market.setPoint(point);// 저장시켜 준것 market =
	 * dao.insertUser(market); }
	 * 
	 * } } else { System.out.println("[알림]결제가 완료되었습니다");
	 * System.out.println("이용해 주셔서 감사합니다."); }
	 * 
	 * System.out.println("[알림]다음에 다시 들려주세요."); flag = false;
	 * 
	 * }
	 * 
	 * } }
	 */

	public void deleteUser() {
		// 회원 정보 삭제 메소드
		System.out.println("[알림]회원 탈퇴하시 겠습니까?");

	}

}