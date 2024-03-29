package rs.cyrilic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "urr_id")
	private Long urrId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "urr_rol_id")
	private Role role;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "urr_usr_id")
	private User user;

	public Long getUrrId() {
		return urrId;
	}

	public void setUrrId(Long urrId) {
		this.urrId = urrId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	


	
	
	
}
