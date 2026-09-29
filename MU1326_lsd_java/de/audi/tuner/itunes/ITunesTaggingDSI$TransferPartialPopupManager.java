/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.atip.timer.Timer;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.itunes.ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener;

class ITunesTaggingDSI$TransferPartialPopupManager {
    private static final long MIN_POPUP_VISIBLE_TIME_MS;
    private final ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener tlDelayedSuccess = new ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener(this, true);
    private final ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener tlDelayedFail = new ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener(this, false);
    private long lastTransferStartTime;
    private final Timer delayTimer;
    private final ITunerVariantExt varExt;

    public ITunesTaggingDSI$TransferPartialPopupManager(ITunerVariantExt iTunerVariantExt) {
        this.varExt = iTunerVariantExt;
        this.delayTimer = new Timer("TransferPartialPopupManager", 0, true, this.tlDelayedSuccess);
    }

    public void reportTransferStarted() {
        this.lastTransferStartTime = System.currentTimeMillis();
        this.varExt.showPartialPopup(9);
    }

    public void reportTransferFinished(boolean bl) {
        int n = 0 - (System.currentTimeMillis() - this.lastTransferStartTime);
        if (n <= 0L) {
            this.changeToFinishedPopup(bl);
        } else {
            ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener iTunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener = bl ? this.tlDelayedSuccess : this.tlDelayedFail;
            this.delayTimer.setTimerListener(iTunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener);
            this.delayTimer.setDelay(n);
            this.delayTimer.restart();
        }
    }

    private void changeToFinishedPopup(boolean bl) {
        this.varExt.hidePartialPopup(9);
        int n = bl ? 10 : 11;
        this.varExt.showPartialPopup(n);
    }

    static /* synthetic */ void access$200(ITunesTaggingDSI$TransferPartialPopupManager iTunesTaggingDSI$TransferPartialPopupManager, boolean bl) {
        iTunesTaggingDSI$TransferPartialPopupManager.changeToFinishedPopup(bl);
    }
}

