/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.itunes.TaggingData;
import de.audi.tuner.itunes.TaggingManager;
import de.audi.tuner.util.NullDSIRadioTagging;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIRadioTagging;
import org.dsi.ifc.media.DSIRadioTaggingListener;
import org.dsi.ifc.media.TagInformation;

public class ITunesTaggingDSI
implements DSIRadioTaggingListener {
    private final Logger logger;
    private final LogChannel lc;
    private DSIRadioTagging dsi;
    private boolean dsiFound;
    private final TaggingManager taggingMgr;
    private boolean showPopupsDuringTransfer = false;
    private final TransferPartialPopupManager popupManager;
    private int deviceStatus = 2;
    private int lastTagResult;
    private boolean transmisionRunning;
    private TaggingData[] dataArray = new TaggingData[0];
    private int arrPosToSend;
    private final LabelModelApp tagsToTransferLabel;
    private final LabelModelApp tagsTransferedLabel;
    private final ChoiceModelApp transferStatusChoice;

    public ITunesTaggingDSI(TunerBasics tunerBasics, TaggingManager taggingManager, ITunerVariantExt iTunerVariantExt) {
        this.logger = tunerBasics.getLogger();
        this.lc = tunerBasics.getLogger().tagging;
        this.taggingMgr = taggingManager;
        this.popupManager = new TransferPartialPopupManager(iTunerVariantExt);
        this.dsi = new NullDSIRadioTagging(this.lc);
        TunerModels tunerModels = tunerBasics.getModels();
        tunerModels.getButtonModel(100669).setButtonListener(new ButtonListener());
        this.tagsToTransferLabel = tunerModels.getLabelModel(100889);
        this.tagsTransferedLabel = tunerModels.getLabelModel(100870);
        this.transferStatusChoice = tunerModels.getChoiceModel(100881);
    }

    public void setDeviceService(DSIBase dSIBase) {
        this.logger.hmi.log(10000000, "[ITunesTagging.setDeviceService]");
        this.dsi = (DSIRadioTagging)dSIBase;
        this.dsiFound = !(dSIBase instanceof NullDSIRadioTagging);
    }

    public int getDeviceStatus() {
        return this.deviceStatus;
    }

    public int getLastTagResult() {
        return this.lastTagResult;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[ITunesTagging.asyncException] Error: %2, Msg: %1, reqType %3", (Object)string, (long)n, (long)n2);
    }

    public void tagResult(int n) {
        try {
            this.lc.log(1000000, "[ITunesTagging.tagResult] %1", (long)n);
            this.lastTagResult = n;
            if (n == 0) {
                ++this.arrPosToSend;
                if (this.arrPosToSend < this.dataArray.length) {
                    this.sendToIPod();
                }
            } else {
                this.lc.log(1000000, "[ITunesTagging.tagResult] abort sending data");
                this.tagsToTransferLabel.setText(String.valueOf(this.dataArray.length));
                this.tagsTransferedLabel.setText("0");
                this.transferStatusChoice.setValue(n);
                this.reset();
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception: ", (Throwable)exception);
        }
    }

    public void updateCompatibleDevAvail(int n, int n2) {
        try {
            if (n2 != 1) {
                this.lc.log(1000000, "[ITunesTagging.updateCompatibleDevAvail] Received invalid deviceStatus");
                return;
            }
            if (n == this.deviceStatus) {
                return;
            }
            this.deviceStatus = n;
            switch (n) {
                case 1: {
                    this.lc.log(1000000, "[ITunesTagging.updateCompatibleDevAvail]: deviceStatus DEVICESTATUS_AVAILABLE");
                    this.showPopupsDuringTransfer = this.taggingMgr.containsTaggedItems();
                    this.reset();
                    this.tryToSendData();
                    break;
                }
                case 3: {
                    this.lc.log(1000000, "[ITunesTagging.updateCompatibleDevAvail]: deviceStatus DEVICESTATUS_ERROR");
                    this.reset();
                    break;
                }
                case 0: {
                    this.lc.log(1000000, "[ITunesTagging.updateCompatibleDevAvail]: deviceStatus DEVICESTATUS_NODEVICE");
                    this.reset();
                    break;
                }
                case 2: {
                    this.lc.log(1000000, "[ITunesTagging.updateCompatibleDevAvail]: deviceStatus DEVICESTATUS_NOT_SUPPORTED");
                    this.reset();
                    break;
                }
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception: ", (Throwable)exception);
        }
    }

    private void reset() {
        if (this.transmisionRunning && this.showPopupsDuringTransfer) {
            this.popupManager.reportTransferFinished(false);
        }
        this.dataArray = new TaggingData[0];
        this.arrPosToSend = 0;
        this.transmisionRunning = false;
    }

    public boolean isDsiFound() {
        return this.dsiFound;
    }

    public void init() {
        this.setNotification(new int[]{1});
    }

    public void setNotification(int[] nArray) {
        this.lc.log(10000000, "[ITunesTaggingDSI.setNotification] notifications: %1", (Object)nArray);
        this.dsi.setNotification(nArray, (DSIListener)this);
    }

    synchronized void tryToSendData() {
        this.lc.log(1000000, "[ITunesTagging.tryToSendData]");
        if (this.transmisionRunning || this.deviceStatus != 1) {
            return;
        }
        this.dataArray = this.taggingMgr.getData();
        if (this.dataArray.length > 0) {
            this.transmisionRunning = true;
            this.arrPosToSend = 0;
            if (this.showPopupsDuringTransfer) {
                this.popupManager.reportTransferStarted();
            }
            this.lc.log(1000000, "[ITunesTagging.tryToSendData: group %1]", (long)this.dataArray.length);
            this.dsi.groupTags(this.dataArray.length);
            this.sendToIPod();
        }
    }

    private void sendToIPod() {
        TaggingData taggingData = this.dataArray[this.arrPosToSend];
        this.lc.log(1000000, "[ITunesTagging.sendToIPod] index %1", (long)this.arrPosToSend);
        this.lc.log(1000000, "[ITunesTagging.sendToIPod] %1", (Object)taggingData);
        if (this.deviceStatus == 1) {
            if (taggingData.isAmbigous()) {
                this.lc.log(1000000, "[ITunesTagging.sendToIPod] dsi.tagAmbiguousSong");
                this.dsi.tagAmbiguousSong(this.convertForDsi(taggingData.getTag1()), this.convertForDsi(taggingData.getTag2()));
            } else {
                this.lc.log(1000000, "[ITunesTagging.sendToIPod] dsi.tagSong");
                this.dsi.tagSong(this.convertForDsi(taggingData.getTag1()));
            }
        } else {
            this.lc.log(10000, "[ITunesTagging.sendToIPod] can't dend, dievicestatus %1", (long)this.deviceStatus);
        }
    }

    private TagInformation convertForDsi(TagInformation tagInformation) {
        return new TagInformation(tagInformation.ambiguousTag, tagInformation.buttonPressed, Utilities.isEmpty(tagInformation.title) ? null : tagInformation.title, Utilities.isEmpty(tagInformation.artist) ? null : tagInformation.artist, Utilities.isEmpty(tagInformation.songID) ? null : tagInformation.songID, Utilities.isEmpty(tagInformation.stationFrequency) ? null : tagInformation.stationFrequency, Utilities.isEmpty(tagInformation.stationCallLetters) ? null : tagInformation.stationCallLetters, Utilities.isEmpty(tagInformation.stationURL) ? null : tagInformation.stationURL, tagInformation.timeStamp.time == 0L ? null : tagInformation.timeStamp, Utilities.isEmpty(tagInformation.affiliateID) ? null : tagInformation.affiliateID, Utilities.isEmpty(tagInformation.album) ? null : tagInformation.album, tagInformation.iTunesFrontID, tagInformation.podcastFeedURL, Utilities.isEmpty(tagInformation.genre) ? null : tagInformation.genre, Utilities.isEmpty(tagInformation.unknownData) ? null : tagInformation.unknownData, tagInformation.programNumber);
    }

    public void groupTagsResult(int n, int n2) {
        boolean bl;
        this.lc.log(1000000, "[ITunesTagging.groupTagsResult] res %1, # %2 ", (long)n2, (long)n);
        boolean bl2 = bl = n2 == 0 && n == this.dataArray.length;
        if (bl) {
            this.lc.log(1000000, "[ITunesTagging.groupTagsResult] group transmitted!");
            this.taggingMgr.removeData(this.dataArray);
        } else {
            this.lc.log(1000000, "[ITunesTagging.groupTagsResult] error in group transmitting!");
        }
        this.dataArray = new TaggingData[0];
        this.transmisionRunning = false;
        this.arrPosToSend = 0;
        this.tagsToTransferLabel.setText(String.valueOf(this.dataArray.length));
        this.tagsTransferedLabel.setText(String.valueOf(n));
        this.transferStatusChoice.setValue(n2);
        if (this.showPopupsDuringTransfer) {
            this.popupManager.reportTransferFinished(bl);
        }
        this.showPopupsDuringTransfer = false;
    }

    private void onButtonItunesTaggingTransferNowTyped() {
        this.lc.log(1000000, "[ITunesTagging.onButtonItunesTaggingTransferNowTyped]: Retrying to send tagging data");
        this.reset();
        this.tryToSendData();
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            ITunesTaggingDSI.this.onButtonItunesTaggingTransferNowTyped();
        }
    }

    private static class TransferPartialPopupManager {
        private static final long MIN_POPUP_VISIBLE_TIME_MS = 3000L;
        private final DelayedChangeToFinishedPopupTimerListener tlDelayedSuccess = new DelayedChangeToFinishedPopupTimerListener(true);
        private final DelayedChangeToFinishedPopupTimerListener tlDelayedFail = new DelayedChangeToFinishedPopupTimerListener(false);
        private long lastTransferStartTime;
        private final Timer delayTimer;
        private final ITunerVariantExt varExt;

        public TransferPartialPopupManager(ITunerVariantExt iTunerVariantExt) {
            this.varExt = iTunerVariantExt;
            this.delayTimer = new Timer("TransferPartialPopupManager", 1000L, true, this.tlDelayedSuccess);
        }

        public void reportTransferStarted() {
            this.lastTransferStartTime = System.currentTimeMillis();
            this.varExt.showPartialPopup(9);
        }

        public void reportTransferFinished(boolean bl) {
            long l = 3000L - (System.currentTimeMillis() - this.lastTransferStartTime);
            if (l <= 0L) {
                this.changeToFinishedPopup(bl);
            } else {
                DelayedChangeToFinishedPopupTimerListener delayedChangeToFinishedPopupTimerListener = bl ? this.tlDelayedSuccess : this.tlDelayedFail;
                this.delayTimer.setTimerListener(delayedChangeToFinishedPopupTimerListener);
                this.delayTimer.setDelay(l);
                this.delayTimer.restart();
            }
        }

        private void changeToFinishedPopup(boolean bl) {
            this.varExt.hidePartialPopup(9);
            int n = bl ? 10 : 11;
            this.varExt.showPartialPopup(n);
        }

        private class DelayedChangeToFinishedPopupTimerListener
        extends DefaultTimerListener {
            private final boolean successful;

            public DelayedChangeToFinishedPopupTimerListener(boolean bl) {
                this.successful = bl;
            }

            public void fireTimer(Timer timer) {
                TransferPartialPopupManager.this.changeToFinishedPopup(this.successful);
            }
        }
    }
}

