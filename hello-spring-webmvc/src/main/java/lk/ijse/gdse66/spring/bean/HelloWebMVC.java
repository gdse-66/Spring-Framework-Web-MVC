package lk.ijse.gdse66.spring.bean;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWebMVC {
    /*public HelloWebMVC() {
        System.out.println("HelloWebMVC()");
    }*/

    /*@GetMapping
    public String myMethod(){
        System.out.println("myMethod() is invoked");
        return "myMethod";
    }*/

    /* handler / handler method */
    @GetMapping
    public String handleGetMethod(){
        System.out.println("handleGetMethod() is invoked");
        return "Received Get Request";
    }

    /* handler / handler method */
    @PostMapping
    public String handlePostMethod(){
        System.out.println("handlePostMethod() is invoked");
        return "Received Post Request";
    }

    /* handler / handler method */
    @DeleteMapping
    public String handleDeleteMethod(){
        System.out.println("handleDeleteMethod() is invoked");
        return "Received Delete Request";
    }

    /* handler / handler method */
    @PutMapping
    public String handlePutMethod(){
        System.out.println("handlePutMethod() is invoked");
        return "Received Put Request";
    }

    /* handler / handler method */
    @PatchMapping
    public String handlePatchMethod(){
        System.out.println("handlePatchMethod() is invoked");
        return "Received Patch Request";
    }


}
