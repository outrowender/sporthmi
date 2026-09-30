/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import de.audi.tuner.app.epg.dab.IDabEpgHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.radio.EPGFullInfo;

public class NullDabEpgHandler
extends NullService
implements IDabEpgHandler {
    public NullDabEpgHandler(LogChannel logChannel) {
        super(logChannel, "IDabEpgHandler");
    }

    public DSICarTimeUnitsLanguageListener getDSICarTimeUnitsLanguageListener() {
        this.log();
        return null;
    }

    public void setEPGList(EPGShortInfoExt[] ePGShortInfoExtArray) {
        this.log();
    }

    public void setEPGDetailData(EPGFullInfo ePGFullInfo) {
        this.log();
    }

    public RadioInfo[] getDabListeners() {
        this.log();
        return new RadioInfo[0];
    }

    public RadioInfo[] getUniListeners() {
        this.log();
        return new RadioInfo[0];
    }

    public void updateEPGDetailData() {
        this.log();
    }

    public void setFavoriteHandler(IStoreStationHandler iStoreStationHandler) {
        this.log();
    }
}

