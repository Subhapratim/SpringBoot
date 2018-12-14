package com.example.demo.RepositoryOrDao;

import com.example.demo.Domain.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    List<User> findAllByOrderByCreateDateDesc();

    List<User> findTop3ByOrderByUpdateDateDesc();

    @Query("select mm from User mm order by update_date DESC")
    List<User> findTopNByOrderByUpdateDateDesc(Pageable pageable);
}
