/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

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
        int[] nArray = new int[]{81014784, -10, 97792000, 97792000, 164900864, 164900864, 81014784, 181678080, 181678080, 30683136, 30683136, 215232512, 30683136, 81014784, 81014784};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{13905920, -1, 47460352, 64237568, -1, -1, 81014784, 114569216, -1, -1, -1, 164900864, -1, 181678080, 198455296};
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
        nArray[1] = new int[]{1, 164900864, 148123648};
        nArray2[1] = new int[]{13905920, 366227456, 315895808};
        nArray[2] = new int[]{47460352};
        nArray2[2] = new int[]{47460352};
        nArray[3] = new int[]{81014784};
        nArray2[3] = new int[]{64237568};
        nArray[4] = new int[]{1, 1741, 1742, 97792000};
        nArray2[4] = new int[]{81014784, 383004672, 383004672, 131346432};
        nArray[5] = new int[]{1};
        nArray2[5] = new int[]{97792000};
        nArray[7] = new int[]{131346432};
        nArray2[7] = new int[]{164900864};
        nArray[8] = new int[]{1, 2, 1507, 1741, 1742};
        nArray2[8] = new int[]{181678080, 198455296, 215232512, 232009728, 232009728};
        nArray[9] = nArray[5];
        nArray2[9] = new int[]{248786944};
        nArray[10] = new int[]{1, 2, 1644};
        nArray2[10] = new int[]{265564160, 282341376, 299118592};
        nArray[12] = new int[]{1, 1741, 1742};
        nArray2[12] = new int[]{332673024, 349450240, 349450240};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[15][];
        nArrayArray[1] = new int[]{13905920, 114569216, 97792000, 131346432};
        nArrayArray[4] = new int[]{47460352};
        nArrayArray[5] = new int[]{64237568};
        nArrayArray[10] = new int[]{81014784};
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

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

