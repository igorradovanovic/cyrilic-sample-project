package rs.cyrilic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.cyrilic.controller.dto.CustomerDTO;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.mapper.CustomerMapper;
import rs.cyrilic.model.Customer;
import rs.cyrilic.model.User;
import rs.cyrilic.repository.CustomerRepository;
import rs.cyrilic.repository.UserRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private CustomerMapper customerMapper;

	@Transactional(readOnly=true)
	public List<CustomerDTO> loadAll()
	{
		List<Customer> res = customerRepository.findAll();
		List<CustomerDTO> res1 = customerMapper.enitiesToDtos(res);
		return res1;
	}
	
	@Transactional
	public Long create(CustomerDTO input)
	{
		Customer entity = customerMapper.dtoToEntity(input);
		Customer cas = customerRepository.save(entity);
		return cas.getCstId();
	}
	
	@Transactional
	public void update(CustomerDTO input) throws Exception
	{
		Customer customerDTO = customerRepository.findById(input.getCstId()).orElse(null);
		if (input.getCstId() == null || customerDTO == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		
		customerMapper.updateEntityFromDto(input, customerDTO);
		Customer cas = customerRepository.save(customerDTO);
	}
	
	@Transactional
	public void delete(Long id)
	{
		customerRepository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public CustomerDTO findById(Long id) throws Exception
	{
		if (id == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Optional<Customer> opt = customerRepository.findById(id);
		Customer cas = opt.orElseThrow(() -> new CustomNotFoundException("NOT FOUND"));
		CustomerDTO customerDTO = customerMapper.entityToDTO(cas);
		return customerDTO;
	}
	
	@Transactional(readOnly=true)
	public boolean exists(Long id)
	{
		boolean cas = customerRepository.existsById(id);
		return cas;
	}
	
	//custom method to take only customer privileged to account
	@Transactional(readOnly=true)
	public List<CustomerDTO> loadAllByPrivilege()
	{
		User user = userRepository.findOneByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Customer> res = customerRepository.getCustomerByAccountPrivilege(user.getUserId());
		if(res == null || res.isEmpty()) {
			return null;
		}
		List<CustomerDTO> res1 = customerMapper.enitiesToDtos(res);
		return res1;
	}

}
