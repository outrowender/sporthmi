/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.ChoiceModelHandlerAdapter;
import de.audi.app.car.core.light.IntLightChoiceHandlerTransactionData;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class IntLightChoiceModelHandler
extends ChoiceModelHandlerAdapter {
    private int lastSetting = 0;

    public IntLightChoiceModelHandler(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        super(choiceModelApp, logChannel);
    }

    public void updateOnItemSelected(int n) {
        if (this.getBusiness() != null) {
            IntLightChoiceHandlerTransactionData intLightChoiceHandlerTransactionData = new IntLightChoiceHandlerTransactionData(n, this.lastSetting);
            this.getChoiceModelBusiness().processItemSelected(intLightChoiceHandlerTransactionData, (ChoiceModelHandler)this);
        }
    }

    public void updateChoiceModelValue(int n) {
        this.lastSetting = n;
        this.getChoiceModel().setValue(n);
    }
}

