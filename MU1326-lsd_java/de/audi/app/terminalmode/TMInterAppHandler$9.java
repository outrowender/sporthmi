/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.collections.Predicate;

class TMInterAppHandler$9
implements Predicate {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$9(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.smartphoneType().isNot(SmartphoneManager$SmartphoneType.UNKNOWN);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

