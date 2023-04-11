package io;

import client.ClientMessage;
import product.ProductCode;
import store.StoreCode;

import java.util.Set;

import static java.lang.String.format;
import static java.lang.System.out;

public class Output {
    public void message(ClientMessage message) {
        message.print();
    }

    public void message(StoreCode storeCode, ClientMessage successExchange) {
        out.println(format("""
                %s 상점에서  %s 되었습니다.
                """, storeCode.name(), successExchange.name()));
    }

    public void productCheck(ProductCode productCode, Set<StoreCode> key) {
        StringBuffer sb = new StringBuffer();
        sb.append(productCode.name()).append("의 상품코드에서 교환이 가능한 상점코드는 [");
        for (StoreCode storeCode : key) {
            sb.append(storeCode.name()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        out.println(sb);
    }

    public void validProduct() {
        out.println("상품교환은 10개까지 만 제공 됩니다.");
    }
}
