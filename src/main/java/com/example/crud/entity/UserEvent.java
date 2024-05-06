package com.example.crud.entity;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa la relación entre un usuario y un evento en la base de datos.
 * Utiliza una tabla de nombre 'usuario_evento' para almacenar las asociaciones.
 *
 * La clase está anotada con @Entity para indicar que es una entidad JPA,
 * y con @Data de Lombok para generar automáticamente los métodos getter, setter y otros métodos útiles.
 */
@Entity
@Data
@Table(name = "usuario_evento")
public class UserEvent {

    /**
     * Usuario asociado con el evento. Es una clave foránea que referencia a la entidad User.
     * Esta columna se mapea a 'usuario_id' en la base de datos.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    /**
     * Evento asociado con el usuario. Es una clave foránea que referencia a la entidad Event.
     * Esta columna se mapea a 'evento_id' en la base de datos.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;

    // Getters y setters generados automáticamente por Lombok
}
