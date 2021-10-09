package int222.integrated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.member;
import int222.integrated.Repositories.MemberJpaRepository;

@CrossOrigin
@RestController
public class MemberController {
	@Autowired
	private MemberJpaRepository memberJpa;
	
	@GetMapping("/member")
	public List<member> showAllMembers() {
		return memberJpa.findAll();
	}
	
	//ยังไม่ได้ทำ throw Exception
	@DeleteMapping("/member/{userid}")
	public String delete(@PathVariable Integer userid) {
		memberJpa.findById(userid).orElse(null);
		memberJpa.deleteById(userid);
		return "Delete member Success";
	}
	
	@PostMapping(value = "/createAccount")
	public member create(@RequestBody member newAccount) {
		return memberJpa.save(newAccount);	
	}
}
