package rs.cyrilic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.cyrilic.controller.dto.CustomerDTO;
import rs.cyrilic.controller.dto.FarmDTO;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.mapper.CustomerMapper;
import rs.cyrilic.mapper.FarmMapper;
import rs.cyrilic.model.Customer;
import rs.cyrilic.model.Farm;
import rs.cyrilic.model.User;
import rs.cyrilic.repository.FarmRepository;
import rs.cyrilic.repository.UserRepository;

@Service
public class FarmService {
	
	@Autowired
	private FarmRepository farmRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FarmMapper farmMapper;

	@Transactional(readOnly=true)
	public List<FarmDTO> loadAll()
	{
		List<Farm> res = farmRepository.findAll();
		List<FarmDTO> res1 = farmMapper.enitiesToDtos(res);
		return res1;
	}
	
	@Transactional
	public Long create(FarmDTO input)
	{
		Farm entity = farmMapper.dtoToEntity(input);
		Farm frm = farmRepository.save(entity);
		return frm.getFrmId();
	}
	
	@Transactional
	public void update(FarmDTO input) throws Exception
	{
		Farm farmDB = farmRepository.findById(input.getFrmId()).orElse(null);
		if (input.getFrmId() == null || farmDB == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		
		farmMapper.updateEntityFromDto(input, farmDB);
		Farm frm = farmRepository.save(farmDB);
	}
	
	@Transactional
	public void delete(Long id)
	{
		farmRepository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public FarmDTO findById(Long id) throws Exception
	{
		if (id == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Optional<Farm> opt = farmRepository.findById(id);
		Farm frm = opt.orElseThrow(() -> new CustomNotFoundException("NOT FOUND"));
		FarmDTO farmDTO = farmMapper.entityToDTO(frm);
		return farmDTO;
	}
	
	@Transactional(readOnly=true)
	public boolean exists(Long id)
	{
		boolean frm = farmRepository.existsById(id);
		return frm;
	}
	
	@Transactional(readOnly=true)
	public List<FarmDTO> loadAllByUserPrivilege()
	{
		User user = userRepository.findOneByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Farm> res = farmRepository.getFarmsByUserAccess(user.getUserId());
		if(res == null) {
			return null;
		}
		List<FarmDTO> res1 = farmMapper.enitiesToDtos(res);
		return res1;
	}


}
