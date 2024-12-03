package com.cajero_backend.cajero_backend.controllers;
import com.cajero_backend.cajero_backend.services.CajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// Definición del controlador como un RestController para manejar peticiones HTTP
@RestController
@RequestMapping("/api/cajero")  // Define la ruta base para las peticiones de este controlador
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde el origen indicado (por ejemplo, desde Angular)
public class CajeroController {

    // Inyección del servicio CajeroService, que contiene la lógica de negocio
    @Autowired
    private CajeroService cajeroService;

    // Método para manejar solicitudes GET en la ruta "/api/cajero/retiro"
    // Este método permite realizar un retiro de dinero, pasando el monto como parámetro
    @GetMapping("/retiro")
    public ResponseEntity<?> realizarRetiro(@RequestParam("monto") Double monto) {
        // Llama al servicio CajeroService para procesar el retiro con el monto proporcionado
        return cajeroService.procesarRetiro(monto);
    }

    // Método para manejar solicitudes GET en la ruta "/api/cajero/saldo"
    // Este método devuelve el saldo actual del cajero
    @GetMapping("/saldo")
    public ResponseEntity<?> obtenerSaldo() {
        // Llama al servicio CajeroService para obtener el saldo actual
        return ResponseEntity.ok(cajeroService.obtenerSaldo());
    }
}
