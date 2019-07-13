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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CustomerDTO implements Serializable {
	
	private Long cstId;
	private String cstName;
	private String cstMainAddress;
	private CustomerSizeDTO cstCustomerSize;
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


	public CustomerSizeDTO getCstCustomerSize() {
		return cstCustomerSize;
	}


	public void setCstCustomerSize(CustomerSizeDTO cstCustomerSize) {
		this.cstCustomerSize = cstCustomerSize;
	}


	public Date getCstSysCreateDate() {
		return cstSysCreateDate;
	}


	public void setCstSysCreateDate(Date cstSysCreateDate) {
		this.cstSysCreateDate = cstSysCreateDate;
	}
	
	
	
	
}


