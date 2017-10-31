package gov.ui;

import java.util.List;
import java.util.Scanner;

import gov.manager.Manager;
import gov.vo.FireStation;
import gov.vo.GovernmentOffice;
import gov.vo.PoliceOffice;

public class UI {
	private Manager manager;
	private Scanner scanner;
	
	/**
	 * Constructor
	 */
	public UI() {
		scanner = new Scanner(System.in);
		manager = new Manager();
	}
	
	/**
	 * UI를 시작한다
	 */
	public void start() {
		boolean canContinue = true;
		while(canContinue) {
			int option = printMainMenu();
			
			switch(option) {
				case 1:
					insert();
					break;
					
				case 2:
					search();
					break;
					
				case 3:
					delete();
					break;
					
				case 4:
					print();
					break;
					
				case 5:
					printNumOfEachOffices();
					break;
					
				case 6:
					printNumOfEmployees();
					break;
					
				case 9:
					canContinue = false;
					manager.saveFile();
					break;
					
				default:
					System.out.println("잘못 입력하셨습니다");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * 메인 메뉴를 표시한다.
	 * @return 메인 메뉴 선택 번호
	 */
	private int printMainMenu() {
		int option = 0;
		
		do {
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│ 관공서 관리 시스템					│");
			System.out.println("└───────────────────────────────┘");
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│1.등록                    					│");	
			System.out.println("│2.찾기                    					│");	
			System.out.println("│3.삭제                    					│");	
			System.out.println("│4.전체출력 						│");
			System.out.println("│5.관공서 별 갯수 출력					│");	
			System.out.println("│6.전체 종사자 수 출력					│");	
			System.out.println("│9.종료							│");
			System.out.println("└───────────────────────────────┘");
			System.out.print(" 메뉴 번호를 선택하세요=> ");	
			
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("다시 입력해주세요");
				System.out.println();
				scanner.next();
			}
		} while (option == 0);
		
		System.out.println();
		
		return option;
	}
	
	/**
	 * 관공서 정보를 등록한다
	 */
	private void insert() {
		boolean canContinue = true;
		
		while(canContinue) {
			int option = printInsertMenu();
			
			if (option == 9) {
				break;
			}
			
			if (option < 1 || 3 < option) {
				System.out.println("잘못 입력하셨습니다");
				continue;
			}
			
			// GovernmentOffice를 저장할 변수 선언
			GovernmentOffice t = null;
			
			System.out.print("|관리번호| ");
			String officeId = scanner.next();
			
			System.out.print("|관공서 명| ");
			String name = scanner.next();
			
			System.out.print("|주소| ");
			String address = scanner.next();
			
			System.out.print("|직원 수| ");
			int numOfEmployees = scanner.nextInt();
			
			if (option == 1) {
				System.out.print("|관할구역| ");
				String district = scanner.next();
				
				t = new PoliceOffice(officeId, name, address, numOfEmployees, district);
			} else if (option == 2) {
				System.out.print("|소방차 수| ");
				int numOfFireCars = scanner.nextInt();
				
				t = new FireStation(officeId, name, address, numOfEmployees, numOfFireCars);
			}
			
			// 등록 작업
			boolean canInsert = manager.insert(t);
			if (canInsert) {
				System.out.println("등록에 성공했습니다");
			} else {
				System.out.println("등록에 실패했습니다");
			}
		}
	}
	
	/**
	 * 등록 메뉴를 표시한다
	 */
	private int printInsertMenu() {
		int option = 0;
		
		do {
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│        관공서 등록				│");
			System.out.println("└───────────────────────────────┘");
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│1.경찰서							│");	
			System.out.println("│2.소방서							│");	
			System.out.println("│9.상위메뉴						│");
			System.out.println("└───────────────────────────────┘");
			System.out.print(" 메뉴 번호를 선택하세요=> ");	
			
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("다시 입력해주세요");
				scanner.next();
			}
		} while(option == 0);
		
		System.out.println();
		
		return option;
	}
	
	/**
	 * 관공서을 검색하여 출력한다
	 */
	private void search() {
		System.out.println("===== 관공서 검색 =====");
		System.out.print("|관리번호| ");
		
		String code = scanner.next();

		System.out.println();
		
		GovernmentOffice t = manager.search(code);
		
		if (t == null) {
			System.out.println("관리번호에 해당하는 정보가 존재하지 않습니다");
		} else {
			System.out.println("===== 관공서 정보 =====");	
			System.out.println(t);
		}
	}
	
	/**
	 * 관공서 정보를 삭제한다
	 */
	private void delete() {
		String code;
		System.out.println("===== 관공서 삭제 =====");
		System.out.print("|관리번호| ");
		//여기다 숫자만 적게 할려고 트라이문을 쓰면 밑에 delete(code)가 오류가 난다 //숫자를 입력하라는 것은 arthi
		code = scanner.next();
		
		System.out.println();
		
		boolean canDelete = manager.delete(code);
		
		if(canDelete) {
			System.out.println("삭제에 성공하였습니다");
		}
		else {
			System.out.println("삭제에 실패하였습니다");
		}
	}
	
	/**
	 * 전체 관공서 정보를 출력한다
	 */
	public void print() {
		System.out.println("===== 관공서 출력 =====");
		
		List<GovernmentOffice> list = manager.getOfficeList();
		
		if (list.isEmpty()) {
			System.out.println("관공서 정보가 한 건도 존재하지 않습니다");
			return;
		}
		
		for (GovernmentOffice g : list) {
			System.out.println(g);
		}
	}
	
	/**
	 * 관공서 별 수를 출력한다
	 */
	public void printNumOfEachOffices() {
		System.out.println("===== 관공서 별 수 =====");
		System.out.println("경찰서 수: " + manager.getPoliceOfficeCount());
		System.out.println("소방서 수: " + manager.getFireStationCount());
	}
	
	/**
	 * 전체 종사자 수를 출력한다
	 */
	public void printNumOfEmployees() {
		System.out.println("===== 전체 종사자 수 =====");
		System.out.println("종사자 수: " + manager.getEmployeeCount());
	}
}
