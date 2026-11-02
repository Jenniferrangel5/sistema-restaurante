package com.restaurante.cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheTest {

    @Test
    void naoPermitirPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("X-Burger", -16);
        });
    }

    @Test
    void xBaconComCheddarCusta26() {
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());
        assertEquals(26, lanche.getPreco(), 0.001);
    }
}