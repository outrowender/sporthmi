/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.sortandindex.station;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.sortandindex.station.AbstractIStationInfoComparatorAndIndexer;
import java.text.Collator;

public class SortAlgoCatAndStNumber
extends AbstractIStationInfoComparatorAndIndexer {
    public SortAlgoCatAndStNumber(LanguageManager languageManager) {
        super(languageManager, true);
    }

    @Override
    protected String getStringUsedForIndexing(StationInfoExt stationInfoExt) {
        return stationInfoExt.getShortCategory();
    }

    @Override
    protected int compare(StationInfoExt stationInfoExt, StationInfoExt stationInfoExt2, Collator collator) {
        String string = stationInfoExt.getShortCategory();
        String string2 = stationInfoExt2.getShortCategory();
        if (stationInfoExt.categoryNumber != stationInfoExt2.categoryNumber) {
            return collator.compare(string, string2);
        }
        return stationInfoExt.stationNumber - stationInfoExt2.stationNumber;
    }
}

