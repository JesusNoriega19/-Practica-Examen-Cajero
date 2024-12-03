package com.cajero_backend.cajero_backend.services;

import com.cajero_backend.cajero_backend.models.Cajero;
import com.cajero_backend.cajero_backend.repository.CajeroRepository;
import com.cajero_backend.cajero_backend.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// La clase CajeroService es responsable de la lógica de negocio relacionada con el cajero automático
@Service
public class CajeroService {

    // Inyección automática del repositorio CajeroRepository para acceder a los datos del cajero
    @Autowired
    private CajeroRepository cajeroRepository;

    // Método que maneja la solicitud de un retiro, recibiendo el monto a retirar
    public ResponseEntity<?> procesarRetiro(Double monto) {
        // Obtener todas las denominaciones de billetes disponibles en el cajero
        List<Cajero> cajero = cajeroRepository.findAll();

        // Verificar si el retiro es posible con las denominaciones disponibles
        if (!esRetiroPosible(cajero, monto)) {
            // Si no es posible, se retorna un mensaje de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseMessage("error", "No es posible realizar el retiro con las denominaciones disponibles."));
        }

        // Si es posible realizar el retiro, se procede con el descuento
        realizarDescuento(cajero, monto);

        // Retorna una respuesta de éxito con un mensaje indicando que el retiro se realizó correctamente
        return ResponseEntity.ok(new ResponseMessage("success", "Retiro realizado con éxito"));
    }

    // Método privado que verifica si el retiro es posible con las denominaciones de billetes disponibles
    private boolean esRetiroPosible(List<Cajero> cajero, Double monto) {
        double restante = monto;

        // Recorremos las denominaciones de billetes de mayor a menor
        for (Cajero c : cajero) {
            if (restante == 0) break; // Si ya no queda monto por retirar, terminamos el ciclo

            // Calculamos cuántos billetes de la denominación actual se pueden retirar
            int maxBilletes = (int) (restante / c.getDenominacion());
            // Tomamos el menor valor entre los billetes que podemos retirar y los que hay disponibles
            int billetesARetirar = Math.min(maxBilletes, c.getCantidad());

            // Reducimos el monto restante a retirar
            restante -= billetesARetirar * c.getDenominacion();
        }

        // Si después de recorrer todas las denominaciones el monto restante es 0, es posible realizar el retiro
        return restante == 0;
    }

    // Método privado que actualiza la cantidad de billetes después de realizar el retiro
    private void realizarDescuento(List<Cajero> cajero, Double monto) {
        double restante = monto;

        // Recorremos las denominaciones de billetes de mayor a menor
        for (Cajero c : cajero) {
            if (restante == 0) break; // Si ya no queda monto por retirar, terminamos el ciclo

            // Calculamos cuántos billetes de la denominación actual se deben retirar
            int maxBilletes = (int) (restante / c.getDenominacion());
            // Tomamos el menor valor entre los billetes que podemos retirar y los que hay disponibles
            int billetesARetirar = Math.min(maxBilletes, c.getCantidad());

            // Actualizamos la cantidad de billetes disponibles
            c.setCantidad(c.getCantidad() - billetesARetirar);
            // Guardamos el estado actualizado de los billetes en el repositorio
            cajeroRepository.save(c);

            // Reducimos el monto restante a retirar
            restante -= billetesARetirar * c.getDenominacion();
        }
    }

    // Método que devuelve la lista de todas las denominaciones de billetes disponibles en el cajero
    public List<Cajero> obtenerSaldo() {
        return cajeroRepository.findAll();
    }
}
