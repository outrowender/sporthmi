/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.itunes.ITunesTaggingDSI$TransferPartialPopupManager;

class ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener
extends DefaultTimerListener {
    private final boolean successful;
    private final /* synthetic */ ITunesTaggingDSI$TransferPartialPopupManager this$0;

    public ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener(ITunesTaggingDSI$TransferPartialPopupManager iTunesTaggingDSI$TransferPartialPopupManager, boolean bl) {
        this.this$0 = iTunesTaggingDSI$TransferPartialPopupManager;
        this.successful = bl;
    }

    @Override
    public void fireTimer(Timer timer) {
        ITunesTaggingDSI$TransferPartialPopupManager.access$200(this.this$0, this.successful);
    }
}

