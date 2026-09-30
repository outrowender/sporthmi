/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.IDSIControllerStateListener;
import de.esolutions.fw.util.commons.Buffer;

public class JobNotifyDSIState
implements Runnable {
    private static final String LOGCLASS = "JobNotifyDSIState";
    private final AbstractDSIController dsiController;
    private final boolean availableState;

    public JobNotifyDSIState(AbstractDSIController abstractDSIController, boolean bl) {
        this.availableState = bl;
        this.dsiController = abstractDSIController;
    }

    public void run() {
        IDSIControllerStateListener iDSIControllerStateListener = this.dsiController.getStateListener();
        if (iDSIControllerStateListener == null) {
            this.dsiController.logger.log(1000000, "[%1.run] [%2,%3] No listener.", (Object)LOGCLASS, (Object)this.dsiController.getNameOfDSIServiceClass(), (long)this.dsiController.getInstanceID());
            return;
        }
        if (this.availableState) {
            iDSIControllerStateListener.dsiAvailable();
        } else {
            iDSIControllerStateListener.dsiUnavailable();
        }
    }

    public String toString() {
        return new Buffer().append(this.dsiController.getNameOfDSIServiceClass()).append("[").append(this.dsiController.getInstanceID()).append("] ").append(this.availableState ? "AVAILABLE" : "UNAVAILABLE").toString();
    }
}

