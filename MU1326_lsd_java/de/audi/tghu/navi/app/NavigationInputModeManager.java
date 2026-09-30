/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;

public class NavigationInputModeManager
implements INavigationInputModeManager {
    private int currentInputMode = 0;
    private boolean isSdsActive = false;
    private boolean isTpegPOIActive = false;
    private boolean isNavigationActive = false;
    private int sdsDestinationType = -1;

    private NavigationInputModeManager() {
    }

    public void setInputMode(int n, NavigationEnv navigationEnv) {
        LogChannel logChannel = navigationEnv.getLogChannel();
        if (logChannel.isDebug2()) {
            logChannel.log(100000000, "NavigationInputModeManager#setInputMode(%1)", (long)n);
        }
        navigationEnv.getChoiceModel(401246).setValue(n);
        this.currentInputMode = n;
    }

    public int getInputMode() {
        return this.currentInputMode;
    }

    public void setSdsActiveStatus(boolean bl) {
        this.isSdsActive = bl;
    }

    public boolean isSdsActive() {
        return this.isSdsActive;
    }

    public void setTpegPOIActive(boolean bl) {
        this.isTpegPOIActive = bl;
    }

    public boolean isTpegPOIActive() {
        return this.isTpegPOIActive;
    }

    public int getSdsDestinationType() {
        return this.sdsDestinationType;
    }

    public void setSdsDestinationType(int n) {
        this.sdsDestinationType = n;
    }

    public void resetSDSDestinationType() {
        this.sdsDestinationType = -1;
    }

    public boolean isNavigationActive() {
        return this.isNavigationActive;
    }

    public void setNavigationActive(boolean bl) {
        this.isNavigationActive = bl;
    }

    public static class InputModeManagerHolder {
        public static final INavigationInputModeManager INSTANCE = new NavigationInputModeManager();

        private InputModeManagerHolder() {
        }
    }
}

