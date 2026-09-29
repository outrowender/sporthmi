/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.business.ChoiceModelEventBusinessAdapter;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.core.light.IntLightChoiceHandlerTransactionData;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlight.DSICarLight;

public class IntLightChoiceEventBusiness
extends ChoiceModelEventBusinessAdapter {
    public IntLightChoiceEventBusiness(DSICarLight dSICarLight, LogChannel logChannel) {
        super(dSICarLight, logChannel);
    }

    @Override
    public boolean processItemSelected(HandlerTransactionData handlerTransactionData, ChoiceModelHandler choiceModelHandler) {
        IntLightChoiceHandlerTransactionData intLightChoiceHandlerTransactionData = (IntLightChoiceHandlerTransactionData)handlerTransactionData;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[IntLightChoiceEventBusiness#processItemSelected] Profile wit id = %1 has been selected", (long)intLightChoiceHandlerTransactionData.getNewSelected());
        }
        if (intLightChoiceHandlerTransactionData.getNewSelected() > 0 && intLightChoiceHandlerTransactionData.getNewSelected() < 9) {
            if (intLightChoiceHandlerTransactionData.getNewSelected() == intLightChoiceHandlerTransactionData.getOldSelected()) {
                choiceModelHandler.fireEvent();
            } else {
                this.getDSICarLight().setIntLightActiveProfile(intLightChoiceHandlerTransactionData.getNewSelected());
            }
        } else {
            this.getLogChannel().log(1000, "Profile id out of range: %1", (long)intLightChoiceHandlerTransactionData.getNewSelected());
            return false;
        }
        return true;
    }

    private DSICarLight getDSICarLight() {
        return (DSICarLight)this.getDSI();
    }
}

