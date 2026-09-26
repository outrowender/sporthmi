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
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private CarSMMInitStates smmInitStates;
    private CarSMMInitTransitions smmInitTransitions;
    private CarSMMInitMediators smmInitMediators;
    private CarSMMActions smmActions;

    public CarSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 6, "CarSMM");
    }

    public CarSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 6, "CarSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new CarSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new CarSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new CarSMMInitMediators(this, this.logChannel);
        this.smmActions = new CarSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 121112832;
        this.popupIDList = new int[]{-1071183616, -1054406400, -1037629184, -1020851968, -1004074752, -987297536, -970520320, -953743104, -936965888, -920188672};
        this.popupPriorityList = new int[]{1550, 0, 200, 100, 100, 1200, 1000, 100, 1000, 100};
        this.popupTopLevelStateIDList = new int[]{-148436736, -114882304, -81327872, 1009256704, 1042811136, 1227360512, 1260914944, 1328023808, 1479018752, 1529350400};
        this.popupZPMPriorityList = new int[]{100, 250, 235, 175, 175, 140, 155, 155, 155, 245};
        this.popupZPMSlotList = new int[]{2, 10, 2, 8, 8, 4, 4, 4, 4, 10};
        this.extStateIDList = new int[]{-399046400, -499709696, 1177028864, -482932480, -533264128, -1020851968, 1730676992, -1037629184, 121112832, -416872192, -415823616, 1126697216, -1004074752, 656935168, -618198784, 1932003584, 925370624};
        this.extStateLabelList = new String[]{"carOptChargeTimer2Main", "carChargeMainComp", "carCharismaComp", "settingsTimeInclude_Car", "AuxCombinedMainComp", "carFasMain", "AuxheatComp", "carCarsettingsMain", "carDesktop", "carAuxheatMain", "carOptChargeTimer1Main", "popupHelpBordbuch", "carServiceMain", "carCarsettingsUgdoLearnButtonMainUniversal", "carAcMain", "BordbuchComp", "carCarSettingsUgdoLearnButtonRollGroup"};
        this.incSlotList = new int[]{1109920000, -2077751040, -482932480, -248051456};
        this.incSlotStateIDList = new int[]{1126697216, -3, -4, -3};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "toneTouchSliderIncl", "settingsTime", "mainWizardRootState", "carOptChargeTimer1Weekday", "carOptChargeTimer2Weekday", "settingsSystemComp"};
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 600000: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                            return ((ChoiceModel)this.getModel(-987100928)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                            return ((SysConstModel)this.getModel(522)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                            return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                            return ((ChoiceModel)this.getModel(-785381120)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 2 )");
                            return ((ChoiceModel)this.getModel(-785381120)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 3 )");
                            return ((ChoiceModel)this.getModel(-785381120)).getValue() == 3;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 4 )");
                            return ((ChoiceModel)this.getModel(-785381120)).getValue() == 4;
                        }
                        case 4: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 5 )");
                            return ((ChoiceModel)this.getModel(-785381120)).getValue() == 5;
                        }
                        case 5: {
                            this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 6 )");
                            return ((ChoiceModel)this.getModel(-785381120)).getValue() == 6;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == 807930112;
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
                            return ((ChoiceModel)this.getModel(1814628608)).getValue() == 4;
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
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 8;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 3");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 7");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 7;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 6");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 6;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 4");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 5");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 5;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 1");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 1;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 2");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 2;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 0");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 0;
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
                            return ((ChoiceModel)this.getModel(1814628608)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 1");
                            return ((ChoiceModel)this.getModel(1814628608)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 2");
                            return ((ChoiceModel)this.getModel(1814628608)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 3");
                            return ((ChoiceModel)this.getModel(1814628608)).getValue() == 3;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 4");
                            return ((ChoiceModel)this.getModel(1814628608)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ButtonModel (MODELID#600625) Pressed == true");
                            return ((ButtonModel)this.getModel(824838400)).getPressed();
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
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 8;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 3");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 7");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 7;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 6");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 6;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 4");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 5");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 5;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 1");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 1;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 2");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 2;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#600427) Value == 0");
                            return ((ChoiceModel)this.getModel(1797851392)).getValue() == 0;
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
                    if (((ChoiceModel)this.getModel(-987100928)).getValue() >= 2) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                            return ((ChoiceModel)this.getModel(-987100928)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                            return ((SysConstModel)this.getModel(522)).getValue() == 4;
                        }
                        case 2: {
                            this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                            return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -987297536;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -970520320;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -953743104;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -936965888;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -920188672;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -903411456;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -869857024;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -853079808;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -836302592;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -819525376;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -802748160;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -785970944;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#600516) Value == 1");
                            return ((ChoiceModel)this.getModel(-1003943680)).getValue() == 1;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -769193728;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -718862080;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -702084864;
                        }
                        case 1: {
                            this.logCheckGuard("!( ChoiceModel (MODELID#600588) Value == 1 )");
                            return ((ChoiceModel)this.getModel(204081408)).getValue() != 1;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -685307648;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -668530432;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -651753216;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -584644352;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -567867136;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -534312704;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -517535488;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -500758272;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == 807930112;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -349763328;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -332986112;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -316208896;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1680345344;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -47773440;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -30996224;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == -14219008;
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
                            return ((ChoiceModel)this.getModel(-534050560)).getValue() == 36178176;
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
        this.smLogChannel.log(-2137614336, "[CarSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[CarSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    public boolean checkGuardSub1(int n, int n2) {
        switch (n) {
            case 600205: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600067");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 52955392;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 69732608;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 86509824;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 103287040;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 120064256;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 136841472;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 153618688;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 170395904;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 187173120;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 203950336;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 237504768;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 254281984;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 271059200;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 287836416;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 354945280;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 405276928;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 455608576;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 522717440;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 556271872;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -1020851968;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600004");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -1004074752;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600002");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -1037629184;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600039");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -416872192;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600027");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -618198784;
                    }
                    case 5: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600067");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 52955392;
                    }
                    case 6: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600097");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 556271872;
                    }
                    case 7: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600072");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 136841472;
                    }
                    case 8: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600040");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -400094976;
                    }
                    case 9: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600030");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -567867136;
                    }
                    case 10: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600032");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -534312704;
                    }
                    case 11: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600033");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -517535488;
                    }
                    case 12: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600034");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -500758272;
                    }
                    case 13: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600026");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -634976000;
                    }
                    case 14: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600005");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -987297536;
                    }
                    case 15: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600006");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -970520320;
                    }
                    case 16: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600007");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -953743104;
                    }
                    case 17: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600010");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -903411456;
                    }
                    case 18: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600012");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -869857024;
                    }
                    case 19: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600013");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -853079808;
                    }
                    case 20: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600015");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -819525376;
                    }
                    case 21: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600016");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -802748160;
                    }
                    case 22: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600018");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -769193728;
                    }
                    case 23: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600061");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -47773440;
                    }
                    case 24: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600044");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -332986112;
                    }
                    case 25: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600043");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -349763328;
                    }
                    case 26: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600045");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -316208896;
                    }
                    case 27: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600073");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 153618688;
                    }
                    case 28: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600075");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 187173120;
                    }
                    case 29: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600164");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1680345344;
                    }
                    case 30: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600068");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 69732608;
                    }
                    case 31: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600069");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 86509824;
                    }
                    case 32: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600070");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 103287040;
                    }
                    case 33: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600071");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 120064256;
                    }
                    case 34: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600038");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -433649408;
                    }
                    case 35: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600029");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -584644352;
                    }
                    case 36: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600031");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -551089920;
                    }
                    case 37: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600024");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -668530432;
                    }
                    case 38: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600025");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -651753216;
                    }
                    case 39: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600022");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -702084864;
                    }
                    case 40: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600023");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -685307648;
                    }
                    case 41: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600021");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -718862080;
                    }
                    case 42: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600008");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -936965888;
                    }
                    case 43: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600009");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -920188672;
                    }
                    case 44: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600014");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -836302592;
                    }
                    case 45: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600017");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -785970944;
                    }
                    case 46: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600019");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -752416512;
                    }
                    case 47: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600062");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -30996224;
                    }
                    case 48: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600079");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 254281984;
                    }
                    case 49: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600080");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 271059200;
                    }
                    case 50: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600074");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 170395904;
                    }
                    case 51: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600078");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 237504768;
                    }
                    case 52: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600076");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 203950336;
                    }
                    case 53: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600085");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 354945280;
                    }
                    case 54: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600088");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 405276928;
                    }
                    case 55: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600091");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 455608576;
                    }
                    case 56: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600094");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 505940224;
                    }
                    case 57: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600066");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 36178176;
                    }
                    case 58: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600063");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -14219008;
                    }
                    case 59: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600065");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 19400960;
                    }
                    case 60: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600141");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1294469376;
                    }
                    case 61: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600157");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1562904832;
                    }
                    case 62: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600112");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 807930112;
                    }
                    case 63: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 600183");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1999112448;
                    }
                    case 64: {
                        this.logCheckGuard("ChoiceModel (MODELID#601056) Value == 604140");
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -331937536;
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
                        return ((ChoiceModel)this.getModel(-1826027264)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -634976000;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 19400960;
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
                        return ((ChoiceModel)this.getModel(-1238693632)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#601020) Value == 0 ) && ( !( ChoiceModel (MODELID#601014) Value == 2 ) ) && ( !( ChoiceModel (MODELID#601014) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(-1138030336)).getValue() == 0 && ((ChoiceModel)this.getModel(-1238693632)).getValue() != 2 && ((ChoiceModel)this.getModel(-1238693632)).getValue() != 0;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 0");
                        return ((ChoiceModel)this.getModel(-1238693632)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-1238693632)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#601020) Value == 0 ) && ( !( ChoiceModel (MODELID#601014) Value == 2 ) ) && ( !( ChoiceModel (MODELID#601014) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(-1138030336)).getValue() == 0 && ((ChoiceModel)this.getModel(-1238693632)).getValue() != 2 && ((ChoiceModel)this.getModel(-1238693632)).getValue() != 0;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 0");
                        return ((ChoiceModel)this.getModel(-1238693632)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-1238693632)).getValue() == 2;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#601020) Value == 0 ) && ( !( ChoiceModel (MODELID#601014) Value == 2 ) ) && ( !( ChoiceModel (MODELID#601014) Value == 0 ) )");
                        return ((ChoiceModel)this.getModel(-1138030336)).getValue() == 0 && ((ChoiceModel)this.getModel(-1238693632)).getValue() != 2 && ((ChoiceModel)this.getModel(-1238693632)).getValue() != 0;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#601014) Value == 0");
                        return ((ChoiceModel)this.getModel(-1238693632)).getValue() == 0;
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
                return ((ChoiceModel)this.getModel(-919926528)).getValue() == 1;
            }
            case 600270: {
                this.logCheckGuard("ChoiceModel (MODELID#601033) Value == 0");
                return ((ChoiceModel)this.getModel(-919926528)).getValue() == 0;
            }
            case 600281: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600381) Value == 0");
                        return ((ChoiceModel)this.getModel(1026099456)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(1579747584)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -1037629184;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(506202368)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -1020851968;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -1004074752;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -618198784;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -416872192;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-987100928)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1999112448;
                    }
                    case 1: {
                        this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( !( ChoiceModel (MODELID#601056) Value == 600183 ) )");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4 && ((ChoiceModel)this.getModel(-534050560)).getValue() != 1999112448;
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
                        return ((ChoiceModel)this.getModel(-2060842752)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-2060842752)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -517535488;
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
                        return ((ChoiceModel)this.getModel(-1826027264)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-2044065536)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#600709) Value > 0 ) && ( ChoiceModel (MODELID#601254) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-2060842752)).getValue() > 0 && ((ChoiceModel)this.getModel(-1507063552)).getValue() == 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -416872192;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-2044065536)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#600709) Value > 0 ) && ( ChoiceModel (MODELID#601254) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-2060842752)).getValue() > 0 && ((ChoiceModel)this.getModel(-1507063552)).getValue() == 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 170395904;
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
                        return ((ChoiceModel)this.getModel(-1456731904)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-1456731904)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1294469376;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1562904832;
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
                        return ((ChoiceModel)this.getModel(-987100928)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((SysConstModel)this.getModel(522)).getValue() != 4 && ((ChoiceModel)this.getModel(-282457856)).getValue() == 2 && ((ChoiceModel)this.getModel(-215086848)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601438) Value == 0");
                        return ((ChoiceModel)this.getModel(1580009728)).getValue() == 0;
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
                        return ((SysConstModel)this.getModel(522)).getValue() != 4 && ((ChoiceModel)this.getModel(-282457856)).getValue() == 2 && ((ChoiceModel)this.getModel(-215086848)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601438) Value == 0");
                        return ((ChoiceModel)this.getModel(1580009728)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1999112448;
                    }
                    case 1: {
                        this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( !( ChoiceModel (MODELID#601056) Value == 600183 ) )");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4 && ((ChoiceModel)this.getModel(-534050560)).getValue() != 1999112448;
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
                        return ((ChoiceModel)this.getModel(-250863616)).getValue() > 0;
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
                        return ((ChoiceModel)this.getModel(-250863616)).getValue() > 0;
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
                        return ((ChoiceModel)this.getModel(-1626595328)).getValue() == 1;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == 1999112448;
                    }
                    case 1: {
                        this.logCheckGuard("( SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440 ) && ( !( ChoiceModel (MODELID#601056) Value == 600183 ) )");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4 && ((ChoiceModel)this.getModel(-534050560)).getValue() != 1999112448;
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
                        return ((ChoiceModel)this.getModel(-718403328)).getValue() == 2;
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
                        return ((SysConstModel)this.getModel(522)).getValue() != 4 && ((ChoiceModel)this.getModel(-282457856)).getValue() == 2 && ((ChoiceModel)this.getModel(-215086848)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#601438) Value == 0");
                        return ((ChoiceModel)this.getModel(1580009728)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(-250863616)).getValue() > 0;
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
                return ((ChoiceModel)this.getModel(-670294016)).getValue() == 0;
            }
            case 600503: {
                this.logCheckGuard("ChoiceModel (MODELID#2100438) Value == 0");
                return ((ChoiceModel)this.getModel(-703848448)).getValue() == 0;
            }
            case 600506: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100488) Value > 0");
                        return ((ChoiceModel)this.getModel(135077888)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100487) Value > 0");
                        return ((ChoiceModel)this.getModel(118300672)).getValue() > 0;
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
                        return ((ChoiceModel)this.getModel(-534050560)).getValue() == -331937536;
                    }
                }
                return false;
            }
            case 600513: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#600773) Value == 1");
                        return ((ChoiceModel)this.getModel(-987100928)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-250863616)).getValue() > 0;
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
                        return ((ChoiceModel)this.getModel(-2144335616)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#601885) Value == 1 )");
                        return ((ChoiceModel)this.getModel(489621760)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-1456731904)).getValue() == 0;
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
                        return ((ChoiceModel)this.getModel(135077888)).getValue() > 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100487) Value > 0");
                        return ((ChoiceModel)this.getModel(118300672)).getValue() > 0;
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
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 1");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 2");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 2;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 3");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 3;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 4");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 4;
                    }
                    case 5: {
                        this.logCheckGuard("ButtonModel (MODELID#600625) Pressed == true");
                        return ((ButtonModel)this.getModel(824838400)).getPressed();
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
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 0;
                    }
                    case 1: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 1");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 1;
                    }
                    case 2: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 2");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 2;
                    }
                    case 3: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 3");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 3;
                    }
                    case 4: {
                        this.logCheckGuard("ChoiceModel (MODELID#600428) Value == 4");
                        return ((ChoiceModel)this.getModel(1814628608)).getValue() == 4;
                    }
                    case 5: {
                        this.logCheckGuard("ButtonModel (MODELID#600625) Pressed == true");
                        return ((ButtonModel)this.getModel(824838400)).getPressed();
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
                        return ((ChoiceModel)this.getModel(489621760)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#601888) Value == 1 )");
                        return ((ChoiceModel)this.getModel(539953408)).getValue() != 1;
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
                return ((ChoiceModel)this.getModel(539953408)).getValue() != 1;
            }
            case 600548: {
                this.logCheckGuard("!( ChoiceModel (MODELID#602240) Value == 1 )");
                return ((ChoiceModel)this.getModel(-2144335616)).getValue() != 1;
            }
            case 600549: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#601885) Value == 1 )");
                        return ((ChoiceModel)this.getModel(489621760)).getValue() != 1;
                    }
                    case 1: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#602240) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-2144335616)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-987100928)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("SysConstModel (MODELID#522) Value == ICoreSysConfig.SCREEN_RESOLUTION_1440");
                        return ((SysConstModel)this.getModel(522)).getValue() == 4;
                    }
                    case 2: {
                        this.logCheckGuard("!( ChoiceModel (MODELID#600815) Value == 1 )");
                        return ((ChoiceModel)this.getModel(-282457856)).getValue() != 1;
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
                        return ((ChoiceModel)this.getModel(-785381120)).getValue() == 1;
                    }
                    case 1: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 2 )");
                        return ((ChoiceModel)this.getModel(-785381120)).getValue() == 2;
                    }
                    case 2: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 3 )");
                        return ((ChoiceModel)this.getModel(-785381120)).getValue() == 3;
                    }
                    case 3: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 4 )");
                        return ((ChoiceModel)this.getModel(-785381120)).getValue() == 4;
                    }
                    case 4: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 5 )");
                        return ((ChoiceModel)this.getModel(-785381120)).getValue() == 5;
                    }
                    case 5: {
                        this.logCheckGuard("( ChoiceModel (MODELID#602321) Value == 6 )");
                        return ((ChoiceModel)this.getModel(-785381120)).getValue() == 6;
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
                return ((ChoiceModel)this.getModel(-905175040)).getValue() == 1;
            }
            case 600558: {
                this.logCheckGuard("ChoiceModel (MODELID#2100426) Value == 1");
                return ((ChoiceModel)this.getModel(-905175040)).getValue() == 1;
            }
            case 600564: {
                switch (n2) {
                    case 0: {
                        this.logCheckGuard("ChoiceModel (MODELID#2100465) Value > 0");
                        return ((ChoiceModel)this.getModel(-250863616)).getValue() > 0;
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
                        return ((ChoiceModel)this.getModel(506202368)).getValue() == 0;
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

