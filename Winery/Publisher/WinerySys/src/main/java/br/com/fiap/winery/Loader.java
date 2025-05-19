package br.com.fiap.winery;

import jakarta.xml.ws.Endpoint;

public class Loader {

    public static void main(String[] args) {
        String stockServiceAddress = "http://localhost:8085/WineStockService";

        WineStockServiceImplementation wineStock = new WineStockServiceImplementation();

        Endpoint.publish(stockServiceAddress, wineStock);

        System.out.println("Serviço publicado!");


        String warningServiceAddress = "http://localhost:8086/WineWarningService";

        WineWarningServiceImplementation wineWarning = new WineWarningServiceImplementation();

        Endpoint.publish(warningServiceAddress, wineWarning);

        System.out.println("Serviço publicado!");

        System.out.println("\nAmbos os serviços publicados! Mantenha este processo ativo.");
        System.out.println("WSDL do WineStockService: " + stockServiceAddress + "?wsdl");
        System.out.println("WSDL do WineWarningService: " + warningServiceAddress + "?wsdl");
        System.out.println("Para parar os serviços, pare o processo Java.");
    }
}