package rs.cyrilic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import rs.cyrilic.controller.dto.RoleDTO;
import rs.cyrilic.controller.dto.UserRolesDTO;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.mapper.RoleMapper;
import rs.cyrilic.mapper.UserRolesMapper;
import rs.cyrilic.model.UserRoles;
import rs.cyrilic.model.Account;
import rs.cyrilic.model.Role;
import rs.cyrilic.repository.AccountRepository;
import rs.cyrilic.repository.RoleRepository;
import rs.cyrilic.repository.UserRolesRepository;

public class UserRolesService {
	
	@Autowired
	UserRolesRepository userRolesRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UserRolesMapper userRolesMapper;
	
	@Transactional(readOnly = true)
	public List<UserRolesDTO> loadAll() {
		List<UserRoles> urr = userRolesRepository.findAll();
		List<UserRolesDTO> res = userRolesMapper.enitiesToDtos(urr);
		return res;
	}

	@Transactional
	public Long create(UserRolesDTO userRolesDTO) {
		Account acc = accountRepository.findOneByAccName(SecurityContextHolder.getContext().getAuthentication().getName());
		UserRoles userRoles = userRolesMapper.dtoToEntity(userRolesDTO);
		Role r1 = roleRepository.findById(userRoles.getRole().getRolId()).orElse(null);
		UserRoles urr = userRolesRepository.save(userRoles);
		return urr.getUrrId();
	}

	@Transactional
	public void update(UserRolesDTO userRolesDTO) throws Exception {
		UserRoles userRolesDB = userRolesRepository.findById(userRolesDTO.getUrrId()).orElse(null);
	
		Account acc = accountRepository.findOneByAccName(SecurityContextHolder.getContext().getAuthentication().getName());

		userRolesDB.setRole(new Role());

		userRolesMapper.updateEntityFromDto(userRolesDTO, userRolesDB);
		

		userRolesRepository.save(userRolesDB);
	}

	@Transactional
	public void delete(Long id) {
		userRolesRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public UserRolesDTO findById(Long id) throws Exception {
		if (id == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Optional<UserRoles> opt = userRolesRepository.findById(id);
		UserRoles urr = opt.orElseThrow(() -> new CustomNotFoundException("NOT FOUND"));
		UserRolesDTO dto = userRolesMapper.entityToDTO(urr);
		return dto;
	}

	@Transactional(readOnly = true)
	public boolean exists(Long id) {
		boolean acr = userRolesRepository.existsById(id);
		return acr;
	}

	// custom-start

	@Transactional(readOnly = true)
	public List<UserRolesDTO> findAllByAccId(Long urrId) {
		List<UserRoles> res = userRolesRepository.findAllByAccId(urrId);
		List<UserRolesDTO> resDTO = userRolesMapper.enitiesToDtos(res);
		return resDTO;
	}

	

}
