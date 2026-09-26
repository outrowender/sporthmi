/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.combi.bap.commands.GetCombiViewSizeCommand;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DownloadInfo;

public class CombiADBStateHandler {
    private CombiADBHandler adbHandler;
    private LogChannel log;
    private boolean adbReady = false;
    private boolean downloadActive = false;
    private int entryCount = 0;
    private DownloadInfo downloadCountMe;
    private DownloadInfo downloadCountSim;
    private int lastPbState = -1;
    private int lastEntryCount = -1;

    public CombiADBStateHandler(CombiADBHandler combiADBHandler) {
        this.adbHandler = combiADBHandler;
        this.log = combiADBHandler.getLog();
    }

    public void setAdbReady(boolean bl) {
        this.adbReady = bl;
        this.updateCombiPbState();
    }

    public boolean isAdbReady() {
        return this.adbReady;
    }

    public void setDownloadActive(boolean bl) {
        if (this.downloadActive != bl) {
            this.downloadActive = bl;
            GetCombiViewSizeCommand.createGetCombiViewSizeCommand(this.adbHandler, false, false);
        }
    }

    public void setEntryCount(int n) {
        this.entryCount = n;
        this.updateCombiPbState();
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public void updateCombiPbState() {
        int n = this.computePbState();
        if (n != this.lastPbState || this.entryCount != this.lastEntryCount) {
            this.log.log(1078071040, "CombiADBStateHandler#updateCombiPbState(): pbState: %1, entryCount: %2", (Object)ADBDbgUtils.dbgCombiPbState(n), (long)this.entryCount);
            this.adbHandler.getCombiService().updatePbState(n, this.entryCount);
            this.lastPbState = n;
            this.lastEntryCount = this.entryCount;
        }
    }

    public int computePbState() {
        if (!this.adbReady) {
            return 0;
        }
        if (this.downloadActive && this.entryCount == 0) {
            return 1;
        }
        return 2;
    }

    public void updateDownloadCountMe(DownloadInfo downloadInfo) {
        this.log.log(1078071040, "CombiADBStateHandler#updateDownloadCountMe(): downloadCountMe: %1", (Object)downloadInfo);
        this.downloadCountMe = downloadInfo;
        this.updateCombiDownloadProgress();
    }

    public void updateDownloadCountSim(DownloadInfo downloadInfo) {
        this.log.log(1078071040, "CombiADBStateHandler#updateDownloadCountSim(): downloadCountSim: %1", (Object)downloadInfo);
        this.downloadCountSim = downloadInfo;
        this.updateCombiDownloadProgress();
    }

    public void resetDownloadProgress() {
        this.log.log(1078071040, "CombiADBStateHandler#resetDownloadProgress()");
        if (this.downloadCountMe != null) {
            this.downloadCountMe.count = 0;
            this.downloadCountMe.numberOfItems = -1;
        }
        if (this.downloadCountSim != null) {
            this.downloadCountSim.count = 0;
            this.downloadCountSim.numberOfItems = -1;
        }
        this.updateCombiDownloadProgress();
    }

    public void updateCombiDownloadProgress() {
        int n = this.downloadCountMe == null ? 0 : this.downloadCountMe.count;
        int n2 = this.downloadCountSim == null ? 0 : this.downloadCountSim.count;
        int n3 = -1;
        if (this.downloadCountMe != null && this.downloadCountMe.numberOfItems != -1 || this.downloadCountSim != null && this.downloadCountSim.numberOfItems != -1) {
            n3 = this.downloadCountMe != null && this.downloadCountMe.numberOfItems != -1 ? this.downloadCountMe.numberOfItems : 0;
            n3 += this.downloadCountSim != null && this.downloadCountSim.numberOfItems != -1 ? this.downloadCountSim.numberOfItems : 0;
        }
        this.adbHandler.getCombiService().updatePhonebookDownloadProgress(this.computePbState(), -1, n3, n + n2);
    }
}

