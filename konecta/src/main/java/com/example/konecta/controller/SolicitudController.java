package com.example.konecta.controller;

import com.example.konecta.model.Empleado;
import com.example.konecta.model.Solicitud;
import com.example.konecta.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/solicitud")

public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;
    Map<String, Object> map = new HashMap<>();
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    private ResponseEntity<ArrayList<Solicitud>> getAll(){
        return ResponseEntity.ok(solicitudService.getAll());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    private ResponseEntity<Object> save(@RequestBody Solicitud solicitud){
        try {
            solicitud = solicitudService.saveOrUpdate(solicitud);
            return ResponseEntity.created(new URI("/api/v1/solicitud/" + solicitud.getId())).body(solicitud);
        }catch (Exception e){
            map.put("error", true);
            map.put("message", "No se pudo crear la solicitud");
            return new ResponseEntity<Object>(map, HttpStatus.CONFLICT);

        }
    }
}
