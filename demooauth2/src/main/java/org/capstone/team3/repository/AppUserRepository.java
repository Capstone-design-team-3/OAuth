package org.capstone.team3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.capstone.team3.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
}
