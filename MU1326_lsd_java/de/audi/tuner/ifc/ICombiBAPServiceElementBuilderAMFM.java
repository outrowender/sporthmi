/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.tuner.app.TunerObjectContainer;

public interface ICombiBAPServiceElementBuilderAMFM {
    public CombiBAPCurrentStationInfo getAMFMCurrentStationEntry(TunerObjectContainer var1, int var2, int var3, int var4, HMIResourceLocator var5);

    public CombiBAPReceptionListEntry getAMFMListStationEntry(TunerObjectContainer var1, int var2);
}

