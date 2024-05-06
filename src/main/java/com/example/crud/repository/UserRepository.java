package com.example.crud.repository;

import com.example.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para definir operaciones de base de datos relacionadas con la entidad {@link User}.
 * Hereda métodos como save(), findAll(), findById(), delete() de JpaRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aquí puedes añadir métodos personalizados que requieran consultas específicas que no están cubiertas por los métodos de JpaRepository.
}
