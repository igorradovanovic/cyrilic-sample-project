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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="accounts")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "acc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accId;
	
	@Column(name = "acc_name")
	private String accName;
	
	@Column(name = "acc_number")
	private String accNumber;
	
	@Column(name = "acc_valid")
	private Boolean accValid;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="acc_cst_id")
	private Customer customer;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "acc_sys_create_date")
	private Date accSysCreateDate;

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public Boolean getAccValid() {
		return accValid;
	}

	public void setAccValid(Boolean accValid) {
		this.accValid = accValid;
	}

	public Date getAccSysCreateDate() {
		return accSysCreateDate;
	}

	public void setAccSysCreateDate(Date accSysCreateDate) {
		this.accSysCreateDate = accSysCreateDate;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
