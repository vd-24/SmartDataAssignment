package com.smartdatasolutions.test;

import java.util.Objects;

public class Member {

	private String	id;
	private String	address;
	private String	city;
	private String	firstName;
	private String	lastName;
	private String	state;
	private String	zip;

	public void setId( String id ) {
		this.id = id;
	}

	public String getId( ) {
		return id;
	}

	public String getAddress( ) {
		return address;
	}

	public String getCity( ) {
		return city;
	}

	public String getFirstName( ) {
		return firstName;
	}

	public String getLastName( ) {
		return lastName;
	}

	public String getState( ) {
		return state;
	}

	public String getZip( ) {
		return zip;
	}

	public void setAddress( String address ) {
		this.address = address;
	}

	public void setCity( String city ) {
		this.city = city;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public void setState( String state ) {
		this.state = state;
	}

	public void setZip( String zip ) {
		this.zip = zip;
	}

	public String toCSVString( ) {
		return this.getId()+","+this.getFirstName()+","+this.getLastName()+","+this.getAddress()+","+this.getCity()+","+this.getZip();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, city, firstName, id, lastName, state, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(state, other.state)
				&& Objects.equals(zip, other.zip);
	}

	
	

}
