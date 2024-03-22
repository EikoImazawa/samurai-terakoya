package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.nagoyameshi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {  
    public User findByEmail(String email);
    public Page<User> findByNameLikeOrFuriganaLike(String nameKeyword, String furiganaKeyword, Pageable pageable);
    
    @Query("SELECT COUNT(u) FROM User u WHERE u.role.name IN ('ROLE_FREE_MEMBER', 'ROLE_PAID_MEMBER')")
    long countByRoleNameInRoleFreeMemberOrRolePaidMember();    

    long countByRole_Name(String roleName);
    
    @Query("SELECT u FROM User u WHERE u.role.name IN ('ROLE_FREE_MEMBER', 'ROLE_PAID_MEMBER')")
    List<User> findByRoleNameInRoleFreeMemberOrRolePaidMember(); 
}