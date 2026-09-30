/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;

public class TVEngineering {
    private final TVEnv env;
    private final Timer engMenuReadDelay;
    public final ITVEventListener activationListener;

    public TVEngineering(TVEnv tVEnv) {
        this.env = tVEnv;
        this.engMenuReadDelay = new Timer("engMenuReadDelay", 10000L, true, new TimerListener());
        this.activationListener = new ActivationListener();
    }

    private void configureGUI() {
        int n = this.env.framework.getStorageMgr().getInt(37, 2424838, -1);
        this.env.lcMain.log(1000000, "[TVEngineering.configureGUI] read %1 from persistance", (long)n);
        boolean bl = n == 1 || n == -1;
        this.env.getChoiceModel(2600084).setValue(bl || this.env.framework.isSimulator() ? 1 : 0);
    }

    public void startTimer() {
        this.engMenuReadDelay.start();
    }

    public void deinit() {
        this.engMenuReadDelay.cancel();
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        public void fireTimer(Timer timer) {
            TVEngineering.this.configureGUI();
        }
    }

    private class ActivationListener
    extends TVEventDefaultListener {
        private ActivationListener() {
        }

        public void onMuGotTvAudioFocus() {
            TVEngineering.this.configureGUI();
        }

        public void onAppActivated(int n) {
            TVEngineering.this.configureGUI();
        }
    }
}

