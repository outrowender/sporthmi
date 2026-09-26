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

    @Override
    public void requestDataById(TunerObjectContainer[] tunerObjectContainerArray, IRSDBResult iRSDBResult) {
    }

    @Override
    public HMIResourceLocator getLogo(long l) {
        return ISimpleTuner.EMPTY_RL;
    }

    @Override
    public void requestAmFmData(AMFMStation[] aMFMStationArray, IRSDBResult iRSDBResult) {
    }

    @Override
    public void requestUniData(UnifiedStationExt[] unifiedStationExtArray, IRSDBResult iRSDBResult) {
    }

    @Override
    public void requestDabData(DabStation[] dabStationArray, IRSDBResult iRSDBResult) {
    }

    @Override
    public void resetToDefaultSettings() {
    }

    @Override
    public boolean isRealDatabase() {
        return false;
    }
}

