package rs.cyrilic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.cyrilic.mapper.AccountMapper;
import rs.cyrilic.model.Account;
import rs.cyrilic.model.User;
import rs.cyrilic.repository.AccountRepository;
import rs.cyrilic.repository.UserRepository;
import rs.cyrilic.controller.dto.AccountDTO;
import rs.cyrilic.exception.CustomNotFoundException;

@Service
public class AccountService {
	

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private AccountMapper accountMapper;

	@Transactional(readOnly=true)
	public List<AccountDTO> loadAll()
	{
		List<Account> res = accountRepository.findAll();
		List<AccountDTO> res1 = accountMapper.enitiesToDtos(res);
		return res1;
	}
	
	@Transactional
	public Long create(AccountDTO input)
	{
		Account entity = accountMapper.dtoToEntity(input);
		Account acc = accountRepository.save(entity);
		return acc.getAccId();
	}
	
	@Transactional
	public void update(AccountDTO input) throws Exception
	{
		Account accountDB = accountRepository.findById(input.getAccId()).orElse(null);
		if (input.getAccId() == null || accountDB == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		
		accountMapper.updateEntityFromDto(input, accountDB);
		Account acc = accountRepository.save(accountDB);
	}
	
	@Transactional
	public void delete(Long id)
	{
		accountRepository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public AccountDTO findById(Long id) throws Exception
	{
		if (id == null) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Optional<Account> opt = accountRepository.findById(id);
		Account acc = opt.orElseThrow(() -> new CustomNotFoundException("NOT FOUND"));
		AccountDTO AccountDTO = accountMapper.entityToDTO(acc);
		return AccountDTO;
	}
	
	@Transactional(readOnly=true)
	public boolean exists(Long id)
	{
		boolean amc = accountRepository.existsById(id);
		return amc;
	}
	
	// custom methods
	public AccountDTO findAccountByName(String name) throws CustomNotFoundException {
		Account acc = accountRepository.findByAccName(name);
		AccountDTO dto = accountMapper.entityToDTO(acc);
		return dto;
	}
	
	@Transactional(readOnly=true)
	public List<AccountDTO> loadAllByPrivilege()
	{
		User user = userRepository.findOneByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Account> res = accountRepository.getAccountsByUserAccess(user.getUserId());
		if(res == null || res.isEmpty()) {
			return null;
		}
		List<AccountDTO> res1 = accountMapper.enitiesToDtos(res);
		return res1;
	}

}
