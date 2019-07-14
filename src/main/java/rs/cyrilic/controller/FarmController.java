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

import rs.cyrilic.controller.dto.FarmDTO;
import rs.cyrilic.controller.dto.system.ErrorMessage;
import rs.cyrilic.controller.dto.system.ResponseWrapper;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.service.FarmService;

@RestController
@RequestMapping("api")
public class FarmController {
	
	@Autowired
	private FarmService farmService;
	
	
	@RequestMapping(value = "/farms", method = RequestMethod.GET)
	public ResponseEntity<?> loadAll() {
		//List<FarmDTO> res = farmService.loadAll();
		List<FarmDTO> res = farmService.loadAllByUserPrivilege();
		if (res == null) {
			return new ResponseEntity<>(new ErrorMessage("ACCESS_IS_DENIED_CHECK_YOUR_ACCOUNT_PRIVIELGE"), HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity(new ResponseWrapper(res), HttpStatus.OK);
	}
	
	

	@RequestMapping(value= "/farms" , method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody FarmDTO input) throws Exception {
		Long id = this.farmService.create(input);
		FarmDTO frm = this.farmService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(frm), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/farms/{id}", method = RequestMethod.PUT)
	ResponseEntity<?> update(@PathVariable Long id, @RequestBody FarmDTO input) throws Exception {
		this.farmService.update(input);
		FarmDTO frm = this.farmService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(frm), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/farms/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		if (id == null || !farmService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		this.farmService.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/farms/{id}", method = RequestMethod.GET)
	ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
		
		FarmDTO frm = this.farmService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(frm), HttpStatus.OK);
	}

}
