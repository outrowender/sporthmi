/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

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
        int[] nArray = new int[]{-1, -1, -1118162432, -1118162432, -1, -1504038400, -1, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1, -1, -1, -1, -1, -1, -1118162432, -1118162432, -1118162432, -1, -1, -10, -10, -1, -564514304, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1151716864, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -614845952, -1, -1537592832, -547737088, -10, -1, -1, -1, -1, -1, -1, -1118162432, -1, -1, -1, -1118162432, -379964928, -1118162432, -1151716864, -1118162432, -1151716864, -1118162432, -1151716864, -1118162432, -1151716864, -1118162432, -1151716864, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1118162432, -1151716864, -1118162432, -1151716864, -1118162432, -1118162432, -1151716864};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1571147264, -1587924480, -1, -1319489024, -1, -1554370048, -1436929536, -1453706752, -1487261184, -1520815616, -1470483968, -1420152320, -1235602944, -1, -1, -1, -1, -1, -1, -1084608000, -983944704, -1067830784, -1, -1, -1, -1, -1, -1, -1571147264, -1554370048, -1084608000, -983944704, -1436929536, -1453706752, -1487261184, -1520815616, -1470483968, -1420152320, -1587924480, -1067830784, -1235602944, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1508367616, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -849726976, -1, -1, -1, -1, -1, -1017499136, -1017499136, -1269157376, -1269157376, -1285934592, -1285934592, -1000721920, -1000721920, -1118162432, -1302711808, -883281408, -950390272, -967167488, -866504192, -916835840, -1302711808, -900058624, -933613056, -1185271296, -1185271296, -1202048512, -1202048512, -832949760, -1252380160, -1252380160};
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
        nArray2[4] = new int[]{-782618112};
        nArray[5] = new int[]{-1587924480, -1604701696};
        nArray2[5] = new int[]{-1554370048, -1537592832};
        nArray[6] = new int[]{1, 1741, 1742};
        nArray2[6] = new int[]{-1520815616, -1504038400, -1504038400};
        nArray[7] = new int[]{1741, 1742};
        nArray2[7] = new int[]{-1436929536, -1436929536};
        nArray[27] = new int[]{2, 1, 1741, 1742, 1485, -1520815616, -1571147264};
        nArray2[27] = new int[]{-1386597888, -1369820672, -1353043456, -1353043456, -1336266240, -832949760, -1319489024};
        nArray[29] = new int[]{1, -1537592832, -1520815616, -1571147264};
        nArray2[29] = new int[]{-1269157376, -983944704, -816172544, -1487261184};
        nArray[31] = nArray[7];
        nArray2[31] = new int[]{-1252380160, -1252380160};
        nArray[58] = new int[]{1741, 1742, -1520815616};
        nArray2[58] = new int[]{-849726976, -849726976, -799395328};
        nArray[59] = nArray[4];
        nArray2[59] = new int[]{-866504192};
        nArray[60] = new int[]{1, 2};
        nArray2[60] = new int[]{-765840896, -749063680};
        nArray[61] = nArray[60];
        nArray2[61] = new int[]{-732286464, -715509248};
        nArray[62] = new int[]{2, 1, 1485, 1483, 1741, 1742};
        nArray2[62] = new int[]{-698732032, -1587924480, -1235602944, -1218825728, -1571147264, -1571147264};
        nArray[63] = nArray[4];
        nArray2[63] = new int[]{-681954816};
        nArray[73] = new int[]{2, 1495};
        nArray2[73] = new int[]{-900058624, -665177600};
        nArray[74] = new int[]{1, 2, 1507};
        nArray2[74] = new int[]{-648400384, -631623168, -614845952};
        nArray[83] = new int[]{-1554370048};
        nArray2[83] = new int[]{-1118162432};
        nArray[93] = nArray[83];
        nArray2[93] = new int[]{-598068736};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[100][];
        nArrayArray[13] = new int[]{-1369820672};
        nArrayArray[21] = new int[]{-1403375104};
        nArrayArray[22] = new int[]{-1386597888};
        nArrayArray[23] = new int[]{-1353043456};
        nArrayArray[27] = new int[]{-1587924480};
        nArrayArray[29] = new int[]{-1604701696};
        nArrayArray[73] = new int[]{-1420152320};
        nArrayArray[75] = new int[]{-1336266240};
        nArrayArray[81] = new int[]{-1319489024};
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

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

