package de.twist.basketballgameservice.models.submodels;

public class Location {
	
	private String street;
	private String zipCode;
	private String city;

	/** Constructors */
	public Location() {
	}

	/** Getters */
	public String getStreet() {
		return street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getCity() {
		return city;
	}

	/** Setters */
	public void setStreet(String street) {
		this.street = street;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
