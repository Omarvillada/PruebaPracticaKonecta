import { Component, OnInit } from '@angular/core';
import { SolicitudesService } from '../services/solicitudes.service';
import { EmpleadosService } from '../services/empleados.service'
import { FormBuilder, FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';


@Component({
  selector: 'app-solicitud',
  templateUrl: './solicitud.component.html',
  styleUrls: ['./solicitud.component.css']
})
export class SolicitudComponent implements OnInit{

  empleados:any
  solicitud:any
  solicitudForm: FormGroup = new FormGroup({});

  constructor(
    public fb: FormBuilder,
    public empleadoService: EmpleadosService,
    public solicitudService: SolicitudesService
  ){

  }

  ngOnInit(): void {

    this.solicitudForm = this.fb.group({
      empleado: ['', Validators.required],
      codigo: ['', Validators.required],
      descripcion: ['', Validators.required],
      resumen: ['', Validators.required]
    });


    this.empleadoService.getAllEmpleados().subscribe(resp =>{

      this.empleados = resp
    },
    error =>{console.error(error)})

    this.solicitudService.getAllSolicitudes().subscribe(resp => {
      console.log(resp)
      this.solicitud = resp
    })
  }

  guardar(): void {
/**
     let valoresFormulario = this.solicitudForm.value;

    let empleadoSeleccionado = {
      id: valoresFormulario.empleado.id
    }

    let datosFormulario = {

      nombre: valoresFormulario.nombre,
      salario: valoresFormulario.salario
    };
 */
    let valoresFormulario = this.solicitudForm.value

    const form = {
      empleado: {id: valoresFormulario.empleado},
      codigo: valoresFormulario.codigo,
      descripcion: valoresFormulario.descripcion,
      resumen: valoresFormulario.resumen
    }


    this.solicitudService.saveSolicitud(form).subscribe(resp => {
      console.log(JSON.stringify(form))

      console.log(resp)

      this.solicitud = this.solicitud.filter((s: { id: any; }) => resp.id !== s.id)
      //this.empleados.push(resp);
    },
      error => { console.error(error) }
    )
  }
}
