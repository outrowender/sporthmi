/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import de.audi.tuner.ifc.IStoreStationHandler;
import org.dsi.ifc.radio.EPGFullInfo;

public interface IDabEpgHandler {
    default public void setEPGList(EPGShortInfoExt[] ePGShortInfoExtArray) {
    }

    default public void setEPGDetailData(EPGFullInfo ePGFullInfo) {
    }

    default public RadioInfo[] getDabListeners() {
    }

    default public RadioInfo[] getUniListeners() {
    }

    default public void updateEPGDetailData() {
    }

    default public void setFavoriteHandler(IStoreStationHandler iStoreStationHandler) {
    }
}

