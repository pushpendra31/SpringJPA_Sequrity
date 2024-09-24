package Spring.Data.JPA.SpringJPA_Sequrity.DTOs;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class ProductMaster {

@Temporal(TemporalType.TIMESTAMP)
Date crtdt;
	    public Date getCrtdt() {
	return crtdt;
}

public void setCrtdt(Date crtdt) {
	this.crtdt = crtdt;
}

		public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "product_id")
	    private Long pid;

	    @Column(name = "name", nullable = false, unique = true)
	    private String name;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "quantity", nullable = false)
	    private Integer quantity;

	    @Column(name = "price", nullable = false)
	    private Integer price;

}
