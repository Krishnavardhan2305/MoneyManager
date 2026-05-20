package com.example.MoneyManager.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MoneyManager.Entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> 
{
    // select * from tbl_profiles where email = ? 
    Optional<ProfileEntity> findByEmail(String email);
}
