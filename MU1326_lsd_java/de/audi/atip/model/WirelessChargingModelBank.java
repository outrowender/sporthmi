/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.model.ICoreWirelessChargingModelBank;
import de.audi.atip.model.IEvoWirelessChargingModelBank;

public class WirelessChargingModelBank
extends AbstractModelBank
implements ICoreWirelessChargingModelBank,
IEvoWirelessChargingModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                default: 
            }
            WirelessChargingModelBank.getModelLogChannel().log(10000, "[WirelessChargingModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public WirelessChargingModelBank() {
        super(34, 1, 0);
        this.modelIDs = new int[0];
    }
}

