package br.com.fiap.winery;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import br.com.fiap.winery.client.WineStockService;
import br.com.fiap.winery.client.WineWarningService;

public class ApplicationClient2 {

    public static void main(String[] args) {

        System.out.println("Iniciando cliente WineOrderClient...");

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

        String wsdlUrlString2 = "http://localhost:8086/WineWarningService?wsdl";

        URL url2 = null;
        try {
            url2 = new URL(wsdlUrlString2);
            System.out.println("Objeto URL criado para WSDL do WineWarningService: " + url2);
        } catch (MalformedURLException e) {
            System.err.println("Erro: A URL do WSDL do WineWarningService é inválida - " + e.getMessage());
            e.printStackTrace();
            return;
        }

        QName qName2 = new QName("http://winery.fiap.com.br/", "WineWarningServiceService");
        System.out.println("Objeto QName criado para WineWarningService: " + qName2);

        Service service = Service.create(url, qName);
        System.out.println("Objeto Service criado usando URL e QName.");

        WineStockService wineStockService = service.getPort(WineStockService.class);
        System.out.println("Objeto proxy (wineStockService) do serviço obtido.");

        System.out.println("\nChamando o método placeOrder(\"Merlot\", 5)...");
        String order = wineStockService.placeOrder("Merlot", 5);
        System.out.println("Resposta do pedido:");
        System.out.println(order);

        Service service2 = Service.create(url2, qName2);
        System.out.println("Objeto Service 'service2' criado para WineWarningService.");

        WineWarningService wineWarningService = service2.getPort(WineWarningService.class);
        System.out.println("Objeto proxy (wineWarningService) do serviço de aviso obtido.");

        System.out.println("\nChamando o método sendWarn()...");
        String warn = wineWarningService.sendWarn();
        System.out.println("Resposta do aviso:");
        System.out.println(warn);
        System.out.println("\nCliente WineOrderClient finalizado.");
    }
}