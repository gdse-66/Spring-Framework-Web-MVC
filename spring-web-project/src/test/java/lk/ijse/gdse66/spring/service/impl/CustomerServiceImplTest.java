package lk.ijse.gdse66.spring.service.impl;

import lk.ijse.gdse66.spring.config.WebRootConfig;
import lk.ijse.gdse66.spring.dto.CustomerDTO;
import lk.ijse.gdse66.spring.service.CustomerService;
import lk.ijse.gdse66.spring.service.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith({SpringExtension.class}) // link Junit with Spring
//@ContextConfiguration(classes = WebRootConfig.class) // create a spring context for testing and import configuration for it
@SpringJUnitConfig(classes = WebRootConfig.class)
@Transactional // any changes made to db during test will not be committed after the execution of test
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    CustomerDTO addOneCustomer(){
        CustomerDTO customerDTO = new CustomerDTO("C001",
                "Kasun Sampath", "Galle", "ProfilePic1");
        return customerService.saveCustomer(customerDTO);
    }

    void addAllCustomers(){
        CustomerDTO customer1 = new CustomerDTO("C001", "Kasun Sampath", "Galle", "ProfilePic1");
        CustomerDTO customer2 = new CustomerDTO("C002", "Saman Kumara", "Matara", "ProfilePic2");
        CustomerDTO customer3 = new CustomerDTO("C003", "Amal Perera", "Panadura", "ProfilePic3");

        customerService.saveCustomer(customer1);
        customerService.saveCustomer(customer2);
        customerService.saveCustomer(customer3);
    }

    @Test
    void getAllCustomers() {
        addAllCustomers();

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        assertEquals(3,allCustomers.size());
    }

    @Test
    void getCustomerDetails() {
        assertThrows(NotFoundException.class,
                () -> customerService.getCustomerDetails("C001"));

        CustomerDTO customerDTO = addOneCustomer();

        assertDoesNotThrow(() ->
                customerService.getCustomerDetails(customerDTO.getId()));
    }

    @Test
    void saveCustomer() {
        CustomerDTO customerDTO = new CustomerDTO("C001",
                "Kasun Sampath", "Galle", "ProfilePic1");
        CustomerDTO customer = customerService.saveCustomer(customerDTO);
        assertNotEquals(null,customer);
        assertNotEquals("C001",customer.getId());
        assertNotNull(customer);
    }

    @Test
    void updateCustomer() {
        CustomerDTO customerDTO = addOneCustomer();


        assertThrows(NotFoundException.class,
                () -> customerService.updateCustomer(new CustomerDTO(
                        "C001","Janith Lakmal","Kandy",
                        "ProfilePic1")));

        assertDoesNotThrow(() -> customerService.updateCustomer(new CustomerDTO(
                customerDTO.getId(),"Janith Lakmal","Kandy",
                "ProfilePic1")));
    }

    @Test
    void deleteCustomer() {
        CustomerDTO customerDTO = addOneCustomer();

        assertThrows(NotFoundException.class,
                () -> customerService.deleteCustomer("C001"));
    }
}