package application;

public class searchHandler {
	   private Integer itemsId = null;
	   private String itemNaming = null;
	   private Double itemCost = null;
	   private String itemDescription = null;


public searchHandler(Integer itemsId, String itemNaming, Double itemCost, String itemDescription) {
	this.itemsId = itemsId;
	this.itemNaming = itemNaming;
	this.itemCost = itemCost;
	this.itemDescription = itemDescription;
}

public Integer getItemsId() {
	return itemsId;
}
public void setItemId(Integer itemsId) {
	this.itemsId = itemsId;
}


public String getItemNaming() {
	return itemNaming;
}
public void SetItemNaming(String itemNaming) {
	this.itemNaming = itemNaming;
}


public Double getItemCost() {
	return itemCost;
}
public void setItemCost(Double itemCost) {
	this.itemCost = itemCost;
}


public String getItemDescription() {
	return itemDescription;
}
public void setItemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
}

}
