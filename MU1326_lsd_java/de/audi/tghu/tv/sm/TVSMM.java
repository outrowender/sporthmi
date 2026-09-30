/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.tv.sm.TVSMMActions;
import de.audi.tghu.tv.sm.TVSMMInitMediators;
import de.audi.tghu.tv.sm.TVSMMInitStates;
import de.audi.tghu.tv.sm.TVSMMInitTransitions;
import java.util.NoSuchElementException;

public class TVSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 26;
    public static final String SMM_NAME = "TVSMM";
    private TVSMMInitStates smmInitStates;
    private TVSMMInitTransitions smmInitTransitions;
    private TVSMMInitMediators smmInitMediators;
    private TVSMMActions smmActions;

    public TVSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 26, SMM_NAME);
    }

    public TVSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 26, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new TVSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new TVSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new TVSMMInitMediators(this, this.logChannel);
        this.smmActions = new TVSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 2600066;
        this.popupIDList = new int[]{2600000};
        this.popupPriorityList = new int[]{1};
        this.popupTopLevelStateIDList = new int[]{2600088};
        this.popupZPMPriorityList = new int[]{250};
        this.popupZPMSlotList = new int[]{4};
        this.extStateIDList = new int[]{2600000, 2600036, 2600039, 2600045, 2600046, 2600066};
        this.extStateLabelList = new String[]{"tvCenterMain", "tvCenter", "tvAVMain", "tvMovieRating", "tvMovieRatingMain", "tvDesktop"};
        this.incSlotList = new int[]{2600015, 2600043, 2600044, 2600073, 2600078, 2600090, 2600093};
        this.incSlotStateIDList = new int[]{-3, 2600072, 2600050, -4, 2600079, 2600072, -5};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "toneSystem", "popupHelpBordbuch", "toneTouchSliderIncl"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 2600001: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600184) Value == 0 )");
                            return ((ChoiceModel)this.getModel(2600184)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600002: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600082) Value == 1 )");
                            return ((ChoiceModel)this.getModel(2600082)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600026) Value == 1 ) && ( ( ChoiceModel (MODELID#2600016) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                            return ((ChoiceModel)this.getModel(2600026)).getValue() == 1 && (((ChoiceModel)this.getModel(2600016)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1);
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600026) Value == 0 ) && ( !( ( ChoiceModel (MODELID#2600016) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) ) )");
                            return ((ChoiceModel)this.getModel(2600026)).getValue() == 0 && ((ChoiceModel)this.getModel(2600016)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600026) Value == 1 ) && ( !( ( ChoiceModel (MODELID#2600016) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) ) )");
                            return ((ChoiceModel)this.getModel(2600026)).getValue() == 1 && ((ChoiceModel)this.getModel(2600016)).getValue() != 1 && (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5618)).getValue() != 1);
                        }
                        case 4: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600014: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600021: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600024: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600025: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600026) Value == 0 )");
                            return ((ChoiceModel)this.getModel(2600026)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600048: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600014) Value == 1");
                            return ((ChoiceModel)this.getModel(2600014)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600014) Value == 2");
                            return ((ChoiceModel)this.getModel(2600014)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600074: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600014) Value == 0");
                            return ((ChoiceModel)this.getModel(2600014)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600014) Value == 1");
                            return ((ChoiceModel)this.getModel(2600014)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600076: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600080) Value == 1 ) && ( !( ChoiceModel (MODELID#2600156) Value == 13 ) )");
                    return ((ChoiceModel)this.getModel(2600080)).getValue() == 1 && ((ChoiceModel)this.getModel(2600156)).getValue() != 13;
                }
                case 2600078: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600081) Value == 1 )");
                            return ((ChoiceModel)this.getModel(2600081)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600040) Value == 0 )");
                            return ((ChoiceModel)this.getModel(2600040)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600082: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600014) Value == 0");
                            return ((ChoiceModel)this.getModel(2600014)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600096: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600017) Value == 0");
                            return ((ChoiceModel)this.getModel(2600017)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600112: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600119) Value == 1 )");
                            return ((ChoiceModel)this.getModel(2600119)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600117: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600080) Value == 1 )");
                            return ((ChoiceModel)this.getModel(2600080)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600127: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600081) Value == 1 )");
                    return ((ChoiceModel)this.getModel(2600081)).getValue() == 1;
                }
                case 2600128: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600082) Value == 1 )");
                    return ((ChoiceModel)this.getModel(2600082)).getValue() == 1;
                }
                case 2600158: {
                    this.logCheckGuard("( SpellerModel (MODELID#2600114) Status == 0 )");
                    return ((SpellerModel)this.getModel(2600114)).getStatus() == 0;
                }
                case 2600160: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ( ChoiceModel (MODELID#2600016) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) ) )");
                            return ((ChoiceModel)this.getModel(2600016)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600163: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600016) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600016)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600166: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600016) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                    return ((ChoiceModel)this.getModel(2600016)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                }
                case 2600167: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600016) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                    return ((ChoiceModel)this.getModel(2600016)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                }
                case 2600168: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600101) Value == 1 )");
                    return ((ChoiceModel)this.getModel(2600101)).getValue() == 1;
                }
                case 2600172: {
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
                case 2600173: {
                    this.logCheckGuard("( !( ChoiceModel (MODELID#377) Value == 1 ) )");
                    return ((ChoiceModel)this.getModel(377)).getValue() != 1;
                }
                case 2600191: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600081) Value == 1 )");
                            return ((ChoiceModel)this.getModel(2600081)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600040) Value == 0 )");
                            return ((ChoiceModel)this.getModel(2600040)).getValue() == 0;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600205: {
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
                case 2600207: {
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
                case 2600218: {
                    this.logCheckGuard("( ChoiceModel (MODELID#335) Value > 0 )");
                    return ((ChoiceModel)this.getModel(335)).getValue() > 0;
                }
                case 2600219: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600184) Value == 0 )");
                    return ((ChoiceModel)this.getModel(2600184)).getValue() == 0;
                }
                case 2600222: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600184) Value == 1 )");
                    return ((ChoiceModel)this.getModel(2600184)).getValue() == 1;
                }
                case 2600223: {
                    this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value > 0 )");
                    if (((ChoiceModel)this.getModel(2600146)).getValue() <= 0) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 2 ) || ( ChoiceModel (MODELID#200530) Value == 8 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 2 || ((ChoiceModel)this.getModel(200530)).getValue() == 8;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 3 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 4 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 4;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 6 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 6;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600146) Value == 5");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 5;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600226: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600184) Value == 0 )");
                            return ((ChoiceModel)this.getModel(2600184)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600229: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value > 0 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600230: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 2 ) || ( ChoiceModel (MODELID#200530) Value == 8 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 2 || ((ChoiceModel)this.getModel(200530)).getValue() == 8;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 3 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 3;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 4 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 4;
                        }
                        case 3: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600146) Value == 6 )");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 6;
                        }
                        case 4: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600146) Value == 5");
                            return ((ChoiceModel)this.getModel(2600146)).getValue() == 5;
                        }
                        case 5: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600236: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600240: {
                    this.logCheckGuard("( ChoiceModel (MODELID#5592) Value == 1 ) && ( ChoiceModel (MODELID#5583) Value == 1 )");
                    return ((ChoiceModel)this.getModel(5592)).getValue() == 1 && ((ChoiceModel)this.getModel(5583)).getValue() == 1;
                }
                case 2600243: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600244: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600246: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600247: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600249: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#2600023) Value == 1 ) || ( ( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5618) Value == 1 ) )");
                            return ((ChoiceModel)this.getModel(2600023)).getValue() == 1 || ((ChoiceModel)this.getModel(5583)).getValue() == 1 && ((ChoiceModel)this.getModel(5618)).getValue() == 1;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 2600251: {
                    this.logCheckGuard("( ChoiceModel (MODELID#5583) Value == 1 ) && ( ChoiceModel (MODELID#5592) Value == 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )");
                    if (((ChoiceModel)this.getModel(5583)).getValue() != 1 || ((ChoiceModel)this.getModel(5592)).getValue() != 1 || ((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9) {
                        return false;
                    }
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#2600159) Value == 1");
                            return ((ChoiceModel)this.getModel(2600159)).getValue() == 1;
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
                this.logChannel.log(10000, "[TVSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[TVSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[TVSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[TVSMM.java#checkGuard] checking: '%1'", (Object)string);
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

