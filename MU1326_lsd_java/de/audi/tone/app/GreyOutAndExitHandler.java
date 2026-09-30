/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.ToneEnv;

public class GreyOutAndExitHandler {
    public static final int VALUE_DISABLED = 0;
    private static final int VALUE_ENABLED = 1;
    public static final int CHOICE_MODEL = 1000042;
    private final LogChannel lc;
    private final ChoiceModelApp greyOutAndExitChoice;
    private int activeConn = 0;
    private int activeEntConn = 0;

    GreyOutAndExitHandler(ToneEnv toneEnv) {
        this.lc = toneEnv.lcHMI;
        this.greyOutAndExitChoice = toneEnv.getChoiceModel(1000042);
        this.greyOutAndExitChoice.setValue(0);
    }

    void updateActiveConnection(int n, int n2) {
        if (AudioConnection.contains(AudioConnection.TOUCHPAD_CONNECTIONS, n) || AudioConnection.contains(AudioConnection.VOLUME_MENU_CONNECTIONS, n) || n == 200) {
            return;
        }
        this.activeConn = n;
        this.updateGreyOutAndExitState();
    }

    void updateActiveEntertainmentConnection(int n, int n2) {
        this.activeEntConn = n;
        this.updateGreyOutAndExitState();
    }

    private void updateGreyOutAndExitState() {
        if (this.activeConn == this.activeEntConn || this.activeConn == 8) {
            this.lc.log(10000000, "[GreyOutAndExitHandler.updateGreyOutAndExitState] AAC:%1 AEC:%2 -> enable", (long)this.activeConn, (long)this.activeEntConn);
            this.greyOutAndExitChoice.setValue(1);
        } else {
            this.lc.log(10000000, "[GreyOutAndExitHandler.updateGreyOutAndExitState] AAC:%1 AEC:%2 -> disable (grey-out)", (long)this.activeConn, (long)this.activeEntConn);
            this.greyOutAndExitChoice.setValue(0);
        }
    }
}

