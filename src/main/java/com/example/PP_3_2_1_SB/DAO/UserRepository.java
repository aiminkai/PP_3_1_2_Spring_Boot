package com.example.PP_3_2_1_SB.DAO;

import com.example.PP_3_2_1_SB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
}
