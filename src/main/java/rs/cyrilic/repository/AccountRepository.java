package rs.cyrilic.repository;

import org.springframework.stereotype.Repository;

import rs.cyrilic.model.Account;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface AccountRepository extends CustomRepository<Account, Long> {
	
	Account findByAccName(String name);
	
	Account findOneByAccName(String name);

}
