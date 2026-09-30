/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.DispatcherTimer;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.ITimer;
import de.audi.atip.utils.dispatching.ITimerListener;

public class HardKeyDSIListener
extends DefaultButtonListener {
    private static final int SEEKING_TIMEOUT = 500;
    private static final int SKIP_COUNTER_TIMEOUT = 350;
    private static final String LOGCLASS = "HardKeyDSIListener";
    private final ITimer seekingFwdTimer;
    private final ITimer seekingBwdTimer;
    private final ITimer skipCountTimer;
    private final IContext context;
    private final IPlayerModificationListener playerModificationListener;
    private final LogChannel logger;
    private volatile int skipCount = 0;

    public HardKeyDSIListener(IContext iContext, IDispatcher iDispatcher) {
        this.context = iContext;
        this.logger = iContext.getLogger().main();
        this.playerModificationListener = iContext.getSmartphoneDSIManager().getPlayerModificationListener();
        this.seekingFwdTimer = new DispatcherTimer(iDispatcher, "seekingFwdTimer", 500, true, new ITimerListener.Stub(){

            public void fireTimer() {
                HardKeyDSIListener.this.logger.log(10000000, "[%1.fireTimer] SEEK FW.", (Object)HardKeyDSIListener.LOGCLASS);
                HardKeyDSIListener.this.playerModificationListener.seek(true, true);
            }
        });
        this.seekingBwdTimer = new DispatcherTimer(iDispatcher, "seekingBwdTimer", 500, true, new ITimerListener.Stub(){

            public void fireTimer() {
                HardKeyDSIListener.this.logger.log(10000000, "[%1.fireTimer] SEEK BW.", (Object)HardKeyDSIListener.LOGCLASS);
                HardKeyDSIListener.this.playerModificationListener.seek(false, true);
            }
        });
        this.skipCountTimer = new DispatcherTimer(iDispatcher, "skipCountTimer", 350, true, new ITimerListener.Stub(){

            public void fireTimer() {
                HardKeyDSIListener.this.logger.log(10000000, "[%1.fireTimer] SKIP('%2').", (Object)HardKeyDSIListener.LOGCLASS, (long)HardKeyDSIListener.this.skipCount);
                if (HardKeyDSIListener.this.skipCount == 0) {
                    return;
                }
                HardKeyDSIListener.this.playerModificationListener.skip(HardKeyDSIListener.this.skipCount > 0, Math.abs(HardKeyDSIListener.this.skipCount));
                HardKeyDSIListener.this.skipCount = 0;
            }
        });
    }

    public void activate() {
        this.skipCount = 0;
    }

    public void deactivate() {
        this.seekingFwdTimer.cancel();
        this.seekingBwdTimer.cancel();
        this.skipCountTimer.cancel();
    }

    private void increaeSkipCount() {
        ++this.skipCount;
        this.logger.log(1000000, "[%1.increaeSkipCount] SKIP('%2')", (Object)LOGCLASS, (long)this.skipCount);
        this.skipCountTimer.restart();
    }

    private void decreaeSkipCount() {
        --this.skipCount;
        this.logger.log(1000000, "[%1.decreaeSkipCount] SKIP('%2')", (Object)LOGCLASS, (long)this.skipCount);
        this.skipCountTimer.restart();
    }

    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 3200031: 
            case 3200052: {
                this.logger.log(1000000, "[%1.keyPressed] HK_NEXT", (Object)LOGCLASS);
                if (this.context.getAudioManager().hasAudioFocus()) {
                    this.seekingFwdTimer.restart();
                    break;
                }
                this.logger.log(1000000, "[%1.keyPressed] No audio focus.", (Object)LOGCLASS);
                break;
            }
            case 3200039: 
            case 3200051: {
                this.logger.log(1000000, "[%1.keyPressed] HK_PREV", (Object)LOGCLASS);
                if (this.context.getAudioManager().hasAudioFocus()) {
                    this.seekingBwdTimer.restart();
                    break;
                }
                this.logger.log(1000000, "[%1.keyPressed] No audio focus.", (Object)LOGCLASS);
                break;
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 3200031: 
            case 3200052: {
                this.logger.log(1000000, "[%1.keyReleased] HK_NEXT", (Object)LOGCLASS);
                boolean bl = this.seekingFwdTimer.cancel();
                if (bl) {
                    this.increaeSkipCount();
                    break;
                }
                if (!this.context.getAudioManager().hasAudioFocus()) break;
                this.playerModificationListener.seek(true, false);
                break;
            }
            case 3200039: 
            case 3200051: {
                this.logger.log(1000000, "[%1.keyReleased] HK_PREV", (Object)LOGCLASS);
                boolean bl = this.seekingBwdTimer.cancel();
                if (bl) {
                    this.decreaeSkipCount();
                    break;
                }
                if (!this.context.getAudioManager().hasAudioFocus()) break;
                this.playerModificationListener.seek(true, false);
                break;
            }
        }
    }
}

