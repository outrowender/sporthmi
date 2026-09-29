/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.generics.GComparator;

class TMInterAppHandler$8
implements GComparator {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$8(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    public int compare(TMDevice tMDevice, TMDevice tMDevice2) {
        return new Long(tMDevice2.getAttachTime()).compareTo(new Long(tMDevice.getAttachTime()));
    }

    @Override
    public /* synthetic */ int compare(Object object, Object object2) {
        return this.compare((TMDevice)object, (TMDevice)object2);
    }
}

