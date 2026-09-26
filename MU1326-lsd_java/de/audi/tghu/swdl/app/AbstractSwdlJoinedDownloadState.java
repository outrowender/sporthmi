/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;

public abstract class AbstractSwdlJoinedDownloadState {
    private boolean joinedDownload;
    private final SwdlEnv swdlEnv;

    public AbstractSwdlJoinedDownloadState(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
        this.joinedDownload = false;
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private final SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    protected final IHMIServiceApp getHMIService() {
        return this.getSwdlEnv().getHMIService();
    }

    private final LogChannel getLogHMI() {
        return this.getSwdlEnv().getLogHMI();
    }

    public boolean isJoinedDownload() {
        return this.joinedDownload;
    }

    public void setJoinedDownload(boolean bl) {
        this.getLogHMI().log(1078071040, "[AbstractSwdlJoinedDownloadState] setJoinedDownload(%1)", (Object)bl);
        this.joinedDownload = bl;
    }

    public synchronized void startJoinedDownload() {
        this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] startJoinedDownload()");
        if (this.getSwdlEnv().isFrontMU()) {
            this.getLogHMI().log(1078071040, "[AbstractSwdlJoinedDownloadState] startJoinedDownload() ignore: this is a front MU");
        } else if (this.getSwdlEnv().isSwdlHMIActive()) {
            this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] startJoinedDownload() ignore: download already active!");
        } else if (this.getSwdlEnv().isRebootToDownload()) {
            this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] startJoinedDownload() ignore: rebooted into download!");
        } else if (!this.isJoinedDownload()) {
            this.setJoinedDownload(true);
            this.getSwdlModels().getRSESwdlJoinedChoice().setValue(1);
            this.getSwdlModels().getSwdlDownloadStartedChoice().setValue(1);
            this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] startJoinedDownload() set fall through flag");
            this.getSwdlModels().getRSESwdlJoinedChoice().setValue(1);
            this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] startJoinedDownload() post events");
            this.fireSMEventEnter(3);
            this.fireSMEventEnter(4);
        }
    }

    public synchronized void leaveJoinedDownload(AbstractPopupManager abstractPopupManager) {
        this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] leaveJoinedDownload()");
        if (this.getSwdlEnv().isFrontMU()) {
            this.getLogHMI().log(1078071040, "[AbstractSwdlJoinedDownloadState] leaveJoinedDownload() ignore: this is a front MU");
        } else if (this.getSwdlEnv().isRebootToDownload()) {
            this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] leaveJoinedDownload() ignore: rebooted into download!");
        } else if (this.isJoinedDownload()) {
            this.getLogHMI().log(-2137614336, "[AbstractSwdlJoinedDownloadState] leaveJoinedDownload() post events");
            this.fireSMEventExit(3);
            this.fireSMEventExit(4);
            abstractPopupManager.removeAllPopups();
            this.setJoinedDownload(false);
        }
    }

    protected abstract void fireSMEventEnter(int n) {
    }

    protected abstract void fireSMEventExit(int n) {
    }
}

