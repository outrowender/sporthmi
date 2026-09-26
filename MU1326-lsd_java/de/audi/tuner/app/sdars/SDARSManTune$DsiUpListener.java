/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSManTune$1;
import de.audi.tuner.app.sdars.SDARSManTune$DsiUpListener$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import java.util.ArrayList;
import java.util.Collections;

class SDARSManTune$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSManTune this$0;

    private SDARSManTune$DsiUpListener(SDARSManTune sDARSManTune) {
        this.this$0 = sDARSManTune;
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        if (!SDARSManTune.access$400(this.this$0).isRunning()) {
            SDARSManTune.access$502(this.this$0, stationInfoExt);
            SDARSManTune.access$600(this.this$0);
            SDARSManTune.access$800(this.this$0, SDARSManTune.access$700(this.this$0));
        }
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        ArrayList arrayList = new ArrayList(stationInfoExtArray.length);
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            if (stationInfoExtArray[i2].subscription != 2 || stationInfoExtArray[i2].stationNumber == 0) continue;
            arrayList.add(stationInfoExtArray[i2]);
        }
        Collections.sort(arrayList, new SDARSManTune$DsiUpListener$1(this));
        SDARSManTune.access$902(this.this$0, (StationInfoExt[])arrayList.toArray(new StationInfoExt[arrayList.size()]));
        SDARSManTune.access$1000(this.this$0).setLimits(0, SDARSManTune.access$900(this.this$0).length - 1, 1);
        SDARSManTune.access$600(this.this$0);
    }

    @Override
    public void updateSignalStatus(boolean bl) {
        this.this$0.noSignal = bl;
        SDARSManTune.access$800(this.this$0, SDARSManTune.access$700(this.this$0));
    }

    /* synthetic */ SDARSManTune$DsiUpListener(SDARSManTune sDARSManTune, SDARSManTune$1 sDARSManTune$1) {
        this(sDARSManTune);
    }
}

