package gov.vo;

public class FireStation extends GovernmentOffice {
	private int firetruckCount;
	
	public FireStation() {	}

	public FireStation(String officeId, String name, String address, int employeeCount,
			int firetruckCount) {
		super(officeId, name, address, employeeCount);
		this.firetruckCount = firetruckCount;
	}

	public int getFiretruckCount() {
		return firetruckCount;
	}

	public void setFiretruckCount(int firetruckCount) {
		this.firetruckCount = firetruckCount;
	}

	@Override
	public String toString() {
		return super.toString() + ", 소방차 수: " + this.firetruckCount;
	}

}
