/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.rsdb.IRSDBResult;
import de.audi.tuner.app.uni.UnifiedStationExt;

public interface ILogoDatabase {
    default public void requestDataById(TunerObjectContainer[] tunerObjectContainerArray, IRSDBResult iRSDBResult) {
    }

    default public HMIResourceLocator getLogo(long l) {
    }

    default public void requestAmFmData(AMFMStation[] aMFMStationArray, IRSDBResult iRSDBResult) {
    }

    default public void requestUniData(UnifiedStationExt[] unifiedStationExtArray, IRSDBResult iRSDBResult) {
    }

    default public void requestDabData(DabStation[] dabStationArray, IRSDBResult iRSDBResult) {
    }

    default public void resetToDefaultSettings() {
    }

    default public boolean isRealDatabase() {
    }
}

