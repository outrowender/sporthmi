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
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private SWDLSMMInitStates smmInitStates;
    private SWDLSMMInitTransitions smmInitTransitions;
    private SWDLSMMInitMediators smmInitMediators;
    private SWDLSMMActions smmActions;

    public SWDLSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 17, "SWDLSMM");
    }

    public SWDLSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 17, "SWDLSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new SWDLSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new SWDLSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new SWDLSMMInitMediators(this, this.logChannel);
        this.smmActions = new SWDLSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = -1108338432;
        this.popupIDList = new int[]{-1594877696, -1578100480, -1561323264, -1544546048, -1510991616, -1494214400, -1477437184, -1460659968, -1443882752, -1427105536, -1410328320, -1393551104, -1376773888, -1359996672, -1343219456, -1326442240, -1309665024, -1292887808, -1276110592, -1259333376, -1242556160, -1225778944, -1209001728};
        this.popupPriorityList = new int[]{1500, 100, 100, 100, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{-1024452352, -168814336, -135259904, -101705472, 636557568, 670112000, 703666432, 737220864, 904993024, 1072765184, 1106319616, 1139874048, 1173428480, 1206982912, 1240537344, 1274091776, 1324423424, 1425086720, 1441863936, 1492195584, 1559304448, 1592858880, 1743853824};
        this.popupZPMPriorityList = new int[]{105, 155, 155, 155, 245, 245, 245, 105, 245, 245, 245, 245, 245, 245, 245, 245, 105, 245, 245, 245, 245, 245, 245};
        this.popupZPMSlotList = new int[]{3, 6, 6, 6, 3, 3, 6, 3, 6, 6, 6, 6, 6, 6, 3, 6, 3, 3, 3, 12, 6, 6, 12};
        this.extStateIDList = new int[]{-319809280, -437249792, 1659967744, -1125115648, -1108338432, 770775296, 99686656};
        this.extStateLabelList = new String[]{"settingsUpdateSelectionComp", "settingsCustomerUpdate", "settingsCustomerUpdateConnGatewayComp", "swdl", "swdlHistory", "settingsUpdateSetupGroupCompsUota", "settingsUpdateOnlineSourceDataOk"};
        this.incSlotList = new int[]{-1141892864, -51373824, -34596608, 133241088, 150018304, 603003136, 753998080, 804329728, 821106944, 871438592, 1341200640, 1609636096, 1626413312, 1643190528, 1760631040};
        this.incSlotStateIDList = new int[]{-1125115648, -17819392, -17819392, 183572736, 183572736, -3, 770775296, 837884160, 837884160, -4, 1357977856, -5, -4, -6, -7};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "connectivityCenter", "connectivityCenterOnlineCheck", "onlineBundleInitCheck", "connGatewayRightsRoles", "destMyAudiAuthen_incl", "FinalState (swdlRoot)"};
    }

    @Override
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
                            return ((BufferedListModel)this.getModel(753998080)).getLength() == 1;
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
                            return ((BufferedListModel)this.getModel(753998080)).getLength() == 1;
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
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 3");
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 1");
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 0");
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 0;
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
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 3");
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 1");
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700123) Value == 0");
                            return ((ChoiceModel)this.getModel(468785408)).getValue() == 0;
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
                    return ((ChoiceModel)this.getModel(-101705472)).getValue() == 0;
                }
                case 1700085: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#1700089) Value > 0");
                            return ((ChoiceModel)this.getModel(-101705472)).getValue() > 0;
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
                            return ((ChoiceModel)this.getModel(-638510848)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(-1510926080)).getValue() == 0;
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
                            return (((ChoiceModel)this.getModel(107)).getValue() == 1 || ((ChoiceModel)this.getModel(107)).getValue() == 2) && ((ChoiceModel)this.getModel(-1510926080)).getValue() == 0 || ((ChoiceModel)this.getModel(107)).getValue() == 6;
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
                            return (((ChoiceModel)this.getModel(107)).getValue() == 1 || ((ChoiceModel)this.getModel(107)).getValue() == 2) && ((ChoiceModel)this.getModel(-1510926080)).getValue() == 0 || ((ChoiceModel)this.getModel(107)).getValue() == 6;
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
                            return ((ChoiceModel)this.getModel(-1578034944)).getStatus() > 2;
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
                            return ((ChoiceModel)this.getModel(-1578034944)).getStatus() > 0;
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
                            return ((ChoiceModel)this.getModel(-501538048)).getValue() == 0 || ((SysConstModel)this.getModel(442)).getValue() != 0;
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
                            return ((ChoiceModel)this.getModel(-1578034944)).getValue() == -2;
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
                            return ((ChoiceModel)this.getModel(-655288064)).getValue() == 0;
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
                            return ((ChoiceModel)this.getModel(-655288064)).getValue() == 0;
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
        this.smLogChannel.log(-2137614336, "[SWDLSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[SWDLSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 1700260: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700312) Value == 0");
                        return ((ChoiceModel)this.getModel(-655288064)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-655288064)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-655288064)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-319809280)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#1700076) Value == 2");
                        return ((ChoiceModel)this.getModel(-319809280)).getValue() == 2;
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
                        return ((ChoiceModel)this.getModel(-1578034944)).getValue() == -2;
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
                        return ((ChoiceModel)this.getModel(-1578034944)).getStatus() > 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#1700257) Status == 1 ) && ( ChoiceModel (MODELID#1700257) Value > -1 )");
                        return ((ChoiceModel)this.getModel(-1578034944)).getStatus() == 1 && ((ChoiceModel)this.getModel(-1578034944)).getValue() > -1;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#1700257) Status == 0 )");
                        return ((ChoiceModel)this.getModel(-1578034944)).getStatus() == 0;
                    }
                    case 3: {
                        this.logCheckGuard("( ChoiceModel (MODELID#1700257) Status == 1 ) && ( ChoiceModel (MODELID#1700257) Value < 0 )");
                        return ((ChoiceModel)this.getModel(-1578034944)).getStatus() == 1 && ((ChoiceModel)this.getModel(-1578034944)).getValue() < 0;
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
                        return ((ChoiceModel)this.getModel(-1273289984)).getValue() == 22;
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

