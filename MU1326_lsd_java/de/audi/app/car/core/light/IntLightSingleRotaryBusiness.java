/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.RangeModelEventBusinessAdapter;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.app.car.core.light.AbstractIntLightComponent$AllSetSyncHandler;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carlight.DSICarLight;

public class IntLightSingleRotaryBusiness
extends RangeModelEventBusinessAdapter {
    private boolean profile1Activated = false;
    private boolean incrDecrEvent = false;
    private int setNum = 0;
    private RangeModelWatcherTimer watchedModelTimer;
    private AbstractIntLightComponent$AllSetSyncHandler allSetSyncHandler;

    public IntLightSingleRotaryBusiness(DSIBase dSIBase, boolean bl, int n, RangeModelApp rangeModelApp, AbstractIntLightComponent$AllSetSyncHandler abstractIntLightComponent$AllSetSyncHandler, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.profile1Activated = bl;
        this.setNum = n;
        this.watchedModelTimer = new RangeModelWatcherTimer("IntLightRotaryValue", rangeModelApp, 0, this.getLogChannel());
        this.allSetSyncHandler = abstractIntLightComponent$AllSetSyncHandler;
    }

    @Override
    public boolean processAdjustment(int n, RangeModelHandler rangeModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[IntLightSingleRotaryBusiness#processAdjustment] rotary changed: %1 for modelID = %2", (long)n, (long)rangeModelHandler.getHandledModelID());
        }
        int n2 = rangeModelHandler.getRangeModel().getValue() + n;
        this.incrDecrEvent = true;
        if (this.profile1Activated) {
            this.getLogChannel().log(1078071040, "[IntLightSingleRotaryBusiness#processAdjustment] dsi.setIntLightIlluminationProfile(1, %1)", (long)n2);
            this.getDSICarLight().setIntLightIlluminationProfile(1, n2);
        }
        if (this.setNum > 0 && this.setNum < 9) {
            this.getLogChannel().log(1078071040, "[IntLightSingleRotaryBusiness#processAdjustment] setIntLightIlluminationSet(%1,%2)", (long)this.setNum, (long)n2);
            this.getDSICarLight().setIntLightIlluminationSet(this.setNum, n2);
        }
        this.watchedModelTimer.setTempValue(n2);
        return true;
    }

    @Override
    public boolean processKeyPressed(int n, ButtonModelHandler buttonModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[IntLightSingleRotaryBusiness#processKeyPressed] Key has been pressd for modelID = %1", (long)buttonModelHandler.getHandledModelID());
        }
        this.allSetSyncHandler.triggerAllSetSync(this.incrDecrEvent);
        buttonModelHandler.fireEvent();
        return true;
    }

    public void activateProfile1Mode(boolean bl) {
        this.profile1Activated = bl;
    }

    public void activateSetMode(int n) {
        this.setNum = n;
    }

    public RangeModelWatcherTimer getWatcherTimer() {
        return this.watchedModelTimer;
    }

    private DSICarLight getDSICarLight() {
        return (DSICarLight)this.getDSI();
    }

    public void resetEventWatcher() {
        this.incrDecrEvent = false;
    }
}

