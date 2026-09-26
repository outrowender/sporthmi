/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

public class CarSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected CarSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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

    /*
     * Exception decompiling
     */
    protected void initStateFlagList() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op2rewriters.Op02RedundantStoreRewriter.removeOverwrittenStores(Op02RedundantStoreRewriter.java:92)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op2rewriters.Op02RedundantStoreRewriter.rewrite(Op02RedundantStoreRewriter.java:197)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:426)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private void initStateSuperstateList() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.ArrayIndexOutOfBoundsException
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private void initStateDHSList() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.ArrayIndexOutOfBoundsException
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[4178][];
        int[][] nArrayArray2 = new int[4178][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.initStateTrigger2(nArrayArray, nArrayArray2);
        this.initStateTrigger3(nArrayArray, nArrayArray2);
        this.initStateTrigger4(nArrayArray, nArrayArray2);
        this.initStateTrigger5(nArrayArray, nArrayArray2);
        this.initStateTrigger6(nArrayArray, nArrayArray2);
        this.initStateTrigger7(nArrayArray, nArrayArray2);
        this.initStateTrigger8(nArrayArray, nArrayArray2);
        this.initStateTrigger9(nArrayArray, nArrayArray2);
        this.initStateTrigger10(nArrayArray, nArrayArray2);
        this.initStateTrigger11(nArrayArray, nArrayArray2);
        this.initStateTrigger12(nArrayArray, nArrayArray2);
        this.initStateTrigger13(nArrayArray, nArrayArray2);
        this.initStateTrigger14(nArrayArray, nArrayArray2);
        this.initStateTrigger15(nArrayArray, nArrayArray2);
        this.initStateTrigger16(nArrayArray, nArrayArray2);
        this.initStateTrigger17(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[2] = new int[]{992479488, -853079808, -886634240, -903411456, -920188672, -869857024, -953743104, -383317760, -148371200, 136907008, 1741, 1742};
        nArray2[2] = new int[]{-819459840, 1026033920, -567867136, -551089920, -718862080, -517535488, -702084864, -500758272, -1087829760, -1373042432, -332920576, -332920576};
        nArray[3] = new int[]{-970520320, -316208896, -299431680, -1071183616, -1037629184, -1054406400, -987297536, -567867136, -1020851968, 1009256704, -1004074752, -282654464, 1260914944, 1741, 1742, 1193806080};
        nArray2[3] = new int[]{254281984, 271059200, -98105088, -1004074752, -987297536, -970520320, -953743104, -920188672, -903411456, -802682624, -886634240, -114882304, -316143360, -265811712, -265811712, -551024384};
        nArray[4] = new int[]{-752416512, -802748160, -819525376, -785970944, -769193728, 86509824, 1741, 1742, 1462241536};
        nArray2[4] = new int[]{724044032, -148436736, 489163008, -131659520, 371722496, 539494656, -249034496, -249034496, -14153472};
        nArray[5] = new int[]{1741, 1742};
        nArray2[5] = new int[]{1797785856, 1797785856};
        nArray[6] = new int[]{1741, 1742, 338233600};
        nArray2[6] = new int[]{1814563072, 1814563072, -651622144};
        nArray[7] = nArray[5];
        nArray2[7] = new int[]{1831340288, 1831340288};
        nArray[8] = nArray[5];
        nArray2[8] = new int[]{1848117504, 1848117504};
        nArray[9] = nArray[5];
        nArray2[9] = new int[]{1864894720, 1864894720};
        nArray[10] = new int[]{1741, 1742, -551089920, -534312704, 1277692160};
        nArray2[10] = new int[]{1881671936, 1881671936, -836302592, -819525376, -299366144};
        nArray[12] = nArray[5];
        nArray2[12] = new int[]{1898449152, 1898449152};
        nArray[13] = nArray[5];
        nArray2[13] = new int[]{1915226368, 1915226368};
        nArray[14] = new int[]{1741, 1742, -198768384, 1378355456};
        nArray2[14] = new int[]{1932003584, 1932003584, 287836416, -114816768};
        nArray[15] = nArray[5];
        nArray2[15] = new int[]{1948780800, 1948780800};
        nArray[16] = new int[]{-584644352, 1741, 1742};
        nArray2[16] = new int[]{-752416512, 1965558016, 1965558016};
        nArray[17] = new int[]{1741, 1742, 1210583296};
        nArray2[17] = new int[]{1982335232, 1982335232, -534247168};
        nArray[18] = nArray[5];
        nArray2[18] = new int[]{1999112448, 1999112448};
        nArray[21] = nArray[5];
        nArray2[21] = new int[]{2015889664, 2015889664};
        nArray[22] = nArray[5];
        nArray2[22] = new int[]{2032666880, 2032666880};
        nArray[23] = nArray[5];
        nArray2[23] = new int[]{2049444096, 2049444096};
        nArray[24] = nArray[5];
        nArray2[24] = new int[]{2066221312, 2066221312};
        nArray[25] = new int[]{-165213952, 1741, 1742, -181991168};
        nArray2[25] = new int[]{321390848, 2082998528, 2082998528, 338168064};
        nArray[26] = new int[]{-450426624, -467203840, -433649408, -483981056, 1741, 1742};
        nArray2[26] = new int[]{-651753216, -634976000, -618198784, -601421568, -1423439616, -1423439616};
        nArray[27] = new int[]{-148436736, -366540544, -131659520, 1741, 1742};
        nArray2[27] = new int[]{405276928, 388499712, 807930112, -232257280, -232257280};
        nArray[29] = new int[]{1741, 1742, 1932003584, 1965558016, 1948780800};
        nArray2[29] = new int[]{2099775744, 2099775744, 1378420992, 1395198208, 1411975424};
        nArray[30] = new int[]{-416872192, 1741, 1742};
        nArray2[30] = new int[]{-400094976, 2116552960, 2116552960};
        nArray[31] = new int[]{1741};
        nArray2[31] = new int[]{0x22290900};
        nArray[32] = new int[]{1741, 1742, 1848117504};
        nArray2[32] = new int[]{-2144859904, -2144859904, 1244203264};
        nArray[33] = new int[]{-400094976, 1741, 1742};
        nArray2[33] = new int[]{-366540544, -2128082688, -2128082688};
        nArray[34] = nArray[5];
        nArray2[34] = new int[]{-2111305472, -2111305472};
        nArray[36] = new int[]{1, 2, 1741, 1742, 388565248, 405342464};
        nArray2[36] = new int[]{1042811136, 1059588352, -2094528256, -2094528256, -550958848, -534181632};
        nArray[38] = new int[]{1741, 1742, 1512573184, 1713899776};
        nArray2[38] = new int[]{271124736, 271124736, -903280384, 942213376};
        nArray[39] = new int[]{-349763328};
        nArray2[39] = new int[]{-215545600};
        nArray[40] = new int[]{1741, 1742, 1177028864};
        nArray2[40] = new int[]{-2077751040, -2077751040, -567801600};
        nArray[43] = nArray[5];
        nArray2[43] = new int[]{-2060973824, -2060973824};
        nArray[44] = nArray[5];
        nArray2[44] = new int[]{-2044196608, -2044196608};
        nArray[45] = nArray[5];
        nArray2[45] = new int[]{-2027419392, -2027419392};
        nArray[47] = new int[]{1, 1741, 1742};
        nArray2[47] = new int[]{136907008, -2010642176, -2010642176};
        nArray[49] = new int[]{1, 2, 1741, 1742, 1741};
        nArray2[49] = new int[]{-1071183616, -1054275328, -1809315584, -1809315584, 170461440};
        nArray[50] = new int[]{1, 1741, 1742, 1093142784, 1042811136, 1076365568, 1109920000, 1026033920, 1059588352, 287901952, 1126697216};
        nArray2[50] = new int[]{-47773440, -81327872, -81327872, -769128192, -752350976, -735573760, -718796544, -702019328, -685242112, -701953792, 1193871616};
        nArray[51] = new int[]{1, 52955392, 1741, 1742, 19400960, 36178176};
        nArray2[51] = new int[]{-30996224, 690489600, -735639296, -735639296, 556271872, 573049088};
        nArray[54] = nArray[5];
        nArray2[54] = new int[]{36178176, 36178176};
        nArray[55] = new int[]{1};
        nArray2[55] = new int[]{52955392};
        nArray[56] = new int[]{1741, 1742, 1487, -13};
        nArray2[56] = new int[]{69732608, 69732608, 86509824, 103287040};
        nArray[57] = nArray[55];
        nArray2[57] = new int[]{120064256};
        nArray[58] = new int[]{-13, 1487, 1741, 1742};
        nArray2[58] = new int[]{136841472, 153618688, 170395904, 170395904};
        nArray[59] = nArray[55];
        nArray2[59] = new int[]{187173120};
        nArray[61] = new int[]{-215545600, 1741, 1742};
        nArray2[61] = new int[]{304613632, -1993864960, -1993864960};
        nArray[62] = nArray[5];
        nArray2[62] = new int[]{-1977087744, -1977087744};
        nArray[63] = nArray[5];
        nArray2[63] = new int[]{-1960310528, -1960310528};
        nArray[64] = nArray[55];
        nArray2[64] = new int[]{-651687680};
        nArray[65] = nArray[5];
        nArray2[65] = new int[]{-1406662400, -1406662400};
        nArray[66] = nArray[5];
        nArray2[66] = new int[]{-1943533312, -1943533312};
        nArray[67] = new int[]{1741, 1742, 522782976, 472451328, 506005760, 489228544};
        nArray2[67] = new int[]{-1926756096, -1926756096, -383186688, -366409472, -1893136128, -1876358912};
        nArray[68] = nArray[5];
        nArray2[68] = new int[]{-1909978880, -1909978880};
        nArray[69] = nArray[5];
        nArray2[69] = new int[]{-1893201664, -1893201664};
        nArray[70] = nArray[5];
        nArray2[70] = new int[]{-1876424448, -1876424448};
        nArray[71] = nArray[5];
        nArray2[71] = new int[]{-1859647232, -1859647232};
        nArray[72] = new int[]{-64550656, 1741, 1742, -98105088, -114882304, -81327872};
        nArray2[72] = new int[]{422054144, -1842870016, -1842870016, 438831360, 455608576, 472385792};
        nArray[73] = new int[]{-14219008, -30996224, 69732608, 1741, 1742};
        nArray2[73] = new int[]{589826304, 505940224, 606603520, -1826092800, -1826092800};
        nArray[74] = new int[]{1764231424};
        nArray2[74] = new int[]{1109985536};
        nArray[75] = new int[]{1741, 1742, -47773440};
        nArray2[75] = new int[]{-1792538368, -1792538368, 522717440};
        nArray[76] = new int[]{1741, 1742, 2623744};
        nArray2[76] = new int[]{-1775761152, -1775761152, 707266816};
        nArray[77] = new int[]{2, 103287040, 136841472, 120064256};
        nArray2[77] = new int[]{-1440216832, 640157952, 656935168, 673712384};
        nArray[78] = new int[]{1741, 1742, 1479018752};
        nArray2[78] = new int[]{-1758983936, -1758983936, 220793088};
        nArray[79] = new int[]{1741, 1742, 1579682048};
        nArray2[79] = new int[]{-1742206720, -1742206720, 556337408};
        nArray[80] = nArray[5];
        nArray2[80] = new int[]{-1725429504, -1725429504};
        nArray[81] = nArray[5];
        nArray2[81] = new int[]{-1708652288, -1708652288};
        nArray[83] = new int[]{757598464, -1874718976, 1741, 1742};
        nArray2[83] = new int[]{-1473771264, -869725952, -282588928, -282588928};
        nArray[84] = nArray[47];
        nArray2[84] = new int[]{791152896, 237504768, 237504768};
        nArray[85] = nArray[5];
        nArray2[85] = new int[]{-1691875072, -1691875072};
        nArray[88] = nArray[5];
        nArray2[88] = new int[]{-1641543424, -1641543424};
        nArray[91] = nArray[5];
        nArray2[91] = new int[]{-1591211776, -1591211776};
        nArray[94] = nArray[5];
        nArray2[94] = new int[]{-1540880128, -1540880128};
        nArray[97] = new int[]{187173120, 237504768, 220727552, 1741, 1742, 203950336};
        nArray2[97] = new int[]{958925056, 975702272, 992479488, -1490548480, -1490548480, 1009256704};
        nArray[98] = new int[]{505940224, 1741};
        nArray2[98] = new int[]{1193806080, -517469952};
        nArray[99] = new int[]{455608576, 489163008, 472385792};
        nArray2[99] = new int[]{1210583296, 1227360512, 1244137728};
        nArray[100] = new int[]{539494656, 1741, 1742};
        nArray2[100] = new int[]{1260914944, 1445529856, 1445529856};
        nArray[101] = nArray[5];
        nArray2[101] = new int[]{1277692160, 1277692160};
        nArray[102] = new int[]{656935168, 1741, 1742, 271124736};
        nArray2[102] = new int[]{1411909888, 1428687104, 1428687104, -953612032};
        nArray[103] = new int[]{-467138304};
        nArray2[103] = new int[]{1730742528};
        nArray[104] = new int[]{1741, 1742, 791152896};
        nArray2[104] = new int[]{1512573184, 1512573184, -1356330752};
        nArray[105] = new int[]{707266816, -349697792, -366475008};
        nArray2[105] = new int[]{1546127616, 1864960256, 1881737472};
        nArray[106] = new int[]{690489600, 1741, -483915520};
        nArray2[106] = new int[]{1562904832, 1428752640, 1713965312};
        nArray[108] = nArray[5];
        nArray2[108] = new int[]{-131593984, -131593984};
        nArray[112] = new int[]{422054144, 1741, 1742, 438831360, 355010816};
        nArray2[112] = new int[]{1093142784, 1109920000, 1109920000, 1126697216, -601290496};
        nArray[114] = new int[]{1, 2, 589826304, -30930688};
        nArray2[114] = new int[]{1328023808, 1613236480, 1495795968, -1775695616};
        nArray[115] = new int[]{573049088};
        nArray2[115] = new int[]{1378355456};
        nArray[116] = new int[]{1, 2, 1741, 1742, 1227360512};
        nArray2[116] = new int[]{1143474432, 1395132672, 1177028864, 1177028864, -416806656};
        nArray[117] = new int[]{2, 1741, 1742, 673712384};
        nArray2[117] = new int[]{1630013696, 1663568128, 1663568128, 1680345344};
        nArray[118] = new int[]{2, 522717440, -383252224, 573049088, 623380736};
        nArray2[118] = new int[]{1344801024, 1361578240, 1848183040, 1479018752, 1697122560};
        nArray[119] = new int[]{1, 2};
        nArray2[119] = new int[]{1713899776, 1730676992};
        nArray[120] = nArray[55];
        nArray2[120] = new int[]{1747454208};
        nArray[121] = new int[]{1741, 1742, 740821248};
        nArray2[121] = new int[]{-148305664, -148305664, 1764231424};
        nArray[122] = nArray[31];
        nArray2[122] = new int[]{187238656};
        nArray[123] = new int[]{1741, 1742, 405276928};
        nArray2[123] = new int[]{-1339553536, -1339553536, -1322776320};
        nArray[124] = new int[]{1, 573049088};
        nArray2[124] = new int[]{-1389885184, 657000704};
        nArray[125] = nArray[123];
        nArray2[125] = new int[]{-1305999104, -1305999104, -1289221888};
        nArray[126] = nArray[124];
        nArray2[126] = new int[]{-1373107968, 673777920};
        nArray[127] = new int[]{975702272};
        nArray2[127] = new int[]{-853014272};
        nArray[129] = new int[]{841484544};
        nArray2[129] = new int[]{-1188558592};
        nArray[130] = nArray[119];
        nArray2[130] = new int[]{-1272444672, 1294534912};
        nArray[131] = new int[]{2, 1, 2800};
        nArray2[131] = new int[]{-1238890240, 136972544, 153749760};
        nArray[134] = new int[]{1, 2, 908593408, 1741, 1742, -198702848, 1999112448};
        nArray2[134] = new int[]{1546193152, 1596524800, 1361643776, 204015872, 204015872, -1960244992, 1562970368};
        nArray[136] = new int[]{1741, 1742, 1613236480, 1328023808, 1596459264};
        nArray2[136] = new int[]{-1004009216, -1004009216, 589891840, -181925632, 606669056};
        nArray[137] = new int[]{1, 2007, 1747454208};
        nArray2[137] = new int[]{-987232000, -114751232, 1026099456};
        nArray[139] = nArray[55];
        nArray2[139] = new int[]{-936900352};
        nArray[140] = new int[]{1730676992, 975702272, 925370624, 1741, 1742};
        nArray2[140] = new int[]{1009322240, -836237056, -886568704, -869791488, -869791488};
        nArray[141] = nArray[5];
        nArray2[141] = new int[]{1160317184, 1160317184};
        nArray[142] = nArray[5];
        nArray2[142] = new int[]{-584578816, -584578816};
        nArray[143] = nArray[55];
        nArray2[143] = new int[]{-785905408};
        nArray[144] = new int[]{1680345344};
        nArray2[144] = new int[]{757664000};
        nArray[152] = nArray[55];
        nArray2[152] = new int[]{-634910464};
        nArray[153] = new int[]{1750, 1741, -30930688};
        nArray2[153] = new int[]{-618133248, -601356032, 86640896};
        nArray[154] = nArray[5];
        nArray2[154] = new int[]{-400029440, -400029440};
        nArray[155] = nArray[55];
        nArray2[155] = new int[]{-383252224};
        nArray[157] = new int[]{-148371200, 1741, 1742};
        nArray2[157] = new int[]{-1943467776, 1177094400, 1177094400};
        nArray[163] = new int[]{1881671936, 1741, 1742, 1344801024};
        nArray2[163] = new int[]{1328089344, 1344866560, 1344866560, 53020928};
        nArray[164] = new int[]{1395132672};
        nArray2[164] = new int[]{69798144};
        nArray[165] = new int[]{1741, 1742, 1797785856};
        nArray2[165] = new int[]{103352576, 103352576, 1143539968};
        nArray[167] = new int[]{1, 2, 925501696};
        nArray2[167] = new int[]{958990592, 925436160, -165082880};
        nArray[170] = new int[]{455674112};
        nArray2[170] = new int[]{-399963904};
        nArray[172] = nArray[5];
        nArray2[172] = new int[]{623446272, 623446272};
        nArray[173] = nArray[5];
        nArray2[173] = new int[]{640223488, 640223488};
        nArray[174] = new int[]{1244137728, 1646790912};
        nArray2[174] = new int[]{-349697792, 0x29290900};
        nArray[175] = new int[]{1, 1741, 1742, 1697122560};
        nArray2[175] = new int[]{975767808, -215480064, -215480064, 908658944};
        nArray[176] = new int[]{1, 1741, 1742, 1529350400};
        nArray2[176] = new int[]{992545024, 304679168, 304679168, 321456384};
        nArray[177] = new int[]{1, 1741, 1742, 321456384, 1781008640};
        nArray2[177] = new int[]{1126762752, 1059653888, 1059653888, -668399360, 1093208320};
        nArray[178] = new int[]{1680345344, 1864894720, 1741, 1741, 1742, 2800};
        nArray2[178] = new int[]{740886784, 1277757696, 1260980480, 438896896, 438896896, 36309248};
        nArray[179] = nArray[119];
        nArray2[179] = new int[]{1311312128, -1255667456};
        nArray[183] = new int[]{1596459264, 1741, 1742, 1613236480};
        nArray2[183] = new int[]{-1826027264, 1613302016, 1613302016, -1809250048};
        nArray[184] = new int[]{1741, 1742, 2032666880};
        nArray2[184] = new int[]{1630079232, 1630079232, 1579747584};
        nArray[191] = new int[]{-450361088, -433583872, 1741, 1742};
        nArray2[191] = new int[]{1747519744, 1781074176, 1764296960, 1764296960};
        nArray[195] = new int[]{1, 2, 1492};
        nArray2[195] = new int[]{1915291904, 1932069120, 1948846336};
        nArray[196] = new int[]{1, 2, 1507};
        nArray2[196] = new int[]{1965623552, 1982400768, 1999177984};
        nArray[199] = new int[]{1741, 1742, -332920576};
        nArray2[199] = new int[]{-2128017152, -2128017152, 2083064064};
        nArray[200] = new int[]{942278912};
        nArray2[200] = new int[]{-97974016};
        nArray[203] = new int[]{1, -282588928};
        nArray2[203] = new int[]{2133395712, -2111239936};
    }

    private void initStateTrigger2(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger3(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger4(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger5(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger6(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger7(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger8(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger9(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger10(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger11(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger12(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger13(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger14(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger15(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger16(int[][] nArray, int[][] nArray2) {
    }

    private void initStateTrigger17(int[][] nArray, int[][] nArray2) {
        nArray[4109] = new int[]{-64485120, 422119680};
        nArray2[4109] = new int[]{-483849984, -467072768};
        nArray[4112] = new int[]{422119680};
        nArray2[4112] = new int[]{-450295552};
        nArray[4115] = nArray[5];
        nArray2[4115] = new int[]{-1792472832, -1792472832};
        nArray[4116] = new int[]{1750};
        nArray2[4116] = new int[]{-920057600};
        nArray[4121] = nArray[55];
        nArray2[4121] = new int[]{-718731008};
        nArray[4122] = new int[]{1, 2, 1741, 1742, 19466496};
        nArray2[4122] = new int[]{-1540814592, -1524037376, -1624700672, -1624700672, -1607923456};
        nArray[4124] = nArray[55];
        nArray2[4124] = new int[]{-1675032320};
        nArray[4125] = new int[]{53020928, -14153472, 0x2290900};
        nArray2[4125] = new int[]{-1591146240, -1574369024, -1557591808};
        nArray[4128] = new int[]{1, -30930688, 254347520};
        nArray2[4128] = new int[]{-1305933568, -198637312, -970389248};
        nArray[4129] = new int[]{120129792};
        nArray2[4129] = new int[]{-1456928512};
        nArray[4130] = new int[]{1, 220793088, 204015872, 371788032};
        nArray2[4130] = new int[]{-1171715840, -1138161408, -1104606976, -567736064};
        nArray[4131] = nArray[119];
        nArray2[4131] = new int[]{-1406596864, -1356265216};
        nArray[4134] = new int[]{975833344};
        nArray2[4134] = new int[]{-30865152};
        nArray[4135] = new int[]{-416806656};
        nArray2[4135] = new int[]{-1238824704};
        nArray[4136] = new int[]{-400029440};
        nArray2[4136] = new int[]{-1222047488};
        nArray[4140] = nArray[5];
        nArray2[4140] = new int[]{-1071052544, -1071052544};
        nArray[4141] = new int[]{1741, 1742, 237570304};
        nArray2[4141] = new int[]{-987166464, -987166464, -1020720896};
        nArray[4143] = new int[]{1, 2, 2800, 1492};
        nArray2[4143] = new int[]{-852948736, -735508224, 69863680, -802617088};
        nArray[4145] = nArray[196];
        nArray2[4145] = new int[]{-785839872, -769062656, -752285440};
        nArray[4150] = nArray[4116];
        nArray2[4150] = new int[]{-584513280};
        nArray[4151] = new int[]{-64485120};
        nArray2[4151] = new int[]{-517404416};
        nArray[4160] = new int[]{1, 1680345344};
        nArray2[4160] = new int[]{-332855040, -232191744};
        nArray[4166] = new int[]{889921536, 1741, 1742, 873144320};
        nArray2[4166] = new int[]{-316077824, -248968960, -248968960, -299300608};
        nArray[4167] = new int[]{1, 1741, 1742, -618198784, -634976000, -668530432, -232322816, -651753216, -299366144, 106, 1574, -1874718976, 1831340288, 1578, 1570, 1571, 738926592, -165148416, 0x290900, -500692736, 0x9290900, 1495795968, -534247168, 1587, 1411909888, 1294469376, 1944, -316143360, 1814563072, 153618688, -517469952, -685307648, 1567, 170461440, -131593984, 774375680};
        nArray2[4167] = new int[]{-64550656, 774375680, 774375680, -1054406400, -584644352, -1037629184, -1071118080, -1020851968, -1473705728, -349632256, -500692736, 1898514688, 1227426048, -483915520, -467138304, -450361088, -1993799424, -1440151296, -1725363968, -1423374080, -1339488000, 237570304, -1272379136, -366475008, -64485120, -198702848, 858327296, 2066286848, 1210648832, 0x9290900, -1255601920, 338233600, 355010816, -1322710784, -1926690560, -1456994048};
        nArray[4171] = new int[]{1741, 1742, 959056128};
        nArray2[4171] = new int[]{-81196800, -81196800, -64419584};
        nArray[4172] = nArray[5];
        nArray2[4172] = new int[]{-47642368, -47642368};
        nArray[4173] = new int[]{1741, 1742, 992610560};
        nArray2[4173] = new int[]{-14087936, -14087936, 2754816};
        nArray[4174] = nArray[5];
        nArray2[4174] = new int[]{19532032, 19532032};
        nArray[4175] = new int[]{2800};
        nArray2[4175] = new int[]{103418112};
        nArray[4176] = nArray[4175];
        nArray2[4176] = new int[]{120195328};
        nArray[4177] = new int[]{1, 2, 1741, 1742, 1326252800, 824707328, 807930112, 858261760};
        nArray2[4177] = new int[]{-1222113024, 170526976, -1205335808, -1205335808, -1087895296, -1171781376, -1155004160, -1104672512};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[4178][];
        nArrayArray[14] = new int[]{-634976000};
        nArrayArray[38] = new int[]{-383317760};
        nArrayArray[77] = new int[]{-1071183616};
        nArrayArray[78] = new int[]{-500758272};
        nArrayArray[79] = new int[]{-467203840};
        nArrayArray[114] = new int[]{-1004074752, -198768384};
        nArrayArray[115] = new int[]{-1037629184};
        nArrayArray[116] = new int[]{-651753216};
        nArrayArray[117] = new int[]{-920188672};
        nArrayArray[118] = new int[]{-1020851968, -987297536};
        nArrayArray[121] = new int[]{-853079808};
        nArrayArray[124] = new int[]{-450426624};
        nArrayArray[126] = new int[]{-433649408};
        nArrayArray[127] = new int[]{-685307648};
        nArrayArray[131] = new int[]{170395904};
        nArrayArray[134] = new int[]{-282654464};
        nArrayArray[137] = new int[]{-366540544};
        nArrayArray[140] = new int[]{-668530432};
        nArrayArray[153] = new int[]{120064256};
        nArrayArray[165] = new int[]{-517535488};
        nArrayArray[167] = new int[]{52955392};
        nArrayArray[170] = new int[]{19400960};
        nArrayArray[174] = new int[]{-416872192};
        nArrayArray[175] = new int[]{-400094976};
        nArrayArray[177] = new int[]{-30996224, -349763328};
        nArrayArray[178] = new int[]{69732608};
        nArrayArray[195] = new int[]{-265877248};
        nArrayArray[203] = new int[]{-249100032};
        nArrayArray[4122] = new int[]{-165213952};
        nArrayArray[4125] = new int[]{-181991168};
        nArrayArray[4128] = new int[]{36178176, -64550656};
        nArrayArray[4129] = new int[]{-114882304};
        nArrayArray[4130] = new int[]{-14219008};
        nArrayArray[4143] = new int[]{103287040, -47773440};
        nArrayArray[4167] = new int[]{-836302592, -215545600};
        nArrayArray[4175] = new int[]{136841472};
        nArrayArray[4176] = new int[]{153618688};
        nArrayArray[4177] = new int[]{-769193728, -802748160, -819525376, -785970944};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[4178][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[4178][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[4178][];
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

