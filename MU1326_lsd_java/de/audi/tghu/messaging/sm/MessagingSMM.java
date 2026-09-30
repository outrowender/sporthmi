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
    public static final int MODULE_ID = 22;
    public static final String SMM_NAME = "MessagingSMM";
    private MessagingSMMInitStates smmInitStates;
    private MessagingSMMInitTransitions smmInitTransitions;
    private MessagingSMMInitMediators smmInitMediators;
    private MessagingSMMActions smmActions;

    public MessagingSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 22, SMM_NAME);
    }

    public MessagingSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 22, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new MessagingSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new MessagingSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new MessagingSMMInitMediators(this, this.logChannel);
        this.smmActions = new MessagingSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 2200063;
        this.popupIDList = new int[]{2200000, 2200001, 2200002, 2200003, 2200004, 2200006, 2200007};
        this.popupPriorityList = new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{2200024, 2200034, 2200071, 2200164, 2200233, 2200235, 2200252};
        this.popupZPMPriorityList = new int[]{155, 155, 155, 155, 155, 155, 155};
        this.popupZPMSlotList = new int[]{4, 4, 4, 4, 4, 4, 4};
        this.extStateIDList = new int[]{2200009, 2200112, 2200180, 2200182, 2200176, 2200178, 2200225, 2200231, 2200161, 0x219292, 2200158, 2200211, 2200208, 2200088, 2200214, 2200153, 2200212, 2200213, 2200152, 2200218, 2200150, 2200216, 2200149, 2200285, 2200282, 2200222, 2200087, 2200220, 2200073, 2200257, 2200256, 2200207, 2200063, 2200205, 2200069, 2200204};
        this.extStateLabelList = new String[]{"msgSmsFolder", "Office_Detail_Cond", "officeOptSMSEditor", "officeEmailEditorComp", "officeOptMailSendMSGComp", "officeOptSMSSendMSGComp", "officeSmsMainWaitComp", "officeMailMainWaitComp", "officeOptSmsNew", "officeOptSmsDeleteTempAll", "officeOptMailNew", "officeOptSmsDeleteTempAllInclude", "msgOfficePopupSMSStoreTemp", "msgSMSFolderComp", "adbMainWaitComp_officeAddressbookWait", "SMSDesktop", "officeOptSmsDeleteTempOne", "officeOptSMSDeleteTempOneInclude", "IncludeSMSDesktop", "officeOptMailDeleteTempOne", "OfficeDesktop", "officeOptMailDeleteTemp", "IncludeOfficeDesktop", "msgOptEMailSetup", "officeOptTmpl", "officeOptMailStoreDraft", "OPT_SMS", "msgOfficeOptPopupMailStoreTemp", "OfficeOptSMSNewEdit", "IncludeMSGSetup 2", "IncludeMSGSetup", "officeOptSMSStoreTempReplace", "messagingDesktop", "officeOptSMSStoreDraftInclude", "msgMailFolderComp", "OfficeOptSMSStoreDraft"};
        this.incSlotList = new int[]{2200148, 2200149, 2200152, 2200156, 2200160, 2200175, 2200177, 2200179, 2200181, 2200189, 2200202, 2200203, 2200205, 2200206, 0x219291, 2200211, 2200213, 2200214, 0x219299, 2200219, 2200221, 2200223, 2200224, 2200230, 2200236, 2200238, 2200240, 2200241, 2200243, 2200247, 2200253, 2200255, 2200256, 2200257, 2200270, 2200272, 2200273, 2200286};
        this.incSlotStateIDList = new int[]{-3, 2200150, 2200153, 2200158, 2200161, 2200176, 2200178, 2200180, 2200182, -4, 2200182, 2200180, 2200204, 2200207, 2200208, 0x219292, 2200212, -5, 2200216, 2200218, 2200220, 2200222, 2200225, 2200231, -6, -7, -7, 2200180, 2200182, 2200158, -4, -6, -8, -8, -7, -7, 2200158, 2200285};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "sysInitAddressbook", "connectivityCenterOnlineCheck", "adbMainWaitComp", "CM_popup_online_errors_licens_check", "toneTouchSliderIncl", "Msg_Setup", "mainWizzard"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 2200008: {
                    this.logCheckGuard("( !( ChoiceModel (MODELID#138) Value == 3 ) ) || ( ChoiceModel (MODELID#2200129) Value == 1 )");
                    if (((ChoiceModel)this.getModel(138)).getValue() == 3 && ((ChoiceModel)this.getModel(2200129)).getValue() != 1) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200129) Value == 1");
                            return ((ChoiceModel)this.getModel(2200129)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200352)).getValue() == 0;
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
                            return ((ChoiceModel)this.getModel(2200352)).getValue() == 0;
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
                    if (((ChoiceModel)this.getModel(2200129)).getValue() != 1 && ((ChoiceModel)this.getModel(138)).getValue() == 3) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200129) Value == 1");
                            return ((ChoiceModel)this.getModel(2200129)).getValue() == 1;
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
                            return ((BaseListModel)this.getModel(2200253)).getLength() > 0;
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
                            return ((BaseListModel)this.getModel(2200253)).getLength() > 0;
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
                            return ((ChoiceModel)this.getModel(2200200)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200270)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200137)).getValue() == 0;
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
                            return ((ChoiceModel)this.getModel(2200297)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 1");
                            return ((ChoiceModel)this.getModel(2200297)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200270)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200297)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200297) Value == 1");
                            return ((ChoiceModel)this.getModel(2200297)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200297)).getValue() == 0;
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
                            return ((ChoiceModel)this.getModel(2200297)).getValue() == 0;
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
                            return ((ChoiceModel)this.getModel(2200270)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200300)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200300) Value == 1");
                            return ((ChoiceModel)this.getModel(2200300)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200270)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200300)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200300) Value == 1");
                            return ((ChoiceModel)this.getModel(2200300)).getValue() == 1;
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
                            return !(((ChoiceModel)this.getModel(2200400)).getValue() != 1 && ((ChoiceModel)this.getModel(2200400)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(2200237)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
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
                            return ((ChoiceModel)this.getModel(2200270)).getValue() == 1;
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
                            return !(((ChoiceModel)this.getModel(2200400)).getValue() != 1 && ((ChoiceModel)this.getModel(2200400)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(2200237)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
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
                            return ((BaseListModel)this.getModel(2200312)).getLength() == 1;
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
                            return ((ChoiceModel)this.getModel(2200270)).getValue() == 1;
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
                            return !(((ChoiceModel)this.getModel(2200400)).getValue() != 1 && ((ChoiceModel)this.getModel(2200400)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(2200237)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
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
                            return !(((ChoiceModel)this.getModel(2200400)).getValue() != 1 && ((ChoiceModel)this.getModel(2200400)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(2200237)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
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
                            return ((ChoiceModel)this.getModel(2200229)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 1");
                            return ((ChoiceModel)this.getModel(2200229)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200229)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 1");
                            return ((ChoiceModel)this.getModel(2200229)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(2200137)).getValue() == 0;
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
                            return ((BaseListModel)this.getModel(2200312)).getLength() == 1;
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
                    return ((BufferedChoiceModel)this.getModel(2200143)).getValue() == 1;
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
                            return ((BaseListModel)this.getModel(2200312)).getLength() == 1;
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
                            return ((BaseListModel)this.getModel(2200312)).getLength() == 1;
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
                            return ((ChoiceModel)this.getModel(2200229)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200229) Value == 2");
                            return ((ChoiceModel)this.getModel(2200229)).getValue() == 2;
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
                    return ((ChoiceModel)this.getModel(2200403)).getValue() == 1;
                }
                case 2200584: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 1");
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 2;
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
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 2;
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
                            return !(((ChoiceModel)this.getModel(2200400)).getValue() != 1 && ((ChoiceModel)this.getModel(2200400)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(2200237)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
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
                            return !(((ChoiceModel)this.getModel(2200400)).getValue() != 1 && ((ChoiceModel)this.getModel(2200400)).getValue() != 2 || ((ChoiceModel)this.getModel(268)).getValue() > 0 || ((SysConstModel)this.getModel(4062)).getValue() != 0 && ((SysConstModel)this.getModel(4368)).getValue() != 1 || ((SysConstModel)this.getModel(442)).getValue() == 3 || ((SysConstModel)this.getModel(442)).getValue() == 2 || ((SysConstModel)this.getModel(442)).getValue() == 4 || ((SysConstModel)this.getModel(442)).getValue() == 5 || ((ChoiceModel)this.getModel(2200237)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5602)).getValue() != 1 && ((ChoiceModel)this.getModel(5606)).getValue() != 1));
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
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 2;
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
                            return ((ChoiceModel)this.getModel(2200430)).getValue() == 3 || ((ChoiceModel)this.getModel(2200430)).getValue() == 4;
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
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2200397) Value == 2");
                            return ((ChoiceModel)this.getModel(2200397)).getValue() == 2;
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
        this.smLogChannel.log(10000000, "[MessagingSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[MessagingSMM.java#checkGuard] checking: '%1'", (Object)string);
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

