import { Component, OnInit } from '@angular/core';
import { CajeroService } from './services/cajero.service';

@Component({
  selector: 'app-root', 
  templateUrl: './app.component.html', 
  styleUrls: ['./app.component.css']  
})
export class AppComponent implements OnInit {
  saldo: any = [];  // Variable que almacenará el saldo disponible del cajero
  monto: number = 0;  // Variable que almacenará el monto a retirar
  mensaje: string = '';  // Variable para mostrar mensajes al usuario

  // Inyección de servicio CajeroService
  constructor(private cajeroService: CajeroService) {}

  // Al inicializar el componente, obtenemos el saldo
  ngOnInit(): void {
    this.obtenerSaldo();
  }

  // Método para obtener el saldo del cajero desde el servicio
  obtenerSaldo(): void {
    this.cajeroService.obtenerSaldo().subscribe(
      data => {
        // Si la solicitud es exitosa, asignamos el saldo a la variable 'saldo'
        this.saldo = data;
      },
      error => {
        // En caso de error, mostramos un mensaje de error
        console.error('Error al obtener saldo', error);
        this.mensaje = 'Hubo un error al obtener el saldo.';
      }
    );
  }

  // Método para realizar un retiro
  realizarRetiro(): void {
    // Verificar que el monto sea mayor que 0
    if (this.monto <= 0) {
      this.mensaje = 'El monto debe ser mayor que 0.';
      return;
    }

    // Llamar al servicio para realizar el retiro
    this.cajeroService.realizarRetiro(this.monto).subscribe(
      data => {
        // Si la respuesta es exitosa, mostramos el mensaje de éxito y actualizamos el saldo
        if (data.status === 'success') {
          this.mensaje = data.message;
          this.obtenerSaldo(); // Actualizamos el saldo después del retiro
        } else {
          // Si la respuesta es un error, mostramos un mensaje de error
          this.mensaje = 'Hubo un error al realizar el retiro.';
        }
      },
      error => {
        // En caso de error, mostramos un mensaje de error
        console.error('Error al realizar el retiro', error);
        this.mensaje = 'Hubo un error al realizar el retiro.';
      }
    );
  }

}
