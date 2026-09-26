/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;
import java.util.Collections;
import java.util.List;

final class CharacterConverterFactory$1
implements ICharacterConverter {
    CharacterConverterFactory$1() {
    }

    @Override
    public void setUnconvertedCharacters(String string) {
    }

    @Override
    public String getValidCharacters() {
        return "";
    }

    @Override
    public String getUnconvertedCharacters() {
        return "";
    }

    @Override
    public List getConversions(int n) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List getConversions() {
        return Collections.EMPTY_LIST;
    }
}

