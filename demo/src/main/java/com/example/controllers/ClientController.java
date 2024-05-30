package com.example.controllers;
import com.example.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

@RestController
public class ClientController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String JSON_FILE_PATH = "clientes.json";

    @GetMapping("/cliente")
    public Cliente getCliente(@RequestParam(required = false) String nombre, @RequestParam(required = false) String numeroDocumento) throws Exception {
        // Lee el archivo JSON y convierte su contenido a un mapa
        Map<String, Map<String, String>> clientes = objectMapper.readValue(new File(JSON_FILE_PATH), Map.class);

        // Si se proporciona un nombre, busca el cliente por nombre
        if (nombre != null) {
            for (Map.Entry<String, Map<String, String>> entry : clientes.entrySet()) {
                Map<String, String> clienteData = entry.getValue();
                if (nombre.equals(clienteData.get("nombre"))) {
                    return mapToCliente(clienteData);
                }
            }
        }

        // Si se proporciona un número de documento, busca el cliente por número de documento
        if (numeroDocumento != null) {
            for (Map.Entry<String, Map<String, String>> entry : clientes.entrySet()) {
                Map<String, String> clienteData = entry.getValue();
                if (numeroDocumento.equals(clienteData.get("numeroDocumento"))) {
                    return mapToCliente(clienteData);
                }
            }
        }

        // Si no se encuentra ningún cliente, devuelve null
        return null;
    }

    // Método auxiliar para mapear los datos del cliente desde el mapa a un objeto Cliente
    private Cliente mapToCliente(Map<String, String> clienteData) {
        return new Cliente(
                clienteData.get("nombre"),
                clienteData.get("tipoCliente"),
                clienteData.get("numeroDocumento")
        );
    }
}