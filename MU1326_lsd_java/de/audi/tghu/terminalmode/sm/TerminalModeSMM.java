/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.terminalmode.sm.TerminalModeSMMActions;
import de.audi.tghu.terminalmode.sm.TerminalModeSMMInitMediators;
import de.audi.tghu.terminalmode.sm.TerminalModeSMMInitStates;
import de.audi.tghu.terminalmode.sm.TerminalModeSMMInitTransitions;
import java.util.NoSuchElementException;

public class TerminalModeSMM
extends AbstractAppSMM {
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private TerminalModeSMMInitStates smmInitStates;
    private TerminalModeSMMInitTransitions smmInitTransitions;
    private TerminalModeSMMInitMediators smmInitMediators;
    private TerminalModeSMMActions smmActions;

    public TerminalModeSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 32, "TerminalModeSMM");
    }

    public TerminalModeSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 32, "TerminalModeSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new TerminalModeSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new TerminalModeSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new TerminalModeSMMInitMediators(this, this.logChannel);
        this.smmActions = new TerminalModeSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 30683136;
        this.popupIDList = EMPTY_INT_LIST;
        this.popupPriorityList = EMPTY_INT_LIST;
        this.popupTopLevelStateIDList = EMPTY_INT_LIST;
        this.popupZPMPriorityList = EMPTY_INT_LIST;
        this.popupZPMSlotList = EMPTY_INT_LIST;
        this.extStateIDList = new int[]{30683136};
        this.extStateLabelList = new String[]{"terminalModeDesktop"};
        this.incSlotList = new int[]{148123648};
        this.incSlotStateIDList = new int[]{-3};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "connectivityCenter", "mainWizzard"};
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 3200000: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4239) Value == 0 ) && ( ChoiceModel (MODELID#4384) Value == 0 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() == 0 && ((ChoiceModel)this.getModel(4384)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3200004: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#3200012) Value == 1 ) && ( ChoiceModel (MODELID#4239) Value == 2 )");
                            return ((ChoiceModel)this.getModel(215232512)).getValue() == 1 && ((ChoiceModel)this.getModel(4239)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4239) Value == 3 ) && ( ChoiceModel (MODELID#3200012) Value == 2 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() == 3 && ((ChoiceModel)this.getModel(215232512)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4239) Value == 3 ) && ( ChoiceModel (MODELID#3200012) Value == 3 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() == 3 && ((ChoiceModel)this.getModel(215232512)).getValue() == 3;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3200005: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4384) Value == 1 ) || ( ChoiceModel (MODELID#4384) Value == 2 )");
                            return ((ChoiceModel)this.getModel(4384)).getValue() == 1 || ((ChoiceModel)this.getModel(4384)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3200007: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#3200012) Value == 1 ) && ( ChoiceModel (MODELID#4239) Value == 2 )");
                            return ((ChoiceModel)this.getModel(215232512)).getValue() == 1 && ((ChoiceModel)this.getModel(4239)).getValue() == 2;
                        }
                        case 1: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4239) Value == 3 ) && ( ChoiceModel (MODELID#3200012) Value == 2 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() == 3 && ((ChoiceModel)this.getModel(215232512)).getValue() == 2;
                        }
                        case 2: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4239) Value == 3 ) && ( ChoiceModel (MODELID#3200012) Value == 3 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() == 3 && ((ChoiceModel)this.getModel(215232512)).getValue() == 3;
                        }
                        case 3: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3200014: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#4384) Value > 0");
                            return ((ChoiceModel)this.getModel(4384)).getValue() > 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3200018: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4239) Value == 0 ) && ( ChoiceModel (MODELID#4384) Value == 0 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() == 0 && ((ChoiceModel)this.getModel(4384)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3200019: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#3200049) Value == 1 ) || ( ChoiceModel (MODELID#3200049) Value == 2 ) || ( ChoiceModel (MODELID#3200049) Value == 3 ) || ( ChoiceModel (MODELID#3200049) Value == 4 ) || ( ChoiceModel (MODELID#3200049) Value == 5 ) || ( ChoiceModel (MODELID#3200049) Value == 6 )");
                            return ((ChoiceModel)this.getModel(835989504)).getValue() == 1 || ((ChoiceModel)this.getModel(835989504)).getValue() == 2 || ((ChoiceModel)this.getModel(835989504)).getValue() == 3 || ((ChoiceModel)this.getModel(835989504)).getValue() == 4 || ((ChoiceModel)this.getModel(835989504)).getValue() == 5 || ((ChoiceModel)this.getModel(835989504)).getValue() == 6;
                        }
                        case 1: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 3200021: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("( ChoiceModel (MODELID#4239) Value == 0 ) && ( ChoiceModel (MODELID#4384) Value == 0 )");
                            return ((ChoiceModel)this.getModel(4239)).getValue() == 0 && ((ChoiceModel)this.getModel(4384)).getValue() == 0;
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
                this.logChannel.log(10000, "[TerminalModeSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[TerminalModeSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(-2137614336, "[TerminalModeSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[TerminalModeSMM.java#checkGuard] checking: '%1'", (Object)string);
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

