/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractSysSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.system.sm.SystemSMMActions;
import de.audi.tghu.system.sm.SystemSMMInitMediators;
import de.audi.tghu.system.sm.SystemSMMInitStates;
import de.audi.tghu.system.sm.SystemSMMInitTransitions;
import java.util.NoSuchElementException;

public class SystemSMM
extends AbstractSysSMM {
    public static final int MODULE_ID = 0;
    public static final String SMM_NAME = "SystemSMM";
    private SystemSMMInitStates smmInitStates;
    private SystemSMMInitTransitions smmInitTransitions;
    private SystemSMMInitMediators smmInitMediators;
    private SystemSMMActions smmActions;

    public SystemSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 0, SMM_NAME);
    }

    public SystemSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 0, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new SystemSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new SystemSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new SystemSMMInitMediators(this, this.logChannel);
        this.smmActions = new SystemSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.smmSlotList = new int[]{0, 4, 113, 84, 5, 427, 70, 6, 7, 8, 9, 10, 78, 74, 163, 13, 252, 90, 14, 256, 257, 15, 431};
        this.smmSlotModuleIDList = new int[]{7, 6, 25, 16, 21, 33, 13, 5, 2, 22, 4, 23, 11, 17, 26, 3, 32, 24, 10, 8, 9, 1, 34};
        this.topLevelStateID = 55;
        this.popupIDList = new int[]{4, 6, 7, 8, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42};
        this.popupPriorityList = new int[]{1000, 1501, 1550, 1550, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 100, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 165, 145};
        this.popupTopLevelStateIDList = new int[]{83, 96, 98, 100, 128, 130, 136, 138, 147, 178, 180, 190, 194, 235, 241, 259, 291, 394, 397, 400, 403, 404, 406, 408, 410, 412, 415, 417, 438, 451};
        this.popupZPMPriorityList = new int[]{100, 100, 100, 100, 155, 155, 155, 155, 155, 225, 225, 155, 155, 155, 100, 100, 165, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 135, 145};
        this.popupZPMSlotList = new int[]{4, 4, 2, 2, 4, 4, 4, 4, 4, 7, 7, 4, 4, 4, 4, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5};
        this.extStateIDList = new int[]{479, 35, 64, 141, 203, 37, 111, 131, 160, 285, 289, 489, 250, 81, 80, 297, 299, 94, 481, 300, 480, 88, 61, 482};
        this.extStateLabelList = new String[]{"include_PopUpLicenseExpiredLicenseOverview", "sysInitNavi", "sysInitOnline", "sysInitTV", "DEST_INIT_Online", "sysInitTone", "sysInitConnectivity", "sysInitAddressbook", "Include-Slot-sysInitCarInclude", "onlineBundleInitCheck", "sysInitOnline_BCall", "nav_emptyDrawersComp", "includeDestIntellidestDisambiguation_addressbook_compound", "messaging", "MessagingRoot", "messagingComp", "Include-Slot-messagingDefault", "mainWizardRootState", "include_PopupLicenseExpired_comp", "Include-Slot-MessagingInit_Sys", "include_PopupTeaserExpiredLicenseOverview", "mainWizzard", "sysDesktopHistory", "include_PopupTeaserExpired_comp"};
        this.incSlotList = new int[]{80, 132, 133, 150, 151, 152, 160, 164, 166, 176, 181, 187, 208, 209, 210, 211, 216, 218, 223, 224, 233, 242, 245, 246, 262, 269, 270, 271, 272, 273, 274, 275, 279, 280, 286, 288, 292, 299, 300, 419, 440, 441, 446, 450, 464, 467, 479, 480, 488, 493, 494};
        this.incSlotStateIDList = new int[]{81, 131, -26, -27, -26, -27, 162, -17, -27, -28, -29, -30, 203, -31, 203, -31, 203, -31, 203, -31, 228, -32, -32, -32, -26, 162, 162, 162, 162, 162, 162, 162, -26, -26, 285, 285, -22, 301, 301, -33, 285, -34, 250, -34, 455, 203, -35, -35, -36, 285, -37};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "addressbookDesktop", "carDesktop", "connectivityDesktop", "DevelopmentTLS", "earlyAppsDesktop", "ecallDesktop", "engineeringDesktop", "infoDesktop", "mediaDesktop", "messagingDesktop", "naviDesktop", "onlineDesktop", "settingsDesktop", "swdlHistory", "tvDesktop", "phoneDesktop", "terminalModeDesktop", "tsDesktop", "toneDesktop", "tpeg_KR_Main", "mapVICSMainJP", "tunerDesktop", "wirelessChargingDesktop", "connectivityCenter", "settingsCustomerUpdate", "destSetdestQuery", "popupHelpBordbuch", "CM_popup_online_errors_licens_check", "nav_inner_init_online", "destIntellidestDisambiguation_incl", "destOptHomeCreateEdit_incl", "onlineDestOperatorCall_CN", "audiConnectOptLicenseComp", "mapMapviewMain_incl", "onlineInitCoreServicesPreCheck", "telCenter", "JUMP_TO_DEST_DESKTOP", "tunerListFavoriteMain", "telNumberEditMain", "is_destAddressForm", "JUMP_TO_MAP", "SDS_settingsSDSTrainingError_Comp", "settingsSdsTrainingEnd", "settingsSdsTrainingStart", "JUMP_TO_MAP_DESKTOP", "tunerListHistoryMain", "destIntellidest", "IS_destPoiSearch", "mapDesktop", "Include-Tel_ADB", "IncludeOfficeDesktop", "Include-Dest_ADB", "mediaInvalid", "mediaBrowserDesktop", "destDesktop", "settingsSds", "is_destOptions_showDetails_SDS", "mapRoutelist", "DEST_OPT_ONLINE_SEARCH_AREA_MAIN", "Include_Tel_Messaging", "is_destCoordinates", "IS_mapview_main", "include_onlineConnectivityCenterEnter_destPoi", "IncludeSMSDesktop", "telFavoritesMain", "is_destOnlineSearch", "includeAdbComp_addressbookDesktop", "is_destFavorites_list", "is_destLastDest", "telIntellicallFull", "tunerList", "includeOnlineDesktopMain_1", "telIntellicall", "is_destOnlineDest", "destOnlineDest", "destPoi", "mapDesktopMain", "includeTelMailboxEdit_SDS", "telSetupPin", "carAcMain", "carAuxheatMain", "BordbuchComp", "carCarsettingsMain", "carCharismaComp", "carFasMain", "carServiceMain", "breakdownCallCN", "mediaDesktopTypesSelectDesktop", "settingsRSEMain", "include_onlineDestOperatorCall_CN", "is_destOptions_detailsOnlinePoi", "telOfficeDesktop_comp", "is_destMapCode_JP_incl", "mapVICS_JP", "is_destTelephone_JP_KR", "tunerCenter", "telOperator_JP", "destOperatorCall_CN", "include_onlineTelOperatorCall_CN", "tunerListSiriusFavoritesMain", "is_destTPEG_POI_KR_Main", "destGasWarning", "telCarPlayDisclaimer_compound", "telSMSDesktop", "tunerListSelectWaveband", "is_mapSimpleMaps_desktop", "showInMapVicsGen2", "onlineEntryPoint_Inner", "online_destMyAudiAuth_Inc_Inner", "mapOptSemiDynGuidance", "carCarsettingsUgdoLearnButtonMainUniversal", "carCarSettingsUgdoLearnButtonRollGroup"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 13: {
                    this.logCheckGuard("!( ChoiceModel (MODELID#1700061) Value == 1 )");
                    return ((ChoiceModel)this.getModel(1700061)).getValue() != 1;
                }
                case 19: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#350) Value == 1 ) && ( ChoiceModel (MODELID#15) Value == 1 )");
                            return ((ChoiceModel)this.getModel(350)).getValue() == 1 && ((ChoiceModel)this.getModel(15)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("!( ( ChoiceModel (MODELID#350) Value == 1 ) && ( ChoiceModel (MODELID#15) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(350)).getValue() != 1 || ((ChoiceModel)this.getModel(15)).getValue() != 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 21: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4045) Value == 1 )");
                            return ((ChoiceModel)this.getModel(4045)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4045) Value == 0 )");
                            return ((ChoiceModel)this.getModel(4045)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 23: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#354) Value == 1");
                            return ((ChoiceModel)this.getModel(354)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#354) Value == 0");
                            return ((ChoiceModel)this.getModel(354)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 26: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#358) Value == 0");
                            return ((ChoiceModel)this.getModel(358)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#358) Value == 1");
                            return ((ChoiceModel)this.getModel(358)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 28: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#358) Value == 0");
                            return ((ChoiceModel)this.getModel(358)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#358) Value == 1");
                            return ((ChoiceModel)this.getModel(358)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 29: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 512");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 512;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 0");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 0;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1024");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 1024;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 30: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 512");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 512;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 0");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 0;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1024");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 1024;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 31: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#367) Value == 1024 ) || ( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_400 )");
                            return ((ChoiceModel)this.getModel(367)).getValue() == 1024 || ((SysConstModel)this.getModel(522)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#367) Value == 0");
                            return ((ChoiceModel)this.getModel(367)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#367) Value == 1");
                            return ((ChoiceModel)this.getModel(367)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 34: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#367) Value == 1024 ) || ( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_400 )");
                            return ((ChoiceModel)this.getModel(367)).getValue() == 1024 || ((SysConstModel)this.getModel(522)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#367) Value == 0");
                            return ((ChoiceModel)this.getModel(367)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#367) Value == 1");
                            return ((ChoiceModel)this.getModel(367)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 35: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#377) Value == 1");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#377) Value == 0");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 36: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#377) Value == 1");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#377) Value == 0");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 37: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#378) Value == 0");
                            return ((ChoiceModel)this.getModel(378)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#378) Value == 1");
                            return ((ChoiceModel)this.getModel(378)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 38: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#378) Value == 0");
                            return ((ChoiceModel)this.getModel(378)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#378) Value == 1");
                            return ((ChoiceModel)this.getModel(378)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 45: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#375) Value == 1");
                            return ((ChoiceModel)this.getModel(375)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 62: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_TERMINALMODE");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 43;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_MAINWIZARD");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 41;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_ECALL");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 44;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_MESSAGING");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 21;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_COMBIMAINWIZARD");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 36;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_BORDCOMPUTER");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 35;
                        }
                        case 6: {
                            this.logCheckGuard("( ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_MEDIA ) || ( ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_TV )");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 2 || ((ChoiceModel)this.getModel(129)).getValue() == 38;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_SWDL");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 12;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_PHONE");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 4;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_CAR");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 7;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_UNDEFINED");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 0;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_NAVI");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 5;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_MAP");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 39;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_TONE");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 9;
                        }
                        case 14: {
                            this.logCheckGuard("( ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_INFOKR )");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 46;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_ONLINE");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 22;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_SETTINGS");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 10;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#129) Value == ICoreSysConfig.APPLICATION_ID_WIRELESS_CHARGING");
                            return ((ChoiceModel)this.getModel(129)).getValue() == 47;
                        }
                        case 18: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 64: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#357) Value == 1");
                            return ((ChoiceModel)this.getModel(357)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#357) Value == 0");
                            return ((ChoiceModel)this.getModel(357)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 75: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#355) Value == 0");
                            return ((ChoiceModel)this.getModel(355)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#355) Value == 1");
                            return ((ChoiceModel)this.getModel(355)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 76: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#355) Value == 0");
                            return ((ChoiceModel)this.getModel(355)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#355) Value == 1");
                            return ((ChoiceModel)this.getModel(355)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 94: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#350) Value == 1 ) && ( ChoiceModel (MODELID#15) Value == 1 )");
                            return ((ChoiceModel)this.getModel(350)).getValue() == 1 && ((ChoiceModel)this.getModel(15)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("!( ( ChoiceModel (MODELID#350) Value == 1 ) && ( ChoiceModel (MODELID#15) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(350)).getValue() != 1 || ((ChoiceModel)this.getModel(15)).getValue() != 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 96: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#354) Value == 1");
                            return ((ChoiceModel)this.getModel(354)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#354) Value == 0");
                            return ((ChoiceModel)this.getModel(354)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 97: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#359) Value == 1");
                            return ((ChoiceModel)this.getModel(359)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#359) Value == 0");
                            return ((ChoiceModel)this.getModel(359)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#359) Value == 1024");
                            return ((ChoiceModel)this.getModel(359)).getValue() == 1024;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 99: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#357) Value == 1");
                            return ((ChoiceModel)this.getModel(357)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#357) Value == 0");
                            return ((ChoiceModel)this.getModel(357)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 101: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#372) Value == 1");
                            return ((ChoiceModel)this.getModel(372)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#372) Value == 0");
                            return ((ChoiceModel)this.getModel(372)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 102: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#372) Value == 1");
                            return ((ChoiceModel)this.getModel(372)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#372) Value == 0");
                            return ((ChoiceModel)this.getModel(372)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 108: {
                    this.logCheckGuard("ChoiceModel (MODELID#450) Value == 1");
                    return ((ChoiceModel)this.getModel(450)).getValue() == 1;
                }
                case 115: {
                    this.logCheckGuard("ChoiceModel (MODELID#112) Value == 0");
                    return ((ChoiceModel)this.getModel(112)).getValue() == 0;
                }
                case 120: {
                    this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( ( ChoiceModel (MODELID#3895) Value == 1 ) || ( ChoiceModel (MODELID#3996) Value == 1 ) )");
                    return ((SysConstModel)this.getModel(522)).getValue() == 4 && (((ChoiceModel)this.getModel(3895)).getValue() == 1 || ((ChoiceModel)this.getModel(3996)).getValue() == 1);
                }
                case 121: {
                    this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( ( ChoiceModel (MODELID#3895) Value == 1 ) || ( ChoiceModel (MODELID#3996) Value == 1 ) )");
                    return ((SysConstModel)this.getModel(522)).getValue() == 4 && (((ChoiceModel)this.getModel(3895)).getValue() == 1 || ((ChoiceModel)this.getModel(3996)).getValue() == 1);
                }
                case 122: {
                    this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( ( ChoiceModel (MODELID#3895) Value == 1 ) || ( ChoiceModel (MODELID#3996) Value == 1 ) )");
                    return ((SysConstModel)this.getModel(522)).getValue() == 4 && (((ChoiceModel)this.getModel(3895)).getValue() == 1 || ((ChoiceModel)this.getModel(3996)).getValue() == 1);
                }
                case 137: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 147: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#456) Value == 1");
                            return ((ChoiceModel)this.getModel(456)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#456) Value == 0");
                            return ((ChoiceModel)this.getModel(456)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 148: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#456) Value == 1");
                            return ((ChoiceModel)this.getModel(456)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#456) Value == 0");
                            return ((ChoiceModel)this.getModel(456)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 193: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                            return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 206: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#509) Value == 0");
                            return ((ChoiceModel)this.getModel(509)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#509) Value == 1");
                            return ((ChoiceModel)this.getModel(509)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 207: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#509) Value == 0");
                            return ((ChoiceModel)this.getModel(509)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#509) Value == 1");
                            return ((ChoiceModel)this.getModel(509)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 213: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#368) Value == 0");
                            return ((ChoiceModel)this.getModel(368)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 230: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                            return ((SysConstModel)this.getModel(522)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 273: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#545) Value == 1 ) && ( ChoiceModel (MODELID#4117) Value == 1 )");
                            return ((ChoiceModel)this.getModel(545)).getValue() == 1 && ((ChoiceModel)this.getModel(4117)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#545) Value == 0 ) || ( ChoiceModel (MODELID#4117) Value == 0 )");
                            return ((ChoiceModel)this.getModel(545)).getValue() == 0 || ((ChoiceModel)this.getModel(4117)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 275: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#545) Value == 1 ) && ( ChoiceModel (MODELID#4117) Value == 1 )");
                            return ((ChoiceModel)this.getModel(545)).getValue() == 1 && ((ChoiceModel)this.getModel(4117)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#545) Value == 0 ) || ( ChoiceModel (MODELID#4117) Value == 0 )");
                            return ((ChoiceModel)this.getModel(545)).getValue() == 0 || ((ChoiceModel)this.getModel(4117)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
            }
            return this.checkGuardSub1(n, n2);
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[SystemSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[SystemSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[SystemSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[SystemSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 277: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 1");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 0");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#2300852) Value == 3 ) || ( ChoiceModel (MODELID#2300852) Value == 13 )");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 3 || ((ChoiceModel)this.getModel(2300852)).getValue() == 13;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 4");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 4;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 6");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 6;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 7");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 7;
                    }
                    case 6: {
                        this.logCheckGuard("( ChoiceModel (MODELID#2300852) Value == 9 ) || ( ChoiceModel (MODELID#2300852) Value == 10 )");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 9 || ((ChoiceModel)this.getModel(2300852)).getValue() == 10;
                    }
                    case 7: {
                        this.logCheckGuard("( ChoiceModel (MODELID#2300852) Value == 8 ) || ( ChoiceModel (MODELID#2300852) Value == 12 )");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 8 || ((ChoiceModel)this.getModel(2300852)).getValue() == 12;
                    }
                    case 8: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 2");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 2;
                    }
                    case 9: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 298: {
                this.logCheckGuard("( ChoiceModel (MODELID#3848) Value == 0 ) && ( ChoiceModel (MODELID#300691) Value == 0 ) && ( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 )");
                return ((ChoiceModel)this.getModel(3848)).getValue() == 0 && ((ChoiceModel)this.getModel(300691)).getValue() == 0 && ((SysConstModel)this.getModel(522)).getValue() == 4;
            }
            case 320: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#352) Value == 0");
                        return ((ChoiceModel)this.getModel(352)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#352) Value == 1");
                        return ((ChoiceModel)this.getModel(352)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 347: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200522) Value == 0");
                        return ((ChoiceModel)this.getModel(200522)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 382: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#402566) Value == 1");
                        return ((ChoiceModel)this.getModel(402566)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 384: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#400871) Value == 2 ) && ( !( ( ChoiceModel (MODELID#402440) Value == 1 ) ) )");
                        return ((ChoiceModel)this.getModel(400871)).getValue() == 2 && ((ChoiceModel)this.getModel(402440)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 385: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#402566) Value == 1");
                        return ((ChoiceModel)this.getModel(402566)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 390: {
                this.logCheckGuard("!( ChoiceModel (MODELID#17) Value == 0 )");
                if (((ChoiceModel)this.getModel(17)).getValue() == 0) {
                    return false;
                }
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#17) Value == 1");
                        return ((ChoiceModel)this.getModel(17)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 439: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#52) Value == 1");
                        return ((ChoiceModel)this.getModel(52)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 446: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 0");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 512");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 512;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1024");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 1024;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                    }
                    case 4: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 448: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 0");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 449: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 0");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 491: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#358) Value == 1");
                        return ((ChoiceModel)this.getModel(358)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#358) Value == 0");
                        return ((ChoiceModel)this.getModel(358)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 509: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 0");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 1");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 2");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 2;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 3");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 3;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 4");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 4;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 5");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 5;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 6");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 6;
                    }
                    case 7: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 8");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 8;
                    }
                    case 8: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 9");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 9;
                    }
                    case 9: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 511: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#400871) Value == 2 ) && ( !( ( ChoiceModel (MODELID#402440) Value == 1 ) ) )");
                        return ((ChoiceModel)this.getModel(400871)).getValue() == 2 && ((ChoiceModel)this.getModel(402440)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 513: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4005) Value == 1");
                        return ((ChoiceModel)this.getModel(4005)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#4005) Value == 0");
                        return ((ChoiceModel)this.getModel(4005)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 515: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4005) Value == 1");
                        return ((ChoiceModel)this.getModel(4005)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#4005) Value == 0");
                        return ((ChoiceModel)this.getModel(4005)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 520: {
                this.logCheckGuard("!( ChoiceModel (MODELID#401470) Value == 0 )");
                return ((ChoiceModel)this.getModel(401470)).getValue() != 0;
            }
        }
        return this.checkGuardSub2(n, n2);
    }

    public boolean checkGuardSub2(int n, int n2) {
        switch (n) {
            case 534: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 4");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 4;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 7");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 7;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 548: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4033) Value == 0");
                        return ((ChoiceModel)this.getModel(4033)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#4033) Value == 1");
                        return ((ChoiceModel)this.getModel(4033)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 549: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4033) Value == 0");
                        return ((ChoiceModel)this.getModel(4033)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#4033) Value == 1");
                        return ((ChoiceModel)this.getModel(4033)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 556: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 9");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 9;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 6");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 6;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 3");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 3;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 1");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 1;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 4");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 4;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 5");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 5;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 2");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 2;
                    }
                    case 7: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 8");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 8;
                    }
                    case 8: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 0");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 0;
                    }
                    case 9: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 582: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 584: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#361) Value == 1");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 586: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#11) Value == ICoreSysConfig.ACTIVE_ENTERTAINMENT_AUDIO_CONTEXT_TUNER ) && ( ChoiceModel (MODELID#4451) Value == 0 ) ) || ( ( ChoiceModel (MODELID#4451) Value > 0 ) && ( ChoiceModel (MODELID#5536) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(11)).getValue() == 0 && ((ChoiceModel)this.getModel(4451)).getValue() == 0 || ((ChoiceModel)this.getModel(4451)).getValue() > 0 && ((ChoiceModel)this.getModel(5536)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 624: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#363) Value == 0");
                        return ((ChoiceModel)this.getModel(363)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#363) Value == 1024");
                        return ((ChoiceModel)this.getModel(363)).getValue() == 1024;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#363) Value == 1");
                        return ((ChoiceModel)this.getModel(363)).getValue() == 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 628: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 4");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 4;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#138) Value == 7");
                        return ((ChoiceModel)this.getModel(138)).getValue() == 7;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 635: {
                this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                return ((SysConstModel)this.getModel(522)).getValue() == 4;
            }
            case 645: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#4045) Value == 1 )");
                        return ((ChoiceModel)this.getModel(4045)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#4045) Value == 0 )");
                        return ((ChoiceModel)this.getModel(4045)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 662: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#359) Value == 1");
                        return ((ChoiceModel)this.getModel(359)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#359) Value == 0");
                        return ((ChoiceModel)this.getModel(359)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#359) Value == 1024");
                        return ((ChoiceModel)this.getModel(359)).getValue() == 1024;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 669: {
                this.logCheckGuard("( ChoiceModel (MODELID#11) Value == ICoreSysConfig.ACTIVE_ENTERTAINMENT_AUDIO_CONTEXT_TUNER )");
                return ((ChoiceModel)this.getModel(11)).getValue() == 0;
            }
            case 670: {
                this.logCheckGuard("( !( ChoiceModel (MODELID#11) Value == ICoreSysConfig.ACTIVE_ENTERTAINMENT_AUDIO_CONTEXT_TUNER ) )");
                return ((ChoiceModel)this.getModel(11)).getValue() != 0;
            }
            case 685: {
                this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( !( ( ChoiceModel (MODELID#447) Value == 5 ) || ( ChoiceModel (MODELID#447) Value == 11 ) || ( ChoiceModel (MODELID#447) Value == 10 ) || ( ChoiceModel (MODELID#447) Value == 15 ) || ( ChoiceModel (MODELID#447) Value == 16 ) || ( ChoiceModel (MODELID#447) Value == 17 ) || ( ChoiceModel (MODELID#447) Value == 39 ) || ( ChoiceModel (MODELID#447) Value == 40 ) || ( ChoiceModel (MODELID#447) Value == 38 ) || ( ChoiceModel (MODELID#447) Value == 42 ) || ( ChoiceModel (MODELID#447) Value == 18 ) ) )");
                return ((SysConstModel)this.getModel(522)).getValue() == 4 && ((ChoiceModel)this.getModel(447)).getValue() != 5 && ((ChoiceModel)this.getModel(447)).getValue() != 11 && ((ChoiceModel)this.getModel(447)).getValue() != 10 && ((ChoiceModel)this.getModel(447)).getValue() != 15 && ((ChoiceModel)this.getModel(447)).getValue() != 16 && ((ChoiceModel)this.getModel(447)).getValue() != 17 && ((ChoiceModel)this.getModel(447)).getValue() != 39 && ((ChoiceModel)this.getModel(447)).getValue() != 40 && ((ChoiceModel)this.getModel(447)).getValue() != 38 && ((ChoiceModel)this.getModel(447)).getValue() != 42 && ((ChoiceModel)this.getModel(447)).getValue() != 18;
            }
            case 703: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4164) Value == 1");
                        return ((ChoiceModel)this.getModel(4164)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 706: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#400357) Value == 0");
                        return ((ChoiceModel)this.getModel(400357)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 719: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4079) Value == 1");
                        return ((ChoiceModel)this.getModel(4079)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#4079) Value == 0");
                        return ((ChoiceModel)this.getModel(4079)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 720: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4079) Value == 1");
                        return ((ChoiceModel)this.getModel(4079)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#4079) Value == 0");
                        return ((ChoiceModel)this.getModel(4079)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 768: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#367) Value == 0");
                        return ((ChoiceModel)this.getModel(367)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#367) Value == 1");
                        return ((ChoiceModel)this.getModel(367)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#367) Value == 1024");
                        return ((ChoiceModel)this.getModel(367)).getValue() == 1024;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 781: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#5535) Value == 2");
                        return ((ChoiceModel)this.getModel(5535)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#5535) Value == 1");
                        return ((ChoiceModel)this.getModel(5535)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 810: {
                this.logCheckGuard("ChoiceModel (MODELID#4384) Value > 0");
                return ((ChoiceModel)this.getModel(4384)).getValue() > 0;
            }
            case 820: {
                this.logCheckGuard("ChoiceModel (MODELID#4451) Value > 0");
                return ((ChoiceModel)this.getModel(4451)).getValue() > 0;
            }
            case 833: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#301049) Value == 1");
                        return ((ChoiceModel)this.getModel(301049)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300852) Value == 8");
                        return ((ChoiceModel)this.getModel(2300852)).getValue() == 8;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 838: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#400871) Value == 2 ) && ( !( ( ChoiceModel (MODELID#402440) Value == 1 ) ) )");
                        return ((ChoiceModel)this.getModel(400871)).getValue() == 2 && ((ChoiceModel)this.getModel(402440)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 848: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#361) Value == 1 )");
                        return ((ChoiceModel)this.getModel(361)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 862: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#4586) Value == 0");
                        return ((ChoiceModel)this.getModel(4586)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#4586) Value == 1");
                        return ((ChoiceModel)this.getModel(4586)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 865: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#48) Status == 0");
                        return ((ChoiceModel)this.getModel(48)).getStatus() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 874: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5600) Value == 1 ) ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5600)).getValue() == 1 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9;
            }
            case 875: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5600) Value == 1 ) )");
                        return ((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5600)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 876: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 881: {
                this.logCheckGuard("( SysConstModel (MODELID#4252) Value == ICoreSysConfig.ON ) && ( SysConstModel (MODELID#474) Value == ICoreSysConfig.OFF )");
                return ((SysConstModel)this.getModel(4252)).getValue() == 1 && ((SysConstModel)this.getModel(474)).getValue() == 0;
            }
            case 883: {
                this.logCheckGuard("( ChoiceModel (MODELID#5593) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                return ((ChoiceModel)this.getModel(5593)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9;
            }
            case 884: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5588) Value == 1 ) ) && ( ChoiceModel (MODELID#8) Value == ICoreSysConfig.APPLICATION_ID_PHONE ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5588)).getValue() == 1 && ((ChoiceModel)this.getModel(8)).getValue() == 4 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9;
            }
            case 885: {
                this.logCheckGuard("( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5600) Value == 1 )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5600)).getValue() == 1;
            }
            case 886: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5600) Value == 1 ) ) && ( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 )");
                        return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5600)).getValue() == 1 && ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 1: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5600) Value == 1 ) ) && ( !( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) )");
                        return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5600)).getValue() == 1 && ((SysConstModel)this.getModel(522)).getValue() != 4;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 889: {
                this.logCheckGuard("!( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5600) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5600)).getValue() != 1;
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

