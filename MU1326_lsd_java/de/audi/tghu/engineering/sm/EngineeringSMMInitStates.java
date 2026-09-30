/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class EngineeringSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EngineeringSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{2, 7, 0, 0, 0, 593, 0, 0, 0, 9, 0, 0, 0, 1, 1, 1, 6, 0, 0, 0, 0, 0, 9, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{1300001, -10, 1300001, 1300001, 1300001, 1300001, 1300001, 1300009, 1300009, 1300031, 1300009, 1300009, 1300031, 1300001, 1300001, 1300014, 1300014, 1300015, 1300015, 1300031, 1300013, 1300013, 1300013, 1300022, 1300022, 1300014, 1300025, 1300025, 1300025, 1300025, 1300025, 1300001, 1300034, 1300001, 1300031, 1300034};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{1300001, -1, 1300004, 1300005, 1300003, -1, 1300002, 1300011, 1300009, -1, 1300008, 1300010, 1300007, -1, -1, -1, 1300012, 1300014, 1300013, 1300011, 1300018, 1300006, -1, 1300019, 1300020, -1, 1300022, 1300023, 1300024, 1300021, 1300025, -1, 1300026, 1300027, -1, 1300029};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[36][];
        int[][] nArrayArray2 = new int[36][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[1] = new int[]{1};
        nArray2[1] = new int[]{1300000};
        nArray[2] = new int[]{1300003, 1741, 1742};
        nArray2[2] = new int[]{1300010, 1300011, 1300011};
        nArray[3] = new int[]{1741, 1742, 1300008, 1300005, 1300006, 1300004};
        nArray2[3] = new int[]{1300001, 1300001, 1300012, 1300013, 1300014, 1300034};
        nArray[4] = new int[]{1300002, 1741, 1742, 1300001};
        nArray2[4] = new int[]{1300002, 1300003, 1300003, 1300028};
        nArray[5] = new int[]{1, 2, 1741, 1742};
        nArray2[5] = new int[]{1300004, 1300005, 1300006, 1300006};
        nArray[6] = new int[]{1700002, 1300031, 1741, 1742, 1300000, 1300007};
        nArray2[6] = new int[]{1300007, 1300062, 1300008, 1300008, 1300009, 1300015};
        nArray[7] = new int[]{1741, 1742};
        nArray2[7] = new int[]{1300016, 1300016};
        nArray[9] = new int[]{1300013, 1300012, 1300010, 1300011};
        nArray2[9] = new int[]{1300019, 1300020, 1300021, 1300022};
        nArray[10] = nArray[7];
        nArray2[10] = new int[]{1300023, 1300023};
        nArray[11] = new int[]{1300014};
        nArray2[11] = new int[]{1300024};
        nArray[12] = nArray[7];
        nArray2[12] = new int[]{1300060, 1300060};
        nArray[13] = new int[]{1, 2};
        nArray2[13] = new int[]{1300036, 1300027};
        nArray[14] = new int[]{1, 1741, 1742};
        nArray2[14] = new int[]{1300029, 1300030, 1300030};
        nArray[15] = nArray[7];
        nArray2[15] = new int[]{1300031, 1300031};
        nArray[16] = new int[]{1300015, 1300025, 1300016};
        nArray2[16] = new int[]{1300032, 1300048, 1300033};
        nArray[20] = new int[]{1300021, 1300020, 1741, 1742};
        nArray2[20] = new int[]{1300037, 1300038, 1300039, 1300039};
        nArray[21] = new int[]{1741, 1742, 1300018, 1300019};
        nArray2[21] = new int[]{1300040, 1300040, 1300041, 1300042};
        nArray[22] = new int[]{2, 1300022, 1300023};
        nArray2[22] = new int[]{1300043, 1300044, 1300045};
        nArray[24] = new int[]{1741, 1742, 1300024};
        nArray2[24] = new int[]{1300046, 1300046, 1300047};
        nArray[25] = nArray[14];
        nArray2[25] = new int[]{1300049, 1300050, 1300050};
        nArray[26] = new int[]{1300027, 1300029, 1741, 1742};
        nArray2[26] = new int[]{1300051, 1300052, 1300053, 1300053};
        nArray[27] = nArray[7];
        nArray2[27] = new int[]{1300054, 1300054};
        nArray[28] = nArray[7];
        nArray2[28] = new int[]{1300055, 1300055};
        nArray[29] = new int[]{1300028, 1300026};
        nArray2[29] = new int[]{1300056, 1300057};
        nArray[30] = nArray[7];
        nArray2[30] = new int[]{1300058, 1300058};
        nArray[31] = new int[]{2, 1741, 1742};
        nArray2[31] = new int[]{1300018, 1300059, 1300059};
        nArray[33] = nArray[7];
        nArray2[33] = new int[]{1300063, 1300063};
        nArray[34] = new int[]{1, 1300030};
        nArray2[34] = new int[]{1300064, 1300061};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[36][];
        nArrayArray[9] = new int[]{1300000};
        nArrayArray[22] = new int[]{1300001};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[36][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[36][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[36][];
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

