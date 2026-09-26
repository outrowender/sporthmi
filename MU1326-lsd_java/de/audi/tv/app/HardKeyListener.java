/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.HardKeyListener$1;
import de.audi.tv.app.HardKeyListener$ActivationListener;
import de.audi.tv.app.HardKeyListener$TVListener;
import de.audi.tv.app.IHardKeyHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.TuningMonitor;
import de.audi.tv.app.lists.AbstractStationList;
import de.audi.tv.app.lists.FocusHandler;

public class HardKeyListener
extends DefaultButtonListener {
    private IHardKeyHandler defaultHKHandler = new HardKeyListener$1(this);
    private final FocusHandler focusHandler;
    private final TuningMonitor tuningMonitor;
    public final HardKeyListener$ActivationListener activationListener;
    private volatile boolean tvAppActive = false;
    private volatile boolean hardKeysActive = true;
    private volatile boolean isInAVMode = false;
    public final HardKeyListener$TVListener listener = new HardKeyListener$TVListener(this, null);
    private IHardKeyHandler hkHandler = this.defaultHKHandler;
    private final LogChannel log;

    public HardKeyListener(TVEnv tVEnv, LogChannel logChannel, FocusHandler focusHandler, TuningMonitor tuningMonitor) {
        this.log = logChannel;
        this.focusHandler = focusHandler;
        this.tuningMonitor = tuningMonitor;
        this.activationListener = new HardKeyListener$ActivationListener(this, null);
        tVEnv.getButtonModel(1940662016).setButtonListener(this);
        tVEnv.getButtonModel(1957439232).setButtonListener(this);
        tVEnv.getButtonModel(-441702656).setButtonListener(this);
        tVEnv.getButtonModel(-458479872).setButtonListener(this);
    }

    public void registerHardKeyHandler(IHardKeyHandler iHardKeyHandler) {
        this.hkHandler = iHardKeyHandler == null ? this.defaultHKHandler : iHardKeyHandler;
    }

    public void simulateHkNext(int n) {
        this.keyTyped(1940662016, 0, n);
    }

    public void simualteHkPrev(int n) {
        this.keyTyped(1957439232, 0, n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (!this.tvAppActive) {
            this.log.log(-1601830656, "[HardKeyListener.keyTyped] ignored (TV not active)");
            return;
        }
        if (!this.hardKeysActive) {
            this.log.log(-1601830656, "[HardKeyListener.keyTyped] ignored (skip behaviour unavailable)");
            return;
        }
        if (this.isInAVMode) {
            this.log.log(-1601830656, "[HardKeyListener.keyTyped] ignored (AV is active)");
            return;
        }
        if (this.tuningMonitor.getLastTunedService() != null) {
            this.log.log(-1601830656, "[HardKeyListener.keyTyped] tuning is in progress");
        }
        switch (n) {
            case 2600051: 
            case 2600165: {
                AbstractStationList abstractStationList;
                if (this.hkHandler.nextKeyPressed() || (abstractStationList = this.focusHandler.getFocusedList()) == null) break;
                abstractStationList.setNextService();
                break;
            }
            case 2600052: 
            case 2600164: {
                AbstractStationList abstractStationList;
                if (this.hkHandler.prevKeyPressed() || (abstractStationList = this.focusHandler.getFocusedList()) == null) break;
                abstractStationList.setPrevService();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unknown model ").append(n).toString());
            }
        }
        this.log.log(-2137614336, "[HardKeyListener.keyTyped] model:%1 HT:%2", (long)n, (long)n3);
    }

    static /* synthetic */ boolean access$202(HardKeyListener hardKeyListener, boolean bl) {
        hardKeyListener.tvAppActive = bl;
        return hardKeyListener.tvAppActive;
    }

    static /* synthetic */ LogChannel access$300(HardKeyListener hardKeyListener) {
        return hardKeyListener.log;
    }

    static /* synthetic */ boolean access$402(HardKeyListener hardKeyListener, boolean bl) {
        hardKeyListener.hardKeysActive = bl;
        return hardKeyListener.hardKeysActive;
    }

    static /* synthetic */ boolean access$400(HardKeyListener hardKeyListener) {
        return hardKeyListener.hardKeysActive;
    }

    static /* synthetic */ boolean access$502(HardKeyListener hardKeyListener, boolean bl) {
        hardKeyListener.isInAVMode = bl;
        return hardKeyListener.isInAVMode;
    }
}

