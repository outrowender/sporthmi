/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

public class TVSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TVSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{1, 15, 0, 9, 6, 1, 7, 9, 0, 6, 1, 0, 9, 0, 6, 593, 9, 9, 9, 0, 0, 1, 1, 1, 1, 9, 1, 0, 6, 6, 6, 0, 0, 6, 6, 0, 49, 15, 0, 6, 7, 7, 15, 593, 593, 5, 10, 0, 1, 0, 257, 0, 0, 0, 0, 0, 7, 0, 8, 0, 0, 0, 0, 8, 7, 7, 271, 0, 9, 0, 6, 0, 257, 593, 0, 0, 0, 0, 593, 257, 0, 0, 0, 9, 1, 0, 15, 9, 7, 1, 593, 0, 9, 593, 89, 15, 0, 0, 1, 53, 0, 9, 0, 0, 9, 0, 9, 0, 9};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{1689003776, 1772889856, -1, 1689003776, -2119424256, -2119424256, -1632884992, 1185687296, 1202464512, 1202464512, 1185687296, 1470899968, 1185687296, 1286350592, 1286350592, -1750325504, 1487677184, 1487677184, 1185687296, -1, -1, 1487677184, 1185687296, 1252796160, 1252796160, 1185687296, 1487677184, 1353459456, 1370236672, 1387013888, 1923884800, -1884543232, 1437345536, 1454122752, 1504454400, 1521231616, -1632884992, -1800657152, -2136201472, 1756112640, 1085024000, 1085024000, 1772889856, 1839998720, -2001983744, 1168910080, 1839998720, -1, -2001983744, 1923884800, -10, 1923884800, 2024548096, 2024548096, 2024548096, 1890330368, 1890330368, 1890330368, -1767102720, -1, -1, -1, 1101801216, 1789667072, 1135355648, 1135355648, -10, -1, 1772889856, -2069092608, -1431558400, -1, -10, -1716771072, -1, -1548998912, -1548998912, -1548998912, -1398003968, -10, -1817434368, -1817434368, -1817434368, -1884543232, -2136201472, 1705780992, 1168910080, 1185687296, -1, 1185687296, -1398003968, -1, 1185687296, -1666439424, -2102647040, -2102647040, -1616107776, -1, -1632884992, -1733548288, -1515444480, 1487677184, -1465112832, -1465112832, 1353459456, -1515444480, -2069092608, -1431558400, 1185687296};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1817434368, -1, -1, -1, -1817434368, 1286350592, -1, 1437345536, -1, -1817434368, 1655449344, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1621894912, 1638672128, 1269573376, 1454122752, 1873553152, 1605117696, 1722558208, 1420568320, 1588340480, 1085024000, -1, -1817434368, 1370236672, -1, -1, -1, -1, -1, -1, 1252796160, -1, -1, 1470899968, -1, 1487677184, 1538008832, 1554786048, 1571563264, 1504454400, -1, 1521231616, 1168910080, -1, -1, -1, 1185687296, 1789667072, -1, -1, -1, -1, -1, 1219241728, 1236018944, -1, -1, -1, -1, 1336682240, 1353459456, 1839998720, -1, -1, 1890330368, 1923884800, 1907107584, -1, -1, 1387013888, -1, -1, -1, -1, -1, -1, -1, -1, 1689003776, -1, -1834211584, -1, -1, -1951652096, -1800657152, -1, 1236018944, -1817434368, -1, -1817434368, -1, -1817434368, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[109][];
        int[][] nArrayArray2 = new int[109][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[0] = new int[]{1, -2136201472, 1085024000};
        nArray2[0] = new int[]{1504454400, -559143168, 1085024000};
        nArray[1] = new int[]{1, 1286350592};
        nArray2[1] = new int[]{-1347672320, 179119872};
        nArray[3] = new int[]{1, 2, -1649662208, -1632884992, 1741, 1742, 1118578432, 1839998720, 1672226560, 1286350592, 1269573376, 1907107584};
        nArray2[3] = new int[]{1118578432, 1135355648, 715990784, 447555328, 1152132864, 1152132864, 1202464512, -1263786240, -1985206528, 1219241728, 1236018944, -1062459648};
        nArray[5] = new int[]{1, 2};
        nArray2[5] = new int[]{-1247009024, -1230231808};
        nArray[6] = new int[]{2, -1683216640, 1750};
        nArray2[6] = new int[]{1185687296, 564995840, -1683216640};
        nArray[7] = new int[]{1, 2, 1741, 1742, -1649662208, 1269573376};
        nArray2[7] = new int[]{1319905024, 1336682240, 1353459456, 1353459456, 346892032, 1370236672};
        nArray[10] = new int[]{1, 2, -1213454592, 1252796160, 1168910080, 1236018944, 1741, 1742, 1202464512};
        nArray2[10] = new int[]{1387013888, 1403791104, 732768000, 1689003776, 1605117696, 1672226560, 1420568320, 1420568320, 1621894912};
        nArray[12] = nArray[7];
        nArray2[12] = new int[]{1437345536, 1454122752, 1470899968, 1470899968, 363669248, 1487677184};
        nArray[15] = new int[]{1, 2, 1507};
        nArray2[15] = new int[]{1705780992, -357816576, -290707712};
        nArray[16] = new int[]{1, 2, 1741, 1742, -1683216640};
        nArray2[16] = new int[]{1739335424, 1756112640, 1772889856, 1772889856, 850208512};
        nArray[17] = new int[]{1, 2, -1683216640, 1741, 1742, -1649662208};
        nArray2[17] = new int[]{1789667072, 1806444288, 665659136, -1465112832, -1465112832, 1823221504};
        nArray[18] = new int[]{1, 2, -1649662208, 1741, 1742};
        nArray2[18] = new int[]{1839998720, 1856775936, 380446464, 1873553152, 1873553152};
        nArray[21] = new int[]{1, 2, 1741, 1742};
        nArray2[21] = new int[]{1990993664, 2007770880, 2024548096, 2024548096};
        nArray[22] = nArray[21];
        nArray2[22] = new int[]{2041325312, 2058102528, 2074879744, 2074879744};
        nArray[23] = new int[]{1};
        nArray2[23] = new int[]{2091656960};
        nArray[24] = new int[]{2};
        nArray2[24] = new int[]{2108434176};
        nArray[25] = new int[]{1, 2, 1741, 1742, -1649662208};
        nArray2[25] = new int[]{2125211392, 2141988608, -2136201472, -2136201472, 397223680};
        nArray[26] = nArray[21];
        nArray2[26] = new int[]{-2119424256, -2102647040, -2085869824, -2085869824};
        nArray[27] = new int[]{-1196677376};
        nArray2[27] = new int[]{833431296};
        nArray[30] = new int[]{1336682240};
        nArray2[30] = new int[]{-1968429312};
        nArray[31] = new int[]{2125211392, 2091656960, 2108434176, 1741, 1742};
        nArray2[31] = new int[]{-710138112, -693360896, -676583680, 1974216448, 1974216448};
        nArray[36] = new int[]{1, 1605117696};
        nArray2[36] = new int[]{-2001983744, -2018760960};
        nArray[40] = nArray[23];
        nArray2[40] = new int[]{-1918097664};
        nArray[41] = new int[]{1, -1716771072};
        nArray2[41] = new int[]{-1901320448, -5495040};
        nArray[42] = new int[]{1, 1286350592, -2052315392};
        nArray2[42] = new int[]{-1330895104, 195897088, -374593792};
        nArray[43] = nArray[5];
        nArray2[43] = new int[]{-1884543232, -1867766016};
        nArray[44] = nArray[5];
        nArray2[44] = new int[]{-1850988800, -1834211584};
        nArray[45] = nArray[5];
        nArray2[45] = new int[]{-1817434368, -1213454592};
        nArray[46] = new int[]{1135355648, 1722558208};
        nArray2[46] = new int[]{-1767102720, -458479872};
        nArray[48] = nArray[21];
        nArray2[48] = new int[]{-1666439424, -1649662208, -1565776128, -1565776128};
        nArray[49] = new int[]{1739335424};
        nArray2[49] = new int[]{-1733548288};
        nArray[50] = new int[]{2, 1, 1741, 1742};
        nArray2[50] = new int[]{-1716771072, 1890330368, 1923884800, 1923884800};
        nArray[51] = new int[]{1756112640};
        nArray2[51] = new int[]{-1699993856};
        nArray[52] = nArray[30];
        nArray2[52] = new int[]{-1616107776};
        nArray[53] = nArray[30];
        nArray2[53] = new int[]{-1599330560};
        nArray[54] = nArray[51];
        nArray2[54] = new int[]{-1582553344};
        nArray[55] = new int[]{1319905024, 1303127808};
        nArray2[55] = new int[]{-1548998912, -1532221696};
        nArray[56] = nArray[21];
        nArray2[56] = new int[]{-1515444480, -1498667264, -1481890048, -1481890048};
        nArray[57] = new int[]{-2119424256, 1741, 1742};
        nArray2[57] = new int[]{-542365952, -1632884992, -1632884992};
        nArray[58] = new int[]{-2102647040, -2069092608};
        nArray2[58] = new int[]{-525588736, -391371008};
        nArray[63] = new int[]{2800};
        nArray2[63] = new int[]{1001203456};
        nArray[66] = new int[]{2, 1, -1874718976, -1699993856, 1454122752, 1353459456, 1538008832, 2007770880, 1487677184, -2129853696, 1437345536, 1554786048, 1470899968, 1504454400, 1521231616, -1616107776};
        nArray2[66] = new int[]{-1314117888, 1101801216, 212674304, 11347712, 1286350592, 1588340480, -592697600, -894687488, 1252796160, 581773056, 1571563264, 1269573376, 1554786048, 1538008832, -341039360, 464332544};
        nArray[68] = new int[]{1, 2, -1683216640};
        nArray2[68] = new int[]{-1196677376, -1179900160, 145565440};
        nArray[69] = new int[]{1741, 1742, 1101801216};
        nArray2[69] = new int[]{-1163122944, -1163122944, -1146345728};
        nArray[70] = new int[]{1873553152};
        nArray2[70] = new int[]{-1112791296};
        nArray[72] = new int[]{2, 1};
        nArray2[72] = new int[]{-911464704, -1750325504};
        nArray[73] = nArray[5];
        nArray2[73] = new int[]{-877910272, -39049472};
        nArray[75] = new int[]{2041325312, 1152132864};
        nArray2[75] = new int[]{-743692544, -760469760};
        nArray[76] = new int[]{1741, 1742};
        nArray2[76] = new int[]{682436352, 682436352};
        nArray[77] = nArray[76];
        nArray2[77] = new int[]{699213568, 699213568};
        nArray[78] = nArray[5];
        nArray2[78] = new int[]{-659806464, -575920384};
        nArray[79] = nArray[72];
        nArray2[79] = new int[]{-643029248, 1940662016};
        nArray[83] = new int[]{2141988608, -2102647040, 1741, 1742, 1269573376};
        nArray2[83] = new int[]{-626252032, -424925440, -609474816, -609474816, -408148224};
        nArray[84] = nArray[5];
        nArray2[84] = new int[]{-508811520, -492034304};
        nArray[85] = new int[]{-2102647040};
        nArray2[85] = new int[]{-475257088};
        nArray[87] = new int[]{1, 2, -2035538176};
        nArray2[87] = new int[]{-324262144, 1722558208, -307484928};
        nArray[88] = new int[]{1, 1741, 1742, 2058102528};
        nArray2[88] = new int[]{-240376064, -794024192, -794024192, -777246976};
        nArray[89] = nArray[5];
        nArray2[89] = new int[]{-22272256, -861133056};
        nArray[90] = nArray[5];
        nArray2[90] = new int[]{28124928, 44902144};
        nArray[92] = new int[]{1, 2, 1492};
        nArray2[92] = new int[]{229451520, 246228736, 263005952};
        nArray[93] = new int[]{1, 2, 1507, 1741, 1742};
        nArray2[93] = new int[]{279783168, 296560384, 313337600, 330114816, 330114816};
        nArray[94] = new int[]{1, 1722558208, -2001983744, 1990993664, 1890330368, 1689003776};
        nArray2[94] = new int[]{615327488, -1934874880, 531441408, -945019136, -1079236864, -1951652096};
        nArray[95] = new int[]{1, 2, -1616107776};
        nArray2[95] = new int[]{481109760, 497886976, 514664192};
        nArray[98] = nArray[5];
        nArray2[98] = new int[]{632104704, 648881920};
        nArray[100] = new int[]{-1649662208};
        nArray2[100] = new int[]{799876864};
        nArray[101] = new int[]{1, 2, 1741, 1742, -1683216640, 1269573376};
        nArray2[101] = new int[]{749545216, 766322432, 783099648, 783099648, 900540160, 917317376};
        nArray[104] = new int[]{1, 1269573376};
        nArray2[104] = new int[]{866985728, 883762944};
        nArray[106] = new int[]{1, 2, -1649662208, 1741, 1742, 1269573376};
        nArray2[106] = new int[]{934094592, 950871808, 414000896, -1129568512, -1129568512, 967649024};
        nArray[108] = nArray[63];
        nArray2[108] = new int[]{816654080};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[109][];
        nArrayArray[1] = new int[]{1521231616};
        nArrayArray[3] = new int[]{1101801216, 1085024000, 1236018944};
        nArrayArray[7] = new int[]{1420568320, 1118578432};
        nArrayArray[12] = new int[]{1470899968, 1135355648};
        nArrayArray[16] = new int[]{1689003776};
        nArrayArray[17] = new int[]{1437345536};
        nArrayArray[18] = new int[]{1454122752};
        nArrayArray[25] = new int[]{1487677184};
        nArrayArray[37] = new int[]{1588340480};
        nArrayArray[42] = new int[]{1538008832, 1353459456};
        nArrayArray[46] = new int[]{1286350592};
        nArrayArray[58] = new int[]{1336682240};
        nArrayArray[63] = new int[]{1772889856};
        nArrayArray[66] = new int[]{1605117696};
        nArrayArray[68] = new int[]{1504454400};
        nArrayArray[83] = new int[]{1319905024};
        nArrayArray[86] = new int[]{1571563264};
        nArrayArray[87] = new int[]{1370236672};
        nArrayArray[92] = new int[]{1554786048};
        nArrayArray[94] = new int[]{1168910080, 1638672128, 1252796160, 1219241728, 1152132864};
        nArrayArray[95] = new int[]{1621894912};
        nArrayArray[101] = new int[]{1722558208, 1705780992};
        nArrayArray[104] = new int[]{1672226560};
        nArrayArray[106] = new int[]{1739335424};
        nArrayArray[108] = new int[]{1655449344};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[109][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[109][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[109][];
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

