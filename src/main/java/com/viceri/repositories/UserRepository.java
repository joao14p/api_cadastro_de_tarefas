package com.viceri.repositories;

import entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<Users, Long> {

}
