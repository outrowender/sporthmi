/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognition;

public class MobileSpeechRecognitionHandler
implements TimerListener {
    private final LogChannel lc = Logger.getDSIASRLog();
    private DSIMobileSpeechRecognition dsi;
    private final ISDSPopupHelper sdsPopupHelper;
    private volatile boolean mobileSpeechRecognitionActive = false;
    private final Object mobileSpeechMutex = new Object();
    private final Timer mobileSpeechRecognitionTimer;
    private final Timer mobileSpeechRecognitionRestartTimer;
    private SDSTimeoutHandler sdsTimeoutHandler = null;
    private SDSHMIListener hmiListener = null;
    private AppSDSManager appSDSManager = null;

    public MobileSpeechRecognitionHandler(ISDSPopupHelper iSDSPopupHelper) {
        this.sdsPopupHelper = iSDSPopupHelper;
        this.mobileSpeechRecognitionTimer = new Timer("MobileSpeechRecognitionTimer", 5, this.lc, this, 3000L, true);
        this.mobileSpeechRecognitionRestartTimer = new Timer("MobileSpeechRecognitionRestartTimer", 5, this.lc, this, 500L, true);
        this.lc.log(10000000, "MobileSpeechRecognitionHandler initialized.");
    }

    void setDSI(DSIMobileSpeechRecognition dSIMobileSpeechRecognition) {
        this.dsi = dSIMobileSpeechRecognition;
    }

    public boolean requestStartSpeechRecognition() {
        if (this.dsi == null) {
            this.lc.log(100000, "MobileSpeechRecognitionHandler#requestStartSpeechRecognition: DSIMobileSpeechRecognition not available => NOP!");
            return false;
        }
        this.lc.log(10000000, "MobileSpeechRecognitionHandler#requestStartSpeechRecognition: called");
        this.dsi.requestStartSpeechRecognition();
        if (this.appSDSManager != null) {
            this.appSDSManager.setExternalSDSRequested(true);
        }
        return true;
    }

    public boolean requestDelayedStartSpeechRecognition() {
        if (this.dsi == null) {
            this.lc.log(100000, "MobileSpeechRecognitionHandler#requestDelayedStartSpeechRecognition: DSIMobileSpeechRecognition not available => NOP!");
            return false;
        }
        this.lc.log(10000000, "MobileSpeechRecognitionHandler#requestDelayedStartSpeechRecognition: called");
        this.mobileSpeechRecognitionRestartTimer.restart();
        return true;
    }

    public boolean requestStopSpeechRecognition() {
        if (this.mobileSpeechRecognitionRestartTimer.isRunning()) {
            this.mobileSpeechRecognitionRestartTimer.cancel();
        }
        if (!this.isMobileSpeechRecognitionActive()) {
            return false;
        }
        if (this.dsi == null) {
            return false;
        }
        this.lc.log(10000000, "MobileSpeechRecognitionHandler#requestStopSpeechRecognition: Mobile speech recognition active => request stop!");
        this.dsi.requestStopSpeechRecognition();
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isMobileSpeechRecognitionActive() {
        Object object = this.mobileSpeechMutex;
        synchronized (object) {
            return this.mobileSpeechRecognitionActive;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setMobileSpeechRecognitionActive(boolean bl) {
        this.lc.log(10000000, "MobileSpeechRecognitionHandler#setMobileSpeechRecognitionActive: value=%1", bl);
        if (bl) {
            if (this.mobileSpeechRecognitionTimer.isRunning()) {
                this.lc.log(10000000, "MobileSpeechRecognitionHandler#setMobileSpeechRecognitionActive: Canceling timer!");
                this.mobileSpeechRecognitionTimer.cancel();
            }
            if (this.sdsTimeoutHandler != null) {
                this.lc.log(10000000, "MobileSpeechRecognitionHandler#setMobileSpeechRecognitionActive: reset PTT running timer!");
                this.sdsTimeoutHandler.cancelPTTRunningTimer();
            } else {
                this.lc.log(10000000, "MobileSpeechRecognitionHandler#setMobileSpeechRecognitionActive: SDS timeout handler NULL -> cannot reset PTT running timer!");
            }
            Object object = this.mobileSpeechMutex;
            synchronized (object) {
                this.mobileSpeechRecognitionActive = true;
            }
            this.sdsPopupHelper.triggerHapticalPopup(114, true);
            this.hmiListener.updateStatusExternalSDS(true);
        } else {
            if (this.mobileSpeechRecognitionTimer.isRunning()) {
                this.lc.log(10000000, "MobileSpeechRecognitionHandler#setMobileSpeechRecognitionActive: Timer already running!");
                return;
            }
            this.lc.log(10000000, "MobileSpeechRecognitionHandler#setMobileSpeechRecognitionActive: Start hide popup timer!");
            this.mobileSpeechRecognitionTimer.start();
        }
    }

    public void unsetDSI() {
        this.lc.log(10000000, "MobileSpeechRecognitionHandler#unsetDSI: called");
        this.dsi = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        if (timer == this.mobileSpeechRecognitionTimer) {
            Object object = this.mobileSpeechMutex;
            synchronized (object) {
                if (!this.mobileSpeechRecognitionActive) {
                    return;
                }
                this.mobileSpeechRecognitionActive = false;
            }
            this.sdsPopupHelper.triggerHapticalPopup(114, false);
            this.hmiListener.updateStatusExternalSDS(false);
            return;
        }
        if (timer == this.mobileSpeechRecognitionRestartTimer) {
            this.requestStartSpeechRecognition();
            return;
        }
        this.lc.log(100000, "MobileSpeechRecognitionHandler#fireTimer: Unhandled timer %1 => NOP!", (Object)timer);
    }

    public void cancelTimer(Timer timer) {
        this.lc.log(10000000, "MobileSpeechRecognitionHandler#cancelTimer: NOP!");
    }

    public void setSDSTimeoutHandler(SDSTimeoutHandler sDSTimeoutHandler) {
        this.sdsTimeoutHandler = sDSTimeoutHandler;
    }

    public void setSDSHMIListener(SDSHMIListener sDSHMIListener) {
        this.hmiListener = sDSHMIListener;
    }

    public void setAppSDSManager(AppSDSManager appSDSManager) {
        this.appSDSManager = appSDSManager;
    }
}

