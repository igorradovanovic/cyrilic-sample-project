package rs.cyrilic.controller.dto;

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

public class AccountDTO {
	
	
	private Long accId;
	private String accName;
	private String accNumber;
	private Boolean accValid;
	private CustomerDTO customer;
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
	

	public CustomerDTO getAccCustomer() {
		return customer;
	}

	public void setAccCustomer(CustomerDTO customer) {
		this.customer = customer;
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
	
	

}
