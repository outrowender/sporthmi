/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.testsupport.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class TestSupportSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TestSupportSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initStates() {
        this.initStateFlagList();
        this.initStateSuperstateList();
        this.initStateDHSList();
        this.initStateTrigger();
        this.initStateMediatorList();
        this.initStateSyncTriggerList();
        this.initStateSyncExitTriggerList();
        this.initStateSyncTargetList();
        this.initSyncTargets();
    }

    protected void initStateFlagList() {
        int[] nArray = new int[]{3, 0, 0, 0, 0, 0};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-10, 2400000, 2400000, 2400000, 2400000, 2400000};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, 2400000, 2400002, 2400001, 2400003, 2400004};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[6][];
        int[][] nArrayArray2 = new int[6][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[0] = new int[]{1};
        nArray2[0] = new int[]{2400000};
        nArray[1] = new int[]{2400000, 2400002};
        nArray2[1] = new int[]{2400001, 2400005};
        nArray[2] = new int[]{1741, 1742};
        nArray2[2] = new int[]{2400002, 2400002};
        nArray[3] = new int[]{2400001, 1741, 1742};
        nArray2[3] = new int[]{2400003, 2400004, 2400004};
        nArray[4] = new int[]{1741, 1742, 2400001};
        nArray2[4] = new int[]{2400006, 2400006, 2400007};
        nArray[5] = nArray[2];
        nArray2[5] = new int[]{2400008, 2400008};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[6][];
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[6][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[6][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[6][];
        this.smm.setStateSyncTargetList(nArrayArray);
    }

    private void initSyncTargets() {
        SMSyncTarget[] sMSyncTargetArray = new SMSyncTarget[1];
        this.smm.setSyncTargetList(sMSyncTargetArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

