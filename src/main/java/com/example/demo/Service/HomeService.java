package com.example.demo.Service;

import com.example.demo.Bean.UserBean;
import com.example.demo.Domain.User;
import com.example.demo.RepositoryOrDao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    UserRepository userRepository;

    public boolean getUser(UserBean userBean) {
        User user = userRepository.findByEmail(userBean.getEmail());
        if(user != null && user.getPassword().equals(userBean.getPassword()))
            return true;
        else
            return false;
    }

    public boolean addUser(UserBean userBean) {
        User user = new User();
        user.setName(userBean.getName());
        user.setEmail(userBean.getEmail());
        user.setPassword(userBean.getPassword());
        userRepository.save(user);
        return true;
    }
}
