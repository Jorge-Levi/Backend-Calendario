package com.example.crud.service;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que provee operaciones CRUD para los usuarios.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Obtiene una lista de todos los usuarios registrados en la base de datos.
     *
     * @return lista de usuarios.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param userId el ID del usuario a buscar.
     * @return el usuario encontrado, o null si no existe.
     */
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param user el usuario a crear.
     * @return el usuario creado.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Actualiza la información de un usuario existente.
     *
     * @param userId el ID del usuario a actualizar.
     * @param userDetails los detalles del usuario a actualizar.
     * @return el usuario actualizado, o null si el usuario no existe.
     */
    public User updateUser(Long userId, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param userId el ID del usuario a eliminar.
     * @return ResponseEntity con el estado de la operación.
     */
    public ResponseEntity<?> deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
