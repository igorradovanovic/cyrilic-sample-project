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

import org.hibernate.annotations.CreationTimestamp;


public class FarmDTO implements Serializable {
	
	private Long frmId;
	private String frmName;
	private String frmAddress;
	private String frmCity;
	private String frmState;
	private String frmZip;
	private AccountDTO frmAccount;
	private Date frmSysCreateDate;
	
	public Long getFrmId() {
		return frmId;
	}
	public void setFrmId(Long frmId) {
		this.frmId = frmId;
	}
	public String getFrmName() {
		return frmName;
	}
	public void setFrmName(String frmName) {
		this.frmName = frmName;
	}
	public String getFrmAddress() {
		return frmAddress;
	}
	public void setFrmAddress(String frmAddress) {
		this.frmAddress = frmAddress;
	}
	public String getFrmCity() {
		return frmCity;
	}
	public void setFrmCity(String frmCity) {
		this.frmCity = frmCity;
	}
	public String getFrmState() {
		return frmState;
	}
	public void setFrmState(String frmState) {
		this.frmState = frmState;
	}
	public String getFrmZip() {
		return frmZip;
	}
	public void setFrmZip(String frmZip) {
		this.frmZip = frmZip;
	}
	public Date getFrmSysCreateDate() {
		return frmSysCreateDate;
	}
	public void setFrmSysCreateDate(Date frmSysCreateDate) {
		this.frmSysCreateDate = frmSysCreateDate;
	}
	public AccountDTO getFrmAccount() {
		return frmAccount;
	}
	public void setFrmAccount(AccountDTO frmAccount) {
		this.frmAccount = frmAccount;
	}
	
	
}


