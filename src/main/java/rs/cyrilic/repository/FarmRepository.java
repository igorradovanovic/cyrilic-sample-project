package rs.cyrilic.repository;

import org.springframework.stereotype.Repository;

import rs.cyrilic.model.Farm;
import rs.cyrilic.sys.CustomRepository;

@Repository
public interface FarmRepository extends CustomRepository<Farm, Long> {

}
