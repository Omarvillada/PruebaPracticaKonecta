package com.example.konecta.controller;

import com.example.konecta.model.Empleado;
import com.example.konecta.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    Map<String, Object> map = new HashMap<>();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    private ResponseEntity<ArrayList<Empleado>> getAll(){
        return ResponseEntity.ok(empleadoService.getAll());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    private ResponseEntity<Object> save(@RequestBody Empleado empleado){
        try {
            empleado = empleadoService.saveOrUpdate(empleado);
            return ResponseEntity.created(new URI("/api/v1/empleados/" + empleado.getId())).body(empleado);
        }catch (Exception e){
            map.put("error", true);
            map.put("message", "No se pudo crear el empleado");
            return new ResponseEntity<Object>(map, HttpStatus.CONFLICT);

        }
    }
}
