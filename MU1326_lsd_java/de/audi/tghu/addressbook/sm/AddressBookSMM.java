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
    public static final int MODULE_ID = 7;
    public static final String SMM_NAME = "AddressBookSMM";
    private AddressBookSMMInitStates smmInitStates;
    private AddressBookSMMInitTransitions smmInitTransitions;
    private AddressBookSMMInitMediators smmInitMediators;
    private AddressBookSMMActions smmActions;

    public AddressBookSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 7, SMM_NAME);
    }

    public AddressBookSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 7, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new AddressBookSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new AddressBookSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new AddressBookSMMInitMediators(this, this.logChannel);
        this.smmActions = new AddressBookSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 700000;
        this.popupIDList = new int[]{700000, 700001, 700002, 700003};
        this.popupPriorityList = new int[]{1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{700018, 700024, 700047, 700087};
        this.popupZPMPriorityList = new int[]{155, 155, 155, 155};
        this.popupZPMSlotList = new int[]{4, 4, 4, 4};
        this.extStateIDList = new int[]{700052, 700051, 700080, 700094, 700057, 700011, 700013, 700103, 700012, 700104, 700106, 700000, 700074};
        this.extStateLabelList = new String[]{"includeAdbComp_addressbookDesktop", "adb_comp", "IncludeOfficeOptSmsEditor_adbOptDetailview_compound_rd", "ADB_onlineDesktopMain_Comp2", "ADB_onlineDesktopMain_Comp", "adbImport", "adrDetailViewMain", "is_destOnlineSearchInit_adbImport", "adrMain", "is_destOptions_adbImport", "adbMainWaitComp", "addressbookDesktop", "adbOptDetailView_compound_rd"};
        this.incSlotList = new int[]{700022, 700044, 700045, 700052, 700056, 700059, 700060, 700061, 700062, 700068, 700071, 700076, 700077, 700078, 700079, 700080, 700081, 700082, 700088, 700095, 700097, 700099, 700100, 700101, 700103, 700104, 700108, 700109, 700110, 700111, 700112, 700115, 700117, 700118, 700122, 700123, 700124, 700126};
        this.incSlotStateIDList = new int[]{-3, -4, -5, 700051, -6, -7, -8, -9, -10, -11, -11, -4, -3, -7, -8, -9, -10, -5, -12, -13, -14, -15, -16, -17, -18, -19, -20, -21, -22, -23, -24, -25, -8, -8, 700121, 700121, -12, -26};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "destSelectionAdr_incl", "destOptSaveAsFavorite", "telFavoritesOptions", "onlineDesktopMain", "officeEmailEditorComp", "officeOptMailSendMSGComp", "officeOptSMSEditor", "officeOptSMSSendMSGComp", "destTryBestMatchEdit", "includeDestIntellidestDisambiguation_addressbook_compound", "onlineBundleInitCheck", "OfficeOptSMSStoreDraft", "msgOfficePopupSMSStoreTemp", "officeOptSmsDeleteTempAll", "officeOptSmsDeleteTempOne", "DEST_INIT_Online", "destOnlineDest_incl", "msgOfficeOptPopupMailStoreTemp", "officeOptMailDeleteTemp", "officeOptMailDeleteTempOne", "officeOptMailStoreDraft", "onlineInitCoreServicesPreCheck", "toneTouchSliderIncl", "officeOptSMSStoreTempReplace"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 700013: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#700440) Value == 1 ) || ( ChoiceModel (MODELID#700440) Value == 3 ) || ( ChoiceModel (MODELID#700440) Value == 4 )");
                            return ((ChoiceModel)this.getModel(700440)).getValue() == 1 || ((ChoiceModel)this.getModel(700440)).getValue() == 3 || ((ChoiceModel)this.getModel(700440)).getValue() == 4;
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
                            return ((ChoiceModel)this.getModel(700444)).getValue() == 1;
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
                            return ((BaseListModel)this.getModel(700527)).getLength() > 1;
                        }
                        case 1: {
                            this.logCheckGuard("BaseListModel (MODELID#700527) Length == 1");
                            return ((BaseListModel)this.getModel(700527)).getLength() == 1;
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
                    return ((BaseListModel)this.getModel(700525)).getLength() > 1;
                }
                case 700062: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("LabelModel (MODELID#700495) Status == 0");
                            return ((LabelModel)this.getModel(700495)).getStatus() == 0;
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
                            return ((ButtonModel)this.getModel(700453)).getStatus() == 1;
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
                            return ((ButtonModel)this.getModel(700454)).getStatus() == 1;
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
                            return ((ButtonModel)this.getModel(700455)).getStatus() == 1;
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
                            return ((LabelModel)this.getModel(700496)).getStatus() == 0;
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
                            return ((ChoiceModel)this.getModel(700448)).getValue() == 1 || ((ChoiceModel)this.getModel(700448)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#700448) Value == 3");
                            return ((ChoiceModel)this.getModel(700448)).getValue() == 3;
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
                            return ((ChoiceModel)this.getModel(700440)).getValue() == 1 || ((ChoiceModel)this.getModel(700440)).getValue() == 3 || ((ChoiceModel)this.getModel(700440)).getValue() == 4;
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
                            return ((ChoiceModel)this.getModel(700470)).getValue() == 0;
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
                    return ((ChoiceModel)this.getModel(700545)).getValue() == 1;
                }
                case 700164: {
                    this.logCheckGuard("( ChoiceModel (MODELID#700545) Value == 1 )");
                    return ((ChoiceModel)this.getModel(700545)).getValue() == 1;
                }
                case 700215: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#700440) Value == 1 ) || ( ChoiceModel (MODELID#700440) Value == 3 ) || ( ChoiceModel (MODELID#700440) Value == 4 )");
                            return ((ChoiceModel)this.getModel(700440)).getValue() == 1 || ((ChoiceModel)this.getModel(700440)).getValue() == 3 || ((ChoiceModel)this.getModel(700440)).getValue() == 4;
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
                    return ((ChoiceModel)this.getModel(700545)).getValue() == 1;
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
        this.smLogChannel.log(10000000, "[AddressBookSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[AddressBookSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 700265: {
                this.logCheckGuard("!( ChoiceModel (MODELID#401470) Value == 0 )");
                return ((ChoiceModel)this.getModel(401470)).getValue() != 0;
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
                return ((ChoiceModel)this.getModel(401470)).getValue() != 0;
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

