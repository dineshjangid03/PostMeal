package com.postmeal.Model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	private Integer addressId;
	
	private String buildingName;
	
	private String StreetNo;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	
	private String type;

	@Override
	public int hashCode() {
		return Objects.hash(StreetNo, addressId, area, buildingName, city, country, pincode, state, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(StreetNo, other.StreetNo) && Objects.equals(addressId, other.addressId)
				&& Objects.equals(area, other.area) && Objects.equals(buildingName, other.buildingName)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(state, other.state)
				&& Objects.equals(type, other.type);
	}
	
	
}
