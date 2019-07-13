package rs.cyrilic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.cyrilic.controller.dto.CustomerSizeDTO;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.mapper.CustomerSizeMapper;
import rs.cyrilic.model.CustomerSize;
import rs.cyrilic.repository.CustomerSizeRepository;

@Service
public class CustomerSizeService {
	
	@Autowired
	private CustomerSizeRepository customerSizeRepository;
	
	@Autowired
	private CustomerSizeMapper customerSizeMapper;

	@Transactional(readOnly=true)
	public List<CustomerSizeDTO> loadAll()
	{
		List<CustomerSize> res = customerSizeRepository.findAll();
		List<CustomerSizeDTO> res1 = customerSizeMapper.enitiesToDtos(res);
		return res1;
	}
	
	@Transactional
	public Long create(CustomerSizeDTO input)
	{
		CustomerSize entity = customerSizeMapper.dtoToEntity(input);
		CustomerSize cst = customerSizeRepository.save(entity);
		return cst.getSizId();
	}
	
	@Transactional
	public void update(CustomerSizeDTO input) throws Exception
	{
		CustomerSize customerSizeDB = customerSizeRepository.findById(input.getSizId()).orElse(null);
		if (input.getSizId() == null || customerSizeDB == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		
		customerSizeMapper.updateEntityFromDto(input, customerSizeDB);
		CustomerSize cst = customerSizeRepository.save(customerSizeDB);
	}
	
	@Transactional
	public void delete(Long id)
	{
		customerSizeRepository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public CustomerSizeDTO findById(Long id) throws Exception
	{
		if (id == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Optional<CustomerSize> opt = customerSizeRepository.findById(id);
		CustomerSize cst = opt.orElseThrow(() -> new CustomNotFoundException("NOT FOUND"));
		CustomerSizeDTO customerSizeDTO = customerSizeMapper.entityToDTO(cst);
		return customerSizeDTO;
	}
	
	@Transactional(readOnly=true)
	public boolean exists(Long id)
	{
		boolean cst = customerSizeRepository.existsById(id);
		return cst;
	}
}
