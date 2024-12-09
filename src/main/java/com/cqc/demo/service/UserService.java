package com.cqc.demo.service;

import com.cqc.demo.annotation.ReadOnly;
import com.cqc.demo.annotation.WriteOnly;
import com.cqc.demo.db.entity.secondary.User;
import com.cqc.demo.db.repository.primary.UserRepositoryPrimary;
import com.cqc.demo.db.repository.secondary.UserRepositorySecondary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepositorySecondary userRepositorySecondary;

    @Autowired
    private UserRepositoryPrimary userRepositoryPrimary;

    @WriteOnly
    public List<User> getAllUsers() {
        return (List<User>) userRepositorySecondary.findAll();
    }

    @ReadOnly
    public void saveUser(com.cqc.demo.db.entity.primary.User user) {
        userRepositoryPrimary.save(user);
    }

    @Cacheable(value = "user", key = "#id")  // 查询并缓存结果
    public List<User>  getUserById(Long id) {
        // 模拟数据库查询
        System.out.println("Querying user with id: " + id);
        return getAllUsers();
    }

    @CachePut(value = "user", key = "#user.id")  // 更新缓存
    public User updateUser(User user) {
        // 模拟更新数据库
        System.out.println("Updating user: " + user);
        return user;
    }

    @CacheEvict(value = "user", key = "#id")  // 删除缓存
    public void deleteUser(Long id) {
        // 模拟删除数据库记录
        System.out.println("Deleting user with id: " + id);
    }

}
