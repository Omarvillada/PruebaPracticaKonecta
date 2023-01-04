import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { HttpClientModule } from '@angular/common/http';
import { SolicitudComponent } from './solicitud/solicitud.component';
import { AppRoutingModule } from './app-routing.module';
import { EmpleadoComponent } from './empleado/empleado.component';

@NgModule({
  declarations: [
    AppComponent,
    SolicitudComponent,
    EmpleadoComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
