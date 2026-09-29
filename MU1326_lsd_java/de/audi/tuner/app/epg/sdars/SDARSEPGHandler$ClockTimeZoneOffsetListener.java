/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;

class SDARSEPGHandler$ClockTimeZoneOffsetListener
implements ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$ClockTimeZoneOffsetListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void offsetChanged(long l) {
        SDARSEPGHandler.access$2000(this.this$0, l);
    }

    /* synthetic */ SDARSEPGHandler$ClockTimeZoneOffsetListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

