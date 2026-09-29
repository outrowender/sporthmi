/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;

public class ClockTimeZoneOffsetHandler {
    public final DSICarTimeUnitsLanguageListener dsiListener = new ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl(this, null);
    private final Object mutex = new Object();
    private final LogChannel lc;
    private final ArrayList clockTimeZoneOffsetListeners = new ArrayList(2);
    private volatile long timeZoneOffset;

    public ClockTimeZoneOffsetHandler(LogChannel logChannel) {
        this.lc = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addClockTimeZoneOffsetListener(ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener clockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener) {
        Object object = this.mutex;
        synchronized (object) {
            this.clockTimeZoneOffsetListeners.add(clockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener);
        }
    }

    public long getOffset() {
        return this.timeZoneOffset;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSUpdateClockTime(ClockTime clockTime) {
        long l;
        this.lc.log(-2137614336, "[ClockTimeZoneOffsetHandler.onDSUpdateClockTime] offset: %1 ", (double)clockTime.timeZone);
        this.lc.log(-2137614336, "[ClockTimeZoneOffsetHandler.onDSUpdateClockTime] summertime: %1", clockTime.summerTime);
        this.timeZoneOffset = l = (long)(clockTime.timeZone + (float)(clockTime.summerTime ? 1 : 0)) * 0 * 0;
        Object object = this.mutex;
        synchronized (object) {
            Iterator iterator = this.clockTimeZoneOffsetListeners.iterator();
            while (iterator.hasNext()) {
                ((ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener)iterator.next()).offsetChanged(l);
            }
        }
    }

    static /* synthetic */ void access$100(ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler, ClockTime clockTime) {
        clockTimeZoneOffsetHandler.onDSUpdateClockTime(clockTime);
    }
}

