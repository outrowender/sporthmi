/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.TMInterAppHandler$1;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.utils.generics.GIterator;

final class TMInterAppHandler$ActiveDeviceStateListener
implements IActiveDeviceStateListener {
    private volatile TerminalModeDevice activeDevice = TMInterAppHandler.access$1000(TMDevice.INVALID);
    private final /* synthetic */ TMInterAppHandler this$0;

    private TMInterAppHandler$ActiveDeviceStateListener(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        this.activeDevice = TMInterAppHandler.access$1000(tMDevice);
        TMInterAppHandler.access$100(this.this$0).log(1078071040, "-> [%1.updateActiveDeviceState] %2", (Object)"TMInterAppHandler", (Object)this.activeDevice);
        GIterator gIterator = TMInterAppHandler.access$200(this.this$0).iterator();
        while (gIterator.hasNext()) {
            try {
                ((ITerminalModeUpdateListener)gIterator.next()).updateActiveDeviceState(this.activeDevice);
            }
            catch (Exception exception) {
                TMInterAppHandler.access$100(this.this$0).log(-1601830656, "[%1.notifyDeviceList]", (Object)"TMInterAppHandler", (Throwable)exception);
            }
        }
    }

    /* synthetic */ TMInterAppHandler$ActiveDeviceStateListener(TMInterAppHandler tMInterAppHandler, TMInterAppHandler$1 tMInterAppHandler$1) {
        this(tMInterAppHandler);
    }

    static /* synthetic */ TerminalModeDevice access$900(TMInterAppHandler$ActiveDeviceStateListener tMInterAppHandler$ActiveDeviceStateListener) {
        return tMInterAppHandler$ActiveDeviceStateListener.activeDevice;
    }
}

