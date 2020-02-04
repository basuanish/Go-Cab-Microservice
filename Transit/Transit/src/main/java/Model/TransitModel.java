package Model;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "cabs") 
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})   //Serialization issue
public class TransitModel {

}
