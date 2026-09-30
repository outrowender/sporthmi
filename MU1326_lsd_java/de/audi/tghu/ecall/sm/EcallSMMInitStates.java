/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class EcallSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EcallSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 0, 0, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 0, 0, 1, 267, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 593, 593, 257, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 593, 8, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-1, -1, 3300029, 3300029, -1, 3300006, -1, 3300029, 3300029, 3300029, 3300029, 3300029, 3300029, 3300029, 3300029, -1, -1, -1, -1, -1, -1, 3300029, 3300029, 3300029, -1, -1, -10, -10, -1, 3300062, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, 3300027, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3300059, -1, 3300004, 3300063, -10, -1, -1, -1, -1, -1, -1, 3300029, -1, -1, -1, 3300029, 3300073, 3300029, 3300027, 3300029, 3300027, 3300029, 3300027, 3300029, 3300027, 3300029, 3300027, 3300029, 3300029, 3300029, 3300029, 3300029, 3300029, 3300029, 3300029, 3300029, 3300027, 3300029, 3300027, 3300029, 3300029, 3300027};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, 3300002, 3300001, -1, 3300017, -1, 3300003, 3300010, 3300009, 3300007, 3300005, 3300008, 3300011, 3300022, -1, -1, -1, -1, -1, -1, 3300031, 3300037, 3300032, -1, -1, -1, -1, -1, -1, 3300002, 3300003, 3300031, 3300037, 3300010, 3300009, 3300007, 3300005, 3300008, 3300011, 3300001, 3300032, 3300022, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2300070, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3300045, -1, -1, -1, -1, -1, 3300035, 3300035, 3300020, 3300020, 3300019, 3300019, 3300036, 3300036, 3300029, 3300018, 3300043, 3300039, 3300038, 3300044, 3300041, 3300018, 3300042, 3300040, 3300025, 3300025, 3300024, 3300024, 3300046, 3300021, 3300021};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[100][];
        int[][] nArrayArray2 = new int[100][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[4] = new int[]{1};
        nArray2[4] = new int[]{3300049};
        nArray[5] = new int[]{3300001, 3300000};
        nArray2[5] = new int[]{3300003, 3300004};
        nArray[6] = new int[]{1, 1741, 1742};
        nArray2[6] = new int[]{3300005, 3300006, 3300006};
        nArray[7] = new int[]{1741, 1742};
        nArray2[7] = new int[]{3300010, 3300010};
        nArray[27] = new int[]{2, 1, 1741, 1742, 1485, 3300005, 3300002};
        nArray2[27] = new int[]{3300013, 3300014, 3300015, 3300015, 3300016, 3300046, 3300017};
        nArray[29] = new int[]{1, 3300004, 3300005, 3300002};
        nArray2[29] = new int[]{3300020, 3300037, 3300047, 3300007};
        nArray[31] = nArray[7];
        nArray2[31] = new int[]{3300021, 3300021};
        nArray[58] = new int[]{1741, 1742, 3300005};
        nArray2[58] = new int[]{3300045, 3300045, 3300048};
        nArray[59] = nArray[4];
        nArray2[59] = new int[]{3300044};
        nArray[60] = new int[]{1, 2};
        nArray2[60] = new int[]{3300050, 3300051};
        nArray[61] = nArray[60];
        nArray2[61] = new int[]{3300052, 3300053};
        nArray[62] = new int[]{2, 1, 1485, 1483, 1741, 1742};
        nArray2[62] = new int[]{3300054, 3300001, 3300022, 3300023, 3300002, 3300002};
        nArray[63] = nArray[4];
        nArray2[63] = new int[]{3300055};
        nArray[73] = new int[]{2, 1495};
        nArray2[73] = new int[]{3300042, 3300056};
        nArray[74] = new int[]{1, 2, 1507};
        nArray2[74] = new int[]{3300057, 3300058, 3300059};
        nArray[83] = new int[]{3300003};
        nArray2[83] = new int[]{3300029};
        nArray[93] = nArray[83];
        nArray2[93] = new int[]{3300060};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[100][];
        nArrayArray[13] = new int[]{3300014};
        nArrayArray[21] = new int[]{3300012};
        nArrayArray[22] = new int[]{3300013};
        nArrayArray[23] = new int[]{3300015};
        nArrayArray[27] = new int[]{3300001};
        nArrayArray[29] = new int[]{3300000};
        nArrayArray[73] = new int[]{3300011};
        nArrayArray[75] = new int[]{3300016};
        nArrayArray[81] = new int[]{3300017};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[100][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[100][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[100][];
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

