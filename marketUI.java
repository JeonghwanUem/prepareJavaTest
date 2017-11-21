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

				sc.nextLine();// �ѹ� ����ִ� �ڵ�

			}

			switch (no) {

			case 1:
				// ��ǰ�� �˻��ϰ� ����
				searchProduct();
				break;

			case 2:
				// ��ǰ�� �˻����� �ٷ� ����
				buyNow();
				break;

			case 3:
				// ȸ�����
				int num = 0;

				insertUser(num);

				break;

			case 4:
				// ȸ���˻�
				selectOneUser();

				break;
			case 5:
				// ȸ�� ����

			case 6:
				// ȸ�� ���� ���

			case 9:

				System.out.println("���۸����� �����ϴ�.");

				System.exit(0);

				break;

			default:

				System.out.println("��ȣ�� �ٽ� ���� �ϼ���");

				break;
			}

		}

	}

	public void printMainMenu() {

		System.out.println("��Ʈ�� ���� ���� ȯ���մϴ�.");

		System.out.println("1. ��ǰ �˻�");

		System.out.println("2. ��ǰ ����");

		System.out.println("3. ȸ�����");

		System.out.println("4. ȸ�� �˻�");

		System.out.println("9. ���α׷� ����");

		System.out.println("* �޴� ��ȣ�� �����ϼ���");

		/*
		 * market market = new market(); market market2 = dao.selectPrice(market);
		 * System.out.println(market.getUsername()+market2.getName());
		 */
		// �̷��� �ϸ� �� ���� ��� �翬�� ã�� �ִ� ���� ������ �Ǿ� ���� �ʱ� �����̴�
	}

	public void salesTable(String name) {
		market market;
		market = dao.selectSumAndSell(name);
		// �� ���� ����Ʈ���ؼ� ã����� �Ѵ�
		int howMany = 0;

		System.out.println("[�˸�]�˻��Ͻ� ������ �����Ͻðڽ��ϱ�?(Y/N)");
		sc.nextLine();// ���ǰ˻��� ���� �־��ִ� ���� ��ȿȭ �����ֱ� ���� ����Ѵ�
		String sayYesOrNo = sc.next();// ������ �������� ���Ѵ�

		if (sayYesOrNo.equals("Y") || sayYesOrNo.equals("y")) {
			System.out.println("[�˸�]���� ������ �Է��� �ּ���.");
			howMany = sc.nextInt();// ������ �Է¹޴´�
			/*
			 * if (market.getSum() < howMany) { System.out.println("��ǰ�� ������ ������� �ʽ��ϴ�.");
			 * 
			 * } else if (market.getSum() - howMany == 0) { dao.deleteName(market); } else
			 * if (market.getSum() > howMany) { market m3 = dao.updateSum(market);
			 * m3.setSum(market.getSum() - howMany); }
			 */
		} else {
			System.out.println("[�˸�]�˻�������� ���ư��ϴ�");
			searchProduct();
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@���⼭ buynow���� �Դٸ� �ű��
			// �ٽ� ���ư���� �ϴµ� �����ϴ� �� �𸣰ڴ�
		}
		// �̰� �� �־����� �ù�, ����Ʈ ������ �ٽ� �ۼ�������Ѵ�
		// market M = dao.insertMarket(name);

		// String title = M.getTitle();

		// M.getSell();// �Ƹ� ���� ���̺��� ��� ���� ��
		// ������ ������ �� ������
		totalPrice = market.getSell() * howMany;
		System.out.println("[�˸�]�����Ͻ� ��ǰ�� ������" + totalPrice + "�Դϴ�.");
		System.out.println("[�˸�]������ ��� �Ͻðڽ��ϱ�?(Y/N)");
		String keepOn = sc.next();
		if (keepOn.equals("y") || keepOn.equals("Y")) {
			if (whereAreYouFrom == true) {
				searchProduct();
			} else {
				buyNow();
				sum = + totalPrice;
			}
		} else {
			System.out.println("[�˸�]ȸ���̽ʴϱ�?(Y/N)");

			String confirm = sc.next();

			if (confirm.equals("Y") || confirm.equals("y")) {

				userLogIn();

			} else {

				System.out.println("[�˸�]ȸ�������� �Ͻðڽ��ϱ�?(Y/N)");

				areYouGoingToSave = false;

				String decision = sc.next();

				if (decision.equals("y") || decision.equals("Y")) {

					insertUser(totalPrice);
					
					System.out.println("������ �ּż� �����մϴ�.");
					
					System.out.println("�� �ݾ��� " + sum + "�� �Դϴ�.");

					System.out.println("�̿��� �ּż� �����մϴ�.");


					return;

				} else {

					System.out.println("�� �ݾ��� " + sum + "�� �Դϴ�.");

					System.out.println("�̿��� �ּż� �����մϴ�.");
				}

			}
		}
		// market m3 = dao.sel//selltable�� insert �־� ��� �Ѵ�
		market m2 = new market();

		// �Ǹűݾ�, ���� �� ������, ���� �α��� ���� �ʰ� �׳� ��ٸ�
		// �մ����� �����ϰ�
		// �α����ϰ� �����ߴٸ�
		// �մ��� �̸��� �޴´� �װ� �α��� �޼ҵ忡�� ����� �Ѵ�
		//

		// m2.setTitle(title);

		// m2.setName(name);

		m2.setSell(market.getSell() * howMany);// �Ǹűݾ�

		// m2.setSum(market.getSum()-howMany);
		// main���̺� ���� �ȸ� ��ŭ ����
		m2.setSum(market.getSum() - howMany);// �Ǹż���

		market m3 = dao.insertSell(name);

		m3.setSell_num(howMany);
		m3.setName(name);
		m3.setSell_date(null);// �� ���� ������ ���� ��¥�� �������� ������ ����
	}

	// ���⼭ ������ ������ ���� ���� ���ڸ� �Է½��� ��� �Ѵ�

	// ȸ�� �������̺� �ϼ�
	public void insertUser(int price) {

		market market;

		market = new market();

		String name = "";

		String phone;

		String address;

		int point; // ����Ʈ�� �� ���űݾ��� �Ϻθ�ŭ �ڵ����� �����

		sc.nextLine();

		System.out.println("[������ �Է�]");

		System.out.println("�̸�: ");

		// try {

		name = sc.next();

		// } catch (Exception e) {

		// System.out.println("[�˸�]Ư�����ڳ� ���ڴ� �Է��� �� �����ϴ�.");

		// }

		System.out.println("��ȭ��ȣ: ");

		phone = sc.next();

		StringBuffer sb = new StringBuffer(phone); // ����

		sb.insert(3, "-");// ���۸� �����ؼ� -�� �ڵ����� �ٿ��ְ� �� ���� ���̺� ������ �ָ� ���� ����

		sb.insert(8, "-");// 3��° �ڸ��� 8��° �ڸ��� ���� �־� �ش�

		System.out.println("�ּ�: ");

		address = sc.next();

		sc.nextLine();

		point = price / 10 + market.getPoint();
		// ������ ���� â���� �����ü� �ִ� ������ �����ͼ� �����ش�
		System.out.println("[�˸�]ȸ�� ������ �Ϸ� �Ǿ����ϴ�.");
		// System.out.println("����Ʈ: " + point);

		market.setUsername(name);// ���� �ϳ��� vo�� ���� ���ش�

		market.setPhone(phone);

		market.setAddress(address);

		market.setPoint(point);

		dao.insertUser(market);// �׷��� ���� ������ mapper�� ���� table�� ���� ���� �ش�
		/*
		 * boolean flag = dao.insertUser(market); if (flag) {
		 * System.out.println("[�˸�]������� �Ϸ� �Ǿ����ϴ�."); } else {
		 * System.out.println("[�˸�]��Ͽ� �����Ͽ����ϴ�. \t �ٽ��ѹ� �õ��� �ּ���.");
		 * 
		 * }
		 */

		if (areYouGoingToSave == false) {

			market market2 = dao.insertSell(name);
			market2.setUsername(name);

		}
		return;
	}

	// ������ �����ִ� ��ȭ��ȣ�� ���� �޾ƿͼ� ����Ѵ�
	// ��ȭ��ȣ ��ü�� �� ���� �ʰ� �� 4�ڸ��� ���� ������ �߶� �� �� �ִ� �ڵ带 �˾ƾ� �Ѵ�
	//
	public void userLogIn() {

		ArrayList<market> list = dao.selectUser();

		market market = new market();

		boolean flag = true;

		boolean innerFlag = true;

		while (flag) {

			System.out.println("[�˸�]��ȭ��ȣ ���ڸ��� �Է��ϼ���.>");

			String phone = sc.next();

			for (market m : list) {// ����Ʈ���� ���� ��ȣ�� �ִ��� Ȯ���� �ش�

				if (phone.equals(m.getPhone().substring(7))) {// ����Ʈ�� �ִ� ��ȭ��ȣ�� ������ �ִٸ�

					int count = 0;
					count++;

					if (count > 1) {// count�� 2�̻��� �ȴٸ� ���� ��ȣ�� 2�� �̻��̶��

						System.out.println("[�˸�]������ ��ȭ��ȣ�� �����ϴ�, �̸��� �Է��ϼ���.>");

						String name = sc.next();// ȸ���� �̸��� �̿��Ͽ� ȸ���� �˻��Ѵ�.

						if (name.equals(m.getUsername())) {// ȭ���� �̸��� �˻��� �ش�

							System.out.println("[�˸�]ȸ�� Ȯ�� �Ǿ����ϴ�.");
							System.out.println("�̿��� �ּż� �����մϴ�.");

							flag = false;// ������ while���� Ż���Ѵ�

							break;

						} else {

							System.out.println("[�˸�]�̸��� �߸� �Է��ϼ̽��ϴ�.");

							System.out.println("[�˸�]�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");

							String tryAgain = sc.next();

							if (tryAgain.equals("Y") || tryAgain.equals("y")) {
								continue; // continue�� ��뼭 �ٽ�for �ݺ������� �÷��ش�
											// �ϴ� �ѹ� �þ count�� �ѹ��� �þ�� �������
											// �̸����� �ѹ��� �˻��� �� ���̱� ������
											// �����ϵ� �˾���� �� �Ͱ���
											// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

							} else {
								System.out.println(m.getUsername() + "��, ȸ�� Ȯ�� �Ǿ����ϴ�.");
								System.out.println("[�˸�]�޴��� ���ư��ϴ�.");
								flag = false;
								break;
							}

						}

					} else {

						System.out.println("[�˸�]�̿��� �ּż� �����մϴ�.");

						market.getUsername();
						
						market market2 = dao.insertSell(market);
						
						flag = false;

						break;
					}

				} else {

					System.out.println("[�˸�]��ȣ�� �߸� �Է��ϼ̽��ϴ�.");

					System.out.println("[�˸�]ȸ������ â���� ���ðڽ��ϱ�?(Y/N)");

					String confirm = sc.next();

					if (confirm.equals("Y") || confirm.equals("y")) {

						int num = 0;

						insertUser(num);

					} else {

						System.out.println("[�˸�]�ٽ� �õ� �Ͻðڽ�����?(Y/N)");

						confirm = sc.next();

						if (confirm.equals("Y") || confirm.equals("y")) {

							userLogIn();

						} else {

							System.out.println("[�˸�]�޴��� �����մϴ�");

							flag = false;

						}
					}

					flag = false;
				}
			}
		}

	}

	// ���� �˻���� �ϼ�
	public void selectOneUser() {
		// ȸ���� �̸��� ��ȭ ��ȣ �ּҷ� ȸ���� �˻��ϴ� ���
		// hashmap���
		// usersinfo���̺��� ����Ѵ�
		System.out.println("[ȸ�� �˻�]");
		String col = "";
		String text = "";

		System.out.println("*�˻����: 1.�̸� 2.��ȭ��ȣ  3.�ּ� ");
		col = sc.next();
		System.out.println("*�˻���>");
		sc.nextLine();
		text = sc.nextLine();

		HashMap<String, String> map = new HashMap<>();
		map.put("col", col);
		map.put("text", text);

		ArrayList<market> list = dao.selectOneUser(map);

		if (list == null || list.size() == 0) {
			System.out.println("�˻������ �����ϴ�");
			return;
		} else {
			for (market m : list) {
				System.out.println("�̸�: " + m.getName() + "\t");
				System.out.println("��ȭ��ȣ: " + m.getPhone() + "\t");
				System.out.println("�ּ�: " + m.getAddress() + "\t");

			}
		}
	}

	// ���� ������ ���� �ҷ��� � ������ �ִ��� �˾ƾ� �ϱ� ������ ������ ������ȸ â���� ������ ���� ������ ����
	// ������ ������ �� �ִ� �޼ҵ带 ����� ��� �Ѵ�
	public void searchProduct() {
		System.out.println("[�˸�]�����Ͻ� ������ ã���ּ���.");
		String col = "";
		String sol = "";
		sc.nextLine();
		System.out.println("                  [��� ]");
		System.out.println("[1.ä��  2.���� 3.����ǰ 4.��� 5.����    ]");
		System.out.println("[6.���̽�ũ�� 7.����� 8.�ҽ� 9.��Ȱ��ǰ ]");
		System.out.print("������� ������? : ");
		col = sc.next();
		if (col.equals("1")) {
			System.out.println("                <==ä��==>");
			System.out.println("[1.ȣ�� 2.���� 3.���� 4.���� 5.�̳��� 6.�丶�� ]");
			System.out.println("[7.����̹��� 8.ǥ�����9.���� 0.���                ]");
			System.out.print("������� ������? : ");
			System.out.println();
		}
		if (col.equals("2")) {
			System.out.println("            <==����==>           ");
			System.out.println("[1.���ڳ� 2.�� 3.������ 4.�ƺ�ī�� 5.��� ]");
			System.out.println("[6.�ٳ���7.�ڵ� 8.���ξ��� 9.�޷� 0.��     ]");
			System.out.print("������� ������? : ");
		}
		if (col.equals("3")) {
			System.out.println("           <==����ǰ==>");
			System.out.println("[1.ġ�� 2.���÷� 3.�䱸��Ʈ 4.����Ÿġ�� 5.�����  ]");
			System.out.println("[6.���� 7.���� 8.�ٳ������� 9.���� 0.���ڿ���        ]");
			System.out.print("������� ������? : ");
		}
		if (col.equals("4")) {
			System.out.println("            <==���==>");
			System.out.println("[1.�Ŷ�� 2.����� 3.�ʱ��� 4.���ĸ� 5.�������                ]");
			System.out.println("[6.¥�İ�Ƽ 7.����� 8.�ȵ������ 9.��¡��«�� 0.������ ]");
			System.out.print("������� ������? : ");
		}
		if (col.equals("5")) {
			System.out.println("          <==����==>");
			System.out.println("[1.����� 2.������ 3.�������� 4.���ڼ�����Ʈ 5.��Ĩ]");
			System.out.println("[6.���� 7.�ٳ���ű 8.���ڼ��� 9.�ڰ�ġ 0.����      ]");
			System.out.print("������� ������? : ");
		}
		if (col.equals("6")) {
			System.out.println("          <==���̽�ũ��==>");
			System.out.println("[1.�ؾ�θ��� 2.��й� 3.������� 4.���ڹ� 5.�举��]");
			System.out.println("[6.�ҽ��� 7.������ 8.�ٹ�� 9.������ 0.������         ]");
			System.out.print("������� ������? : ");
		}
		if (col.equals("7")) {
			System.out.println("            <==�����==>");
			System.out.println("[1.�ݶ� 2.��� 3.�޺��ݶ� 4.���� 5.���γ���C    ]");
			System.out.println("[6.���䷹�� 7.��ī�� 8.2% 9.Ʈ����ī�� 0.�Ϲٻ� ]");
			System.out.print("������� ������? : ");
		}
		if (col.equals("8")) {
			System.out.println("            <==�ҽ�==>");
			System.out.println("[1.���� 2.�ӽ�Ÿ�� 3.���� 4.������ 5.�����    ]");
			System.out.println("[6.�ʰ����� 7.���� 8.���ҽ� 9.�ּҽ� 0.Ÿ�ٽ��� ]");
			System.out.print("������� ������? : ");
		}
		if (col.equals("9")) {
			System.out.println("            <==��Ȱ��ǰ==>");
			System.out.println("[1.�վ 2.��Į 3.���� 4.�� 5.�׸� 6.����]");
			System.out.println("[7.���� 8.���� 9.�������� 0.������             ]");
			System.out.print("������� ������? : ");
		}

		sc.nextLine();
		sol = sc.next();

		HashMap<String, String> buyer = new HashMap<>();
		buyer = makeMap(col, sol);

		ArrayList<market> list = dao.AllMenu();

		if (list == null || list.size() == 0) {
			System.out.println("�ý��� ����� �����ϴ�.");
			return;
		} else {
			for (market m : list) {
				// ���⼭ vo�� �ٽ� �ʵ带 ��������� �Ѵ�
				// ���̺��� �޾ƾ� ������ �����ϴ�.
				// ������ ������ ��ǰ�� ������ ������� ���ݵ� ���̰� �ؾ� �Ѵ�
				System.out.print("���� : " + m.getTitle() + "\t");

				System.out.print("�̸� : " + m.getName() + "\t");

				System.out.println("����: " + m.getSell() + "\t");

				System.out.print("���� : " + m.getSum() + "\t");

				System.out.print("������� : " + m.getLimitdate() + "\t");

				System.out.println();

				// ���⿡ ���� ������ �־� ��� �Ѵ�.
				whereAreYouFrom = true;
				salesTable(m.getName());

				/*
				 * market market = new market();
				 * 
				 * System.out.println("[�˸�]�����Ͻ� ������ �Է��� �ּ���.>");
				 * 
				 * int buyingNum = sc.nextInt();
				 * 
				 * int modifiedNum = m.getSum() - buyingNum;
				 * 
				 * market.setSum(modifiedNum);
				 * 
				 * int totalBuyingPrice = buyingNum * m.getSell();
				 * 
				 * System.out.println("[�˸�]�� �ݾ���" + totalBuyingPrice + "");
				 */

				// ������ �� ���� �ݾ��� ���̺� ������ ��� �Ѵ�.
				// ���̺� ���� �ϳ� ����� ��� �Ѵ�
				// ���̸� (���� ���ٸ� ����Ʈ ������ �Ϲ� ���̶�� ���� �־� ��� �Ѵ�)
				// ������ �������� ���� ������ ��ǰ�� ��ǰ�� ���� ���� ,�� �׼��� �޾���� �Ѵ�.
				// ���� ������ ��ǰ�� ������ main table�� �������� ���� ���� modifiedBum�̶�
				// �̸����� �����Ͽ� �������ش�
			}

		}

	}

	public HashMap<String, String> makeMap(String num1, String num2) {

		HashMap<String, String> buyer = new HashMap<>();

		String title = "";

		String name = "";

		if (num1.equals("1")) {

			title = "ä��";

			if (num2.equals("1")) {

				name = "ȣ��";

			} else if (num2.equals("2")) {

				name = "����";

			} else if (num2.equals("3")) {

				name = "����";

			} else if (num2.equals("4")) {

				name = "����";

			} else if (num2.equals("5")) {

				name = "�̳���";

			} else if (num2.equals("6")) {

				name = "�丶��";

			} else if (num2.equals("7")) {

				name = "����̹���";

			} else if (num2.equals("8")) {

				name = "ǥ�����";

			} else if (num2.equals("9")) {

				name = "����";

			} else if (num2.equals("0")) {

				name = "���";
			}
		}
		if (num1.equals("2")) {

			title = "����";

			if (num2.equals("1")) {

				name = "���ڳ�";

			} else if (num2.equals("2")) {

				name = "��";

			} else if (num2.equals("3")) {

				name = "������";

			} else if (num2.equals("4")) {

				name = "�ƺ�ī��";

			} else if (num2.equals("5")) {

				name = "���";

			} else if (num2.equals("6")) {

				name = "�ٳ���";

			} else if (num2.equals("7")) {

				name = "�ڵ�";

			} else if (num2.equals("8")) {

				name = "���ξ���";

			} else if (num2.equals("9")) {

				name = "�޷�";

			} else if (num2.equals("0")) {

				name = "��";
			}
		}
		if (num1.equals("3")) {

			title = "����ǰ";

			if (num2.equals("1")) {

				name = "ġ��";

			} else if (num2.equals("2")) {

				name = "���÷�";

			} else if (num2.equals("3")) {

				name = "�䱸��Ʈ";

			} else if (num2.equals("4")) {

				name = "����Ÿġ��";

			} else if (num2.equals("5")) {

				name = "�����";

			} else if (num2.equals("6")) {

				name = "����";

			} else if (num2.equals("7")) {

				name = "����";

			} else if (num2.equals("8")) {

				name = "�ٳ�������";

			} else if (num2.equals("9")) {

				name = "�������";

			} else if (num2.equals("0")) {

				name = "���ڿ���";
			}
		}
		if (num1.equals("4")) {

			title = "���";

			if (num2.equals("1")) {

				name = "�Ŷ��";

			} else if (num2.equals("2")) {

				name = "�����";

			} else if (num2.equals("3")) {

				name = "�ʱ���";

			} else if (num2.equals("4")) {

				name = "���ĸ�";

			} else if (num2.equals("5")) {

				name = "�������";

			} else if (num2.equals("6")) {

				name = "¥�İ�Ƽ";

			} else if (num2.equals("7")) {

				name = "�����";

			} else if (num2.equals("8")) {

				name = "�ȵ������";

			} else if (num2.equals("9")) {

				name = "��¡��«��";

			} else if (num2.equals("0")) {

				name = "������";
			}
		}

		if (num1.equals("5")) {

			title = "����";

			if (num2.equals("1")) {

				name = "�����";

			} else if (num2.equals("2")) {

				name = "������";

			} else if (num2.equals("3")) {

				name = "��������";

			} else if (num2.equals("4")) {

				name = "���ڼ�����Ʈ";

			} else if (num2.equals("5")) {

				name = "��Ĩ";

			} else if (num2.equals("6")) {

				name = "����";

			} else if (num2.equals("7")) {

				name = "�ٳ���ű";

			} else if (num2.equals("8")) {

				name = "���ڼ���";

			} else if (num2.equals("9")) {

				name = "�ڰ�ġ";

			} else if (num2.equals("0")) {

				name = "����";
			}
		}
		if (num1.equals("6")) {

			title = "���̽�ũ��";

			if (num2.equals("1")) {

				name = "�ؾ�θ���";

			} else if (num2.equals("2")) {

				name = "��й�";

			} else if (num2.equals("3")) {

				name = "�������";

			} else if (num2.equals("4")) {

				name = "���ڹ�";

			} else if (num2.equals("5")) {

				name = "�举��";

			} else if (num2.equals("6")) {

				name = "�ҽ���";

			} else if (num2.equals("7")) {

				name = "������";

			} else if (num2.equals("8")) {

				name = "�ٹ��";

			} else if (num2.equals("9")) {

				name = "������";

			} else if (num2.equals("0")) {

				name = "������";
			}
		}
		if (num1.equals("7")) {
			title = "�����";
			if (num2.equals("1")) {
				name = "�ݶ�";
			} else if (num2.equals("2")) {
				name = "�ս�";
			} else if (num2.equals("3")) {
				name = "�޺��ݶ�";
			} else if (num2.equals("4")) {
				name = "����";
			} else if (num2.equals("5")) {
				name = "���γ���C";
			} else if (num2.equals("6")) {
				name = "���䷹��";
			} else if (num2.equals("7")) {
				name = "��ī��";
			} else if (num2.equals("8")) {
				name = "2%";
			} else if (num2.equals("9")) {
				name = "Ʈ����ī��";
			} else if (num2.equals("0")) {
				name = "�Ϲٻ�";
			}
		}
		if (num1.equals("8")) {
			title = "�ҽ�";
			if (num2.equals("1")) {
				name = "����";
			} else if (num2.equals("2")) {
				name = "�ӽ�Ÿ��";
			} else if (num2.equals("3")) {
				name = "����";
			} else if (num2.equals("4")) {
				name = "������";
			} else if (num2.equals("5")) {
				name = "�ͻ��";
			} else if (num2.equals("6")) {
				name = "�ʰ�����";
			} else if (num2.equals("7")) {
				name = "����";
			} else if (num2.equals("8")) {
				name = "���ҽ�";
			} else if (num2.equals("9")) {
				name = "�ּҽ�";
			} else if (num2.equals("0")) {
				name = "Ÿ�ٽ���";
			}
		}
		if (num1.equals("9")) {
			title = "��Ȱ��ǰ";
			if (num2.equals("1")) {
				name = "�վ";
			} else if (num2.equals("2")) {
				name = "��Į";
			} else if (num2.equals("3")) {
				name = "����";
			} else if (num2.equals("4")) {
				name = "��";
			} else if (num2.equals("5")) {
				name = "�׸�";
			} else if (num2.equals("6")) {
				name = "����";
			} else if (num2.equals("7")) {
				name = "����";
			} else if (num2.equals("8")) {
				name = "����";
			} else if (num2.equals("9")) {
				name = "��������";
			} else if (num2.equals("0")) {
				name = "������";
			}
		}

		buyer.put("title", title);
		buyer.put("name", name);

		return buyer;
	}

	public void refund() {

	}

	// �ڽ��� �����ϰ� ���� ������ �ȴٸ� �ٷ� ������ �� �ֵ��� ����� ���ƾ� �Ѵ�

	public void buyNow() {
		whereAreYouFrom = false;
		market market = new market();

		// System.out.println("[�˸�]�����Ͻ� ��ǰ ������ �Է��� �ּ���.");

		// col = sc.next();

		System.out.println("[�˸�]�����Ͻ� ��ǰ���� �Է��� �ּ���.");
		String name = sc.next();

		// text = sc.next();// ��ǰ���� �Է��ϸ� ��ǰ�� ������ ����� �� �� �־�� �Ѵ�.

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
	 * System.out.println("[�˸�]�����Ͻ� ��ǰ�� ������ �Է��� �ּ���.");
	 * 
	 * int productNumber = sc.nextInt(); // main�� ���Ӱ� ������ ��� �Ѵ� int
	 * modifiedProductNumber = market.getSum() - productNumber;
	 * 
	 * int totalPrice = market.getSell() * productNumber;
	 * 
	 * System.out.println("�� ������ " + totalPrice + "�Դϴ�");
	 * 
	 * System.out.println("[�˸�]���Ÿ� ��� �Ͻðڽ��ϱ�?(Y/N)");
	 * 
	 * String keepShop = sc.next();
	 * 
	 * int sum = +totalPrice;
	 * 
	 * if (keepShop.equals("Y") || keepShop.equals("y")) { continue;
	 * 
	 * } else {
	 * 
	 * System.out.println("�� ���� ������" + sum); System.out.println("[�˸�]ȸ���̽ʴϱ�?(Y/N)");
	 * String answer = sc.next(); if (answer.equals("Y") || answer.equals("y")) {
	 * System.out.println("[�˸�]�α��� �Ͻðڽ��ϱ�?(Y/N)"); String answer2 = sc.next(); if
	 * (answer2.equals("Y") || answer2.equals("y")) { userLogIn(); if
	 * (market.getPoint() != 0) { System.out.println("[�˸�]��밡���� ����Ʈ�� �����մϴ�.");
	 * System.out.println("��� �Ͻðڽ��ϱ�?(Y/N)"); String answer3 = sc.next(); if
	 * (answer3.equals("Y") || answer3.equals("y")) {
	 * 
	 * System.out.println(sum - market.getPoint() + "�� �Դϴ�."); // ���� ���̺��� ����
	 * mapper�� ���� �����༭ // ����� ��� �Ѵ� System.out.println("�̿��� �ּż� �����մϴ�."); int point
	 * = (sum - market.getPoint()) / 10; market.setPoint(point);// ������� �ذ� market =
	 * dao.insertUser(market); }
	 * 
	 * } } else { System.out.println("[�˸�]������ �Ϸ�Ǿ����ϴ�");
	 * System.out.println("�̿��� �ּż� �����մϴ�."); }
	 * 
	 * System.out.println("[�˸�]������ �ٽ� ����ּ���."); flag = false;
	 * 
	 * }
	 * 
	 * } }
	 */

	public void deleteUser() {
		// ȸ�� ���� ���� �޼ҵ�
		System.out.println("[�˸�]ȸ�� Ż���Ͻ� �ڽ��ϱ�?");

	}

}