package com.example.demo.RestController;

import com.example.demo.Bean.UserBean;
import com.example.demo.Domain.User;
import com.example.demo.Service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest", produces = "application/json")
@CrossOrigin(origins = "*")
public class MyRestController {

    @Autowired
    RestService restService;

    @GetMapping("/user/all")
    public ResponseEntity<?> getAllUsers(){
        return restService.getAllUsers();
    }

    @GetMapping("/user/recent")
    public ResponseEntity<?> getRecentUsers(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return restService.getRecentUsers(page-1, size);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        return restService.getUser(id);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<?> getUser_v1(@RequestParam(name = "id") Long id){
        return restService.getUser(id);
    }

    @RequestMapping("/user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserBean userBean){
        return restService.updateUser(id, userBean);
    }

    @PutMapping("/user/update")
    public ResponseEntity<?> updateUser_v1(@RequestParam(name = "id") Long id, @RequestBody UserBean userBean){
        return restService.updateUser(id, userBean);
    }

    @RequestMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        return restService.deleteUser(id);
    }

    @DeleteMapping("/user/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteUser_v1(@RequestParam(name = "id") Long id){
        return restService.deleteUser(id);
    }
}
