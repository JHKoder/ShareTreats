package client;


public enum ClientInputType {
    CHECK,
    HELP,
    CLAIM;

    public static ClientInputType find(String str) {
        String strUpper = str.toUpperCase();
        for (ClientInputType inputType : values()) {
            if (inputType.name().equals(strUpper)) {
                return inputType;
            }
        }
        return null;
    }
}
