/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.sortandindex.station;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.sdars.IStationInfo;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sortandindex.AbstractComparatorAndIndexer;
import java.text.Collator;

public abstract class AbstractIStationInfoComparatorAndIndexer
extends AbstractComparatorAndIndexer {
    protected AbstractIStationInfoComparatorAndIndexer(LanguageManager languageManager, boolean bl) {
        super(languageManager, bl);
    }

    @Override
    protected String getStringUsedForIndexing(Object object) {
        return this.getStringUsedForIndexing(((IStationInfo)object).getStation());
    }

    @Override
    protected int compare(Object object, Object object2, Collator collator) {
        return this.compare(((IStationInfo)object).getStation(), ((IStationInfo)object2).getStation(), collator);
    }

    protected abstract String getStringUsedForIndexing(StationInfoExt stationInfoExt) {
    }

    protected abstract int compare(StationInfoExt stationInfoExt, StationInfoExt stationInfoExt2, Collator collator) {
    }
}

