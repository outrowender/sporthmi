/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.wirelesscharging.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

public class WirelessChargingSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected WirelessChargingSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 0, 3, 0, 3};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-10, 1122054912, -1, 1155609344, -1};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, 1105277696, -1, 1122054912, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[5][];
        int[][] nArrayArray2 = new int[5][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[1] = new int[]{1088500480};
        nArray2[1] = new int[]{1088500480};
        nArray[2] = new int[]{1, 1741, 1742};
        nArray2[2] = new int[]{1105277696, 1122054912, 1122054912};
        nArray[4] = nArray[2];
        nArray2[4] = new int[]{1138832128, 1155609344, 1155609344};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[5][];
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[5][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[5][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[5][];
        this.smm.setStateSyncTargetList(nArrayArray);
    }

    private void initSyncTargets() {
        SMSyncTarget[] sMSyncTargetArray = new SMSyncTarget[1];
        this.smm.setSyncTargetList(sMSyncTargetArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

