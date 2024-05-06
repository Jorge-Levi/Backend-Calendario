package com.example.crud.repository;

import com.example.crud.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Event.
 * Este repositorio extiende JpaRepository, proporcionando métodos CRUD para la entidad Event.
 *
 * @author Jorge
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
