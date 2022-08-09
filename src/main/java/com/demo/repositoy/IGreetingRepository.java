package com.demo.repositoy;

import com.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingRepository extends JpaRepository<User,Long> {
}
