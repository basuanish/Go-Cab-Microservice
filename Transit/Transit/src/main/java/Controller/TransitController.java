package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Model.TransitModel;
import Repository.TransitRepository;


@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/transit")
@RestController
public class TransitController {
	
	@Autowired
	private TransitRepository transitRepository ;
	
	@GetMapping(value="/search")
	Iterable <TransitModel>findByQuery(@RequestParam("Sedan") String cab_type ,@RequestParam("Active")String status)
	{
		return transitRepository.findByCabTypeAndStatus("Sedan", "Active") ;
	}

}
