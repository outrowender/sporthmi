/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.RadioTextPlus$ArtistAndTitlePairExtractor;
import de.audi.tuner.app.RadioTextPlus$PairExtractor;
import de.audi.tuner.app.RadioTextPlus$SingleArtistItemExtractor;
import de.audi.tuner.app.RadioTextPlus$SingleTitleItemExtractor;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class RadioTextPlus {
    protected final LogChannel log;
    private static final RadioTextPlus$ArtistAndTitlePairExtractor[] RT_ITEM_EXTRACTORS = new RadioTextPlus$ArtistAndTitlePairExtractor[]{new RadioTextPlus$PairExtractor(4, 1), new RadioTextPlus$PairExtractor(4, 33), new RadioTextPlus$PairExtractor(7, 1), new RadioTextPlus$PairExtractor(8, 1), new RadioTextPlus$SingleTitleItemExtractor(1), new RadioTextPlus$SingleArtistItemExtractor(4), new RadioTextPlus$SingleArtistItemExtractor(8), new RadioTextPlus$SingleArtistItemExtractor(7), new RadioTextPlus$PairExtractor(36, 33), new RadioTextPlus$SingleArtistItemExtractor(36), new RadioTextPlus$SingleTitleItemExtractor(33)};
    private final SimpleIntObjectMap rtPlus;
    private final ArtistAndTitlePair extractedArtistAndTitlePair;

    public RadioTextPlus(SimpleIntObjectMap simpleIntObjectMap, LogChannel logChannel) {
        this.log = logChannel;
        this.rtPlus = simpleIntObjectMap;
        logChannel.log(-2137614336, "[RadioTextPlus.extractArtistAndTitlePair]Available Items: %1", (Object)simpleIntObjectMap.getValues());
        this.extractedArtistAndTitlePair = RadioTextPlus.extractArtistAndTitlePair(simpleIntObjectMap);
        logChannel.log(-2137614336, "[RadioTextPlus.extractArtistAndTitlePair]Extracted Artist: %1 , Title: %2", (Object)this.extractedArtistAndTitlePair.artistString, (Object)this.extractedArtistAndTitlePair.titleString);
    }

    public RadioTextPlus(RadioTextPlus radioTextPlus) {
        this(RadioTextPlus.copyMap(radioTextPlus.rtPlus), radioTextPlus.log);
    }

    public String getTag(int[] nArray) {
        this.log.log(-2137614336, "[RadioTextPlus.getTag]wanted Tags: %1", (Object)nArray);
        String string = null;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            string = (String)this.rtPlus.get(nArray[i2]);
            if (string == null) continue;
            this.log.log(-2137614336, "[RadioTextPlus.getTag]return text: %1", (Object)string);
            return string;
        }
        return "";
    }

    public ArtistAndTitlePair getArtistAndTitlePair() {
        return this.extractedArtistAndTitlePair;
    }

    public String getPlainRadioText() {
        return (String)this.rtPlus.get(64);
    }

    public int hashCode() {
        return this.rtPlus.getCapacity();
    }

    public boolean equals(Object object) {
        if (object instanceof RadioTextPlus) {
            RadioTextPlus radioTextPlus = (RadioTextPlus)object;
            if (this.rtPlus.getCapacity() != radioTextPlus.rtPlus.getCapacity()) {
                return false;
            }
            int[] nArray = this.rtPlus.getKeys();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (this.rtPlus.get(nArray[i2]).equals(radioTextPlus.rtPlus.get(nArray[i2]))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    private static SimpleIntObjectMap copyMap(SimpleIntObjectMap simpleIntObjectMap) {
        int[] nArray = simpleIntObjectMap.getKeys();
        Object[] objectArray = simpleIntObjectMap.getValues();
        SimpleIntObjectMap simpleIntObjectMap2 = new SimpleIntObjectMap(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            simpleIntObjectMap2.add(nArray[i2], objectArray[i2]);
        }
        return simpleIntObjectMap2;
    }

    private static ArtistAndTitlePair extractArtistAndTitlePair(SimpleIntObjectMap simpleIntObjectMap) {
        for (int i2 = 0; i2 < RT_ITEM_EXTRACTORS.length; ++i2) {
            if (!RT_ITEM_EXTRACTORS[i2].canBeExtractedFrom(simpleIntObjectMap)) continue;
            return RT_ITEM_EXTRACTORS[i2].extract(simpleIntObjectMap);
        }
        return ArtistAndTitlePair.EMPTY_PAIR;
    }
}

