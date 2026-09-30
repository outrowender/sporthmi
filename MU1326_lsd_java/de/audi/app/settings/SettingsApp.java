/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class SettingsApp
implements HMIApplication {
    public int getId() {
        return 11;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void popupVisible(int n, int n2) {
    }

    public void popupHidden(int n, int n2) {
    }

    public void popupRemoved(int n, int n2) {
    }

    public void screenVisible(int n, int n2) {
    }

    public void screenHidden(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }
}

