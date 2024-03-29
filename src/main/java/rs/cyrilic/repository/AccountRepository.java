package rs.cyrilic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.cyrilic.model.Role;
import rs.cyrilic.model.Account;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface AccountRepository extends CustomRepository<Account, Long> {
	
	Account findByAccName(String name);
	
	Account findOneByAccName(String name);
	
	@Query(value = "SELECT *FROM accounts WHERE acc_id in \r\n" + 
			"(SELECT usa_acc_id FROM user_access WHERE usa_usr_id = :usr_id )", nativeQuery=true)
	List<Account>getAccountsByUserAccess(@Param("usr_id")Long usaUsrId);
	
	
	

	 
}
