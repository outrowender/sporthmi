/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.RangeModelEventBusinessAdapter;
import de.audi.app.car.core.light.IntLightIndividualRangeModelHandler;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carlight.DSICarLight;

public class IntLightIndividualBrightnessRangeBusiness
extends RangeModelEventBusinessAdapter {
    private int illuminationSetNumber = 0;
    private boolean profileMode = false;

    public IntLightIndividualBrightnessRangeBusiness(DSIBase dSIBase, boolean bl, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.profileMode = bl;
    }

    public boolean processAdjustment(int n, RangeModelHandler rangeModelHandler) {
        if (this.illuminationSetNumber > 0) {
            int n2 = rangeModelHandler.getRangeModel().getValue() + n;
            this.getLogChannel().log(1000000, "[IntLightIndividualBrightnessRangeBusiness] dsi.setIntLightIlluminationSet: %1 value = %2", (long)this.illuminationSetNumber, (long)n2);
            this.getDSICarLight().setIntLightIlluminationSet(this.illuminationSetNumber, n2);
            ((IntLightIndividualRangeModelHandler)rangeModelHandler).getModelWatcherTimer().setTempValue(n2);
            return true;
        }
        return false;
    }

    public boolean processKeyPressed(int n, ButtonModelHandler buttonModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[IntLightIndividualBrightnessRangeBusiness#processKeyPressed] Key has been pressd for modelID = %1", (long)buttonModelHandler.getHandledModelID());
        }
        if (this.profileMode) {
            this.getDSICarLight().setIntLightActiveProfile(1);
        }
        buttonModelHandler.fireEvent();
        return true;
    }

    private DSICarLight getDSICarLight() {
        return (DSICarLight)this.getDSI();
    }

    public void setIlluminationSetNumber(int n) {
        this.illuminationSetNumber = n;
    }

    public void setProfilesMode(boolean bl) {
        this.profileMode = bl;
    }
}

