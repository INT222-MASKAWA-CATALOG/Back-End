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
import int222.integrated.Models.AuthenticationUser;
import int222.integrated.Models.Record;
import int222.integrated.Repositories.RecordJpaRepository;
import int222.integrated.Repositories.UserJpaRepository;

@CrossOrigin
@RestController
public class RecordController {
	@Autowired
	RecordJpaRepository recordJpa;

	@Autowired
	UserJpaRepository userJpa;

//  ---------------------------------- GetMapping ----------------------------------
	// Show a list of all records.
	@GetMapping("/record")
	public List<Record> showAllRecords() {
		return recordJpa.findAll();
	}

	// Show all records with user information.
	@GetMapping("/record/alluser")
	public List<AuthenticationUser> showAuthenticationUsers() {
		return userJpa.findAll();
	}

//  ---------------------------------- PostMapping ----------------------------------
	// add record
	@PostMapping("/addRecord")
	public void addRecord(@RequestBody Record record) {
		recordJpa.save(record);
	}

//  ---------------------------------- DeleteMapping ----------------------------------
	// delete record
	@DeleteMapping("/deleteRecord/{recordid}")
	public String deleteRecordById(@PathVariable("recordid") int recordid) {
		recordJpa.deleteById(recordid);
		return "delete success";
	}
}