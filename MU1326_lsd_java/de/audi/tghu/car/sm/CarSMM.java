/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.car.sm.CarSMMActions;
import de.audi.tghu.car.sm.CarSMMInitMediators;
import de.audi.tghu.car.sm.CarSMMInitStates;
import de.audi.tghu.car.sm.CarSMMInitTransitions;
import java.util.NoSuchElementException;

public class CarSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 6;
    public static final String SMM_NAME = "CarSMM";
    private CarSMMInitStates smmInitStates;
    private CarSMMInitTransitions smmInitTransitions;
    private CarSMMInitMediators smmInitMediators;
    private CarSMMActions smmActions;

    public CarSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 6, SMM_NAME);
    }

    public CarSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 6, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new CarSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new CarSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new CarSMMInitMediators(this, this.logChannel);
        this.smmActions = new CarSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 604167;
        this.popupIDList = new int[]{600000, 600001, 600002, 600003, 600004, 600005, 600006, 600007, 600008, 600009};
        this.popupPriorityList = new int[]{1550, 0, 200, 100, 100, 1200, 1000, 100, 1000, 100};
        this.popupTopLevelStateIDList = new int[]{600055, 600057, 600059, 600124, 600126, 600137, 600139, 600143, 600152, 600155};
        this.popupZPMPriorityList = new int[]{100, 250, 235, 175, 175, 140, 155, 155, 155, 245};
        this.popupZPMSlotList = new int[]{2, 10, 2, 8, 8, 4, 4, 4, 4, 10};
        this.extStateIDList = new int[]{604136, 604130, 600134, 604131, 604128, 600003, 600167, 600002, 604167, 600039, 604135, 600131, 600004, 600103, 600027, 600179, 600119};
        this.extStateLabelList = new String[]{"carOptChargeTimer2Main", "carChargeMainComp", "carCharismaComp", "settingsTimeInclude_Car", "AuxCombinedMainComp", "carFasMain", "AuxheatComp", "carCarsettingsMain", "carDesktop", "carAuxheatMain", "carOptChargeTimer1Main", "popupHelpBordbuch", "carServiceMain", "carCarsettingsUgdoLearnButtonMainUniversal", "carAcMain", "BordbuchComp", "carCarSettingsUgdoLearnButtonRollGroup"};
        this.incSlotList = new int[]{600130, 600196, 604131, 604145};
        this.incSlotStateIDList = new int[]{600131, -3, -4, -3};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "toneTouchSliderIncl", "settingsTime", "mainWizardRootState", "carOptChargeTimer1Weekday", "carOptChargeTimer2Weekday", "settingsSystemComp"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 600000: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                            return ((ChoiceModel)this.getModel(600773)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                            return ((SysConstModel)this.getModel(522)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                            return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600034: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 1 )");
                            return ((ChoiceModel)this.getModel(602321)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 2 )");
                            return ((ChoiceModel)this.getModel(602321)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 3 )");
                            return ((ChoiceModel)this.getModel(602321)).getValue() == 3;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 4 )");
                            return ((ChoiceModel)this.getModel(602321)).getValue() == 4;
                        }
                        case 4: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 5 )");
                            return ((ChoiceModel)this.getModel(602321)).getValue() == 5;
                        }
                        case 5: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 6 )");
                            return ((ChoiceModel)this.getModel(602321)).getValue() == 6;
                        }
                        case 6: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600127: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600112");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600112;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600145: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 4");
                            return ((ChoiceModel)this.getModel(600428)).getValue() == 4;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600146: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#52) Value == 0");
                            return ((ChoiceModel)this.getModel(52)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600154: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 8");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 8;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 3");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 7");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 7;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 6");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 6;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 4");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 5");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 5;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 1");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 1;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 2");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 2;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 0");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 0;
                        }
                        case 9: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600165: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 0");
                            return ((ChoiceModel)this.getModel(600428)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 1");
                            return ((ChoiceModel)this.getModel(600428)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 2");
                            return ((ChoiceModel)this.getModel(600428)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 3");
                            return ((ChoiceModel)this.getModel(600428)).getValue() == 3;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 4");
                            return ((ChoiceModel)this.getModel(600428)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ButtonModel (MODELID#600625) Pressed == true");
                            return ((ButtonModel)this.getModel(600625)).getPressed();
                        }
                        case 6: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600166: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 8");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 8;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 3");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 7");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 7;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 6");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 6;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 4");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 5");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 5;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 1");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 1;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 2");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 2;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 0");
                            return ((ChoiceModel)this.getModel(600427)).getValue() == 0;
                        }
                        case 9: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600169: {
                    this.logCheckGuard("ChoiceModel (MODELID#600773) Value < 2");
                    if (((ChoiceModel)this.getModel(600773)).getValue() >= 2) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                            return ((ChoiceModel)this.getModel(600773)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                            return ((SysConstModel)this.getModel(522)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                            return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600171: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600005");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600005;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600172: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600006");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600006;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600173: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600007");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600007;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600174: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600008");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600008;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600175: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600009");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600009;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600176: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600010");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600010;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600177: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600012");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600012;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600178: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600013");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600013;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600179: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600014");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600014;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600180: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600015");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600015;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600181: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600016");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600016;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600182: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600017");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600017;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600516) Value == 1");
                            return ((ChoiceModel)this.getModel(600516)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600183: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600018");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600018;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600184: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600021");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600021;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600185: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600022");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600022;
                        }
                        case 1: {
                            this.logCheckGuard("!( ChoiceModel (MODELID#600588) Value == 1 )");
                            return ((ChoiceModel)this.getModel(600588)).getValue() != 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600186: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600023");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600023;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600187: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600024");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600024;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600188: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600025");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600025;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600189: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600029");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600029;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600190: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600030");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600030;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600192: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600032");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600032;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600193: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600033");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600033;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600194: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600034");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600034;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600195: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600112");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600112;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600197: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600043");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600043;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600198: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600044");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600044;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600199: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600045");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600045;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600200: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600164");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600164;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600201: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600061");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600061;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600202: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600062");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600062;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600203: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600063");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600063;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 600204: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600066");
                            return ((ChoiceModel)this.getModel(601056)).getValue() == 600066;
                        }
                        case 1: {
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
                this.logChannel.log(10000, "[CarSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[CarSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[CarSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[CarSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 600205: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600067");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600067;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600206: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600068");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600068;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600207: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600069");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600069;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600208: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600070");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600070;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600209: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600071");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600071;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600210: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600072");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600072;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600211: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600073");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600073;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600212: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600074");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600074;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600213: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600075");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600075;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600214: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600076");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600076;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600215: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600078");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600078;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600216: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600079");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600079;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600217: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600080");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600080;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600218: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600081");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600081;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600219: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600085");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600085;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600222: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600088");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600088;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600225: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600091");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600091;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600228: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600095");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600095;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600231: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600097");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600097;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600233: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600003");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600003;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600004");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600004;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600002");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600002;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600039");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600039;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600027");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600027;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600067");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600067;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600097");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600097;
                    }
                    case 7: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600072");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600072;
                    }
                    case 8: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600040");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600040;
                    }
                    case 9: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600030");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600030;
                    }
                    case 10: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600032");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600032;
                    }
                    case 11: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600033");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600033;
                    }
                    case 12: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600034");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600034;
                    }
                    case 13: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600026");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600026;
                    }
                    case 14: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600005");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600005;
                    }
                    case 15: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600006");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600006;
                    }
                    case 16: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600007");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600007;
                    }
                    case 17: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600010");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600010;
                    }
                    case 18: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600012");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600012;
                    }
                    case 19: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600013");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600013;
                    }
                    case 20: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600015");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600015;
                    }
                    case 21: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600016");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600016;
                    }
                    case 22: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600018");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600018;
                    }
                    case 23: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600061");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600061;
                    }
                    case 24: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600044");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600044;
                    }
                    case 25: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600043");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600043;
                    }
                    case 26: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600045");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600045;
                    }
                    case 27: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600073");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600073;
                    }
                    case 28: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600075");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600075;
                    }
                    case 29: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600164");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600164;
                    }
                    case 30: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600068");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600068;
                    }
                    case 31: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600069");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600069;
                    }
                    case 32: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600070");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600070;
                    }
                    case 33: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600071");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600071;
                    }
                    case 34: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600038");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600038;
                    }
                    case 35: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600029");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600029;
                    }
                    case 36: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600031");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600031;
                    }
                    case 37: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600024");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600024;
                    }
                    case 38: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600025");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600025;
                    }
                    case 39: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600022");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600022;
                    }
                    case 40: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600023");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600023;
                    }
                    case 41: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600021");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600021;
                    }
                    case 42: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600008");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600008;
                    }
                    case 43: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600009");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600009;
                    }
                    case 44: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600014");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600014;
                    }
                    case 45: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600017");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600017;
                    }
                    case 46: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600019");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600019;
                    }
                    case 47: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600062");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600062;
                    }
                    case 48: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600079");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600079;
                    }
                    case 49: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600080");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600080;
                    }
                    case 50: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600074");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600074;
                    }
                    case 51: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600078");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600078;
                    }
                    case 52: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600076");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600076;
                    }
                    case 53: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600085");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600085;
                    }
                    case 54: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600088");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600088;
                    }
                    case 55: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600091");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600091;
                    }
                    case 56: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600094");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600094;
                    }
                    case 57: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600066");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600066;
                    }
                    case 58: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600063");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600063;
                    }
                    case 59: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600065");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600065;
                    }
                    case 60: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600141");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600141;
                    }
                    case 61: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600157");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600157;
                    }
                    case 62: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600112");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600112;
                    }
                    case 63: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600183");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600183;
                    }
                    case 64: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 604140");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 604140;
                    }
                    case 65: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600234: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600467) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600467)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600235: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600026");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600026;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600236: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600065");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600065;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600247: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 2");
                        return ((ChoiceModel)this.getModel(601014)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#601020) Value == 0 ) && ( !( ChoiceModel (MODELID#601014) Value == 2 ) ) && ( !( ChoiceModel (MODELID#601014) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(601020)).getValue() == 0 && ((ChoiceModel)this.getModel(601014)).getValue() != 2 && ((ChoiceModel)this.getModel(601014)).getValue() != 0;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 0");
                        return ((ChoiceModel)this.getModel(601014)).getValue() == 0;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600251: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 2");
                        return ((ChoiceModel)this.getModel(601014)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#601020) Value == 0 ) && ( !( ChoiceModel (MODELID#601014) Value == 2 ) ) && ( !( ChoiceModel (MODELID#601014) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(601020)).getValue() == 0 && ((ChoiceModel)this.getModel(601014)).getValue() != 2 && ((ChoiceModel)this.getModel(601014)).getValue() != 0;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 0");
                        return ((ChoiceModel)this.getModel(601014)).getValue() == 0;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600255: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 2");
                        return ((ChoiceModel)this.getModel(601014)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#601020) Value == 0 ) && ( !( ChoiceModel (MODELID#601014) Value == 2 ) ) && ( !( ChoiceModel (MODELID#601014) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(601020)).getValue() == 0 && ((ChoiceModel)this.getModel(601014)).getValue() != 2 && ((ChoiceModel)this.getModel(601014)).getValue() != 0;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 0");
                        return ((ChoiceModel)this.getModel(601014)).getValue() == 0;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600269: {
                this.logCheckGuard("ChoiceModel (MODELID#601033) Value == 1");
                return ((ChoiceModel)this.getModel(601033)).getValue() == 1;
            }
            case 600270: {
                this.logCheckGuard("ChoiceModel (MODELID#601033) Value == 0");
                return ((ChoiceModel)this.getModel(601033)).getValue() == 0;
            }
            case 600281: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600381) Value == 0");
                        return ((ChoiceModel)this.getModel(600381)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600295: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#600414) Value == 0 )");
                        return ((ChoiceModel)this.getModel(600414)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600300: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600002");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600002;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600303: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601118) Value == 0");
                        return ((ChoiceModel)this.getModel(601118)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600304: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600003");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600003;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600305: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600004");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600004;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600306: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600027");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600027;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600307: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600039");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600039;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600330: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                        return ((ChoiceModel)this.getModel(600773)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600332: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600183");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600183;
                    }
                    case 1: {
                        this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( !( ChoiceModel (MODELID#601056) Value == 600183 ) )");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4 && ((ChoiceModel)this.getModel(601056)).getValue() != 600183;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600338: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600709) Value == 0");
                        return ((ChoiceModel)this.getModel(600709)).getValue() == 0;
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
            case 600339: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600709) Value == 0");
                        return ((ChoiceModel)this.getModel(600709)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600346: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600033");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600033;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600353: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600467) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600467)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600359: {
                this.logCheckGuard("ChoiceModel (MODELID#52) Value == 0");
                return ((ChoiceModel)this.getModel(52)).getValue() == 0;
            }
            case 600360: {
                this.logCheckGuard("ChoiceModel (MODELID#52) Value == 0");
                return ((ChoiceModel)this.getModel(52)).getValue() == 0;
            }
            case 600374: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600710) Value > 0");
                        return ((ChoiceModel)this.getModel(600710)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#600709) Value > 0 ) && ( ChoiceModel (MODELID#601254) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600709)).getValue() > 0 && ((ChoiceModel)this.getModel(601254)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600375: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600039");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600039;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600377: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600710) Value > 0");
                        return ((ChoiceModel)this.getModel(600710)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#600709) Value > 0 ) && ( ChoiceModel (MODELID#601254) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600709)).getValue() > 0 && ((ChoiceModel)this.getModel(601254)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600383: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600074");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600074;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600385: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601257) Value == 0");
                        return ((ChoiceModel)this.getModel(601257)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600387: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601257) Value == 0");
                        return ((ChoiceModel)this.getModel(601257)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600389: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600141");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600141;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600390: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600157");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600157;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600393: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                        return ((ChoiceModel)this.getModel(600773)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600412: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( !( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) ) && ( ChoiceModel (MODELID#600815) Value == 2 ) && ( ChoiceModel (MODELID#601843) Value == 1 )");
                        return ((SysConstModel)this.getModel(522)).getValue() != 4 && ((ChoiceModel)this.getModel(600815)).getValue() == 2 && ((ChoiceModel)this.getModel(601843)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601438) Value == 0");
                        return ((ChoiceModel)this.getModel(601438)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600413: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( !( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) ) && ( ChoiceModel (MODELID#600815) Value == 2 ) && ( ChoiceModel (MODELID#601843) Value == 1 )");
                        return ((SysConstModel)this.getModel(522)).getValue() != 4 && ((ChoiceModel)this.getModel(600815)).getValue() == 2 && ((ChoiceModel)this.getModel(601843)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601438) Value == 0");
                        return ((ChoiceModel)this.getModel(601438)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
        }
        return this.checkGuardSub3(n, n2);
    }

    public boolean checkGuardSub3(int n, int n2) {
        switch (n) {
            case 600415: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600183");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600183;
                    }
                    case 1: {
                        this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( !( ChoiceModel (MODELID#601056) Value == 600183 ) )");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4 && ((ChoiceModel)this.getModel(601056)).getValue() != 600183;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600434: {
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
            case 600436: {
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
            case 600447: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100465) Value > 0");
                        return ((ChoiceModel)this.getModel(2100465)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600450: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100465) Value > 0");
                        return ((ChoiceModel)this.getModel(2100465)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600457: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100383) Value == 1");
                        return ((ChoiceModel)this.getModel(2100383)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600459: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600183");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 600183;
                    }
                    case 1: {
                        this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( !( ChoiceModel (MODELID#601056) Value == 600183 ) )");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4 && ((ChoiceModel)this.getModel(601056)).getValue() != 600183;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600480: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601813) Value == 2");
                        return ((ChoiceModel)this.getModel(601813)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600489: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( !( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) ) && ( ChoiceModel (MODELID#600815) Value == 2 ) && ( ChoiceModel (MODELID#601843) Value == 1 )");
                        return ((SysConstModel)this.getModel(522)).getValue() != 4 && ((ChoiceModel)this.getModel(600815)).getValue() == 2 && ((ChoiceModel)this.getModel(601843)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601438) Value == 0");
                        return ((ChoiceModel)this.getModel(601438)).getValue() == 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600494: {
                this.logCheckGuard("ChoiceModel (MODELID#372) Value == 1");
                return ((ChoiceModel)this.getModel(372)).getValue() == 1;
            }
            case 600498: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100465) Value > 0");
                        return ((ChoiceModel)this.getModel(2100465)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600502: {
                this.logCheckGuard("ChoiceModel (MODELID#2100440) Value == 0");
                return ((ChoiceModel)this.getModel(2100440)).getValue() == 0;
            }
            case 600503: {
                this.logCheckGuard("ChoiceModel (MODELID#2100438) Value == 0");
                return ((ChoiceModel)this.getModel(2100438)).getValue() == 0;
            }
            case 600506: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100488) Value > 0");
                        return ((ChoiceModel)this.getModel(2100488)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100487) Value > 0");
                        return ((ChoiceModel)this.getModel(2100487)).getValue() > 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600512: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 604140");
                        return ((ChoiceModel)this.getModel(601056)).getValue() == 604140;
                    }
                }
                return false;
            }
            case 600513: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                        return ((ChoiceModel)this.getModel(600773)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600518: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100465) Value > 0");
                        return ((ChoiceModel)this.getModel(2100465)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600525: {
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
            case 600528: {
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
            case 600533: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#602240) Value == 1 )");
                        return ((ChoiceModel)this.getModel(602240)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#601885) Value == 1 )");
                        return ((ChoiceModel)this.getModel(601885)).getValue() != 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600536: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601257) Value == 0");
                        return ((ChoiceModel)this.getModel(601257)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600542: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100488) Value > 0");
                        return ((ChoiceModel)this.getModel(2100488)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100487) Value > 0");
                        return ((ChoiceModel)this.getModel(2100487)).getValue() > 0;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600543: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 0");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 1");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 2");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 2;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 3");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 3;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 4");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 4;
                    }
                    case 5: {
                        this.logCheckGuard("ButtonModel (MODELID#600625) Pressed == true");
                        return ((ButtonModel)this.getModel(600625)).getPressed();
                    }
                    case 6: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600544: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 0");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 1");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 2");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 2;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 3");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 3;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 4");
                        return ((ChoiceModel)this.getModel(600428)).getValue() == 4;
                    }
                    case 5: {
                        this.logCheckGuard("ButtonModel (MODELID#600625) Pressed == true");
                        return ((ButtonModel)this.getModel(600625)).getPressed();
                    }
                    case 6: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600545: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#601885) Value == 1 )");
                        return ((ChoiceModel)this.getModel(601885)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#601888) Value == 1 )");
                        return ((ChoiceModel)this.getModel(601888)).getValue() != 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600547: {
                this.logCheckGuard("!( ChoiceModel (MODELID#601888) Value == 1 )");
                return ((ChoiceModel)this.getModel(601888)).getValue() != 1;
            }
            case 600548: {
                this.logCheckGuard("!( ChoiceModel (MODELID#602240) Value == 1 )");
                return ((ChoiceModel)this.getModel(602240)).getValue() != 1;
            }
            case 600549: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#601885) Value == 1 )");
                        return ((ChoiceModel)this.getModel(601885)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#602240) Value == 1 )");
                        return ((ChoiceModel)this.getModel(602240)).getValue() != 1;
                    }
                    case 2: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600555: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                        return ((ChoiceModel)this.getModel(600773)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(600815)).getValue() != 1;
                    }
                    case 3: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600556: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 1 )");
                        return ((ChoiceModel)this.getModel(602321)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 2 )");
                        return ((ChoiceModel)this.getModel(602321)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 3 )");
                        return ((ChoiceModel)this.getModel(602321)).getValue() == 3;
                    }
                    case 3: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 4 )");
                        return ((ChoiceModel)this.getModel(602321)).getValue() == 4;
                    }
                    case 4: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 5 )");
                        return ((ChoiceModel)this.getModel(602321)).getValue() == 5;
                    }
                    case 5: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 6 )");
                        return ((ChoiceModel)this.getModel(602321)).getValue() == 6;
                    }
                    case 6: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600557: {
                this.logCheckGuard("ChoiceModel (MODELID#2100426) Value == 1");
                return ((ChoiceModel)this.getModel(2100426)).getValue() == 1;
            }
            case 600558: {
                this.logCheckGuard("ChoiceModel (MODELID#2100426) Value == 1");
                return ((ChoiceModel)this.getModel(2100426)).getValue() == 1;
            }
            case 600564: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100465) Value > 0");
                        return ((ChoiceModel)this.getModel(2100465)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600578: {
                this.logCheckGuard("( ChoiceModel (MODELID#5608) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                return ((ChoiceModel)this.getModel(5608)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 600580: {
                this.logCheckGuard("( ChoiceModel (MODELID#5608) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                if (((ChoiceModel)this.getModel(5608)).getValue() != 1 || ((ChoiceModel)this.getModel(5583)).getValue() != 1) {
                    return false;
                }
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601118) Value == 0");
                        return ((ChoiceModel)this.getModel(601118)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600582: {
                this.logCheckGuard("( ChoiceModel (MODELID#5608) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                return ((ChoiceModel)this.getModel(5608)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 600583: {
                this.logCheckGuard("( ( ChoiceModel (MODELID#5608) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 ) )");
                return ((ChoiceModel)this.getModel(5608)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
            }
            case 600584: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("( ChoiceModel (MODELID#5608) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                        return ((ChoiceModel)this.getModel(5608)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuardDefault();
                        return true;
                    }
                }
                return false;
            }
            case 600585: {
                this.logCheckGuard("( ChoiceModel (MODELID#5608) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                return ((ChoiceModel)this.getModel(5608)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
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

