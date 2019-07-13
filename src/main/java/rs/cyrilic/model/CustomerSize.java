package rs.cyrilic.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "customer_size")
public class CustomerSize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "siz_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sizId;
	
	@Column(name = "siz_name")
	private String sizName;
	
	@Column(name="siz_sys_create_date")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date sizSysCreateDate;

	public Long getSizId() {
		return sizId;
	}

	public void setSizId(Long sizId) {
		this.sizId = sizId;
	}

	public String getSizName() {
		return sizName;
	}

	public void setSizName(String sizName) {
		this.sizName = sizName;
	}

	public Date getSizSysCreateDate() {
		return sizSysCreateDate;
	}

	public void setSizSysCreateDate(Date sizSysCreateDate) {
		this.sizSysCreateDate = sizSysCreateDate;
	}
	
	

}
