/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.navuota.UotaNavListener;
import de.audi.atip.log.LogChannel;

public class UotaNavListenerImpl
implements UotaNavListener {
    private UotaNavListener listener;
    private LogChannel logChannel;
    private int latitude;
    private int longitude;
    private boolean rgActive;

    public UotaNavListenerImpl(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void setListener(UotaNavListener uotaNavListener) {
        this.listener = uotaNavListener;
        if (uotaNavListener != null) {
            this.logChannel.log(1000000, "UotaNavListenerImpl#setListener() - listener registered");
            if (this.rgActive) {
                try {
                    uotaNavListener.startNewGuidance(this.latitude, this.longitude, true);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "UotaNavListenerImpl#startNewGuidance()", (Throwable)exception);
                }
            }
        } else {
            this.logChannel.log(1000000, "UotaNavListenerImpl#setListener() - listener deregistered");
        }
    }

    public void startNewGuidance(int n, int n2, boolean bl) {
        this.rgActive = true;
        this.latitude = n;
        this.longitude = n2;
        if (this.listener != null) {
            try {
                this.listener.startNewGuidance(n, n2, bl);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "UotaNavListenerImpl#startNewGuidance()", (Throwable)exception);
            }
        } else if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "UotaNavListenerImpl#startNewGuidance() - listener not registered! ");
        }
    }

    public void cancelLastGuidance() {
        this.rgActive = false;
        if (this.listener != null) {
            try {
                this.listener.cancelLastGuidance();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "UotaNavListenerImpl#cancelLastGuidance()", (Throwable)exception);
            }
        } else if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "UotaNavListenerImpl#cancelLastGuidance() - listener not registered! ");
        }
    }
}

