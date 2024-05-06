package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * La clase {@code Event} representa un evento dentro de la aplicación.
 * Esta clase es una entidad que se mapea a la tabla "eventos" en la base de datos.
 * Utiliza Lombok para generar automáticamente los métodos getters y setters.
 */
@Data // Anotación de Lombok que genera getters, setters, equals, canEqual, hashCode y toString.
@Entity // Esta anotación especifica que la clase es una entidad JPA.
@Table(name = "eventos") // Esta anotación define la tabla de la base de datos con la que se mapea la entidad.
public class Event {
    @Id // Esta anotación define el identificador único de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de generación de valor para el ID (auto incremento en la base de datos).
    private Long id; // Identificador único del evento.

    private String titulo; // Título del evento.

    @Column(name = "fecha_inicio") // Esta columna especifica el nombre de la columna en la base de datos para la fecha de inicio.
    private LocalDateTime fechaInicio; // Fecha y hora de inicio del evento.

    @Column(name = "fecha_fin") // Esta columna especifica el nombre de la columna en la base de datos para la fecha de fin.
    private LocalDateTime fechaFin; // Fecha y hora de fin del evento.

    // Los métodos getters y setters son generados automáticamente por la anotación @Data de Lombok.
}
