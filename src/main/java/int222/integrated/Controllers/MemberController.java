package int222.integrated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Member;
import int222.integrated.Repositories.MemberJpaRepository;

@RestController
public class MemberController {
	@Autowired
	private MemberJpaRepository MemberJpa;
	
	@GetMapping("/member")
	public List<Member> showAllMembers() {
		return MemberJpa.findAll();
	}
}
