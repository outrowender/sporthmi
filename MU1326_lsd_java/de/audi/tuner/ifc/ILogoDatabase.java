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
    public void requestDataById(TunerObjectContainer[] var1, IRSDBResult var2);

    public HMIResourceLocator getLogo(long var1);

    public void requestAmFmData(AMFMStation[] var1, IRSDBResult var2);

    public void requestUniData(UnifiedStationExt[] var1, IRSDBResult var2);

    public void requestDabData(DabStation[] var1, IRSDBResult var2);

    public void resetToDefaultSettings();

    public boolean isRealDatabase();
}

