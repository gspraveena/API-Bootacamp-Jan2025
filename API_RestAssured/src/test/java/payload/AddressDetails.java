package payload;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDetails {
	
	 @JsonProperty("plotNumber") // Ensure the names match exactly or use this annotation
	    private String plotNumber;

	    @JsonProperty("street") // Note the capitalization
	    private String street;

	    @JsonProperty("state")
	    private String state;

	    @JsonProperty("country")
	    private String country;

	    @JsonProperty("zipCode")
	    private String zipCode;

	
	public String getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	

}
