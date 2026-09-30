/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import java.util.List;

public interface ICharacterConverter {
    public void setUnconvertedCharacters(String var1);

    public String getUnconvertedCharacters();

    public String getValidCharacters();

    public List getConversions();

    public List getConversions(int var1);
}

