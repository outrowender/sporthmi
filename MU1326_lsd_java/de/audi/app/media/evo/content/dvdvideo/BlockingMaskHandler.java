/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.dvdvideo.AbstractBlockingMaskHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class BlockingMaskHandler
extends AbstractBlockingMaskHandler
implements TimerListener {
    private static final String LOGCLASS = "BlockingMaskHandler";
    private static final int HMI_ICON_HIDDEN = 0;
    private static final int HMI_ICON_VISIBLE = 1;
    private static final int SEEK_TO_TIME_BLOCKED = 1;
    private static final int SEEK_TO_TIME_NOT_BLOCKED = 0;
    private final Timer blockedIconHideTimer = new Timer("dvdVideoBlockedIconHideTimer", 2000L, true, this);

    public BlockingMaskHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    protected void updateFunctionModels() {
        if (super.isBlocked(512, "BLOCK_BACKWARD_SCAN") || super.isBlocked(256, "BLOCK_FORWARD_SCAN")) {
            this.logger.hmi().log(10000000, "[%1.updateFunctionModels] Seek to time blocked.", (Object)LOGCLASS);
            this.getChoiceModel(200826).setValue(1);
        } else {
            this.getChoiceModel(200826).setValue(0);
        }
        this.updateModelStatus(2048, "Wizard: Menu Button", 200672);
        this.updateModelStatus(128, "Wizard: Next Button", 200673);
        this.updateModelStatus(64, "Wizard: Previous Button", 200675);
        this.updateModelStatus(256, "Wizard: FFW Button", 200671);
        this.updateModelStatus(512, "Wizard: FBW Button", 200670);
        this.updateModelStatus(524288, "Wizard: Pause Button", 200674);
        this.updateChoiceModelValue(0x1000000, "Setup: Video format", 200695);
        this.updateChoiceModelValue(0x100000, "Setup: Audio stream", 200693);
        this.updateChoiceModelValue(0x200000, "Setup: Subtitle", 200694);
    }

    protected boolean isBlocked(int n, String string) {
        if (!super.isBlocked(n, string)) {
            return false;
        }
        this.logger.hmi().log(10000000, "[%1.isBlocked] '%2' blocked.", (Object)LOGCLASS, (Object)string);
        switch (n) {
            case 64: 
            case 128: 
            case 256: 
            case 512: 
            case 2048: 
            case 524288: {
                this.showBlockedIcon();
                break;
            }
        }
        return true;
    }

    protected void resetSeekToTimeBlocking() {
        this.getChoiceModel(200826).setValue(0);
    }

    public void showBlockedIcon() {
        this.logger.hmi().log(10000000, "[%1.showBlockedIcon] For '%2' ms.", (Object)LOGCLASS, this.blockedIconHideTimer.getDelay());
        this.getChoiceModel(200699).setValue(1);
        this.blockedIconHideTimer.restart();
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
        this.logger.hmi().log(10000000, "[%1.fireTimer] Hide blocked icon.", (Object)LOGCLASS);
        this.getChoiceModel(200699).setValue(0);
    }
}

