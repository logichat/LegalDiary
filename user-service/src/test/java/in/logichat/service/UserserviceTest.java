package in.logichat.service;

import in.logichat.entity.Customer;
import in.logichat.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserserviceTest {

    @Autowired
    private Userservice userservice;
    @MockBean
    private UserRepository userRepository;

    private Customer customer;

    private Customer inputCustomer;

    @BeforeEach
    void setUp() {
        customer=Customer.builder().email("sameer.chatterji@gmail.com").customerId(1L).build();

        inputCustomer=Customer.builder().email("sameer.chatterji@gmail.com").customerId(1L).build();
        Mockito.when(userRepository.save(customer)).thenReturn(customer);
        Mockito.when(userRepository.findByCustomerId(1L)).thenReturn(customer);
    }

    @Test
    void saveUser() {

        Customer customer1=userservice.saveUser(inputCustomer);
        assertEquals(inputCustomer,customer1);
    }

    @Test
    void getCustomerById() {

        Long id=1L;

        Customer customer1=userservice.getCustomerById(id);
        assertEquals(customer1.getCustomerId(),id);
    }
}