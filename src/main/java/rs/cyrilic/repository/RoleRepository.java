package rs.cyrilic.repository;

import java.util.List;

import rs.cyrilic.model.Role;
import rs.cyrilic.sys.CustomRepository;

public interface RoleRepository extends CustomRepository<Role, Long> {
	
	List<Role> findByRolNameContainingIgnoreCase(String rolName);

}
