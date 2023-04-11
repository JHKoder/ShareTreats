import client.Client;
import client.ClientInputType;
import client.Clientor;
import io.Input;
import io.Output;
import product.ProductCode;
import store.Store;
import store.StoreCode;
import store.StoreExecutor;

import java.util.Set;

import static product.ProductCode.*;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        Store store = new Store(storeAProvider());
        StoreExecutor storeExecutor = new StoreExecutor(output);
        storeExecutor.putStore(store,StoreCode.KOREAA);

        Client client = new Client("Kang Jeong Hun");
        Clientor clientor = new Clientor(storeExecutor, client, output);

        store.inClient(client);

        while (true) {
            String[] arr = input.put();
            if (arr[0].equalsIgnoreCase("exit")) {
                break;
            }
            clientor.run(ClientInputType.find(arr[0]), input.toArr(arr));
        }
        input.close();
    }

    private static Set<ProductCode> storeAProvider() {
        return Set.of(PRODU_001, PRODU_002, PRODU_003, PRODU_004,
                PRODU_005, PRODU_006, PRODU_007, PRODU_008,
                PRODU_009, PRODU_010, PRODU_012,PRODU_013);
    }
}
