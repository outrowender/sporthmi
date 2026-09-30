/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.online.AbstractErrorHandler;
import de.audi.atip.log.LogChannel;

public final class OnlineApplicationState {
    public static final int CONTEXT_NONE = 0;
    public static final int CONTEXT_RED = 1;
    public static final int CONTEXT_MAP = 2;
    public static final int CONTEXT_CHECK = 3;
    public static final int CONTEXT_UNLOCK = 4;
    private static final String[] CONTEXT_NAMES = new String[]{"CONTEXT_NONE", "CONTEXT_RED", "CONTEXT_MAP", "CONTEXT_CHECK", "CONTEXT_UNLOCK"};
    private final LogChannel log;
    private volatile boolean redApp = false;
    private volatile boolean map = false;
    private volatile boolean check = false;
    private volatile boolean telUnlock = false;
    private volatile int context = 0;
    private volatile boolean wlan = false;
    private volatile boolean dataOnly = false;
    private final AbstractErrorHandler errorHandler;

    public OnlineApplicationState(LogChannel logChannel, AbstractErrorHandler abstractErrorHandler) {
        this.log = logChannel;
        this.errorHandler = abstractErrorHandler;
    }

    void updateRedApp(boolean bl) {
        this.redApp = bl;
        this.updateContext();
    }

    void updateWlan(boolean bl) {
        if (bl != this.wlan) {
            this.wlan = bl;
            this.updateApplicationState();
        }
    }

    void updateMap(boolean bl) {
        if (this.map != bl) {
            this.map = bl;
            this.updateContext();
        }
    }

    void updatePhone(boolean bl) {
        if (this.dataOnly != bl) {
            this.dataOnly = bl;
            this.updateApplicationState();
        }
    }

    void updateCheck(boolean bl) {
        if (this.check != bl) {
            this.check = bl;
            this.updateContext();
        }
    }

    void updateTelUnlock(boolean bl) {
        if (this.telUnlock != bl) {
            this.telUnlock = bl;
            this.updateContext();
        }
    }

    private void updateContext() {
        int n = 0;
        if (this.check) {
            n = 3;
        } else if (this.telUnlock) {
            n = 4;
        } else if (this.redApp) {
            n = 1;
        } else if (this.map) {
            n = 2;
        }
        if (this.context != n) {
            this.context = n;
            this.updateApplicationState();
        }
    }

    private void updateApplicationState() {
        this.log.log(10000000, "OnlineApplicationState#updateApplicationState(): new application state: %1", (Object)this);
        this.errorHandler.updateApplicationState(this.context, this.wlan, this.dataOnly);
    }

    public String toString() {
        return CONTEXT_NAMES[this.context] + "; wlan=" + this.wlan + "; dataOnly=" + this.dataOnly;
    }
}

