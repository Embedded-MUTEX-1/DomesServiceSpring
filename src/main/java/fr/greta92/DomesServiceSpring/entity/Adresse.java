package fr.greta92.DomesServiceSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * 
 */
@Embeddable
public class Adresse {

	/**
     * 
     */
	@Column(name = "nom_adresse")
    private String addrName;

    /**
     * 
     */
	@Column(name = "adresse")
    private String address;

    /**
     * 
     */
	@Column(name = "code_postale")
    private String postalCode;

    /**
     * 
     */
	@Column(name = "ville")
    private String city;

    /**
     * 
     */
	@Column(name = "pays")
    private String country;
    
    /**
     * Default constructor
     */
    public Adresse() {
    }

    public Adresse(String addrName, String address, String postalCode, String city, String country) {
		super();
		this.addrName = addrName;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Adresse{" +
				"addrName='" + addrName + '\'' +
				", address='" + address + '\'' +
				", postalCode='" + postalCode + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}