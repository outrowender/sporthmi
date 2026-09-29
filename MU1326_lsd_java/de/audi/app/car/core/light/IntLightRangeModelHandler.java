/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.RangeModelHandlerAdapter;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.app.car.core.light.IntLightRangeHandlerTransactionData;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;

public class IntLightRangeModelHandler
extends RangeModelHandlerAdapter {
    private int selectedProfile = 0;
    private int[] brightness = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80};
    private RangeModelWatcherTimer watchedModelTimer;

    public IntLightRangeModelHandler(RangeModelApp rangeModelApp, LogChannel logChannel) {
        super(rangeModelApp, logChannel);
        rangeModelApp.setLimits(0, 100, 5);
        rangeModelApp.setValue(50);
        this.watchedModelTimer = new RangeModelWatcherTimer("IntLightRotaryValue", rangeModelApp, 0, logChannel);
    }

    @Override
    public void updateOnAdjustment(int n) {
        if (this.getBusiness() != null) {
            IntLightRangeHandlerTransactionData intLightRangeHandlerTransactionData = new IntLightRangeHandlerTransactionData(this.selectedProfile, n);
            this.getRangeEventBusiness().processAdjustment(intLightRangeHandlerTransactionData, (RangeModelHandler)this);
            this.watchedModelTimer.setTempValue(this.getRangeModel().getValue() + n);
        }
    }

    @Override
    public void updateOnKeyPressed(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processKeyPressed(n, (ButtonModelHandler)this);
        }
    }

    public void setSelectedProfile(int n) {
        this.selectedProfile = n;
        this.getRangeModel().setValue(this.brightness[n]);
    }

    public void setBrightness(int n, int n2) {
        this.brightness[n] = n2;
        if (this.selectedProfile == n) {
            this.watchedModelTimer.setValidValue(n2);
        }
    }

    public int getSelectedProfile() {
        return this.selectedProfile;
    }

    public int getSelectedProfilesValue() {
        return this.brightness[this.selectedProfile];
    }

    public RangeModelWatcherTimer getModelWatcherTimer() {
        return this.watchedModelTimer;
    }
}

