/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$AbstractCandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICharacterItem;

public final class AbstractConversionWidgetController$MultiCharItem
extends AbstractConversionWidgetController$AbstractCandidateItem
implements AbstractConversionWidgetController$ICharacterItem {
    public static final String TYPE_KEY;
    private String characters;
    private String abbreviatedCharacters;

    public AbstractConversionWidgetController$MultiCharItem() {
        this.reset();
    }

    public AbstractConversionWidgetController$MultiCharItem(String string) {
        this.characters = string;
    }

    @Override
    public String getTypeKey() {
        return "ConversionLineController.MultiCharItem";
    }

    @Override
    public void reset() {
        super.reset();
        this.characters = "";
        this.abbreviatedCharacters = "";
    }

    @Override
    public void setChars(String string) {
        this.characters = string;
        this.setColumnSpan(this.characters.length());
    }

    @Override
    public String getChars() {
        return this.characters;
    }

    @Override
    public String toString() {
        return new Buffer("MultiCharItem[").append("chars='").append(this.characters).append("'; col=").append(this.getColumnIndex()).append("; row=").append(this.getRowIndex()).append("; colSpan=").append(this.getColumnSpan()).append("]").toString();
    }

    @Override
    public String getAbbreviatedCharacters() {
        return this.abbreviatedCharacters;
    }

    @Override
    public void setAbbreviatedCharacters(String string) {
        this.abbreviatedCharacters = string;
    }
}

