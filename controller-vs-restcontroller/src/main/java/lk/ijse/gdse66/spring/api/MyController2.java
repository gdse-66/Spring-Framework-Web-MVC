package lk.ijse.gdse66.spring.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/two")
public class MyController2 {
    public MyController2() {
        System.out.println("MyController2() - constructor");
    }

    @GetMapping
    public String getMethod(){
        System.out.println("MyController2");
        return "something";
    }
}
