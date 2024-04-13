package com.github.fabio2g.stocksync.enums.product;

public enum CategoryEnum {
    CAMISETA("Camiseta"),
    CALCA("Calca"),
    VESTIDO("Vestido"),
    SAPATO("Sapato"),
    BOLSA("Bolsa"),
    CASACO("Casaco"),
    SAIA("Saia"),
    CAMISA("Camisa"),
    BLUSA("Blusa"),
    TERNO("Terno"),
    SHORTS("Shorts"),
    MACACAO("Macacao"),
    CHAPEU("Chapeu"),
    MEIA("Meia");

    private final String type;

    CategoryEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
