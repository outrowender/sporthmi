/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import java.util.List;

public interface IFreetextConverter {
    default public List getPossibleConversions(String string, int n) {
    }

    default public int getNumberOfConversions() {
    }

    default public String getValidCharacters(String string) {
    }
}

