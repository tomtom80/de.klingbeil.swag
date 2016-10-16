package de.klingbeil.swag.service.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.klingbeil.swag.APIUrls;
import de.klingbeil.swag.service.UserService;
import de.klingbeil.swag.service.domain.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = APIUrls.USERS_RESOURCE)
@RestController
@RequestMapping(APIUrls.USERS_RESOURCE)
public class UserController {

	@Resource
	private UserService userService;

	@ApiOperation(value = "Fetch user information by user login name.")
	@RequestMapping(value = {
			"/{loginName}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<UserDTO> getUserByLoginName(
			@ApiParam(value = "The users login name.") @PathVariable String loginName) {
		return new ResponseEntity<>(UserDTO.from(this.userService.findByLoginName(loginName)),
				HttpStatus.OK);
	}
	@ApiOperation(value = "Creates a new user.")
	@RequestMapping( method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public ResponseEntity<Void> createUser(@ApiParam(value = "The user object to create.") @RequestBody UserDTO user) {
		
		this.userService.persist(user.toUser());
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>( httpHeaders, HttpStatus.CREATED);
	}
}
