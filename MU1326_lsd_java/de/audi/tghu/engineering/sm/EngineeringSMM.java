/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.engineering.sm.EngineeringSMMActions;
import de.audi.tghu.engineering.sm.EngineeringSMMInitMediators;
import de.audi.tghu.engineering.sm.EngineeringSMMInitStates;
import de.audi.tghu.engineering.sm.EngineeringSMMInitTransitions;
import java.util.NoSuchElementException;

public class EngineeringSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 13;
    public static final String SMM_NAME = "EngineeringSMM";
    private EngineeringSMMInitStates smmInitStates;
    private EngineeringSMMInitTransitions smmInitTransitions;
    private EngineeringSMMInitMediators smmInitMediators;
    private EngineeringSMMActions smmActions;

    public EngineeringSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 13, SMM_NAME);
    }

    public EngineeringSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 13, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new EngineeringSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new EngineeringSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new EngineeringSMMInitMediators(this, this.logChannel);
        this.smmActions = new EngineeringSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 1300001;
        this.popupIDList = EMPTY_INT_LIST;
        this.popupPriorityList = EMPTY_INT_LIST;
        this.popupTopLevelStateIDList = EMPTY_INT_LIST;
        this.popupZPMPriorityList = EMPTY_INT_LIST;
        this.popupZPMSlotList = EMPTY_INT_LIST;
        this.extStateIDList = new int[]{1300001};
        this.extStateLabelList = new String[]{"engineeringDesktop"};
        this.incSlotList = new int[]{1300005};
        this.incSlotStateIDList = new int[]{-3};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "swdl"};
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 1300064: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("BufferedListModel (MODELID#1300016) Length == 0");
                            return ((BufferedListModel)this.getModel(1300016)).getLength() == 0;
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
                this.logChannel.log(10000, "[EngineeringSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[EngineeringSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[EngineeringSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[EngineeringSMM.java#checkGuard] checking: '%1'", (Object)string);
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

