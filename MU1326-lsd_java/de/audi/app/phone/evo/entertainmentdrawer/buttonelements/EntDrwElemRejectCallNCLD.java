/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.buttonelements;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.AbstractButtonEntertainmentDrawerElement;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class EntDrwElemRejectCallNCLD
extends AbstractButtonEntertainmentDrawerElement {
    public EntDrwElemRejectCallNCLD(ITelApplication iTelApplication) {
        super(iTelApplication, 0);
    }

    @Override
    public int getNewValue() {
        return this.computeNewValue(this.getCurrentStateStruct());
    }

    @Override
    public ChoiceModelApp getConditionModel() {
        return this.getChoiceModel(1167590400);
    }

    private int computeNewValue(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState3 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getNonCallLeadingDevice() : null;
        if (iTelDSIMobileEquipmentDeviceState2 != null && iTelDSIMobileEquipmentDeviceState2.getCallState() != null && iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            boolean bl = iTelDSIMobileEquipmentDeviceState2.getCallState().isHasIncomingCall();
            boolean bl2 = iTelDSIMobileEquipmentDeviceState.getCallState().isHasIncomingCall();
            if (!bl && bl2) {
                return 2;
            }
        }
        return 0;
    }
}

