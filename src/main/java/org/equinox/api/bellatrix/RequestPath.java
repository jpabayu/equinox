package org.equinox.api.bellatrix;

public enum RequestPath {
    ACCESS("access"),
    ACCOUNTS("accounts"),
    MEMBERS("members"),
    MESSAGE("message"),
    INTERBANKS("interbanks"),
    PAYMENTS("payments"),
    POS("pos"),
    VIRTUAL_ACCOUNTS("virtualaccounts");

    private String requestPath;

    RequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getPath() {
        return requestPath;
    }
}
