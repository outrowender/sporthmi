/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.RangeModelEventBusinessAdapter;
import de.audi.app.car.core.light.IntLightRangeHandlerTransactionData;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightBrightness;

public class IntLightRangeEventBusiness
extends RangeModelEventBusinessAdapter {
    public IntLightRangeEventBusiness(DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
    }

    public boolean processAdjustment(HandlerTransactionData handlerTransactionData, RangeModelHandler rangeModelHandler) {
        IntLightRangeHandlerTransactionData intLightRangeHandlerTransactionData = (IntLightRangeHandlerTransactionData)handlerTransactionData;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[IntLightRangeEventBusiness#processAdjustment] rotary changed: %1 on profileID = %2 for modelID = %3", (long)intLightRangeHandlerTransactionData.getValue(), (long)intLightRangeHandlerTransactionData.getProfileID(), (long)rangeModelHandler.getHandledModelID());
        }
        if (intLightRangeHandlerTransactionData.getProfileID() == 0) {
            IntLightBrightness intLightBrightness = new IntLightBrightness(new Integer(rangeModelHandler.getRangeModel().getValue() + intLightRangeHandlerTransactionData.getValue()).shortValue(), true);
            this.getLogChannel().log(1000000, "[dsi.setIntLightBrightness] rotary changed: %1 on profileID = %2 for modelID = %3", (long)intLightRangeHandlerTransactionData.getValue(), (long)intLightRangeHandlerTransactionData.getProfileID(), (long)rangeModelHandler.getHandledModelID());
            this.getDSICarLight().setIntLightBrightness(intLightBrightness);
        } else if (intLightRangeHandlerTransactionData.getProfileID() <= 8 && intLightRangeHandlerTransactionData.getProfileID() > 0) {
            this.getLogChannel().log(1000000, "[dsi.setIntLightIlluminationProfile(%1, %2)]", (long)intLightRangeHandlerTransactionData.getProfileID(), (long)(rangeModelHandler.getRangeModel().getValue() + intLightRangeHandlerTransactionData.getValue()));
            this.getDSICarLight().setIntLightIlluminationProfile(intLightRangeHandlerTransactionData.getProfileID(), rangeModelHandler.getRangeModel().getValue() + intLightRangeHandlerTransactionData.getValue());
        } else {
            this.getLogChannel().log(1000000, "IntLightRangeEventBusiness#processAdjustment] Profile %1 not supported", (long)intLightRangeHandlerTransactionData.getProfileID());
            return false;
        }
        return true;
    }

    public boolean processKeyPressed(int n, ButtonModelHandler buttonModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[IntLightRangeEventBusiness#processKeyPressed] Key has been pressd for modelID = %1", (long)buttonModelHandler.getHandledModelID());
        }
        buttonModelHandler.fireEvent();
        return true;
    }

    private DSICarLight getDSICarLight() {
        return (DSICarLight)this.getDSI();
    }
}

