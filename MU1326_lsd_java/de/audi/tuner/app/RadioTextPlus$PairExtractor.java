/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.RadioTextPlus$AbstractSingleItemExtractor;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

class RadioTextPlus$PairExtractor
extends RadioTextPlus$AbstractSingleItemExtractor {
    private final int otherRtItem;

    public RadioTextPlus$PairExtractor(int n, int n2) {
        super(n);
        this.otherRtItem = n2;
    }

    @Override
    public boolean canBeExtractedFrom(SimpleIntObjectMap simpleIntObjectMap) {
        return super.canBeExtractedFrom(simpleIntObjectMap) && simpleIntObjectMap.get(this.otherRtItem) != null;
    }

    @Override
    public ArtistAndTitlePair extract(SimpleIntObjectMap simpleIntObjectMap) {
        return new ArtistAndTitlePair((String)simpleIntObjectMap.get(this.rtItem), (String)simpleIntObjectMap.get(this.otherRtItem));
    }
}

