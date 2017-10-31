package toy.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import toy.vo.Bicycle;
import toy.vo.Drone;
import toy.vo.GameConsole;
import toy.vo.Toy;

/**
 * 장난감 정보를 관리하는 클래스
 */
public class Manager {
	private final String FILE_NAME = "toyList.dat";
	
	private ArrayList<Toy> toyList;		// 장난감 리스트
	//여기서는 왜 스트림을 안 열어줘도 되냐
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@하시라는 말을 없었지만 일단 os상에 정보를 저장해야 하기 때문에 stream을 만든다
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int saveFileInt = 0 ;
	
	

	/**
	 * Constructor
	 */
	public Manager() {
		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			toyList = new ArrayList<Toy>();
		}
	}
	
	/**
	 * toyList.dat를 저장한다
	 */
	public void saveFile() {//이거 왜 불린으로 안되있음??????//void는 return할 수 없다 
		// CODE HERE
		//이 문구가 void임으로 boolean을 쓸수는 없다
		
		//새로운 불린 변수를 하나 만들어 준다 
		
		try {
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(toyList);
			
			oos.flush();
			
			saveFileInt++;
			

		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			closeStreams();
		}
		
	}
	
	/**
	 * toyList.dat를 불러온다
	 */
	public void loadFile() {
		// CODE HERE
		try {
			fis = new FileInputStream(FILE_NAME);//new안적음
			ois = new ObjectInputStream(fis);
			toyList = (ArrayList<Toy>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {//여기는 closeStream만들기 전임 
			if (fos != null) {
				try {
					fos.close();
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
	
	/**
	 * 장난감을 저장한다. 장난감은 code에 의해 분류되고 같은 code는 사용할 수 없다.
	 * @param toy 저장할 장난감 정보
	 * @return 저장 여부
	 */
	public boolean insert(Toy toy) {
		// CODE HERE
		Toy find_t = search(toy.getCode());//입력되 있는 값을 find_t값에 입력받는ㄷ ㅏ
		if(find_t !=null) {                //find_t가 null값이 아니라면
			return false; 				 	// false값을 리턴 받는다 
		}
		
		toyList.add(toy);					//만약 저 if문을 지나지 않는다면 toy의 값들이 toyList에 저장된다
						//return true;//처음에 여기 return값을 실수로 넣어놔서 밑에서도 계속 unreable code 가 떳다 주의하자 
		
		if(saveFileInt ==1) {					//그리고 만약 값들이 제대로 저장되지 않을 시의 경우도 생각해야 된다. 
			toyList.remove(toy);
			return false;
		}
	
		
			return true;
}




	/**
	 * code를 통해 장난감을 찾는다. 코드가 일치하는 장난감을 찾으면 그것을 반환한다.
	 * @param code 검색할 장난감 코드
	 * @return 일치하는 장난감 정보
	 */
	public Toy search(String code) {//code를 통해 같은 장남감인지 판단해서 정보를 출력해야 함
		// CODE HERE
		for(Toy t : toyList) {      //반복문을 통해 toyList안에 있는 정보를 전부 입력받아서 
			if(t.getCode().equals(code)) { //만약 방금 입력한 code값이랑 같은 값이 있다면 
				return t; 					//그 t의 정보를 출력한다 toString을 쓰고있으므로 따로 출력문을 쓰지 않아도 된다 
			}
		}
		return null;
	}

	/**
	 * code를 통해 장난감을 삭제한다. 코드가 일치하는 장난감을 찾으면 삭제한다. 
	 * @param code 삭제할 장난감 코드
	 * @return 삭제 여부
	 */
	public boolean delete(String code) {
		// CODE HERE
		for(Toy t : toyList) {
			if(t.getCode().equals(code))
				toyList.remove(t);
				return true;
		}
		return false;
	}

	/**
	 * 장난감 리스트를 얻는다
	 * @return 장난감 리스트
	 */
	public ArrayList<Toy> getToyList() {
		return toyList;
	}
	
	private void closeStreams() {
		
		if(fis!=null) {
			try 
			{
				fis.close();

			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(fos!=null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(ois!=null) {
			try {
				ois.close();

			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(oos!=null) {
			try {
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
