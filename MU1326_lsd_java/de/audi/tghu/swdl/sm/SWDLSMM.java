/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.swdl.sm.SWDLSMMActions;
import de.audi.tghu.swdl.sm.SWDLSMMInitMediators;
import de.audi.tghu.swdl.sm.SWDLSMMInitStates;
import de.audi.tghu.swdl.sm.SWDLSMMInitTransitions;
import java.util.NoSuchElementException;

public class SWDLSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 17;
    public static final String SMM_NAME = "SWDLSMM";
    private SWDLSMMInitStates smmInitStates;
    private SWDLSMMInitTransitions smmInitTransitions;
    private SWDLSMMInitMediators smmInitMediators;
    private SWDLSMMActions smmActions;

    public SWDLSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 17, SMM_NAME);
    }

    public SWDLSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 17, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new SWDLSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new SWDLSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new SWDLSMMInitMediators(this, this.logChannel);
        this.smmActions = new SWDLSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 1700029;
        this.popupIDList = new int[]{1700000, 1700001, 1700002, 1700003, 1700005, 1700006, 1700007, 1700008, 1700009, 1700010, 1700011, 1700012, 1700013, 1700014, 1700015, 1700016, 1700017, 1700018, 1700019, 1700020, 1700021, 1700022, 1700023};
        this.popupPriorityList = new int[]{1500, 100, 100, 100, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{1700034, 1700085, 1700087, 1700089, 1700133, 1700135, 1700137, 1700139, 1700149, 1700159, 1700161, 1700163, 1700165, 1700167, 1700169, 1700171, 1700174, 1700180, 1700181, 1700184, 1700188, 1700190, 1700199};
        this.popupZPMPriorityList = new int[]{105, 155, 155, 155, 245, 245, 245, 105, 245, 245, 245, 245, 245, 245, 245, 245, 105, 245, 245, 245, 245, 245, 245};
        this.popupZPMSlotList = new int[]{3, 6, 6, 6, 3, 3, 6, 3, 6, 6, 6, 6, 6, 6, 3, 6, 3, 3, 3, 12, 6, 6, 12};
        this.extStateIDList = new int[]{1700076, 1700069, 1700194, 1700028, 1700029, 1700141, 1700101};
        this.extStateLabelList = new String[]{"settingsUpdateSelectionComp", "settingsCustomerUpdate", "settingsCustomerUpdateConnGatewayComp", "swdl", "swdlHistory", "settingsUpdateSetupGroupCompsUota", "settingsUpdateOnlineSourceDataOk"};
        this.incSlotList = new int[]{1700027, 1700092, 1700093, 1700103, 1700104, 1700131, 1700140, 1700143, 1700144, 1700147, 1700175, 1700191, 1700192, 1700193, 1700200};
        this.incSlotStateIDList = new int[]{1700028, 1700094, 1700094, 1700106, 1700106, -3, 1700141, 1700145, 1700145, -4, 1700176, -5, -4, -6, -7};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "connectivityCenter", "connectivityCenterOnlineCheck", "onlineBundleInitCheck", "connGatewayRightsRoles", "destMyAudiAuthen_incl", "FinalState (swdlRoot)"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 1700000: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#389) Value == 1");
                            return ((ChoiceModel)this.getModel(389)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700015: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BufferedListModel (MODELID#1700140) Length == 1");
                            return ((BufferedListModel)this.getModel(1700140)).getLength() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700026: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BufferedListModel (MODELID#1700140) Length == 1");
                            return ((BufferedListModel)this.getModel(1700140)).getLength() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700040: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 2");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 3");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 1");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 0");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 0;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700041: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 2");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 3");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 1");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 0");
                            return ((ChoiceModel)this.getModel(1700123)).getValue() == 0;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700084: {
                    this.logCheckGuard("ChoiceModel (MODELID#1700089) Value == 0");
                    return ((ChoiceModel)this.getModel(1700089)).getValue() == 0;
                }
                case 1700085: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700089) Value > 0");
                            return ((ChoiceModel)this.getModel(1700089)).getValue() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700123: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700313) Value == 1");
                            return ((ChoiceModel)this.getModel(1700313)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700131: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#3849) Value == 2 ) || ( ChoiceModel (MODELID#3849) Value == 11 ) || ( ChoiceModel (MODELID#3849) Value == 7 )");
                            return ((ChoiceModel)this.getModel(3849)).getValue() == 2 || ((ChoiceModel)this.getModel(3849)).getValue() == 11 || ((ChoiceModel)this.getModel(3849)).getValue() == 7;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#107) Value > 1 ) || ( ChoiceModel (MODELID#3849) Value == 3 )");
                            return ((ChoiceModel)this.getModel(107)).getValue() > 1 || ((ChoiceModel)this.getModel(3849)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700140: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700261) Value == 0");
                            return ((ChoiceModel)this.getModel(1700261)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700141: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#107) Value == 1 ) || ( ChoiceModel (MODELID#107) Value == 2 ) ) && ( ChoiceModel (MODELID#1700261) Value == 0 ) ) || ( ChoiceModel (MODELID#107) Value == 6 )");
                            return (((ChoiceModel)this.getModel(107)).getValue() == 1 || ((ChoiceModel)this.getModel(107)).getValue() == 2) && ((ChoiceModel)this.getModel(1700261)).getValue() == 0 || ((ChoiceModel)this.getModel(107)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700146: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#107) Value == 1 ) || ( ChoiceModel (MODELID#107) Value == 2 ) ) && ( ChoiceModel (MODELID#1700261) Value == 0 ) ) || ( ChoiceModel (MODELID#107) Value == 6 )");
                            return (((ChoiceModel)this.getModel(107)).getValue() == 1 || ((ChoiceModel)this.getModel(107)).getValue() == 2) && ((ChoiceModel)this.getModel(1700261)).getValue() == 0 || ((ChoiceModel)this.getModel(107)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700154: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700257) Status > 2");
                            return ((ChoiceModel)this.getModel(1700257)).getStatus() > 2;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700170: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700257) Status > 0");
                            return ((ChoiceModel)this.getModel(1700257)).getStatus() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700179: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2300898) Value == 0 ) || ( !( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_EU ) )");
                            return ((ChoiceModel)this.getModel(2300898)).getValue() == 0 || ((SysConstModel)this.getModel(442)).getValue() != 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700182: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#391) Value == 1");
                            return ((ChoiceModel)this.getModel(391)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700183: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#391) Value == 1");
                            return ((ChoiceModel)this.getModel(391)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700189: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#3849) Value == 2 ) || ( ChoiceModel (MODELID#3849) Value == 11 ) || ( ChoiceModel (MODELID#3849) Value == 7 )");
                            return ((ChoiceModel)this.getModel(3849)).getValue() == 2 || ((ChoiceModel)this.getModel(3849)).getValue() == 11 || ((ChoiceModel)this.getModel(3849)).getValue() == 7;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#107) Value > 1 ) || ( ChoiceModel (MODELID#3849) Value == 3 )");
                            return ((ChoiceModel)this.getModel(107)).getValue() > 1 || ((ChoiceModel)this.getModel(3849)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700203: {
                    this.logCheckGuard("ChoiceModel (MODELID#3849) Value == 3");
                    return ((ChoiceModel)this.getModel(3849)).getValue() == 3;
                }
                case 1700214: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700257) Value == -2");
                            return ((ChoiceModel)this.getModel(1700257)).getValue() == -2;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700224: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700312) Value == 0");
                            return ((ChoiceModel)this.getModel(1700312)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700226: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700312) Value == 0");
                            return ((ChoiceModel)this.getModel(1700312)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 1700244: {
                    this.logCheckGuard("ChoiceModel (MODELID#3849) Value == 2");
                    return ((ChoiceModel)this.getModel(3849)).getValue() == 2;
                }
            }
            return this.checkGuardSub1(n, n2);
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[SWDLSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[SWDLSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[SWDLSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[SWDLSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 1700260: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700312) Value == 0");
                        return ((ChoiceModel)this.getModel(1700312)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 1700261: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700312) Value == 0");
                        return ((ChoiceModel)this.getModel(1700312)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 1700262: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700312) Value == 0");
                        return ((ChoiceModel)this.getModel(1700312)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 1700270: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700076) Value == 1");
                        return ((ChoiceModel)this.getModel(1700076)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700076) Value == 2");
                        return ((ChoiceModel)this.getModel(1700076)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 1700304: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700257) Value == -2");
                        return ((ChoiceModel)this.getModel(1700257)).getValue() == -2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 1700306: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700257) Status > 2");
                        return ((ChoiceModel)this.getModel(1700257)).getStatus() > 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#1700257) Status == 1 ) && ( ChoiceModel (MODELID#1700257) Value > -1 )");
                        return ((ChoiceModel)this.getModel(1700257)).getStatus() == 1 && ((ChoiceModel)this.getModel(1700257)).getValue() > -1;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#1700257) Status == 0 )");
                        return ((ChoiceModel)this.getModel(1700257)).getStatus() == 0;
                    }
                    case 3: {
                        this.logCheckGuard("( ChoiceModel (MODELID#1700257) Status == 1 ) && ( ChoiceModel (MODELID#1700257) Value < 0 )");
                        return ((ChoiceModel)this.getModel(1700257)).getStatus() == 1 && ((ChoiceModel)this.getModel(1700257)).getValue() < 0;
                    }
                    case 4: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 1700340: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#3849) Value == 2 ) || ( ChoiceModel (MODELID#3849) Value == 11 ) || ( ChoiceModel (MODELID#3849) Value == 7 )");
                        return ((ChoiceModel)this.getModel(3849)).getValue() == 2 || ((ChoiceModel)this.getModel(3849)).getValue() == 11 || ((ChoiceModel)this.getModel(3849)).getValue() == 7;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#107) Value > 1 ) || ( ChoiceModel (MODELID#3849) Value == 3 )");
                        return ((ChoiceModel)this.getModel(107)).getValue() > 1 || ((ChoiceModel)this.getModel(3849)).getValue() == 3;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 1700364: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 22");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 22;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
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

