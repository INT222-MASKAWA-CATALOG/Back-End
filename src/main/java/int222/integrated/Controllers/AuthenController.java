package int222.integrated.Controllers;

import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Exception.ExceptionResponse;
import int222.integrated.Exception.UserNameException;
import int222.integrated.Models.AuthenticationUser;
import int222.integrated.Models.JwtRequest;
import int222.integrated.Models.JwtResponse;
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

	public int numOfUser;

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

	@GetMapping("/me")
	public AuthenticationUser getMe() {
		String username = ServiceUtil.getUsername();
		return userJpaRepository.findByUsername(username);
	}
	
    /*@GetMapping("/alluser")
    public List<AuthenticationUser> getUser(){
        return userJpaRepository.findAll();
    }

	@PostMapping(value = "/register")
	public ResponseEntity<?> saveUser(@RequestBody AuthenticationUser user) throws RuntimeException {
		if (userJpaRepository.findByUsername(user.getUsername()).orElse(null) != null && userJpaRepository
				.findByUsername(user.getUsername()).orElse(null).getUsername() == user.getUsername()) {
			throw new UserNameException(ExceptionResponse.ERROR_CODE.USERNAME_ALREADY_EXIST,
					"Is have already email exist");
		} else {
			this.numOfUser = userJpaRepository.findAll().size() - 1 == -1 ? 300301
					: userJpaRepository.findAll().get(userJpaRepository.findAll().size() - 1).getUserid() + 1;
			AuthenticationUser newuser = new AuthenticationUser();

//            this.numOfUser,user.getUsername(),
//            user.getEmail(),user.getPhone(),user.getGender(),user.getRole()

			user.setPassword(passwordEncoder.encode(user.getPassword()));

			return ResponseEntity.ok(userJpaRepository.save(newuser));
		}
	}*/
}
