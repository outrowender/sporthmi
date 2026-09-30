/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;

public class TrafficMiniMapInterruptStorage {
    private HashMap storage;
    private LogChannel logger;

    public TrafficMiniMapInterruptStorage(LogChannel logChannel) {
        this.logger = logChannel;
        this.storage = new HashMap();
    }

    public Interrupt[] getNewInterrupts(Interrupt[] interruptArray) {
        Interrupt[] interruptArray2 = new Interrupt[]{};
        if (null != interruptArray) {
            Interrupt interrupt = null;
            Integer n = null;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < interruptArray.length; ++i2) {
                this.logger.log(1000000, "TrafficMiniMapInterruptStorage#getNewInterrupts %1 of %2", (long)(1 + i2), (long)interruptArray.length);
                interrupt = interruptArray[i2];
                if (null == interrupt) {
                    this.logger.log(100000, "TrafficMiniMapInterruptStorage#getNewInterrupts interrupts[%1] nulled! -> continue", (long)i2);
                    continue;
                }
                n = new Integer(interrupt.getInterruptId());
                if (this.storage.containsKey(n)) {
                    this.logger.log(1000000, "TrafficMiniMapInterruptStorage#getNewInterrupts %1 is already in cache.", (Object)n);
                    continue;
                }
                this.logger.log(1000000, "TrafficMiniMapInterruptStorage#getNewInterrupts adding id=%1 to cache (size was %2 before).", (Object)n, (long)this.storage.size());
                this.storage.put(n, null);
                arrayList.add(interrupt);
            }
            interruptArray2 = (Interrupt[])arrayList.toArray(new Interrupt[0]);
        }
        return interruptArray2;
    }
}

