/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.sortandindex.station;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.sortandindex.station.AbstractIStationInfoComparatorAndIndexer;
import java.text.Collator;

public class SortAlgoName
extends AbstractIStationInfoComparatorAndIndexer {
    public SortAlgoName(LanguageManager languageManager) {
        super(languageManager, true);
    }

    protected String getStringUsedForIndexing(StationInfoExt stationInfoExt) {
        return stationInfoExt.shortLabel;
    }

    protected int compare(StationInfoExt stationInfoExt, StationInfoExt stationInfoExt2, Collator collator) {
        if (stationInfoExt.shortLabel == null) {
            return 1;
        }
        if (stationInfoExt2.shortLabel == null) {
            return -1;
        }
        return collator.compare(stationInfoExt.shortLabel, stationInfoExt2.shortLabel);
    }
}

