package com.example.demo.RestController;

import com.example.demo.Service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest", produces = "application/json")
@CrossOrigin(origins = "*")
public class MyRestController {

    @Autowired
    RestService restService;

    @GetMapping("/all")
    public String getAllUsers(){
        return restService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAllUsers(@PathVariable("id") Long id){
        ResponseEntity<?> responseEntity = restService.getUser(id);
        return responseEntity;
    }
}
