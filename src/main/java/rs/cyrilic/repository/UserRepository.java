package rs.cyrilic.repository;

import org.springframework.stereotype.Repository;

import rs.cyrilic.model.User;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface UserRepository extends CustomRepository<User, Long> {
	 
	User findByUserName(String name);
	
	User findByUserEmail(String email);
	
	User findByUserNameAndUserIdNot(String name, Long id);

	User findByUserEmailAndUserIdNot(String email, Long id);
	
	User findOneByUserName(String name);
}
