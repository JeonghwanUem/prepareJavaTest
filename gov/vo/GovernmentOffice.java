package gov.vo;

import java.io.Serializable;

public class GovernmentOffice implements Serializable {
	private String officeId;
	private String name;
	private String address;
	private int employeeCount;
	
	public GovernmentOffice() {	}

	public GovernmentOffice(String officeId, String name, String address, int employeeCount) {
		this.officeId = officeId;
		this.name = name;
		this.address = address;
		this.employeeCount = employeeCount;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	@Override
	public String toString() {
		return "관리 번호: " + this.officeId + ", 관공서 명: " + this.name + 
				", 주소: " + this.address + ", 직원 수: " + this.employeeCount;
	}
}
