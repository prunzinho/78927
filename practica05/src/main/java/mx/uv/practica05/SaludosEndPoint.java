package mx.uv.practica05;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.saludos.SaludarRequest;
import mx.uv.t4is.saludos.SaludarResponse;

@Endpoint
//

public class SaludosEndPoint {
    // Adjunta tambien al metoodo al que se esta apuntado
    @PayloadRoot(localPart = "SaludarRequest", namespace = "t4is.uv.mx/saludos")

    @ResponsePayload // La respuesta automaticamnente la convierte en el formato que corresponda
                     // //Payload de 2 tipos
    public SaludarResponse saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("hola" + peticion.getNombre());
        return respuesta;
    }

    //

}
