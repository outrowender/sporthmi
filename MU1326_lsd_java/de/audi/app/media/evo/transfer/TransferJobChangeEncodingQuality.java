/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.AbstractTransferJobEvo;
import de.audi.app.media.evo.transfer.EvoTransferController;
import de.audi.app.media.evo.transfer.EvoTransferState;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferController;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class TransferJobChangeEncodingQuality
extends AbstractTransferJobEvo
implements ChoiceListener {
    private static final String LOGCLASS;
    private static final int RIPPING_ENCODING_QUALITY_LOSSLESS;
    private static final int RIPPING_ENCODING_QUALITY_GOOD;
    private Integer encodingQuality;
    private final IMediaTerminal mediaTerminal;

    public TransferJobChangeEncodingQuality(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, Integer n, IMediaTerminal iMediaTerminal, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
        this.encodingQuality = n;
        this.mediaTerminal = iMediaTerminal;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return "ChangeEncodingQuality";
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"TransferJobChangeEncodingQuality");
        if (null == this.encodingQuality) {
            this.mediaTerminal.getFramework().getHmiServiceApp().getButtonModel(235864832).setButtonListener(this);
            this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2047738624).setChoiceListener(this);
            this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2064515840).setChoiceListener(this);
            this.transferState.setWaitingForUserAction(true);
            this.evoTransferController.showTransferPopup(false, 1091371776);
        } else {
            this.transferController.setEncodingQuality(this.encodingQuality);
        }
    }

    @Override
    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.encodingQualityChanged]", (Object)"TransferJobChangeEncodingQuality");
        if (bl) {
            this.logger.log(10000, "[%1.encodingQualityChanged] Error for set encoding quality", (Object)"TransferJobChangeEncodingQuality");
        }
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"TransferJobChangeEncodingQuality");
        if (bl) {
            this.mediaTerminal.getFramework().getHmiServiceApp().removePopup(1091371776);
        }
    }

    @Override
    public boolean isWaiting() {
        return this.encodingQuality == null;
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", encoding=");
        buffer.append(this.encodingQuality);
        buffer.append(", hashcode=");
        buffer.append(Integer.toHexString(this.hashCode()));
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200462: {
                this.logger.log(1078071040, "[%1.keyTyped] Start cdda ripping", (Object)"TransferJobChangeEncodingQuality");
                this.mediaTerminal.getFramework().getHmiServiceApp().getButtonModel(235864832).fireEvent(n3);
                this.mediaTerminal.getFramework().getHmiServiceApp().getButtonModel(235864832).setButtonListener(null);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2047738624).setChoiceListener(null);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2064515840).setChoiceListener(null);
                if (this.encodingQuality == null) {
                    this.encodingQuality = new Integer(this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2030961408).getValue());
                    this.transferState.setWaitingForUserAction(false);
                }
                this.evoTransferController.setEncodingQuality(this.encodingQuality);
                this.transferController.setEncodingQuality(this.encodingQuality);
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.keyTyped] buttton model %2 unknown", (Object)"TransferJobChangeEncodingQuality", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 200314: {
                this.logger.log(1078071040, "[%1.itemSelected] ripping quality (good) %2.", (Object)"TransferJobChangeEncodingQuality", (Object)(n2 == 1 ? "SELECTED" : "DESELECTED (no effect)"));
                if (n2 != 1 || this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2047738624).getValue() != 0) break;
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2047738624).setValue(1);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2064515840).setValue(0);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2030961408).setValue(1);
                this.mediaTerminal.getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY", 1);
                this.encodingQuality = new Integer(1);
                break;
            }
            case 200315: {
                this.logger.log(1078071040, "[%1.itemSelected] ripping quality (lossless) selected %2.", (Object)"TransferJobChangeEncodingQuality", (Object)(n2 == 1 ? "SELECTED" : "DESELECTED (no effect)"));
                if (n2 != 1 || this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2064515840).getValue() != 0) break;
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2047738624).setValue(0);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2064515840).setValue(1);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(2030961408).setValue(0);
                this.mediaTerminal.getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY", 0);
                this.encodingQuality = new Integer(0);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.itemSelected] unsupported model (MODELID#%2).", (Object)"TransferJobChangeEncodingQuality", (long)n);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public void readyForTransfer() {
    }

    @Override
    public void activationFailed(ISourceSlot iSourceSlot) {
    }

    @Override
    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    @Override
    public void startFailed() {
    }

    @Override
    public void importWillBeResumed() {
    }

    @Override
    public void importIsSuspended() {
    }

    @Override
    public void importAborted(long l, long l2, long l3, boolean bl) {
    }

    @Override
    public void importFinished(long l, long l2, long l3, boolean bl) {
    }

    @Override
    public void deletionFinished() {
    }

    @Override
    public void deletionAborted() {
    }
}

