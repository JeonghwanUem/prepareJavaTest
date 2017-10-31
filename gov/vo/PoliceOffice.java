package gov.vo;

public class PoliceOffice extends GovernmentOffice {
	private String district;
	
	public PoliceOffice() {	}

	public PoliceOffice(String officeId, String name, String address, int employeeCount,
			String district) {
		super(officeId, name, address, employeeCount);
		this.district = district;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return super.toString() + ", 관할 구역: " + this.district;
	}
}
