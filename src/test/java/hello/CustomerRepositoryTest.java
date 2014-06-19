package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleApplication.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @Test
    public void testHoge() {
        assertThat(repository, is(notNullValue()));
        Customer c = new Customer("hoge", "fuga");
        repository.save(c);
        List<Customer> customers = repository.findByLastName("fuga");
        assertThat(customers.size(), is(equalTo(1)));
        assertThat(customers.get(0).getLastName(), is(equalTo("fuga")));
    }

}
