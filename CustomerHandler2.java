package application;

public class CustomerHandler2 {
	
		   private Integer customerId = null;
		   private String cFirstName = null;
		   private String cLastName = null;
		   private String cStreetAddress = null;
		   private String pcode = null;
		   private String cTowns = null;
		   private String hNumber = null;
		   private Integer numberVisits = null; 
			   
		   		   
		   public CustomerHandler2(Integer customerId, String cFirstName, String cLastName, String cStreetAddress, String pcode, String town,  String hNumber,Integer numberVisits) {
			   this.customerId = customerId;
			   this.cFirstName  = cFirstName;
			   this.cLastName = cLastName;
//			   this.cBillId = cBillId;
			   this.cStreetAddress = cStreetAddress; 
			   this.pcode = pcode;
			   this.cTowns= town;
			   this.hNumber  = hNumber;
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
		   
//		   public Integer getCbillId() {
//			   return cBillId;
//		   }
//		   public void setCbillId(Integer cBillId) {
//			   this.cBillId = cBillId;
//		   }
		   
		   public String getCStreetAddress() {
			   return cStreetAddress;
		   }
		   public void setCStreetAddress(String cStreetAddress) {
			   this.cStreetAddress = cStreetAddress;
		   }
		   
		   public String getPcode() {
			return pcode;
		   }
		   public void setPcode(String pcode) {
			   this.pcode = pcode;
		   }
		   
		   public String getHNumber(){
			   return hNumber;
		   }
		   
		  public void setHNumber(String hNumber) {
			  this.hNumber = hNumber;
		  }
		   
		   public String getCTowns() {
			   return cTowns;
		   }
		   public void setCTowns(String cTowns){
			   this.cTowns = cTowns;
		   }
		   
		   public Integer getNumberVisits() {
			   return numberVisits;
		   }
		   public void setNumberVisits(Integer numberVisits) {
			   this.numberVisits = numberVisits;
		   }
		   
		   
		   
		   
	}


