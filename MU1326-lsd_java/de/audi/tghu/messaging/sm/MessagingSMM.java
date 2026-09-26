/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.BufferedChoiceModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.messaging.sm.MessagingSMMActions;
import de.audi.tghu.messaging.sm.MessagingSMMInitMediators;
import de.audi.tghu.messaging.sm.MessagingSMMInitStates;
import de.audi.tghu.messaging.sm.MessagingSMMInitTransitions;
import java.util.NoSuchElementException;

public class MessagingSMM
extends AbstractAppSMM {
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private MessagingSMMInitStates smmInitStates;
    private MessagingSMMInitTransitions smmInitTransitions;
    private MessagingSMMInitMediators smmInitMediators;
    private MessagingSMMActions smmActions;

    public MessagingSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 22, "MessagingSMM");
    }

    public MessagingSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 22, "MessagingSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new MessagingSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new MessagingSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new MessagingSMMInitMediators(this, this.logChannel);
        this.smmActions = new MessagingSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = -7266048;
        this.popupIDList = new int[]{-1064230656, -1047453440, -1030676224, -1013899008, -997121792, -963567360, -946790144};
        this.popupPriorityList = new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{-661577472, -493805312, 127017216, 1687298304, -1450041088, -1416486656, -1131273984};
        this.popupZPMPriorityList = new int[]{155, 155, 155, 155, 155, 155, 155};
        this.popupZPMSlotList = new int[]{4, 4, 4, 4, 4, 4, 4};
        this.extStateIDList = new int[]{-913235712, 814883072, 1955733760, 1989288192, 1888624896, 1922179328, -1584258816, -1483595520, 1636966656, -1835917056, 1586635008, -1819139840, -1869471488, 412229888, -1768808192, 1502748928, -1802362624, -1785585408, 1485971712, -1701699328, 1452417280, -1735253760, 1435640064, -577625856, -627957504, -1634590464, 395452672, -1668144896, 160571648, -1047387904, -1064165120, -1886248704, -7266048, -1919803136, 93462784, -1936580352};
        this.extStateLabelList = new String[]{"msgSmsFolder", "Office_Detail_Cond", "officeOptSMSEditor", "officeEmailEditorComp", "officeOptMailSendMSGComp", "officeOptSMSSendMSGComp", "officeSmsMainWaitComp", "officeMailMainWaitComp", "officeOptSmsNew", "officeOptSmsDeleteTempAll", "officeOptMailNew", "officeOptSmsDeleteTempAllInclude", "msgOfficePopupSMSStoreTemp", "msgSMSFolderComp", "adbMainWaitComp_officeAddressbookWait", "SMSDesktop", "officeOptSmsDeleteTempOne", "officeOptSMSDeleteTempOneInclude", "IncludeSMSDesktop", "officeOptMailDeleteTempOne", "OfficeDesktop", "officeOptMailDeleteTemp", "IncludeOfficeDesktop", "msgOptEMailSetup", "officeOptTmpl", "officeOptMailStoreDraft", "OPT_SMS", "msgOfficeOptPopupMailStoreTemp", "OfficeOptSMSNewEdit", "IncludeMSGSetup 2", "IncludeMSGSetup", "officeOptSMSStoreTempReplace", "messagingDesktop", "officeOptSMSStoreDraftInclude", "msgMailFolderComp", "OfficeOptSMSStoreDraft"};
        this.incSlotList = new int[]{1418862848, 1435640064, 1485971712, 1553080576, 1620189440, 1871847680, 1905402112, 1938956544, 1972510976, 2106728704, -1970134784, -1953357568, -1919803136, -1903025920, -1852694272, -1819139840, -1785585408, -1768808192, -1718476544, -1684922112, -1651367680, -1617813248, -1601036032, -1500372736, -1399709440, -1366155008, -1332600576, -1315823360, -1282268928, -1215160064, -1114496768, -1080942336, -1064165120, -1047387904, -829284096, -795729664, -778952448, -560848640};
        this.incSlotStateIDList = new int[]{-3, 1452417280, 1502748928, 1586635008, 1636966656, 1888624896, 1922179328, 1955733760, 1989288192, -4, 1989288192, 1955733760, -1936580352, -1886248704, -1869471488, -1835917056, -1802362624, -5, -1735253760, -1701699328, -1668144896, -1634590464, -1584258816, -1483595520, -6, -7, -7, 1955733760, 1989288192, 1586635008, -4, -6, -8, -8, -7, -7, 1586635008, -577625856};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "sysInitAddressbook", "connectivityCenterOnlineCheck", "adbMainWaitComp", "CM_popup_online_errors_licens_check", "toneTouchSliderIncl", "Msg_Setup", "mainWizzard"};
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 2200008: {
                    this.logCheckGuard("( !( ChoiceModel (MODELID#138) Value == 3 ) ) || ( ChoiceModel (MODELID#2200129) Value == 1 )");
                    if (((ChoiceModel)this.getModel(138)).getValue() == 3 && ((ChoiceModel)this.getModel(1100095744)).getValue() != 1) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200129) Value == 1");
                            return ((ChoiceModel)this.getModel(1100095744)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200013: {
                    this.logCheckGuard("!( ChoiceModel (MODELID#17) Value == 2 )");
                    return ((ChoiceModel)this.getModel(17)).getValue() != 2;
                }
                case 2200015: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200352) Value == 0");
                            return ((ChoiceModel)this.getModel(546513152)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200018: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200352) Value == 0");
                            return ((ChoiceModel)this.getModel(546513152)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200020: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2200129) Value == 1 ) || ( !( ChoiceModel (MODELID#138) Value == 3 ) )");
                    if (((ChoiceModel)this.getModel(1100095744)).getValue() != 1 && ((ChoiceModel)this.getModel(138)).getValue() == 3) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200129) Value == 1");
                            return ((ChoiceModel)this.getModel(1100095744)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200095: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BaseListModel (MODELID#2200253) Length > 0");
                            return ((BaseListModel)this.getModel(-1114496768)).getLength() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200096: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BaseListModel (MODELID#2200253) Length > 0");
                            return ((BaseListModel)this.getModel(-1114496768)).getLength() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200128: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200200) Value == 1");
                            return ((ChoiceModel)this.getModel(-2003689216)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200172: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200270) Value == 1");
                            return ((ChoiceModel)this.getModel(-829284096)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200182: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200137) Value == 0");
                            return ((ChoiceModel)this.getModel(1234313472)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200183: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 2");
                            return ((ChoiceModel)this.getModel(-376299264)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 1");
                            return ((ChoiceModel)this.getModel(-376299264)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200190: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200270) Value == 1");
                            return ((ChoiceModel)this.getModel(-829284096)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200198: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 2");
                            return ((ChoiceModel)this.getModel(-376299264)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 1");
                            return ((ChoiceModel)this.getModel(-376299264)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200208: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 0");
                            return ((ChoiceModel)this.getModel(-376299264)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 0x219291: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 0");
                            return ((ChoiceModel)this.getModel(-376299264)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 0x219299: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200270) Value == 1");
                            return ((ChoiceModel)this.getModel(-829284096)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200225: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200300) Value == 2");
                            return ((ChoiceModel)this.getModel(-325967616)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200300) Value == 1");
                            return ((ChoiceModel)this.getModel(-325967616)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200229: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200270) Value == 1");
                            return ((ChoiceModel)this.getModel(-829284096)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200237: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200300) Value == 2");
                            return ((ChoiceModel)this.getModel(-325967616)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200300) Value == 1");
                            return ((ChoiceModel)this.getModel(-325967616)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200240: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#2200400) Value == 1 ) || ( ChoiceModel (MODELID#2200400) Value == 2 ) ) && ( !( ChoiceModel (MODELID#268) Value > 0 ) ) && ( ( SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF ) || ( SysConstModel (MODELID#4368) Value == ICoreSysConfig.ON ) ) && ( !( ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_KOREA ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_TAIWAN ) ) ) ) && ( ( ChoiceModel (MODELID#2200237) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ( ChoiceModel (MODELID#5602) Value == 1 ) || ( ChoiceModel (MODELID#5606) Value == 1 ) ) ) )");
                            return !(((ChoiceModel)this.getModel(1351819520)).getValue() != 1 && ((ChoiceModel)this.getModel(1351819520)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(-1382932224)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200241: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200270) Value == 1");
                            return ((ChoiceModel)this.getModel(-829284096)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200254: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#2200400) Value == 1 ) || ( ChoiceModel (MODELID#2200400) Value == 2 ) ) && ( !( ChoiceModel (MODELID#268) Value > 0 ) ) && ( ( SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF ) || ( SysConstModel (MODELID#4368) Value == ICoreSysConfig.ON ) ) && ( !( ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_KOREA ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_TAIWAN ) ) ) ) && ( ( ChoiceModel (MODELID#2200237) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ( ChoiceModel (MODELID#5602) Value == 1 ) || ( ChoiceModel (MODELID#5606) Value == 1 ) ) ) )");
                            return !(((ChoiceModel)this.getModel(1351819520)).getValue() != 1 && ((ChoiceModel)this.getModel(1351819520)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(-1382932224)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200255: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BaseListModel (MODELID#2200312) Length == 1");
                            return ((BaseListModel)this.getModel(-124641024)).getLength() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200259: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200270) Value == 1");
                            return ((ChoiceModel)this.getModel(-829284096)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200285: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#2200400) Value == 1 ) || ( ChoiceModel (MODELID#2200400) Value == 2 ) ) && ( !( ChoiceModel (MODELID#268) Value > 0 ) ) && ( ( SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF ) || ( SysConstModel (MODELID#4368) Value == ICoreSysConfig.ON ) ) && ( !( ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_KOREA ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_TAIWAN ) ) ) ) && ( ( ChoiceModel (MODELID#2200237) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ( ChoiceModel (MODELID#5602) Value == 1 ) || ( ChoiceModel (MODELID#5606) Value == 1 ) ) ) )");
                            return !(((ChoiceModel)this.getModel(1351819520)).getValue() != 1 && ((ChoiceModel)this.getModel(1351819520)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(-1382932224)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200287: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#2200400) Value == 1 ) || ( ChoiceModel (MODELID#2200400) Value == 2 ) ) && ( !( ChoiceModel (MODELID#268) Value > 0 ) ) && ( ( SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF ) || ( SysConstModel (MODELID#4368) Value == ICoreSysConfig.ON ) ) && ( !( ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_KOREA ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_TAIWAN ) ) ) ) && ( ( ChoiceModel (MODELID#2200237) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ( ChoiceModel (MODELID#5602) Value == 1 ) || ( ChoiceModel (MODELID#5606) Value == 1 ) ) ) )");
                            return !(((ChoiceModel)this.getModel(1351819520)).getValue() != 1 && ((ChoiceModel)this.getModel(1351819520)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(-1382932224)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200326: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 0");
                            return ((ChoiceModel)this.getModel(-1517149952)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 1");
                            return ((ChoiceModel)this.getModel(-1517149952)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200331: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 0");
                            return ((ChoiceModel)this.getModel(-1517149952)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 1");
                            return ((ChoiceModel)this.getModel(-1517149952)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200362: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200137) Value == 0");
                            return ((ChoiceModel)this.getModel(1234313472)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200372: {
                    this.logCheckGuard("ChoiceModel (MODELID#268) Value > 0");
                    return ((ChoiceModel)this.getModel(268)).getValue() > 0;
                }
                case 2200377: {
                    this.logCheckGuard("SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF");
                    return ((SysConstModel)this.getModel(4062)).getValue() == 0;
                }
                case 2200463: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#350) Value == 1 ) && ( ChoiceModel (MODELID#15) Value == 1 )");
                            return ((ChoiceModel)this.getModel(350)).getValue() == 1 && ((ChoiceModel)this.getModel(15)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200521: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BaseListModel (MODELID#2200312) Length == 1");
                            return ((BaseListModel)this.getModel(-124641024)).getLength() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200531: {
                    this.logCheckGuard("BufferedChoiceModel (MODELID#2200143) Value == 1");
                    return ((BufferedChoiceModel)this.getModel(1334976768)).getValue() == 1;
                }
                case 2200536: {
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
                case 2200538: {
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
                case 2200542: {
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
                case 2200544: {
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
                case 2200557: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( BaseListModel (MODELID#2200312) Length == 1 )");
                            return ((BaseListModel)this.getModel(-124641024)).getLength() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200563: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BaseListModel (MODELID#2200312) Length == 1");
                            return ((BaseListModel)this.getModel(-124641024)).getLength() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200579: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 1");
                            return ((ChoiceModel)this.getModel(-1517149952)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 2");
                            return ((ChoiceModel)this.getModel(-1517149952)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200580: {
                    this.logCheckGuard("ChoiceModel (MODELID#2200403) Value == 1");
                    return ((ChoiceModel)this.getModel(1402151168)).getValue() == 1;
                }
                case 2200584: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 1");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200591: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 1");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200594: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#2200400) Value == 1 ) || ( ChoiceModel (MODELID#2200400) Value == 2 ) ) && ( !( ChoiceModel (MODELID#268) Value > 0 ) ) && ( ( SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF ) || ( SysConstModel (MODELID#4368) Value == ICoreSysConfig.ON ) ) && ( !( ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_KOREA ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_TAIWAN ) ) ) ) && ( ( ChoiceModel (MODELID#2200237) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ( ChoiceModel (MODELID#5602) Value == 1 ) || ( ChoiceModel (MODELID#5606) Value == 1 ) ) ) )");
                            return !(((ChoiceModel)this.getModel(1351819520)).getValue() != 1 && ((ChoiceModel)this.getModel(1351819520)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(-1382932224)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200595: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#2200400) Value == 1 ) || ( ChoiceModel (MODELID#2200400) Value == 2 ) ) && ( !( ChoiceModel (MODELID#268) Value > 0 ) ) && ( ( SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF ) || ( SysConstModel (MODELID#4368) Value == ICoreSysConfig.ON ) ) && ( !( ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_KOREA ) || ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_TAIWAN ) ) ) ) && ( ( ChoiceModel (MODELID#2200237) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ( ChoiceModel (MODELID#5602) Value == 1 ) || ( ChoiceModel (MODELID#5606) Value == 1 ) ) ) )");
                            return !(((ChoiceModel)this.getModel(1351819520)).getValue() != 1 && ((ChoiceModel)this.getModel(1351819520)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(-1382932224)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200613: {
                    this.logCheckGuard("ChoiceModel (MODELID#268) Value > 0");
                    return ((ChoiceModel)this.getModel(268)).getValue() > 0;
                }
                case 2200616: {
                    this.logCheckGuard("SysConstModel (MODELID#4062) Value == ICoreSysConfig.OFF");
                    return ((SysConstModel)this.getModel(4062)).getValue() == 0;
                }
                case 2200662: {
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
                case 2200664: {
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
                case 2200669: {
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
                case 2200671: {
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
                case 2200696: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 1");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200697: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2200430) Value == 3 ) || ( ChoiceModel (MODELID#2200430) Value == 4 )");
                            return ((ChoiceModel)this.getModel(1855136000)).getValue() == 3 || ((ChoiceModel)this.getModel(1855136000)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200699: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 1");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(1301487872)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2200719: {
                    this.logCheckGuard("( ChoiceModel (MODELID#5588) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                    return ((ChoiceModel)this.getModel(5588)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
                }
                case 2200722: {
                    this.logCheckGuard("SysConstModel (MODELID#4062) Value == ICoreSysConfig.ON");
                    return ((SysConstModel)this.getModel(4062)).getValue() == 1;
                }
            }
            return this.checkGuardSub1(n, n2);
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[MessagingSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[MessagingSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(-2137614336, "[MessagingSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[MessagingSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 2200723: {
                this.logCheckGuard("SysConstModel (MODELID#4062) Value == ICoreSysConfig.ON");
                return ((SysConstModel)this.getModel(4062)).getValue() == 1;
            }
            case 2200732: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5588) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5588)).getValue() == 1;
            }
            case 2200733: {
                this.logCheckGuard("( ChoiceModel (MODELID#5588) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                return ((ChoiceModel)this.getModel(5588)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 2200734: {
                this.logCheckGuard("( ChoiceModel (MODELID#5588) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                return ((ChoiceModel)this.getModel(5588)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9;
            }
            case 2200735: {
                this.logCheckGuard("( ChoiceModel (MODELID#5588) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                return ((ChoiceModel)this.getModel(5588)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 2200736: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5588) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5588)).getValue() == 1;
            }
            case 2200737: {
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

