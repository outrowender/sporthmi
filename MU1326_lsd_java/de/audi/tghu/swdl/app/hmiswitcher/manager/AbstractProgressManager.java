/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;

public abstract class AbstractProgressManager
extends AbstractManager
implements IProgressManager {
    private static final String CLASSNAME = "[AbstractProgressManager]";
    private SwdlDSIHandlerProgress progressDSIHandler;

    protected AbstractProgressManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super(swdlEnv, abstractPopupManager);
        this.progressDSIHandler = swdlDSIHandlerProgress;
    }

    protected final SwdlDSIHandlerProgress getProgressDSIHandler() {
        return this.progressDSIHandler;
    }

    protected void startRebootCountdown() {
        new Timer("RebootCountdownTimer", 1000L, false, new TimerListener(){
            String text = "";

            public void cancelTimer(Timer timer) {
                AbstractProgressManager.this.getSwdlModels().getRebootCountdown().setText("");
            }

            public void fireTimer(Timer timer) {
                this.text = new StringBuffer().append(this.text).append(".").toString();
                AbstractProgressManager.this.getSwdlModels().getRebootCountdown().setText(this.text);
            }
        }).start();
    }

    public String getSelectedDevice() {
        return "";
    }

    public void updateActiveDevices(String[] stringArray) {
    }

    public void updateOverviewStatus(int n) {
    }

    public void init() {
    }

    public void abortProgress(int n) {
    }

    public void abortProgressError(int n) {
    }

    public void abortProgressInterrupt(int n) {
    }

    public void continueProgressInterrupt() {
    }

    public void showPopupMainSKSetupUpdateSummaryInterruptRestart() {
    }

    public void custDownloadLeaveProgress(int n) {
    }

    public void showCustDownloadInfoPopup(int n) {
    }

    public void swdlSummaryExit() {
    }

    public void triggerLatestPanel() {
        int n = this.getProgressDSIHandler().getLatestPanel();
        this.getLogHMI().log(1000000, "%1 triggerLatestPanel(): %2", (Object)CLASSNAME, (long)n);
        if (n > 0) {
            this.triggerPanel(n);
        }
    }

    public void versionUploadDone(boolean bl) {
    }
}

