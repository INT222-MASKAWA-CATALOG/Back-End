package int222.integrated.Controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.AuthenticationUser;
import int222.integrated.Models.JwtRequest;
import int222.integrated.Models.JwtResponse;
import int222.integrated.Repositories.UserJpaRepository;
import int222.integrated.Service.JwtTokenService;

@RestController
public class AuthenController {

	@Autowired
	JwtTokenService jwtTokenService;

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

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
}
