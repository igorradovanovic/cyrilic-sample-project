package rs.cyrilic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.cyrilic.model.Customer;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface CustomerRepository extends CustomRepository<Customer, Long> {
	
	@Query(value = "select *from customers where cst_id in \r\n" + 
			"\r\n" + 
			"(SELECT acc_cst_id FROM accounts WHERE acc_id in \r\n" + 
			"			(SELECT usa_acc_id FROM user_access WHERE usa_usr_id = :usr_id))", nativeQuery=true)
	List<Customer>getCustomerByAccountPrivilege(@Param("usr_id")Long usrId);

}
