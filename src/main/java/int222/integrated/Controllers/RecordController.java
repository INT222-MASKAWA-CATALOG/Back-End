package int222.integrated.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Exception.ExceptionResponse;
import int222.integrated.Exception.MessageException;
import int222.integrated.Exception.ProductException;
import int222.integrated.Models.AuthenticationUser;
import int222.integrated.Models.Product;
import int222.integrated.Models.Record;
import int222.integrated.Repositories.RecordJpaRepository;
import int222.integrated.Repositories.UserJpaRepository;
import int222.integrated.Service.ServiceUtil;

@CrossOrigin
@RestController
public class RecordController {
	@Autowired
	RecordJpaRepository recordJpa;

	@Autowired
	UserJpaRepository userJpa;

//  ---------------------------------- GetMapping ----------------------------------
	// show record ทั้งหมดที่มีอยู่
	@GetMapping("/record")
	public List<Record> showAllRecords() {
		return recordJpa.findAll();
	}

	// show record ทั้งหมดโดย show ข้อมูล User ด้วย
	@GetMapping("/record/alluser")
	public List<AuthenticationUser> showAuthenticationUsers() {
		return userJpa.findAll();
	}

	// show record ทั้งหมดโดยเเยกตาม Userid
	@GetMapping("/record/{userid}")
	public Optional<AuthenticationUser> showRecordById(@PathVariable int userid) {
		Record record = this.recordJpa.findById(userid).orElse(null);
		return userJpa.findById(userid);
	}

//  ---------------------------------- PostMapping ----------------------------------

	@PostMapping("/addRecord")
	public void addRecord(@RequestBody Record record) {
		recordJpa.save(record);
	}

//  ---------------------------------- DeleteMapping ----------------------------------

	@DeleteMapping("/deleteRecord/{recordid}")
	public String deleteRecordById(@PathVariable("recordid") int recordid) {
		recordJpa.deleteById(recordid);
		return "delete success";
	}
}
