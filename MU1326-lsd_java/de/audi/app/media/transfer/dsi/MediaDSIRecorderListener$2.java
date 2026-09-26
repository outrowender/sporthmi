/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;

class MediaDSIRecorderListener$2
implements Runnable {
    private final /* synthetic */ long val$deviceID;
    private final /* synthetic */ long val$mediaID;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$2(MediaDSIRecorderListener mediaDSIRecorderListener, long l, long l2) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$deviceID = l;
        this.val$mediaID = l2;
    }

    @Override
    public void run() {
        MediaDSIRecorderListener.access$300(this.this$0).log(1078071040, "[%1.updateActiveMedia] [%2] deviceID='%3', mediaID='%4'.", (Object)"MediaDSIRecorderListener", (Object)new Integer(MediaDSIRecorderListener.access$200(this.this$0).getInstanceID()), (Object)new Long(this.val$deviceID), (Object)new Long(this.val$mediaID));
        MediaSourceSlot mediaSourceSlot = MediaDSIRecorderListener.access$200(this.this$0).getSourceSlotToActivate();
        if (mediaSourceSlot == null) {
            MediaDSIRecorderListener.access$400(this.this$0).log(1078071040, "[%1.updateActiveMedia] [%2] No request was send. Update have to be call just before a resume after startup. Trying to get the SourceSlot.", (Object)"MediaDSIRecorderListener", (long)MediaDSIRecorderListener.access$200(this.this$0).getInstanceID());
            mediaSourceSlot = MediaDSIRecorderListener.access$500(this.this$0).getSourceSlot(this.val$deviceID, this.val$mediaID);
            if (mediaSourceSlot == null) {
                MediaDSIRecorderListener.access$600(this.this$0).log(-1601830656, "[%1.updateActiveMedia] [%2] Unexpected update. SlotToActive is null.", (Object)"MediaDSIRecorderListener", (long)MediaDSIRecorderListener.access$200(this.this$0).getInstanceID());
                return;
            }
        }
        if (mediaSourceSlot.getDeviceID() != this.val$deviceID || mediaSourceSlot.getMediaID() != this.val$mediaID) {
            MediaDSIRecorderListener.access$700(this.this$0).log(1078071040, "[%1.updateActiveMedia] [%2] Slot not triggered for activation.", (Object)"MediaDSIRecorderListener", (long)MediaDSIRecorderListener.access$200(this.this$0).getInstanceID());
            return;
        }
        IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener();
        if (iMediaRecorderListener == null) {
            return;
        }
        iMediaRecorderListener.sourceSlotActivated(mediaSourceSlot);
    }

    public String toString() {
        return "DSIMediaRecorder.updateActiveMedia";
    }
}

