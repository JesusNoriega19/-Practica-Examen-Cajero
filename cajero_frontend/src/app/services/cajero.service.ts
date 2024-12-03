import { Injectable } from '@angular/core';  
import { HttpClient } from '@angular/common/http'; 
import { Observable } from 'rxjs';  

@Injectable({
  providedIn: 'root'  // Definimos que este servicio estará disponible en toda la aplicación
})
export class CajeroService {

  private apiUrl = 'http://localhost:8888/api/cajero'; // URL de la API backend, la cual es el punto de acceso para obtener el saldo y realizar el retiro

  // Inyección de HttpClient para realizar las solicitudes HTTP
  constructor(private http: HttpClient) { }

  // Método para obtener el saldo del cajero
  obtenerSaldo(): Observable<any> {
    // Realizamos una solicitud GET a la API para obtener el saldo
    return this.http.get(`${this.apiUrl}/saldo`);
  }

  // Método para realizar un retiro
  realizarRetiro(monto: number): Observable<any> {
    // Realizamos una solicitud GET con el monto que el usuario desea retirar
    return this.http.get(`${this.apiUrl}/retiro?monto=${monto}`);
  }
}
