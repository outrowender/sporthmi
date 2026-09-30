/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class SWDLSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SWDLSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 1, 6, 6, 9, 9, 0, 0, 0, 9, 1, 0, 0, 5, 0, 6, 593, 267, 3, 0, 6, 6, 0, 1, 6, 4, 0, 0, 15, 7, 0, 9, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 261, 2, 0, 0, 0, 0, 1, 1, 11, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5, 0, 5, 0, 0, 593, 593, 265, 0, 0, 7, 0, 0, 0, 15, 0, 593, 593, 0, 265, 0, 0, 0, 9, 1, 0, 0, 0, 0, 1, 1, 13, 0, 13, 0, 15, 0, 15, 0, 0, 0, 0, 0, 0, 593, 0, 1, 0, 1, 0, 1, 0, 1, 593, 259, 0, 593, 593, 265, 1, 593, 0, 3, 9, 1, 1, 0, 0, 0, 0, 0, 0, 11, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 0, 7, 593, 265, 9, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 5, 0, 5, 593, 593, 593, 9, 8, 1, 0, 0, 1, 593, 7};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-1, 1700016, 1700015, -1, -1, 1700006, 1700021, 1700016, 1700006, 1700015, 1700097, 1700012, 1700015, 1700120, 1700020, 1700020, 1700012, 1700016, 1700146, 1700196, 1700097, 1700097, 1700024, -1, 1700021, 1700196, 1700021, 1700029, -10, -10, -1, 1700118, 1700122, 1700034, -1, 1700024, 1700024, 1700024, 1700024, 1700020, 1700020, 1700042, 1700040, 1700040, 1700042, 1700039, 1700040, 1700040, 1700040, 1700040, 1700040, 1700040, 1700040, 1700047, 1700047, 1700047, 1700047, -1, 1700059, 1700039, -1, 1700059, -1, 1700146, 1700146, -1, -1, -1, 1700075, -10, 1700176, -1, -1, -1, -1, 1700076, 1700176, 1700076, 1700077, 1700150, -1, 1700150, 1700150, 1700111, 1700085, -1, 1700087, -1, 1700089, -1, -1, -1, 1700024, 1700016, -10, -1, -1, 1700028, 1700028, 1700047, 1700006, 1700076, 1700101, 1700077, 1700141, -1, -10, 1700110, 1700101, 1700110, 1700101, 1700150, 1700111, 1700116, -1, 1700117, 1700101, 1700116, 1700124, 1700118, 1700124, 1700120, 1700124, 1700122, 1700094, 1700145, -1, -1, -1, -1, 1700145, 1700176, 1700133, -1, 1700135, -1, 1700137, -1, 1700139, -1, 1700101, -10, -1, 1700039, 1700094, -10, 1700145, 1700177, -1, -1, 1700106, 1700149, 1700151, 1700152, 1700151, 1700151, 1700152, 1700151, 1700159, -1, 1700161, -1, 1700163, -1, 1700165, -1, 1700167, -1, 1700169, -1, 1700171, -1, -1, 1700174, -1, 1700069, -10, 1700076, 1700181, 1700180, -1, -1, -1, 1700184, -1, 1700184, 1700184, 1700188, -1, 1700190, -1, 1700194, 1700194, 1700194, 1700076, 1700021, 1700021, 1700199, 1700199, -1, 1700201, 1700075};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, 1700007, 1700004, -1, -1, 1700012, -1, 1700006, 1700019, 1700003, 1700011, 1700005, -1, 1700009, 1700001, -1, -1, 1700008, 1700010, 1700017, -1, -1, 1700013, -1, -1, 1700018, 1700016, -1, -1, -1, -1, 1700023, 1700022, 1700021, -1, 1700024, 1700025, 1700027, 1700026, -1, -1, 1700028, -1, 1700030, 1700029, 1700070, 1700032, -1, 1700031, 1700034, 1700033, 1700035, 1700036, 1700038, 1700032, 1700039, 1700037, -1, 1700071, -1, -1, 1700072, -1, 1700042, 1700041, -1, -1, -1, 1700088, -1, 1700089, -1, -1, -1, -1, -1, -1, -1, 1700050, 1700049, -1, 1700051, 1700052, 1700053, 1700048, -1, 1700046, -1, 1700047, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1700055, 1700026, 1700057, -1, 1700060, -1, -1, -1, -1, 1700061, 1700062, 1700063, -1, -1, 1700066, 1700067, -1, 1700068, -1, -1, -1, 1700071, -1, 1700070, -1, 1700072, -1, 1700073, -1, -1, -1, -1, 1700074, -1, 1700076, -1, 1700077, -1, 1700078, -1, 1700079, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1700066, 1700051, 1700052, 1700053, 1700049, 1700054, -1, 1700082, -1, 1700083, -1, 1700084, -1, 1700086, -1, 1700085, -1, 1700087, -1, -1, 1700020, -1, -1, -1, -1, 1700091, 1700090, -1, -1, -1, 1700140, -1, 1700141, 1700090, 1700142, -1, 1700143, -1, -1, -1, -1, -1, 1700018, -1, 1700090, 1700141, -1, -1, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[202][];
        int[][] nArrayArray2 = new int[202][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[5] = new int[]{1700023, 1741, 1742, 151, 1700071};
        nArray2[5] = new int[]{1700010, 1700011, 1700011, 1700341, 1700187};
        nArray[7] = new int[]{1741, 1742};
        nArray2[7] = new int[]{1700028, 1700028};
        nArray[8] = nArray[7];
        nArray2[8] = new int[]{1700012, 1700012};
        nArray[10] = nArray[7];
        nArray2[10] = new int[]{1700013, 1700013};
        nArray[11] = new int[]{1700003};
        nArray2[11] = new int[]{1700014};
        nArray[12] = new int[]{1, 2};
        nArray2[12] = new int[]{1700015, 1700016};
        nArray[13] = new int[]{1700106, 1700104};
        nArray2[13] = new int[]{1700275, 1700273};
        nArray[14] = new int[]{1741, 1742, 1700004, 1700035, 1700034};
        nArray2[14] = new int[]{1700186, 1700186, 1700019, 1700073, 1700074};
        nArray[15] = new int[]{2, 1741, 1742, 1700019, 1700006, 1700007, 1700005};
        nArray2[15] = new int[]{1700021, 1700022, 1700022, 1700027, 1700023, 1700024, 1700025};
        nArray[16] = new int[]{2, 1741, 1742, 1700009, 1700010, 1700008, 1700015};
        nArray2[16] = new int[]{1700026, 1700333, 1700333, 1700030, 1700031, 1700032, 1700177};
        nArray[17] = new int[]{1700012, 1700011};
        nArray2[17] = new int[]{1700033, 1700034};
        nArray[18] = new int[]{1700102};
        nArray2[18] = new int[]{1700130};
        nArray[19] = new int[]{1741, 1742, 1700022};
        nArray2[19] = new int[]{1700037, 1700037, 1700038};
        nArray[20] = new int[]{1, 1741, 1742, 1700015};
        nArray2[20] = new int[]{1700039, 0x19F111, 0x19F111, 1700075};
        nArray[21] = new int[]{1, 1700028};
        nArray2[21] = new int[]{1700040, 1700041};
        nArray[22] = new int[]{1700014, 1741, 1742, 151, 1700019};
        nArray2[22] = new int[]{1700063, 1700045, 1700045, 1700240, 1700171};
        nArray[24] = new int[]{1, 1700021};
        nArray2[24] = new int[]{1700047, 1700044};
        nArray[25] = new int[]{1741, 1742, 1700017};
        nArray2[25] = new int[]{1700048, 1700048, 1700385};
        nArray[26] = nArray[7];
        nArray2[26] = new int[]{1700049, 1700049};
        nArray[27] = new int[]{1, 2, 1741, 1742};
        nArray2[27] = new int[]{1700050, 1700051, 1700052, 1700052};
        nArray[28] = new int[]{2, 1, 1700023, 1700020, 1700017, 1700016, 1700018, 1700101, 1700070};
        nArray2[28] = new int[]{1700053, 1700182, 1700001, 1700002, 1700003, 1700004, 1700005, 1700286, 1700183};
        nArray[29] = nArray[12];
        nArray2[29] = new int[]{1700054, 1700055};
        nArray[31] = nArray[13];
        nArray2[31] = new int[]{1700276, 1700277};
        nArray[32] = nArray[13];
        nArray2[32] = new int[]{1700278, 1700279};
        nArray[33] = nArray[7];
        nArray2[33] = new int[]{1700064, 1700064};
        nArray[34] = new int[]{1};
        nArray2[34] = new int[]{1700065};
        nArray[35] = new int[]{1741, 1742, 1700031, 1700032};
        nArray2[35] = new int[]{1700066, 1700066, 1700067, 1700068};
        nArray[36] = new int[]{1741, 1742, 1700033};
        nArray2[36] = new int[]{1700069, 1700069, 1700070};
        nArray[37] = nArray[7];
        nArray2[37] = new int[]{1700071, 1700071};
        nArray[38] = nArray[7];
        nArray2[38] = new int[]{1700072, 1700072};
        nArray[39] = new int[]{1, 2, 1700015, 1700103};
        nArray2[39] = new int[]{1700076, 1700112, 1700114, 1700271};
        nArray[40] = nArray[12];
        nArray2[40] = new int[]{1700077, 1700078};
        nArray[41] = new int[]{1741, 1742, 1700036};
        nArray2[41] = new int[]{1700080, 1700080, 1700081};
        nArray[42] = new int[]{1, 2, 1700038};
        nArray2[42] = new int[]{1700082, 1700083, 1700084};
        nArray[43] = new int[]{1700040, 1741, 1742, 1700043, 1700041, 1700042};
        nArray2[43] = new int[]{1700088, 1700085, 1700085, 1700089, 1700090, 1700091};
        nArray[44] = new int[]{1700039, 1741, 1742};
        nArray2[44] = new int[]{1700086, 1700087, 1700087};
        nArray[45] = new int[]{1700013, 1741, 1742, 1700014};
        nArray2[45] = new int[]{1700115, 1700116, 1700116, 1700117};
        nArray[46] = new int[]{1741, 1742, 1700014};
        nArray2[46] = new int[]{1700092, 1700092, 1700093};
        nArray[47] = nArray[12];
        nArray2[47] = new int[]{1700101, 1700102};
        nArray[48] = nArray[7];
        nArray2[48] = new int[]{1700094, 1700094};
        nArray[49] = nArray[7];
        nArray2[49] = new int[]{1700095, 1700095};
        nArray[50] = new int[]{1741, 1742, 1700031};
        nArray2[50] = new int[]{1700096, 1700096, 1700097};
        nArray[51] = new int[]{1741, 1742, 1700044};
        nArray2[51] = new int[]{1700098, 1700098, 1700099};
        nArray[52] = nArray[7];
        nArray2[52] = new int[]{1700100, 1700100};
        nArray[53] = nArray[7];
        nArray2[53] = new int[]{1700103, 1700103};
        nArray[54] = nArray[46];
        nArray2[54] = new int[]{1700104, 1700104, 1700105};
        nArray[55] = nArray[36];
        nArray2[55] = new int[]{1700106, 1700106, 1700107};
        nArray[56] = new int[]{1741, 1742, 1700032, 1700031};
        nArray2[56] = new int[]{1700108, 1700108, 1700109, 1700110};
        nArray[58] = new int[]{1700033, 1741, 1742};
        nArray2[58] = new int[]{1700185, 1700118, 1700118};
        nArray[59] = nArray[12];
        nArray2[59] = new int[]{1700119, 1700120};
        nArray[61] = nArray[50];
        nArray2[61] = new int[]{0x19F119, 0x19F119, 1700122};
        nArray[63] = new int[]{1700047};
        nArray2[63] = new int[]{1700126};
        nArray[64] = new int[]{1700048};
        nArray2[64] = new int[]{0x19F11F};
        nArray[68] = new int[]{1700050, 1700143, 1700142, 1700144, 1700051};
        nArray2[68] = new int[]{1700179, 1700399, 1700400, 1700401, 1700143};
        nArray[69] = new int[]{2, 1};
        nArray2[69] = new int[]{1700132, 1700335};
        nArray[70] = new int[]{1700069, 1741, 1742, 1700082, 2436};
        nArray2[70] = new int[]{1700170, 1700145, 1700145, 1700212, 1700393};
        nArray[75] = new int[]{1, 1741, 1742};
        nArray2[75] = new int[]{1700141, 1700142, 1700142};
        nArray[76] = new int[]{1, 2, 1700076, 1700136};
        nArray2[76] = new int[]{1700140, 1700144, 1700340, 1700380};
        nArray[77] = new int[]{1, 2, 1741, 1742, 1700110};
        nArray2[77] = new int[]{1700193, 1700146, 1700152, 1700152, 1700339};
        nArray[78] = new int[]{1700065, 1700064};
        nArray2[78] = new int[]{1700150, 1700151};
        nArray[84] = new int[]{1741, 1742, 1700068, 1700067};
        nArray2[84] = new int[]{1700157, 1700157, 1700158, 1700159};
        nArray[85] = nArray[34];
        nArray2[85] = new int[]{1700160};
        nArray[86] = new int[]{1700058, 1741, 1742, 1700066};
        nArray2[86] = new int[]{1700161, 1700162, 1700162, 1700163};
        nArray[87] = nArray[34];
        nArray2[87] = new int[]{1700164};
        nArray[88] = new int[]{1741, 1742, 1700059};
        nArray2[88] = new int[]{1700379, 1700379, 1700165};
        nArray[89] = nArray[34];
        nArray2[89] = new int[]{1700166};
        nArray[92] = nArray[12];
        nArray2[92] = new int[]{1700172, 1700173};
        nArray[93] = nArray[12];
        nArray2[93] = new int[]{1700174, 1700175};
        nArray[94] = new int[]{2, 1, 1700015, 1700103};
        nArray2[94] = new int[]{1700176, 1700178, 1700029, 1700272};
        nArray[97] = nArray[34];
        nArray2[97] = new int[]{1700000};
        nArray[99] = nArray[7];
        nArray2[99] = new int[]{1700111, 1700111};
        nArray[100] = new int[]{151, 1741, 1742};
        nArray2[100] = new int[]{1700342, 1700188, 1700188};
        nArray[101] = new int[]{1, 2, 1700066, 1700077, 1700074};
        nArray2[101] = new int[]{1700190, 1700191, 1700213, 1700203, 1700192};
        nArray[102] = new int[]{1700117, 1700083};
        nArray2[102] = new int[]{1700395, 1700216};
        nArray[103] = new int[]{1, 2, 1700112, 1700066};
        nArray2[103] = new int[]{1700194, 1700195, 1700325, 1700155};
        nArray[104] = nArray[12];
        nArray2[104] = new int[]{1700196, 1700197};
        nArray[106] = nArray[69];
        nArray2[106] = new int[]{1700200, 1700296};
        nArray[107] = new int[]{1700074};
        nArray2[107] = new int[]{1700205};
        nArray[109] = new int[]{1700079, 1741, 1742, 1700078};
        nArray2[109] = new int[]{1700206, 1700209, 1700209, 1700207};
        nArray[110] = new int[]{1, 2, 1700081};
        nArray2[110] = new int[]{1700210, 1700208, 1700211};
        nArray[111] = nArray[34];
        nArray2[111] = new int[]{1700214};
        nArray[113] = new int[]{1700084};
        nArray2[113] = new int[]{1700218};
        nArray[116] = new int[]{1, 1741, 1742, 1700085};
        nArray2[116] = new int[]{1700219, 1700222, 1700222, 1700221};
        nArray[117] = nArray[7];
        nArray2[117] = new int[]{1700223, 1700223};
        nArray[118] = new int[]{1, 1700033, 1741, 1742, 1700107, 1700105, 1700101};
        nArray2[118] = new int[]{1700224, 1700184, 1700060, 1700060, 1700280, 1700281, 1700260};
        nArray[120] = new int[]{1, 1700013, 1741, 1742, 1700014, 1700105, 1700107, 1700101};
        nArray2[120] = new int[]{1700225, 1700017, 1700018, 1700018, 1700059, 1700274, 1700282, 1700261};
        nArray[122] = new int[]{1, 1700031, 1741, 1742, 1700107, 1700105, 1700101};
        nArray2[122] = new int[]{1700226, 1700061, 1700062, 1700062, 1700283, 1700284, 1700262};
        nArray[125] = nArray[7];
        nArray2[125] = new int[]{1700227, 1700227};
        nArray[130] = new int[]{1700090, 1700089};
        nArray2[130] = new int[]{1700265, 1700238};
        nArray[131] = nArray[12];
        nArray2[131] = new int[]{1700242, 1700243};
        nArray[132] = new int[]{1700116, 1700115};
        nArray2[132] = new int[]{1700258, 0x19F1F9};
        nArray[133] = nArray[34];
        nArray2[133] = new int[]{1700248};
        nArray[134] = new int[]{1700097};
        nArray2[134] = new int[]{0x19F199};
        nArray[135] = nArray[34];
        nArray2[135] = new int[]{1700250};
        nArray[136] = new int[]{1700098};
        nArray2[136] = new int[]{1700251};
        nArray[137] = nArray[34];
        nArray2[137] = new int[]{1700252};
        nArray[138] = new int[]{1700100, 1700116};
        nArray2[138] = new int[]{1700254, 1700259};
        nArray[139] = nArray[34];
        nArray2[139] = new int[]{0x19F19F};
        nArray[140] = new int[]{1, 2, 1741, 1742, 1700112};
        nArray2[140] = new int[]{1700256, 1700204, 1700392, 1700392, 1700326};
        nArray[141] = nArray[69];
        nArray2[141] = new int[]{1700257, 1700198};
        nArray[143] = nArray[27];
        nArray2[143] = new int[]{1700266, 1700124, 1700269, 1700269};
        nArray[144] = nArray[27];
        nArray2[144] = new int[]{1700267, 1700231, 1700035, 1700035};
        nArray[145] = new int[]{2, 1, 1741, 1742, 1700088};
        nArray2[145] = new int[]{1700268, 1700123, 1700128, 1700128, 1700229};
        nArray[146] = nArray[34];
        nArray2[146] = new int[]{1700270};
        nArray[147] = nArray[12];
        nArray2[147] = new int[]{1700287, 1700288};
        nArray[149] = new int[]{1, 1700066, 1741, 1742};
        nArray2[149] = new int[]{1700297, 1700305, 1700378, 1700378};
        nArray[150] = new int[]{2, 1700062, 1700060, 1700061, 1700063};
        nArray2[150] = new int[]{1700298, 1700153, 1700148, 1700154, 1700149};
        nArray[151] = nArray[12];
        nArray2[151] = new int[]{1700306, 1700299};
        nArray[152] = nArray[34];
        nArray2[152] = new int[]{1700304};
        nArray[158] = nArray[7];
        nArray2[158] = new int[]{1700307, 1700307};
        nArray[159] = new int[]{1, 1700081, 1700111};
        nArray2[159] = new int[]{1700308, 1700408, 1700324};
        nArray[160] = new int[]{1700076, 1700081, 1741, 1742};
        nArray2[160] = new int[]{1700309, 1700310, 1700312, 1700312};
        nArray[161] = nArray[34];
        nArray2[161] = new int[]{1700311};
        nArray[162] = new int[]{1700081};
        nArray2[162] = new int[]{1700313};
        nArray[163] = nArray[34];
        nArray2[163] = new int[]{1700314};
        nArray[164] = nArray[162];
        nArray2[164] = new int[]{1700315};
        nArray[165] = nArray[34];
        nArray2[165] = new int[]{1700316};
        nArray[166] = nArray[162];
        nArray2[166] = new int[]{1700317};
        nArray[167] = nArray[34];
        nArray2[167] = new int[]{1700318};
        nArray[168] = new int[]{1700066};
        nArray2[168] = new int[]{1700319};
        nArray[169] = nArray[34];
        nArray2[169] = new int[]{1700320};
        nArray[170] = new int[]{1700129, 0x19F111, 1700081, 1741, 1742};
        nArray2[170] = new int[]{0x19F1FF, 1700327, 1700321, 1700322, 1700322};
        nArray[171] = nArray[34];
        nArray2[171] = new int[]{1700323};
        nArray[173] = new int[]{1741, 1742, 1700025};
        nArray2[173] = new int[]{1700330, 1700330, 1700331};
        nArray[174] = nArray[34];
        nArray2[174] = new int[]{1700332};
        nArray[175] = nArray[12];
        nArray2[175] = new int[]{1700336, 0x19F1F1};
        nArray[176] = new int[]{2, 1, 1700134, 1700092, 1700129, 1700114, 1700072, 1700138, 1700094};
        nArray2[176] = new int[]{1700338, 1700131, 1700362, 0x19F191, 1700391, 1700328, 1700189, 1700394, 1700244};
        nArray[177] = new int[]{1, 1507, 2500145};
        nArray2[177] = new int[]{1700406, 1700344, 1700289};
        nArray[178] = new int[]{1700117};
        nArray2[178] = new int[]{1700348};
        nArray[179] = new int[]{1700139, 1700117, 1700076};
        nArray2[179] = new int[]{1700396, 1700382, 1700349};
        nArray[180] = nArray[34];
        nArray2[180] = new int[]{1700346};
        nArray[181] = nArray[34];
        nArray2[181] = new int[]{1700347};
        nArray[183] = new int[]{1700130};
        nArray2[183] = new int[]{1700354};
        nArray[184] = new int[]{1, 1700117, 1700076, 1741, 1742};
        nArray2[184] = new int[]{1700353, 1700356, 1700381, 1700352, 1700352};
        nArray[185] = new int[]{1700131};
        nArray2[185] = new int[]{1700355};
        nArray[187] = new int[]{1700059};
        nArray2[187] = new int[]{1700358};
        nArray[188] = nArray[34];
        nArray2[188] = new int[]{1700359};
        nArray[189] = new int[]{1700141, 1700059};
        nArray2[189] = new int[]{1700398, 1700360};
        nArray[190] = nArray[34];
        nArray2[190] = new int[]{1700361};
        nArray[191] = new int[]{1, 2, 1507};
        nArray2[191] = new int[]{1700363, 1700364, 1700365};
        nArray[192] = nArray[191];
        nArray2[192] = new int[]{1700366, 1700367, 1700368};
        nArray[193] = nArray[12];
        nArray2[193] = new int[]{1700369, 1700376};
        nArray[194] = new int[]{1, 2, 1741, 1742, 1495, 2500145};
        nArray2[194] = new int[]{1700371, 1700372, 1700373, 1700373, 1700374, 1700375};
        nArray[195] = new int[]{1700137, 1741, 1742};
        nArray2[195] = new int[]{1700383, 1700384, 1700384};
        nArray[198] = nArray[185];
        nArray2[198] = new int[]{1700386};
        nArray[199] = new int[]{1, 1741, 1742, 1700117, 1700076};
        nArray2[199] = new int[]{1700387, 1700388, 1700388, 1700389, 1700390};
        nArray[200] = new int[]{1, 2, 1507, 400164};
        nArray2[200] = new int[]{1700402, 1700403, 1700404, 1700405};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[202][];
        nArrayArray[15] = new int[]{1700001};
        nArrayArray[16] = new int[]{1700002, 1700009};
        nArrayArray[20] = new int[]{1700005};
        nArrayArray[28] = new int[]{1700010, 1700030};
        nArrayArray[39] = new int[]{1700006, 1700023};
        nArrayArray[42] = new int[]{1700004};
        nArrayArray[77] = new int[]{1700038};
        nArrayArray[94] = new int[]{1700016, 1700022};
        nArrayArray[101] = new int[]{1700018};
        nArrayArray[106] = new int[]{1700036};
        nArrayArray[110] = new int[]{1700013};
        nArrayArray[118] = new int[]{1700026, 1700025, 1700019};
        nArrayArray[120] = new int[]{1700024, 1700027, 1700020};
        nArrayArray[122] = new int[]{1700029, 1700028, 1700021};
        nArrayArray[124] = new int[]{1700003};
        nArrayArray[145] = new int[]{1700014};
        nArrayArray[150] = new int[]{1700008};
        nArrayArray[159] = new int[]{1700035};
        nArrayArray[176] = new int[]{1700011, 1700045, 1700017};
        nArrayArray[177] = new int[]{1700039};
        nArrayArray[194] = new int[]{1700043, 1700042};
        nArrayArray[195] = new int[]{1700044};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[202][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[202][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[202][];
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

