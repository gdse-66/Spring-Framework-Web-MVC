package lk.ijse.gdse66.spring.api;

import lk.ijse.gdse66.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getAllCustomers(){
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        customerList.add(new CustomerDTO("C001","Lahiru", "Galle"));
        customerList.add(new CustomerDTO("C002","Savinda","Matara"));
        customerList.add(new CustomerDTO("C003","Theekshana","Colombo"));
        return customerList;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomer(@RequestBody CustomerDTO customer){
        System.out.println(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        System.out.println(id);
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable("id") String id,
                               @RequestBody CustomerDTO customer){
        System.out.println(id);
        System.out.println(customer);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO GetCustomerDetails(@PathVariable("id") String id){
        return new CustomerDTO(id, "Amal Bandara", "Panadura");
    }
}
