/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.atip.timer.Timer;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractProgressManager$1;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;

public abstract class AbstractProgressManager
extends AbstractManager
implements IProgressManager {
    private static final String CLASSNAME;
    private SwdlDSIHandlerProgress progressDSIHandler;

    protected AbstractProgressManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super(swdlEnv, abstractPopupManager);
        this.progressDSIHandler = swdlDSIHandlerProgress;
    }

    protected final SwdlDSIHandlerProgress getProgressDSIHandler() {
        return this.progressDSIHandler;
    }

    protected void startRebootCountdown() {
        new Timer("RebootCountdownTimer", 0, false, new AbstractProgressManager$1(this)).start();
    }

    @Override
    public String getSelectedDevice() {
        return "";
    }

    @Override
    public void updateActiveDevices(String[] stringArray) {
    }

    @Override
    public void updateOverviewStatus(int n) {
    }

    @Override
    public void init() {
    }

    @Override
    public void abortProgress(int n) {
    }

    @Override
    public void abortProgressError(int n) {
    }

    @Override
    public void abortProgressInterrupt(int n) {
    }

    @Override
    public void continueProgressInterrupt() {
    }

    @Override
    public void showPopupMainSKSetupUpdateSummaryInterruptRestart() {
    }

    @Override
    public void custDownloadLeaveProgress(int n) {
    }

    public void showCustDownloadInfoPopup(int n) {
    }

    @Override
    public void swdlSummaryExit() {
    }

    @Override
    public void triggerLatestPanel() {
        int n = this.getProgressDSIHandler().getLatestPanel();
        this.getLogHMI().log(1078071040, "%1 triggerLatestPanel(): %2", (Object)"[AbstractProgressManager]", (long)n);
        if (n > 0) {
            this.triggerPanel(n);
        }
    }

    @Override
    public void versionUploadDone(boolean bl) {
    }
}

