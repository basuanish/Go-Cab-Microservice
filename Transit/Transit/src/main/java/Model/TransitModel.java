package Model;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "cabs") 
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})   //Serialization issue
public class TransitModel {
	
	private int number;
	private String cab_type;
	private String name;
	private String status ;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCab_type() {
		return cab_type;
	}
	public void setCab_type(String cab_type) {
		this.cab_type = cab_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
