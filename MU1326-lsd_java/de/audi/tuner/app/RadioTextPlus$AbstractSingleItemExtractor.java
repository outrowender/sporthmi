/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.RadioTextPlus$ArtistAndTitlePairExtractor;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

abstract class RadioTextPlus$AbstractSingleItemExtractor
implements RadioTextPlus$ArtistAndTitlePairExtractor {
    protected final int rtItem;

    public RadioTextPlus$AbstractSingleItemExtractor(int n) {
        this.rtItem = n;
    }

    @Override
    public boolean canBeExtractedFrom(SimpleIntObjectMap simpleIntObjectMap) {
        return simpleIntObjectMap.get(this.rtItem) != null;
    }
}

