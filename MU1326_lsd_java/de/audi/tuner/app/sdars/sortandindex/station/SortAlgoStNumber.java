/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.sortandindex.station;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.sortandindex.station.AbstractIStationInfoComparatorAndIndexer;
import java.text.Collator;

public class SortAlgoStNumber
extends AbstractIStationInfoComparatorAndIndexer {
    public SortAlgoStNumber(LanguageManager languageManager) {
        super(languageManager, false);
    }

    @Override
    protected String getStringUsedForIndexing(StationInfoExt stationInfoExt) {
        return null;
    }

    @Override
    protected int compare(StationInfoExt stationInfoExt, StationInfoExt stationInfoExt2, Collator collator) {
        return stationInfoExt.stationNumber - stationInfoExt2.stationNumber;
    }
}

