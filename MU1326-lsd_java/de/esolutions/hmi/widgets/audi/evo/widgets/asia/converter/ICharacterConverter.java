/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import java.util.List;

public interface ICharacterConverter {
    default public void setUnconvertedCharacters(String string) {
    }

    default public String getUnconvertedCharacters() {
    }

    default public String getValidCharacters() {
    }

    default public List getConversions() {
    }

    default public List getConversions(int n) {
    }
}

