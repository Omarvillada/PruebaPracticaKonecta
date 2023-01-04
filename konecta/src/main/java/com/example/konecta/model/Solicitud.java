package com.example.konecta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Empleado empleado;

    @Column(name = "codigo", nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "resumen", nullable = false, length = 50)
    private String resumen;

    public Solicitud() {
    }

    public Solicitud(long id, Empleado empleado, String codigo, String descripcion, String resumen) {
        this.id = id;
        this.empleado = empleado;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.resumen = resumen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
}
