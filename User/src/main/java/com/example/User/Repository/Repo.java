package com.example.User.Repository;

import com.example.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<User,Long> {
}
