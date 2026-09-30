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
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.ISimpleTuner;

public class NullLogoDatabase
implements ILogoDatabase {
    public static final ILogoDatabase INSTANCE = new NullLogoDatabase();

    public void requestDataById(TunerObjectContainer[] tunerObjectContainerArray, IRSDBResult iRSDBResult) {
    }

    public HMIResourceLocator getLogo(long l) {
        return ISimpleTuner.EMPTY_RL;
    }

    public void requestAmFmData(AMFMStation[] aMFMStationArray, IRSDBResult iRSDBResult) {
    }

    public void requestUniData(UnifiedStationExt[] unifiedStationExtArray, IRSDBResult iRSDBResult) {
    }

    public void requestDabData(DabStation[] dabStationArray, IRSDBResult iRSDBResult) {
    }

    public void resetToDefaultSettings() {
    }

    public boolean isRealDatabase() {
        return false;
    }
}

