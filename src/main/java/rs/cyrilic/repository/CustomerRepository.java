package rs.cyrilic.repository;

import org.springframework.stereotype.Repository;

import rs.cyrilic.model.Customer;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface CustomerRepository extends CustomRepository<Customer, Long> {

}
