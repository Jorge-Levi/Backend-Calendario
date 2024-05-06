package com.example.crud.controller;

import com.example.crud.entity.Event;
import com.example.crud.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar eventos.
 * Proporciona métodos para operaciones CRUD sobre eventos.
 */
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * Obtiene y devuelve todos los eventos disponibles.
     *
     * @return una lista de eventos encapsulada en el cuerpo de ResponseEntity.
     */
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    /**
     * Obtiene un evento por su ID.
     *
     * @param eventId el ID del evento a buscar.
     * @return ResponseEntity con el evento encontrado o un status de no encontrado.
     */
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Long eventId) {
        Event event = eventService.getEventById(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo evento.
     *
     * @param event los detalles del evento a crear.
     * @return ResponseEntity con el evento creado y el status HTTP correspondiente.
     */
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    /**
     * Actualiza un evento existente.
     *
     * @param eventId el ID del evento a actualizar.
     * @param eventDetails los nuevos detalles para actualizar el evento.
     * @return ResponseEntity con el evento actualizado o un status de no encontrado.
     */
    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody Event eventDetails) {
        Event updatedEvent = eventService.updateEvent(eventId, eventDetails);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un evento por su ID.
     *
     * @param eventId el ID del evento a eliminar.
     * @return ResponseEntity con el resultado de la operación de eliminación.
     */
    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        ResponseEntity<?> responseEntity = eventService.deleteEvent(eventId);
        return responseEntity;
    }
}
