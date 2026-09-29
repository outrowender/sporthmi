/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.interapp.displaymanager.IDisplayManagerListener;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.dsi.DefaultDisplayManagementListener;

public class DisplayManagerListenerImpl
implements IDisplayManagerListener {
    private final LogChannel log;
    private DefaultDisplayManagementListener[] listeners = new DefaultDisplayManagementListener[0];
    private final Object mutexAddListeners = new Object();

    public DisplayManagerListenerImpl(LogChannel logChannel) {
        this.log = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListeners(DefaultDisplayManagementListener[] defaultDisplayManagementListenerArray) {
        Object object = this.mutexAddListeners;
        synchronized (object) {
            DefaultDisplayManagementListener[] defaultDisplayManagementListenerArray2 = new DefaultDisplayManagementListener[this.listeners.length + defaultDisplayManagementListenerArray.length];
            System.arraycopy((Object)this.listeners, 0, (Object)defaultDisplayManagementListenerArray2, 0, this.listeners.length);
            System.arraycopy((Object)defaultDisplayManagementListenerArray, 0, (Object)defaultDisplayManagementListenerArray2, this.listeners.length, defaultDisplayManagementListenerArray.length);
            this.listeners = defaultDisplayManagementListenerArray2;
        }
    }

    @Override
    public void startComponentResult(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "[DisplayManagerListenerImpl.startComponentResult] cid: %1, displayID: %2, sessionID: %3, resultCode: %4");
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].startComponentResult(n, n2, n3, n4);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DisplayManagerListenerImpl.startComponentResult]", (Throwable)exception);
        }
    }

    @Override
    public void stopComponentResult(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "[DisplayManagerListenerImpl.stopComponentResult] cid: %1, displayID: %2, sessionID: %3, resultCode: %4");
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].stopComponentResult(n, n2, n3, n4);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DisplayManagerListenerImpl.stopComponentResult]", (Throwable)exception);
        }
    }

    @Override
    public void setCroppingResult(int n) {
    }

    @Override
    public void error() {
        this.log.log(10000, "<- [DisplayManagerListenerImpl.error]");
    }
}

