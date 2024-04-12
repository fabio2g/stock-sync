package com.github.fabio2g.stocksync.enums;

public enum ColorEnum {
    VERMELHO(1),
    VERDE(2),
    AZUL(3),
    AMARELO(4),
    LARANJA(5),
    ROXO(6),
    PRETA(7);

    private final int code;

    ColorEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ColorEnum getColorByCode(int code) {
        for (ColorEnum color : ColorEnum.values()) {
            if (color.getCode() == code) {
                return color;
            }
        }
        return null;
    }
}
