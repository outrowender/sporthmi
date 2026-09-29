/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.IContainsDabStation;
import org.dsi.ifc.radio.EPGShortInfo;

public class EPGShortInfoExt
extends EPGShortInfo
implements IContainsDabStation {
    private DabStation station;

    public EPGShortInfoExt(EPGShortInfo ePGShortInfo, DabStation dabStation) {
        super(ePGShortInfo.getEnsID(), ePGShortInfo.getEnsECC(), ePGShortInfo.getSID(), 0, ePGShortInfo.getNowProgramInfo(), ePGShortInfo.getNextProgramInfo(), ePGShortInfo.getExtendedProgramInfo());
        this.station = dabStation;
    }

    @Override
    public DabStation getDabStation() {
        return this.station;
    }

    public String getServiceName() {
        return this.station.service.fullName;
    }
}

