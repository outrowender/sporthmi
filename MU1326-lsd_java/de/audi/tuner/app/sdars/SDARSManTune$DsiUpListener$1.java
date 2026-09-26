/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSManTune$DsiUpListener;
import de.audi.tuner.app.sdars.StationInfoExt;
import java.util.Comparator;

class SDARSManTune$DsiUpListener$1
implements Comparator {
    private final /* synthetic */ SDARSManTune$DsiUpListener this$1;

    SDARSManTune$DsiUpListener$1(SDARSManTune$DsiUpListener sDARSManTune$DsiUpListener) {
        this.this$1 = sDARSManTune$DsiUpListener;
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((StationInfoExt)object).stationNumber - ((StationInfoExt)object2).stationNumber;
    }
}

