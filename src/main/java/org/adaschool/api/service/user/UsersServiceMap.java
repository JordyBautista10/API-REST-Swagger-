package org.adaschool.api.service.user;

import org.adaschool.api.exception.UserNotFoundException;
import org.adaschool.api.repository.user.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceMap implements UsersService {

    List<User> listaUsuarios = new ArrayList<User>();
    HashMap<String, User> diccionario = new HashMap<>();

    @Override
    public User save(User user) {
        diccionario.put(user.getId(), user);
        return null;
    }

    @Override
    public Optional<User> findById(String id) {
        try {
            return Optional.of(diccionario.get(id));
        } catch (Exception e) {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public List<User> all() {
        return listaUsuarios;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public User update(User user, String userId) {
        return null;
    }
}
