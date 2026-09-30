/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.tuner.sm.TunerSMMActions;
import de.audi.tghu.tuner.sm.TunerSMMInitMediators;
import de.audi.tghu.tuner.sm.TunerSMMInitStates;
import de.audi.tghu.tuner.sm.TunerSMMInitTransitions;
import java.util.NoSuchElementException;

public class TunerSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 1;
    public static final String SMM_NAME = "TunerSMM";
    private TunerSMMInitStates smmInitStates;
    private TunerSMMInitTransitions smmInitTransitions;
    private TunerSMMInitMediators smmInitMediators;
    private TunerSMMActions smmActions;

    public TunerSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 1, SMM_NAME);
    }

    public TunerSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 1, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new TunerSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new TunerSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new TunerSMMInitMediators(this, this.logChannel);
        this.smmActions = new TunerSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 100001;
        this.popupIDList = new int[]{100000, 100001, 100002, 100003, 100004, 100005};
        this.popupPriorityList = new int[]{1000, 1000, 1000, 1000, 1000, 1000};
        this.popupTopLevelStateIDList = new int[]{100149, 100151, 100153, 100155, 100157, 100159};
        this.popupZPMPriorityList = new int[]{155, 155, 155, 155, 155, 155};
        this.popupZPMSlotList = new int[]{4, 4, 4, 4, 4, 4};
        this.extStateIDList = new int[]{100199, 100056, 100160, 100182, 100191, 100022, 100017, 100016, 100001};
        this.extStateLabelList = new String[]{"tunerListMsgUnsubscr", "tunerListHistoryMain", "tunerListComp", "tunerListSiriusFavoritesMain", "tunerListSelectWaveband", "tunerListFavoriteMain", "tunerList", "tunerCenter", "tunerDesktop"};
        this.incSlotList = new int[]{100097, 100145, 100146, 100165, 100166, 100193, 100194, 100198, 100215, 100216, 100226, 100229, 100230, 100231, 100234, 100236, 100238, 100242};
        this.incSlotStateIDList = new int[]{-3, 100147, 100147, -4, -5, -6, 100057, 100199, 100217, 100217, 100227, 100227, 100227, 100227, -7, -8, -9, -10};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "toneSystem", "popupHelpBordbuch", "toneAnnouncement", "toneTouchSliderIncl", "officeEmailEditorComp", "officeOptSMSEditor", "nav_inner_init_online", "connectivityCenterOnlineCheck", "phoneDesktop", "destIntellidestMain"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 100008: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100676) Value == 1 )");
                            return ((ChoiceModel)this.getModel(100676)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100618) Value > 1 ) ) && ( ChoiceModel (MODELID#100327) Value == 7 )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() > 1 && ((ChoiceModel)this.getModel(100327)).getValue() == 7;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 1");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 1;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 7");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 7;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 10");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 10;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 11");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 11;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 4");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 4;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 13");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 13;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 5");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 5;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 12");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 12;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#100316) Value == 8");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 8;
                        }
                        case 11: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100013: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( !( ChoiceModel (MODELID#100549) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100549)).getValue() != 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100014: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100618) Value == 5 )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() == 5;
                        }
                        case 1: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100618) Value == 2 ) || ( ChoiceModel (MODELID#100618) Value == 3 ) )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() == 2 || ((ChoiceModel)this.getModel(100618)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100618) Value == 6 )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() == 6;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100618) Value == 4 )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() == 4;
                        }
                        case 4: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100618) Value == 8 )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() == 8;
                        }
                        case 5: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100618) Value == 7 )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() == 7;
                        }
                        case 6: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100033: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BaseListModel (MODELID#100488) Length > 0");
                            return ((BaseListModel)this.getModel(100488)).getLength() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100058: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100727) Value == 1 ) && ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR )");
                            return ((ChoiceModel)this.getModel(100727)).getValue() == 1 && ((SysConstModel)this.getModel(442)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100327) Value == 1 ) || ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR ) && ( ChoiceModel (MODELID#100327) Value == 4 ) ) )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 1 || ((SysConstModel)this.getModel(442)).getValue() == 1 && ((ChoiceModel)this.getModel(100327)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#100327) Value == 5");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 5;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 11 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 11;
                        }
                        case 4: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 7 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 7;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100070: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( !( ChoiceModel (MODELID#100550) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100550)).getValue() != 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100076: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100618) Value == 3 )");
                            return ((ChoiceModel)this.getModel(100618)).getValue() == 3;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100122: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100315) Value == 1");
                            return ((ChoiceModel)this.getModel(100315)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( !( ChoiceModel (MODELID#100315) Value == 1 ) ) && ( ChoiceModel (MODELID#100327) Value == 11 )");
                            return ((ChoiceModel)this.getModel(100315)).getValue() != 1 && ((ChoiceModel)this.getModel(100327)).getValue() == 11;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100159: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100727) Value == 1");
                            return ((ChoiceModel)this.getModel(100727)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100166: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100489) Value == 1 ) || ( ChoiceModel (MODELID#100490) Value == 1 )");
                            return ((ChoiceModel)this.getModel(100489)).getValue() == 1 || ((ChoiceModel)this.getModel(100490)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100230: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 1 ) || ( ChoiceModel (MODELID#100327) Value == 7 ) || ( ChoiceModel (MODELID#100327) Value == 4 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 1 || ((ChoiceModel)this.getModel(100327)).getValue() == 7 || ((ChoiceModel)this.getModel(100327)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100243: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#376) Value > -1");
                            return ((ChoiceModel)this.getModel(376)).getValue() > -1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100247: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100154) Value == 1");
                            return ((ChoiceModel)this.getModel(100154)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100274: {
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
                case 100320: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100727) Value == 1 ) && ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR )");
                            return ((ChoiceModel)this.getModel(100727)).getValue() == 1 && ((SysConstModel)this.getModel(442)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100327) Value == 1 ) || ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR ) && ( ChoiceModel (MODELID#100327) Value == 4 ) ) )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 1 || ((SysConstModel)this.getModel(442)).getValue() == 1 && ((ChoiceModel)this.getModel(100327)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#100327) Value == 5");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 5;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 11 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 11;
                        }
                        case 4: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 7 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 7;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100321: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) || ( !( ChoiceModel (MODELID#100549) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0 || ((ChoiceModel)this.getModel(100549)).getValue() != 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100322: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) || ( !( ChoiceModel (MODELID#100550) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0 || ((ChoiceModel)this.getModel(100550)).getValue() != 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100323: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 5 ) || ( ChoiceModel (MODELID#100327) Value == 11 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 5 || ((ChoiceModel)this.getModel(100327)).getValue() == 11;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100324: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 5 ) || ( ChoiceModel (MODELID#100327) Value == 11 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 5 || ((ChoiceModel)this.getModel(100327)).getValue() == 11;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100339: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#377) Value == 1 )");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100340: {
                    this.logCheckGuard("( !( ChoiceModel (MODELID#377) Value == 1 ) )");
                    return ((ChoiceModel)this.getModel(377)).getValue() != 1;
                }
                case 100341: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#377) Value == 1 )");
                            return ((ChoiceModel)this.getModel(377)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100342: {
                    this.logCheckGuard("( !( ChoiceModel (MODELID#377) Value == 1 ) )");
                    return ((ChoiceModel)this.getModel(377)).getValue() != 1;
                }
                case 100346: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 7 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 7;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 8 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 8;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100359: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100708) Value == 0 )");
                            return ((ChoiceModel)this.getModel(100708)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100368: {
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
                case 100370: {
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
                case 100375: {
                    this.logCheckGuard("( ChoiceModel (MODELID#100432) Value == 0 )");
                    return ((ChoiceModel)this.getModel(100432)).getValue() == 0;
                }
                case 100377: {
                    this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 7 ) && ( ( ChoiceModel (MODELID#100618) Value > 1 ) )");
                    return ((ChoiceModel)this.getModel(100327)).getValue() == 7 && ((ChoiceModel)this.getModel(100618)).getValue() > 1;
                }
                case 100378: {
                    this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 7 ) && ( ( ChoiceModel (MODELID#100618) Value > 1 ) )");
                    return ((ChoiceModel)this.getModel(100327)).getValue() == 7 && ((ChoiceModel)this.getModel(100618)).getValue() > 1;
                }
                case 100379: {
                    this.logCheckGuard("( !( ChoiceModel (MODELID#100327) Value == 7 ) )");
                    return ((ChoiceModel)this.getModel(100327)).getValue() != 7;
                }
                case 100380: {
                    this.logCheckGuard("( !( ( ChoiceModel (MODELID#100618) Value > 1 ) ) )");
                    return ((ChoiceModel)this.getModel(100618)).getValue() <= 1;
                }
                case 100387: {
                    this.logCheckGuard("( ( ChoiceModel (MODELID#100316) Value == 12 ) || ( ChoiceModel (MODELID#100316) Value == 13 ) ) && ( ( ChoiceModel (MODELID#100618) Value > 1 ) )");
                    return (((ChoiceModel)this.getModel(100316)).getValue() == 12 || ((ChoiceModel)this.getModel(100316)).getValue() == 13) && ((ChoiceModel)this.getModel(100618)).getValue() > 1;
                }
                case 100388: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 1 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 4 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 12 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 12;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 13 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 13;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100394: {
                    this.logCheckGuard("ChoiceModel (MODELID#100509) Value == 0");
                    return ((ChoiceModel)this.getModel(100509)).getValue() == 0;
                }
                case 100414: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100676) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(100676)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100415: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100676) Value == 1 )");
                            return ((ChoiceModel)this.getModel(100676)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100423: {
                    this.logCheckGuard("( ( ChoiceModel (MODELID#100681) Value == 0 ) )");
                    return ((ChoiceModel)this.getModel(100681)).getValue() == 0;
                }
                case 100424: {
                    this.logCheckGuard("( ( BaseListModel (MODELID#100481) Length == 0 ) )");
                    return ((BaseListModel)this.getModel(100481)).getLength() == 0;
                }
                case 100432: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100727) Value == 1");
                            return ((ChoiceModel)this.getModel(100727)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100433: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100434: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100435: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100436: {
                    this.logCheckGuard("SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR");
                    if (((SysConstModel)this.getModel(442)).getValue() != 1) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100727) Value == 1 ) && ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR )");
                            return ((ChoiceModel)this.getModel(100727)).getValue() == 1 && ((SysConstModel)this.getModel(442)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#100327) Value == 1 ) || ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR ) && ( ChoiceModel (MODELID#100327) Value == 4 ) ) )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 1 || ((SysConstModel)this.getModel(442)).getValue() == 1 && ((ChoiceModel)this.getModel(100327)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#100327) Value == 5");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 5;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 11 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 11;
                        }
                        case 4: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100327) Value == 7 )");
                            return ((ChoiceModel)this.getModel(100327)).getValue() == 7;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100437: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100727) Value == 1");
                            return ((ChoiceModel)this.getModel(100727)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100438: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100727) Value == 1");
                            return ((ChoiceModel)this.getModel(100727)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100439: {
                    this.logCheckGuard("( ChoiceModel (MODELID#100489) Value == 1 ) || ( ChoiceModel (MODELID#100490) Value == 1 )");
                    return ((ChoiceModel)this.getModel(100489)).getValue() == 1 || ((ChoiceModel)this.getModel(100490)).getValue() == 1;
                }
                case 100440: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100441: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100442: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 4 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 1 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 13 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 13;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100316) Value == 12 )");
                            return ((ChoiceModel)this.getModel(100316)).getValue() == 12;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100443: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ( ChoiceModel (MODELID#100655) Value > 0 ) && ( ( ChoiceModel (MODELID#100154) Value == 1 ) ) ) || ( ( ChoiceModel (MODELID#100708) Value == 0 ) ) )");
                            return ((ChoiceModel)this.getModel(100655)).getValue() > 0 && ((ChoiceModel)this.getModel(100154)).getValue() == 1 || ((ChoiceModel)this.getModel(100708)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100449: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 0");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 1");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 2");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 3");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 3;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100495: {
                    this.logCheckGuard("ChoiceModel (MODELID#4091) Value == 0");
                    return ((ChoiceModel)this.getModel(4091)).getValue() == 0;
                }
                case 100502: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100798) Value == 3 )");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 3;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100798) Value == 2 ) && ( ChoiceModel (MODELID#155) Value > 0 )");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 2 && ((ChoiceModel)this.getModel(155)).getValue() > 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100505: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#4091) Value == 0");
                            return ((ChoiceModel)this.getModel(4091)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100510: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 0");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 1");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 2");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#100798) Value == 3");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 3;
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100519: {
                    this.logCheckGuard("( ( ChoiceModel (MODELID#100509) Value > 0 ) && ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR ) )");
                    return ((ChoiceModel)this.getModel(100509)).getValue() > 0 && ((SysConstModel)this.getModel(442)).getValue() == 1;
                }
                case 100520: {
                    this.logCheckGuard("( ( ChoiceModel (MODELID#100509) Value > 0 ) && ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_NAR ) )");
                    return ((ChoiceModel)this.getModel(100509)).getValue() > 0 && ((SysConstModel)this.getModel(442)).getValue() == 1;
                }
                case 100521: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#154) Value > 0 )");
                            return ((ChoiceModel)this.getModel(154)).getValue() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100522: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100798) Value == 3 )");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 3;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#100798) Value == 2 ) && ( ChoiceModel (MODELID#155) Value > 0 )");
                            return ((ChoiceModel)this.getModel(100798)).getValue() == 2 && ((ChoiceModel)this.getModel(155)).getValue() > 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100525: {
                    this.logCheckGuard("( ChoiceModel (MODELID#5584) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                    if (((ChoiceModel)this.getModel(5584)).getValue() != 1 || ((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100578) Value == 1");
                            return ((ChoiceModel)this.getModel(100578)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 100526: {
                    this.logCheckGuard("( ChoiceModel (MODELID#5584) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                    if (((ChoiceModel)this.getModel(5584)).getValue() != 1 || ((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#100578) Value == 1");
                            return ((ChoiceModel)this.getModel(100578)).getValue() == 1;
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
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[TunerSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[TunerSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[TunerSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[TunerSMM.java#checkGuard] checking: '%1'", (Object)string);
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

