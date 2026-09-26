/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class SettingsApp
implements HMIApplication {
    @Override
    public int getId() {
        return 11;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public void popupVisible(int n, int n2) {
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    @Override
    public void popupRemoved(int n, int n2) {
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
    }
}

