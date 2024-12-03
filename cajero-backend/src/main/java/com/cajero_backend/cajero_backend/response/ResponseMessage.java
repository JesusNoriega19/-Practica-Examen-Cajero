package com.cajero_backend.cajero_backend.response;

// Definición de la clase ResponseMessage, que se utiliza para representar un mensaje de respuesta
public class ResponseMessage {

    // Atributos que almacenan el estado y el mensaje de la respuesta
    private String status;
    private String message;

    // Constructor que inicializa los atributos de la clase
    public ResponseMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Método getter para obtener el valor del atributo status
    public String getStatus() {
        return status;
    }

    // Método getter para obtener el valor del atributo message
    public String getMessage() {
        return message;
    }
}
