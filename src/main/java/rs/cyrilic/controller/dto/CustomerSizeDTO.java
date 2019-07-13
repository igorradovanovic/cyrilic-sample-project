package rs.cyrilic.controller.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerSizeDTO implements Serializable {

	private Long sizId;
	private String sizName;
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
