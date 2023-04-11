package store;

public enum StoreCode {
    KOREAA,
    KOREAB,
    KOREAC,
    KOREAD,
    KOREAE;

    public static StoreCode find(String str) {
        String strUpper = str.toUpperCase();
        for (StoreCode inputType : values()) {
            if (inputType.name().equals(strUpper)) {
                return inputType;
            }
        }
        return null;
    }
}
