package APIAutomation.PojoClassExample;

public class ComplexArrayJsonBasicInfo {
	
	private String firstName;
	private String lastName;
	private String id;
	private ComplexJsonaddress1info[] address;
	
	public void setAddress(ComplexJsonaddress1info[] address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ComplexJsonaddress1info[] getAddress() {
		return address;
	}
}
