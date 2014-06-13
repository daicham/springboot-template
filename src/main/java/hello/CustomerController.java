package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping
	@Transactional(readOnly = true)
	public Customer customer() {
		return customerRepository.findOne(1L);
	}
	
	@RequestMapping("/add")
	@Transactional
	public Customer add() {
		return customerRepository.save(new Customer("hoge", "fuga"));
	}
}
