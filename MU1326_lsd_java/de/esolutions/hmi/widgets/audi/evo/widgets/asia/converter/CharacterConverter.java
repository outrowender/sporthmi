/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.IFreetextConverter;
import java.util.List;

class CharacterConverter
implements ICharacterConverter {
    private String unconvertedChars = "";
    private final IFreetextConverter converterImplementation;

    CharacterConverter(IFreetextConverter iFreetextConverter) {
        this.converterImplementation = iFreetextConverter;
    }

    public void setUnconvertedCharacters(String string) {
        if (StringUtilities.isNullOrEmpty(string)) {
            string = "";
        }
        this.unconvertedChars = string;
    }

    public String getUnconvertedCharacters() {
        return this.unconvertedChars;
    }

    public String getValidCharacters() {
        return this.converterImplementation.getValidCharacters(this.unconvertedChars);
    }

    public List getConversions() {
        return this.getConversions(Integer.MAX_VALUE);
    }

    public List getConversions(int n) {
        return this.converterImplementation.getPossibleConversions(this.unconvertedChars, n);
    }
}

