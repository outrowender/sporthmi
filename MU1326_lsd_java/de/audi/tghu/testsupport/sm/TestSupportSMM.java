/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.testsupport.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.testsupport.sm.TestSupportSMMActions;
import de.audi.tghu.testsupport.sm.TestSupportSMMInitMediators;
import de.audi.tghu.testsupport.sm.TestSupportSMMInitStates;
import de.audi.tghu.testsupport.sm.TestSupportSMMInitTransitions;
import java.util.NoSuchElementException;

public class TestSupportSMM
extends AbstractAppSMM {
    public static final int MODULE_ID = 24;
    public static final String SMM_NAME = "TestSupportSMM";
    private TestSupportSMMInitStates smmInitStates;
    private TestSupportSMMInitTransitions smmInitTransitions;
    private TestSupportSMMInitMediators smmInitMediators;
    private TestSupportSMMActions smmActions;

    public TestSupportSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 24, SMM_NAME);
    }

    public TestSupportSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 24, SMM_NAME);
    }

    private void initSubclasses() {
        this.smmInitStates = new TestSupportSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new TestSupportSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new TestSupportSMMInitMediators(this, this.logChannel);
        this.smmActions = new TestSupportSMMActions(this, this.logChannel);
    }

    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 2400000;
        this.popupIDList = EMPTY_INT_LIST;
        this.popupPriorityList = EMPTY_INT_LIST;
        this.popupTopLevelStateIDList = EMPTY_INT_LIST;
        this.popupZPMPriorityList = EMPTY_INT_LIST;
        this.popupZPMSlotList = EMPTY_INT_LIST;
        this.extStateIDList = new int[]{2400000};
        this.extStateLabelList = new String[]{"tsDesktop"};
        this.incSlotList = EMPTY_INT_LIST;
        this.incSlotStateIDList = EMPTY_INT_LIST;
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
    }

    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                default: 
            }
            return false;
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[TestSupportSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[TestSupportSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(10000000, "[TestSupportSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(10000000, "[TestSupportSMM.java#checkGuard] checking: '%1'", (Object)string);
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

