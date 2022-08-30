package in.logichat.controller;

import in.logichat.entity.Customer;
import in.logichat.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private Userservice userservice;

    @PostMapping("/")
    public Customer saveCustomer(@Valid @RequestBody Customer customer)
    {
       return userservice.saveUser(customer);
    }


    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId)
    {
        return  userservice.getCustomerById(customerId);
    }

}
