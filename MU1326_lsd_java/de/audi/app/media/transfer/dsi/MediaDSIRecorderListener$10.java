/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIRecorderListener$10
implements Runnable {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$10(MediaDSIRecorderListener mediaDSIRecorderListener, int n, int n2, String string) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$errorCode = n;
        this.val$requestType = n2;
        this.val$errorMsg = string;
    }

    @Override
    public void run() {
        Buffer buffer = new Buffer(20);
        buffer.append("errorCode='").append(this.val$errorCode).append("',requestType='").append(this.val$requestType).append("',msg='").append(this.val$errorMsg).append("'");
        MediaDSIRecorderListener.access$1600(this.this$0).log(-1601830656, "[%1.asyncException] [%2] %3", (Object)"MediaDSIRecorderListener", (Object)new Integer(MediaDSIRecorderListener.access$200(this.this$0).getInstanceID()), (Object)buffer);
        IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener();
        if (iMediaRecorderListener == null) {
            return;
        }
        iMediaRecorderListener.asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
    }

    public String toString() {
        return "DSIMediaRecorder.asyncException";
    }
}

