/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.tuner.app.epg.sdars.EPGShortInfoExt;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.EPGDescription;

class SDARSEPGHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$DsiUpListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void informationEPGChannelList(EPGShortInfoExt[] ePGShortInfoExtArray) {
        SDARSEPGHandler.access$800(this.this$0, ePGShortInfoExtArray);
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        SDARSEPGHandler.access$900(this.this$0, stationInfoExt);
    }

    @Override
    public void responseEPG24Hour(EPGShortInfoExt ePGShortInfoExt) {
        SDARSEPGHandler.access$1000(this.this$0, ePGShortInfoExt);
    }

    @Override
    public void responseEPGDescription(EPGDescription ePGDescription) {
        SDARSEPGHandler.access$1100(this.this$0, ePGDescription);
    }

    /* synthetic */ SDARSEPGHandler$DsiUpListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

