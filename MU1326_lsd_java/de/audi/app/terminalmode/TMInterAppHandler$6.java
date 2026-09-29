/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.utils.generics.Function;

class TMInterAppHandler$6
implements Function {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$6(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    public TerminalModeDevice apply(TMDevice tMDevice) {
        return TMInterAppHandler.access$1000(tMDevice);
    }

    @Override
    public /* synthetic */ Object apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

