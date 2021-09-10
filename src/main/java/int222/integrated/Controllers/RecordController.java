package int222.integrated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Record;
import int222.integrated.Repositories.RecordJpaRepository;

@RestController
public class RecordController {
	@Autowired
	private RecordJpaRepository recordJpa;
	
	@GetMapping("/record")
	public List<Record> showAllRecords() {
		return recordJpa.findAll();
	}
}
