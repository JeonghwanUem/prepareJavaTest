package gov.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import gov.vo.FireStation;
import gov.vo.GovernmentOffice;
import gov.vo.PoliceOffice;

public class Manager {
	private final String FILE_NAME = "gov.dat";

	private ArrayList<GovernmentOffice> officeList; // 관공서 리스트
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int saveFileInt = 0;
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Constructor
	 */
	public Manager() {
		if (new File(FILE_NAME).exists()) {
			loadFile();
		} else {
			officeList = new ArrayList<GovernmentOffice>();
		}
	}

	/**
	 * gov.dat를 저장한다
	 */
	public void saveFile() {
		// CODE HERE
		
		try {
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(officeList);
			saveFileInt++;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream();
		}

	}

	/**
	 * gov.dat를 불러온다
	 */
	public void loadFile() {
		// CODE HERE
		try {
			fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			officeList = (ArrayList<GovernmentOffice>)ois.readObject();
		} catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			closeStream();
		}
	
		
	}

	/**
	 * 관공서 정보를 저장한다. 관공서는 관리 번호에 의해 분류되고 중복될 수 없다.
	 * 
	 * @param office
	 *            저장할 관공서 정보
	 * @return 저장 여부
	 */
	public boolean insert(GovernmentOffice office) {
		// CODE HERE
		GovernmentOffice find_o = search(office.getAddress());
		if(find_o != null) {
			return false;
		}
		
		officeList.add(office);
		
		if(saveFileInt == 1) {
			officeList.remove(office);
			return false;
		}
			return true;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 찾는다.
	 * 
	 * @param officeId
	 *            검색할 관공서의 관리 번호
	 * @return 일치하는 관공서 정보
	 */
	public GovernmentOffice search(String officeId) {
		// CODE HERE
		for(GovernmentOffice o : officeList) {
			if(o.getOfficeId().equals(officeId)) {
				return o;//불린 문이 아니니깐 t/f를 return할 수 없다 
			}
		}
		return null;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 삭제한다.
	 * 
	 * @param officeId
	 *            삭제할 관공서의 관리 번호
	 * @return 삭제 여부
	 */
	public boolean delete(String officeId) {
		// CODE HERE
		for(GovernmentOffice o : officeList) {
			if(o.getOfficeId().equals(officeId))
			officeList.remove(o);
			saveFile();
			return true;
		}
		return false;
	}

	/**
	 * 관공서 리스트를 얻는다
	 * 
	 * @return
	 */
	public ArrayList<GovernmentOffice> getOfficeList() {
		return officeList;
	}

	/**
	 * 경찰서의 숫자를 얻는다
	 * 
	 * @return 경찰서의 수
	 */
	public int getPoliceOfficeCount() {
		// CODE HERE
		int count = 0;
		GovernmentOffice po = new GovernmentOffice();
		for (int i =0 ; i<this.officeList.size();i++) {
			po = officeList.get(i);//여기가 정확이 뭔지 모르겠다 
			if(po instanceof PoliceOffice) 
				count++;
			
		}
			return count;
		
	}

	/**
	 * 소방서의 숫자를 얻는다
	 * 
	 * @return 소방서의 수
	 */
	public int getFireStationCount() {
		int count = 0;
		
		// CODE HERE
		GovernmentOffice fi = new GovernmentOffice();
		for (int i =0 ; i<this.officeList.size();i++) {
			fi = officeList.get(i);//여기가 정확이 뭔지 모르겠다 
			if(fi instanceof FireStation) 
				count++;
			
		}
			return count;
		
	}

	/**
	 * 전체 관공서의 종사자 수를 얻는다
	 * 
	 * @return 전체 관공서의 종사자 수
	 */
	public int getEmployeeCount() {
		int sum = 0;

		// CODE HERE
		for (int i = 0; i < this.officeList.size(); i++)
			sum += officeList.get(i).getEmployeeCount(); 

		return sum;
	}
	

	public void closeStream() {
		if (fis != null) {
			try {

				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
