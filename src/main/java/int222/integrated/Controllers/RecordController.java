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

import int222.integrated.Models.Record;
import int222.integrated.Repositories.RecordJpaRepository;

@CrossOrigin
@RestController
public class RecordController {
	@Autowired
	private RecordJpaRepository recordJpa;

//  ---------------------------------- GetMapping ----------------------------------
	
	@GetMapping("/record")
	public List<Record> showAllRecords() {
		return recordJpa.findAll();
	}

//  ---------------------------------- PostMapping ----------------------------------
	
	@PostMapping("/addRecord")
	public void addCart(@RequestBody Record record) {
		recordJpa.save(record);
	}

//  ---------------------------------- DeleteMapping ----------------------------------
	
	@DeleteMapping("/deleteRecord/{recordid}")
	public String deleteRecordById(@PathVariable("recordid") int recordid) {
		recordJpa.deleteById(recordid);
		return "delete success";
	}
}
