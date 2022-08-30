package in.logichat.controller;

import in.logichat.entity.Customer;
import in.logichat.service.Userservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Userservice userservice;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer=Customer.builder().customerId(1L).email("sameer.chatterji@gmail.com").build();
    }

    @Test
    void saveCustomer() throws  Exception{

        Customer inputCustomer=Customer.builder().customerId(1L).email("sameer.chatterji@gmail.com").build();

        Mockito.when(userservice.saveUser(inputCustomer)).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/").contentType(MediaType.APPLICATION_JSON).content("{\"customerId\":1,\"email\":\"sameer.chatterji@gmail.com\"}"
                )).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getCustomerById() throws  Exception {
        Long customerId=1L;

        Mockito.when(userservice.getCustomerById(customerId)).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customer.getEmail()));
    }
}