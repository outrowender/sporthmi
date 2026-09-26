/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.buttonelements;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.AbstractButtonEntertainmentDrawerElement;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class EntDrwElemRejectCallCLD
extends AbstractButtonEntertainmentDrawerElement {
    public EntDrwElemRejectCallCLD(ITelApplication iTelApplication) {
        super(iTelApplication, 0);
    }

    @Override
    public int getNewValue() {
        return this.computeNewValue(this.getCurrentStateStruct());
    }

    @Override
    public ChoiceModelApp getConditionModel() {
        return this.getChoiceModel(1083704320);
    }

    private int computeNewValue(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasIncomingCall() ? 2 : 0;
        }
        return 0;
    }
}

