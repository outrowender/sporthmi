/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.DefaultDSICarTimeUnitsLanguageListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;

public class ClockTimeZoneOffsetHandler {
    public final DSICarTimeUnitsLanguageListener dsiListener = new DSICarTimeUnitsLanguageListenerImpl();
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
    public void addClockTimeZoneOffsetListener(IClockTimeZoneOffsetListener iClockTimeZoneOffsetListener) {
        Object object = this.mutex;
        synchronized (object) {
            this.clockTimeZoneOffsetListeners.add(iClockTimeZoneOffsetListener);
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
        this.lc.log(10000000, "[ClockTimeZoneOffsetHandler.onDSUpdateClockTime] offset: %1 ", (double)clockTime.timeZone);
        this.lc.log(10000000, "[ClockTimeZoneOffsetHandler.onDSUpdateClockTime] summertime: %1", clockTime.summerTime);
        this.timeZoneOffset = l = (long)(clockTime.timeZone + (float)(clockTime.summerTime ? 1 : 0)) * 3600L * 1000L;
        Object object = this.mutex;
        synchronized (object) {
            Iterator iterator = this.clockTimeZoneOffsetListeners.iterator();
            while (iterator.hasNext()) {
                ((IClockTimeZoneOffsetListener)iterator.next()).offsetChanged(l);
            }
        }
    }

    public static interface IClockTimeZoneOffsetListener {
        public void offsetChanged(long var1);
    }

    private class DSICarTimeUnitsLanguageListenerImpl
    extends DefaultDSICarTimeUnitsLanguageListener {
        private boolean summerTime;
        private float timeZone;

        private DSICarTimeUnitsLanguageListenerImpl() {
        }

        public void updateClockTime(ClockTime clockTime, int n) {
            if (n == 1 && (this.summerTime != clockTime.summerTime || this.timeZone != clockTime.timeZone)) {
                this.summerTime = clockTime.summerTime;
                this.timeZone = clockTime.timeZone;
                ClockTimeZoneOffsetHandler.this.onDSUpdateClockTime(clockTime);
            }
        }
    }
}

