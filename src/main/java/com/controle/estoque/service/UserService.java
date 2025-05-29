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

    public void updateUserById(Long id, User user){
        Optional<User> userExists =userRepository.findById(id);
        User userEntity = userExists.get();
        if(userExists.isPresent()){
            

            if(user.getName() != null){
                userEntity.setName(user.getName());
            }
            if(user.getPasseworld() != null){
                userEntity.setPasseworld(user.getPasseworld());
            }
            if(user.getContact() != null){
                userEntity.setContact(user.getContact());
            }
            if(user.getCnpj() != null){
                userEntity.setCnpj(user.getCnpj());
            }
            if(user.getEmail()!=null){
                userEntity.setEmail(user.getEmail());
            }

            userRepository.save(userEntity);
            
        }
        
    }

    public void deleteById(Long id){
        var userExiste = userRepository.existsById(id);
        if(userExiste){
            userRepository.deleteById(id);
        }
        
    }
}
