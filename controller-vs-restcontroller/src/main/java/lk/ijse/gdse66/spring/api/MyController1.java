package lk.ijse.gdse66.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* @Controller + @ResponseBody */
@RequestMapping("/one")
public class MyController1 {
    public MyController1() {
        System.out.println("MyController1() - constructor");
    }

    @GetMapping
    public String getMethod(){
        return "MyController1";
    }
}
