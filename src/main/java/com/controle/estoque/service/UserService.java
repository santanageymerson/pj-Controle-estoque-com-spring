package com.controle.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.model.User;
import com.controle.estoque.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listar(){
        return userRepository.findAll();
    }

    public User createUser(User user){
       User resposta = userRepository.save(user);
       return resposta;
    }

    public Optional<User> getUserById(Long id){
        
            return userRepository.findById(id);
    
    }

    public void deleteById(Long id){
        var userExiste = userRepository.existsById(id);
        if(userExiste){
            userRepository.deleteById(id);
        }
        
    }
}
