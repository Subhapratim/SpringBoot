package com.example.demo.Service;

import com.example.demo.Bean.UserBean;
import com.example.demo.Domain.User;
import com.example.demo.RepositoryOrDao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class HomeService {

    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest servletRequest;

    @Autowired
    UserRepository userRepository;

    public boolean getUser(UserBean userBean) {
        User user = userRepository.findByEmail(userBean.getEmail());
        if(user != null && user.getPassword().equals(userBean.getPassword())) {
            session.invalidate();
            HttpSession newSession = servletRequest.getSession(true);
            newSession.setAttribute("UserSession", user);
            return true;
        } else {
            return false;
        }
    }

    public boolean addUser(UserBean userBean) {
        User user = new User(userBean.getName(), userBean.getEmail(), userBean.getPassword());
        userRepository.save(user);

        session.invalidate();
        HttpSession newSession = servletRequest.getSession(true);
        newSession.setAttribute("UserSession", user);
        return true;
    }
}
