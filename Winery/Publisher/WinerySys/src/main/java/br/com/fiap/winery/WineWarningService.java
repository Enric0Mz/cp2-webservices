package br.com.fiap.winery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface WineWarningService {

    // Método "sendWarn" anotado como uma operação do serviço web
    @WebMethod
    String sendWarn();

}