package com.example.konecta.service;

import com.example.konecta.model.Empleado;
import com.example.konecta.model.Solicitud;
import com.example.konecta.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public ArrayList<Solicitud> getAll(){
        return (ArrayList<Solicitud>) solicitudRepository.findAll();
    }

    public Solicitud saveOrUpdate(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }
}
