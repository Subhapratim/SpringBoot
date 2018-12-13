package com.example.demo.RepositoryOrDao;

import com.example.demo.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    List<User> findAllByOrderByCreateDateDesc();

    List<User> findTop3ByOrderByUpdateDateDesc();
}
