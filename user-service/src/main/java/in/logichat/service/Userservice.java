package in.logichat.service;

import in.logichat.entity.Customer;
import in.logichat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {

    @Autowired
    private UserRepository userRepository;
    public Customer saveUser(Customer customer)
    {
     return userRepository.save(customer);
    }

    public Customer getCustomerById(Long userId)
    {
        return userRepository.findByCustomerId(userId);
    }
}
