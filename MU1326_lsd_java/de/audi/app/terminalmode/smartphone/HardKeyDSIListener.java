/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.HardKeyDSIListener$1;
import de.audi.app.terminalmode.smartphone.HardKeyDSIListener$2;
import de.audi.app.terminalmode.smartphone.HardKeyDSIListener$3;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.DispatcherTimer;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.ITimer;

public class HardKeyDSIListener
extends DefaultButtonListener {
    private static final int SEEKING_TIMEOUT;
    private static final int SKIP_COUNTER_TIMEOUT;
    private static final String LOGCLASS;
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
        this.seekingFwdTimer = new DispatcherTimer(iDispatcher, "seekingFwdTimer", 500, true, new HardKeyDSIListener$1(this));
        this.seekingBwdTimer = new DispatcherTimer(iDispatcher, "seekingBwdTimer", 500, true, new HardKeyDSIListener$2(this));
        this.skipCountTimer = new DispatcherTimer(iDispatcher, "skipCountTimer", 350, true, new HardKeyDSIListener$3(this));
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
        this.logger.log(1078071040, "[%1.increaeSkipCount] SKIP('%2')", (Object)"HardKeyDSIListener", (long)this.skipCount);
        this.skipCountTimer.restart();
    }

    private void decreaeSkipCount() {
        --this.skipCount;
        this.logger.log(1078071040, "[%1.decreaeSkipCount] SKIP('%2')", (Object)"HardKeyDSIListener", (long)this.skipCount);
        this.skipCountTimer.restart();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 3200031: 
            case 3200052: {
                this.logger.log(1078071040, "[%1.keyPressed] HK_NEXT", (Object)"HardKeyDSIListener");
                if (this.context.getAudioManager().hasAudioFocus()) {
                    this.seekingFwdTimer.restart();
                    break;
                }
                this.logger.log(1078071040, "[%1.keyPressed] No audio focus.", (Object)"HardKeyDSIListener");
                break;
            }
            case 3200039: 
            case 3200051: {
                this.logger.log(1078071040, "[%1.keyPressed] HK_PREV", (Object)"HardKeyDSIListener");
                if (this.context.getAudioManager().hasAudioFocus()) {
                    this.seekingBwdTimer.restart();
                    break;
                }
                this.logger.log(1078071040, "[%1.keyPressed] No audio focus.", (Object)"HardKeyDSIListener");
                break;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 3200031: 
            case 3200052: {
                this.logger.log(1078071040, "[%1.keyReleased] HK_NEXT", (Object)"HardKeyDSIListener");
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
                this.logger.log(1078071040, "[%1.keyReleased] HK_PREV", (Object)"HardKeyDSIListener");
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

    static /* synthetic */ LogChannel access$000(HardKeyDSIListener hardKeyDSIListener) {
        return hardKeyDSIListener.logger;
    }

    static /* synthetic */ IPlayerModificationListener access$100(HardKeyDSIListener hardKeyDSIListener) {
        return hardKeyDSIListener.playerModificationListener;
    }

    static /* synthetic */ int access$200(HardKeyDSIListener hardKeyDSIListener) {
        return hardKeyDSIListener.skipCount;
    }

    static /* synthetic */ int access$202(HardKeyDSIListener hardKeyDSIListener, int n) {
        hardKeyDSIListener.skipCount = n;
        return hardKeyDSIListener.skipCount;
    }
}

