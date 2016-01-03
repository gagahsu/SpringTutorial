import java.io.Serializable;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;  

@Entity
@Table(name="raytest")   
public class Raytest implements Serializable {  

   private static final long serialVersionUID = 619443250978905802L;
   
   @Id
   @Column(name="phone")
   String phone; 
   
   @Column(name="firstname")
   String firstname;
   
   @Column(name="lastname")
   String lastname;
   
   @Column(name="address")
   String address;
   
   public String getPhone() {
   	  return phone;
   }
   
   public void setPhone(String phone) {
   	  this.phone = phone;
   }
   
   public String getFirstname() {
   	  return firstname;
   }
   
   public void setFirstname(String firstname) {
   	  this.firstname = firstname;
   }
   
   public String getLastname() {
   	  return lastname;
   }
   
   public void setLastname(String lastname) {
   	  this.lastname = lastname;
   }
   
   public String getAddress() {
   	  return address;
   }
   
   public void setAddress(String address) {
   	  this.address = address;
   }
} 
