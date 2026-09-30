/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.amfm.dsi.AbstractStationConsistencyCheck;

class StationConsistencyCheck
extends AbstractStationConsistencyCheck {
    private final IPSFreezeDB psFreeze;

    StationConsistencyCheck(TunerBasics tunerBasics, IPSFreezeDB iPSFreezeDB) {
        super(tunerBasics);
        this.psFreeze = iPSFreezeDB;
    }

    public AMFMStation[] checkList(AMFMStation[] aMFMStationArray) {
        for (int i2 = 0; i2 < aMFMStationArray.length; ++i2) {
            aMFMStationArray[i2] = this.adjustStationContent(aMFMStationArray[i2], false);
            this.logger.amfmDeepDebug.log(10000000, "%2: %1", (Object)aMFMStationArray[i2], (long)i2);
        }
        return aMFMStationArray;
    }

    public AMFMStation checkStation(AMFMStation aMFMStation) {
        return this.adjustStationContent(aMFMStation, true);
    }

    private AMFMStation adjustStationContent(AMFMStation aMFMStation, boolean bl) {
        if (aMFMStation == null) {
            return aMFMStation;
        }
        aMFMStation.validateHd();
        if (bl && aMFMStation.serviceId == 0) {
            aMFMStation.serviceId = 1;
        }
        this.makeConsistent(aMFMStation);
        String string = this.psFreeze.getFreezedName(aMFMStation);
        if (string != null) {
            aMFMStation.freezePs(string);
        }
        return aMFMStation;
    }

    private void makeConsistent(AMFMStation aMFMStation) {
        String string = aMFMStation.name = aMFMStation.name == null ? "" : aMFMStation.name.trim();
        if (aMFMStation.isRds() && aMFMStation.name.length() == 0) {
            aMFMStation.ptyCode = 0;
            aMFMStation.pi = aMFMStation.isHd() && aMFMStation.serviceId > 0 ? aMFMStation.pi : -1;
            aMFMStation.rds = false;
            aMFMStation.scrollingPS = false;
        }
        if (aMFMStation.waveband == 1 && aMFMStation.serviceId == 0) {
            aMFMStation.serviceId = 1;
        }
        if (aMFMStation.serviceId > 1) {
            aMFMStation.ptyCode = 0;
        }
    }
}

