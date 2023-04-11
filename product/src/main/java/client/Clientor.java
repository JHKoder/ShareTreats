package client;

import io.Output;
import product.ProductCode;
import store.StoreCode;
import store.StoreExecutor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Clientor {
    private final StoreExecutor storeExecutor;
    private final Client client;
    private final Output output;

    public Clientor(StoreExecutor storeExecutor, Client client, Output output) {
        this.storeExecutor = storeExecutor;
        this.client = client;
        this.output = output;
    }

    public Map<ProductCode, Set<StoreCode>> check(Set<ProductCode> productCodes) {
        HashMap<ProductCode, Set<StoreCode>> map = new HashMap<>();
        productCodes.forEach(productCode ->
                map.put(productCode, storeExecutor.storeProductCheck(productCode)));
        map.forEach(output::productCheck);
        return map;
    }

    public void help() {
        output.message(ClientMessage.HELP);
    }

    public void claim(StoreCode store, Set<ProductCode> productCodes) {
        if (validProduct(productCodes)) {
            for (ProductCode productCode : productCodes) {
                storeExecutor.exchange(store, client, productCode);
            }
        }
    }

    public void run(ClientInputType type, String[] arr) {
        if (type == ClientInputType.CHECK) {
            Set<ProductCode> productCodes = stream(arr).map(ProductCode::find).
                    collect(Collectors.toUnmodifiableSet());
            check(productCodes);
        } else if (type == ClientInputType.HELP) {
            help();
        } else if (type == ClientInputType.CLAIM) {
            StoreCode storeCode = StoreCode.find(arr[0]);
            Set<ProductCode> productCodes = new HashSet<>();
            for (int i = 1; i < arr.length; i++) {
                productCodes.add(ProductCode.find(arr[i]));
            }
            claim(storeCode, productCodes);
        }
    }

    private boolean validProduct(Set<ProductCode> productCodes) {
        if (productCodes.size() <= 10) {
            return true;
        }
        output.validProduct();
        return false;
    }
}
