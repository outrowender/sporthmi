/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.IHardKeyHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.TuningMonitor;
import de.audi.tv.app.lists.AbstractStationList;
import de.audi.tv.app.lists.FocusHandler;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class HardKeyListener
extends DefaultButtonListener {
    private IHardKeyHandler defaultHKHandler = new IHardKeyHandler(){

        public boolean prevKeyPressed() {
            return false;
        }

        public boolean nextKeyPressed() {
            return false;
        }
    };
    private final FocusHandler focusHandler;
    private final TuningMonitor tuningMonitor;
    public final ActivationListener activationListener;
    private volatile boolean tvAppActive = false;
    private volatile boolean hardKeysActive = true;
    private volatile boolean isInAVMode = false;
    public final TVListener listener = new TVListener();
    private IHardKeyHandler hkHandler = this.defaultHKHandler;
    private final LogChannel log;

    public HardKeyListener(TVEnv tVEnv, LogChannel logChannel, FocusHandler focusHandler, TuningMonitor tuningMonitor) {
        this.log = logChannel;
        this.focusHandler = focusHandler;
        this.tuningMonitor = tuningMonitor;
        this.activationListener = new ActivationListener();
        tVEnv.getButtonModel(2600051).setButtonListener(this);
        tVEnv.getButtonModel(2600052).setButtonListener(this);
        tVEnv.getButtonModel(2600165).setButtonListener(this);
        tVEnv.getButtonModel(2600164).setButtonListener(this);
    }

    public void registerHardKeyHandler(IHardKeyHandler iHardKeyHandler) {
        this.hkHandler = iHardKeyHandler == null ? this.defaultHKHandler : iHardKeyHandler;
    }

    public void simulateHkNext(int n) {
        this.keyTyped(2600051, 0, n);
    }

    public void simualteHkPrev(int n) {
        this.keyTyped(2600052, 0, n);
    }

    public void keyTyped(int n, int n2, int n3) {
        if (!this.tvAppActive) {
            this.log.log(100000, "[HardKeyListener.keyTyped] ignored (TV not active)");
            return;
        }
        if (!this.hardKeysActive) {
            this.log.log(100000, "[HardKeyListener.keyTyped] ignored (skip behaviour unavailable)");
            return;
        }
        if (this.isInAVMode) {
            this.log.log(100000, "[HardKeyListener.keyTyped] ignored (AV is active)");
            return;
        }
        if (this.tuningMonitor.getLastTunedService() != null) {
            this.log.log(100000, "[HardKeyListener.keyTyped] tuning is in progress");
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
        this.log.log(10000000, "[HardKeyListener.keyTyped] model:%1 HT:%2", (long)n, (long)n3);
    }

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            HardKeyListener.this.hardKeysActive = true;
            HardKeyListener.this.log.log(1000000, "[HardKeyListener.TVListener.updateStartUpMUConfig] hard keys available:%1", HardKeyListener.this.hardKeysActive);
        }

        public void updateSelectedSource(int n) {
            if (n == 1) {
                HardKeyListener.this.isInAVMode = true;
            } else {
                HardKeyListener.this.isInAVMode = false;
            }
        }
    }

    private class ActivationListener
    extends TVEventDefaultListener {
        private ActivationListener() {
        }

        public void onMuGotTvAudioFocus() {
            HardKeyListener.this.tvAppActive = true;
            HardKeyListener.this.log.log(1000000, "[HardKeyListener.ActivationListener.onGotAudioFocus] HardKey evaluation enabled.");
        }

        public void onMuLostTvAudioFocus() {
            HardKeyListener.this.tvAppActive = false;
            HardKeyListener.this.log.log(1000000, "[HardKeyListener.ActivationListener.onLostAudioFocus] HardKey evaluation disabled.");
        }
    }
}

