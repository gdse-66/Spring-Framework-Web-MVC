package lk.ijse.gdse66.spring.api;

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

    @GetMapping
    public String getMethodWithParam1(String id){
        return String.format("getMethodWithParam1(String id): %s",id);
    }



}







