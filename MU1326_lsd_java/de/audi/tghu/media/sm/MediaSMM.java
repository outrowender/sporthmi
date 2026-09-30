/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.media.sm.MediaSMMActions;
import de.audi.tghu.media.sm.MediaSMMInitMediators;
import de.audi.tghu.media.sm.MediaSMMInitStates;
import de.audi.tghu.media.sm.MediaSMMInitTransitions;
import java.util.NoSuchElementException;

public class MediaSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 2;
    public static final String SMM_NAME = "MediaSMM";
    private MediaSMMInitStates smmInitStates;
    private MediaSMMInitTransitions smmInitTransitions;
    private MediaSMMInitMediators smmInitMediators;
    private MediaSMMActions smmActions;

    public MediaSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 2, SMM_NAME);
    }

    public MediaSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 2, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new MediaSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new MediaSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new MediaSMMInitMediators(this, this.logChannel);
        this.smmActions = new MediaSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 200029;
        this.popupIDList = new int[]{200000, 200001, 200002, 200003, 200004, 200005, 200006, 200007, 200008, 200009};
        this.popupPriorityList = new int[]{200, 200, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{200105, 200129, 200134, 200136, 200138, 200140, 200142, 200145, 200173, 200219};
        this.popupZPMPriorityList = new int[]{155, 155, 155, 155, 155, 155, 155, 155, 155, 155};
        this.popupZPMSlotList = new int[]{9, 9, 4, 4, 4, 4, 4, 4, 4, 9};
        this.extStateIDList = new int[]{200029, 200031, 200024, 200191, 200088, 200042, 200041, 200244, 200107, 200247, 200110, 200241};
        this.extStateLabelList = new String[]{"mediaDesktop", "mediaDesktopMain", "mediaData", "Media_Online_Comp", "mediaDesktopTypesSelectDesktop", "mediaInvalidBtaudio", "mediaInvalid", "mediaToOnlineDrawerOption", "MediaStateChangeComp", "mediaToOnline_Comp", "mediaBrowserDesktop", "mediaToOnlineDrawer"};
        this.incSlotList = new int[]{200096, 200169, 200178, 200181, 200189, 200202, 200207, 200209, 200242, 200245, 200249, 200252, 200255};
        this.incSlotStateIDList = new int[]{-3, -4, -5, -5, -6, -7, -5, -5, -8, -6, -9, -5, -10};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "toneSystem", "settingsFactory", "connectivityCenter", "onlineDesktopMain", "popupHelpBordbuch", "onlineBundleInitCheck", "cmOptBluetooth", "toneTouchSliderIncl", "sysInitTV", "mainWizzard", "mainWizardRootState"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 200007: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200644) Value == 0");
                            return ((ChoiceModel)this.getModel(200644)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200233) Value == 0");
                            return ((ChoiceModel)this.getModel(200233)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200008: {
                    this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200259) Value == 4 ) || ( ChoiceModel (MODELID#200259) Value == 5 ) ) ) && ( ChoiceModel (MODELID#200853) Value == 0 )");
                    return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200259)).getValue() != 4 && ((ChoiceModel)this.getModel(200259)).getValue() != 5 && ((ChoiceModel)this.getModel(200853)).getValue() == 0;
                }
                case 200009: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200644) Value == 0");
                            return ((ChoiceModel)this.getModel(200644)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200233) Value == 0");
                            return ((ChoiceModel)this.getModel(200233)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200657) Value == 1 ) && ( !( ChoiceModel (MODELID#200603) Value == 0 ) ) && ( !( ChoiceModel (MODELID#200233) Value == 0 ) )");
                            return ((ChoiceModel)this.getModel(200657)).getValue() == 1 && ((ChoiceModel)this.getModel(200603)).getValue() != 0 && ((ChoiceModel)this.getModel(200233)).getValue() != 0;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200028: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200033: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 )");
                            return ((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200034: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 6");
                            return ((ChoiceModel)this.getModel(200526)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                            return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200522) Value == 0 ) && ( ChoiceModel (MODELID#200526) Value == 1 )");
                            return ((ChoiceModel)this.getModel(200522)).getValue() == 0 && ((ChoiceModel)this.getModel(200526)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 5");
                            return ((ChoiceModel)this.getModel(200526)).getValue() == 5;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 0");
                            return ((ChoiceModel)this.getModel(200526)).getValue() == 0;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 7");
                            return ((ChoiceModel)this.getModel(200526)).getValue() == 7;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 8");
                            return ((ChoiceModel)this.getModel(200526)).getValue() == 8;
                        }
                        case 7: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200522) Value == 1 ) && ( ChoiceModel (MODELID#200526) Value == 1 )");
                            return ((ChoiceModel)this.getModel(200522)).getValue() == 1 && ((ChoiceModel)this.getModel(200526)).getValue() == 1;
                        }
                        case 8: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200039: {
                    this.logCheckGuard("!( ChoiceModel (MODELID#200823) Value == 1 )");
                    return ((ChoiceModel)this.getModel(200823)).getValue() != 1;
                }
                case 200050: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200530) Value == 8");
                            return ((ChoiceModel)this.getModel(200530)).getValue() == 8;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200530) Value == 7");
                            return ((ChoiceModel)this.getModel(200530)).getValue() == 7;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200054: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 17 ) || ( ChoiceModel (MODELID#200537) Status == 19 ) || ( ChoiceModel (MODELID#200537) Status == 20 ) || ( ChoiceModel (MODELID#200537) Status == 50 ) || ( ChoiceModel (MODELID#200537) Status == 51 ) || ( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ( ChoiceModel (MODELID#200530) Value == 9 ) || ( ChoiceModel (MODELID#200530) Value == 10 ) ) )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 17 || ((ChoiceModel)this.getModel(200537)).getStatus() == 19 || ((ChoiceModel)this.getModel(200537)).getStatus() == 20 || ((ChoiceModel)this.getModel(200537)).getStatus() == 50 || ((ChoiceModel)this.getModel(200537)).getStatus() == 51 || ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && (((ChoiceModel)this.getModel(200530)).getValue() == 9 || ((ChoiceModel)this.getModel(200530)).getValue() == 10);
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 21 ) || ( ChoiceModel (MODELID#200537) Status == 22 ) || ( ChoiceModel (MODELID#200537) Status == 23 ) || ( ChoiceModel (MODELID#200537) Status == 24 ) || ( ChoiceModel (MODELID#200537) Status == 25 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 21 || ((ChoiceModel)this.getModel(200537)).getStatus() == 22 || ((ChoiceModel)this.getModel(200537)).getStatus() == 23 || ((ChoiceModel)this.getModel(200537)).getStatus() == 24 || ((ChoiceModel)this.getModel(200537)).getStatus() == 25;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status < 2 ) && ( ChoiceModel (MODELID#200537) Value > -1 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() < 2 && ((ChoiceModel)this.getModel(200537)).getValue() > -1;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 60 ) || ( ChoiceModel (MODELID#200537) Status == 18 ) || ( ChoiceModel (MODELID#200537) Status == 61 ) || ( ChoiceModel (MODELID#200537) Status == 26 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 60 || ((ChoiceModel)this.getModel(200537)).getStatus() == 18 || ((ChoiceModel)this.getModel(200537)).getStatus() == 61 || ((ChoiceModel)this.getModel(200537)).getStatus() == 26;
                        }
                        case 4: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 14 ) || ( ChoiceModel (MODELID#200537) Status == 15 ) || ( ChoiceModel (MODELID#200537) Status == 16 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 14 || ((ChoiceModel)this.getModel(200537)).getStatus() == 15 || ((ChoiceModel)this.getModel(200537)).getStatus() == 16;
                        }
                        case 5: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 41 ) || ( ChoiceModel (MODELID#200537) Status == 42 ) || ( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ChoiceModel (MODELID#200530) Value == 12 ) ) || ( ChoiceModel (MODELID#200537) Status == 62 ) || ( ChoiceModel (MODELID#200537) Status == 63 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 41 || ((ChoiceModel)this.getModel(200537)).getStatus() == 42 || ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && ((ChoiceModel)this.getModel(200530)).getValue() == 12 || ((ChoiceModel)this.getModel(200537)).getStatus() == 62 || ((ChoiceModel)this.getModel(200537)).getStatus() == 63;
                        }
                        case 6: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 43 ) || ( ChoiceModel (MODELID#200537) Status == 44 ) || ( ChoiceModel (MODELID#200537) Status == 45 ) || ( ChoiceModel (MODELID#200537) Status == 46 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 43 || ((ChoiceModel)this.getModel(200537)).getStatus() == 44 || ((ChoiceModel)this.getModel(200537)).getStatus() == 45 || ((ChoiceModel)this.getModel(200537)).getStatus() == 46;
                        }
                        case 7: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200060: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 42 ) && ( !( ( ChoiceModel (MODELID#3913) Value == 1 ) ) )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 42 && ((ChoiceModel)this.getModel(3913)).getValue() != 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 41");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 41;
                        }
                        case 2: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ChoiceModel (MODELID#200530) Value == 12 ) ) || ( ChoiceModel (MODELID#200537) Status == 62 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && ((ChoiceModel)this.getModel(200530)).getValue() == 12 || ((ChoiceModel)this.getModel(200537)).getStatus() == 62;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 63");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 63;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200061: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("!( ChoiceModel (MODELID#4239) Value == 0 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() != 0;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 23 ) || ( ChoiceModel (MODELID#200537) Status == 21 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 23 || ((ChoiceModel)this.getModel(200537)).getStatus() == 21;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 22");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 22;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 24");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 24;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 25");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 25;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200062: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 20");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 20;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 10 ) && ( ( ChoiceModel (MODELID#200530) Value == 9 ) || ( ChoiceModel (MODELID#200530) Value == 10 ) )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && (((ChoiceModel)this.getModel(200530)).getValue() == 9 || ((ChoiceModel)this.getModel(200530)).getValue() == 10);
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 19");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 19;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 50 ) || ( ChoiceModel (MODELID#200537) Status == 51 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 50 || ((ChoiceModel)this.getModel(200537)).getStatus() == 51;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200063: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 18");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 18;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 61");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 61;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 60 ) && ( SysConstModel (MODELID#482) Value == 0 ) && ( SysConstModel (MODELID#481) Value == 0 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 60 && ((SysConstModel)this.getModel(482)).getValue() == 0 && ((SysConstModel)this.getModel(481)).getValue() == 0;
                        }
                        case 3: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#200537) Status == 60 ) && ( ( !( SysConstModel (MODELID#482) Value == 0 ) ) || ( !( SysConstModel (MODELID#481) Value == 0 ) ) ) )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 60 && (((SysConstModel)this.getModel(482)).getValue() != 0 || ((SysConstModel)this.getModel(481)).getValue() != 0);
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 26");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 26;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200064: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 15");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 15;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 14 )");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 14;
                        }
                        case 2: {
                            this.logCheckGuard("0 == 16");
                            return false;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200065: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 10");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 10;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 13");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 13;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 11");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 11;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 12");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 12;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 19");
                            return ((ChoiceModel)this.getModel(200537)).getStatus() == 19;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200070: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200669) Status == 0");
                            return ((ChoiceModel)this.getModel(200669)).getStatus() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("!( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                            return ((ChoiceModel)this.getModel(200573)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200091: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#201012) Status == 0");
                            return ((ChoiceModel)this.getModel(201012)).getStatus() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200259) Value == 4 ) || ( ChoiceModel (MODELID#200259) Value == 5 ) ) )");
                            return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200259)).getValue() != 4 && ((ChoiceModel)this.getModel(200259)).getValue() != 5;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200096: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) ) )");
                            return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200573)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                            return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && (((ChoiceModel)this.getModel(200573)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1);
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200097: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) ) )");
                            return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200573)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                            return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && (((ChoiceModel)this.getModel(200573)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1);
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200115: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#200614) Value > 1 )");
                            return ((ChoiceModel)this.getModel(200614)).getValue() > 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#200617) Value == 0");
                            return ((ChoiceModel)this.getModel(200617)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#200617) Value == 1");
                            return ((ChoiceModel)this.getModel(200617)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200119: {
                    this.logCheckGuard("ChoiceModel (MODELID#200629) Value == 1");
                    if (((ChoiceModel)this.getModel(200629)).getValue() != 1) {
                        return false;
                    }
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
                case 200126: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#200452) Value == 1");
                            return ((ChoiceModel)this.getModel(200452)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 200132: {
                    this.logCheckGuard("ChoiceModel (MODELID#200452) Value == 1");
                    return ((ChoiceModel)this.getModel(200452)).getValue() == 1;
                }
            }
            return this.checkGuardSub1(n, n2);
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[MediaSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[MediaSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[MediaSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[MediaSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 200136: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) ) )");
                        return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200573)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                        return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && (((ChoiceModel)this.getModel(200573)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1);
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200139: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 1");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 5");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 5;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 10");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 10;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 8");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 8;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 6");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 6;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 6");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 6;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 3");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 3;
                    }
                    case 7: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 7");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 7;
                    }
                    case 8: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 4");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 4;
                    }
                    case 9: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 9");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 9;
                    }
                    case 10: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 2");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 2;
                    }
                    case 11: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200628) Value == 11 ) && ( !( ChoiceModel (MODELID#200623) Value == 1 ) )");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 11 && ((ChoiceModel)this.getModel(200623)).getValue() != 1;
                    }
                    case 12: {
                        this.logCheckGuard("ChoiceModel (MODELID#200623) Value == 1");
                        return ((ChoiceModel)this.getModel(200623)).getValue() == 1;
                    }
                    case 13: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 12");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 12;
                    }
                    case 14: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200140: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200603) Value == 1");
                        return ((ChoiceModel)this.getModel(200603)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200142: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#200628) Value == 1 ) ) || ( ( !( ChoiceModel (MODELID#200628) Value == 1 ) ) && ( ( ( ( ChoiceModel (MODELID#200538) Value & 2 ) == 2 ) && ( ( !( ChoiceModel (MODELID#200529) Value == 19 ) ) || ( ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 1 ) ) ) ) || ( ( ( ChoiceModel (MODELID#200538) Value & 1 ) == 1 ) && ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 0 ) ) ) )");
                return ((ChoiceModel)this.getModel(200628)).getValue() == 1 || ((ChoiceModel)this.getModel(200628)).getValue() != 1 && ((((ChoiceModel)this.getModel(200538)).getValue() & 2) == 2 && (((ChoiceModel)this.getModel(200529)).getValue() != 19 || ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 1) || (((ChoiceModel)this.getModel(200538)).getValue() & 1) == 1 && ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 0);
            }
            case 200149: {
                this.logCheckGuard("( ChoiceModel (MODELID#200629) Value == 0 )");
                return ((ChoiceModel)this.getModel(200629)).getValue() == 0;
            }
            case 200150: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#200628) Value == 1 ) ) || ( ( !( ChoiceModel (MODELID#200628) Value == 1 ) ) && ( ( ( ( ChoiceModel (MODELID#200538) Value & 2 ) == 2 ) && ( ( !( ChoiceModel (MODELID#200529) Value == 19 ) ) || ( ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 1 ) ) ) ) || ( ( ( ChoiceModel (MODELID#200538) Value & 1 ) == 1 ) && ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 0 ) ) ) )");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 1 || ((ChoiceModel)this.getModel(200628)).getValue() != 1 && ((((ChoiceModel)this.getModel(200538)).getValue() & 2) == 2 && (((ChoiceModel)this.getModel(200529)).getValue() != 19 || ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 1) || (((ChoiceModel)this.getModel(200538)).getValue() & 1) == 1 && ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 0);
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200160: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200232) Value == 0");
                        return ((ChoiceModel)this.getModel(200232)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200164: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                        return ((ChoiceModel)this.getModel(200573)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200166: {
                this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200259) Value == 4 ) || ( ChoiceModel (MODELID#200259) Value == 5 ) ) )");
                return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200259)).getValue() != 4 && ((ChoiceModel)this.getModel(200259)).getValue() != 5;
            }
            case 200179: {
                this.logCheckGuard("ChoiceModel (MODELID#200452) Value == 1");
                return ((ChoiceModel)this.getModel(200452)).getValue() == 1;
            }
            case 200194: {
                this.logCheckGuard("ChoiceModel (MODELID#200251) Value == 0");
                return ((ChoiceModel)this.getModel(200251)).getValue() == 0;
            }
            case 200196: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200529) Value == 19 ) && ( ( SysConstModel (MODELID#5572) Value == 2 ) ) && ( ChoiceModel (MODELID#201118) Value == 7 )");
                        return ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((SysConstModel)this.getModel(5572)).getValue() == 2 && ((ChoiceModel)this.getModel(201118)).getValue() == 7;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200197: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( !( ChoiceModel (MODELID#200628) Value == 20 ) ) && ( !( ChoiceModel (MODELID#200628) Value == 21 ) ) && ( !( ChoiceModel (MODELID#200526) Value == 8 ) ) && ( !( ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200628) Value == 2 ) && ( ( SysConstModel (MODELID#5572) Value == 2 ) ) ) )");
                        return ((ChoiceModel)this.getModel(200628)).getValue() != 20 && ((ChoiceModel)this.getModel(200628)).getValue() != 21 && ((ChoiceModel)this.getModel(200526)).getValue() != 8 && (((ChoiceModel)this.getModel(200529)).getValue() != 19 || ((ChoiceModel)this.getModel(200628)).getValue() != 2 || ((SysConstModel)this.getModel(5572)).getValue() != 2);
                    }
                    case 1: {
                        this.logCheckGuard("( !( ChoiceModel (MODELID#200628) Value == 20 ) ) && ( !( ChoiceModel (MODELID#200628) Value == 21 ) ) && ( ChoiceModel (MODELID#200526) Value == 8 ) && ( !( ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200628) Value == 2 ) && ( ( SysConstModel (MODELID#5572) Value == 2 ) ) ) )");
                        return ((ChoiceModel)this.getModel(200628)).getValue() != 20 && ((ChoiceModel)this.getModel(200628)).getValue() != 21 && ((ChoiceModel)this.getModel(200526)).getValue() == 8 && (((ChoiceModel)this.getModel(200529)).getValue() != 19 || ((ChoiceModel)this.getModel(200628)).getValue() != 2 || ((SysConstModel)this.getModel(5572)).getValue() != 2);
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200628) Value == 2 ) && ( ( SysConstModel (MODELID#5572) Value == 2 ) )");
                        return ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200628)).getValue() == 2 && ((SysConstModel)this.getModel(5572)).getValue() == 2;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200199: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200200: {
                this.logCheckGuard("!( ChoiceModel (MODELID#200537) Value == 1 )");
                return ((ChoiceModel)this.getModel(200537)).getValue() != 1;
            }
            case 200201: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) ) && ( ( ChoiceModel (MODELID#200526) Value == 2 ) || ( ( ChoiceModel (MODELID#200638) Value == 1 ) && ( ChoiceModel (MODELID#200526) Value == 1 ) ) )");
                        return (((ChoiceModel)this.getModel(200573)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1) && (((ChoiceModel)this.getModel(200526)).getValue() == 2 || ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200526)).getValue() == 1);
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200526) Value == 1 ) && ( ChoiceModel (MODELID#200638) Value == 1 )");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 1 && ((ChoiceModel)this.getModel(200638)).getValue() == 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200212: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 4");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 4;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 7");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 7;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 1");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 1;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 11");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 11;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 2");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 2;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 8");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 8;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 6");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 6;
                    }
                    case 7: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 0");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 0;
                    }
                    case 8: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 5");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 5;
                    }
                    case 9: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 10");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 10;
                    }
                    case 10: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 9");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 9;
                    }
                    case 11: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 3");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 3;
                    }
                    case 12: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 12");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 12;
                    }
                    case 13: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200224: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200616) Value > 0 ) && ( !( ChoiceModel (MODELID#200616) Value == 11 ) )");
                        return ((ChoiceModel)this.getModel(200616)).getValue() > 0 && ((ChoiceModel)this.getModel(200616)).getValue() != 11;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200616) Value == 11 ) && ( ChoiceModel (MODELID#200616) Value > 0 )");
                        return ((ChoiceModel)this.getModel(200616)).getValue() == 11 && ((ChoiceModel)this.getModel(200616)).getValue() > 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200227: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200532) Value == 1 ) && ( ChoiceModel (MODELID#200526) Value == 1 ) && ( ChoiceModel (MODELID#200617) Value == 1 )");
                        return ((ChoiceModel)this.getModel(200532)).getValue() == 1 && ((ChoiceModel)this.getModel(200526)).getValue() == 1 && ((ChoiceModel)this.getModel(200617)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200228: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 6");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 6;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200522) Value == 0 ) && ( ChoiceModel (MODELID#200526) Value == 1 )");
                        return ((ChoiceModel)this.getModel(200522)).getValue() == 0 && ((ChoiceModel)this.getModel(200526)).getValue() == 1;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 5");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 5;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 0");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 0;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 7");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 7;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 8");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 8;
                    }
                    case 7: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200522) Value == 1 ) && ( ChoiceModel (MODELID#200526) Value == 1 )");
                        return ((ChoiceModel)this.getModel(200522)).getValue() == 1 && ((ChoiceModel)this.getModel(200526)).getValue() == 1;
                    }
                    case 8: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200244: {
                this.logCheckGuard("!( ChoiceModel (MODELID#200809) Value == 1 )");
                if (((ChoiceModel)this.getModel(200809)).getValue() == 1) {
                    return false;
                }
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200623) Value == 1");
                        return ((ChoiceModel)this.getModel(200623)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200245: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200628) Value == 11");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 11;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200249: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200657) Value == 1 ) && ( !( ChoiceModel (MODELID#200603) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(200657)).getValue() == 1 && ((ChoiceModel)this.getModel(200603)).getValue() != 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200254: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200155) Value == 2");
                        return ((ChoiceModel)this.getModel(200155)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200257: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200669) Status == 0");
                        return ((ChoiceModel)this.getModel(200669)).getStatus() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200265: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300989) Value == 1");
                        return ((ChoiceModel)this.getModel(2300989)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200270: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200232) Value == 0");
                        return ((ChoiceModel)this.getModel(200232)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200273: {
                this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200259) Value == 4 ) || ( ChoiceModel (MODELID#200259) Value == 5 ) ) )");
                return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200259)).getValue() != 4 && ((ChoiceModel)this.getModel(200259)).getValue() != 5;
            }
            case 200278: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200154) Value == 0");
                        return ((ChoiceModel)this.getModel(200154)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200282: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200155) Value == 0");
                        return ((ChoiceModel)this.getModel(200155)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200155) Value == 2");
                        return ((ChoiceModel)this.getModel(200155)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200283: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200155) Value == 2");
                        return ((ChoiceModel)this.getModel(200155)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200284: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200614) Value > 1 )");
                        return ((ChoiceModel)this.getModel(200614)).getValue() > 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200617) Value == 0");
                        return ((ChoiceModel)this.getModel(200617)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200302: {
                this.logCheckGuard("ChoiceModel (MODELID#200538) Value < 1");
                return ((ChoiceModel)this.getModel(200538)).getValue() < 1;
            }
            case 200306: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 17 ) || ( ChoiceModel (MODELID#200537) Status == 19 ) || ( ChoiceModel (MODELID#200537) Status == 20 ) || ( ChoiceModel (MODELID#200537) Status == 50 ) || ( ChoiceModel (MODELID#200537) Status == 51 ) || ( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ( ChoiceModel (MODELID#200530) Value == 9 ) || ( ChoiceModel (MODELID#200530) Value == 10 ) ) )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 17 || ((ChoiceModel)this.getModel(200537)).getStatus() == 19 || ((ChoiceModel)this.getModel(200537)).getStatus() == 20 || ((ChoiceModel)this.getModel(200537)).getStatus() == 50 || ((ChoiceModel)this.getModel(200537)).getStatus() == 51 || ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && (((ChoiceModel)this.getModel(200530)).getValue() == 9 || ((ChoiceModel)this.getModel(200530)).getValue() == 10);
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 21 ) || ( ChoiceModel (MODELID#200537) Status == 22 ) || ( ChoiceModel (MODELID#200537) Status == 23 ) || ( ChoiceModel (MODELID#200537) Status == 24 ) || ( ChoiceModel (MODELID#200537) Status == 25 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 21 || ((ChoiceModel)this.getModel(200537)).getStatus() == 22 || ((ChoiceModel)this.getModel(200537)).getStatus() == 23 || ((ChoiceModel)this.getModel(200537)).getStatus() == 24 || ((ChoiceModel)this.getModel(200537)).getStatus() == 25;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status < 2 ) && ( ChoiceModel (MODELID#200537) Value > -1 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() < 2 && ((ChoiceModel)this.getModel(200537)).getValue() > -1;
                    }
                    case 3: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 60 ) || ( ChoiceModel (MODELID#200537) Status == 18 ) || ( ChoiceModel (MODELID#200537) Status == 61 ) || ( ChoiceModel (MODELID#200537) Status == 26 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 60 || ((ChoiceModel)this.getModel(200537)).getStatus() == 18 || ((ChoiceModel)this.getModel(200537)).getStatus() == 61 || ((ChoiceModel)this.getModel(200537)).getStatus() == 26;
                    }
                    case 4: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 14 ) || ( ChoiceModel (MODELID#200537) Status == 15 ) || ( ChoiceModel (MODELID#200537) Status == 16 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 14 || ((ChoiceModel)this.getModel(200537)).getStatus() == 15 || ((ChoiceModel)this.getModel(200537)).getStatus() == 16;
                    }
                    case 5: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 41 ) || ( ChoiceModel (MODELID#200537) Status == 42 ) || ( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ChoiceModel (MODELID#200530) Value == 12 ) ) || ( ChoiceModel (MODELID#200537) Status == 62 ) || ( ChoiceModel (MODELID#200537) Status == 63 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 41 || ((ChoiceModel)this.getModel(200537)).getStatus() == 42 || ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && ((ChoiceModel)this.getModel(200530)).getValue() == 12 || ((ChoiceModel)this.getModel(200537)).getStatus() == 62 || ((ChoiceModel)this.getModel(200537)).getStatus() == 63;
                    }
                    case 6: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 43 ) || ( ChoiceModel (MODELID#200537) Status == 44 ) || ( ChoiceModel (MODELID#200537) Status == 45 ) || ( ChoiceModel (MODELID#200537) Status == 46 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 43 || ((ChoiceModel)this.getModel(200537)).getStatus() == 44 || ((ChoiceModel)this.getModel(200537)).getStatus() == 45 || ((ChoiceModel)this.getModel(200537)).getStatus() == 46;
                    }
                    case 7: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200309: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 42 ) && ( !( ( ChoiceModel (MODELID#3913) Value == 1 ) ) )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 42 && ((ChoiceModel)this.getModel(3913)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 41");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 41;
                    }
                    case 2: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ChoiceModel (MODELID#200530) Value == 12 ) ) || ( ChoiceModel (MODELID#200537) Status == 62 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && ((ChoiceModel)this.getModel(200530)).getValue() == 12 || ((ChoiceModel)this.getModel(200537)).getStatus() == 62;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 63");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 63;
                    }
                    case 4: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200310: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200155) Value == 2");
                        return ((ChoiceModel)this.getModel(200155)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200311: {
                this.logCheckGuard("ChoiceModel (MODELID#201038) Value > 0");
                return ((ChoiceModel)this.getModel(201038)).getValue() > 0;
            }
            case 200317: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 45");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 45;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 44");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 44;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 43");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 43;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#200537) Status == 46");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 46;
                    }
                    case 4: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200318: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 17 ) || ( ChoiceModel (MODELID#200537) Status == 19 ) || ( ChoiceModel (MODELID#200537) Status == 20 ) || ( ChoiceModel (MODELID#200537) Status == 50 ) || ( ChoiceModel (MODELID#200537) Status == 51 ) || ( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ( ChoiceModel (MODELID#200530) Value == 9 ) || ( ChoiceModel (MODELID#200530) Value == 10 ) ) )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 17 || ((ChoiceModel)this.getModel(200537)).getStatus() == 19 || ((ChoiceModel)this.getModel(200537)).getStatus() == 20 || ((ChoiceModel)this.getModel(200537)).getStatus() == 50 || ((ChoiceModel)this.getModel(200537)).getStatus() == 51 || ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && (((ChoiceModel)this.getModel(200530)).getValue() == 9 || ((ChoiceModel)this.getModel(200530)).getValue() == 10);
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 21 ) || ( ChoiceModel (MODELID#200537) Status == 22 ) || ( ChoiceModel (MODELID#200537) Status == 23 ) || ( ChoiceModel (MODELID#200537) Status == 24 ) || ( ChoiceModel (MODELID#200537) Status == 25 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 21 || ((ChoiceModel)this.getModel(200537)).getStatus() == 22 || ((ChoiceModel)this.getModel(200537)).getStatus() == 23 || ((ChoiceModel)this.getModel(200537)).getStatus() == 24 || ((ChoiceModel)this.getModel(200537)).getStatus() == 25;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status < 2 ) && ( ChoiceModel (MODELID#200537) Value > -1 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() < 2 && ((ChoiceModel)this.getModel(200537)).getValue() > -1;
                    }
                    case 3: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 60 ) || ( ChoiceModel (MODELID#200537) Status == 18 ) || ( ChoiceModel (MODELID#200537) Status == 61 ) || ( ChoiceModel (MODELID#200537) Status == 26 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 60 || ((ChoiceModel)this.getModel(200537)).getStatus() == 18 || ((ChoiceModel)this.getModel(200537)).getStatus() == 61 || ((ChoiceModel)this.getModel(200537)).getStatus() == 26;
                    }
                    case 4: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 14 ) || ( ChoiceModel (MODELID#200537) Status == 15 ) || ( ChoiceModel (MODELID#200537) Status == 16 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 14 || ((ChoiceModel)this.getModel(200537)).getStatus() == 15 || ((ChoiceModel)this.getModel(200537)).getStatus() == 16;
                    }
                    case 5: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 41 ) || ( ChoiceModel (MODELID#200537) Status == 42 ) || ( ( ChoiceModel (MODELID#200537) Status == 10 ) && ( ChoiceModel (MODELID#200530) Value == 12 ) ) || ( ChoiceModel (MODELID#200537) Status == 62 ) || ( ChoiceModel (MODELID#200537) Status == 63 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 41 || ((ChoiceModel)this.getModel(200537)).getStatus() == 42 || ((ChoiceModel)this.getModel(200537)).getStatus() == 10 && ((ChoiceModel)this.getModel(200530)).getValue() == 12 || ((ChoiceModel)this.getModel(200537)).getStatus() == 62 || ((ChoiceModel)this.getModel(200537)).getStatus() == 63;
                    }
                    case 6: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200537) Status == 43 ) || ( ChoiceModel (MODELID#200537) Status == 44 ) || ( ChoiceModel (MODELID#200537) Status == 45 ) || ( ChoiceModel (MODELID#200537) Status == 46 )");
                        return ((ChoiceModel)this.getModel(200537)).getStatus() == 43 || ((ChoiceModel)this.getModel(200537)).getStatus() == 44 || ((ChoiceModel)this.getModel(200537)).getStatus() == 45 || ((ChoiceModel)this.getModel(200537)).getStatus() == 46;
                    }
                    case 7: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200325: {
                this.logCheckGuard("ChoiceModel (MODELID#200653) Value == 1");
                if (((ChoiceModel)this.getModel(200653)).getValue() != 1) {
                    return false;
                }
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200657) Value == 1 ) && ( !( ChoiceModel (MODELID#200603) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(200657)).getValue() == 1 && ((ChoiceModel)this.getModel(200603)).getValue() != 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200347: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#200628) Value == 1 ) ) || ( ( !( ChoiceModel (MODELID#200628) Value == 1 ) ) && ( ( ( ( ChoiceModel (MODELID#200538) Value & 2 ) == 2 ) && ( ( !( ChoiceModel (MODELID#200529) Value == 19 ) ) || ( ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 1 ) ) ) ) || ( ( ( ChoiceModel (MODELID#200538) Value & 1 ) == 1 ) && ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 0 ) ) ) )");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 1 || ((ChoiceModel)this.getModel(200628)).getValue() != 1 && ((((ChoiceModel)this.getModel(200538)).getValue() & 2) == 2 && (((ChoiceModel)this.getModel(200529)).getValue() != 19 || ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 1) || (((ChoiceModel)this.getModel(200538)).getValue() & 1) == 1 && ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 0);
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200349: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#200628) Value == 1 ) ) || ( ( !( ChoiceModel (MODELID#200628) Value == 1 ) ) && ( ( ( ( ChoiceModel (MODELID#200538) Value & 2 ) == 2 ) && ( ( !( ChoiceModel (MODELID#200529) Value == 19 ) ) || ( ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 1 ) ) ) ) || ( ( ( ChoiceModel (MODELID#200538) Value & 1 ) == 1 ) && ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#200533) Value == 0 ) ) ) )");
                return ((ChoiceModel)this.getModel(200628)).getValue() == 1 || ((ChoiceModel)this.getModel(200628)).getValue() != 1 && ((((ChoiceModel)this.getModel(200538)).getValue() & 2) == 2 && (((ChoiceModel)this.getModel(200529)).getValue() != 19 || ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 1) || (((ChoiceModel)this.getModel(200538)).getValue() & 1) == 1 && ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(200533)).getValue() == 0);
            }
            case 200350: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200616) Value == 11");
                        return ((ChoiceModel)this.getModel(200616)).getValue() == 11;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200352: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200616) Value == 11");
                        return ((ChoiceModel)this.getModel(200616)).getValue() == 11;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
        }
        return this.checkGuardSub2(n, n2);
    }

    public boolean checkGuardSub2(int n, int n2) {
        switch (n) {
            case 200358: {
                this.logCheckGuard("BaseListModel (MODELID#200598) Length < 1");
                return ((BaseListModel)this.getModel(200598)).getLength() < 1;
            }
            case 200370: {
                this.logCheckGuard("( BaseListModel (MODELID#201043) Length < 1 ) || ( ChoiceModel (MODELID#200694) Value == 1 )");
                return ((BaseListModel)this.getModel(201043)).getLength() < 1 || ((ChoiceModel)this.getModel(200694)).getValue() == 1;
            }
            case 200371: {
                this.logCheckGuard("( BaseListModel (MODELID#201041) Length < 1 ) || ( ChoiceModel (MODELID#200693) Value == 1 )");
                return ((BaseListModel)this.getModel(201041)).getLength() < 1 || ((ChoiceModel)this.getModel(200693)).getValue() == 1;
            }
            case 200372: {
                this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
            }
            case 200373: {
                this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
            }
            case 200374: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#201012) Status == 0");
                        return ((ChoiceModel)this.getModel(201012)).getStatus() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200259) Value == 4 ) || ( ChoiceModel (MODELID#200259) Value == 5 ) ) )");
                        return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200259)).getValue() != 4 && ((ChoiceModel)this.getModel(200259)).getValue() != 5;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200375: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                        return ((ChoiceModel)this.getModel(200573)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200390: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2300989) Value == 1");
                        return ((ChoiceModel)this.getModel(2300989)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200397: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200398: {
                this.logCheckGuard("!( ChoiceModel (MODELID#200537) Value == 1 )");
                return ((ChoiceModel)this.getModel(200537)).getValue() != 1;
            }
            case 200413: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200530) Value == 8");
                        return ((ChoiceModel)this.getModel(200530)).getValue() == 8;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200530) Value == 7");
                        return ((ChoiceModel)this.getModel(200530)).getValue() == 7;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200420: {
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
            case 200422: {
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
            case 200427: {
                this.logCheckGuard("( ChoiceModel (MODELID#200646) Value < 0 ) && ( ChoiceModel (MODELID#200646) Status == 1 )");
                return ((ChoiceModel)this.getModel(200646)).getValue() < 0 && ((ChoiceModel)this.getModel(200646)).getStatus() == 1;
            }
            case 200430: {
                this.logCheckGuard("( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 )");
                return ((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9;
            }
            case 200431: {
                this.logCheckGuard("( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 )");
                return ((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9;
            }
            case 200433: {
                this.logCheckGuard("ChoiceModel (MODELID#200629) Value == 1");
                if (((ChoiceModel)this.getModel(200629)).getValue() != 1) {
                    return false;
                }
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
            case 200436: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ( ChoiceModel (MODELID#200573) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) ) && ( ( ChoiceModel (MODELID#200526) Value == 2 ) || ( ( ChoiceModel (MODELID#200638) Value == 1 ) && ( ChoiceModel (MODELID#200526) Value == 1 ) ) )");
                        return (((ChoiceModel)this.getModel(200573)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1) && (((ChoiceModel)this.getModel(200526)).getValue() == 2 || ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200526)).getValue() == 1);
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200526) Value == 1 ) && ( ChoiceModel (MODELID#200638) Value == 1 )");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 1 && ((ChoiceModel)this.getModel(200638)).getValue() == 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200437: {
                this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 7");
                return ((ChoiceModel)this.getModel(200526)).getValue() == 7;
            }
            case 200443: {
                this.logCheckGuard("ChoiceModel (MODELID#200452) Value == 1");
                return ((ChoiceModel)this.getModel(200452)).getValue() == 1;
            }
            case 200448: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200529) Value == 19");
                        return ((ChoiceModel)this.getModel(200529)).getValue() == 19;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200449: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200616) Value > 0 ) && ( !( ChoiceModel (MODELID#200616) Value == 11 ) )");
                        return ((ChoiceModel)this.getModel(200616)).getValue() > 0 && ((ChoiceModel)this.getModel(200616)).getValue() != 11;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200616) Value == 11 ) && ( ChoiceModel (MODELID#200616) Value > 0 )");
                        return ((ChoiceModel)this.getModel(200616)).getValue() == 11 && ((ChoiceModel)this.getModel(200616)).getValue() > 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200450: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#201012) Status == 0");
                        return ((ChoiceModel)this.getModel(201012)).getStatus() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200259) Value == 4 ) || ( ChoiceModel (MODELID#200259) Value == 5 ) ) )");
                        return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200259)).getValue() != 4 && ((ChoiceModel)this.getModel(200259)).getValue() != 5;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200451: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#201012) Status == 0");
                        return ((ChoiceModel)this.getModel(201012)).getStatus() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200638) Value == 1 ) && ( !( ( ChoiceModel (MODELID#200259) Value == 4 ) || ( ChoiceModel (MODELID#200259) Value == 5 ) ) )");
                        return ((ChoiceModel)this.getModel(200638)).getValue() == 1 && ((ChoiceModel)this.getModel(200259)).getValue() != 4 && ((ChoiceModel)this.getModel(200259)).getValue() != 5;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200453: {
                this.logCheckGuard("ChoiceModel (MODELID#200452) Value == 1");
                return ((ChoiceModel)this.getModel(200452)).getValue() == 1;
            }
            case 200455: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 6");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 6;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 2");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200522) Value == 0 ) && ( ChoiceModel (MODELID#200526) Value == 1 )");
                        return ((ChoiceModel)this.getModel(200522)).getValue() == 0 && ((ChoiceModel)this.getModel(200526)).getValue() == 1;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 5");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 5;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 0");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 0;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 7");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 7;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#200526) Value == 8");
                        return ((ChoiceModel)this.getModel(200526)).getValue() == 8;
                    }
                    case 7: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200522) Value == 1 ) && ( ChoiceModel (MODELID#200526) Value == 1 )");
                        return ((ChoiceModel)this.getModel(200522)).getValue() == 1 && ((ChoiceModel)this.getModel(200526)).getValue() == 1;
                    }
                    case 8: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200459: {
                this.logCheckGuard("( ChoiceModel (MODELID#200259) Value == 4 ) && ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ( SysConstModel (MODELID#5572) Value == 2 ) )");
                if (((ChoiceModel)this.getModel(200259)).getValue() != 4 || ((ChoiceModel)this.getModel(200529)).getValue() != 19 || ((SysConstModel)this.getModel(5572)).getValue() != 2) {
                    return false;
                }
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#200628) Value == 2 )");
                        return ((ChoiceModel)this.getModel(200628)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 200462: {
                this.logCheckGuard("( ( SysConstModel (MODELID#5572) Value == 2 ) ) && ( ChoiceModel (MODELID#200529) Value == 19 ) && ( ChoiceModel (MODELID#201118) Value == 7 )");
                return ((SysConstModel)this.getModel(5572)).getValue() == 2 && ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((ChoiceModel)this.getModel(201118)).getValue() == 7;
            }
            case 200463: {
                this.logCheckGuard("( ChoiceModel (MODELID#200529) Value == 19 ) && ( ( SysConstModel (MODELID#5572) Value == 2 ) ) && ( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) )");
                return ((ChoiceModel)this.getModel(200529)).getValue() == 19 && ((SysConstModel)this.getModel(5572)).getValue() == 2 && (((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9);
            }
            case 200464: {
                this.logCheckGuard("( ChoiceModel (MODELID#5587) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                return ((ChoiceModel)this.getModel(5587)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 200466: {
                this.logCheckGuard("( ChoiceModel (MODELID#5587) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#200829) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                return ((ChoiceModel)this.getModel(5587)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(200829)).getValue() == 1 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9;
            }
            case 200467: {
                this.logCheckGuard("( ChoiceModel (MODELID#5587) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#200829) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                return ((ChoiceModel)this.getModel(5587)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(200829)).getValue() == 1 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9;
            }
            case 200468: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5587) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5587)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 200469: {
                this.logCheckGuard("( ChoiceModel (MODELID#5587) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                return ((ChoiceModel)this.getModel(5587)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 200470: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5587) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5587)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
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

