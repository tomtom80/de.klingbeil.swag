package de.klingbeil.swag.service.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.klingbeil.swag.persistence.model.User;
import de.klingbeil.swag.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping( value = { "/{loginName}" },method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User>  getUserByLoginName(@PathVariable String loginName) {
		return new ResponseEntity<>( this.userService.findByLoginName(loginName), HttpStatus.OK);
	}
}
