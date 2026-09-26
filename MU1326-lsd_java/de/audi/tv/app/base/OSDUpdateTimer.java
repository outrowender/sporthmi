/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.IOSDUpdateListener;
import de.audi.tv.app.base.OSDUpdateTimer$EventListener;
import de.audi.tv.app.base.TVEventDefaultListener;

public class OSDUpdateTimer
extends DefaultTimerListener {
    private final IOSDUpdateListener listener;
    private LogChannel log;
    final TVEventDefaultListener tvListener = new OSDUpdateTimer$EventListener(this, null);
    private final Timer updateTimer;

    public OSDUpdateTimer(LogChannel logChannel, IOSDUpdateListener iOSDUpdateListener) {
        this.log = logChannel;
        this.listener = iOSDUpdateListener;
        this.updateTimer = new Timer("OSDUpdateTimer", 0, false, this);
    }

    @Override
    public void fireTimer(Timer timer) {
        this.listener.updateProgress();
    }

    void deinit() {
        this.updateTimer.cancel();
    }

    static /* synthetic */ LogChannel access$100(OSDUpdateTimer oSDUpdateTimer) {
        return oSDUpdateTimer.log;
    }

    static /* synthetic */ Timer access$200(OSDUpdateTimer oSDUpdateTimer) {
        return oSDUpdateTimer.updateTimer;
    }
}

