/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.ecall.sm.EcallSMMActions;
import de.audi.tghu.ecall.sm.EcallSMMInitMediators;
import de.audi.tghu.ecall.sm.EcallSMMInitStates;
import de.audi.tghu.ecall.sm.EcallSMMInitTransitions;
import java.util.NoSuchElementException;

public class EcallSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 33;
    public static final String SMM_NAME = "EcallSMM";
    private EcallSMMInitStates smmInitStates;
    private EcallSMMInitTransitions smmInitTransitions;
    private EcallSMMInitMediators smmInitMediators;
    private EcallSMMActions smmActions;

    public EcallSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 33, SMM_NAME);
    }

    public EcallSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 33, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new EcallSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new EcallSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new EcallSMMInitMediators(this, this.logChannel);
        this.smmActions = new EcallSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 3300026;
        this.popupIDList = new int[]{3300000, 3300001, 3300002, 3300003};
        this.popupPriorityList = new int[]{250, 249, 500, 0};
        this.popupTopLevelStateIDList = new int[]{3300004, 3300006, 3300059, 3300063};
        this.popupZPMPriorityList = new int[]{125, 130, 125, 135};
        this.popupZPMSlotList = new int[]{12, 12, 12, 12};
        this.extStateIDList = new int[]{3300026, 3300027};
        this.extStateLabelList = new String[]{"ecallDesktop", "ecallStates"};
        this.incSlotList = new int[]{3300060, 3300061, 3300074};
        this.incSlotStateIDList = new int[]{3300062, 3300062, -3};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "audiConnectOptLicenseComp"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 3300001: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#367) Value == 1024");
                            return ((ChoiceModel)this.getModel(367)).getValue() == 1024;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3300007: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 0");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 1");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 2");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 3");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 3;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 4");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 5");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 5;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 6");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 6;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 7");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 7;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 8");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 8;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 9");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 9;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 11");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 11;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 12");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 12;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 13");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 13;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 14");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 14;
                        }
                        case 14: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 15");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 15;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 16");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 16;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 17");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 17;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 18");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 18;
                        }
                        case 18: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 19");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 19;
                        }
                        case 19: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 20");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 20;
                        }
                        case 20: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 21");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 21;
                        }
                        case 21: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 22");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 22;
                        }
                        case 22: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 33");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 33;
                        }
                        case 23: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 24");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 24;
                        }
                        case 24: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 25");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 25;
                        }
                        case 25: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 26");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 26;
                        }
                        case 26: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 27");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 27;
                        }
                        case 27: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 28");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 28;
                        }
                        case 28: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 29");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 29;
                        }
                        case 29: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 30");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 30;
                        }
                        case 30: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 31");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 31;
                        }
                        case 31: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 32");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 32;
                        }
                        case 32: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3300014: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 6");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 14");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 14;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 2");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 13");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 13;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 18");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 18;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 12");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 12;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 8");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 8;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 15");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 15;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 0");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 0;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 21");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 21;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 4");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 4;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 3");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 3;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 11");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 11;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 19");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 19;
                        }
                        case 14: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 9");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 9;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 10");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 10;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 20");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 20;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 5");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 5;
                        }
                        case 18: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 16");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 16;
                        }
                        case 19: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 1");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 1;
                        }
                        case 20: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 7");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 7;
                        }
                        case 21: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 22");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 22;
                        }
                        case 22: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3300015: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 6");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 14");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 14;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 2");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 13");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 13;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 18");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 18;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 12");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 12;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 8");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 8;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 15");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 15;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 0");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 0;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 21");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 21;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 4");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 4;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 3");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 3;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 11");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 11;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 19");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 19;
                        }
                        case 14: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 9");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 9;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 10");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 10;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 20");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 20;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 5");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 5;
                        }
                        case 18: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 16");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 16;
                        }
                        case 19: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 1");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 1;
                        }
                        case 20: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 7");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 7;
                        }
                        case 21: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 22");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 22;
                        }
                        case 22: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3300016: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 6");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 14");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 14;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 2");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 13");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 13;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 18");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 18;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 12");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 12;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 8");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 8;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 15");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 15;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 0");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 0;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 21");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 21;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 4");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 4;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 3");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 3;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 11");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 11;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 19");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 19;
                        }
                        case 14: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 9");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 9;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 10");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 10;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 20");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 20;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 5");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 5;
                        }
                        case 18: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 16");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 16;
                        }
                        case 19: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 1");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 1;
                        }
                        case 20: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 7");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 7;
                        }
                        case 21: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 22");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 22;
                        }
                        case 22: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3300017: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 6");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 14");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 14;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 2");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 13");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 13;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 18");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 18;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 12");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 12;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 8");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 8;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 15");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 15;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 0");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 0;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 21");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 21;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 4");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 4;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 3");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 3;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 11");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 11;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 19");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 19;
                        }
                        case 14: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 9");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 9;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 10");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 10;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 20");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 20;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 5");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 5;
                        }
                        case 18: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 16");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 16;
                        }
                        case 19: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 1");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 1;
                        }
                        case 20: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 7");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 7;
                        }
                        case 21: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 22");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 22;
                        }
                        case 22: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3300020: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 0");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 1");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 2");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 3");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 3;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 4");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 4;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 5");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 5;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 6");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 6;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 7");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 7;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 8");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 8;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 9");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 9;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 11");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 11;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 12");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 12;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 13");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 13;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 14");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 14;
                        }
                        case 14: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 15");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 15;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 16");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 16;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 17");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 17;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 18");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 18;
                        }
                        case 18: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 19");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 19;
                        }
                        case 19: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 20");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 20;
                        }
                        case 20: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 21");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 21;
                        }
                        case 21: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 22");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 22;
                        }
                        case 22: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 33");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 33;
                        }
                        case 23: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 24");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 24;
                        }
                        case 24: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 25");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 25;
                        }
                        case 25: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 26");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 26;
                        }
                        case 26: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 27");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 27;
                        }
                        case 27: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 28");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 28;
                        }
                        case 28: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 29");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 29;
                        }
                        case 29: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 30");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 30;
                        }
                        case 30: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 31");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 31;
                        }
                        case 31: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 32");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 32;
                        }
                        case 32: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3300021: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 6");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 14");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 14;
                        }
                        case 2: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 2");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 2;
                        }
                        case 3: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 13");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 13;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 18");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 18;
                        }
                        case 5: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 12");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 12;
                        }
                        case 6: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 8");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 8;
                        }
                        case 7: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 15");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 15;
                        }
                        case 8: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 0");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 0;
                        }
                        case 9: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 21");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 21;
                        }
                        case 10: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 4");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 4;
                        }
                        case 11: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 3");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 3;
                        }
                        case 12: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 11");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 11;
                        }
                        case 13: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 19");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 19;
                        }
                        case 14: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 9");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 9;
                        }
                        case 15: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 10");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 10;
                        }
                        case 16: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 20");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 20;
                        }
                        case 17: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 5");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 5;
                        }
                        case 18: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 16");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 16;
                        }
                        case 19: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 1");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 1;
                        }
                        case 20: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 7");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 7;
                        }
                        case 21: {
                            this.logCheckGuard("ChoiceModel (MODELID#3300006) Value == 22");
                            return ((ChoiceModel)this.getModel(3300006)).getValue() == 22;
                        }
                        case 22: {
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
                this.logChannel.log(10000, "[EcallSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[EcallSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[EcallSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[EcallSMM.java#checkGuard] checking: '%1'", (Object)string);
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

