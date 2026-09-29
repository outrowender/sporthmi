/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.TelBapFSGOperationStateStruct;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.IEcallState;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class BAPPropertyTelFSGOperationState
extends AbstractTel1EnqueuedBAPPropertyHandler {
    private volatile TelBapFSGOperationStateStruct fsgOperationStateStruct;
    private int telMode;
    private int actState;
    private int phoneModuleState;
    private int telState;
    private boolean isPrivacyMode;
    private int nadMode;
    private final boolean enhancedPrivacyModeActive;
    private boolean isLowPriorityEcallActive;

    BAPPropertyTelFSGOperationState(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
        this.enhancedPrivacyModeActive = true;
    }

    private void updateArgs(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        boolean bl;
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "BAPPropertyTelFSGOperationState#updateArgs telephoneState is null");
            return;
        }
        this.log.log(-2137614336, "[BAPPropertyTelFSGOperationState#updateArgs call");
        IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
        boolean bl2 = bl = iEcallState != null && iEcallState.isLowPrioritySOSEmergencyCallType();
        if (bl) {
            this.isLowPriorityEcallActive = true;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getActivationState() != null) {
            this.isPrivacyMode = iTelDSIMobileEquipmentDeviceState.isPrivacyMode();
            this.telMode = iTelDSIMobileEquipmentDeviceState.getActivationState().getTelMode();
            this.actState = iTelDSIMobileEquipmentDeviceState.getActivationState().getTelActivationState();
            this.phoneModuleState = iGlobalTelephoneStateStruct.getPhoneModuleState();
            this.nadMode = iGlobalTelephoneStateStruct.getNadMode();
        }
        this.updateTelState();
    }

    private void updateTelState() {
        this.log.log(-2137614336, "[BAPPropertyTelFSGOperationState#updateTelState] call");
        if (this.isLowPriorityEcallActive) {
            this.telState = 15;
            return;
        }
        block0 : switch (this.actState) {
            case 0: {
                this.telState = 0;
                break;
            }
            case 1: 
            case 4: {
                int n = this.nadMode == 2 ? 0 : this.phoneModuleState;
                switch (n) {
                    case 0: 
                    case 2: {
                        this.telState = 18;
                        break block0;
                    }
                    case 1: {
                        this.telState = 9;
                        break block0;
                    }
                    case 3: 
                    case 4: {
                        this.telState = 5;
                        break block0;
                    }
                    case 5: {
                        this.telState = 1;
                        break block0;
                    }
                }
                this.log.log(-2137614336, "PhoneBAPPropertyFSGOperationState#telStateChanged: For ACTIVATIONSTATE_PHONE_OFF no action for %1", (long)this.phoneModuleState);
                break;
            }
            case 2: 
            case 5: {
                if (this.isSIMUsed(this.telMode)) {
                    this.telState = 7;
                    break;
                }
                if (this.telMode != 3) break;
                this.telState = 15;
                break;
            }
            case 7: {
                this.telState = 19;
                break;
            }
            case 9: {
                this.telState = 20;
                break;
            }
            case 12: {
                this.telState = 12;
                break;
            }
        }
    }

    private boolean isSIMUsed(int n) {
        return n == 2 || n == 0 || n == 1;
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return true;
    }

    @Override
    protected void updateAsync() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-2137614336, "[BAPPropertyTelFSGOperationState#update nothing to update:  globalTelephoneState is null]");
            return;
        }
        this.updateArgs(iGlobalTelephoneStateStruct);
        super.getClass();
        TelBapFSGOperationStateStruct telBapFSGOperationStateStruct = new TelBapFSGOperationStateStruct(this.telState, this.isPrivacyMode, true);
        if (!telBapFSGOperationStateStruct.equals(this.fsgOperationStateStruct) && combiBAPServicePhone != null) {
            this.log.log(1078071040, "[BAPPropertyTelFSGOperationState#update] updating cluster: %1", (Object)telBapFSGOperationStateStruct);
            combiBAPServicePhone.updateFSGOperationState(telBapFSGOperationStateStruct.getTelState(), telBapFSGOperationStateStruct.isPrivacyModeActive(), telBapFSGOperationStateStruct.isEnhancedPrivacyModeActive());
            this.fsgOperationStateStruct = telBapFSGOperationStateStruct;
        }
    }
}

