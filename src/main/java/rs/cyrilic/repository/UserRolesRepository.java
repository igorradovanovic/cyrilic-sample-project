package rs.cyrilic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.cyrilic.model.UserRoles;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface UserRolesRepository extends CustomRepository<UserRoles, Long> {
	
	@Query(value = "SELECT * FROM user_roles WHERE urr_acc_id = :accId", nativeQuery = true)
	List<UserRoles> findAllByAccId(@Param("accId") Long accId);
	

	

}
