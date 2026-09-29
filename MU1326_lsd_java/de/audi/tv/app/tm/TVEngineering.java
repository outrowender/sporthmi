/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.timer.Timer;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.TVEngineering$ActivationListener;
import de.audi.tv.app.tm.TVEngineering$TimerListener;

public class TVEngineering {
    private final TVEnv env;
    private final Timer engMenuReadDelay;
    public final ITVEventListener activationListener;

    public TVEngineering(TVEnv tVEnv) {
        this.env = tVEnv;
        this.engMenuReadDelay = new Timer("engMenuReadDelay", 0, true, new TVEngineering$TimerListener(this, null));
        this.activationListener = new TVEngineering$ActivationListener(this, null);
    }

    private void configureGUI() {
        int n = this.env.framework.getStorageMgr().getInt(37, 100672768, -1);
        this.env.lcMain.log(1078071040, "[TVEngineering.configureGUI] read %1 from persistance", (long)n);
        boolean bl = n == 1 || n == -1;
        this.env.getChoiceModel(-1800657152).setValue(bl || this.env.framework.isSimulator() ? 1 : 0);
    }

    public void startTimer() {
        this.engMenuReadDelay.start();
    }

    public void deinit() {
        this.engMenuReadDelay.cancel();
    }

    static /* synthetic */ void access$200(TVEngineering tVEngineering) {
        tVEngineering.configureGUI();
    }
}

