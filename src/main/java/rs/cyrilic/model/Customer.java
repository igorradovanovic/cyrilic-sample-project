package rs.cyrilic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customers")
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cst_id")
	private Long cstId;
	
	@Column(name = "cst_name")
	private String cstName;
	
	@Column(name = "cst_main_address")
	private String cstMainAddress;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cst_size_id")
	private CustomerSize cstCustomerSize;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cst_sys_create_date")
	private Date cstSysCreateDate;


	public Long getCstId() {
		return cstId;
	}


	public void setCstId(Long cstId) {
		this.cstId = cstId;
	}


	public String getCstName() {
		return cstName;
	}


	public void setCstName(String cstName) {
		this.cstName = cstName;
	}


	public String getCstMainAddress() {
		return cstMainAddress;
	}


	public void setCstMainAddress(String cstMainAddress) {
		this.cstMainAddress = cstMainAddress;
	}


	public CustomerSize getCstCustomerSize() {
		return cstCustomerSize;
	}


	public void setCstCustomerSize(CustomerSize cstCustomerSize) {
		this.cstCustomerSize = cstCustomerSize;
	}


	public Date getCstSysCreateDate() {
		return cstSysCreateDate;
	}


	public void setCstSysCreateDate(Date cstSysCreateDate) {
		this.cstSysCreateDate = cstSysCreateDate;
	}
	
	
	
	
}


