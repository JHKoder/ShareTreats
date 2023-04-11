package store;

import client.Client;
import product.ProductCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Store {
    private final Map<Client, HashSet<ProductCode>> clientExchange;
    private final Set<ProductCode> productCodes;

    public Store(Set<ProductCode> productCodes) {
        this.clientExchange = new HashMap<>();
        this.productCodes =productCodes;
    }

    public void inClient(Client client){
        clientExchange.put(client,new HashSet<>());
    }

    public Map<Client, HashSet<ProductCode>> getClientExchange() {
        return clientExchange;
    }

    public boolean checkProductCode(ProductCode productCode){
        return productCodes.contains(productCode);
    }
}
