/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.sortandindex.station;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.sortandindex.station.SortAlgoDabStationName;
import java.text.Collator;

public class SortAlgoDabGenre
extends SortAlgoDabStationName {
    public SortAlgoDabGenre(LanguageManager languageManager) {
        super(languageManager);
    }

    protected String getStringUsedForIndexing(DabStation dabStation) {
        return null;
    }

    protected int compare(DabStation dabStation, DabStation dabStation2, Collator collator) {
        int n = Utilities.getDABPty(dabStation.service.ptyCodes);
        int n2 = Utilities.getDABPty(dabStation2.service.ptyCodes);
        n = n == 0 ? 32 : n;
        int n3 = n2 = n2 == 0 ? 32 : n2;
        if (n == n2) {
            return super.compare(dabStation, dabStation2, collator);
        }
        return n - n2;
    }
}

