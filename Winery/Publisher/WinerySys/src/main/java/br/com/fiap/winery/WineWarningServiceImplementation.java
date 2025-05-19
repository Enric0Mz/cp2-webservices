package br.com.fiap.winery;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.winery.WineWarningService")
public class WineWarningServiceImplementation implements WineWarningService {

    @Override
    public String sendWarn() {
        System.out.println("Método sendWarn() chamado.");
        return "Estoque insuficiente!";
    }

}