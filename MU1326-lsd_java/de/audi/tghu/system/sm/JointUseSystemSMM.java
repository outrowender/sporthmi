/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.AbstractSysSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.SMServices;

public class JointUseSystemSMM
extends AbstractSysSMM {
    private static final int MAX_STATES;
    private static final int STATE_ROOT;
    private static final int STATE_DUMMY_SLOT;
    private static final int STATE_NAVI_SLOT;
    private static final int STATE_SWDL_SLOT;
    private static final int MAX_MEDIATORS;
    private static final int MAX_TRANSITIONS;
    private static final int TRANSITION_ROOT_DEFAULT;
    private static final int TRANSITION_ROOT_NAV;
    private static final int TRANSITION_ROOT_JOINT_DUMMY;
    private static final int TRANSITION_DUMMY_DEFAULT;
    private static final int TRANSITION_NAVI_DEFAULT;
    private static final int TRANSITION_SWDL_DEFAULT;
    private static final int TRANSITION_ROOT_SWDL;
    private static int EXT_STATE_NAVI_TLS;
    private static int EXT_STATE_DUMMY_TLS;
    private static int EXT_STATE_SWDL_TLS;

    public JointUseSystemSMM(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, 5, "rearSeatJoint", 0, 0, "SystemSMM");
    }

    @Override
    protected void init() {
        this.smmSlotList = new int[]{2, 3, 4};
        this.smmSlotModuleIDList = new int[]{23, 4, 17};
        this.reqExtStateLabelList = new String[]{null, "NavigationTLS", "DummyTLS", "SwdlTLS"};
        this.topLevelStateID = 1;
        this.popupIDList = new int[0];
        this.popupPriorityList = new int[0];
        this.popupTopLevelStateIDList = new int[0];
        this.extStateIDList = new int[0];
        this.extStateLabelList = new String[0];
        this.incSlotList = new int[0];
        this.incSlotStateIDList = new int[0];
        this.initStates();
        this.initMediators();
        this.initTransitions();
    }

    private void initStates() {
        this.stateSuperstateList = new int[5];
        this.stateDHSList = new int[5];
        this.stateFlagList = new int[5];
        this.stateTriggerEventList = new int[5][];
        this.stateOutTransList = new int[5][];
        this.stateSuperstateList[0] = -1;
        this.stateDHSList[0] = -1;
        this.stateFlagList[0] = 0;
        this.stateSuperstateList[1] = -1;
        this.stateDHSList[1] = -1;
        this.stateFlagList[1] = 1;
        this.stateTriggerEventList[1] = new int[]{1, -8, -13, 101, 102, 1741, -12, -14};
        this.stateOutTransList[1] = new int[]{1, 2, 3, 3, 3, 3, 7, 3};
        this.stateSuperstateList[2] = 1;
        this.stateDHSList[2] = -1;
        this.stateFlagList[2] = 129;
        this.stateTriggerEventList[2] = new int[]{1};
        this.stateOutTransList[2] = new int[]{4};
        this.stateSuperstateList[3] = 1;
        this.stateDHSList[3] = -1;
        this.stateFlagList[3] = 129;
        this.stateTriggerEventList[3] = new int[]{1};
        this.stateOutTransList[3] = new int[]{5};
        this.stateSuperstateList[4] = 1;
        this.stateDHSList[4] = -1;
        this.stateFlagList[4] = 129;
        this.stateTriggerEventList[4] = new int[]{1};
        this.stateOutTransList[4] = new int[]{6};
    }

    private void initTransitions() {
        this.transFlagList = new int[8];
        this.transTrgtFlagList = new int[8][];
        this.transTrgtStateList = new int[8][];
        this.transFlagList[0] = 0;
        this.transFlagList[1] = 0;
        this.transTrgtFlagList[1] = new int[0];
        this.transTrgtStateList[1] = new int[]{2};
        this.transFlagList[2] = 0;
        this.transTrgtFlagList[2] = new int[0];
        this.transTrgtStateList[2] = new int[]{3};
        this.transFlagList[3] = 4;
        this.transTrgtFlagList[3] = new int[0];
        this.transTrgtStateList[3] = new int[]{2};
        this.transFlagList[4] = 1;
        this.transTrgtFlagList[4] = new int[0];
        this.transTrgtStateList[4] = new int[]{EXT_STATE_DUMMY_TLS};
        this.transFlagList[5] = 1;
        this.transTrgtFlagList[5] = new int[0];
        this.transTrgtStateList[5] = new int[]{EXT_STATE_NAVI_TLS};
        this.transFlagList[6] = 1;
        this.transTrgtFlagList[6] = new int[0];
        this.transTrgtStateList[6] = new int[]{EXT_STATE_SWDL_TLS};
        this.transFlagList[7] = 0;
        this.transTrgtFlagList[7] = new int[0];
        this.transTrgtStateList[7] = new int[]{4};
    }

    private void initMediators() {
        this.mediatorList = new EventMediator[0];
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        throw new UnsupportedOperationException(new StringBuffer().append(super.getClass().getName()).append(" does not support method checkGuard(int,int)").toString());
    }

    @Override
    public boolean checkGuard(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 3: {
                return sMServices.getJointUseCount() == 0;
            }
        }
        return true;
    }

    @Override
    public void execEnteredAction(SMServices sMServices, int n) {
    }

    @Override
    public void execEnterAction(SMServices sMServices, int n) {
    }

    @Override
    public void execExitAction(SMServices sMServices, int n) {
    }

    @Override
    public void execTransitionAction(SMServices sMServices, int n, int n2) {
    }

    static {
        EXT_STATE_NAVI_TLS = -1;
        EXT_STATE_DUMMY_TLS = -2;
        EXT_STATE_SWDL_TLS = -3;
    }
}

