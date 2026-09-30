/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.network;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class NetworkStateHandler
extends AbstractPhoneComponent {
    protected static final int REGISTERSTATE_UNKNOWN = 0;
    protected static final int REGISTERSTATE_REGISTERED = 1;
    protected static final int REGISTERSTATE_ROAMING = 2;
    protected static final int REGISTERSTATE_SEARCHING = 3;
    protected static final int REGISTERSTATE_NOT_SEARCHING = 4;
    protected static final int REGISTERSTATE_DENIED = 5;
    protected static final int ROAMING_NO = 0;
    protected static final int ROAMING_YES = 1;
    protected static final int SIGNAL_QUALITY_INVALID = 255;
    protected static final int SIGNAL_QUALITY_CHOICE_NONE = 0;
    protected static final int SIGNAL_QUALITY_CHOICE_0 = 1;
    protected static final int SIGNAL_QUALITY_CHOICE_1 = 2;
    protected static final int SIGNAL_QUALITY_CHOICE_2 = 3;
    protected static final int SIGNAL_QUALITY_CHOICE_3 = 4;
    protected static final int SIGNAL_QUALITY_CHOICE_4 = 5;
    protected static final int SIGNAL_QUALITY_CHOICE_5 = 6;
    protected static final int SIGNAL_QUALITY_CHOICE_DENIED = 7;
    protected static final int PHONE_DATA_RATE_UNDEFINED = 0;
    protected static final int PHONE_DATA_RATE_GSM = 1;
    protected static final int PHONE_DATA_RATE_UMTS = 2;
    protected static final int PHONE_DATA_RATE_LTE = 3;

    private static void setRegisterStateChoice(ChoiceModelApp choiceModelApp, int n, int n2) {
        if (n2 == 0 && n != 5) {
            choiceModelApp.setValue(3);
            return;
        }
        switch (n) {
            case 5: {
                choiceModelApp.setValue(5);
                break;
            }
            case 4: {
                choiceModelApp.setValue(4);
                break;
            }
            case 1: {
                choiceModelApp.setValue(1);
                break;
            }
            case 2: {
                choiceModelApp.setValue(2);
                break;
            }
            case 3: {
                choiceModelApp.setValue(3);
                break;
            }
            default: {
                choiceModelApp.setValue(0);
            }
        }
    }

    private static void setRoamingChoice(ChoiceModelApp choiceModelApp, int n) {
        if (n == 2) {
            choiceModelApp.setValue(1);
        } else {
            choiceModelApp.setValue(0);
        }
    }

    private static void setNetworkTypeChoice(ChoiceModelApp choiceModelApp, int n) {
        switch (n) {
            case 1: {
                choiceModelApp.setValue(1);
                break;
            }
            case 4: {
                choiceModelApp.setValue(2);
                break;
            }
            case 5: {
                choiceModelApp.setValue(3);
                break;
            }
            default: {
                choiceModelApp.setValue(0);
            }
        }
    }

    private static void setSignalQualityChoice(ChoiceModelApp choiceModelApp, int n, int n2) {
        int n3 = 0;
        n3 = n == 5 ? 7 : (n == 3 ? 1 : (n2 == 255 ? 0 : (n2 == 0 ? 1 : (n2 <= 20 ? 2 : (n2 <= 40 ? 3 : (n2 <= 60 ? 4 : (n2 <= 80 ? 5 : 6)))))));
        choiceModelApp.setValue(n3);
    }

    public NetworkStateHandler(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.updateDataNetworkIcons(n, iGlobalTelephoneStateStruct);
        this.updateSignalQualityIcon(n, iGlobalTelephoneStateStruct);
        this.updateRegisterState(n, iGlobalTelephoneStateStruct);
        this.updateRegisterStateDSINAD(n, iGlobalTelephoneStateStruct);
    }

    private void updateDataNetworkIcons(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (this.isDataNetworkAllowed(n, iGlobalTelephoneStateStruct)) {
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNadInstanceState();
            ChoiceModelApp choiceModelApp = this.getChoiceModel(183);
            ChoiceModelApp choiceModelApp2 = this.getChoiceModel(3897);
            if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.isPhoneReady() && (iTelDSIMobileEquipmentDeviceState.getTelMode() == 0 || iTelDSIMobileEquipmentDeviceState.getTelMode() == 2 || iTelDSIMobileEquipmentDeviceState.getTelMode() == 1)) {
                this.log.log(10000000, "NetworkStateHandler#updateDataNetworkIcons(): Data device IS ready");
                int n2 = iTelDSIMobileEquipmentDeviceState.getRegisterState() != null ? iTelDSIMobileEquipmentDeviceState.getRegisterState().getTelRegisterState() : 0;
                int n3 = iTelDSIMobileEquipmentDeviceState.getSignalQuality();
                this.setDataNadSignalQualityChoice(n3, n2);
                NetworkStateHandler.setNetworkTypeChoice(choiceModelApp, iTelDSIMobileEquipmentDeviceState.getNetworkType());
                this.log.log(10000000, "[NetworkStateHandler#setDataNadSignalQualityChoice] registerState=%1, signalQuality=%2, --> value=%3", (long)n2, (long)n3, (long)choiceModelApp2.getValue());
            } else {
                this.log.log(10000000, "NetworkStateHandler#updateDataNetworkIcons(): Data device IS NOT ready");
                this.setDataNadSignalQualityChoice(255, 0);
                NetworkStateHandler.setNetworkTypeChoice(choiceModelApp, 0);
                this.log.log(10000000, "[NetworkStateHandler#setDataNadSignalQualityChoice] No nad phone ready, setting value to %1", (long)choiceModelApp2.getValue());
            }
        }
    }

    private boolean isDataNetworkAllowed(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && (n == 196630 || n == 196633 || n == 196611 || n == 196623 || n == 196628 || n == 65558 || n == 65561 || n == 65539 || n == 65551 || n == 65556 || n == 131094 || n == 131097 || n == 131075 || n == 131087 || n == 131092);
    }

    private void setDataNadSignalQualityChoice(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(3897);
        NetworkStateHandler.setSignalQualityChoice(choiceModelApp, n2, n);
    }

    private void updateSignalQualityIcon(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && (n == 65561 || n == 65558 || n == 65539 || n == 65551)) {
            ChoiceModelApp choiceModelApp = this.getChoiceModel(346);
            if (iGlobalTelephoneStateStruct.isPhoneReady() && this.checkVariantSpecificConditions(iGlobalTelephoneStateStruct.getTelMode())) {
                this.log.log(10000000, "[NetworkStateHandler#updateSignalQualityIcon] The phone IS ready");
                int n2 = iGlobalTelephoneStateStruct.getSignalQuality();
                int n3 = iGlobalTelephoneStateStruct.getRegisterState() != null ? iGlobalTelephoneStateStruct.getRegisterState().getTelRegisterState() : 0;
                this.log.log(10000000, "NetworkStateHandler#setSignalQualityChoice(): registerState %1, signalQuality %2", (long)n3, (long)n2);
                NetworkStateHandler.setSignalQualityChoice(choiceModelApp, n3, n2);
                this.log.log(10000000, "[NetworkStateHandler#updateSignalQualityIcon] registerState=%1, signalQuality=%2, --> value=%3", (long)n3, (long)n2, (long)choiceModelApp.getValue());
            } else {
                this.log.log(10000000, "[NetworkStateHandler#updateSignalQualityIcon] The phone IS NOT ready, SIGNALQUALITY_INVALID");
                NetworkStateHandler.setSignalQualityChoice(choiceModelApp, 0, 255);
                this.log.log(10000000, "[NetworkStateHandler#updateSignalQualityIcon] No phone ready, setting value to %1", (long)choiceModelApp.getValue());
            }
        }
    }

    private boolean checkVariantSpecificConditions(int n) {
        boolean bl;
        boolean bl2 = bl = this.getApplication().getFrameworkAccess().getSysConstManager().getSysConst(4168) == 7 || this.getApplication().getFrameworkAccess().getSysConstManager().getSysConst(4168) == 5;
        if (bl) {
            return true;
        }
        return n == 3;
    }

    private void updateRegisterState(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getRegisterState() != null && (n == 65561 || n == 65558 || n == 65539 || n == 65551)) {
            int n2 = iGlobalTelephoneStateStruct.getSignalQuality();
            int n3 = iGlobalTelephoneStateStruct.getRegisterState().getTelRegisterState();
            if (iGlobalTelephoneStateStruct.isPhoneReady()) {
                NetworkStateHandler.setRegisterStateChoice(this.getChoiceModel(3889), n3, n2);
                NetworkStateHandler.setRoamingChoice(this.getChoiceModel(3860), n3);
            } else {
                NetworkStateHandler.setRegisterStateChoice(this.getChoiceModel(3889), 0, 255);
                NetworkStateHandler.setRoamingChoice(this.getChoiceModel(3860), 0);
            }
        }
    }

    private void updateRegisterStateDSINAD(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null && iGlobalTelephoneStateStruct.getNadInstanceState().getRegisterState() != null && (n == 196630 || n == 196611 || n == 196623 || n == 65558 || n == 65539 || n == 65551 || n == 131094 || n == 131075 || n == 131087)) {
            int n2 = iGlobalTelephoneStateStruct.getNadInstanceState().getRegisterState().getTelRegisterState();
            NetworkStateHandler.setRoamingChoice(this.getChoiceModel(3899), n2);
        }
    }
}

