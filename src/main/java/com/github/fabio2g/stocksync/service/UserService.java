package com.github.fabio2g.stocksync.service;

import com.github.fabio2g.stocksync.dto.UserDTO;
import com.github.fabio2g.stocksync.exception.UserException;
import com.github.fabio2g.stocksync.model.User;
import com.github.fabio2g.stocksync.repository.UserRepository;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO save(UserDTO userDTO) {
        if (userRepository.findByLogin(userDTO.login()) != null) {
            throw new UserException("Erro de cadastro: Este login já está em uso por outro usuário.");
        }

        User entity = new User(
                userDTO.name(),
                userDTO.login(),
                userDTO.password(),
                userDTO.registration()
        );

        User newUser = userRepository.save(entity);

        return new UserDTO(
                newUser.getId(),
                newUser.getName(),
                newUser.getLogin(),
                newUser.getPassword(),
                newUser.getRegistration(),
                newUser.getRole(),
                newUser.getIsDeleted()
        );
    }

    public UserDTO findById(long id) {
        Optional<User> userEntity = userRepository.findById(id);

        if (userEntity.isPresent()) {
            User user = userEntity.get();

            return new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getRegistration(),
                    user.getRole(),
                    user.getIsDeleted()
            );
        } else {
            return new UserDTO(null, null, null, null, null, null, null);
        }
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();

        List<UserDTO> userDTOs = users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getRegistration(),
                        user.getRole(),
                        user.getIsDeleted()
                ))
                .collect(Collectors.toList());

        return userDTOs;
    }

    public Boolean delete(long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setIsDeleted(true);
            userRepository.save(user);

            return true;
        } else {
            return false;
        }
    }
}
