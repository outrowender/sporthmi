/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.reactive.observables.Observables$Combinator3;
import de.audi.tv.app.tm.handling.DisplayModeHandler;
import org.dsi.ifc.tvtuner.ServiceInfo;

final class DisplayModeHandler$1
implements Observables$Combinator3 {
    DisplayModeHandler$1() {
    }

    public Integer combine(Boolean bl, Integer n, ServiceInfo serviceInfo) {
        int n2 = 0;
        if (n == 0) {
            n2 = DisplayModeHandler.access$000(serviceInfo, bl);
        }
        return new Integer(n2);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
        return this.combine((Boolean)object, (Integer)object2, (ServiceInfo)object3);
    }
}

