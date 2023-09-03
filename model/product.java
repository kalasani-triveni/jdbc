package model;

public class product {
	private int productid;
	private String productname;
	private int productprice;
	private int productquantity;
	private int minsellquantity;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public int getMinsellquantity() {
		return minsellquantity;
	}
	public void setMinsellquantity(int minsellquantity) {
		this.minsellquantity = minsellquantity;
	}
	public int getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

}
