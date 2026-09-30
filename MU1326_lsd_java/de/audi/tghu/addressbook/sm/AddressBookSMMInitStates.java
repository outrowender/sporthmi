/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class AddressBookSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected AddressBookSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{95, 0, 0, 0, 1, 8, 0, 0, 0, 8, 0, 13, 14, 14, 0, 0, 0, 0, 3, 0, 0, 0, 593, 0, 3, 0, 2, 0, 0, 1, 8, 1, 0, 8, 0, 9, 8, 8, 1, 0, 8, 0, 7, 7, 593, 593, 0, 3, 0, 0, 0, 345, 593, 0, 0, 0, 593, 9, 0, 593, 593, 593, 593, 0, 0, 0, 0, 0, 593, 0, 0, 593, 6, 9, 265, 7, 593, 593, 593, 593, 593, 593, 593, 0, 0, 0, 0, 3, 593, 0, 7, 3, 7, 3, 15, 593, 0, 593, 0, 593, 593, 593, 0, 593, 593, 15, 265, 0, 593, 593, 593, 593, 593, 15, 0, 593, 8, 593, 593, 7, 81, 265, 593, 593, 593, 15, 593, 0, 9, 9};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-10, -1, -1, -1, 700120, 700004, 700004, -1, -1, 700004, 700011, 700129, 700051, 700051, -1, -1, -1, 700018, -1, -1, -1, -1, 700120, 700024, -1, 700042, 700128, -1, -1, 700129, 700029, 700029, 700031, 700031, -1, 700011, 700035, 700029, 700035, 700038, 700038, -1, 700051, 700000, 700120, 700120, 700047, -1, -1, -1, -1, -10, 700000, -1, -1, -1, 700113, 700051, -1, 700090, 700090, 700090, 700090, -1, -1, -1, -1, -1, 700091, -1, -1, 700093, 700073, 700074, -10, 700074, 700075, 700075, 700075, 700075, 700075, 700075, 700075, -1, -1, -1, 700087, -1, 700092, -1, 700120, 700075, 700073, 700120, 700057, 700057, -1, 700090, -1, 700090, 700090, 700090, -1, 700105, 700105, 700011, -10, 700106, 700090, 700090, 700090, 700090, 700094, 700094, -1, 700121, 700004, 700119, 700073, 700051, 700043, -10, 700000, 700043, 700125, 700051, 700090, -1, 700042, 700004};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{700052, -1, -1, -1, -1, 700006, 700007, -1, -1, 700010, 700011, -1, 700012, 700005, -1, -1, -1, 700015, -1, -1, -1, -1, -1, 700023, -1, 700024, 700025, -1, -1, -1, 700027, -1, 700030, 700029, -1, -1, 700031, 700013, -1, 700032, 700033, -1, -1, -1, -1, -1, 700045, -1, -1, -1, -1, 700012, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 700005, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 700018, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 700059, -1, -1, -1, -1, -1, -1, -1, -1, 700006, -1, -1, -1, 700043, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[130][];
        int[][] nArrayArray2 = new int[130][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[0] = new int[]{1, 700025, 700023, 700002, 700069, 1750, 700050, 700070, 700063, 400295, 700066, 700048, 1917, 1000080, 700047, 700065, 2200072, 2200109, 2200115, 2200078, 300223, 300237, 700054, 700055, 300224, 2200106, 2200094, 2200076, 700060, 2200125, 300239, 2200073, 2200112, 700059, 2200119, 2200126, 2200127, 700071, 700068};
        nArray2[0] = new int[]{700096, 700047, 700042, 700004, 700252, 700171, 700104, 700255, 700159, 700244, 700161, 700110, 700105, 700364, 700099, 700154, 700319, 700322, 700134, 700321, 700301, 700296, 700132, 700133, 700302, 700290, 700291, 700320, 700141, 700287, 700289, 700318, 700323, 700142, 700288, 700143, 700144, 700263, 700245};
        nArray[4] = new int[]{1, 2, 1741, 1742};
        nArray2[4] = new int[]{700005, 700106, 700009, 700009};
        nArray[5] = new int[]{700003, 700011, 700012, 700008, 700010};
        nArray2[5] = new int[]{700007, 700017, 700019, 700029, 700061};
        nArray[6] = new int[]{1741, 1742};
        nArray2[6] = new int[]{700093, 700093};
        nArray[9] = new int[]{1741, 1742, 700019};
        nArray2[9] = new int[]{700027, 700027, 700089};
        nArray[10] = new int[]{700030, 700039};
        nArray2[10] = new int[]{700056, 700074};
        nArray[11] = new int[]{1, 2, 1741, 1742, 700049};
        nArray2[11] = new int[]{700020, 700021, 700022, 700022, 700102};
        nArray[12] = new int[]{400146, 700018, 700017, 700062, 700111};
        nArray2[12] = new int[]{700145, 700034, 700285, 700153, 700390};
        nArray[13] = new int[]{1741, 1742, 400329, 400333, 700095, 2800, 1677};
        nArray2[13] = new int[]{700010, 700010, 700369, 700370, 700356, 700382, 700098};
        nArray[17] = new int[]{700076};
        nArray2[17] = new int[]{700316};
        nArray[18] = new int[]{1};
        nArray2[18] = new int[]{700032};
        nArray[22] = new int[]{1, 2};
        nArray2[22] = new int[]{700040, 700107};
        nArray[23] = nArray[17];
        nArray2[23] = new int[]{700317};
        nArray[24] = nArray[18];
        nArray2[24] = new int[]{700046};
        nArray[29] = nArray[4];
        nArray2[29] = new int[]{700062, 700063, 700064, 700064};
        nArray[30] = new int[]{700033, 700032, 700037, 700035, 700036};
        nArray2[30] = new int[]{700065, 700079, 700068, 700066, 700067};
        nArray[31] = nArray[22];
        nArray2[31] = new int[]{700069, 700070};
        nArray[32] = new int[]{700046, 1741, 1742};
        nArray2[32] = new int[]{700254, 700071, 700071};
        nArray[33] = new int[]{700034, 1741, 1742};
        nArray2[33] = new int[]{700072, 700080, 700080};
        nArray[35] = new int[]{1, 2, 1741, 1742, 700093};
        nArray2[35] = new int[]{700075, 700076, 700077, 700077, 700349};
        nArray[36] = new int[]{700056, 1741, 700092, 700045};
        nArray2[36] = new int[]{700130, 700128, 700350, 700091};
        nArray[37] = new int[]{700057, 700040, 1741, 1742};
        nArray2[37] = new int[]{700131, 700081, 700082, 700082};
        nArray[38] = nArray[22];
        nArray2[38] = new int[]{700083, 700084};
        nArray[39] = nArray[32];
        nArray2[39] = new int[]{700092, 700085, 700085};
        nArray[40] = new int[]{700041};
        nArray2[40] = new int[]{700086};
        nArray[42] = new int[]{1741, 1742, 2800};
        nArray2[42] = new int[]{700103, 700103, 700388};
        nArray[43] = new int[]{2, 1741, 1742, 1000080};
        nArray2[43] = new int[]{700041, 700332, 700332, 700343};
        nArray[44] = nArray[22];
        nArray2[44] = new int[]{700108, 700109};
        nArray[45] = nArray[22];
        nArray2[45] = new int[]{700111, 700112};
        nArray[47] = nArray[18];
        nArray2[47] = new int[]{700113};
        nArray[51] = new int[]{2, 1, 700006, 700044, 700007, 1916, 400332, 700027, 700029, 700021, 700052, 700016, 1750, 700020, 400315, 400316, 700067, 1680, 700005, 700026, 400325, 700063, 700066, 700096, 700073, 700015};
        nArray2[51] = new int[]{700120, 700000, 700012, 700090, 700014, 700055, 700052, 700048, 700054, 700162, 700127, 700100, 700172, 700163, 700156, 700155, 700094, 700125, 700013, 700050, 700371, 700164, 700157, 700362, 700035, 700031};
        nArray[52] = nArray[22];
        nArray2[52] = new int[]{700123, 700119};
        nArray[56] = new int[]{1, 2, 1741, 1742, 1507};
        nArray2[56] = new int[]{700146, 700147, 700148, 700148, 700333};
        nArray[57] = new int[]{1, 2, 700052, 1495};
        nArray2[57] = new int[]{700274, 700149, 700334, 700275};
        nArray[59] = new int[]{1, 2, 2200272};
        nArray2[59] = new int[]{700165, 700299, 700354};
        nArray[60] = nArray[22];
        nArray2[60] = new int[]{700167, 700136};
        nArray[61] = new int[]{1, 2, 2200271};
        nArray2[61] = new int[]{700168, 700352, 700139};
        nArray[62] = nArray[22];
        nArray2[62] = new int[]{700169, 700300};
        nArray[68] = nArray[4];
        nArray2[68] = new int[]{700197, 700198, 700246, 700246};
        nArray[71] = nArray[22];
        nArray2[71] = new int[]{700203, 700248};
        nArray[72] = new int[]{700050, 400329, 700047, 700023, 1916, 700021, 700020, 700054, 2200126, 400333, 700095, 700055, 2200127, 700044};
        nArray2[72] = new int[]{700205, 700264, 700206, 700207, 700208, 700209, 700210, 700211, 700212, 700265, 700357, 700213, 700214, 700215};
        nArray[73] = new int[]{1677, 700063, 400325, 700096};
        nArray2[73] = new int[]{700216, 700217, 700266, 700363};
        nArray[74] = new int[]{2, 1, 700063, 700069, 700060, 700059, 2200119, 1917, 700065, 700070, 400295, 300258, 2200115, 700071, 700068};
        nArray2[74] = new int[]{700218, 700219, 700238, 700253, 700220, 700221, 700222, 700239, 700223, 700256, 700250, 700224, 700240, 700271, 700251};
        nArray[75] = new int[]{2};
        nArray2[75] = new int[]{700225};
        nArray[76] = nArray[22];
        nArray2[76] = new int[]{700226, 700227};
        nArray[77] = nArray[22];
        nArray2[77] = new int[]{700228, 700229};
        nArray[78] = nArray[59];
        nArray2[78] = new int[]{700230, 700231, 700355};
        nArray[79] = nArray[22];
        nArray2[79] = new int[]{700232, 700241};
        nArray[80] = new int[]{1, 2, 1741, 1742, 2200271};
        nArray2[80] = new int[]{700233, 700242, 700234, 700234, 700353};
        nArray[81] = nArray[22];
        nArray2[81] = new int[]{700235, 700236};
        nArray[82] = nArray[4];
        nArray2[82] = new int[]{700243, 700237, 700342, 700342};
        nArray[87] = nArray[18];
        nArray2[87] = new int[]{700270};
        nArray[88] = nArray[4];
        nArray2[88] = new int[]{700272, 700268, 700269, 700269};
        nArray[94] = new int[]{1, 2300004};
        nArray2[94] = new int[]{700276, 700335};
        nArray[95] = nArray[22];
        nArray2[95] = new int[]{700278, 700279};
        nArray[97] = nArray[22];
        nArray2[97] = new int[]{700292, 700293};
        nArray[99] = new int[]{1, 2, 2200090};
        nArray2[99] = new int[]{700297, 700298, 700375};
        nArray[100] = nArray[22];
        nArray2[100] = new int[]{700304, 700305};
        nArray[101] = nArray[22];
        nArray2[101] = new int[]{700306, 700295};
        nArray[103] = nArray[22];
        nArray2[103] = new int[]{700307, 700308};
        nArray[104] = nArray[22];
        nArray2[104] = new int[]{700309, 700310};
        nArray[105] = new int[]{1, 2, 700091, 1498};
        nArray2[105] = new int[]{700311, 700312, 700340, 700313};
        nArray[106] = new int[]{2, 1};
        nArray2[106] = new int[]{700314, 700315};
        nArray[108] = nArray[22];
        nArray2[108] = new int[]{700324, 700325};
        nArray[109] = nArray[22];
        nArray2[109] = new int[]{700326, 700327};
        nArray[110] = nArray[22];
        nArray2[110] = new int[]{700328, 700329};
        nArray[111] = nArray[22];
        nArray2[111] = new int[]{700330, 700331};
        nArray[112] = new int[]{1, 2, 1507, 2300074};
        nArray2[112] = new int[]{700336, 700337, 700338, 700339};
        nArray[113] = new int[]{1, 700072};
        nArray2[113] = new int[]{700341, 700277};
        nArray[115] = new int[]{1, 2, 1507};
        nArray2[115] = new int[]{700346, 700347, 700348};
        nArray[116] = new int[]{700094};
        nArray2[116] = new int[]{700351};
        nArray[117] = nArray[22];
        nArray2[117] = new int[]{700358, 700359};
        nArray[118] = nArray[22];
        nArray2[118] = new int[]{700360, 700361};
        nArray[121] = nArray[106];
        nArray2[121] = new int[]{700365, 700344};
        nArray[122] = nArray[22];
        nArray2[122] = new int[]{700366, 700367};
        nArray[123] = nArray[22];
        nArray2[123] = new int[]{700368, 700345};
        nArray[124] = nArray[4];
        nArray2[124] = new int[]{700372, 700373, 700374, 700374};
        nArray[125] = new int[]{2800};
        nArray2[125] = new int[]{700391};
        nArray[126] = nArray[22];
        nArray2[126] = new int[]{700376, 700377};
        nArray[129] = nArray[125];
        nArray2[129] = new int[]{700389};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[130][];
        nArrayArray[0] = new int[]{700045, 700019, 700006, 700042, 700017, 700040, 700023, 700027, 700059, 700055, 700024, 700025, 700058, 700054, 700026};
        nArrayArray[5] = new int[]{700002};
        nArrayArray[9] = new int[]{700075};
        nArrayArray[11] = new int[]{700018};
        nArrayArray[12] = new int[]{700080};
        nArrayArray[13] = new int[]{700073};
        nArrayArray[30] = new int[]{700012, 700010, 700011};
        nArrayArray[33] = new int[]{700013};
        nArrayArray[35] = new int[]{700065};
        nArrayArray[36] = new int[]{700022};
        nArrayArray[37] = new int[]{700021};
        nArrayArray[40] = new int[]{700014};
        nArrayArray[51] = new int[]{700000, 700007, 700069, 700031, 700029, 700067, 700053, 700004};
        nArrayArray[57] = new int[]{700061, 700050};
        nArrayArray[73] = new int[]{700035, 700034, 700036, 700038, 700033, 700032, 700046, 700068, 700037};
        nArrayArray[74] = new int[]{700047, 700039, 700048};
        nArrayArray[94] = new int[]{700060};
        nArrayArray[105] = new int[]{700062, 700056};
        nArrayArray[106] = new int[]{700057};
        nArrayArray[113] = new int[]{700063};
        nArrayArray[116] = new int[]{700066};
        nArrayArray[121] = new int[]{700064};
        nArrayArray[125] = new int[]{700081};
        nArrayArray[128] = new int[]{700078};
        nArrayArray[129] = new int[]{700079};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[130][];
        nArrayArray[12] = new int[]{80};
        nArrayArray[13] = new int[]{97};
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[130][];
        nArrayArray[12] = new int[]{109};
        nArrayArray[13] = new int[]{109};
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[130][];
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

