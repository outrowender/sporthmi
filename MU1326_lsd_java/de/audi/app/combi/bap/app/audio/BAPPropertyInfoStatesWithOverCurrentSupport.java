/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.vw.mib.bap.generated.audiosd.serializer.InfoStates_Status;
import de.vw.mib.bap.requests.StatusProperty;

public final class BAPPropertyInfoStatesWithOverCurrentSupport
implements TimerListener {
    private static final int OVER_CURRENT_MIN_DISPLAY_TIME_MILLI_SECONDS = 3000;
    private final CombiModuleAudio combiModuleAudio;
    private final BAPFunctionPropertyFSG infoStateProperty;
    private final Object mutex = new Object();
    private final Timer infoStateMediatorTimer = new Timer("infoStateTimer", 3000L, true, this);
    private volatile StatusProperty statusPending = null;

    public BAPPropertyInfoStatesWithOverCurrentSupport(CombiModuleAudio combiModuleAudio, BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
        this.combiModuleAudio = combiModuleAudio;
        this.infoStateProperty = bAPFunctionPropertyFSG;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void statusREQ(StatusProperty statusProperty) {
        if (this.infoStateMediatorTimer.isRunning()) {
            Object object = this.mutex;
            synchronized (object) {
                this.statusPending = statusProperty;
            }
        } else {
            this.statusREQAndStartTimerIfNeeded(statusProperty);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        this.combiModuleAudio.getLogChannel().log(10000000, "[BAPPropertyInfoStatesWithOverCurrentSupport#fireTimer] restoring InfoStates before Overcurrent");
        StatusProperty statusProperty = null;
        Object object = this.mutex;
        synchronized (object) {
            if (this.statusPending != null) {
                statusProperty = this.statusPending;
                this.statusPending = null;
            }
        }
        if (statusProperty != null) {
            this.statusREQAndStartTimerIfNeeded(statusProperty);
        }
    }

    public void cancelTimer(Timer timer) {
    }

    private void statusREQAndStartTimerIfNeeded(StatusProperty statusProperty) {
        if (((InfoStates_Status)statusProperty).states == 53) {
            this.combiModuleAudio.getLogChannel().log(10000000, "[BAPPropertyInfoStatesWithOverCurrentSupport#statusREQAndStartTimerIfNeeded] Sending Overcurrent InfoStates");
            this.infoStateMediatorTimer.restart();
        }
        this.infoStateProperty.sendStatusIfChanged(statusProperty);
    }
}

