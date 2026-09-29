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

    @Override
    public void setInputMode(int n, NavigationEnv navigationEnv) {
        LogChannel logChannel = navigationEnv.getLogChannel();
        if (logChannel.isDebug2()) {
            logChannel.log(14808325, "NavigationInputModeManager#setInputMode(%1)", (long)n);
        }
        navigationEnv.getChoiceModel(1579091456).setValue(n);
        this.currentInputMode = n;
    }

    @Override
    public int getInputMode() {
        return this.currentInputMode;
    }

    @Override
    public void setSdsActiveStatus(boolean bl) {
        this.isSdsActive = bl;
    }

    @Override
    public boolean isSdsActive() {
        return this.isSdsActive;
    }

    @Override
    public void setTpegPOIActive(boolean bl) {
        this.isTpegPOIActive = bl;
    }

    @Override
    public boolean isTpegPOIActive() {
        return this.isTpegPOIActive;
    }

    @Override
    public int getSdsDestinationType() {
        return this.sdsDestinationType;
    }

    @Override
    public void setSdsDestinationType(int n) {
        this.sdsDestinationType = n;
    }

    @Override
    public void resetSDSDestinationType() {
        this.sdsDestinationType = -1;
    }

    @Override
    public boolean isNavigationActive() {
        return this.isNavigationActive;
    }

    @Override
    public void setNavigationActive(boolean bl) {
        this.isNavigationActive = bl;
    }
}

