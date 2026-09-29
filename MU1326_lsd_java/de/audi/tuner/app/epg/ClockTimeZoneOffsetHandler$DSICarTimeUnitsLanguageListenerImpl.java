/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg;

import de.audi.atip.util.DefaultDSICarTimeUnitsLanguageListener;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler$1;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

class ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl
extends DefaultDSICarTimeUnitsLanguageListener {
    private boolean summerTime;
    private float timeZone;
    private final /* synthetic */ ClockTimeZoneOffsetHandler this$0;

    private ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl(ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler) {
        this.this$0 = clockTimeZoneOffsetHandler;
    }

    @Override
    public void updateClockTime(ClockTime clockTime, int n) {
        if (n == 1 && (this.summerTime != clockTime.summerTime || this.timeZone != clockTime.timeZone)) {
            this.summerTime = clockTime.summerTime;
            this.timeZone = clockTime.timeZone;
            ClockTimeZoneOffsetHandler.access$100(this.this$0, clockTime);
        }
    }

    /* synthetic */ ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl(ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler, ClockTimeZoneOffsetHandler$1 clockTimeZoneOffsetHandler$1) {
        this(clockTimeZoneOffsetHandler);
    }
}

