package ntu.kiet.quanlybanhang.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ntu.kiet.quanlybanhang.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}