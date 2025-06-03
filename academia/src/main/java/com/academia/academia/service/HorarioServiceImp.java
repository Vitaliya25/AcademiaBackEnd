/**
 * Implementación del servicio HorarioService
 *
 * Esta clase gestiona la lógica de negocio relacionada con los horarios,
 * utilizando HorarioRepository para el acceso a datos.
 *
 * Funcionalidades principales:
 * - getAllHorarios(): obtiene la lista completa de horarios.
 * - getHorarioById(Long id): obtiene un horario específico por su ID.
 * - saveHorario(Horario horario): crea o actualiza un horario.
 * - deleteHorario(Long id): elimina un horario por su ID.
 * */
package com.academia.academia.service;

import com.academia.academia.entity.Horario;
import com.academia.academia.repository.HorarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImp implements HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioServiceImp(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Optional<Horario> getHorarioById(Long id) {
        return horarioRepository.findById(id);
    }

    @Override
    public Horario saveHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }
}