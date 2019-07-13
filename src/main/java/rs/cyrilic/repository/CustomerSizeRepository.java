package rs.cyrilic.repository;

import org.springframework.stereotype.Repository;

import rs.cyrilic.model.CustomerSize;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface CustomerSizeRepository extends CustomRepository<CustomerSize, Long> {

}
