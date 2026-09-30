/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class InfoSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected InfoSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{7, 3, 0, 593, 593, 593, 593, 593, 265, 14, 271, 1, 6, 14, 15, 6, 3, 83, 7};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{500011, -10, 500001, 500011, 500010, 500018, 500017, 500000, -10, 500008, -10, 500010, 500011, 500010, -1, 500016, -1, 500014, 500014};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, 500003, -1, -1, 500004, 500005, -1, 500006, -1, 500006, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[19][];
        int[][] nArrayArray2 = new int[19][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[1] = new int[]{1};
        nArray2[1] = new int[]{500000};
        nArray[3] = new int[]{1, 2, 1741, 1742, 500005};
        nArray2[3] = new int[]{500007, 500008, 500006, 500006, 500023};
        nArray[4] = new int[]{1, 2, 100028};
        nArray2[4] = new int[]{500024, 500025, 500026};
        nArray[5] = new int[]{1, 2, 1741, 1742};
        nArray2[5] = new int[]{500029, 500030, 500031, 500031};
        nArray[6] = nArray[5];
        nArray2[6] = new int[]{500000, 500014, 500015, 500015};
        nArray[7] = nArray[5];
        nArray2[7] = new int[]{500020, 500021, 500022, 500022};
        nArray[8] = new int[]{2, 1, 500003};
        nArray2[8] = new int[]{500009, 500010, 500018};
        nArray[9] = new int[]{500002};
        nArray2[9] = new int[]{500017};
        nArray[10] = new int[]{2, 1, 400117};
        nArray2[10] = new int[]{500001, 500002, 500003};
        nArray[11] = nArray[1];
        nArray2[11] = new int[]{500004};
        nArray[12] = new int[]{500000, 500004};
        nArray2[12] = new int[]{500005, 500019};
        nArray[13] = new int[]{500007};
        nArray2[13] = new int[]{500027};
        nArray[14] = new int[]{1, 2446, 400587, 500009};
        nArray2[14] = new int[]{500016, 500036, 500028, 500035};
        nArray[15] = new int[]{500001, 1741, 1742};
        nArray2[15] = new int[]{500012, 500011, 500011};
        nArray[16] = nArray[1];
        nArray2[16] = new int[]{500013};
        nArray[18] = new int[]{2, 1750};
        nArray2[18] = new int[]{500032, 500033};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[19][];
        nArrayArray[8] = new int[]{500003};
        nArrayArray[9] = new int[]{500000};
        nArrayArray[10] = new int[]{500001};
        nArrayArray[13] = new int[]{500002};
        nArrayArray[14] = new int[]{500005};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[19][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[19][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[19][];
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

