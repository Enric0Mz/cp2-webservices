package br.com.fiap.winery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {

    @Override
    @WebMethod
    public String getMenu() {
        System.out.println("Método getMenu() chamado.");

        StringBuilder menu = new StringBuilder();
        menu.append("--- Menu de Vinhos por Tipo de Uva ---\n");
        menu.append("\n");

        menu.append("🍇 Cabernet Sauvignon:\n");
        menu.append("  - Vinho Tinto A (Safra 2020)\n");
        menu.append("  - Vinho Tinto B (Reserva Especial)\n");
        menu.append("\n");

        menu.append("🍇 Merlot:\n");
        menu.append("  - Vinho Tinto C (Suave)\n");
        menu.append("  - Vinho Tinto D (Seco)\n");
        menu.append("\n");

        menu.append("🍇 Chardonnay:\n");
        menu.append("  - Vinho Branco E (Com madeira)\n");
        menu.append("  - Vinho Branco F (Sem madeira)\n");
        menu.append("\n");

        menu.append("🍇 Sauvignon Blanc:\n");
        menu.append("  - Vinho Branco G (Aromático)\n");
        menu.append("\n");

        menu.append("--- Fim do Menu ---");

        return menu.toString();
    }

    @Override
    @WebMethod
    public String placeOrder(String name, int quantity) {
        System.out.println("Método chamado com nome: " + name + ", quantidade: " + quantity);
        return "Pedido confirmado!";
    }

}