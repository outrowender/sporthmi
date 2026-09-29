/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaParentalManagementListener;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayer;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.atip.hmi.model.ButtonListener;

public class PMBlockingHandler
implements ButtonListener,
IMediaParentalManagementListener {
    private static final String LOGCLASS;
    private final DVDVideoPlayer player;
    private final IMediaLogger logger;
    private static final int DSI_PM_LEVEL_NONE;
    private static final int BLOCKINGSTATE_NONE;
    private static final int BLOCKINGSTATE_TEMP;
    private static final int BLOCKINGSTATE_MEDIUM;
    private volatile int currentBlockingState = 0;
    private volatile int currentTempPmLevel = 0;
    private IMediaDSIBaseController dsiBaseController;

    public PMBlockingHandler(DVDVideoPlayer dVDVideoPlayer, IMediaLogger iMediaLogger, IMediaDSIBaseController iMediaDSIBaseController) {
        this.player = dVDVideoPlayer;
        this.logger = iMediaLogger;
        this.dsiBaseController = iMediaDSIBaseController;
        this.player.getButtonModel(-636550400).setButtonListener(this);
    }

    public void activate() {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"PMBlockingHandler");
        this.player.getChoiceModel(-586218752).setStatus(1);
        this.currentBlockingState = 0;
        this.dsiBaseController.addParentalManagementListener(this);
    }

    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"PMBlockingHandler");
        this.dsiBaseController.removeParentalManagementListener(this);
    }

    protected void removeTempScreen() {
        this.logger.hmi().log(1078071040, "[%1.removeTempScreen] called. Current BlockingState is '%2'.", (Object)"PMBlockingHandler", (long)this.currentBlockingState);
        if (this.currentBlockingState == 1) {
            this.showTempPMLScreen(false);
            this.setCurrentBlockingState(0);
        }
    }

    protected int getCurrentTempPmLevel() {
        return this.currentTempPmLevel;
    }

    private void setCurrentTempPmLevel(int n) {
        this.currentTempPmLevel = n;
    }

    public int getCurrentBlockingState() {
        return this.currentBlockingState;
    }

    private void setCurrentBlockingState(int n) {
        this.logger.hmi().log(1078071040, "[%1.setCurrentBlockingState] set to '%2'.", (Object)"PMBlockingHandler", (long)n);
        this.currentBlockingState = n;
    }

    private void showTempPMLScreen(boolean bl) {
        this.logger.hmi().log(1078071040, "[%1.showTempPMLScreen] '%2'", (Object)"PMBlockingHandler", (Object)bl);
        if (bl) {
            this.player.getChoiceModel(-586218752).setStatus(0);
        } else {
            this.player.getChoiceModel(-586218752).setStatus(1);
        }
    }

    protected void setBlockedByTempPM(int n) {
        this.logger.hmi().log(1078071040, "[%1.setBlockedByTempPM] '%2'", (Object)"PMBlockingHandler", (Object)new Integer(n));
        this.setCurrentTempPmLevel(n);
        switch (n) {
            case 0: {
                if (this.currentBlockingState == 0) break;
                this.showTempPMLScreen(false);
                this.setCurrentBlockingState(0);
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                this.player.getLabelModel(-602995968).setText(Integer.toString(n));
                this.showTempPMLScreen(true);
                this.setCurrentBlockingState(1);
                break;
            }
            default: {
                this.logger.dsi().log(-1601830656, "[%1.setBlockedByTempPM] unsupported pmLevel '%2'.", (Object)"PMBlockingHandler", (Object)new Integer(n));
            }
        }
    }

    public void setBlockedByMediumPM(boolean bl) {
        this.logger.hmi().log(1078071040, "[%1.setBlockedByMediumPM] '%2'", (Object)"PMBlockingHandler", (Object)bl);
        if (bl) {
            if (this.getCurrentBlockingState() == 1) {
                this.showTempPMLScreen(false);
            }
            this.setCurrentBlockingState(2);
        } else {
            if (this.getCurrentBlockingState() == 2) {
                this.player.resume();
            }
            this.setCurrentBlockingState(0);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logger.hmi().log(1078071040, "[%1.keyPressed] modelID='%2'", (Object)"PMBlockingHandler", (long)n);
        this.player.denyTempPMLRequest();
        if (this.getCurrentBlockingState() == 1) {
            this.showTempPMLScreen(false);
            this.setCurrentBlockingState(0);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void updateParentalML(int n) {
        if (n < 0 || n > 8) {
            this.logger.dsi().log(-1601830656, "[%1.updateParentalML] unsupported pmLevel '%2', ignoring.", (Object)"PMBlockingHandler", (long)n);
        }
        int n2 = this.getCurrentTempPmLevel();
        if (n == 0 || n >= n2) {
            this.logger.hmi().log(1078071040, "[%1.updateParentalML] current temp level is '%2', new level is '%3'. Warning can be removed in background.", (Object)"PMBlockingHandler", (long)n2, (long)n);
            this.removeTempScreen();
        } else {
            this.logger.hmi().log(1078071040, "[%1.updateParentalML] the selected level '%3' is not enough to show the DVD. Level '%2' is required. Nothing more to do.", (Object)"PMBlockingHandler", (long)n2, (long)n);
        }
    }
}

