/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class JobSetEncodingQuality
extends AbstractJobTransfer {
    private static final String LOGCLASS;
    private final int encodingQuality;

    public JobSetEncodingQuality(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, AbstractMediaBrowser abstractMediaBrowser, int n) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, abstractMediaBrowser);
        this.encodingQuality = n;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return "SetEncodingQuality";
    }

    @Override
    public void start() {
        int n = 0;
        switch (this.encodingQuality) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
        }
        this.getMediaDSIRecorder().setEncodingQuality(n);
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"TransferJobSetEncodingQuality");
        if (bl) {
            this.getTransferController().removeTransferState(4);
            this.getMediaDSIRecorder().abortImport();
        }
    }

    @Override
    public void asyncException(int n, int n2) {
        this.logger.log(-1601830656, "[%1.asyncException] requestType='%2' errorCode='%3'", (Object)"TransferJobSetEncodingQuality", (long)n, (long)n2);
        this.getTransferListener().encodingQualityChanged(true, -1);
    }

    @Override
    public void encodingQualityChanged(int n) {
        this.logger.log(1078071040, "[%1.encodingQualityChanged]", (Object)"TransferJobSetEncodingQuality");
        this.getTransferListener().encodingQualityChanged(false, n);
        this.getTransferController().setTransferState(4);
        this.jobFinished();
    }

    @Override
    public void importStatusChanged(int n) {
        this.logger.log(1078071040, "[%1.importStatusChanged]", (Object)"TransferJobSetEncodingQuality");
        if (0 == n) {
            this.getTransferController().setTransferState(1);
            this.getTransferListener().readyForTransfer();
            this.jobFinished();
        }
    }

    @Override
    public void deletionStatusChanged(int n) {
        this.logger.log(1078071040, "[%1.deletionStatusChanged]", (Object)"TransferJobSetEncodingQuality");
        if (0 == n) {
            this.getTransferController().setTransferState(1);
            this.getTransferListener().readyForTransfer();
            this.jobFinished();
        }
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", encodingQuality=");
        buffer.append(this.encodingQuality == 1 ? "high" : "max");
        buffer.append("]");
        return buffer.toString();
    }
}

