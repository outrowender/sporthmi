/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.buttonelements;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.AbstractButtonEntertainmentDrawerElement;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class EntDrwElemMuteRingtoneCLD
extends AbstractButtonEntertainmentDrawerElement {
    public EntDrwElemMuteRingtoneCLD(ITelApplication iTelApplication) {
        super(iTelApplication, 0);
    }

    public int getNewValue() {
        return this.computeNewValue(this.getCurrentStateStruct());
    }

    public ChoiceModelApp getConditionModel() {
        return this.getChoiceModel(301118);
    }

    private int computeNewValue(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            int n = iTelDSIMobileEquipmentDeviceState.getCallState().getCallStateChoiceValue();
            switch (n) {
                case 1: {
                    return 2;
                }
            }
            return 0;
        }
        return 0;
    }
}

