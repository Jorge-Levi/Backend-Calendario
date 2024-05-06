package com.example.crud.service;

import com.example.crud.entity.Event;
import com.example.crud.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que proporciona operaciones para gestionar eventos.
 * Utiliza {@link EventRepository} para interactuar con la base de datos.
 */
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    /**
     * Obtiene todos los eventos disponibles en la base de datos.
     * @return lista de todos los eventos.
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Busca un evento por su identificador.
     * @param eventId el ID del evento a buscar.
     * @return el evento encontrado, o null si no existe.
     */
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElse(null);
    }

    /**
     * Crea un nuevo evento en la base de datos.
     * @param event los detalles del evento a crear.
     * @return el evento guardado con ID asignado.
     */
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    /**
     * Actualiza los detalles de un evento existente.
     * @param eventId el ID del evento a actualizar.
     * @param eventDetails los nuevos detalles del evento a aplicar.
     * @return el evento actualizado, o null si el evento original no fue encontrado.
     */
    public Event updateEvent(Long eventId, Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setTitulo(eventDetails.getTitulo());
            event.setFechaInicio(eventDetails.getFechaInicio());
            event.setFechaFin(eventDetails.getFechaFin());
            return eventRepository.save(event);
        }
        return null;
    }

    /**
     * Elimina un evento de la base de datos.
     * @param eventId el ID del evento a eliminar.
     * @return ResponseEntity que indica el resultado de la operación.
     */
    public ResponseEntity<?> deleteEvent(Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            eventRepository.delete(event);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
