/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.hmi.SyncedHMITimer;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;

public class HardKeyHandler
extends AbstractMediaTerminalComponent
implements ButtonListener,
TimerListener {
    private static final int SEEKING_TIMEOUT = 500;
    private static final int SKIP_COUNTER_TIMEOUT = 350;
    private static final String LOGCLASS = "HardKeyHandler";
    private final IPlayer player;
    protected final SyncedHMITimer seekingFwdTimer;
    protected final SyncedHMITimer seekingBwdTimer;
    private final SyncedHMITimer skipCountTimer;
    private int skipCount = 0;
    private final Object skipCountMutex = new Object();
    private final boolean isBY831;

    public HardKeyHandler(IMediaTerminal iMediaTerminal, IPlayer iPlayer) {
        super(iMediaTerminal);
        this.seekingFwdTimer = new SyncedHMITimer("seekingFwdTimer", 500L, this, iMediaTerminal.getFramework());
        this.seekingBwdTimer = new SyncedHMITimer("seekingBwdTimer", 500L, this, iMediaTerminal.getFramework());
        this.skipCountTimer = new SyncedHMITimer("skipCountTimer", 350L, this, iMediaTerminal.getFramework());
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
        this.getButtonModel(200264).setButtonListener(this);
        this.getButtonModel(200263).setButtonListener(this);
        this.getButtonModel(200265).setButtonListener(this);
        this.getButtonModel(200266).setButtonListener(this);
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
        this.skipCountTimer.setDelay(350L);
        this.getButtonModel(200264).setButtonListener(null);
        this.getButtonModel(200263).setButtonListener(null);
        this.getButtonModel(200265).setButtonListener(null);
        this.getButtonModel(200266).setButtonListener(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void increaseSkipCount() {
        Object object = this.skipCountMutex;
        synchronized (object) {
            ++this.skipCount;
            this.logger.hmi().log(1000000, "[%1.increaseSkipCount] SKIP('%2')", (Object)LOGCLASS, (long)this.skipCount);
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
            this.logger.hmi().log(1000000, "[%1.decreaseSkipCount] SKIP('%2')", (Object)LOGCLASS, (long)this.skipCount);
        }
        this.skipCountTimer.restart();
    }

    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 201018: {
                if (this.isArrowKeySkipping()) {
                    this.mediaSkipNextPressed();
                    break;
                }
                this.logger.hmi().log(10000000, "[%1.keyPressed] HK_NEXT ignored", (Object)LOGCLASS);
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
                this.logger.hmi().log(10000000, "[%1.keyPressed] HK_PREV ignored", (Object)LOGCLASS);
                break;
            }
            case 200576: {
                this.mediaSkipPrevPressed();
                break;
            }
            case 200264: {
                this.logger.hmi().log(1000000, "[%1.keyPressed] PLAYER_SEEK_FW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200264).setPressed(true);
                this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.startSeek"){

                    public void run() {
                        HardKeyHandler.this.player.startSeek(true);
                    }
                });
                break;
            }
            case 200263: {
                this.logger.hmi().log(1000000, "[%1.keyPressed] PLAYER_SEEK_BW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200263).setPressed(true);
                this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.startSeek"){

                    public void run() {
                        HardKeyHandler.this.player.startSeek(false);
                    }
                });
                break;
            }
            case 200265: {
                this.logger.hmi().log(1000000, "[%1.keyPressed] PLAYER_SKIP_BW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200265).setPressed(true);
                break;
            }
            case 200266: {
                this.logger.hmi().log(1000000, "[%1.keyPressed] PLAYER_SKIP_FW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200266).setPressed(true);
                break;
            }
        }
    }

    protected void mediaSkipPrevPressed() {
        this.logger.hmi().log(1000000, "[%1.mediaSkipPrevPressed] HK_PREV", (Object)LOGCLASS);
        if (this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.seekingBwdTimer.restart();
        } else {
            this.logger.hmi().log(1000000, "[%1.mediaSkipPrevPressed] No audio focus.", (Object)LOGCLASS);
        }
    }

    protected void mediaSkipNextPressed() {
        this.logger.hmi().log(1000000, "[%1.mediaSkipNextPressed] HK_NEXT", (Object)LOGCLASS);
        if (this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.seekingFwdTimer.restart();
        } else {
            this.logger.hmi().log(1000000, "[%1.mediaSkipNextPressed] No audio focus.", (Object)LOGCLASS);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 201018: {
                if (this.isArrowKeySkipping()) {
                    this.mediaSkipNextReleased();
                    break;
                }
                this.logger.hmi().log(10000000, "[%1.keyReleased] HK_NEXT ignored", (Object)LOGCLASS);
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
                this.logger.hmi().log(10000000, "[%1.keyReleased] HK_PREV ignored", (Object)LOGCLASS);
                break;
            }
            case 200576: {
                this.mediaSkipPrevReleased();
                break;
            }
            case 200264: {
                this.logger.hmi().log(1000000, "[%1.keyReleased] PLAYER_SEEK_FW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200264).setPressed(false);
                this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.stopSeek"){

                    public void run() {
                        HardKeyHandler.this.player.stopSeek(true);
                    }
                });
                break;
            }
            case 200263: {
                this.logger.hmi().log(1000000, "[%1.keyReleased] PLAYER_SEEK_BW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200263).setPressed(false);
                this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.stopSeek"){

                    public void run() {
                        HardKeyHandler.this.player.stopSeek(true);
                    }
                });
                break;
            }
            case 200265: {
                this.logger.hmi().log(1000000, "[%1.keyReleased] PLAYER_SKIP_BW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200265).setPressed(false);
                this.decreaseSkipCount();
                break;
            }
            case 200266: {
                this.logger.hmi().log(1000000, "[%1.keyReleased] PLAYER_SKIP_FW_BUTTON", (Object)LOGCLASS);
                this.getButtonModel(200266).setPressed(false);
                this.increaseSkipCount();
                break;
            }
        }
    }

    private void mediaSkipPrevReleased() {
        this.logger.hmi().log(1000000, "[%1.mediaSkipPrevReleased] HK_PREV", (Object)LOGCLASS);
        boolean bl = this.seekingBwdTimer.cancel();
        if (bl) {
            this.decreaseSkipCount();
            return;
        }
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.stopSeek"){

            public void run() {
                HardKeyHandler.this.player.stopSeek(true);
            }
        });
    }

    private void mediaSkipNextReleased() {
        this.logger.hmi().log(1000000, "[%1.mediaSkipNextReleased] HK_NEXT", (Object)LOGCLASS);
        boolean bl = this.seekingFwdTimer.cancel();
        if (bl) {
            this.increaseSkipCount();
            return;
        }
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.stopSeek"){

            public void run() {
                HardKeyHandler.this.player.stopSeek(true);
            }
        });
    }

    private boolean isArrowKeySkipping() {
        return this.isBY831 ? false : 0 == this.getChoiceModel(4304).getValue();
    }

    public void cancelTimer(Timer timer) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        if (timer == this.seekingFwdTimer) {
            this.logger.hmi().log(10000000, "[%1.fireTimer] SEEK FW.", (Object)LOGCLASS);
            this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.fireTimer"){

                public void run() {
                    HardKeyHandler.this.player.startSeek(true);
                }
            });
            return;
        }
        if (timer == this.seekingBwdTimer) {
            this.logger.hmi().log(10000000, "[%1.fireTimer] SEEK BW.", (Object)LOGCLASS);
            this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("HardKeyHandler.fireTimer"){

                public void run() {
                    HardKeyHandler.this.player.startSeek(false);
                }
            });
            return;
        }
        Object object = this.skipCountMutex;
        synchronized (object) {
            if (timer == this.skipCountTimer) {
                this.logger.hmi().log(10000000, "[%1.fireTimer] SKIP('%2').", (Object)LOGCLASS, (long)this.skipCount);
                if (this.skipCount == 0) {
                    return;
                }
                this.getTerminal().getDispatcher().execute(new SkipJob(this.skipCount));
                this.skipCount = 0;
                return;
            }
        }
    }

    private class SkipJob
    implements Runnable {
        private final int count;

        public SkipJob(int n) {
            this.count = n;
        }

        public void run() {
            HardKeyHandler.this.player.skip(this.count > 0, Math.abs(this.count));
        }

        public String toString() {
            return new Buffer().append("HardKeyHandler.skip(").append(this.count).append(")").toString();
        }
    }
}

