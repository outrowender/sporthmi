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
    private static final int PHONEMODULESTATE_SWITCHING_ON;
    private static final int PHONEMODULESTATE_SWITCHING_OFF;
    private static final int PHONEMODULESTATE_ON;
    private static final int PHONEMODULESTATE_OFF_TEMP;
    private static final int PHONEMODULESTATE_OFF_DIAG;
    private static final int PHONEMODULESTATE_OFF;
    private static final int PHONEMODULESTATE_NOT_FUNCTION;
    private static final int PHONEMODULESTATE_N_A;
    private static final int PHONEMODULESTATE_INIT;
    protected static final int ACTIVATIONSTATE_INIT;
    protected static final int ACTIVATIONSTATE_NOT_ATTACHED;
    protected static final int ACTIVATIONSTATE_TEL_ACTIVE_CALL;
    protected static final int ACTIVATIONSTATE_PHONE_OFF;
    protected static final int ACTIVATIONSTATE_PHONE_ON;
    protected static final int ACTIVATIONSTATE_ATTACHED_NOT_READY;
    protected static final int ACTIVATIONSTATE_ATTACHED_NOT_FUNC;
    protected static final int ACTIVATIONSTATE_ME_RECONNECT;
    private static final int FEATURE_NOT_SUPPORTED;
    private static final int FEATURE_SUPPORTED;
    protected static final int POWERMODEL_UNKNOWN;
    protected static final int POWERMODEL_PHONE_NOT_INSTALLED;
    protected static final int POWERMODEL_PHONE_INIT_WAIT;
    protected static final int POWERMODEL_PHONE_OFF;
    protected static final int POWERMODEL_PHONE_NOT_CONNECTED;
    protected static final int POWERMODEL_SIM_NOT_ATTACHED;
    protected static final int POWERMODEL_PHONE_NOT_FUNCTIONAL;
    protected static final int POWERMODEL_PHONE_ME_OFF;
    protected static final int POWERMODEL_PHONE_TEMPERATURE_OFF;
    protected static final int POWERMODEL_PHONE_ON;
    protected static final int POWERMODEL_PHONE_RECONNECT;
    protected static final int POWERMODEL_NO_ME_IN_CRADLE;
    protected static final int POWERMODEL_NAD_NOT_FUNC;
    protected static final int POWERMODEL_DIAGNOSE_NOT_ON_ALLOWED;
    protected static final int POWERMODEL_PHONE_SWITCHING_ON_OFF;

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
        return new StringBuffer().append("model ").append(n).append(" not a power state choice!").toString();
    }

    public TelActivationStateHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            if (n == 0xD000400 || n == 0x3000100 || n == 0x3000300 || n == 0x3000200 || n == 0x3000400) {
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
            telModelGroup.add(this.getChoiceModel(798426112));
            int n = activationStateStruct.getTelActivationState();
            int n2 = iGlobalTelephoneStateStruct.getPhoneModuleState();
            int n3 = activationStateStruct.getTelMode();
            this.setPowerStateChoice(n, n2, n3, true, this.getDataNadPowerStateChoice());
            this.getChoiceModel(798426112).setValue(this.getPhoneModuleChoiceValue(n2));
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
            telModelGroup.add(this.getChoiceModel(-1114373120));
            telModelGroup.add(this.getChoiceModel(630522880));
            telModelGroup.add(this.getChoiceModel(647300096));
            telModelGroup.add(this.getChoiceModel(664077312));
            telModelGroup.add(this.getChoiceModel(680854528));
            telModelGroup.add(this.getChoiceModel(697631744));
            telModelGroup.add(this.getChoiceModel(714408960));
            telModelGroup.add(this.getChoiceModel(-409598976));
            int n = activationStateStruct.getTelActivationState();
            int n2 = iGlobalTelephoneStateStruct.getPhoneModuleState();
            int n3 = activationStateStruct.getTelMode();
            boolean bl = iGlobalTelephoneStateStruct.getTopology() != null ? iGlobalTelephoneStateStruct.getTopology().isInitState() : false;
            boolean bl2 = this.getApplication().getFrameworkAccess().getSysConstManager().getAdaptationANP().getESIMUUsage() == 2;
            boolean bl3 = this.getApplication().getFrameworkAccess().getSysConstManager().getSysConst(463) == 1;
            this.setTelephonePowerStateChoice(n, n2, n3, bl3, iGlobalTelephoneStateStruct.getNadMode(), bl, this.getPowerStateChoice(), iGlobalTelephoneStateStruct.isSimCardInserted(), bl2, iGlobalTelephoneStateStruct.isESIMActive());
            this.getChoiceModel(-1181350912).setValue(this.getActivationStateChoiceValue(n));
            this.getChoiceModel(-1114373120).setValue(this.getPhoneModuleChoiceValue(n2));
            this.getChoiceModel(630522880).setValue(iGlobalTelephoneStateStruct.isThreeWaySupported() ? 1 : 0);
            this.getChoiceModel(647300096).setValue(iGlobalTelephoneStateStruct.isAddToConferenceSupported() ? 1 : 0);
            this.getChoiceModel(664077312).setValue(iGlobalTelephoneStateStruct.isEnhancedCallFeaturesSupported() ? 1 : 0);
            this.getChoiceModel(680854528).setValue(iGlobalTelephoneStateStruct.isEnhancedStatSupported() ? 1 : 0);
            this.getChoiceModel(-409598976).setValue(iGlobalTelephoneStateStruct.isEnhancedConferenceTransferSupported() ? 1 : 0);
            this.getChoiceModel(697631744).setValue(iGlobalTelephoneStateStruct.inbandRingingSupported() ? 1 : 0);
            this.getChoiceModel(714408960).setValue(iGlobalTelephoneStateStruct.isResponseAndHoldSupported() ? 1 : 0);
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
            this.setTelephonePowerStateChoice(n, n2, n3, bl3, iGlobalTelephoneStateStruct.getNadMode(), bl, this.getChoiceModel(-1718156288), iGlobalTelephoneStateStruct.isSimCardInserted(), bl2, iGlobalTelephoneStateStruct.isESIMActive());
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
        this.log.log(-1601830656, "[TelActivationStateHandler#getActivationStateChoiceValue] unknown activation state %1", (long)n);
        return -1;
    }

    protected ChoiceModelApp getPowerStateChoice() {
        return this.getChoiceModel(-1013709824);
    }

    protected ChoiceModelApp getDataNadPowerStateChoice() {
        return this.getChoiceModel(1184236544);
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
            this.log.log(1078071040, "[TelActivationStateHandler#setPowerStateChoice] %1", (Object)buffer);
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
            this.log.log(1078071040, "[TelActivationStateHandler#setTelephonePowerStateChoice] %1", (Object)buffer);
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

