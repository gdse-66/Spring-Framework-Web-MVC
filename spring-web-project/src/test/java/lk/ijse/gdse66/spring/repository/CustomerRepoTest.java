package lk.ijse.gdse66.spring.repository;

import lk.ijse.gdse66.spring.config.WebRootConfig;
import lk.ijse.gdse66.spring.dto.CustomerDTO;
import lk.ijse.gdse66.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = WebRootConfig.class)
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    void addAllCustomers(){
        Customer customer1 = new Customer("C001", "Kasun Sampath", "Galle", "ProfilePic1");
        Customer customer2 = new Customer("C002", "Saman Kumara", "Matara", "ProfilePic2");
        Customer customer3 = new Customer("C003", "Amal Perera", "Matale", "ProfilePic3");

        customerRepo.save(customer1);
        customerRepo.save(customer2);
        customerRepo.save(customer3);
    }

    @Test
    void saveCustomer(){
        Customer customer = new Customer(
                "C001", "Kasun Sampath", "Galle", "ProfilePic1");
        Customer savedCustomer = customerRepo.save(customer);
        assertNotNull(savedCustomer);
    }

    @Test
    void getCustomersByName(){
        addAllCustomers();
        List<Customer> customerList = customerRepo.findCustomersByName("Kasun Sampath");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Test
    void getCustomersByNameAndAddress(){
        addAllCustomers();
        Customer customer = customerRepo.searchByNameAndAddress(
                "Kasun Sampath", "Galle");
        System.out.println(customer);
    }

    @Test
    void countCustomersByStartsWith(){
        addAllCustomers();
        int count = customerRepo.countCustomersByAddressStartsWith(
                "Ma");
        System.out.println(count);
    }

    @Test
    void getAllCustomers(){
        addAllCustomers();
//        List<Customer> customerList = customerRepo.getAllCustomersWithSQL();
//        List<Customer> customerList = customerRepo.getAllCustomersWithJPQL();
        List<Customer> customerList = customerRepo.getAllCustomersWithHQL();
        customerList.forEach(customer -> System.out.println(customer));
    }

    @Test
    void getAllCustomersWithNameAndAddress(){
        addAllCustomers();
//        List<Customer> customerList = customerRepo.getAllCustomersByNameAndAddress("Saman Kumara", "Matara");
        List<Customer> customerList = customerRepo.getAllCustomersByNameAndAddress2("Saman Kumara", "Matara");
        customerList.forEach(customer -> System.out.println(customer));

    }

}