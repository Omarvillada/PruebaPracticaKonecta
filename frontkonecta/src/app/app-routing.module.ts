import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { SolicitudComponent } from './solicitud/solicitud.component';
import { EmpleadoComponent } from './empleado/empleado.component';

const routes: Routes = [
  { path: 'solicitud', component: SolicitudComponent },
  {path: 'empleado', component: EmpleadoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
