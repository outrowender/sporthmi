/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$1;

class DABEpgHandler$ClockTimeZoneOffsetListener
implements ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener {
    private final /* synthetic */ DABEpgHandler this$0;

    private DABEpgHandler$ClockTimeZoneOffsetListener(DABEpgHandler dABEpgHandler) {
        this.this$0 = dABEpgHandler;
    }

    @Override
    public void offsetChanged(long l) {
        DABEpgHandler.access$1700(this.this$0).setNotification(new int[]{29});
    }

    /* synthetic */ DABEpgHandler$ClockTimeZoneOffsetListener(DABEpgHandler dABEpgHandler, DABEpgHandler$1 dABEpgHandler$1) {
        this(dABEpgHandler);
    }
}

