package product;

public enum ProductCode {
    PRODU_001("apple"),
    PRODU_002("banana"),
    PRODU_003("lemon"),
    PRODU_004("cheese"),
    PRODU_005("hoppang"),
    PRODU_006("gum"),
    PRODU_007("ice_cream"),
    PRODU_008("snack"),
    PRODU_009("chicken"),
    PRODU_010("pizza"),
    PRODU_012("spaghetti"),
    PRODU_013("ham"),
    PRODU_014("beef"),
    PRODU_015("wine"),
    PRODU_016("cookie"),
    PRODU_017("pie"),
    PRODU_018("pudding"),
    PRODU_019("sandwich"),
    PRODU_020("coffee");

    private final String name;

    ProductCode(String name) {
        this.name = name;
    }

    public static ProductCode find(String str) {
        String strUpper = str.toUpperCase();
        for (ProductCode inputType : values()) {
            if (inputType.name().equals(strUpper)) {
                return inputType;
            }
        }
        return null;
    }
}
