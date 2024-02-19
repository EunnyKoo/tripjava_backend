package com.trip.tripjava.repository;

import com.trip.tripjava.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByIdAndPassword(String id, String password);
    UserEntity findByNickname(String nickname);
    UserEntity findByIdAndEmail(String id, String email);
}
