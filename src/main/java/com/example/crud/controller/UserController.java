package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar usuarios.
 * Proporciona operaciones CRUD sobre usuarios.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;  // Servicio para las operaciones de negocio sobre usuarios.

    /**
     * Obtiene y retorna todos los usuarios registrados.
     * @return ResponseEntity que contiene una lista de usuarios.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Obtiene un usuario por su ID.
     * @param userId ID del usuario a buscar.
     * @return ResponseEntity con el usuario encontrado o un estado de no encontrado.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo usuario con los datos proporcionados.
     * @param user Datos del nuevo usuario.
     * @return ResponseEntity con el usuario creado y el estado HTTP creado.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Actualiza los datos de un usuario existente.
     * @param userId ID del usuario a actualizar.
     * @param userDetails Detalles del usuario para actualizar.
     * @return ResponseEntity con el usuario actualizado o un estado de no encontrado.
     */
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(userId, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un usuario basado en su ID.
     * @param userId ID del usuario a eliminar.
     * @return ResponseEntity con el resultado de la operación de eliminación.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        ResponseEntity<?> responseEntity = userService.deleteUser(userId);
        return responseEntity;
    }
}
