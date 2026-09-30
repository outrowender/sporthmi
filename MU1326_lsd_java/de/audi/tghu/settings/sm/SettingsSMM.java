/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.settings.sm.SettingsSMMActions;
import de.audi.tghu.settings.sm.SettingsSMMInitMediators;
import de.audi.tghu.settings.sm.SettingsSMMInitStates;
import de.audi.tghu.settings.sm.SettingsSMMInitTransitions;
import java.util.NoSuchElementException;

public class SettingsSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 11;
    public static final String SMM_NAME = "SettingsSMM";
    private SettingsSMMInitStates smmInitStates;
    private SettingsSMMInitTransitions smmInitTransitions;
    private SettingsSMMInitMediators smmInitMediators;
    private SettingsSMMActions smmActions;

    public SettingsSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 11, SMM_NAME);
    }

    public SettingsSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 11, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new SettingsSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new SettingsSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new SettingsSMMInitMediators(this, this.logChannel);
        this.smmActions = new SettingsSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 1100128;
        this.popupIDList = EMPTY_INT_LIST;
        this.popupPriorityList = EMPTY_INT_LIST;
        this.popupTopLevelStateIDList = EMPTY_INT_LIST;
        this.popupZPMPriorityList = EMPTY_INT_LIST;
        this.popupZPMSlotList = EMPTY_INT_LIST;
        this.extStateIDList = new int[]{1100160, 1100124, 1100155, 1100159, 1100147, 1100151, 1100148, 1100130, 1100128, 1100132};
        this.extStateLabelList = new String[]{"settingsTime", "SDS_settingsSDSTrainingError_Comp", "settingsSdsTrainingStart", "settingsSystemComp", "settingsRSEMain", "settingsSdsTrainingEnd", "settingsSds", "settingsDesktopCustDownloadContext", "settingsDesktop", "settingsFactory"};
        this.incSlotList = new int[]{1100120, 1100121, 1100122, 1100123, 1100129, 1100161, 1100180};
        this.incSlotStateIDList = new int[]{-3, -4, 1100132, -5, -6, 1100160, -7};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "popupHelpBordbuch", "connectivityCenter", "toneCenerSdsSliderGreyOut", "settingsCustomerUpdate", "toneWCVolume"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 1100248: {
                    this.logCheckGuard("( ChoiceModel (MODELID#1100143) Value > 1 ) || ( ChoiceModel (MODELID#1100136) Value > 1 )");
                    return ((ChoiceModel)this.getModel(1100143)).getValue() > 1 || ((ChoiceModel)this.getModel(1100136)).getValue() > 1;
                }
                case 1100260: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#4013) Value == 1");
                            return ((ChoiceModel)this.getModel(4013)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100276: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4528) Value == 0 )");
                            return ((ChoiceModel)this.getModel(4528)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100303: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#375) Value == 1 ) && ( !( ChoiceModel (MODELID#543) Value == 1 ) ) && ( !( ChoiceModel (MODELID#107) Value > 2 ) )");
                            return ((ChoiceModel)this.getModel(375)).getValue() == 1 && ((ChoiceModel)this.getModel(543)).getValue() != 1 && ((ChoiceModel)this.getModel(107)).getValue() <= 2;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100313: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#377) Value == 1");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100315: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#377) Value == 1");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100318: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#4013) Value == 1");
                            return ((ChoiceModel)this.getModel(4013)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100333: {
                    this.logCheckGuard("( ChoiceModel (MODELID#1100183) Value == 0 ) || ( ChoiceModel (MODELID#1100189) Value == 1 )");
                    return ((ChoiceModel)this.getModel(1100183)).getValue() == 0 || ((ChoiceModel)this.getModel(1100189)).getValue() == 1;
                }
                case 1100337: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1100187) Value == 0");
                            return ((ChoiceModel)this.getModel(1100187)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100349: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( SysConstModel (MODELID#523) Value == 0 ) || ( ChoiceModel (MODELID#1100225) Status == 0 )");
                            return ((SysConstModel)this.getModel(523)).getValue() == 0 || ((ChoiceModel)this.getModel(1100225)).getStatus() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100351: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#1100228) Value == 0 ) && ( SysConstModel (MODELID#4547) Value == ICoreSysConfig.ON )");
                            return ((ChoiceModel)this.getModel(1100228)).getValue() == 0 && ((SysConstModel)this.getModel(4547)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100352: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#1100228) Value == 0 ) && ( SysConstModel (MODELID#4547) Value == ICoreSysConfig.ON )");
                            return ((ChoiceModel)this.getModel(1100228)).getValue() == 0 && ((SysConstModel)this.getModel(4547)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100357: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#377) Value == 1 ) && ( ChoiceModel (MODELID#1000019) Value == 1 )");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1 && ((ChoiceModel)this.getModel(1000019)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100359: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#377) Value == 1 ) && ( ChoiceModel (MODELID#1000019) Value == 1 )");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1 && ((ChoiceModel)this.getModel(1000019)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1100361: {
                    this.logCheckGuard("( ChoiceModel (MODELID#5601) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                    return ((ChoiceModel)this.getModel(5601)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
                }
                case 1100362: {
                    this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5600) Value == 1 ) ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#8) Value == 7 )");
                    return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5600)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(8)).getValue() == 7;
                }
            }
            return false;
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[SettingsSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[SettingsSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[SettingsSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[SettingsSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public void execSDForState(TTSASR tTSASR, ITTSASRContext iTTSASRContext, int n) {
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        this.smmActions.execFocusGainedAction(sMServices, n);
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        this.smmActions.execFocusLostAction(sMServices, n);
    }

    public void execExitAction(SMServices sMServices, int n) {
        this.smmActions.execExitAction(sMServices, n);
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        this.smmActions.execEnteredAction(sMServices, n);
    }

    public void execEnterAction(SMServices sMServices, int n) {
        this.smmActions.execEnterAction(sMServices, n);
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        this.smmActions.execTransitionAction(sMServices, n, n2);
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        return this.smmActions.addActionProxy(n, actionProxy);
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        this.smmActions.removeActionProxy(n, actionProxy);
    }
}

