/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.RangeModelEventBusinessAdapter;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBValues;

public class IntLightAmbientColorRangeModelEventBusiness
extends RangeModelEventBusinessAdapter {
    private IntLightRGBColorListRA0[] colorData = null;
    private boolean profileMode = false;

    public IntLightAmbientColorRangeModelEventBusiness(DSIBase dSIBase, boolean bl, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.profileMode = bl;
    }

    public boolean processAdjustment(int n, RangeModelHandler rangeModelHandler) {
        if (this.colorData != null) {
            int n2 = rangeModelHandler.getRangeModel().getValue() + n;
            if (n2 > 0 && n2 <= this.colorData.length) {
                IntLightRGBValues intLightRGBValues = this.colorData[n2 - 1].getValues();
                this.getLogChannel().log(1000000, "[dsi.setIntLightAmbientLightColor: %1 (%2)", (Object)intLightRGBValues.toString(), (long)n2);
                this.getDSICarLight().setIntLightAmbientLightColor(intLightRGBValues);
                return true;
            }
        } else {
            this.getLogChannel().log(1000000, "[IntLightAmbientColorRangeModelEventBusiness#processAdjustment] rotary changed: %1 for modelID = %2", (long)n, (long)rangeModelHandler.getHandledModelID());
        }
        return false;
    }

    public boolean processKeyPressed(int n, ButtonModelHandler buttonModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[IntLightAmbientColorRangeModelEventBusiness#processKeyPressed] Key has been pressd for modelID = %1", (long)buttonModelHandler.getHandledModelID());
        }
        if (this.profileMode) {
            this.getDSICarLight().setIntLightActiveProfile(1);
        }
        buttonModelHandler.fireEvent();
        return true;
    }

    public void setColorList(IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        this.colorData = intLightRGBColorListRA0Array;
    }

    public IntLightRGBColorListRA0[] getColorList() {
        return this.colorData;
    }

    private DSICarLight getDSICarLight() {
        return (DSICarLight)this.getDSI();
    }

    public void setProfilesMode(boolean bl) {
        this.profileMode = bl;
    }
}

