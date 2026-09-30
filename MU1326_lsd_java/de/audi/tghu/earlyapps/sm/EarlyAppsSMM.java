/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.earlyapps.sm.EarlyAppsSMMActions;
import de.audi.tghu.earlyapps.sm.EarlyAppsSMMInitMediators;
import de.audi.tghu.earlyapps.sm.EarlyAppsSMMInitStates;
import de.audi.tghu.earlyapps.sm.EarlyAppsSMMInitTransitions;
import java.util.NoSuchElementException;

public class EarlyAppsSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 21;
    public static final String SMM_NAME = "EarlyAppsSMM";
    private EarlyAppsSMMInitStates smmInitStates;
    private EarlyAppsSMMInitTransitions smmInitTransitions;
    private EarlyAppsSMMInitMediators smmInitMediators;
    private EarlyAppsSMMActions smmActions;

    public EarlyAppsSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 21, SMM_NAME);
    }

    public EarlyAppsSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 21, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new EarlyAppsSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new EarlyAppsSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new EarlyAppsSMMInitMediators(this, this.logChannel);
        this.smmActions = new EarlyAppsSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 2100058;
        this.popupIDList = new int[]{2100004, 2100001, 0x200B20};
        this.popupPriorityList = new int[]{135, 135, 1200};
        this.popupTopLevelStateIDList = new int[]{2100068, 2100070, 2100075};
        this.popupZPMPriorityList = new int[]{145, 145, 135};
        this.popupZPMSlotList = new int[]{4, 4, 1};
        this.extStateIDList = new int[]{2100046, 2100048, 2100058};
        this.extStateLabelList = new String[]{"carOptChargeTimer1Weekday", "carOptChargeTimer2Weekday", "earlyAppsDesktop"};
        this.incSlotList = EMPTY_INT_LIST;
        this.incSlotStateIDList = EMPTY_INT_LIST;
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "carOptChargeTimer1Main", "carOptChargeTimer2Main"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 2100057: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100490) Value == 3");
                            return ((ChoiceModel)this.getModel(2100490)).getValue() == 3;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100075: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100346) Value == 1");
                            return ((ChoiceModel)this.getModel(2100346)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100346) Value == 2");
                            return ((ChoiceModel)this.getModel(2100346)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100076: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100346) Value == 1");
                            return ((ChoiceModel)this.getModel(2100346)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100346) Value == 2");
                            return ((ChoiceModel)this.getModel(2100346)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100080: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( SysConstModel (MODELID#466) Value == 3 ) && ( SysConstModel (MODELID#469) Value == 7 ) && ( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_800 )");
                            return ((SysConstModel)this.getModel(466)).getValue() == 3 && ((SysConstModel)this.getModel(469)).getValue() == 7 && ((SysConstModel)this.getModel(522)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100086: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100338) Value == 0");
                            return ((ChoiceModel)this.getModel(2100338)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100089: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100180) Value > 1");
                            return ((ChoiceModel)this.getModel(2100180)).getValue() > 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100091: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100166) Value == 1");
                            return ((ChoiceModel)this.getModel(2100166)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100093: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100166) Value == 1");
                            return ((ChoiceModel)this.getModel(2100166)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100097: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2100490) Value == 3");
                            return ((ChoiceModel)this.getModel(2100490)).getValue() == 3;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2100103: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2100465) Value == 2 ) && ( ChoiceModel (MODELID#2100756) Value == 0 )");
                    return ((ChoiceModel)this.getModel(2100465)).getValue() == 2 && ((ChoiceModel)this.getModel(2100756)).getValue() == 0;
                }
                case 2100104: {
                    this.logCheckGuard("ChoiceModel (MODELID#2100465) Value == 0");
                    return ((ChoiceModel)this.getModel(2100465)).getValue() == 0;
                }
            }
            return false;
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[EarlyAppsSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[EarlyAppsSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[EarlyAppsSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[EarlyAppsSMM.java#checkGuard] checking: '%1'", (Object)string);
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

