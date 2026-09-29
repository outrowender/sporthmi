/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

public class SettingsSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SettingsSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 63, 6, 0, 0, 15, 0, 3, 3, 1, 593, 593, 593, 593, 1, 8, 6, 11, 15, 593, 15, 8, 261, 7, 0, 0, 9, 0, 8, 1, 0, 7, 2, 15, 0, 0, 0, 2, 7, 0, 9, 0, 0, 0, 0, 0, 0, 6, 2, 3, 265, 593, 0, 0, 1, 6, 7, 0, 0, 1, 1, 0, 0, 0, 3, 9, 0, 0, 1, 0, 593, 9};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1439240192, 1338576896, 1405685760, 1338576896, 1439240192, 1405685760, 1808338944, 1808338944, 1959333888, -2067197952, 1607012352, 1707675648, 1992888320, 1472794624, 1456017408, 1456017408, 1456017408, -10, 1657344000, 2143883264, 1875447808, -10, 1456017408, 1690898432, 1758007296, 1690898432, 1758007296, 1758007296, 1623789568, 1841893376, 1456017408, 1623789568, 2143883264, 1875447808, 1875447808, 1875447808, 1808338944, 1456017408, 1959333888, 1472794624, 1472794624, 1556680704, 1472794624, 1472794624, 1472794624, 1472794624, 1472794624, 1808338944, 1808338944, -10, 1456017408, -2134306816, -2134306816, 1456017408, 1456017408, 1456017408, -2033643520, -2033643520, 2143883264, -1983311872, -1983311872, -1966534656, -1882648576, -1983311872, -1899425792, -1882648576, -1899425792, 1456017408, -1832316928, -1781985280, -1832316928};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 852037632, 264835072, 248057856, -1, 214503424, -1, -1, -1, -1, -1, -1, -1, -1, -1, -204992512, -1, -1, -1, -1, -87552000, -1, -1, -406319104, -389541888, -1, 801705984, 801705984, -1, -456650752, -1, 147394560, -1, -104329216, -87552000, -87552000, 130617344, -1, -423096320, -1, -305655808, -322433024, -355987456, -339210240, 466161664, 63508480, -188215296, 164171776, -1, -1, -1, -372764672, -53997568, -1, -439873536, -1, -137883648, -121106432, -1, -1, -255324160, -238546944, 46731264, -1, -1, 189, 432607232, -1, 751374336, -1, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[182][];
        int[][] nArrayArray2 = new int[182][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[111] = new int[]{1, 2, 835260416};
        nArray2[111] = new int[]{-859238400, -842461184, -825683968};
        nArray[112] = new int[]{784928768};
        nArray2[112] = new int[]{-808906752};
        nArray[114] = new int[]{1741, 1742};
        nArray2[114] = new int[]{-792129536, -792129536};
        nArray[115] = new int[]{2, 1750, 1741, 1742, 2800};
        nArray2[115] = new int[]{1221201920, -775352320, -758575104, -758575104, 1237979136};
        nArray[117] = new int[]{1, 2, 751374336, 768151552};
        nArray2[117] = new int[]{-741797888, -725020672, -708243456, -691466240};
        nArray[118] = new int[]{2, 617156608, 868814848, 1741, 1742};
        nArray2[118] = new int[]{-674689024, -657911808, -641134592, -624357376, -624357376};
        nArray[119] = new int[]{1, 2, 1741, 1742, 29954048};
        nArray2[119] = new int[]{-607580160, -590802944, -574025728, -574025728, -557248512};
        nArray[120] = new int[]{1, 2};
        nArray2[120] = new int[]{1875447808, -540471296};
        nArray[121] = nArray[120];
        nArray2[121] = new int[]{1623789568, -523694080};
        nArray[122] = nArray[120];
        nArray2[122] = new int[]{281612288, -506916864};
        nArray[123] = new int[]{1, 2, 1507};
        nArray2[123] = new int[]{-2117529600, -490139648, -473362432};
        nArray[124] = new int[]{1};
        nArray2[124] = new int[]{-456585216};
        nArray[126] = new int[]{13176832};
        nArray2[126] = new int[]{-439808000};
        nArray[127] = new int[]{1507, 1741, 1742, 1644};
        nArray2[127] = new int[]{-423030784, -406253568, -406253568, -389476352};
        nArray[128] = new int[]{1, 46731264, 80285696, 801705984, -454027008, -355987456, 533270528, -70774784, 1103695872, 264835072, -506982400, 550047744, 852037632, 315166720, 650711040, -53997568, 63508480, 566824960, -605021952, -339210240, -372764672, 619780352};
        nArray2[128] = new int[]{-372699136, 399052800, 415830016, 2143883264, -1882648576, -490205184, 1506349056, 835260416, -1832316928, 986255360, -305655808, 1607012352, -2050420736, 852037632, 1858670592, 1003032576, 1674121216, 1573457920, 1825116160, -456650752, -439873536, -355921920};
        nArray[129] = nArray[123];
        nArray2[129] = new int[]{1036587008, -339144704, -322367488};
        nArray[130] = new int[]{1, 2, 1170804736};
        nArray2[130] = new int[]{-305590272, -288813056, -272035840};
        nArray[131] = new int[]{717819904};
        nArray2[131] = new int[]{-255258624};
        nArray[132] = new int[]{2, 1};
        nArray2[132] = new int[]{315166720, -238481408};
        nArray[133] = nArray[120];
        nArray2[133] = new int[]{-221704192, -204926976};
        nArray[134] = new int[]{-423096320};
        nArray2[134] = new int[]{-188149760};
        nArray[135] = new int[]{-406319104};
        nArray2[135] = new int[]{-171372544};
        nArray[136] = new int[]{1741, 1742, -389541888, 1187581952};
        nArray2[136] = new int[]{-154595328, -154595328, -137818112, -121040896};
        nArray[137] = nArray[135];
        nArray2[137] = new int[]{-104263680};
        nArray[138] = new int[]{1484, 1558, 1485, 1557, 1482, 1741, 1742, 1525, -13, 1483, 106, 105, 1750, 101, 1741, 102, 151};
        nArray2[138] = new int[]{-87486464, -70709248, -53932032, -37154816, -20377600, -3600384, -3600384, 13242368, 30019584, 46796800, 63574016, 80351232, 97128448, 113905664, 130682880, 147460096, 164237312};
        nArray[139] = nArray[114];
        nArray2[139] = new int[]{181014528, 181014528};
        nArray[140] = new int[]{180948992};
        nArray2[140] = new int[]{197791744};
        nArray[143] = new int[]{1, 2, 298389504, 449384448};
        nArray2[143] = new int[]{214568960, 231346176, 248123392, 264900608};
        nArray[144] = new int[]{214503424};
        nArray2[144] = new int[]{281677824};
        nArray[146] = new int[]{281612288, 248057856};
        nArray2[146] = new int[]{298455040, 315232256};
        nArray[147] = new int[]{499716096, 1120473088, 516493312};
        nArray2[147] = new int[]{332009472, 348786688, 365563904};
        nArray[148] = nArray[124];
        nArray2[148] = new int[]{382341120};
        nArray[149] = new int[]{-439873536, -456650752};
        nArray2[149] = new int[]{399118336, 415895552};
        nArray[150] = new int[]{1, 2, 1492};
        nArray2[150] = new int[]{432672768, 449449984, 466227200};
        nArray[152] = new int[]{-137883648, -154660864};
        nArray2[152] = new int[]{483004416, 499781632};
        nArray[153] = new int[]{-221769728, -204992512};
        nArray2[153] = new int[]{516558848, 533336064};
        nArray[154] = new int[]{-171438080, 1741, 1742, -188215296};
        nArray2[154] = new int[]{550113280, 566890496, 566890496, 583667712};
        nArray[155] = new int[]{1741, 1742, -121106432};
        nArray2[155] = new int[]{600444928, 600444928, 617222144};
        nArray[157] = new int[]{-3665920};
        nArray2[157] = new int[]{633999360};
        nArray[159] = new int[]{1, 2, 1741, 1742};
        nArray2[159] = new int[]{650776576, 667553792, 684331008, 684331008};
        nArray[160] = new int[]{2, 1, 2800};
        nArray2[160] = new int[]{-1547104256, 701108224, 1254756352};
        nArray[161] = nArray[120];
        nArray2[161] = new int[]{-1530327040, 717885440};
        nArray[162] = new int[]{1741, 1742, 382275584, 331943936};
        nArray2[162] = new int[]{734662656, 734662656, 751439872, 768217088};
        nArray[163] = new int[]{1741, 1742, 415830016, 432607232, 348721152};
        nArray2[163] = new int[]{784994304, 784994304, 801771520, 818548736, 835325952};
        nArray[164] = nArray[120];
        nArray2[164] = new int[]{852103168, 868880384};
        nArray[166] = nArray[124];
        nArray2[166] = new int[]{885657600};
        nArray[167] = new int[]{97062912};
        nArray2[167] = new int[]{902434816};
        nArray[168] = new int[]{130617344, 1741, 1742, 113840128};
        nArray2[168] = new int[]{919212032, 935989248, 935989248, 952766464};
        nArray[169] = nArray[124];
        nArray2[169] = new int[]{969543680};
        nArray[170] = nArray[114];
        nArray2[170] = new int[]{986320896, 986320896};
        nArray[171] = new int[]{-20443136, -37220352};
        nArray2[171] = new int[]{1003098112, 1019875328};
        nArray[174] = new int[]{1, 1741, 1742};
        nArray2[174] = new int[]{1036652544, 1053429760, 1053429760};
        nArray[175] = new int[]{1, 1137250304};
        nArray2[175] = new int[]{1070206976, 1086984192};
        nArray[178] = nArray[124];
        nArray2[178] = new int[]{1103761408};
        nArray[179] = new int[]{-1841164544};
        nArray2[179] = new int[]{1120538624};
        nArray[180] = nArray[123];
        nArray2[180] = new int[]{-1714876416, 1137315840, 1154093056};
        nArray[181] = nArray[150];
        nArray2[181] = new int[]{1170870272, 1187647488, 1204424704};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[182][];
        nArrayArray[111] = new int[]{298389504};
        nArrayArray[115] = new int[]{516493312};
        nArrayArray[125] = new int[]{331943936, 315166720};
        nArrayArray[127] = new int[]{348721152};
        nArrayArray[128] = new int[]{482938880};
        nArrayArray[130] = new int[]{415830016};
        nArrayArray[131] = new int[]{499716096};
        nArrayArray[136] = new int[]{449384448};
        nArrayArray[138] = new int[]{466161664};
        nArrayArray[143] = new int[]{432607232};
        nArrayArray[150] = new int[]{365498368};
        nArrayArray[160] = new int[]{533270528};
        nArrayArray[175] = new int[]{382275584};
        nArrayArray[181] = new int[]{399052800};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[182][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[182][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[182][];
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

