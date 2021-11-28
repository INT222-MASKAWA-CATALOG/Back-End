package int222.integrated.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.AuthenticationUser;
import int222.integrated.Models.JwtRequest;
import int222.integrated.Models.JwtResponse;
import int222.integrated.Models.Role;
import int222.integrated.Repositories.RoleJpaRepository;
import int222.integrated.Repositories.UserJpaRepository;
import int222.integrated.Service.JwtTokenService;
import int222.integrated.Service.ServiceUtil;

@RestController
public class AuthenController {

	@Autowired
	JwtTokenService jwtTokenService;

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private RoleJpaRepository RoleJpa;

	@Autowired
	private UserJpaRepository UserJpa;

//  ---------------------------------- GetMapping ----------------------------------
	@GetMapping("/me")
	public AuthenticationUser getMe() {
		String username = ServiceUtil.getUsername();
		return userJpaRepository.findByUsername(username);
	}

	@GetMapping("/role")
	public List<Role> showRoles() {
		return RoleJpa.findAll();
	}

	@GetMapping("/user")
	public List<AuthenticationUser> showAuthenticationUsers() {
		return UserJpa.findAll();
	}
	
	@GetMapping(value = "/checkUsername/{username}")
	public boolean checkUsername(@PathVariable("username") String username) {
		try {
			if (userJpaRepository.findByUsername(username).getUsername().equals(username)) {
				System.out.println(userJpaRepository.findByUsername(username).getUsername());
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			return false;
		}
	}

//  ---------------------------------- PostMapping ----------------------------------
	
	@PostMapping("/login")
	public JwtResponse getlogin(@RequestBody JwtRequest authenticationRequest) throws Exception {
		AuthenticationUser user = userJpaRepository.findByUsername(authenticationRequest.getUsername());
		if (user == null) {
			throw new Exception();
		}
		if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
			throw new Exception();
		}
		UserDetails userdetail = new User(user.getUsername(), user.getPassword(), new ArrayList<>());
		String tk = jwtTokenService.generateToken(userdetail, user.getRole().getName());
		return new JwtResponse(tk);
	}

	@PostMapping(value = "/register")
	public String register(@RequestParam("password") String password, @RequestParam("username") String username,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("gender") String gender) {
		String encodedPassword = passwordEncoder.encode(password);
		if (!checkUsername(username)) {
			System.out.println("Pass checkUser username");
			if (!checkEmail(email)) {
				AuthenticationUser newUsername = new AuthenticationUser();
				newUsername.setPassword(encodedPassword);
				newUsername.setUsername(username);
				newUsername.setEmail(email);
				newUsername.setPhone(phone);
				newUsername.setGender(gender);
				newUsername.setRoleid(1);
				userJpaRepository.save(newUsername);
				System.out.println("Register Complete.");
				return "Register Complete.";
			} else {
				System.out.println("This email has already exist.");
				return "This email has already exist.";
			}
		} else {
			System.out.println("This username has already exist.");
			return "This username has already exist.";
		}
	}

	public boolean checkEmail(String email) {
		try {
			if (userJpaRepository.findByEmail(email).getEmail().equals(email)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}
	
//  ---------------------------------- PutMapping ----------------------------------
	
	@PutMapping(value = "/updateRole")
	public AuthenticationUser updateRole(@RequestParam("userid") int userid,@RequestParam("roleid") int roleid) {
		AuthenticationUser updateRoleId =  userJpaRepository.findById(userid).get();
		updateRoleId.setRoleid(roleid);
		System.out.println("Update Role Id Complete.");
		return userJpaRepository.save(updateRoleId);
	}
	



}
