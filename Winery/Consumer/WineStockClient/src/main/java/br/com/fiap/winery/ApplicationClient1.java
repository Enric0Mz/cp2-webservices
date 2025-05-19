package br.com.fiap.winery;

import br.com.fiap.winery.client.WineStockService;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class ApplicationClient1 {

    public static void main(String[] args) {

        System.out.println("Iniciando cliente WineStockService...");

        String wsdlUrlString = "http://localhost:8085/WineStockService?wsdl";

        URL url = null;
        try {
            url = new URL(wsdlUrlString);
            System.out.println("Objeto URL criado para WSDL: " + url);

        } catch (MalformedURLException e) {
            System.err.println("Erro: A URL do WSDL é inválida - " + e.getMessage());
            e.printStackTrace();
            return;
        }

        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceService");
        System.out.println("Objeto QName criado para Serviço: " + qName);

        Service service = Service.create(url, qName);
        System.out.println("Objeto Service criado usando URL e QName.");

        WineStockService wineStockService = service.getPort(WineStockService.class);
        System.out.println("Objeto proxy (wineStockService) do serviço obtido.");


        System.out.println("\nChamando getMenu()...");
        String menu = wineStockService.getMenu();
        System.out.println("Resposta de getMenu():");
        System.out.println(menu);

        System.out.println("\nChamando placeOrder(\"Cabernet Sauvignon\", 3)...");
        String orderResponse = wineStockService.placeOrder("Cabernet Sauvignon", 3);
        System.out.println("Resposta de placeOrder():");
        System.out.println(orderResponse);

        System.out.println("\nCliente finalizado.");
    }
}