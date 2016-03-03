package shopping.cart;

public class Customer {
	int cId;
	String cName;
	String isMember;
	
	public Customer() {}
	
	public Customer(int cId, String cName, String isMember) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.isMember = isMember;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getIsMember() {
		return isMember;
	}

	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}

}
