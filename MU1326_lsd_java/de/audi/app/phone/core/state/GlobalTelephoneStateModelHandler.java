/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.state.GlobalTelephoneStateModelHandler$GlobalTelephoneStateModelHandlerLanguageUpdateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;

class GlobalTelephoneStateModelHandler
implements IGlobalTelephoneStateListener {
    public static final int TEL_MODE_HFP;
    public static final int TEL_MODE_INTERNAL_SIM;
    public static final int TEL_MODE_EXTERNAL_SIMAP;
    public static final int TEL_MODE_SIMAP_BTHS;
    public static final int TEL_MODE_NO_SIM_AVAILABLE;
    private static final int HANDSFREEMODE_PRIVATE;
    private static final int HANDSFREEMODE_HANDSFREE;
    private static final int VOICE_AND_DATA;
    private static final int DATA_ONLY;
    private final IHMIServiceApp hmiService;
    private final LogChannel log;
    private final GlobalTelephoneStateModelHandler$GlobalTelephoneStateModelHandlerLanguageUpdateListener langListener;
    private final TelModelGroup modelGroup;
    private final ITelTextFactory textFactory;
    private volatile IGlobalTelephoneStateStruct lastState;
    private final Object lock = new Object();

    private static int getNadModeChoiceModelValue(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            return iGlobalTelephoneStateStruct.getNadMode() == 2 ? 1 : 0;
        }
        return 0;
    }

    private static int getHandsfreeModeModelValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            return iTelDSIMobileEquipmentDeviceState.getHandsFreeMode() == 0 ? 0 : 1;
        }
        return 1;
    }

    private static int getMultipartyActiveModelValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isMultipartyActive() ? 1 : 0;
        }
        return 0;
    }

    private static int getMultipartySupportedModelValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            return iTelDSIMobileEquipmentDeviceState.isMultipartySupported() ? 1 : 0;
        }
        return 0;
    }

    private static int getMailboxAvailableModelValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            return iTelDSIMobileEquipmentDeviceState.isMailboxNumberAvailable() ? 1 : 0;
        }
        return 0;
    }

    private static String getBluetoothFriendlyName(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null) {
            return iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName();
        }
        return "";
    }

    private static String getNadIMEI(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null) {
            return iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getNadIMEI();
        }
        return "";
    }

    private static int getPhoneReadyModelValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        int n = iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getActivationState() != null ? iTelDSIMobileEquipmentDeviceState.getActivationState().getTelActivationState() : 0;
        int n2 = iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getLockState() != null ? iTelDSIMobileEquipmentDeviceState.getLockState().getTelLockState() : 0;
        return (n == 5 || n == 2) && n2 == 2 ? 1 : 0;
    }

    private static int getConferenceInStateActiveChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasActiveConferenceCall() ? 1 : 0;
        }
        return 0;
    }

    private static int getConferenceInStateHeldChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldConferenceCall() ? 1 : 0;
        }
        return 0;
    }

    private static int getConferenceInStateHeldOrActiveChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldConferenceCall() || iTelDSIMobileEquipmentDeviceState.getCallState().isHasActiveConferenceCall() ? 1 : 0;
        }
        return 0;
    }

    private static int getMicMuteChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            return iTelDSIMobileEquipmentDeviceState.getmICMuteState() == 0 ? 1 : 0;
        }
        return 0;
    }

    private static int getOutgoingCallChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasOutgoingCall() ? 1 : 0;
        }
        return 0;
    }

    private static int getActiveCallChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasActiveCall() || iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType() ? 1 : 0;
        }
        return 0;
    }

    private static int getEmergencyCallChoiceValue(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType() && iGlobalTelephoneStateStruct.getConnectedGatewayState().getCall().getState() != 0 ? 1 : 0;
    }

    private static int getOutgoingCallPresentChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasOutgoingCall() ? 1 : 0;
        }
        return 0;
    }

    private static int getPhoneReady2PhoneChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getDeviceRole() == 256 && iTelDSIMobileEquipmentDeviceState.isDialingPossible() ? 1 : 0;
    }

    private static int getTelFeatEnhCallChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? (iTelDSIMobileEquipmentDeviceState.isEnhancedCallFeaturesSupported() ? 1 : 0) : 0;
    }

    private static int getTelFeatInbandRingingChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? (iTelDSIMobileEquipmentDeviceState.inbandRingingSupported() ? 1 : 0) : 0;
    }

    private static String getNadUserFriendlyNameLabelText(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, String string) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            if (iTelDSIMobileEquipmentDeviceState.getTelMode() == 2 && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null) {
                return iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName();
            }
            if (iTelDSIMobileEquipmentDeviceState.getTelMode() == 0) {
                return string;
            }
        }
        return "";
    }

    private static int getNadRoleChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            int n = iTelDSIMobileEquipmentDeviceState.getDeviceRole();
            switch (n) {
                case 131072: {
                    return 2;
                }
                case 196608: {
                    return 3;
                }
                case 65536: {
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

    private static int getTelModeChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        int n = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getTelMode() : 4;
        switch (n) {
            case 3: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 0: {
                return 1;
            }
            case 1: {
                return 3;
            }
        }
        return 4;
    }

    private static int getIncomingCallPresentChoiceValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null ? (iTelDSIMobileEquipmentDeviceState.getCallState().isHasIncomingCall() ? 1 : 0) : 0;
    }

    public GlobalTelephoneStateModelHandler(ITelApplication iTelApplication, LogChannel logChannel) {
        this.log = logChannel;
        this.textFactory = iTelApplication.getTextFactory();
        this.hmiService = iTelApplication.getFrameworkAccess().getHmiServiceApp();
        this.modelGroup = new TelModelGroup("GlobalTelephoneStateModelHandler", logChannel);
        this.langListener = new GlobalTelephoneStateModelHandler$GlobalTelephoneStateModelHandlerLanguageUpdateListener(this, iTelApplication);
        this.langListener.init();
    }

    private void groupAndSetChoiceModel(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(n);
        if (choiceModelApp != null) {
            this.modelGroup.add(choiceModelApp);
            choiceModelApp.setValue(n2);
        }
    }

    private void groupAndSetLabelModel(int n, String string) {
        LabelModelApp labelModelApp = this.hmiService.getLabelModel(n);
        if (labelModelApp != null) {
            this.modelGroup.add(labelModelApp);
            labelModelApp.setText(string);
        }
    }

    private void flushModels() {
        this.modelGroup.flush();
        this.modelGroup.removeAll();
    }

    private void setCallLeadingDeviceModels(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        this.groupAndSetChoiceModel(-510196736, GlobalTelephoneStateModelHandler.getHandsfreeModeModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-476642304, GlobalTelephoneStateModelHandler.getMultipartyActiveModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-459865088, GlobalTelephoneStateModelHandler.getMultipartySupportedModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-493419520, GlobalTelephoneStateModelHandler.getTelModeChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(1587020800, GlobalTelephoneStateModelHandler.getMicMuteChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-342424576, GlobalTelephoneStateModelHandler.getActiveCallChoiceValue(iTelDSIMobileEquipmentDeviceState, this.lastState));
        this.groupAndSetChoiceModel(-325647360, GlobalTelephoneStateModelHandler.getConferenceInStateActiveChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-308870144, GlobalTelephoneStateModelHandler.getConferenceInStateHeldOrActiveChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-292092928, GlobalTelephoneStateModelHandler.getTelFeatEnhCallChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-208206848, GlobalTelephoneStateModelHandler.getOutgoingCallPresentChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(630719488, GlobalTelephoneStateModelHandler.getIncomingCallPresentChoiceValue(iTelDSIMobileEquipmentDeviceState));
    }

    private void setNonCallLeadingDeviceModels(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        this.groupAndSetChoiceModel(613942272, GlobalTelephoneStateModelHandler.getIncomingCallPresentChoiceValue(iTelDSIMobileEquipmentDeviceState));
    }

    private void setPrimaryDeviceModels(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelTextFactory iTelTextFactory) {
        this.groupAndSetChoiceModel(2106983424, GlobalTelephoneStateModelHandler.getMailboxAvailableModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(1687553024, GlobalTelephoneStateModelHandler.getHandsfreeModeModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-1198193664, GlobalTelephoneStateModelHandler.getMultipartyActiveModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-2137652224, GlobalTelephoneStateModelHandler.getMultipartySupportedModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(1385497600, GlobalTelephoneStateModelHandler.getTelModeChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetLabelModel(1637352448, GlobalTelephoneStateModelHandler.getBluetoothFriendlyName(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(4091, GlobalTelephoneStateModelHandler.getPhoneReadyModelValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-560528384, GlobalTelephoneStateModelHandler.getConferenceInStateActiveChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-526973952, GlobalTelephoneStateModelHandler.getConferenceInStateHeldChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-543751168, GlobalTelephoneStateModelHandler.getConferenceInStateHeldOrActiveChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(4346, GlobalTelephoneStateModelHandler.getMicMuteChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(1201079296, GlobalTelephoneStateModelHandler.getOutgoingCallChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(-1164573696, GlobalTelephoneStateModelHandler.getActiveCallChoiceValue(iTelDSIMobileEquipmentDeviceState, this.lastState));
        this.groupAndSetChoiceModel(-1885928448, GlobalTelephoneStateModelHandler.getActiveCallChoiceValue(iTelDSIMobileEquipmentDeviceState, this.lastState));
        this.groupAndSetChoiceModel(4403, GlobalTelephoneStateModelHandler.getTelFeatInbandRingingChoiceValue(iTelDSIMobileEquipmentDeviceState));
    }

    private void setAssociatedDeviceModels(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelTextFactory iTelTextFactory) {
        this.groupAndSetChoiceModel(-1349057536, GlobalTelephoneStateModelHandler.getTelModeChoiceValue(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetLabelModel(-1701379072, GlobalTelephoneStateModelHandler.getBluetoothFriendlyName(iTelDSIMobileEquipmentDeviceState));
        this.groupAndSetChoiceModel(4350, GlobalTelephoneStateModelHandler.getPhoneReadyModelValue(iTelDSIMobileEquipmentDeviceState));
    }

    private void setDataDeviceModels(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.groupAndSetChoiceModel(513278976, GlobalTelephoneStateModelHandler.getTelModeChoiceValue(iGlobalTelephoneStateStruct.getDataOnlyNadDeviceState()));
    }

    private void setEmergencyCallModels(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.groupAndSetChoiceModel(76874752, GlobalTelephoneStateModelHandler.getEmergencyCallChoiceValue(iGlobalTelephoneStateStruct));
    }

    private void setNADDeviceModels(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        this.groupAndSetLabelModel(1721238528, GlobalTelephoneStateModelHandler.getNadIMEI(iTelDSIMobileEquipmentDeviceState));
    }

    private void setGlobalModels(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, ITelTextFactory iTelTextFactory) {
        this.groupAndSetChoiceModel(494, GlobalTelephoneStateModelHandler.getNadModeChoiceModelValue(iGlobalTelephoneStateStruct));
        this.groupAndSetChoiceModel(186, GlobalTelephoneStateModelHandler.getPhoneReady2PhoneChoiceValue(iGlobalTelephoneStateStruct.getCallLeadingDevice()));
        this.groupAndSetLabelModel(-90766336, GlobalTelephoneStateModelHandler.getNadUserFriendlyNameLabelText(iGlobalTelephoneStateStruct.getNadInstanceState(), iTelTextFactory.getText(13)));
        this.groupAndSetChoiceModel(4423, GlobalTelephoneStateModelHandler.getNadRoleChoiceValue(iGlobalTelephoneStateStruct.getNadInstanceState()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        Object object = this.lock;
        synchronized (object) {
            this.lastState = iGlobalTelephoneStateStruct;
            this.refreshModelValues();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void refreshModelValues() {
        Object object = this.lock;
        synchronized (object) {
            if (this.lastState != null) {
                this.setGlobalModels(this.lastState, this.textFactory);
                this.setCallLeadingDeviceModels(this.lastState.getCallLeadingDevice());
                this.setNonCallLeadingDeviceModels(this.lastState.getNonCallLeadingDevice());
                this.setPrimaryDeviceModels(this.lastState.getPrimaryDeviceState(), this.textFactory);
                this.setAssociatedDeviceModels(this.lastState.getAssociatedDeviceState(), this.textFactory);
                this.setDataDeviceModels(this.lastState);
                this.setNADDeviceModels(this.lastState.getNadInstanceState());
                this.setEmergencyCallModels(this.lastState);
                this.flushModels();
            }
        }
    }

    static /* synthetic */ void access$000(GlobalTelephoneStateModelHandler globalTelephoneStateModelHandler) {
        globalTelephoneStateModelHandler.refreshModelValues();
    }
}

