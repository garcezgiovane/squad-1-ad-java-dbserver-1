package com.aceleradev.codenation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleradev.codenation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
