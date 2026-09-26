/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.uni.UnifiedStationExt;

public interface IPSFreezeDB {
    default public void add(AMFMStation aMFMStation) {
    }

    default public void remove(AMFMStation aMFMStation) {
    }

    default public String getFreezedName(AMFMStation aMFMStation) {
    }

    default public String getFreezedName(UnifiedStationExt unifiedStationExt) {
    }

    default public void removeAll() {
    }
}

