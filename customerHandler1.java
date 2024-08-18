package application;

public class customerHandler1 {
	private Integer customerId = null;
	private String cFirstName = null;
	private String cLastName = null;
	private Integer numberVisits = null; 
				   
			   		   
	public customerHandler1( Integer customerId, String cFirstName, String cLastName, Integer numberVisits) {
		this.customerId = customerId;
		this.cFirstName  = cFirstName;
		this.cLastName = cLastName;
		this.numberVisits = numberVisits;
	}
			   		   
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
			   
	public String getCFirstName() {
		return cFirstName;
	}
	public void setCFirstName(String cFirstName) {
		this.cFirstName = cFirstName;
	}
			   
	public String getCLastName() {
		return cLastName;
	}
	public void setCLastName(String cLastName) {
		this.cLastName = cLastName;
	}
			      
	public Integer getNumberVisits() {
		return numberVisits;
	}
	public void setNumberVisits(Integer numberVisits) {
		this.numberVisits = numberVisits;
	}			   
}
