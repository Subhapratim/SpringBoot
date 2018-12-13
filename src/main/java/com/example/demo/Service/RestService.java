package com.example.demo.Service;

import com.example.demo.BeanCollection.BeanCollection;
import com.example.demo.Domain.User;
import com.example.demo.RepositoryOrDao.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestService {


    Gson gson = new Gson();

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public String getAllUsers() {
        BeanCollection beanCollection = new BeanCollection();
        beanCollection.setData((List) userRepository.findAll());
        String json = gson.toJson(beanCollection);
        return json;
    }
}
