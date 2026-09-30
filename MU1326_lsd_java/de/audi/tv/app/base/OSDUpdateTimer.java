/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.IOSDUpdateListener;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEventDefaultListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

public class OSDUpdateTimer
extends DefaultTimerListener {
    private final IOSDUpdateListener listener;
    private LogChannel log;
    final TVEventDefaultListener tvListener = new EventListener();
    private final Timer updateTimer;

    public OSDUpdateTimer(LogChannel logChannel, IOSDUpdateListener iOSDUpdateListener) {
        this.log = logChannel;
        this.listener = iOSDUpdateListener;
        this.updateTimer = new Timer("OSDUpdateTimer", 10000L, false, this);
    }

    public void fireTimer(Timer timer) {
        this.listener.updateProgress();
    }

    void deinit() {
        this.updateTimer.cancel();
    }

    private class EventListener
    extends TVEventDefaultListener {
        private EventListener() {
        }

        public void onSelectedServiceDebounced(ProgramInfo programInfo) {
            if (!TVUtil.isVideoService(programInfo.serviceInfo)) {
                OSDUpdateTimer.this.log.log(10000000, "[OSDUpdateTimer.onSelectedServiceDebounced] activate timer");
                OSDUpdateTimer.this.updateTimer.restart();
            } else {
                OSDUpdateTimer.this.log.log(10000000, "[OSDUpdateTimer.onSelectedServiceDebounced] deactivate timer");
                OSDUpdateTimer.this.updateTimer.cancel();
            }
        }
    }
}

