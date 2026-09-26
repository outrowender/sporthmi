/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.HardKeyHandler$1;
import de.audi.app.media.content.media.HardKeyHandler$2;
import de.audi.app.media.content.media.HardKeyHandler$3;
import de.audi.app.media.content.media.HardKeyHandler$4;
import de.audi.app.media.content.media.HardKeyHandler$5;
import de.audi.app.media.content.media.HardKeyHandler$6;
import de.audi.app.media.content.media.HardKeyHandler$7;
import de.audi.app.media.content.media.HardKeyHandler$8;
import de.audi.app.media.content.media.HardKeyHandler$SkipJob;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.hmi.SyncedHMITimer;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class HardKeyHandler
extends AbstractMediaTerminalComponent
implements ButtonListener,
TimerListener {
    private static final int SEEKING_TIMEOUT;
    private static final int SKIP_COUNTER_TIMEOUT;
    private static final String LOGCLASS;
    private final IPlayer player;
    protected final SyncedHMITimer seekingFwdTimer;
    protected final SyncedHMITimer seekingBwdTimer;
    private final SyncedHMITimer skipCountTimer;
    private int skipCount = 0;
    private final Object skipCountMutex = new Object();
    private final boolean isBY831;

    public HardKeyHandler(IMediaTerminal iMediaTerminal, IPlayer iPlayer) {
        super(iMediaTerminal);
        this.seekingFwdTimer = new SyncedHMITimer("seekingFwdTimer", (long)0, this, iMediaTerminal.getFramework());
        this.seekingBwdTimer = new SyncedHMITimer("seekingBwdTimer", (long)0, this, iMediaTerminal.getFramework());
        this.skipCountTimer = new SyncedHMITimer("skipCountTimer", (long)0, this, iMediaTerminal.getFramework());
        this.player = iPlayer;
        Coding coding = this.getTerminal().getFramework().getSysConstManager().getCarCoding();
        byte by = coding.getCarClass();
        byte by2 = coding.getCarGeneration();
        byte by3 = coding.getCarDerivate();
        byte by4 = coding.getCarBrand();
        this.isBY831 = by4 == 5 && by == 8 && by2 == 3 && by3 == 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate() {
        Object object = this.skipCountMutex;
        synchronized (object) {
            this.skipCount = 0;
        }
        this.getButtonModel(1208877824).setButtonListener(this);
        this.getButtonModel(1192100608).setButtonListener(this);
        this.getButtonModel(1225655040).setButtonListener(this);
        this.getButtonModel(1242432256).setButtonListener(this);
    }

    public void activate(IActivationContext iActivationContext) {
        if (iActivationContext.getSlot().getSource().getType() == 0 || iActivationContext.getSlot().getSource().getType() == 2) {
            this.skipCountTimer.setDelay(this.getTerminal().getFramework().getSysConst(4284));
        }
    }

    public void deactivate() {
        this.seekingFwdTimer.cancel();
        this.seekingBwdTimer.cancel();
        this.skipCountTimer.cancel();
        this.skipCountTimer.setDelay(0);
        this.getButtonModel(1208877824).setButtonListener(null);
        this.getButtonModel(1192100608).setButtonListener(null);
        this.getButtonModel(1225655040).setButtonListener(null);
        this.getButtonModel(1242432256).setButtonListener(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void increaseSkipCount() {
        Object object = this.skipCountMutex;
        synchronized (object) {
            ++this.skipCount;
            this.logger.hmi().log(1078071040, "[%1.increaseSkipCount] SKIP('%2')", (Object)"HardKeyHandler", (long)this.skipCount);
        }
        this.skipCountTimer.restart();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void decreaseSkipCount() {
        Object object = this.skipCountMutex;
        synchronized (object) {
            --this.skipCount;
            this.logger.hmi().log(1078071040, "[%1.decreaseSkipCount] SKIP('%2')", (Object)"HardKeyHandler", (long)this.skipCount);
        }
        this.skipCountTimer.restart();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 201018: {
                if (this.isArrowKeySkipping()) {
                    this.mediaSkipNextPressed();
                    break;
                }
                this.logger.hmi().log(-2137614336, "[%1.keyPressed] HK_NEXT ignored", (Object)"HardKeyHandler");
                break;
            }
            case 200575: {
                this.mediaSkipNextPressed();
                break;
            }
            case 201019: {
                if (this.isArrowKeySkipping()) {
                    this.mediaSkipPrevPressed();
                    break;
                }
                this.logger.hmi().log(-2137614336, "[%1.keyPressed] HK_PREV ignored", (Object)"HardKeyHandler");
                break;
            }
            case 200576: {
                this.mediaSkipPrevPressed();
                break;
            }
            case 200264: {
                this.logger.hmi().log(1078071040, "[%1.keyPressed] PLAYER_SEEK_FW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1208877824).setPressed(true);
                this.getTerminal().getDispatcher().execute(new HardKeyHandler$1(this, "HardKeyHandler.startSeek"));
                break;
            }
            case 200263: {
                this.logger.hmi().log(1078071040, "[%1.keyPressed] PLAYER_SEEK_BW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1192100608).setPressed(true);
                this.getTerminal().getDispatcher().execute(new HardKeyHandler$2(this, "HardKeyHandler.startSeek"));
                break;
            }
            case 200265: {
                this.logger.hmi().log(1078071040, "[%1.keyPressed] PLAYER_SKIP_BW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1225655040).setPressed(true);
                break;
            }
            case 200266: {
                this.logger.hmi().log(1078071040, "[%1.keyPressed] PLAYER_SKIP_FW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1242432256).setPressed(true);
                break;
            }
        }
    }

    protected void mediaSkipPrevPressed() {
        this.logger.hmi().log(1078071040, "[%1.mediaSkipPrevPressed] HK_PREV", (Object)"HardKeyHandler");
        if (this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.seekingBwdTimer.restart();
        } else {
            this.logger.hmi().log(1078071040, "[%1.mediaSkipPrevPressed] No audio focus.", (Object)"HardKeyHandler");
        }
    }

    protected void mediaSkipNextPressed() {
        this.logger.hmi().log(1078071040, "[%1.mediaSkipNextPressed] HK_NEXT", (Object)"HardKeyHandler");
        if (this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.seekingFwdTimer.restart();
        } else {
            this.logger.hmi().log(1078071040, "[%1.mediaSkipNextPressed] No audio focus.", (Object)"HardKeyHandler");
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 201018: {
                if (this.isArrowKeySkipping()) {
                    this.mediaSkipNextReleased();
                    break;
                }
                this.logger.hmi().log(-2137614336, "[%1.keyReleased] HK_NEXT ignored", (Object)"HardKeyHandler");
                break;
            }
            case 200575: {
                this.mediaSkipNextReleased();
                break;
            }
            case 201019: {
                if (this.isArrowKeySkipping()) {
                    this.mediaSkipPrevReleased();
                    break;
                }
                this.logger.hmi().log(-2137614336, "[%1.keyReleased] HK_PREV ignored", (Object)"HardKeyHandler");
                break;
            }
            case 200576: {
                this.mediaSkipPrevReleased();
                break;
            }
            case 200264: {
                this.logger.hmi().log(1078071040, "[%1.keyReleased] PLAYER_SEEK_FW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1208877824).setPressed(false);
                this.getTerminal().getDispatcher().execute(new HardKeyHandler$3(this, "HardKeyHandler.stopSeek"));
                break;
            }
            case 200263: {
                this.logger.hmi().log(1078071040, "[%1.keyReleased] PLAYER_SEEK_BW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1192100608).setPressed(false);
                this.getTerminal().getDispatcher().execute(new HardKeyHandler$4(this, "HardKeyHandler.stopSeek"));
                break;
            }
            case 200265: {
                this.logger.hmi().log(1078071040, "[%1.keyReleased] PLAYER_SKIP_BW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1225655040).setPressed(false);
                this.decreaseSkipCount();
                break;
            }
            case 200266: {
                this.logger.hmi().log(1078071040, "[%1.keyReleased] PLAYER_SKIP_FW_BUTTON", (Object)"HardKeyHandler");
                this.getButtonModel(1242432256).setPressed(false);
                this.increaseSkipCount();
                break;
            }
        }
    }

    private void mediaSkipPrevReleased() {
        this.logger.hmi().log(1078071040, "[%1.mediaSkipPrevReleased] HK_PREV", (Object)"HardKeyHandler");
        boolean bl = this.seekingBwdTimer.cancel();
        if (bl) {
            this.decreaseSkipCount();
            return;
        }
        this.getTerminal().getDispatcher().execute(new HardKeyHandler$5(this, "HardKeyHandler.stopSeek"));
    }

    private void mediaSkipNextReleased() {
        this.logger.hmi().log(1078071040, "[%1.mediaSkipNextReleased] HK_NEXT", (Object)"HardKeyHandler");
        boolean bl = this.seekingFwdTimer.cancel();
        if (bl) {
            this.increaseSkipCount();
            return;
        }
        this.getTerminal().getDispatcher().execute(new HardKeyHandler$6(this, "HardKeyHandler.stopSeek"));
    }

    private boolean isArrowKeySkipping() {
        return this.isBY831 ? false : 0 == this.getChoiceModel(4304).getValue();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer == this.seekingFwdTimer) {
            this.logger.hmi().log(-2137614336, "[%1.fireTimer] SEEK FW.", (Object)"HardKeyHandler");
            this.getTerminal().getDispatcher().execute(new HardKeyHandler$7(this, "HardKeyHandler.fireTimer"));
            return;
        }
        if (timer == this.seekingBwdTimer) {
            this.logger.hmi().log(-2137614336, "[%1.fireTimer] SEEK BW.", (Object)"HardKeyHandler");
            this.getTerminal().getDispatcher().execute(new HardKeyHandler$8(this, "HardKeyHandler.fireTimer"));
            return;
        }
        Object object = this.skipCountMutex;
        synchronized (object) {
            if (timer == this.skipCountTimer) {
                this.logger.hmi().log(-2137614336, "[%1.fireTimer] SKIP('%2').", (Object)"HardKeyHandler", (long)this.skipCount);
                if (this.skipCount == 0) {
                    return;
                }
                this.getTerminal().getDispatcher().execute(new HardKeyHandler$SkipJob(this, this.skipCount));
                this.skipCount = 0;
                return;
            }
        }
    }

    static /* synthetic */ IPlayer access$000(HardKeyHandler hardKeyHandler) {
        return hardKeyHandler.player;
    }
}

