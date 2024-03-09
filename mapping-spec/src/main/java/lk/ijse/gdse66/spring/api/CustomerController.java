package lk.ijse.gdse66.spring.api;

import lk.ijse.gdse66.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    /*@GetMapping
    public String getAllCustomers(){
        return "getAllCustomers()";
    }*/

    /* --------------- path variables -----------------*/

    /*@GetMapping("/{city}")
    public String getCustomerByCity(@PathVariable String city){
        return String.format("getCustomerByCity(String city): %s",city);
    }*/

    @GetMapping("/{city}/{name}")
    public String getCustomerByCityAndName
            (@PathVariable String city, @PathVariable("name") String CusName){
        return String.format(
                "getCustomerByCity(String city, String name): %s, %s",city,CusName);
    }

    @GetMapping("/{id:C\\d{3}}")
    public String getCustomerById(@PathVariable String id){
        return String.format("getCustomerById(String id): %s",id);
    }

    /* ---------------- Query Parameters -----------------*/

    /*@GetMapping
    public String getMethodWithParam1(String id){
        return String.format("getMethodWithParam1(String id): %s",id);
    }*/

    @GetMapping
    public String getMethodWithParam1(@RequestParam(value = "CusId", required = false) String id){
        return String.format("getMethodWithParam1(String id): %s",id);
    }

    @GetMapping(params = "age")
    public String getMethodWithParam2(int age){
        return String.format("getMethodWithParam2(int age): %s",age);
    }

    @GetMapping(params = {"id", "name", "age"})
    public String getMethodWithParam3(@RequestParam("id") String cusId, String name, int age){
        return String.format(
                "getMethodWithParam3(String id, String name, int age): %s, %s, %s"
                ,cusId,name,age);
    }

    /* ---------- application/x-www-form-urlencoded OR query parameters ---------    */

    /*@PostMapping
    public String SaveCustomer(String id, String name, int age){
        return String.format(
                "SaveCustomer(String id, String name, int age): %s, %s, %s",
                id,name,age);
    }*/

    @PostMapping
    public String SaveCustomer(@ModelAttribute CustomerDTO customer){
        return customer.toString();
    }


}







