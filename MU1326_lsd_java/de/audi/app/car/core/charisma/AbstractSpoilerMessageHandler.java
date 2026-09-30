/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.charisma.ISpoilerMessageHandler;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;

public abstract class AbstractSpoilerMessageHandler
implements ISpoilerMessageHandler {
    private final ICarApplication application;
    private final LogChannel logChannel;
    private boolean isAutoHideByGuide = false;
    private int currentMessageID = 0;
    private int visiblePartialPopupID = -1;

    public AbstractSpoilerMessageHandler(ICarApplication iCarApplication, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
    }

    public boolean isAutoHideByGuide() {
        return this.isAutoHideByGuide;
    }

    public void setAutoHideByGuide(boolean bl) {
        this.isAutoHideByGuide = bl;
    }

    public void init() {
    }

    public void deinit() {
    }

    public void showMessage(int n) {
        IHMIServiceApp iHMIServiceApp = this.application.getFrameworkAccess().getHmiServiceApp();
        if (this.isMessageSupported(n)) {
            this.logChannel.log(1000000, "[SpoilerMessageHandler#showMessage] messageID='%1'", (long)n);
            this.currentMessageID = n;
            int n2 = this.getPartialPopupID(n);
            if (-1 != this.visiblePartialPopupID && (0 == n || n2 != this.visiblePartialPopupID)) {
                if (!this.isAutoHideByGuide) {
                    iHMIServiceApp.removePartialPopup(0, this.visiblePartialPopupID);
                }
                this.visiblePartialPopupID = -1;
            }
            if (0 != n) {
                iHMIServiceApp.getChoiceModel(602332).setValue(n);
            }
            if (0 < n) {
                this.visiblePartialPopupID = n2;
                iHMIServiceApp.showPartialPopup(0, n2);
            }
        } else {
            this.logChannel.log(1000000, "[SpoilerMessageHandler#showMessage] messageID='%1' rejected - not supported", (long)n);
            if (-1 != this.visiblePartialPopupID) {
                iHMIServiceApp.removePartialPopup(0, this.visiblePartialPopupID);
                this.visiblePartialPopupID = -1;
            }
        }
    }

    public void updateMessage() {
        this.logChannel.log(1000000, "[SpoilerMessageHandler#updateMessage] called.");
        if (0 != this.currentMessageID) {
            this.showMessage(this.currentMessageID);
        }
    }

    protected abstract boolean isMessageSupported(int var1);

    protected abstract int getPartialPopupID(int var1);
}

