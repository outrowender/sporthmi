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
    private static final String LOGCLASS;
    private static final int HMI_ICON_HIDDEN;
    private static final int HMI_ICON_VISIBLE;
    private static final int SEEK_TO_TIME_BLOCKED;
    private static final int SEEK_TO_TIME_NOT_BLOCKED;
    private final Timer blockedIconHideTimer = new Timer("dvdVideoBlockedIconHideTimer", 0, true, this);

    public BlockingMaskHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    @Override
    protected void updateFunctionModels() {
        if (super.isBlocked(512, "BLOCK_BACKWARD_SCAN") || super.isBlocked(256, "BLOCK_FORWARD_SCAN")) {
            this.logger.hmi().log(-2137614336, "[%1.updateFunctionModels] Seek to time blocked.", (Object)"BlockingMaskHandler");
            this.getChoiceModel(2047869696).setValue(1);
        } else {
            this.getChoiceModel(2047869696).setValue(0);
        }
        this.updateModelStatus(2048, "Wizard: Menu Button", -535887104);
        this.updateModelStatus(128, "Wizard: Next Button", -519109888);
        this.updateModelStatus(64, "Wizard: Previous Button", -485555456);
        this.updateModelStatus(256, "Wizard: FFW Button", -552664320);
        this.updateModelStatus(512, "Wizard: FBW Button", -569441536);
        this.updateModelStatus(2048, "Wizard: Pause Button", -502332672);
        this.updateChoiceModelValue(1, "Setup: Video format", -150011136);
        this.updateChoiceModelValue(4096, "Setup: Audio stream", -183565568);
        this.updateChoiceModelValue(8192, "Setup: Subtitle", -166788352);
    }

    @Override
    protected boolean isBlocked(int n, String string) {
        if (!super.isBlocked(n, string)) {
            return false;
        }
        this.logger.hmi().log(-2137614336, "[%1.isBlocked] '%2' blocked.", (Object)"BlockingMaskHandler", (Object)string);
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
        this.getChoiceModel(2047869696).setValue(0);
    }

    public void showBlockedIcon() {
        this.logger.hmi().log(-2137614336, "[%1.showBlockedIcon] For '%2' ms.", (Object)"BlockingMaskHandler", this.blockedIconHideTimer.getDelay());
        this.getChoiceModel(-82902272).setValue(1);
        this.blockedIconHideTimer.restart();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.hmi().log(-2137614336, "[%1.fireTimer] Hide blocked icon.", (Object)"BlockingMaskHandler");
        this.getChoiceModel(-82902272).setValue(0);
    }
}

