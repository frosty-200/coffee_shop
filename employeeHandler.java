package application;

public class employeeHandler {
      private Integer employeeId = null;
      private String employeeFirst = null;
      private String employeeLast = null;
      private String streetAddress = null;
      private String postcode = null;
      private String houseNum = null;
    		  
      
      
	public employeeHandler(Integer employeeId, String employeeFirst, String employeeLast, String streetAddress, String postcode, String houseNum) {
		this.employeeId = employeeId;
		this.employeeFirst = employeeFirst;
		this.employeeLast = employeeLast;
		this.streetAddress = streetAddress;
		this.postcode = postcode;
		this.houseNum = houseNum;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeFirst() {
		return employeeFirst;
	}
	public void setEmployeeFirst(String employeeFirst) {
		this.employeeFirst = employeeFirst;
	}
	
	public String getEmployeeLast() {
		return employeeLast;
	}
	public void setEmplyeeLast(String employeeLast) {
		this.employeeLast = employeeLast;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
}
