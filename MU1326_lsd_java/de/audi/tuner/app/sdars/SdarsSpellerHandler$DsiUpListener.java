/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SdarsSpellerHandler;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;

class SdarsSpellerHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SdarsSpellerHandler this$0;

    private SdarsSpellerHandler$DsiUpListener(SdarsSpellerHandler sdarsSpellerHandler) {
        this.this$0 = sdarsSpellerHandler;
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        SdarsSpellerHandler.access$1300(this.this$0).clear();
        SdarsSpellerHandler.access$1400(this.this$0, "", "000");
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            short s;
            if (stationInfoExtArray[i2].subscription != 2 || (s = stationInfoExtArray[i2].stationNumber) >= 1000) continue;
            String string = String.valueOf(s);
            Buffer buffer = new Buffer();
            for (int i3 = 0; i3 < 3 - string.length(); ++i3) {
                buffer.append("0");
            }
            buffer.append(string);
            SdarsSpellerHandler.access$1400(this.this$0, "", buffer.toString());
        }
        SdarsSpellerHandler.access$800(this.this$0, SdarsSpellerHandler.access$700(this.this$0).getText());
    }

    /* synthetic */ SdarsSpellerHandler$DsiUpListener(SdarsSpellerHandler sdarsSpellerHandler, SdarsSpellerHandler$1 sdarsSpellerHandler$1) {
        this(sdarsSpellerHandler);
    }
}

