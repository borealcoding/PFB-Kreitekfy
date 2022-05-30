package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.User;
import com.kreitek.kreitekfy.domain.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserPersistenceImpl implements UserPersistence {

    private final  UserRepository userRepository;

    @Autowired
    public UserPersistenceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
       List<User>users=this.userRepository.findAll();
       return users;
    }
    @Override
    public Optional<User> getUserById(Long userId) {

        return this.userRepository.findById(userId);
    }

    @Override
    public User saveUser(User user) {

        return this.userRepository.save(user);
    }
}
