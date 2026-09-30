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
    private static final String LOGCLASS = "TransferJobChangeEncodingQuality";
    private static final int RIPPING_ENCODING_QUALITY_LOSSLESS = 0;
    private static final int RIPPING_ENCODING_QUALITY_GOOD = 1;
    private Integer encodingQuality;
    private final IMediaTerminal mediaTerminal;

    public TransferJobChangeEncodingQuality(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, Integer n, IMediaTerminal iMediaTerminal, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
        this.encodingQuality = n;
        this.mediaTerminal = iMediaTerminal;
    }

    public int getType() {
        return 1;
    }

    public String getName() {
        return "ChangeEncodingQuality";
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        if (null == this.encodingQuality) {
            this.mediaTerminal.getFramework().getHmiServiceApp().getButtonModel(200462).setButtonListener(this);
            this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200314).setChoiceListener(this);
            this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200315).setChoiceListener(this);
            this.transferState.setWaitingForUserAction(true);
            this.evoTransferController.showTransferPopup(false, 200001);
        } else {
            this.transferController.setEncodingQuality(this.encodingQuality);
        }
    }

    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.encodingQualityChanged]", (Object)LOGCLASS);
        if (bl) {
            this.logger.log(10000, "[%1.encodingQualityChanged] Error for set encoding quality", (Object)LOGCLASS);
        }
        this.getExecutionContext().jobFinished();
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)LOGCLASS);
        if (bl) {
            this.mediaTerminal.getFramework().getHmiServiceApp().removePopup(200001);
        }
    }

    public boolean isWaiting() {
        return this.encodingQuality == null;
    }

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

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200462: {
                this.logger.log(1000000, "[%1.keyTyped] Start cdda ripping", (Object)LOGCLASS);
                this.mediaTerminal.getFramework().getHmiServiceApp().getButtonModel(200462).fireEvent(n3);
                this.mediaTerminal.getFramework().getHmiServiceApp().getButtonModel(200462).setButtonListener(null);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200314).setChoiceListener(null);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200315).setChoiceListener(null);
                if (this.encodingQuality == null) {
                    this.encodingQuality = new Integer(this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200313).getValue());
                    this.transferState.setWaitingForUserAction(false);
                }
                this.evoTransferController.setEncodingQuality(this.encodingQuality);
                this.transferController.setEncodingQuality(this.encodingQuality);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.keyTyped] buttton model %2 unknown", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 200314: {
                this.logger.log(1000000, "[%1.itemSelected] ripping quality (good) %2.", (Object)LOGCLASS, (Object)(n2 == 1 ? "SELECTED" : "DESELECTED (no effect)"));
                if (n2 != 1 || this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200314).getValue() != 0) break;
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200314).setValue(1);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200315).setValue(0);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200313).setValue(1);
                this.mediaTerminal.getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY", 1);
                this.encodingQuality = new Integer(1);
                break;
            }
            case 200315: {
                this.logger.log(1000000, "[%1.itemSelected] ripping quality (lossless) selected %2.", (Object)LOGCLASS, (Object)(n2 == 1 ? "SELECTED" : "DESELECTED (no effect)"));
                if (n2 != 1 || this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200315).getValue() != 0) break;
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200314).setValue(0);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200315).setValue(1);
                this.mediaTerminal.getFramework().getHmiServiceApp().getChoiceModel(200313).setValue(0);
                this.mediaTerminal.getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY", 0);
                this.encodingQuality = new Integer(0);
                break;
            }
            default: {
                this.logger.log(100000, "[%1.itemSelected] unsupported model (MODELID#%2).", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void browseModeChanged(boolean bl, int n) {
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void readyForTransfer() {
    }

    public void activationFailed(ISourceSlot iSourceSlot) {
    }

    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    public void startFailed() {
    }

    public void importWillBeResumed() {
    }

    public void importIsSuspended() {
    }

    public void importAborted(long l, long l2, long l3, boolean bl) {
    }

    public void importFinished(long l, long l2, long l3, boolean bl) {
    }

    public void deletionFinished() {
    }

    public void deletionAborted() {
    }
}

