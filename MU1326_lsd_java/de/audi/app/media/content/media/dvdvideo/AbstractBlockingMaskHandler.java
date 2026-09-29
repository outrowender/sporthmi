/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.dvdvideo;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public abstract class AbstractBlockingMaskHandler
extends AbstractMediaTerminalComponent {
    private static final String LOGCLASS;
    protected static final int CMD_MENU;
    protected static final int CMD_NEXT;
    protected static final int CMD_PREV;
    protected static final int CMD_FFW;
    protected static final int CMD_FBW;
    protected static final int CMD_PAUSE;
    protected static final int CMD_CHAPTER;
    protected static final int CMD_SETUP_VIDEO;
    protected static final int CMD_SETUP_AUDIO;
    protected static final int CMD_SETUP_SUBTITLE;
    protected static final int MODEL_STATUS_DISABLED;
    protected static final int MODEL_STATUS_ENABLED;
    protected static final int CHOICE_VALUE_ENABLED;
    protected static final int CHOICE_VALUE_DISABLED;
    private volatile int currentBlockingMask;

    public AbstractBlockingMaskHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void setBlockingMask(int n) {
        if (this.logger.main().getCurrentLogThreshold() == -2137614336) {
            this.logger.main().log(-2137614336, "[%1.setBlockingMask] mask='%2'", (Object)"AbstractBlockingMaskHandler", (Object)Integer.toBinaryString(n));
        }
        this.currentBlockingMask = n;
        this.updateFunctionModels();
    }

    public boolean isMenuBlocked() {
        return this.isBlocked(2048, "BLOCK_MENU_CALL_ROOT");
    }

    public boolean isPauseBlocked() {
        return this.isBlocked(2048, "BLOCK_PAUSE_ON");
    }

    public boolean isNextBlocked() {
        return this.isBlocked(128, "BLOCK_NEXT_PG_SEARCH");
    }

    public boolean isPreviousBlocked() {
        return this.isBlocked(64, "BLOCK_PREV_TOP_PG_SEARCH");
    }

    public boolean isFFWBlocked() {
        return this.isBlocked(256, "BLOCK_FORWARD_SCAN");
    }

    public boolean isFBWBlocked() {
        return this.isBlocked(512, "BLOCK_BACKWARD_SCAN");
    }

    public boolean isSelectChapterBlocked() {
        return this.isBlocked(2, "BLOCK_PTT_PLAY_SEARCH");
    }

    public boolean isChangeVideoFormatBlocked() {
        return this.isBlocked(1, "BLOCK_VIDEO_CHANGE");
    }

    public boolean isChangeAudioStreamBlocked() {
        return this.isBlocked(4096, "BLOCK_AUDIO_CHANGE");
    }

    public boolean isSelectSubtitleBlocked() {
        return this.isBlocked(8192, "BLOCK_SUB_PICTURE_CHANGE");
    }

    protected abstract void updateFunctionModels() {
    }

    protected void updateModelStatus(int n, String string, int n2) {
        HMIModelApp hMIModelApp;
        boolean bl = n == (this.currentBlockingMask & n);
        int n3 = bl ? 0 : 1;
        if (n3 != (hMIModelApp = this.getModel(n2)).getStatus()) {
            this.logger.hmi().log(-2137614336, "[%2.updateModelStatus] '%3'='%1'", (Object)(bl ? "blocked" : "unblocked"), (Object)"AbstractBlockingMaskHandler", (Object)string);
            hMIModelApp.setStatus(n3);
        }
    }

    protected void updateChoiceModelValue(int n, String string, int n2) {
        boolean bl = n == (this.currentBlockingMask & n);
        int n3 = bl ? 1 : 0;
        ChoiceModelApp choiceModelApp = this.getChoiceModel(n2);
        if (choiceModelApp.getValue() != n3) {
            this.getChoiceModel(n2).setValue(n3);
            this.logger.hmi().log(-2137614336, "[%2.updateChoiceModelValue] '%3'='%1'", (Object)(bl ? "blocked" : "unblocked"), (Object)"AbstractBlockingMaskHandler", (Object)string);
        }
    }

    protected boolean isBlocked(int n, String string) {
        boolean bl;
        boolean bl2 = bl = n == (this.currentBlockingMask & n);
        if (bl && this.logger.hmi().isDebug()) {
            this.logger.hmi().log(-2137614336, "[%1.isBlocked] Command '%2' is blocked", (Object)"AbstractBlockingMaskHandler", (Object)string);
        }
        return bl;
    }
}

