package store;

import client.Client;
import client.ClientMessage;
import io.Output;
import product.ProductCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StoreExecutor {
    private final Map<StoreCode, Store> stores;
    private final Output out;

    public StoreExecutor(Output out) {
        this.stores = new HashMap<>();
        this.out = out;
    }

    public Set<StoreCode> storeProductCheck(ProductCode productCode) {
        Set<StoreCode> storeCodes = new HashSet<>();
        stores.forEach((key, value) -> {
            if (value.checkProductCode(productCode)) {
                storeCodes.add(key);
            }
        });
        return storeCodes;
    }

    public void exchange(StoreCode storeCode, Client client, ProductCode productCode) {
        if (!validClientExchange(storeCode, client, productCode)) {
            stores.get(storeCode).getClientExchange().get(client).add(productCode);
            out.message(storeCode, ClientMessage.SUCCESS_EXCHANGE);
        } else {
            out.message(storeCode, ClientMessage.FAIL_EXCHANGE);
        }
    }

    public boolean validClientExchange(StoreCode storeCode, Client client, ProductCode productCode) {
        try {
            return stores.get(storeCode).getClientExchange().get(client).contains(productCode);
        } catch (NullPointerException ignored) {
        }
        return false;
    }

    public void putStore(Store store, StoreCode code) {
        stores.put(code, store);
    }
}
