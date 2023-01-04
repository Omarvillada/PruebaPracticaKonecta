package com.example.konecta.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fecha_ingreso;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "salario", nullable = false)
    private double salario;

    public Empleado() {
    }

    public Empleado(long id, LocalDate fecha_ingreso, String nombre, double salario) {
        this.id = id;
        this.fecha_ingreso = fecha_ingreso;
        this.nombre = nombre;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {

        this.fecha_ingreso = fecha_ingreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
