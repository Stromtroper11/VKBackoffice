package com.vk.backoffice.qr.repository;

import com.vk.backoffice.qr.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    @Query("select e from UserRole e where e.userId = :userId")
    List<UserRole> getRolesByUserId(Long userId);
}
