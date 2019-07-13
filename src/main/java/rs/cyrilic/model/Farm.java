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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="farms")
public class Farm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="frm_id")
	private Long frmId;
	
	@Column(name="frm_name")
	private String frmName;
	
	@Column(name="frm_address")
	private String frmAddress;
	
	@Column(name="frm_city")
	private String frmCity;
	
	@Column(name="frm_state")
	private String frmState;
	
	@Column(name="frm_zip")
	private String frmZip;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="frm_acc_id")
	private Account frmAccount;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="frm_sys_create_date")
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

	public Account getFrmAccount() {
		return frmAccount;
	}

	public void setFrmAccount(Account frmAccount) {
		this.frmAccount = frmAccount;
	}

	public Date getFrmSysCreateDate() {
		return frmSysCreateDate;
	}

	public void setFrmSysCreateDate(Date frmSysCreateDate) {
		this.frmSysCreateDate = frmSysCreateDate;
	}
	
	
}


