/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.tuner.app.TunerObjectContainer;

public interface ICombiBAPServiceElementBuilderAMFM {
    default public CombiBAPCurrentStationInfo getAMFMCurrentStationEntry(TunerObjectContainer tunerObjectContainer, int n, int n2, int n3, HMIResourceLocator hMIResourceLocator) {
    }

    default public CombiBAPReceptionListEntry getAMFMListStationEntry(TunerObjectContainer tunerObjectContainer, int n) {
    }
}

