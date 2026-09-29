/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.hmi.PhoneSignalQualityHandler;
import de.audi.atip.utils.reactive.observables.Observables$Combinator;

class PhoneSignalQualityHandler$1
implements Observables$Combinator {
    private final /* synthetic */ PhoneSignalQualityHandler this$0;

    PhoneSignalQualityHandler$1(PhoneSignalQualityHandler phoneSignalQualityHandler) {
        this.this$0 = phoneSignalQualityHandler;
    }

    public Integer combine(PhoneStateChangedEvent phoneStateChangedEvent, TMDevice tMDevice) {
        if (tMDevice.isCarplayDevice()) {
            return new Integer(phoneStateChangedEvent.getSignalStrength() + 1);
        }
        return new Integer(0);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2) {
        return this.combine((PhoneStateChangedEvent)object, (TMDevice)object2);
    }
}

