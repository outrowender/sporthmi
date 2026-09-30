/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IView;

public class MapOptionView
implements IView {
    private final LogChannel logger;
    private final ButtonModelApp mShowDetailsOfCrosshair;
    private final ButtonModelApp mShowDetailsOfCrosshairForPOIStack;
    private final ButtonModelApp mShowDetailsOfCrosshairForTMCEvent;

    public MapOptionView(NavigationEnv navigationEnv) {
        this.logger = navigationEnv.getLogChannel("App.Map.GUI.Main");
        this.mShowDetailsOfCrosshair = navigationEnv.getButtonModel(401567);
        this.mShowDetailsOfCrosshairForPOIStack = navigationEnv.getButtonModel(401568);
        this.mShowDetailsOfCrosshairForTMCEvent = navigationEnv.getButtonModel(402293);
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public void setShowDetailsOfCrosshairListener(ButtonListener buttonListener) {
        this.getLogger().log(10000000, "MapOptionView#setShowDetailsOfCrosshairListener()");
        if (this.mShowDetailsOfCrosshair != null) {
            this.mShowDetailsOfCrosshair.setButtonListener(buttonListener);
        }
        if (this.mShowDetailsOfCrosshairForPOIStack != null) {
            this.mShowDetailsOfCrosshairForPOIStack.setButtonListener(buttonListener);
        }
        if (this.mShowDetailsOfCrosshairForTMCEvent != null) {
            this.mShowDetailsOfCrosshairForTMCEvent.setButtonListener(buttonListener);
        }
    }
}

