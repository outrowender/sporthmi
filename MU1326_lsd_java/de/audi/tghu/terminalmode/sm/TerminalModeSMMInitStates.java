/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class TerminalModeSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TerminalModeSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 15, 0, 0, 3087, 13, 0, 0, 593, 1, 11, 0, 1, 0, 0};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{3200004, -10, 3200005, 3200005, 3200009, 3200009, 3200004, 3200010, 3200010, 3200001, 3200001, 3200012, 3200001, 3200004, 3200004};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{3200000, -1, 3200002, 3200003, -1, -1, 3200004, 3200006, -1, -1, -1, 3200009, -1, 3200010, 3200011};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[15][];
        int[][] nArrayArray2 = new int[15][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[1] = new int[]{1, 3200009, 3200008};
        nArray2[1] = new int[]{3200000, 3200021, 3200018};
        nArray[2] = new int[]{3200002};
        nArray2[2] = new int[]{3200002};
        nArray[3] = new int[]{3200004};
        nArray2[3] = new int[]{3200003};
        nArray[4] = new int[]{1, 1741, 1742, 3200005};
        nArray2[4] = new int[]{3200004, 3200022, 3200022, 3200007};
        nArray[5] = new int[]{1};
        nArray2[5] = new int[]{3200005};
        nArray[7] = new int[]{3200007};
        nArray2[7] = new int[]{3200009};
        nArray[8] = new int[]{1, 2, 1507, 1741, 1742};
        nArray2[8] = new int[]{3200010, 3200011, 3200012, 3200013, 3200013};
        nArray[9] = nArray[5];
        nArray2[9] = new int[]{3200014};
        nArray[10] = new int[]{1, 2, 1644};
        nArray2[10] = new int[]{3200015, 3200016, 3200017};
        nArray[12] = new int[]{1, 1741, 1742};
        nArray2[12] = new int[]{3200019, 3200020, 3200020};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[15][];
        nArrayArray[1] = new int[]{3200000, 3200006, 3200005, 3200007};
        nArrayArray[4] = new int[]{3200002};
        nArrayArray[5] = new int[]{3200003};
        nArrayArray[10] = new int[]{3200004};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[15][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[15][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[15][];
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

