package store;

import client.Client;
import io.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.ProductCode;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static product.ProductCode.*;
import static store.StoreCode.KOREAA;

@DisplayName("상점에서 상품쿠폰")
public class StoreExecutorTest {


    @Test
    @DisplayName("을 변경이 가능 합니다.")
    void success_change() {
        StoreExecutor storeExecutor = new StoreExecutor(new Output());
        storeExecutor.putStore(new Store(storeAProvider()), KOREAA);

        assertThat(storeExecutor.storeProductCheck(PRODU_001)).contains(KOREAA);
    }

    @Test
    @DisplayName("을 변경을 할 수 없습니다.")
    void fail_change() {
        StoreExecutor storeExecutor = new StoreExecutor(new Output());

        assertThat(storeExecutor.storeProductCheck(PRODU_001)).doesNotContain(KOREAA);
    }

    @Test
    @DisplayName("을 변경을 할 상점을 찾았습니다.")
    void findStoreProductCode() {
        StoreExecutor storeExecutor = new StoreExecutor(new Output());
        Store store = new Store(storeAProvider());
        storeExecutor.putStore(store, StoreCode.KOREAA);
        Client client = new Client("name");
        store.inClient(client);

        storeExecutor.exchange(KOREAA, client, PRODU_001);

        assertThat(storeExecutor.validClientExchange(KOREAA, client, PRODU_001)).isTrue();
    }

    @Test
    @DisplayName("을 변경을 할 상점을 찾지 못했습니다.")
    void findStoreNoneProductCode() {
        StoreExecutor storeExecutor = new StoreExecutor(new Output());
        Store store = new Store(storeAProvider());
        storeExecutor.putStore(store, StoreCode.KOREAA);
        Client client = new Client("name");
        store.inClient(client);

        storeExecutor.exchange(KOREAA, client, PRODU_001);

        assertThat(storeExecutor.validClientExchange(KOREAA, client, PRODU_001)).isTrue();

    }

    private static Set<ProductCode> storeAProvider() {
        return Set.of(PRODU_001, PRODU_002, PRODU_003, PRODU_004,
                PRODU_005, PRODU_006, PRODU_007, PRODU_008,
                PRODU_009, PRODU_010, PRODU_012, PRODU_013);
    }
}
