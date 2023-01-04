import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SolicitudesService {


  private API_SERVER = "http://localhost:8080/api/v1/solicitud";

  constructor(private httpClient: HttpClient) { }

  public getAllSolicitudes(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveSolicitud (solicitud:any): Observable<any>{
    console.log(solicitud)
    return this.httpClient.post(this.API_SERVER,solicitud);
  }
}
