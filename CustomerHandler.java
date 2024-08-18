package application;

public class CustomerHandler {
	   private Integer customerId = null;
	   private String cFirstName = null;
	   private String cLastName = null;
	   private Integer cBillId = null;
//	   private Integer pnumber = null;
	   private String cStreetAddress = null;
	   private String pcode = null;
	   private String cTowns = null;
	   private Integer hNumber = null;
	   private Integer numberVisits = null;

	   public CustomerHandler() {
		   
	   }
	   
	   public CustomerHandler(Integer customerId, String cFirstName, String cLastName, Integer cBillId, String cStreetAddress, String pcode, String cTowns, Integer hNumber ,Integer numberVisits) {
		   this.customerId = customerId;
		   this.cFirstName = cFirstName;
		   this.cLastName = cLastName;
		   this.cBillId = cBillId;
//		   this.pnumber = pnumber;
		   this.cStreetAddress = cStreetAddress; 
		   this.pcode = pcode;
		   this.cTowns = cTowns;
		   this.hNumber = hNumber;
		   this.numberVisits = numberVisits;
	   }
	   
	   
	   public CustomerHandler(Integer customer_ID, Integer bill_ID, String firstName, String lastName,
			String street_address, String post_code, Integer house_number, String town, Integer visits) {
		// TODO Auto-generated constructor stub
	}

	public Integer getcustomer_ID() {
		   return customerId;
	   }
	   public void setcustomer_ID(Integer customerId) {
		   this.customerId = customerId;
	   }
	   
	   public String getfirstname() {
		   return cFirstName;
	   }
	   public void setfirstname(String cFirstName) {
		   this.cFirstName = cFirstName;
	   }
	   
	   public String getlastName() {
		   return cLastName;
	   }
	   public void setlastName(String cLastName) {
		   this.cLastName = cLastName;
	   }
	   
	   public Integer getbill_ID() {
		   return cBillId;
	   }
	   public void setbill_ID(Integer cBillId) {
		   this.cBillId = cBillId;
	   }
	   
//	   public Integer getphoneNumber() {
//		   return pnumber;
//	   }
//	   public void setphoneNumber(Integer pnumber) {
//		   this.pnumber = pnumber;
//	   }
	   
	   public String getstreetaddress() {
		   return cStreetAddress;
	   }
	   public void setstreetaddress(String cStreetAddress) {
		   this.cStreetAddress = cStreetAddress;
	   }
	   
	   public String getpcode() {
		return pcode;
	   }
	   public void setpcode(String pcode) {
		   this.pcode = pcode;
	   }
	   
	   public Integer gethNumber(){
		   return hNumber;
	   }
	   
	  public void sethNumber(Integer hNumber) {
		  this.hNumber = hNumber;
	  }
	   
	   public String getcTowns() {
		   return cTowns;
	   }
	   public void setcTowns(String cTowns){
		   this.cTowns = cTowns;
	   }
	   
	   public Integer getVisits() {
		   return numberVisits;
	   }
	   public void setVisits(Integer numberVisits) {
		   this.numberVisits = numberVisits;
	   }
	   
	   
	   
	   
}
