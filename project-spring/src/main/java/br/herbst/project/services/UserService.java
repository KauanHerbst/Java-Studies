package br.herbst.project.services;

import br.herbst.project.entities.User;
import br.herbst.project.repositories.UserRepository;
import br.herbst.project.services.exception.DataBaseException;
import br.herbst.project.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ResourceNotFoundException(id));
    }
    public User insert(User user){
        return userRepository.save(user);
    }

    public User delete(Long id){
        try{
            Optional<User> user = userRepository.findById(id);
            userRepository.delete(user.get());
            return user.get();
        }catch (NoSuchElementException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User bodyReqUser){
        User user = userRepository.getReferenceById(id);
        updateData(user, bodyReqUser);
        return userRepository.save(user);
    }

    public void updateData(User user, User bodyReqUser){
        user.setName(bodyReqUser.getName());
        user.setIdade(bodyReqUser.getIdade());
        user.setEstado(bodyReqUser.getEstado());
    }

}
