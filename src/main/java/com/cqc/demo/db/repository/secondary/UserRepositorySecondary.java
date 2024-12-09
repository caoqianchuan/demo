package com.cqc.demo.db.repository.secondary;

import com.cqc.demo.db.entity.secondary.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorySecondary extends CrudRepository<User, Long> {
}
