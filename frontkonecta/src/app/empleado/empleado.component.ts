import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EmpleadosService } from '../services/empleados.service';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css']
})
export class EmpleadoComponent {

  empleadoForm: FormGroup = new FormGroup({});
  empleados: any;

  constructor(
    public fb: FormBuilder,
    public empleadoService: EmpleadosService
  ){}



  ngOnInit(): void{

    this.empleadoForm = this.fb.group({
      fecha_ingreso: ['', Validators.required],
      nombre: ['', Validators.required],
      salario: ['', Validators.required]
    });


    this.empleadoService.getAllEmpleados().subscribe(resp => {
      this.empleados = resp;
    },
      error => { console.error(error) }
    );
  }



  guardar(): void {
    let valoresFormulario = this.empleadoForm.value;
    /**
     *
     */
    let fechaFormateada = moment(valoresFormulario.fecha_ingreso).format('DD/MM/YYYY');

    let datosFormulario = {
      fecha_ingreso: fechaFormateada,
      nombre: valoresFormulario.nombre,
      salario: valoresFormulario.salario
    };

    this.empleadoService.saveEmpleado(datosFormulario).subscribe(resp => {

      //this.personaForm.reset();
      console.log(resp)
      this.empleados.push(resp);
    },
      error => { console.error(error) }
    )
  }
}
