/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tone.app.ToneEnv;

public class ToneHMIApplication
implements HMIApplication {
    public static final int HMI_APP_ID;
    private final ToneEnv env;

    public ToneHMIApplication(ToneEnv toneEnv) {
        this.env = toneEnv;
    }

    @Override
    public int getId() {
        return 10;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public void screenHidden(int n, int n2) {
        if (n == -1165623040) {
            this.env.lcHMI.log(1078071040, "[ToneHMIApplication.screenHidden] ID:100026 (toneSystemsParkingEntertain)");
            this.env.getSystemChoiceModel(135).setValue(1);
        }
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    @Override
    public void popupRemoved(int n, int n2) {
    }

    @Override
    public void popupVisible(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
    }
}

