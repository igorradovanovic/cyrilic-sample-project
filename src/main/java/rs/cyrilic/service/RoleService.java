package rs.cyrilic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.cyrilic.controller.dto.RoleDTO;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.mapper.RoleMapper;
import rs.cyrilic.model.Account;
import rs.cyrilic.model.Role;
import rs.cyrilic.repository.AccountRepository;
import rs.cyrilic.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RoleMapper roleMapper;
	
	@Transactional
	public Long create(RoleDTO roleDTO) {
		Account acc = accountRepository.findOneByAccName(SecurityContextHolder.getContext().getAuthentication().getName());
		Role role = this.roleMapper.dtoToEntity(roleDTO);
		Role rol = roleRepository.save(role);
		
		return rol.getRolId();
	}

	@Transactional
	public void update(RoleDTO roleDTO) throws Exception {
		Role roleDB = this.roleRepository.findById(roleDTO.getRolId()).orElse(null);
		
		Account acc = accountRepository.findOneByAccName(SecurityContextHolder.getContext().getAuthentication().getName());
		this.roleMapper.updateEntityFromDto(roleDTO, roleDB);
		roleRepository.save(roleDB);
		
	}

	@Transactional
	public void delete(Long id) throws Exception {
		// roleRepository.deleteById(id);
		Optional<Role> opt = roleRepository.findById(id);
		Role role = opt.orElseThrow(() -> new CustomNotFoundException("NOT FOUND"));
		roleRepository.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	public RoleDTO findById(Long id) throws Exception {
		Optional<Role> opt = roleRepository.findById(id);
		Role role = opt.orElseThrow(() -> new CustomNotFoundException("NOT FOUND"));
		RoleDTO roleDTO = this.roleMapper.entityToDTO(role);
		return roleDTO;
	}

	@Transactional(readOnly = true)
	public boolean exists(Long id) {
		boolean rol = roleRepository.existsById(id);
		return rol;
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> loadByRoleName(String rolName) {
		List<Role> res = roleRepository.findByRolNameContainingIgnoreCase(rolName);
		List<RoleDTO> res1 = this.roleMapper.enitiesToDtos(res);
		return res1;
	}

}
