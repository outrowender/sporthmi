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
    private static final String LOGCLASS;
    private static final long TIMER_TIMEOUT;
    private static final int MAX_TIMER_RETRIES_IMPORT_RESUME;
    private TransferLockHandler transferLockHandler;
    private final Timer importResumeTimer;
    private int timerRetries = 0;

    public JobResumeImport(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, TransferLockHandler transferLockHandler, AbstractMediaBrowser abstractMediaBrowser) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, transferLockHandler, abstractMediaBrowser, true, true);
        this.transferLockHandler = transferLockHandler;
        this.importResumeTimer = new Timer("ImportResumeTimer", 5, null, this, 0, true);
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public String getName() {
        return "ResumeImport";
    }

    @Override
    public void importStatusChanged(int n) {
        switch (n) {
            case 8: {
                this.getTransferListener().importWillBeResumed();
                if (this.transferLockHandler.importActive(true)) {
                    this.logger.log(1078071040, "[%1.importStatusChanged] Start import.", (Object)"TransferJobResumeImport");
                    this.getMediaDSIRecorder().startImport(false);
                    break;
                }
                this.logger.log(-1601830656, "[%1.importStatusChanged] resources are locked, activate retry mechanism to resume import!", (Object)"TransferJobResumeImport");
                this.importResumeTimer.restart();
                break;
            }
            default: {
                this.importResumeTimer.cancel();
                super.importStatusChanged(n);
            }
        }
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"TransferJobResumeImport");
        this.getTransferController().setTransferState(8);
        this.getTransferListener().importIsSuspended();
    }

    @Override
    public void abort(boolean bl) {
        this.importResumeTimer.cancel();
        super.abort(bl);
    }

    @Override
    public void asyncException(int n, int n2) {
        this.importResumeTimer.cancel();
        super.asyncException(n, n2);
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.transferLockHandler.importActive(true)) {
            this.logger.log(1078071040, "[%1.fireTimer] Import ressources are available now. Start the import.", (Object)"TransferJobResumeImport", (long)this.timerRetries, (long)0);
            this.getMediaDSIRecorder().startImport(false);
            return;
        }
        if (this.timerRetries < 5 && !this.transferLockHandler.importActive(true)) {
            this.logger.log(1078071040, "[%1.fireTimer] Restart %2/%3. Import ressources are still locked.", (Object)"TransferJobResumeImport", (long)this.timerRetries, (long)0);
            ++this.timerRetries;
            this.importResumeTimer.restart();
            return;
        }
        this.logger.log(-1601830656, "[%1.fireTimer] Import resume retry machanism timed out (resources are still locked) -> abort import!", (Object)"TransferJobResumeImport");
        this.getMediaDSIRecorder().abortImport();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

