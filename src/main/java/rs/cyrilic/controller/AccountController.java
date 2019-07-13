package rs.cyrilic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.cyrilic.controller.dto.AccountDTO;
import rs.cyrilic.controller.dto.system.ResponseWrapper;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.service.AccountService;

@RestController
@RequestMapping("api")
public class AccountController {
	
	@Autowired
	private AccountService accountService;



	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public ResponseEntity<?> loadAll() {
		List<AccountDTO> res = accountService.loadAll();
		return new ResponseEntity(new ResponseWrapper(res), HttpStatus.OK);
	}

	

	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody AccountDTO input) throws Exception {
		Long id = this.accountService.create(input);
		AccountDTO acc = this.accountService.findById(id);
		
		return new ResponseEntity<>(new ResponseWrapper(acc), HttpStatus.CREATED);
		

	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
	ResponseEntity<?> update(@PathVariable Long id, @RequestBody AccountDTO input) throws Exception {
		this.accountService.update(input);
		AccountDTO acc = this.accountService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(acc), HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		if (id == null || !accountService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		this.accountService.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
		AccountDTO acc = this.accountService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(acc), HttpStatus.OK);
	}

}
