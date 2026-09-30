/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class MediaSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected MediaSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 0, 0, 0, 6, 11, 6, 1, 0, 0, 0, 0, 7, 0, 5, 15, 0, 0, 0, 0, 0, 0, 0, 6, 1, 9, 0, 0, 0, 87, 0, 3, 15, 0, 1, 0, 0, 1, 13, 0, 9, 15, 15, 7, 7, 7, 7, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 89, 14, 13, 8, 0, 0, 0, 0, 593, 9, 0, 9, 0, 0, 9, 8, 0, 1, 0, 9, 0, 0, 15, 8, 6, 81, 81, 87, 9, 0, 6, 9, 0, 0, 6, 0, 6, 1, 7, 13, 6, 1, 0, 9, 0, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 0, 3, 0, 0, 6, 9, 6, 6, 0, 0, 8, 6, 6, 6, 6, 6, 6, 6, 14, 6, 6, 6, 49, 0, 13, 593, 1, 0, 0, 7, 0, 0, 0, 0, 593, 6, 57, 593, 6, 8, 8, 0, 0, 0, 0, 593, 0, 9, 8, 9, 0, 0, 0, 0, 0, 0, 0, 14, 593, 0, 0, 0, 3, 593, 0, 593, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 11, 1, 1, 11, 0, 0, 0, 0, 1, 11, 11, 11, 7, 593, 9, 7, 593, 0, 15, 1, 593, 11, 3, 593, 11, 9, 593, 9, 9, 0, 0, 6, 0, 1, 0, 0, 6, 1, 8, 8, 0, 6, 0, 0, 9};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-1, 200015, -1, -1, 200005, 200007, 200099, 200266, -1, -1, -1, -1, 200032, 200012, 200032, 200032, -1, -1, -1, -1, -1, -1, -1, 200032, 200032, 200024, -1, -1, -1, -10, -1, 200088, 200034, -1, 200107, -1, -1, 200113, 200032, -1, 200032, 200107, 200041, 200041, 200041, 200041, 200041, 200041, 200034, -1, 200032, -1, -1, -1, 200047, 200047, 200047, 200042, 200042, 200042, 200042, -1, 200045, 200045, 200046, 200046, 200045, 200045, -1, -1, 200043, 200043, 200043, 200044, 200044, 200044, 200044, 200044, -1, -1, 200038, 200168, 200038, -1, -1, -1, -1, -1, 200037, 200113, 200266, 200090, -1, -1, -1, -1, 200206, 200110, -1, 200005, 200046, -1, 200126, 200102, 200105, -1, 200126, 200031, 200090, -1, 200107, 200110, 200166, 200114, 200115, 200116, 200029, -1, 200119, 200110, -1, 200046, 200040, -1, 200125, 200040, 200116, 200082, 200129, -1, 200256, 200126, -1, 200134, -1, 200136, -1, 200138, -1, 200140, -1, 200142, -1, 200005, 200145, -1, -1, 200126, 200149, 200126, 200149, 200149, 200127, -1, 200127, 200166, 200166, 200166, 200166, 200166, 200166, 200166, 200166, 200166, 200166, 200166, 200097, -1, 200082, 200046, 200032, 200257, 200173, -1, -1, -1, 200014, -1, 200239, 200180, 200097, 200251, 200099, 200243, 200243, -1, -1, 200193, 200193, 200241, 200273, 200032, 200116, 200273, 200193, 200193, 200193, 200273, 200273, 200273, -1, 200180, 200126, 200126, -1, -1, 200126, 200240, 200046, 200238, 200041, 200210, 200210, 200210, 200210, 200210, 200210, -1, 200219, -1, -1, -1, -1, -1, -1, -1, -1, -1, 200229, 200107, 200107, 200107, 200126, -1, -1, 200047, 200038, 200090, 200210, 200042, 200047, 200247, 200191, 200126, 200247, 200244, 200256, 200191, 200126, 200250, 200232, 200232, 200253, 200232, 200126, 200254, 200131, 200131, 200257, -1, 200149, 200262, 200102, -1, 200042, 200125, 200025, 200266, 200266, 200047, 200166, -1, -1, 200126};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, 200007, -1, -1, 200012, -1, 200011, -1, -1, -1, -1, -1, -1, 200009, -1, -1, -1, -1, -1, -1, -1, -1, -1, 200003, -1, -1, -1, -1, -1, 200037, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 200001, -1, 200059, -1, -1, -1, 200045, 200046, 200047, 200041, 200044, 200042, 200043, -1, 200052, 200053, 200064, 200004, 200048, 200050, -1, -1, 200055, 200056, 200057, 200062, 200061, 200060, 200059, 200058, -1, -1, 200054, 200068, -1, -1, -1, -1, -1, -1, 200088, 200070, -1, 200069, -1, -1, -1, -1, -1, -1, -1, -1, 200074, -1, -1, 200076, 200081, -1, 200085, -1, 200209, -1, -1, 200089, 200038, 200037, 200037, 200037, -1, -1, 200089, -1, -1, 200091, 200092, -1, 200093, -1, -1, -1, 200096, -1, 200097, -1, -1, 200098, -1, 200102, -1, 200100, -1, 200101, -1, 200099, -1, 200103, 200104, -1, -1, 200085, 200106, -1, 200107, 200108, 200209, -1, 200067, 200038, 200038, 200038, 200038, 200038, 200038, 200038, 200117, 200038, 200038, 200038, 200166, -1, -1, -1, -1, 200105, 200109, -1, -1, -1, 200059, -1, -1, 200038, -1, -1, 200011, 200111, 200112, -1, -1, 200114, 200115, -1, 200116, -1, -1, -1, 200126, 200124, 200125, 200123, 200129, 200128, -1, 200117, -1, 200130, -1, -1, -1, -1, 200131, -1, -1, 200141, 200137, 200142, 200139, 200140, 200138, -1, 200145, -1, -1, -1, -1, -1, -1, -1, -1, -1, 200089, -1, -1, -1, -1, -1, -1, 200146, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 200097, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 200105, -1, 200210, 200076, -1, -1, 200211, 200093, -1, 200001, 200001, 200206, 200038, -1, -1, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[274][];
        int[][] nArrayArray2 = new int[274][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.initStateTrigger2(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[5] = new int[]{1, 200093};
        nArray2[5] = new int[]{200007, 200186};
        nArray[7] = new int[]{1, 200123, 200038, 200086};
        nArray2[7] = new int[]{200009, 200273, 200008, 200166};
        nArray[12] = new int[]{1};
        nArray2[12] = new int[]{200015};
        nArray[14] = nArray[12];
        nArray2[14] = new int[]{200238};
        nArray[15] = new int[]{1, 200015};
        nArray2[15] = new int[]{200016, 200432};
        nArray[23] = new int[]{102};
        nArray2[23] = new int[]{200312};
        nArray[24] = new int[]{1, 200132, 1741, 1742};
        nArray2[24] = new int[]{200025, 200223, 200224, 200224};
        nArray[25] = new int[]{1, 200089, 200105};
        nArray2[25] = new int[]{200091, 200172, 200374};
        nArray[29] = new int[]{1, 200001};
        nArray2[29] = new int[]{200028, 200029};
        nArray[31] = nArray[12];
        nArray2[31] = new int[]{200033};
        nArray[32] = new int[]{1, 200237, 200121};
        nArray2[32] = new int[]{200034, 200449, 200455};
        nArray[37] = nArray[12];
        nArray2[37] = new int[]{200084};
        nArray[38] = nArray[15];
        nArray2[38] = new int[]{200257, 200396};
        nArray[40] = new int[]{1, 200122};
        nArray2[40] = new int[]{200160, 200270};
        nArray[41] = new int[]{1, 2, 200011};
        nArray2[41] = new int[]{200054, 200101, 200056};
        nArray[42] = new int[]{1, 2, 200046, 200236};
        nArray2[42] = new int[]{200061, 200240, 200241, 200445};
        nArray[43] = nArray[12];
        nArray2[43] = new int[]{200064};
        nArray[44] = nArray[12];
        nArray2[44] = new int[]{200065};
        nArray[45] = nArray[12];
        nArray2[45] = new int[]{200062};
        nArray[46] = new int[]{1, 2};
        nArray2[46] = new int[]{200063, 200155};
        nArray[47] = nArray[46];
        nArray2[47] = new int[]{200060, 200306};
        nArray[48] = nArray[23];
        nArray2[48] = new int[]{200437};
        nArray[55] = new int[]{200047};
        nArray2[55] = new int[]{200307};
        nArray[82] = new int[]{1, 200089};
        nArray2[82] = new int[]{200070, 200173};
        nArray[88] = new int[]{1, 1741, 200138};
        nArray2[88] = new int[]{200050, 200235, 200413};
        nArray[89] = new int[]{102, 200054};
        nArray2[89] = new int[]{200087, 200088};
        nArray[90] = new int[]{1, 2, 200234, 200077, 200038, 200076};
        nArray2[90] = new int[]{200096, 200092, 200430, 200138, 200097, 200136};
        nArray[91] = new int[]{200103, 1741, 1742, 200058};
        nArray2[91] = new int[]{200204, 200098, 200098, 200099};
        nArray[96] = nArray[46];
        nArray2[96] = new int[]{200110, 200111};
        nArray[97] = new int[]{1, 2, 200151, 1742, 200146, 200069, 1741, 200090, 200166, 200015, 200158, 200106, 200079, 200080, 200067};
        nArray2[97] = new int[]{200139, 200230, 200358, 200284, 200327, 200121, 200115, 200174, 200393, 200213, 200365, 200244, 200302, 200149, 200119};
        nArray[99] = new int[]{1, 200232, 200145, 200231, 200107};
        nArray2[99] = new int[]{200116, 200426, 200325, 200427, 200249};
        nArray[102] = new int[]{1, 2, 200052, 200075};
        nArray2[102] = new int[]{200126, 200145, 200438, 200132};
        nArray[103] = new int[]{200102, 200072, 200075};
        nArray2[103] = new int[]{200202, 200129, 200453};
        nArray[104] = new int[]{1741, 1742, 200073};
        nArray2[104] = new int[]{200357, 200357, 200130};
        nArray[105] = nArray[12];
        nArray2[105] = new int[]{200131};
        nArray[107] = new int[]{200159, 200155, 200149, 200156, 200150, 200335, 200009, 200008, 200010};
        nArray2[107] = new int[]{200366, 200353, 200339, 200354, 200340, 200459, 200037, 200038, 200039};
        nArray[110] = new int[]{1, 2, 1741, 1742, 200121, 200235, 200011, 200068};
        nArray2[110] = new int[]{200140, 200141, 200355, 200355, 200433, 200434, 200311, 200231};
        nArray[111] = new int[]{200078};
        nArray2[111] = new int[]{200143};
        nArray[113] = new int[]{1741, 1742};
        nArray2[113] = new int[]{200089, 200089};
        nArray[114] = nArray[113];
        nArray2[114] = new int[]{200146, 200146};
        nArray[115] = new int[]{1, 1741, 1742};
        nArray2[115] = new int[]{200203, 200147, 200147};
        nArray[116] = new int[]{200144, 200168, 200161, 200098, 200116, 200109, 200112, 200136, 200140, 200133, 200097, 200139, 200091, 200108, 200104, 200119, 200065, 200064, 200039, 200023, 200071, 1000080, 102, 200050, 200051};
        nArray2[116] = new int[]{200324, 200408, 200368, 200193, 200263, 200252, 200254, 200297, 200310, 200288, 200189, 200305, 200175, 200251, 200222, 200264, 200197, 200109, 200151, 200144, 200125, 200419, 200085, 200372, 200373};
        nArray[119] = new int[]{1, 2, 200079};
        nArray2[119] = new int[]{200150, 200229, 200142};
        nArray[121] = new int[]{200084};
        nArray2[121] = new int[]{200217};
        nArray[125] = nArray[12];
        nArray2[125] = new int[]{200448};
        nArray[126] = new int[]{2, 200127, 200141, 200163, 200164, 200154, 2800, 1741, 1742, 1750};
        nArray2[126] = new int[]{200289, 200392, 200313, 200370, 200371, 200351, 200464, 200272, 200272, 200271};
        nArray[127] = new int[]{1, 2, 200233, 200062, 1741, 1742, 200077, 200057, 102, 200076};
        nArray2[127] = new int[]{200164, 200205, 200431, 200206, 200207, 200207, 200208, 200090, 200073, 200209};
        nArray[128] = new int[]{200088};
        nArray2[128] = new int[]{200171};
        nArray[129] = nArray[12];
        nArray2[129] = new int[]{200170};
        nArray[130] = new int[]{200092};
        nArray2[130] = new int[]{200176};
        nArray[131] = new int[]{1, 2, 200075};
        nArray2[131] = new int[]{200177, 200178, 200179};
        nArray[134] = nArray[12];
        nArray2[134] = new int[]{200181};
        nArray[136] = nArray[12];
        nArray2[136] = new int[]{200182};
        nArray[138] = nArray[12];
        nArray2[138] = new int[]{200183};
        nArray[140] = nArray[12];
        nArray2[140] = new int[]{200184};
        nArray[142] = nArray[12];
        nArray2[142] = new int[]{200185};
        nArray[144] = new int[]{200167};
        nArray2[144] = new int[]{200405};
        nArray[145] = nArray[12];
        nArray2[145] = new int[]{200187};
        nArray[147] = nArray[113];
        nArray2[147] = new int[]{200294, 200294};
        nArray[149] = new int[]{1, 2, 200076, 200099, 200101};
        nArray2[149] = new int[]{200201, 200199, 200436, 200194, 200200};
        nArray[156] = nArray[113];
        nArray2[156] = new int[]{200463, 200463};
        nArray[162] = new int[]{1741, 1742, 2800};
        nArray2[162] = new int[]{200285, 200267, 200466};
        nArray[166] = nArray[12];
        nArray2[166] = new int[]{200212};
        nArray[168] = new int[]{1, 2, 200110, 200061, 200162};
        nArray2[168] = new int[]{200215, 200216, 200253, 200108, 200369};
        nArray[169] = new int[]{1, 2, 1741, 1742};
        nArray2[169] = new int[]{200218, 200219, 200220, 200220};
        nArray[170] = nArray[46];
        nArray2[170] = new int[]{200227, 200228};
        nArray[171] = new int[]{200094};
        nArray2[171] = new int[]{200232};
        nArray[173] = nArray[12];
        nArray2[173] = new int[]{200236};
        nArray[178] = nArray[46];
        nArray2[178] = new int[]{200242, 200243};
        nArray[180] = new int[]{1, 200069, 200066, 200100};
        nArray2[180] = new int[]{200245, 200359, 200195, 200196};
        nArray[181] = nArray[46];
        nArray2[181] = new int[]{200247, 200295};
        nArray[182] = new int[]{200148, 200132};
        nArray2[182] = new int[]{200331, 200462};
        nArray[187] = new int[]{1741, 1742, 200126, 200111};
        nArray2[187] = new int[]{200281, 200281, 200280, 200255};
        nArray[189] = new int[]{1, 2, 1507};
        nArray2[189] = new int[]{200259, 200260, 200387};
        nArray[191] = new int[]{1, 2, 200015, 1495};
        nArray2[191] = new int[]{200388, 200399, 200266, 200389};
        nArray[192] = new int[]{200015};
        nArray2[192] = new int[]{200234};
        nArray[193] = new int[]{1, 2, 1741, 1742, 200015};
        nArray2[193] = new int[]{200274, 200275, 200276, 200276, 200286};
        nArray[194] = nArray[113];
        nArray2[194] = new int[]{200304, 200304};
        nArray[195] = new int[]{200124};
        nArray2[195] = new int[]{200277};
        nArray[196] = new int[]{200125};
        nArray2[196] = new int[]{200278};
        nArray[198] = new int[]{1741, 1742, 200128};
        nArray2[198] = new int[]{200296, 200296, 200282};
        nArray[199] = new int[]{200129};
        nArray2[199] = new int[]{200283};
        nArray[201] = new int[]{1742, 2800};
        nArray2[201] = new int[]{200287, 200467};
        nArray[202] = nArray[46];
        nArray2[202] = new int[]{200290, 200291};
        nArray[207] = new int[]{1, 2, 1741};
        nArray2[207] = new int[]{200308, 200309, 200362};
        nArray[209] = nArray[207];
        nArray2[209] = new int[]{200314, 200315, 200316};
        nArray[210] = nArray[46];
        nArray2[210] = new int[]{200317, 200318};
        nArray[214] = new int[]{200143};
        nArray2[214] = new int[]{200319};
        nArray[215] = new int[]{200142, 1741, 1742};
        nArray2[215] = new int[]{200320, 200321, 200321};
        nArray[218] = nArray[113];
        nArray2[218] = new int[]{200328, 200328};
        nArray[219] = nArray[12];
        nArray2[219] = new int[]{200329};
        nArray[229] = new int[]{1, 2, 1741, 1742, 200079};
        nArray2[229] = new int[]{200347, 200348, 200356, 200356, 200349};
        nArray[230] = nArray[12];
        nArray2[230] = new int[]{200350};
        nArray[231] = nArray[12];
        nArray2[231] = new int[]{200352};
        nArray[232] = new int[]{2, 1507, 1644};
        nArray2[232] = new int[]{200465, 200376, 200377};
        nArray[235] = new int[]{1741, 1742, 200157};
        nArray2[235] = new int[]{200364, 200364, 200363};
        nArray[237] = nArray[12];
        nArray2[237] = new int[]{200375};
        nArray[238] = new int[]{1507, 1644, 2800};
        nArray2[238] = new int[]{200380, 200381, 200468};
        nArray[239] = new int[]{1741, 1742, 1507, 1644, 2800};
        nArray2[239] = new int[]{200395, 200395, 200382, 200383, 200469};
        nArray[240] = new int[]{1644, 1507, 2800};
        nArray2[240] = new int[]{200385, 200384, 200470};
        nArray[241] = nArray[12];
        nArray2[241] = new int[]{200400};
        nArray[242] = nArray[46];
        nArray2[242] = new int[]{200391, 200265};
        nArray[243] = new int[]{2, 200101};
        nArray2[243] = new int[]{200397, 200398};
        nArray[244] = nArray[12];
        nArray2[244] = new int[]{200401};
        nArray[245] = nArray[189];
        nArray2[245] = new int[]{200402, 200403, 200404};
        nArray[246] = nArray[130];
        nArray2[246] = new int[]{200407};
        nArray[247] = new int[]{200229, 200165};
        nArray2[247] = new int[]{200412, 200390};
        nArray[248] = nArray[46];
        nArray2[248] = new int[]{200410, 200411};
        nArray[249] = nArray[46];
        nArray2[249] = new int[]{200415, 200416};
    }

    private void initStateTrigger2(int[][] nArray, int[][] nArray2) {
        nArray[252] = nArray[46];
        nArray2[252] = new int[]{200417, 200418};
        nArray[254] = new int[]{1, 2, 1492};
        nArray2[254] = new int[]{200420, 200421, 200422};
        nArray[255] = nArray[189];
        nArray2[255] = new int[]{200423, 200424, 200425};
        nArray[256] = new int[]{200052};
        nArray2[256] = new int[]{200406};
        nArray[257] = nArray[256];
        nArray2[257] = new int[]{200428};
        nArray[258] = nArray[171];
        nArray2[258] = new int[]{200429};
        nArray[261] = new int[]{200102, 200072};
        nArray2[261] = new int[]{200439, 200440};
        nArray[262] = new int[]{1, 2, 200075, 1741, 1742, 1750};
        nArray2[262] = new int[]{200441, 200442, 200443, 200446, 200446, 200447};
        nArray[267] = new int[]{200238};
        nArray2[267] = new int[]{200450};
        nArray[268] = nArray[267];
        nArray2[268] = new int[]{200451};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[274][];
        nArrayArray[5] = new int[]{200002, 200033};
        nArrayArray[15] = new int[]{200102};
        nArrayArray[25] = new int[]{200045};
        nArrayArray[32] = new int[]{200116};
        nArrayArray[38] = new int[]{200043};
        nArrayArray[40] = new int[]{200052};
        nArrayArray[41] = new int[]{200006};
        nArrayArray[42] = new int[]{200108};
        nArrayArray[88] = new int[]{200057};
        nArrayArray[89] = new int[]{200015};
        nArrayArray[90] = new int[]{200016, 200021};
        nArrayArray[91] = new int[]{200101};
        nArrayArray[97] = new int[]{200092, 200042, 200078, 200047, 200056, 200025, 200017};
        nArrayArray[99] = new int[]{200062, 200098, 200048};
        nArrayArray[102] = new int[]{200106, 200079};
        nArrayArray[103] = new int[]{200114};
        nArrayArray[107] = new int[]{200076, 200074, 200075, 200073, 200119, 200008};
        nArrayArray[110] = new int[]{200103, 200104, 200058, 200118, 200018};
        nArrayArray[111] = new int[]{200026};
        nArrayArray[116] = new int[]{200084};
        nArrayArray[119] = new int[]{200027};
        nArrayArray[127] = new int[]{200041};
        nArrayArray[131] = new int[]{200080};
        nArrayArray[149] = new int[]{200105, 200036, 200038};
        nArrayArray[154] = new int[]{200100};
        nArrayArray[162] = new int[]{200077, 200123};
        nArrayArray[168] = new int[]{200081};
        nArrayArray[180] = new int[]{200037};
        nArrayArray[183] = new int[]{200059, 200083};
        nArrayArray[184] = new int[]{200082};
        nArrayArray[191] = new int[]{200050, 200090};
        nArrayArray[192] = new int[]{200046};
        nArrayArray[193] = new int[]{200053};
        nArrayArray[201] = new int[]{200124};
        nArrayArray[229] = new int[]{200072};
        nArrayArray[232] = new int[]{200085};
        nArrayArray[238] = new int[]{200087, 200125};
        nArrayArray[239] = new int[]{200088, 200126};
        nArrayArray[240] = new int[]{200089, 200127};
        nArrayArray[243] = new int[]{200093};
        nArrayArray[247] = new int[]{200095, 200096};
        nArrayArray[250] = new int[]{200120};
        nArrayArray[253] = new int[]{200121};
        nArrayArray[254] = new int[]{200097};
        nArrayArray[256] = new int[]{200094};
        nArrayArray[257] = new int[]{200099};
        nArrayArray[267] = new int[]{200109};
        nArrayArray[268] = new int[]{200110};
        nArrayArray[273] = new int[]{200122};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[274][];
        nArrayArray[4] = new int[]{22};
        nArrayArray[15] = new int[]{22};
        nArrayArray[29] = new int[]{24};
        nArrayArray[99] = new int[]{22};
        nArrayArray[110] = new int[]{121};
        nArrayArray[168] = new int[]{22};
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[274][];
        nArrayArray[4] = new int[]{20};
        nArrayArray[15] = new int[]{20};
        nArrayArray[99] = new int[]{20};
        nArrayArray[110] = new int[]{122};
        nArrayArray[168] = new int[]{20};
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[274][];
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

