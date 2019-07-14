package rs.cyrilic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.cyrilic.controller.dto.UserDTO;
import rs.cyrilic.controller.dto.system.ErrorMessage;
import rs.cyrilic.controller.dto.system.ResponseWrapper;
import rs.cyrilic.exception.CustomNotFoundException;
import rs.cyrilic.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> loadAll() {
		//List<UserDTO> res = userService.loadAll();
		List<UserDTO> res = userService.loadAllByPrivilege();
		if (res == null) {
			return new ResponseEntity<>(new ErrorMessage("ACCESS_IS_DENIED_CHECK_YOUR_ACCOUNT_PRIVIELGE"), HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity(new ResponseWrapper(res), HttpStatus.OK);
	}

	

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody UserDTO input) throws Exception {

		UserDTO usrByName = this.userService.findUserByName(input.getUserName());
		if (usrByName == null) {
			UserDTO usrByEmail = this.userService.findUserByEmail(input.getUserEmail());
			if (usrByEmail == null) {
				Long id = this.userService.create(input);
				UserDTO UserDTO = this.userService.findById(id);
				return new ResponseEntity<>(new ResponseWrapper(UserDTO), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(new ErrorMessage("User_EMAIL_EXISTS"), HttpStatus.BAD_REQUEST);
			}

		} else {
			return new ResponseEntity<>(new ErrorMessage("User_NAME_EXISTS"), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO input) throws Exception {
		UserDTO usrByName = this.userService.findUserByNameAndNotId(input.getUserName(), input.getUserId());
		if (usrByName == null) {
			UserDTO usrByEmail = this.userService.findUserByEmailAndNotId(input.getUserEmail(), input.getUserId());
			if (usrByEmail == null) {
				this.userService.update(input);
				UserDTO UserDTO = this.userService.findById(input.getUserId());
				return new ResponseEntity<>(new ResponseWrapper(UserDTO), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ErrorMessage("User_EMAIL_EXISTS"), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(new ErrorMessage("User_NAME_EXISTS"), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		if (id == null || !userService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		this.userService.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
		UserDTO usr = this.userService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(usr), HttpStatus.OK);
	}

	// custom-start

	@RequestMapping(value = "/users", method = RequestMethod.GET, params = "username")
	ResponseEntity<?> findByUsername(@RequestParam String userName) throws Exception {

		UserDTO usr = this.userService.findOneByUserName(userName);

		return new ResponseEntity<>(new ResponseWrapper(usr), HttpStatus.OK);
	}

}
