package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa a un usuario en la base de datos.
 * Utiliza Lombok para generar automáticamente getters y setters.
 */
@Data
@Entity
@Table(name = "usuarios") // Define el nombre de la tabla en la base de datos para esta entidad
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de generación de ID autoincremental
    private Long id;

    @Column(unique = true) // Especifica que el username debe ser único en la base de datos
    private String username;

    private String password; // Almacena la contraseña del usuario (debe ser almacenada de forma segura)

    // Getters y setters generados por lombok
}
