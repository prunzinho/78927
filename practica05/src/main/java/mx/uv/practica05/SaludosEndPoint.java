package mx.uv.practica05;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.saludos.BuscarSaludosResponse;
import mx.uv.t4is.saludos.SaludarRequest;
import mx.uv.t4is.saludos.SaludarResponse;
import mx.uv.t4is.saludos.BuscarSaludosResponse.Saludos;

@Endpoint
//

public class SaludosEndPoint {
    // Adjunta tambien al metoodo al que se esta apuntado
    ArrayList<Saludos> saludos = new ArrayList<>();

    @PayloadRoot(localPart = "SaludarRequest", namespace = "t4is.uv.mx/saludos")

    @ResponsePayload // La respuesta automaticamnente la convierte en el formato que corresponda
                     // //Payload de 2 tipos

    public SaludarResponse saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();

        respuesta.setRespuesta("hola" + peticion.getNombre());

        Saludos e = new Saludos();
        e.setNombre(peticion.getNombre());
        saludos.add(e); // add(peticion.getNombre());
        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "t4is.uv.mx/saludos")

    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos() {
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        // respuesta.getSaludos().add(saludos.get);
        for (int i = 0; i < saludos.size(); i++) {
            respuesta.getSaludos().add(saludos.get(i));
        }

        return respuesta;
    }

}
