package rs.cyrilic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.cyrilic.model.Role;
import rs.cyrilic.model.User;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface UserRepository extends CustomRepository<User, Long> {
	 
	User findByUserName(String name);
	
	User findByUserEmail(String email);
	
	User findByUserNameAndUserIdNot(String name, Long id);

	User findByUserEmailAndUserIdNot(String email, Long id);
	
	User findOneByUserName(String name);
	
	@Query("SELECT r from UserRoles ur INNER JOIN ur.role r INNER JOIN ur.user u WHERE u.userName = :usrName")
    List<Role> findAuthorities(@Param("usrName") String username);
}
