/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class RadioTextPlus {
    protected final LogChannel log;
    private static final ArtistAndTitlePairExtractor[] RT_ITEM_EXTRACTORS = new ArtistAndTitlePairExtractor[]{new PairExtractor(4, 1), new PairExtractor(4, 33), new PairExtractor(7, 1), new PairExtractor(8, 1), new SingleTitleItemExtractor(1), new SingleArtistItemExtractor(4), new SingleArtistItemExtractor(8), new SingleArtistItemExtractor(7), new PairExtractor(36, 33), new SingleArtistItemExtractor(36), new SingleTitleItemExtractor(33)};
    private final SimpleIntObjectMap rtPlus;
    private final ArtistAndTitlePair extractedArtistAndTitlePair;

    public RadioTextPlus(SimpleIntObjectMap simpleIntObjectMap, LogChannel logChannel) {
        this.log = logChannel;
        this.rtPlus = simpleIntObjectMap;
        logChannel.log(10000000, "[RadioTextPlus.extractArtistAndTitlePair]Available Items: %1", (Object)simpleIntObjectMap.getValues());
        this.extractedArtistAndTitlePair = RadioTextPlus.extractArtistAndTitlePair(simpleIntObjectMap);
        logChannel.log(10000000, "[RadioTextPlus.extractArtistAndTitlePair]Extracted Artist: %1 , Title: %2", (Object)this.extractedArtistAndTitlePair.artistString, (Object)this.extractedArtistAndTitlePair.titleString);
    }

    public RadioTextPlus(RadioTextPlus radioTextPlus) {
        this(RadioTextPlus.copyMap(radioTextPlus.rtPlus), radioTextPlus.log);
    }

    public String getTag(int[] nArray) {
        this.log.log(10000000, "[RadioTextPlus.getTag]wanted Tags: %1", (Object)nArray);
        String string = null;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            string = (String)this.rtPlus.get(nArray[i2]);
            if (string == null) continue;
            this.log.log(10000000, "[RadioTextPlus.getTag]return text: %1", (Object)string);
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

    private static class PairExtractor
    extends AbstractSingleItemExtractor {
        private final int otherRtItem;

        public PairExtractor(int n, int n2) {
            super(n);
            this.otherRtItem = n2;
        }

        public boolean canBeExtractedFrom(SimpleIntObjectMap simpleIntObjectMap) {
            return super.canBeExtractedFrom(simpleIntObjectMap) && simpleIntObjectMap.get(this.otherRtItem) != null;
        }

        public ArtistAndTitlePair extract(SimpleIntObjectMap simpleIntObjectMap) {
            return new ArtistAndTitlePair((String)simpleIntObjectMap.get(this.rtItem), (String)simpleIntObjectMap.get(this.otherRtItem));
        }
    }

    private static class SingleTitleItemExtractor
    extends AbstractSingleItemExtractor {
        public SingleTitleItemExtractor(int n) {
            super(n);
        }

        public ArtistAndTitlePair extract(SimpleIntObjectMap simpleIntObjectMap) {
            return new ArtistAndTitlePair("", (String)simpleIntObjectMap.get(this.rtItem));
        }
    }

    private static class SingleArtistItemExtractor
    extends AbstractSingleItemExtractor {
        public SingleArtistItemExtractor(int n) {
            super(n);
        }

        public ArtistAndTitlePair extract(SimpleIntObjectMap simpleIntObjectMap) {
            return new ArtistAndTitlePair((String)simpleIntObjectMap.get(this.rtItem), "");
        }
    }

    private static abstract class AbstractSingleItemExtractor
    implements ArtistAndTitlePairExtractor {
        protected final int rtItem;

        public AbstractSingleItemExtractor(int n) {
            this.rtItem = n;
        }

        public boolean canBeExtractedFrom(SimpleIntObjectMap simpleIntObjectMap) {
            return simpleIntObjectMap.get(this.rtItem) != null;
        }
    }

    private static interface ArtistAndTitlePairExtractor {
        public boolean canBeExtractedFrom(SimpleIntObjectMap var1);

        public ArtistAndTitlePair extract(SimpleIntObjectMap var1);
    }
}

