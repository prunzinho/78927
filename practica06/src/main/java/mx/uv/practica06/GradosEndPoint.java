package mx.uv.practica06;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import mx.uv.t4is.grados.ConversionGradosCResponse;
import mx.uv.t4is.grados.ConversionGradosCRequest;
import mx.uv.t4is.grados.ConversionGradosFResponse;
import mx.uv.t4is.grados.ConversionGradosFRequest;
import mx.uv.t4is.grados.HistorialConversionesResponse;
import mx.uv.t4is.grados.HistorialConversionesResponse.Conversion;

@Endpoint
//

public class GradosEndPoint {
    ArrayList<Conversion> conversiones = new ArrayList<>();

    // Adjunta tambien al metoodo al que se esta apuntado
    @PayloadRoot(localPart = "ConversionGradosCRequest", namespace = "t4is.uv.mx/grados")

    @ResponsePayload

    public ConversionGradosCResponse conversionc(@RequestPayload ConversionGradosCRequest peticion) {
        ConversionGradosCResponse respuestGradosCResponse = new ConversionGradosCResponse();
        double convertorCtoF = ((peticion.getGrados()) * 9 / 5) + 32;
        respuestGradosCResponse.setResultado("Grados Celcius a Fahrenheit: " + convertorCtoF);
        Conversion e = new Conversion();
        e.setOperacion("Operacion en Grados Celcius " + convertorCtoF);
        conversiones.add(e);
        return respuestGradosCResponse;
    }

    @PayloadRoot(localPart = "ConversionGradosFRequest", namespace = "t4is.uv.mx/grados")

    @ResponsePayload

    public ConversionGradosFResponse conversionf(@RequestPayload ConversionGradosFRequest peticion) {
        ConversionGradosFResponse respuestGradosFResponse = new ConversionGradosFResponse();
        double convertorFtoC = ((peticion.getGrados()) - 32) * 5 / 9;
        respuestGradosFResponse.setResultado("Grados Fahrenheit a Celcius: " + convertorFtoC);
        Conversion e = new Conversion();
        e.setOperacion("Operacion en Grados Fahrenheit " + convertorFtoC);
        conversiones.add(e);
        return respuestGradosFResponse;
    }

    @PayloadRoot(localPart = "HistorialConversionesRequest", namespace = "t4is.uv.mx/grados")

    @ResponsePayload

    public HistorialConversionesResponse historial() {
        HistorialConversionesResponse hisotirConversionesResponse = new HistorialConversionesResponse();
        hisotirConversionesResponse.getConversion().addAll(conversiones);
        return hisotirConversionesResponse;
    }

}
