package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUsuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUsuerRepository usuerRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) usuerRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return usuerRepository.save(user);
    }

    public Optional<UserModel> getById(long id) {
        return usuerRepository.findById(id);
    }

    public UserModel updateById(long id, UserModel updatedUser) {
        UserModel user = usuerRepository.findById(id).orElse(null);

        if (user != null) {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());

            return usuerRepository.save(user);
        }

        return null; // O manejar el caso cuando el usuario con el ID dado no se encuentra
    }
    public  Boolean deleteUser (long id){
        try {
            usuerRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
