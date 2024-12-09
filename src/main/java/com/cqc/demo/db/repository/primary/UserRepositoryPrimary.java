package com.cqc.demo.db.repository.primary;

import com.cqc.demo.db.entity.primary.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryPrimary extends CrudRepository<User, Long> {
}
