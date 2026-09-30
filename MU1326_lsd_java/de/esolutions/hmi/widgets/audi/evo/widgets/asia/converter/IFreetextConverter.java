/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import java.util.List;

public interface IFreetextConverter {
    public List getPossibleConversions(String var1, int var2);

    public int getNumberOfConversions();

    public String getValidCharacters(String var1);
}

