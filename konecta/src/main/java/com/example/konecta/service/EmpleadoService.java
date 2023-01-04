package com.example.konecta.service;

import com.example.konecta.model.Empleado;
import com.example.konecta.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpleadoService {
    /*
     * Consultar e insertar informacion del empleado
     * */
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public ArrayList<Empleado> getAll(){
        return (ArrayList<Empleado>) empleadoRepository.findAll();
    }

    public Empleado saveOrUpdate(Empleado empleado){
        return empleadoRepository.save(empleado);
    }
}
