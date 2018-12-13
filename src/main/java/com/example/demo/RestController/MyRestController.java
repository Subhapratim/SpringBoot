package com.example.demo.RestController;

import com.example.demo.Bean.UserBean;
import com.example.demo.Domain.User;
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

    @GetMapping(path = "/user")
    public ResponseEntity<?> getUserByIdParam(@RequestParam(name = "id") Long id){
        ResponseEntity<?> responseEntity = restService.getUser(id);
        return responseEntity;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        ResponseEntity<?> responseEntity = restService.getUser(id);
        return responseEntity;
    }

    @PutMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @RequestBody UserBean userBean){
        String status = restService.updateUser(id, userBean);
        return status;
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        String status = restService.deleteUser(id);
        return status;
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser_v1(@PathVariable("id") Long id){
        String status = restService.deleteUser(id);
        return status;
    }
}
