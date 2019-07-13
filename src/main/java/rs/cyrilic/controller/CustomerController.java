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

import rs.cyrilic.controller.dto.CustomerDTO;
import rs.cyrilic.controller.dto.system.ResponseWrapper;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.service.CustomerService;

@RestController
@RequestMapping("api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<?> loadAll() {
		List<CustomerDTO> res = customerService.loadAll();
		return new ResponseEntity(new ResponseWrapper(res), HttpStatus.OK);
	}
	
	

	@RequestMapping(value= "/customers" , method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody CustomerDTO input) throws Exception {
		Long id = this.customerService.create(input);
		CustomerDTO cas = this.customerService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(cas), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
	ResponseEntity<?> update(@PathVariable Long id, @RequestBody CustomerDTO input) throws Exception {
		this.customerService.update(input);
		CustomerDTO cas = this.customerService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(cas), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		if (id == null || !customerService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		this.customerService.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
		
		CustomerDTO cas = this.customerService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(cas), HttpStatus.OK);
	}
}
