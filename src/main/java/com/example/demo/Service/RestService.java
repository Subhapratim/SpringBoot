package com.example.demo.Service;

import com.example.demo.Bean.UserBean;
import com.example.demo.BeanCollection.BeanCollection;
import com.example.demo.Domain.User;
import com.example.demo.RepositoryOrDao.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public String getAllUsers() {
        BeanCollection beanCollection = new BeanCollection();
        beanCollection.setData((List) userRepository.findAll());
        String json = gson.toJson(beanCollection);
        return json;
    }


    public String getRecentUsers() {
        BeanCollection beanCollection = new BeanCollection();
//        beanCollection.setData(userRepository.findAllByOrderByCreateDateDesc());
        beanCollection.setData(userRepository.findTop3ByOrderByUpdateDateDesc());
        return gson.toJson(beanCollection);
    }

    public ResponseEntity<?> getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent() && user.get().isActive()){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public String updateUser(Long id, UserBean userBean) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User user1 = user.get();
            user1.setName(userBean.getName());
            user1.setEmail(userBean.getEmail());
            user1.setPassword(userBean.getPassword());
            userRepository.save(user1);
            return "Success";
        }
        return null;

    }

    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User user1 = user.get();
            user1.setActive(false);
            userRepository.save(user1);
            return "Success";
        }
        return null;
    }
}
