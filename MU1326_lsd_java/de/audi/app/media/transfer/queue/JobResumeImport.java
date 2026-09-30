/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.TransferLockHandler;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.queue.JobTransferring;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class JobResumeImport
extends JobTransferring
implements TimerListener {
    private static final String LOGCLASS = "TransferJobResumeImport";
    private static final long TIMER_TIMEOUT = 1000L;
    private static final int MAX_TIMER_RETRIES_IMPORT_RESUME = 5;
    private TransferLockHandler transferLockHandler;
    private final Timer importResumeTimer;
    private int timerRetries = 0;

    public JobResumeImport(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, TransferLockHandler transferLockHandler, AbstractMediaBrowser abstractMediaBrowser) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, transferLockHandler, abstractMediaBrowser, true, true);
        this.transferLockHandler = transferLockHandler;
        this.importResumeTimer = new Timer("ImportResumeTimer", 5, null, this, 1000L, true);
    }

    public int getType() {
        return 4;
    }

    public String getName() {
        return "ResumeImport";
    }

    public void importStatusChanged(int n) {
        switch (n) {
            case 8: {
                this.getTransferListener().importWillBeResumed();
                if (this.transferLockHandler.importActive(true)) {
                    this.logger.log(1000000, "[%1.importStatusChanged] Start import.", (Object)LOGCLASS);
                    this.getMediaDSIRecorder().startImport(false);
                    break;
                }
                this.logger.log(100000, "[%1.importStatusChanged] resources are locked, activate retry mechanism to resume import!", (Object)LOGCLASS);
                this.importResumeTimer.restart();
                break;
            }
            default: {
                this.importResumeTimer.cancel();
                super.importStatusChanged(n);
            }
        }
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.getTransferController().setTransferState(8);
        this.getTransferListener().importIsSuspended();
    }

    public void abort(boolean bl) {
        this.importResumeTimer.cancel();
        super.abort(bl);
    }

    public void asyncException(int n, int n2) {
        this.importResumeTimer.cancel();
        super.asyncException(n, n2);
    }

    public void fireTimer(Timer timer) {
        if (this.transferLockHandler.importActive(true)) {
            this.logger.log(1000000, "[%1.fireTimer] Import ressources are available now. Start the import.", (Object)LOGCLASS, (long)this.timerRetries, 5L);
            this.getMediaDSIRecorder().startImport(false);
            return;
        }
        if (this.timerRetries < 5 && !this.transferLockHandler.importActive(true)) {
            this.logger.log(1000000, "[%1.fireTimer] Restart %2/%3. Import ressources are still locked.", (Object)LOGCLASS, (long)this.timerRetries, 5L);
            ++this.timerRetries;
            this.importResumeTimer.restart();
            return;
        }
        this.logger.log(100000, "[%1.fireTimer] Import resume retry machanism timed out (resources are still locked) -> abort import!", (Object)LOGCLASS);
        this.getMediaDSIRecorder().abortImport();
    }

    public void cancelTimer(Timer timer) {
    }
}

