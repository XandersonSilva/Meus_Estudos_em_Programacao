package xanderson.edu.learnSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import xanderson.edu.learnSpringSecurity.model.User.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
    @Query("SELECT e FROM UserEntity e WHERE e.username=(:username)")
    UserDetails findByUsername(@Param ("username") String username);
    
}
