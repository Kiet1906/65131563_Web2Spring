package ntu.kiet.quanlybanhang.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ntu.kiet.quanlybanhang.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}