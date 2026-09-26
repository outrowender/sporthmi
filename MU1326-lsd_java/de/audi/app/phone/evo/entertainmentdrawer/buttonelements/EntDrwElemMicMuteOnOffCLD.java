/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.buttonelements;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.AbstractButtonEntertainmentDrawerElement;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class EntDrwElemMicMuteOnOffCLD
extends AbstractButtonEntertainmentDrawerElement {
    public EntDrwElemMicMuteOnOffCLD(ITelApplication iTelApplication) {
        super(iTelApplication, 1);
    }

    @Override
    public int getNewValue() {
        return this.computeNewValue(this.getCurrentStateStruct());
    }

    @Override
    public ChoiceModelApp getConditionModel() {
        return this.getChoiceModel(1201144832);
    }

    private int computeNewValue(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            boolean bl = iTelDSIMobileEquipmentDeviceState.getCallState().isHasActiveCall();
            return bl ? 2 : 0;
        }
        return 0;
    }
}

