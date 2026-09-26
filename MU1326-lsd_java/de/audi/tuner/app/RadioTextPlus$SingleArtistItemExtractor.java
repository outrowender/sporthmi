/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.RadioTextPlus$AbstractSingleItemExtractor;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

class RadioTextPlus$SingleArtistItemExtractor
extends RadioTextPlus$AbstractSingleItemExtractor {
    public RadioTextPlus$SingleArtistItemExtractor(int n) {
        super(n);
    }

    @Override
    public ArtistAndTitlePair extract(SimpleIntObjectMap simpleIntObjectMap) {
        return new ArtistAndTitlePair((String)simpleIntObjectMap.get(this.rtItem), "");
    }
}

