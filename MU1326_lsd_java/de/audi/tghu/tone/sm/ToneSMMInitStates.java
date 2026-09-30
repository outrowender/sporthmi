/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class ToneSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected ToneSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 87, 0, 593, 11, 2, 14, 6, 261, 6, 0, 8, 6, 0, 0, 0, 0, 0, 0, 6, 6, 2, 0, 2, 2, 2, 8, 6, 0, 1030, 1030, 6, 1030, 0, 1, 0, 0, 593, 593, 593, 267, 267, 267, 1, 11, 11, 0, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 9, 0, 9, 0, 9, 6, 1, 9, 593, 265, 593, 265, 9, 2, 11, 0, 0, 6, 9, 6, 593, 265, 9, 593, 265, 9, 0, 9, 9, 6, 9, 4};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-1, -10, -1, 1000066, 1000008, 1000048, 1000008, 1000072, -10, 1000052, -1, 1000067, 1000053, -1, -1, -1, -1, -1, 1000045, 1000069, 1000047, 1000050, 1000049, 1000051, 1000055, 1000062, 1000040, 1000056, 1000042, 1000057, 1000058, 1000084, 1000060, -1, 1000042, -1, -1, 1000043, 1000043, 1000043, -10, -10, -10, 1000008, 1000043, 1000043, -1, 1000004, 1000004, 1000004, 1000004, 1000004, 1000043, 1000041, 1000044, 1000004, 1000040, 1000087, 1000087, -1, 1000087, -1, 1000004, 1000054, 1000004, 1000064, 1000001, 1000041, 1000045, -10, 1000043, -10, 1000090, 1000090, 1000043, 1000074, -1, 1000081, 1000041, 1000085, 1000082, -10, 1000074, 1000034, -10, 1000078, 1000078, 1000034, 1000043, 1000088, 1000071, 1000090};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, 1000066, -1, -1, -1, 1000008, 1000005, 1000015, -1, 1000034, -1, 1000020, 1000045, -1, -1, -1, -1, -1, 1000017, 1000016, 1000012, 1000014, 1000006, 1000011, 1000010, 1000009, 1000018, 1000019, 1000023, 1000027, 1000025, 1000026, 1000024, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1000028, -1, 1000046, -1, -1, -1, -1, -1, -1, -1, 1000067, -1, 1000068, -1, 1000069, -1, 1000070, -1, -1, -1, -1, -1, -1, 1000072, -1, -1, 1000073, -1, 1000015};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[92][];
        int[][] nArrayArray2 = new int[92][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[1] = new int[]{1, 2};
        nArray2[1] = new int[]{1000000, 1000001};
        nArray[3] = nArray[1];
        nArray2[3] = new int[]{1000005, 1000006};
        nArray[4] = new int[]{1741, 1742, 1000083, 1000044};
        nArray2[4] = new int[]{1000007, 1000007, 1000152, 1000105};
        nArray[6] = new int[]{1000012, 1000008, 1000011, 1000013, 1000010, 1000009, 1000048, 1000052};
        nArray2[6] = new int[]{1000011, 1000008, 1000012, 1000013, 1000014, 1000015, 1000109, 1000117};
        nArray[8] = new int[]{2, 1, 1000030, 1000006, 1000001, 1000007, 1000005, 1000000, 1000002, 1000004, 1741, 1742, 1000089, 1000157, 1000081, 1000059, 1000056, 1000039};
        nArray2[8] = new int[]{1000009, 1000010, 1000016, 1000017, 1000002, 1000018, 1000019, 1000003, 1000020, 1000021, 1000004, 1000004, 1000180, 1000185, 1000147, 1000132, 1000127, 1000051};
        nArray[11] = new int[]{1000042, 1000054};
        nArray2[11] = new int[]{1000070, 1000118};
        nArray[18] = new int[]{1000015};
        nArray2[18] = new int[]{1000024};
        nArray[26] = new int[]{1000016, 1741, 1742, 1000053};
        nArray2[26] = new int[]{1000028, 1000065, 1000065, 1000119};
        nArray[28] = new int[]{1000021, 1000018, 1000019, 1000020};
        nArray2[28] = new int[]{1000030, 1000031, 1000032, 1000033};
        nArray[34] = new int[]{1741, 1742, 1000055, 1000047};
        nArray2[34] = new int[]{1000035, 1000035, 1000122, 1000106};
        nArray[37] = nArray[1];
        nArray2[37] = new int[]{1000053, 1000054};
        nArray[38] = nArray[1];
        nArray2[38] = new int[]{1000055, 1000056};
        nArray[39] = nArray[1];
        nArray2[39] = new int[]{1000057, 1000058};
        nArray[40] = new int[]{2, 1, 1000059};
        nArray2[40] = new int[]{1000059, 1000060, 1000153};
        nArray[41] = new int[]{2, 1, 1741, 1742, 1000059};
        nArray2[41] = new int[]{1000061, 1000062, 1000066, 1000066, 1000157};
        nArray[42] = new int[]{2, 1, 1741, 1742, 1000051, 1000059};
        nArray2[42] = new int[]{1000063, 1000064, 1000067, 1000067, 1000116, 1000158};
        nArray[43] = new int[]{2, 1741, 1742, 1000059};
        nArray2[43] = new int[]{1000068, 1000069, 1000069, 1000154};
        nArray[45] = new int[]{1000087};
        nArray2[45] = new int[]{1000168};
        nArray[47] = new int[]{1, 1000043};
        nArray2[47] = new int[]{1000073, 1000074};
        nArray[48] = nArray[47];
        nArray2[48] = new int[]{1000075, 1000076};
        nArray[49] = new int[]{1, 1000014, 1000043};
        nArray2[49] = new int[]{1000077, 1000027, 1000078};
        nArray[50] = new int[]{1, 1741, 1742, 1000045, 1000043};
        nArray2[50] = new int[]{1000079, 1000026, 1000026, 1000108, 1000080};
        nArray[51] = nArray[47];
        nArray2[51] = new int[]{1000081, 1000082};
        nArray[52] = nArray[47];
        nArray2[52] = new int[]{1000083, 1000084};
        nArray[53] = new int[]{1, 1741, 1742, 1000057, 1000043};
        nArray2[53] = new int[]{1000085, 1000034, 1000034, 1000126, 1000086};
        nArray[54] = new int[]{1, 1000086, 1000043};
        nArray2[54] = new int[]{1000087, 1000167, 1000088};
        nArray[55] = nArray[47];
        nArray2[55] = new int[]{1000089, 1000090};
        nArray[56] = new int[]{1, 1741, 1742, 1000050, 1000043, 1000058};
        nArray2[56] = new int[]{1000091, 1000029, 1000029, 1000114, 1000092, 1000128};
        nArray[57] = new int[]{1, 1000022, 1000034, 1000043};
        nArray2[57] = new int[]{1000093, 1000045, 1000046, 1000094};
        nArray[58] = nArray[47];
        nArray2[58] = new int[]{1000095, 1000096};
        nArray[60] = nArray[47];
        nArray2[60] = new int[]{1000099, 1000100};
        nArray[62] = nArray[47];
        nArray2[62] = new int[]{1000103, 1000104};
        nArray[64] = nArray[47];
        nArray2[64] = new int[]{1000110, 1000111};
        nArray[66] = new int[]{1};
        nArray2[66] = new int[]{1000115};
        nArray[67] = new int[]{1, 1000016, 1000084, 1000043};
        nArray2[67] = new int[]{1000120, 1000023, 1000159, 1000121};
        nArray[68] = nArray[1];
        nArray2[68] = new int[]{1000123, 1000124};
        nArray[69] = new int[]{2, 1, 1741, 1742, 1000043, 1000059};
        nArray2[69] = new int[]{1000125, 1000071, 1000025, 1000025, 1000072, 1000155};
        nArray[70] = nArray[1];
        nArray2[70] = new int[]{1000142, 1000143};
        nArray[71] = new int[]{2, 1, 1000085, 1000059, 1000145};
        nArray2[71] = new int[]{1000144, 1000101, 1000166, 1000156, 1000184};
        nArray[72] = nArray[47];
        nArray2[72] = new int[]{1000146, 1000102};
        nArray[75] = new int[]{1000082};
        nArray2[75] = new int[]{1000148};
        nArray[78] = new int[]{1, 2, 1000059, 1741, 1742, 1000079};
        nArray2[78] = new int[]{1000175, 1000176, 1000177, 1000160, 1000160, 1000178};
        nArray[80] = nArray[1];
        nArray2[80] = new int[]{1000163, 1000169};
        nArray[81] = new int[]{2, 1, 1741, 1742, 1000043};
        nArray2[81] = new int[]{1000164, 1000149, 1000165, 1000165, 1000151};
        nArray[82] = new int[]{1, 2, 1000079};
        nArray2[82] = new int[]{1000170, 1000150, 1000171};
        nArray[83] = nArray[1];
        nArray2[83] = new int[]{1000172, 1000173};
        nArray[84] = new int[]{2, 1, 1000043};
        nArray2[84] = new int[]{1000174, 1000097, 1000098};
        nArray[85] = nArray[47];
        nArray2[85] = new int[]{1000161, 1000162};
        nArray[88] = nArray[47];
        nArray2[88] = new int[]{1000181, 1000182};
        nArray[90] = new int[]{1, 1000079};
        nArray2[90] = new int[]{1000183, 1000145};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[92][];
        nArrayArray[4] = new int[]{1000067, 1000047};
        nArrayArray[6] = new int[]{1000029};
        nArrayArray[11] = new int[]{1000003, 1000028};
        nArrayArray[26] = new int[]{1000030};
        nArrayArray[40] = new int[]{1000068};
        nArrayArray[41] = new int[]{1000073};
        nArrayArray[42] = new int[]{1000086, 1000087, 1000027, 1000075};
        nArrayArray[44] = new int[]{1000074};
        nArrayArray[45] = new int[]{1000079};
        nArrayArray[47] = new int[]{1000010, 1000036};
        nArrayArray[48] = new int[]{1000020, 1000037};
        nArrayArray[49] = new int[]{1000038, 1000011};
        nArrayArray[50] = new int[]{1000021, 1000008, 1000039};
        nArrayArray[51] = new int[]{1000040, 1000006};
        nArrayArray[52] = new int[]{1000072, 1000049, 1000014};
        nArrayArray[53] = new int[]{1000035, 1000013};
        nArrayArray[54] = new int[]{1000078, 1000019, 1000052};
        nArrayArray[55] = new int[]{1000009, 1000041, 1000022};
        nArrayArray[56] = new int[]{1000005, 1000042, 1000026};
        nArrayArray[57] = new int[]{1000015};
        nArrayArray[58] = new int[]{1000016};
        nArrayArray[60] = new int[]{1000017};
        nArrayArray[62] = new int[]{1000007, 1000043};
        nArrayArray[64] = new int[]{1000025};
        nArrayArray[67] = new int[]{1000031};
        nArrayArray[69] = new int[]{1000004, 1000069, 1000051};
        nArrayArray[71] = new int[]{1000070, 1000050};
        nArrayArray[72] = new int[]{1000062};
        nArrayArray[74] = new int[]{1000088, 1000071};
        nArrayArray[78] = new int[]{1000082, 1000081, 1000077};
        nArrayArray[81] = new int[]{1000065, 1000066};
        nArrayArray[82] = new int[]{1000080};
        nArrayArray[84] = new int[]{1000053, 1000018, 1000024};
        nArrayArray[85] = new int[]{1000076};
        nArrayArray[87] = new int[]{1000033};
        nArrayArray[88] = new int[]{1000083, 1000085, 1000084};
        nArrayArray[90] = new int[]{1000064};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[92][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[92][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[92][];
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

