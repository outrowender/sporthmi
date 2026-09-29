/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.sortandindex.station;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.IContainsDabStation;
import de.audi.tuner.app.sortandindex.AbstractComparatorAndIndexer;
import java.text.Collator;

public abstract class AbstractDabStationComparatorAndIndexer
extends AbstractComparatorAndIndexer {
    protected AbstractDabStationComparatorAndIndexer(LanguageManager languageManager, boolean bl) {
        super(languageManager, bl);
    }

    @Override
    protected String getStringUsedForIndexing(Object object) {
        return this.getStringUsedForIndexing(((IContainsDabStation)object).getDabStation());
    }

    @Override
    protected int compare(Object object, Object object2, Collator collator) {
        return this.compare(((IContainsDabStation)object).getDabStation(), ((IContainsDabStation)object2).getDabStation(), collator);
    }

    protected abstract String getStringUsedForIndexing(DabStation dabStation) {
    }

    protected abstract int compare(DabStation dabStation, DabStation dabStation2, Collator collator) {
    }
}

