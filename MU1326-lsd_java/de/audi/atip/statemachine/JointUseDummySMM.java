/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;

public class JointUseDummySMM
extends AbstractAppSMM {
    private static final int STATE_DUMMY;
    private static final int MAX_STATES;
    private static final int MAX_MEDIATORS;
    private static final int MAX_TRANSITIONS;

    public JointUseDummySMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2, String string2, String string3) {
        this(iFrameworkAccess, n, string, 0, n2, string2, string3);
    }

    public JointUseDummySMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2, int n3, String string2, String string3) {
        super(iFrameworkAccess, n, string, n2, n3, string2);
        this.extStateIDList = new int[]{this.topLevelStateID};
        this.extStateLabelList = new String[]{string3};
    }

    private int getIDBase() {
        return this.moduleID * -1601830656;
    }

    @Override
    protected void init() {
        this.topLevelStateID = this.getIDBase() + 1;
        this.popupIDList = new int[0];
        this.popupPriorityList = new int[0];
        this.popupTopLevelStateIDList = new int[0];
        this.incSlotList = new int[0];
        this.incSlotStateIDList = new int[0];
        this.stateSuperstateList = new int[2];
        this.stateDHSList = new int[2];
        this.stateFlagList = new int[2];
        this.stateTriggerEventList = new int[2][];
        this.stateOutTransList = new int[2][];
        this.stateMediatorList = new int[2][];
        this.stateSuperstateList[0] = -1;
        this.stateDHSList[0] = -1;
        this.stateSuperstateList[1] = -10;
        this.stateDHSList[1] = 50;
        this.stateFlagList[1] = 6;
        this.mediatorList = new EventMediator[0];
        this.transFlagList = new int[0];
        this.transTrgtFlagList = new int[0][];
        this.transTrgtStateList = new int[0][];
        this.reqExtStateLabelList = new String[0];
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        return true;
    }

    @Override
    public void execEnteredAction(SMServices sMServices, int n) {
    }

    @Override
    public void execEnterAction(SMServices sMServices, int n) {
        if (n == this.getIDBase() + 1) {
            sMServices.enterJointUse(this.terminalID, this.moduleID);
        }
    }

    @Override
    public void execExitAction(SMServices sMServices, int n) {
        if (n == this.getIDBase() + 1) {
            sMServices.leaveJointUse(this.terminalID, this.moduleID);
        }
    }

    @Override
    public void execTransitionAction(SMServices sMServices, int n, int n2) {
    }

    @Override
    public void execSDForState(TTSASR tTSASR, ITTSASRContext iTTSASRContext, int n) {
    }
}

