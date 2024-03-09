package lk.ijse.gdse66.spring.api;

import lk.ijse.gdse66.spring.dto.SupplierDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    /* --------- read Json come within request body ------------ */

    /*@PostMapping
    public String SaveSupplier(String id, String name, int age){
        return String.format(
                "SaveSupplier(String id, String name, int age): %s, %s, %s",
                id,name,age);
    }*/

    @PostMapping
    public String SaveSupplier(@RequestBody SupplierDTO supplier){
        return supplier.toString();
    }

    /* ----------- send Json within response body ------------ */

    /*@GetMapping(produces = "application/json")
    public SupplierDTO getAllSuppliers(){
        return new SupplierDTO("S001", "Saman", 22);
    }*/

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<SupplierDTO> getAllSupplierList(){
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        supplierList.add(new SupplierDTO("S001","Kamal",20));
        supplierList.add(new SupplierDTO("S002","Amal",21));
        supplierList.add(new SupplierDTO("S003","Nimal",22));
        return supplierList;
    }

}
