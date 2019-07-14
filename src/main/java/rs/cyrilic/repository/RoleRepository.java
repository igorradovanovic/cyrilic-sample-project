package rs.cyrilic.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import rs.cyrilic.model.Role;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface RoleRepository extends CustomRepository<Role, Long> {
	
	List<Role> findByRolNameContainingIgnoreCase(String rolName);

}
