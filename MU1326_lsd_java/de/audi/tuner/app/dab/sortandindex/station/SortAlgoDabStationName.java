/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.sortandindex.station;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.sortandindex.station.AbstractDabStationComparatorAndIndexer;
import java.text.Collator;

public class SortAlgoDabStationName
extends AbstractDabStationComparatorAndIndexer {
    public SortAlgoDabStationName(LanguageManager languageManager) {
        super(languageManager, true);
    }

    @Override
    protected String getStringUsedForIndexing(DabStation dabStation) {
        if (dabStation.isService()) {
            return dabStation.service.fullName;
        }
        return null;
    }

    @Override
    protected int compare(DabStation dabStation, DabStation dabStation2, Collator collator) {
        if (dabStation.service.sID == dabStation2.service.sID) {
            if (dabStation.isComponent() && dabStation2.isComponent()) {
                return collator.compare(dabStation.component.fullName, dabStation2.component.fullName);
            }
            if (dabStation.isComponent()) {
                return 1;
            }
            if (dabStation2.isComponent()) {
                return -1;
            }
            int n = collator.compare(dabStation.service.fullName, dabStation2.service.fullName);
            if (n == 0) {
                n = collator.compare(dabStation.ensemble.fullName, dabStation2.ensemble.fullName);
            }
            return n;
        }
        return collator.compare(dabStation.service.fullName, dabStation2.service.fullName);
    }
}

