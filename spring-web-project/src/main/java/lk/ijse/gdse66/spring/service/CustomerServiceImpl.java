package lk.ijse.gdse66.spring.service;

import lk.ijse.gdse66.spring.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    ArrayList<CustomerDTO> customerList = new ArrayList<>();

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerList;
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        for (CustomerDTO customer : customerList) {
            if(customer.getId().equals(id))
                return customer;
        }
        return null;
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerList.add(customerDTO);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        for (CustomerDTO customer : customerList) {
            if(customer.getId().equals(customerDTO.getId())){
                customer.setId(customerDTO.getId());
                customer.setName(customerDTO.getName());
                customer.setAddress(customerDTO.getAddress());
            }
        }
    }

    @Override
    public void deleteCustomer(String id) {
        for (CustomerDTO customer : customerList) {
            if(customer.getId().equals(id)){
                customerList.remove(customer);
            }
        }
    }
}
