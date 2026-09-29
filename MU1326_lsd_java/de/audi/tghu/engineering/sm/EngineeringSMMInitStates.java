/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

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
        int[] nArray = new int[]{567677696, -10, 567677696, 567677696, 567677696, 567677696, 567677696, 701895424, 701895424, 1070994176, 701895424, 701895424, 1070994176, 567677696, 567677696, 785781504, 785781504, 802558720, 802558720, 1070994176, 769004288, 769004288, 769004288, 919999232, 919999232, 785781504, 970330880, 970330880, 970330880, 970330880, 970330880, 567677696, 1121325824, 567677696, 1070994176, 1121325824};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{567677696, -1, 618009344, 634786560, 601232128, -1, 584454912, 735449856, 701895424, -1, 685118208, 718672640, 668340992, -1, -1, -1, 752227072, 785781504, 769004288, 735449856, 852890368, 651563776, -1, 869667584, 886444800, -1, 919999232, 936776448, 953553664, 903222016, 970330880, -1, 987108096, 1003885312, -1, 1037439744};
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
        nArray2[1] = new int[]{550900480};
        nArray[2] = new int[]{601232128, 1741, 1742};
        nArray2[2] = new int[]{718672640, 735449856, 735449856};
        nArray[3] = new int[]{1741, 1742, 685118208, 634786560, 651563776, 618009344};
        nArray2[3] = new int[]{567677696, 567677696, 752227072, 769004288, 785781504, 1121325824};
        nArray[4] = new int[]{584454912, 1741, 1742, 567677696};
        nArray2[4] = new int[]{584454912, 601232128, 601232128, 1020662528};
        nArray[5] = new int[]{1, 2, 1741, 1742};
        nArray2[5] = new int[]{618009344, 634786560, 651563776, 651563776};
        nArray[6] = new int[]{-1561323264, 1070994176, 1741, 1742, 550900480, 668340992};
        nArray2[6] = new int[]{668340992, 1591087872, 685118208, 685118208, 701895424, 802558720};
        nArray[7] = new int[]{1741, 1742};
        nArray2[7] = new int[]{819335936, 819335936};
        nArray[9] = new int[]{769004288, 752227072, 718672640, 735449856};
        nArray2[9] = new int[]{869667584, 886444800, 903222016, 919999232};
        nArray[10] = nArray[7];
        nArray2[10] = new int[]{936776448, 936776448};
        nArray[11] = new int[]{785781504};
        nArray2[11] = new int[]{953553664};
        nArray[12] = nArray[7];
        nArray2[12] = new int[]{1557533440, 1557533440};
        nArray[13] = new int[]{1, 2};
        nArray2[13] = new int[]{1154880256, 1003885312};
        nArray[14] = new int[]{1, 1741, 1742};
        nArray2[14] = new int[]{1037439744, 1054216960, 1054216960};
        nArray[15] = nArray[7];
        nArray2[15] = new int[]{1070994176, 1070994176};
        nArray[16] = new int[]{802558720, 970330880, 819335936};
        nArray2[16] = new int[]{1087771392, 1356206848, 1104548608};
        nArray[20] = new int[]{903222016, 886444800, 1741, 1742};
        nArray2[20] = new int[]{1171657472, 1188434688, 1205211904, 1205211904};
        nArray[21] = new int[]{1741, 1742, 852890368, 869667584};
        nArray2[21] = new int[]{1221989120, 1221989120, 1238766336, 1255543552};
        nArray[22] = new int[]{2, 919999232, 936776448};
        nArray2[22] = new int[]{1272320768, 1289097984, 1305875200};
        nArray[24] = new int[]{1741, 1742, 953553664};
        nArray2[24] = new int[]{1322652416, 1322652416, 1339429632};
        nArray[25] = nArray[14];
        nArray2[25] = new int[]{1372984064, 1389761280, 1389761280};
        nArray[26] = new int[]{1003885312, 1037439744, 1741, 1742};
        nArray2[26] = new int[]{1406538496, 1423315712, 1440092928, 1440092928};
        nArray[27] = nArray[7];
        nArray2[27] = new int[]{1456870144, 1456870144};
        nArray[28] = nArray[7];
        nArray2[28] = new int[]{1473647360, 1473647360};
        nArray[29] = new int[]{1020662528, 987108096};
        nArray2[29] = new int[]{1490424576, 1507201792};
        nArray[30] = nArray[7];
        nArray2[30] = new int[]{1523979008, 1523979008};
        nArray[31] = new int[]{2, 1741, 1742};
        nArray2[31] = new int[]{852890368, 1540756224, 1540756224};
        nArray[33] = nArray[7];
        nArray2[33] = new int[]{1607865088, 1607865088};
        nArray[34] = new int[]{1, 1054216960};
        nArray2[34] = new int[]{1624642304, 1574310656};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[36][];
        nArrayArray[9] = new int[]{550900480};
        nArrayArray[22] = new int[]{567677696};
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

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

