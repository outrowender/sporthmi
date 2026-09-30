/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tone.app.ToneEnv;

public class ToneHMIApplication
implements HMIApplication {
    public static final int HMI_APP_ID = 10;
    private final ToneEnv env;

    public ToneHMIApplication(ToneEnv toneEnv) {
        this.env = toneEnv;
    }

    public int getId() {
        return 10;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void screenHidden(int n, int n2) {
        if (n == 100026) {
            this.env.lcHMI.log(1000000, "[ToneHMIApplication.screenHidden] ID:100026 (toneSystemsParkingEntertain)");
            this.env.getSystemChoiceModel(135).setValue(1);
        }
    }

    public void screenVisible(int n, int n2) {
    }

    public void popupHidden(int n, int n2) {
    }

    public void popupRemoved(int n, int n2) {
    }

    public void popupVisible(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }
}

