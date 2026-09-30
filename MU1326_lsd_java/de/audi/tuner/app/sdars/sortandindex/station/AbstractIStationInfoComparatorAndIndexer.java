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

    protected String getStringUsedForIndexing(Object object) {
        return this.getStringUsedForIndexing(((IStationInfo)object).getStation());
    }

    protected int compare(Object object, Object object2, Collator collator) {
        return this.compare(((IStationInfo)object).getStation(), ((IStationInfo)object2).getStation(), collator);
    }

    protected abstract String getStringUsedForIndexing(StationInfoExt var1);

    protected abstract int compare(StationInfoExt var1, StationInfoExt var2, Collator var3);
}

