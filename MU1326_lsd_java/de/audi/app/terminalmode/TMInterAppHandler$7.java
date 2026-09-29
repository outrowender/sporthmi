/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.atip.utils.generics.GComparator;

class TMInterAppHandler$7
implements GComparator {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$7(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    public int compare(TMDevice tMDevice, TMDevice tMDevice2) {
        boolean bl;
        boolean bl2 = tMDevice.connectionState().isOneOf(TMDevice$ConnectionState.ATTACHED, TMDevice$ConnectionState.ACTIVATING, TMDevice$ConnectionState.ACTIVE);
        return bl2 == (bl = tMDevice2.connectionState().isOneOf(TMDevice$ConnectionState.ATTACHED, TMDevice$ConnectionState.ACTIVATING, TMDevice$ConnectionState.ACTIVE)) ? 0 : (bl2 ? -1 : 1);
    }

    @Override
    public /* synthetic */ int compare(Object object, Object object2) {
        return this.compare((TMDevice)object, (TMDevice)object2);
    }
}

