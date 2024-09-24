package Spring.Data.JPA.SpringJPA_Sequrity.DTOs;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name ="persons")
@Cacheable

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class LoginRegisterDTO implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PersonID")
	private int personid;	
	private String  Fname;
	private String LastName;
	private String  Address;
	@Column(name = "City")
	private String city;
	private String Email;
	private String password;
	@Column(name = "gender")
	private String Gender;	

	@Column(name = "contact_no")
//@ValidContact  not  working  properly now  
       private Long contact;	
		/*
		 * @Column(name = "username") private String username;
		 */

	/*
	 * @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "prd") thhis  for  if  we are usinng mapping and need  cache both 
	 * 
	 * @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	 * //@JoinColumn(name = "sbid") private List<Subcat> subcls;
	 */
	@Transient
	private boolean flag;
	private String  role;
	
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "LoginRegisterDTO [personid=" + personid + ", Fname=" + Fname + ", LastName=" + LastName + ", Address="
				+ Address + ", city=" + city + ", Email=" + Email + ", password=" + password + ", Gender=" + Gender
				+ ", contact=" + contact + ", flag=" + flag + ", role=" + role + ", date=" + date + "]";
	}
	
	
	@Column(name = "CRT_DT")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private String date;
	public int getPersonid() {
		return personid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}

public void show() {
	System.out.println("component  as class  bean ");
}  
}


