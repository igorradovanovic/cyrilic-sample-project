package rs.cyrilic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.cyrilic.model.Account;
import rs.cyrilic.model.Farm;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface FarmRepository extends CustomRepository<Farm, Long> {
	
	@Query(value = "SELECT *FROM farms WHERE frm_acc_id in \r\n" + 
			"(SELECT usa_acc_id FROM user_access WHERE usa_usr_id = :usr_id )", nativeQuery=true)
	List<Farm>getFarmsByUserAccess(@Param("usr_id")Long usaUsrId);

}
