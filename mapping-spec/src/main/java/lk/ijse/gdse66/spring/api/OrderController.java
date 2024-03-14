package lk.ijse.gdse66.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    /*@GetMapping
    public String getOrders(@RequestHeader String token){
        return String.format("getOrders(token=%s)",token);
    }*/

    /*@GetMapping
    public String getOrders(@RequestHeader(value = "X-token",
            required = false) String token){
        return String.format("getOrders(token=%s)",token);
    }*/

    @GetMapping(headers = {"token"})
    public String getOrders(@RequestHeader String token){
        return String.format("getOrders(token=%s)",token);
    }
}
