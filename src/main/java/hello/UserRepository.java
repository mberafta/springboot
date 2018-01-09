package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
