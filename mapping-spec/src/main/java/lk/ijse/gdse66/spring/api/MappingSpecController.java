package lk.ijse.gdse66.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
public class MappingSpecController {

    @GetMapping
    public String getMethod(){
        return "getMethod()";
    }

    /* ---------------- path Mapping --------------- */

//    @GetMapping(path = "/ijse")
    @GetMapping("/ijse")
    public String getMethod2(){
        return "getMethod2()";
    }

    @GetMapping("/ijse/gdse")
    public String getMethod3(){
        return "getMethod3()";
    }

    /* ------------- Character Mapping ----------------- */

//    @GetMapping("/ijse/gdse???")
    @GetMapping("/ijse/gd?se")
    public String getMethod4(){
        return "getMethod4()";
    }

    /* ----------- Wildcard Mapping ------------- */

//    @GetMapping("/ijse/galle/*")
//    @GetMapping("/ijse/*/galle")
    @GetMapping("/ijse/*/*/galle")
    public String getMethod5(){
        return "getMethod5()";
    }

//    @GetMapping("/galle/**")
    @GetMapping("/galle/**/batch")
    public String getMethod6(){
        return "getMethod6()";
    }

//    @GetMapping("/batch*")
    @GetMapping("/ba*tch")
    public String getMethod7(){
        return "getMethod7()";
    }

    /* -------------- Extension Mapping ----------*/

    @GetMapping("/*.php")
    public String getMethod8(){
        return "getMethod8()";
    }


}
