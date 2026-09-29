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
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private SettingsSMMInitStates smmInitStates;
    private SettingsSMMInitTransitions smmInitTransitions;
    private SettingsSMMInitMediators smmInitMediators;
    private SettingsSMMActions smmActions;

    public SettingsSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 11, "SettingsSMM");
    }

    public SettingsSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 11, "SettingsSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new SettingsSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new SettingsSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new SettingsSMMInitMediators(this, this.logChannel);
        this.smmActions = new SettingsSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 1623789568;
        this.popupIDList = EMPTY_INT_LIST;
        this.popupPriorityList = EMPTY_INT_LIST;
        this.popupTopLevelStateIDList = EMPTY_INT_LIST;
        this.popupZPMPriorityList = EMPTY_INT_LIST;
        this.popupZPMSlotList = EMPTY_INT_LIST;
        this.extStateIDList = new int[]{-2134306816, 1556680704, 2076774400, 2143883264, 1942556672, 2009665536, 1959333888, 1657344000, 1623789568, 1690898432};
        this.extStateLabelList = new String[]{"settingsTime", "SDS_settingsSDSTrainingError_Comp", "settingsSdsTrainingStart", "settingsSystemComp", "settingsRSEMain", "settingsSdsTrainingEnd", "settingsSds", "settingsDesktopCustDownloadContext", "settingsDesktop", "settingsFactory"};
        this.incSlotList = new int[]{1489571840, 1506349056, 1523126272, 1539903488, 1640566784, -2117529600, -1798762496};
        this.incSlotStateIDList = new int[]{-3, -4, 1690898432, -5, -6, -2134306816, -7};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "popupHelpBordbuch", "connectivityCenter", "toneCenerSdsSliderGreyOut", "settingsCustomerUpdate", "toneWCVolume"};
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 1100248: {
                    this.logCheckGuard("( ChoiceModel (MODELID#1100143) Value > 1 ) || ( ChoiceModel (MODELID#1100136) Value > 1 )");
                    return ((ChoiceModel)this.getModel(1875447808)).getValue() > 1 || ((ChoiceModel)this.getModel(1758007296)).getValue() > 1;
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
                    return ((ChoiceModel)this.getModel(-1748430848)).getValue() == 0 || ((ChoiceModel)this.getModel(-1647767552)).getValue() == 1;
                }
                case 1100337: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1100187) Value == 0");
                            return ((ChoiceModel)this.getModel(-1681321984)).getValue() == 0;
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
                            return ((SysConstModel)this.getModel(523)).getValue() == 0 || ((ChoiceModel)this.getModel(-1043787776)).getStatus() == 0;
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
                            return ((ChoiceModel)this.getModel(-993456128)).getValue() == 0 && ((SysConstModel)this.getModel(4547)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(-993456128)).getValue() == 0 && ((SysConstModel)this.getModel(4547)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1 && ((ChoiceModel)this.getModel(1396838144)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1 && ((ChoiceModel)this.getModel(1396838144)).getValue() == 1;
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
        this.smLogChannel.log(-2137614336, "[SettingsSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[SettingsSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    @Override
    public void execSDForState(TTSASR tTSASR, ITTSASRContext iTTSASRContext, int n) {
    }

    @Override
    public void execFocusGainedAction(SMServices sMServices, int n) {
        this.smmActions.execFocusGainedAction(sMServices, n);
    }

    @Override
    public void execFocusLostAction(SMServices sMServices, int n) {
        this.smmActions.execFocusLostAction(sMServices, n);
    }

    @Override
    public void execExitAction(SMServices sMServices, int n) {
        this.smmActions.execExitAction(sMServices, n);
    }

    @Override
    public void execEnteredAction(SMServices sMServices, int n) {
        this.smmActions.execEnteredAction(sMServices, n);
    }

    @Override
    public void execEnterAction(SMServices sMServices, int n) {
        this.smmActions.execEnterAction(sMServices, n);
    }

    @Override
    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        this.smmActions.execTransitionAction(sMServices, n, n2);
    }

    @Override
    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        return this.smmActions.addActionProxy(n, actionProxy);
    }

    @Override
    public void removeActionProxy(int n, ActionProxy actionProxy) {
        this.smmActions.removeActionProxy(n, actionProxy);
    }
}

