/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.addressbook.sm.AddressBookSMMActions;
import de.audi.tghu.addressbook.sm.AddressBookSMMInitMediators;
import de.audi.tghu.addressbook.sm.AddressBookSMMInitStates;
import de.audi.tghu.addressbook.sm.AddressBookSMMInitTransitions;
import java.util.NoSuchElementException;

public class AddressBookSMM
extends AbstractAppSMM {
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private AddressBookSMMInitStates smmInitStates;
    private AddressBookSMMInitTransitions smmInitTransitions;
    private AddressBookSMMInitMediators smmInitMediators;
    private AddressBookSMMActions smmActions;

    public AddressBookSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 7, "AddressBookSMM");
    }

    public AddressBookSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 7, "AddressBookSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new AddressBookSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new AddressBookSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new AddressBookSMMInitMediators(this, this.logChannel);
        this.smmActions = new AddressBookSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 1622018560;
        this.popupIDList = new int[]{1622018560, 1638795776, 1655572992, 1672350208};
        this.popupPriorityList = new int[]{1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{1924008448, 2024671744, -1884419584, -1213330944};
        this.popupZPMPriorityList = new int[]{155, 155, 155, 155};
        this.popupZPMSlotList = new int[]{4, 4, 4, 4};
        this.extStateIDList = new int[]{-1800533504, -1817310720, -1330771456, -1095890432, -1716647424, 1806567936, 1840122368, -944895488, 1823345152, -928118272, -894563840, 1622018560, -1431434752};
        this.extStateLabelList = new String[]{"includeAdbComp_addressbookDesktop", "adb_comp", "IncludeOfficeOptSmsEditor_adbOptDetailview_compound_rd", "ADB_onlineDesktopMain_Comp2", "ADB_onlineDesktopMain_Comp", "adbImport", "adrDetailViewMain", "is_destOnlineSearchInit_adbImport", "adrMain", "is_destOptions_adbImport", "adbMainWaitComp", "addressbookDesktop", "adbOptDetailView_compound_rd"};
        this.incSlotList = new int[]{1991117312, -1934751232, -1917974016, -1800533504, -1733424640, -1683092992, -1666315776, -1649538560, -1632761344, -1532098048, -1481766400, -1397880320, -1381103104, -1364325888, -1347548672, -1330771456, -1313994240, -1297217024, -1196553728, -1079113216, -1045558784, -1012004352, -995227136, -978449920, -944895488, -928118272, -861009408, -844232192, -827454976, -810677760, -793900544, -743568896, -710014464, -693237248, -626128384, -609351168, -592573952, -559019520};
        this.incSlotStateIDList = new int[]{-3, -4, -5, -1817310720, -6, -7, -8, -9, -10, -11, -11, -4, -3, -7, -8, -9, -10, -5, -12, -13, -14, -15, -16, -17, -18, -19, -20, -21, -22, -23, -24, -25, -8, -8, -642905600, -642905600, -12, -26};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "destSelectionAdr_incl", "destOptSaveAsFavorite", "telFavoritesOptions", "onlineDesktopMain", "officeEmailEditorComp", "officeOptMailSendMSGComp", "officeOptSMSEditor", "officeOptSMSSendMSGComp", "destTryBestMatchEdit", "includeDestIntellidestDisambiguation_addressbook_compound", "onlineBundleInitCheck", "OfficeOptSMSStoreDraft", "msgOfficePopupSMSStoreTemp", "officeOptSmsDeleteTempAll", "officeOptSmsDeleteTempOne", "DEST_INIT_Online", "destOnlineDest_incl", "msgOfficeOptPopupMailStoreTemp", "officeOptMailDeleteTemp", "officeOptMailDeleteTempOne", "officeOptMailStoreDraft", "onlineInitCoreServicesPreCheck", "toneTouchSliderIncl", "officeOptSMSStoreTempReplace"};
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 700013: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#700440) Value == 1 ) || ( ChoiceModel (MODELID#700440) Value == 3 ) || ( ChoiceModel (MODELID#700440) Value == 4 )");
                            return ((ChoiceModel)this.getModel(414190080)).getValue() == 1 || ((ChoiceModel)this.getModel(414190080)).getValue() == 3 || ((ChoiceModel)this.getModel(414190080)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700029: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#700444) Value == 1");
                            return ((ChoiceModel)this.getModel(481298944)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700050: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BaseListModel (MODELID#700527) Length > 1");
                            return ((BaseListModel)this.getModel(1873807872)).getLength() > 1;
                        }
                        case 1: {
                            this.logCheckGuard("BaseListModel (MODELID#700527) Length == 1");
                            return ((BaseListModel)this.getModel(1873807872)).getLength() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700052: {
                    this.logCheckGuard("BaseListModel (MODELID#700525) Length > 1");
                    return ((BaseListModel)this.getModel(1840253440)).getLength() > 1;
                }
                case 700062: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("LabelModel (MODELID#700495) Status == 0");
                            return ((LabelModel)this.getModel(1336936960)).getStatus() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700066: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ButtonModel (MODELID#700453) Status == 1");
                            return ((ButtonModel)this.getModel(632293888)).getStatus() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700067: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ButtonModel (MODELID#700454) Status == 1");
                            return ((ButtonModel)this.getModel(649071104)).getStatus() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700068: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ButtonModel (MODELID#700455) Status == 1");
                            return ((ButtonModel)this.getModel(665848320)).getStatus() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700075: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("LabelModel (MODELID#700496) Status == 0");
                            return ((LabelModel)this.getModel(1353714176)).getStatus() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700089: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#700448) Value == 1 ) || ( ChoiceModel (MODELID#700448) Value == 2 )");
                            return ((ChoiceModel)this.getModel(548407808)).getValue() == 1 || ((ChoiceModel)this.getModel(548407808)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#700448) Value == 3");
                            return ((ChoiceModel)this.getModel(548407808)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700090: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#700440) Value == 1 ) || ( ChoiceModel (MODELID#700440) Value == 3 ) || ( ChoiceModel (MODELID#700440) Value == 4 )");
                            return ((ChoiceModel)this.getModel(414190080)).getValue() == 1 || ((ChoiceModel)this.getModel(414190080)).getValue() == 3 || ((ChoiceModel)this.getModel(414190080)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700102: {
                    this.logCheckGuard("ChoiceModel (MODELID#3853) Value == 0");
                    return ((ChoiceModel)this.getModel(3853)).getValue() == 0;
                }
                case 700128: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#700470) Value == 0");
                            return ((ChoiceModel)this.getModel(917506560)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700157: {
                    this.logCheckGuard("( ChoiceModel (MODELID#700545) Value == 1 )");
                    return ((ChoiceModel)this.getModel(-2119169536)).getValue() == 1;
                }
                case 700164: {
                    this.logCheckGuard("( ChoiceModel (MODELID#700545) Value == 1 )");
                    return ((ChoiceModel)this.getModel(-2119169536)).getValue() == 1;
                }
                case 700215: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#700440) Value == 1 ) || ( ChoiceModel (MODELID#700440) Value == 3 ) || ( ChoiceModel (MODELID#700440) Value == 4 )");
                            return ((ChoiceModel)this.getModel(414190080)).getValue() == 1 || ((ChoiceModel)this.getModel(414190080)).getValue() == 3 || ((ChoiceModel)this.getModel(414190080)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 700217: {
                    this.logCheckGuard("( ChoiceModel (MODELID#700545) Value == 1 )");
                    return ((ChoiceModel)this.getModel(-2119169536)).getValue() == 1;
                }
            }
            return this.checkGuardSub1(n, n2);
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[AddressBookSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[AddressBookSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(-2137614336, "[AddressBookSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[AddressBookSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 700265: {
                this.logCheckGuard("!( ChoiceModel (MODELID#401470) Value == 0 )");
                return ((ChoiceModel)this.getModel(1042286080)).getValue() != 0;
            }
            case 700344: {
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
            case 700370: {
                this.logCheckGuard("!( ChoiceModel (MODELID#401470) Value == 0 )");
                return ((ChoiceModel)this.getModel(1042286080)).getValue() != 0;
            }
            case 700382: {
                this.logCheckGuard("( ChoiceModel (MODELID#5588) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                return ((ChoiceModel)this.getModel(5588)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9;
            }
            case 700388: {
                this.logCheckGuard("( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5588) Value == 1 )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5588)).getValue() == 1;
            }
            case 700389: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5588) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5588)).getValue() == 1;
            }
            case 700390: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5588) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5588)).getValue() == 1;
            }
            case 700391: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5588) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5588)).getValue() == 1;
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

