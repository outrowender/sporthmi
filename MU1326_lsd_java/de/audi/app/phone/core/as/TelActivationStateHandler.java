/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.as;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public class TelActivationStateHandler
extends AbstractPhoneComponent {
    private static final int PHONEMODULESTATE_SWITCHING_ON = 7;
    private static final int PHONEMODULESTATE_SWITCHING_OFF = 8;
    private static final int PHONEMODULESTATE_ON = 1;
    private static final int PHONEMODULESTATE_OFF_TEMP = 3;
    private static final int PHONEMODULESTATE_OFF_DIAG = 4;
    private static final int PHONEMODULESTATE_OFF = 0;
    private static final int PHONEMODULESTATE_NOT_FUNCTION = 5;
    private static final int PHONEMODULESTATE_N_A = 2;
    private static final int PHONEMODULESTATE_INIT = 6;
    protected static final int ACTIVATIONSTATE_INIT = 0;
    protected static final int ACTIVATIONSTATE_NOT_ATTACHED = 1;
    protected static final int ACTIVATIONSTATE_TEL_ACTIVE_CALL = 2;
    protected static final int ACTIVATIONSTATE_PHONE_OFF = 3;
    protected static final int ACTIVATIONSTATE_PHONE_ON = 4;
    protected static final int ACTIVATIONSTATE_ATTACHED_NOT_READY = 5;
    protected static final int ACTIVATIONSTATE_ATTACHED_NOT_FUNC = 6;
    protected static final int ACTIVATIONSTATE_ME_RECONNECT = 7;
    private static final int FEATURE_NOT_SUPPORTED = 0;
    private static final int FEATURE_SUPPORTED = 1;
    protected static final int POWERMODEL_UNKNOWN = -1;
    protected static final int POWERMODEL_PHONE_NOT_INSTALLED = 1;
    protected static final int POWERMODEL_PHONE_INIT_WAIT = 2;
    protected static final int POWERMODEL_PHONE_OFF = 3;
    protected static final int POWERMODEL_PHONE_NOT_CONNECTED = 4;
    protected static final int POWERMODEL_SIM_NOT_ATTACHED = 5;
    protected static final int POWERMODEL_PHONE_NOT_FUNCTIONAL = 6;
    protected static final int POWERMODEL_PHONE_ME_OFF = 7;
    protected static final int POWERMODEL_PHONE_TEMPERATURE_OFF = 8;
    protected static final int POWERMODEL_PHONE_ON = 9;
    protected static final int POWERMODEL_PHONE_RECONNECT = 10;
    protected static final int POWERMODEL_NO_ME_IN_CRADLE = 11;
    protected static final int POWERMODEL_NAD_NOT_FUNC = 12;
    protected static final int POWERMODEL_DIAGNOSE_NOT_ON_ALLOWED = 13;
    protected static final int POWERMODEL_PHONE_SWITCHING_ON_OFF = 14;

    private static String getPowerStateChoiceName(int n) {
        switch (n) {
            case 300227: {
                return "POWER_STATE_CHOICE";
            }
            case 300614: {
                return "DATA_NAD_POWER_STATE_CHOICE";
            }
            case 300953: {
                return "POWER_STATE_ASSOCIATED_CHOICE";
            }
        }
        return "model " + n + " not a power state choice!";
    }

    public TelActivationStateHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            if (n == 262157 || n == 65539 || n == 196611 || n == 131075 || n == 262147) {
                this.updateModels(iGlobalTelephoneStateStruct);
                this.updateDataNadModels(iGlobalTelephoneStateStruct);
                this.updateAssociatedPhoneModels(iGlobalTelephoneStateStruct);
            }
        } else {
            this.log.log(10000, "TelActivationStateHandler#updateGlobalTelephoneStateProperty stateStruct is null");
        }
    }

    private void updateDataNadModels(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationStateDSINAD() != null) {
            ActivationStateStruct activationStateStruct = iGlobalTelephoneStateStruct.getActivationStateDSINAD();
            TelModelGroup telModelGroup = new TelModelGroup("TelActivationStateHandler#updateDataNadModels", this.log);
            telModelGroup.add(this.getDataNadPowerStateChoice());
            telModelGroup.add(this.getChoiceModel(300847));
            int n = activationStateStruct.getTelActivationState();
            int n2 = iGlobalTelephoneStateStruct.getPhoneModuleState();
            int n3 = activationStateStruct.getTelMode();
            this.setPowerStateChoice(n, n2, n3, true, this.getDataNadPowerStateChoice());
            this.getChoiceModel(300847).setValue(this.getPhoneModuleChoiceValue(n2));
            telModelGroup.flush();
        } else {
            this.log.log(10000, "TelActivationStateHandler#updateDataNadModels stateStruct or activation state is null");
        }
    }

    private void updateModels(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationState() != null) {
            ActivationStateStruct activationStateStruct = iGlobalTelephoneStateStruct.getActivationState();
            TelModelGroup telModelGroup = new TelModelGroup("TelActivationStateHandler#updateModels", this.log);
            telModelGroup.add(this.getPowerStateChoice());
            telModelGroup.add(this.getChoiceModel(300221));
            telModelGroup.add(this.getChoiceModel(300325));
            telModelGroup.add(this.getChoiceModel(300326));
            telModelGroup.add(this.getChoiceModel(300327));
            telModelGroup.add(this.getChoiceModel(300328));
            telModelGroup.add(this.getChoiceModel(300329));
            telModelGroup.add(this.getChoiceModel(300330));
            telModelGroup.add(this.getChoiceModel(300775));
            int n = activationStateStruct.getTelActivationState();
            int n2 = iGlobalTelephoneStateStruct.getPhoneModuleState();
            int n3 = activationStateStruct.getTelMode();
            boolean bl = iGlobalTelephoneStateStruct.getTopology() != null ? iGlobalTelephoneStateStruct.getTopology().isInitState() : false;
            boolean bl2 = this.getApplication().getFrameworkAccess().getSysConstManager().getAdaptationANP().getESIMUUsage() == 2;
            boolean bl3 = this.getApplication().getFrameworkAccess().getSysConstManager().getSysConst(463) == 1;
            this.setTelephonePowerStateChoice(n, n2, n3, bl3, iGlobalTelephoneStateStruct.getNadMode(), bl, this.getPowerStateChoice(), iGlobalTelephoneStateStruct.isSimCardInserted(), bl2, iGlobalTelephoneStateStruct.isESIMActive());
            this.getChoiceModel(300729).setValue(this.getActivationStateChoiceValue(n));
            this.getChoiceModel(300221).setValue(this.getPhoneModuleChoiceValue(n2));
            this.getChoiceModel(300325).setValue(iGlobalTelephoneStateStruct.isThreeWaySupported() ? 1 : 0);
            this.getChoiceModel(300326).setValue(iGlobalTelephoneStateStruct.isAddToConferenceSupported() ? 1 : 0);
            this.getChoiceModel(300327).setValue(iGlobalTelephoneStateStruct.isEnhancedCallFeaturesSupported() ? 1 : 0);
            this.getChoiceModel(300328).setValue(iGlobalTelephoneStateStruct.isEnhancedStatSupported() ? 1 : 0);
            this.getChoiceModel(300775).setValue(iGlobalTelephoneStateStruct.isEnhancedConferenceTransferSupported() ? 1 : 0);
            this.getChoiceModel(300329).setValue(iGlobalTelephoneStateStruct.inbandRingingSupported() ? 1 : 0);
            this.getChoiceModel(300330).setValue(iGlobalTelephoneStateStruct.isResponseAndHoldSupported() ? 1 : 0);
            telModelGroup.flush();
        } else {
            this.log.log(10000, "TelActivationStateHandler#updateModels stateStruct or activation state is null");
        }
    }

    private void updateAssociatedPhoneModels(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationStateAssociated() != null) {
            ActivationStateStruct activationStateStruct = iGlobalTelephoneStateStruct.getActivationStateAssociated();
            int n = activationStateStruct.getTelActivationState();
            int n2 = iGlobalTelephoneStateStruct.getPhoneModuleState();
            int n3 = activationStateStruct.getTelMode();
            boolean bl = iGlobalTelephoneStateStruct.getTopology() != null ? iGlobalTelephoneStateStruct.getTopology().isInitState() : false;
            boolean bl2 = this.getApplication().getFrameworkAccess().getSysConstManager().getAdaptationANP().getESIMUUsage() == 2;
            boolean bl3 = this.getApplication().getFrameworkAccess().getSysConstManager().getSysConst(463) == 1;
            this.setTelephonePowerStateChoice(n, n2, n3, bl3, iGlobalTelephoneStateStruct.getNadMode(), bl, this.getChoiceModel(300953), iGlobalTelephoneStateStruct.isSimCardInserted(), bl2, iGlobalTelephoneStateStruct.isESIMActive());
        } else {
            this.log.log(10000, "TelActivationStateHandler#updateAssociatedPhoneModels stateStruct or activation state is null");
        }
    }

    private int getActivationStateChoiceValue(int n) {
        switch (n) {
            case 9: {
                return 6;
            }
            case 7: {
                return 5;
            }
            case 0: {
                return 0;
            }
            case 12: {
                return 7;
            }
            case 1: {
                return 1;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 2: {
                return 2;
            }
        }
        this.log.log(100000, "[TelActivationStateHandler#getActivationStateChoiceValue] unknown activation state %1", (long)n);
        return -1;
    }

    protected ChoiceModelApp getPowerStateChoice() {
        return this.getChoiceModel(300227);
    }

    protected ChoiceModelApp getDataNadPowerStateChoice() {
        return this.getChoiceModel(300614);
    }

    protected int getPhoneModuleChoiceValue(int n) {
        switch (n) {
            case 6: {
                return 6;
            }
            case 0: {
                return 2;
            }
            case 5: {
                return 5;
            }
            case 3: {
                return 0;
            }
            case 4: {
                return 4;
            }
            case 1: {
                return 3;
            }
            case 2: {
                return 1;
            }
            case 8: {
                return 8;
            }
            case 7: {
                return 7;
            }
        }
        return n == 2 ? 1 : 0;
    }

    protected void setPowerStateChoice(int n, int n2, int n3, boolean bl, ChoiceModelApp choiceModelApp) {
        int n4 = -1;
        if (n2 == 8 || n2 == 7) {
            n4 = 14;
        } else {
            block0 : switch (n) {
                case 0: 
                case 7: {
                    n4 = 2;
                    break;
                }
                case 1: 
                case 4: {
                    switch (n2) {
                        case 2: {
                            n4 = 5;
                            break block0;
                        }
                        case 0: {
                            n4 = 4;
                            break block0;
                        }
                        case 1: {
                            n4 = 8;
                            break block0;
                        }
                        case 5: {
                            n4 = 12;
                            break block0;
                        }
                        case 4: {
                            n4 = 13;
                            break block0;
                        }
                        case 3: {
                            n4 = 3;
                            break block0;
                        }
                        case 6: {
                            n4 = 2;
                            break block0;
                        }
                    }
                    n4 = -1;
                    break;
                }
                case 2: 
                case 5: {
                    n4 = 9;
                    break;
                }
                case 9: {
                    n4 = 6;
                    break;
                }
                case 12: {
                    n4 = 10;
                    break;
                }
                default: {
                    n4 = -1;
                }
            }
        }
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("telActivationState=");
            buffer.append(n);
            buffer.append(", ");
            buffer.append("telPhoneModuleState=");
            buffer.append(n2);
            buffer.append(", ");
            buffer.append("telMode=");
            buffer.append(n3);
            buffer.append(", ");
            buffer.append("isDSINAD=");
            buffer.append(bl);
            buffer.append(" --> ");
            buffer.append(TelActivationStateHandler.getPowerStateChoiceName(choiceModelApp.getID()));
            buffer.append("=");
            buffer.append(n4);
            this.log.log(1000000, "[TelActivationStateHandler#setPowerStateChoice] %1", (Object)buffer);
        }
        choiceModelApp.setValue(n4);
    }

    protected void setTelephonePowerStateChoice(int n, int n2, int n3, boolean bl, int n4, boolean bl2, ChoiceModelApp choiceModelApp, boolean bl3, boolean bl4, boolean bl5) {
        int n5 = -1;
        if (bl2) {
            n5 = 2;
        } else if ((n2 == 8 || n2 == 7) && n3 != 3) {
            n5 = 14;
        } else {
            switch (n) {
                case 0: 
                case 7: {
                    n5 = 2;
                    break;
                }
                case 1: 
                case 4: {
                    int n6 = n4 == 2 ? 0 : n2;
                    n5 = this.computePowerStateForPhoneOff(bl, bl3, bl4, bl5, n6);
                    break;
                }
                case 2: 
                case 5: {
                    n5 = 9;
                    break;
                }
                case 9: {
                    n5 = 6;
                    break;
                }
                case 12: {
                    n5 = 10;
                    break;
                }
                default: {
                    n5 = -1;
                }
            }
        }
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("telActivationState=");
            buffer.append(n);
            buffer.append(", ");
            buffer.append("telPhoneModuleState=");
            buffer.append(n2);
            buffer.append(", ");
            buffer.append("telMode=");
            buffer.append(n3);
            buffer.append(", ");
            buffer.append("isNadCoded=");
            buffer.append(bl);
            buffer.append(", ");
            buffer.append("nadMode=");
            buffer.append(n4);
            buffer.append(" --> ");
            buffer.append(TelActivationStateHandler.getPowerStateChoiceName(choiceModelApp.getID()));
            buffer.append("=");
            buffer.append(n5);
            this.log.log(1000000, "[TelActivationStateHandler#setTelephonePowerStateChoice] %1", (Object)buffer);
        }
        choiceModelApp.setValue(n5);
    }

    private int computePowerStateForPhoneOff(boolean bl, boolean bl2, boolean bl3, boolean bl4, int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = bl ? (bl2 ? 4 : 5) : 4;
                break;
            }
            case 0: {
                n2 = bl ? (bl3 ? 4 : (bl2 && !bl4 ? 4 : 5)) : 4;
                break;
            }
            case 1: {
                n2 = 8;
                break;
            }
            case 5: {
                n2 = 12;
                break;
            }
            case 4: {
                n2 = 13;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 6: {
                n2 = 2;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }
}

