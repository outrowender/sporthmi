/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import de.audi.tuner.ifc.IStoreStationHandler;
import org.dsi.ifc.radio.EPGFullInfo;

public interface IDabEpgHandler {
    public void setEPGList(EPGShortInfoExt[] var1);

    public void setEPGDetailData(EPGFullInfo var1);

    public RadioInfo[] getDabListeners();

    public RadioInfo[] getUniListeners();

    public void updateEPGDetailData();

    public void setFavoriteHandler(IStoreStationHandler var1);
}

