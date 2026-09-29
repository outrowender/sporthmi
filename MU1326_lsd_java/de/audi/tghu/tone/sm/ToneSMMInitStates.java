/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

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
        int[] nArray = new int[]{-1, -10, -1, -2109600000, 1212288768, 1883377408, 1212288768, -2008936704, -10, 1950486272, -1, -2092822784, 1967263488, -1, -1, -1, -1, -1, 1833045760, -2059268352, 1866600192, 1916931840, 1900154624, 1933709056, 2000817920, 2118258432, 1749159680, 2017595136, 1782714112, 2034372352, 2051149568, -1807610112, 2084704000, -1, 1782714112, -1, -1, 1799491328, 1799491328, 1799491328, -10, -10, -10, 1212288768, 1799491328, 1799491328, -1, 1145179904, 1145179904, 1145179904, 1145179904, 1145179904, 1799491328, 1765936896, 1816268544, 1145179904, 1749159680, -1757278464, -1757278464, -1, -1757278464, -1, 1145179904, 1984040704, 1145179904, -2143154432, 1094848256, 1765936896, 1833045760, -10, 1799491328, -10, -1706946816, -1706946816, 1799491328, -1975382272, -1, -1857941760, 1765936896, -1790832896, -1841164544, -10, -1975382272, 1648496384, -10, -1908273408, -1908273408, 1648496384, 1799491328, -1740501248, -2025713920, -1706946816};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -2109600000, -1, -1, -1, 1212288768, 1161957120, 1329729280, -1, 1648496384, -1, 1413615360, 1833045760, -1, -1, -1, -1, -1, 1363283712, 1346506496, 1279397632, 1312952064, 1178734336, 1262620416, 1245843200, 1229065984, 1380060928, 1396838144, 1463947008, 1531055872, 1497501440, 1514278656, 1480724224, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1547833088, -1, 1849822976, -1, -1, -1, -1, -1, -1, -1, -2092822784, -1, -2076045568, -1, -2059268352, -1, -2042491136, -1, -1, -1, -1, -1, -1, -2008936704, -1, -1, -1992159488, -1, 1329729280};
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
        nArray2[1] = new int[]{1078071040, 1094848256};
        nArray[3] = nArray[1];
        nArray2[3] = new int[]{1161957120, 1178734336};
        nArray[4] = new int[]{1741, 1742, -1824387328, 1816268544};
        nArray2[4] = new int[]{1195511552, 1195511552, -666759424, -1455288576};
        nArray[6] = new int[]{1279397632, 1212288768, 1262620416, 1296174848, 1245843200, 1229065984, 1883377408, 1950486272};
        nArray2[6] = new int[]{1262620416, 1212288768, 1279397632, 1296174848, 1312952064, 1329729280, -1388179712, -1253961984};
        nArray[8] = new int[]{2, 1, 1581387520, 1178734336, 1094848256, 1195511552, 1161957120, 1078071040, 1111625472, 1145179904, 1741, 1742, -1723724032, -582873344, -1857941760, 2067926784, 2017595136, 1732382464};
        nArray2[8] = new int[]{1229065984, 1245843200, 1346506496, 1363283712, 1111625472, 1380060928, 1396838144, 1128402688, 1413615360, 1430392576, 1145179904, 1145179904, -196997376, -113111296, -750645504, -1002303744, -1086189824, 1933709056};
        nArray[11] = new int[]{1782714112, 1984040704};
        nArray2[11] = new int[]{-2042491136, -1237184768};
        nArray[18] = new int[]{1329729280};
        nArray2[18] = new int[]{1480724224};
        nArray[26] = new int[]{1346506496, 1741, 1742, 1967263488};
        nArray2[26] = new int[]{1547833088, -2126377216, -2126377216, -1220407552};
        nArray[28] = new int[]{1430392576, 1380060928, 1396838144, 1413615360};
        nArray2[28] = new int[]{1581387520, 1598164736, 1614941952, 1631719168};
        nArray[34] = new int[]{1741, 1742, 2000817920, 1866600192};
        nArray2[34] = new int[]{1665273600, 1665273600, -1170075904, -1438511360};
        nArray[37] = nArray[1];
        nArray2[37] = new int[]{1967263488, 1984040704};
        nArray[38] = nArray[1];
        nArray2[38] = new int[]{2000817920, 2017595136};
        nArray[39] = nArray[1];
        nArray2[39] = new int[]{2034372352, 2051149568};
        nArray[40] = new int[]{2, 1, 2067926784};
        nArray2[40] = new int[]{2067926784, 2084704000, -649982208};
        nArray[41] = new int[]{2, 1, 1741, 1742, 2067926784};
        nArray2[41] = new int[]{2101481216, 2118258432, -2109600000, -2109600000, -582873344};
        nArray[42] = new int[]{2, 1, 1741, 1742, 1933709056, 2067926784};
        nArray2[42] = new int[]{2135035648, -2143154432, -2092822784, -2092822784, -1270739200, -566096128};
        nArray[43] = new int[]{2, 1741, 1742, 2067926784};
        nArray2[43] = new int[]{-2076045568, -2059268352, -2059268352, -633204992};
        nArray[45] = new int[]{-1757278464};
        nArray2[45] = new int[]{-398323968};
        nArray[47] = new int[]{1, 1799491328};
        nArray2[47] = new int[]{-1992159488, -1975382272};
        nArray[48] = nArray[47];
        nArray2[48] = new int[]{-1958605056, -1941827840};
        nArray[49] = new int[]{1, 1312952064, 1799491328};
        nArray2[49] = new int[]{-1925050624, 1531055872, -1908273408};
        nArray[50] = new int[]{1, 1741, 1742, 1833045760, 1799491328};
        nArray2[50] = new int[]{-1891496192, 1514278656, 1514278656, -1404956928, -1874718976};
        nArray[51] = nArray[47];
        nArray2[51] = new int[]{-1857941760, -1841164544};
        nArray[52] = nArray[47];
        nArray2[52] = new int[]{-1824387328, -1807610112};
        nArray[53] = new int[]{1, 1741, 1742, 2034372352, 1799491328};
        nArray2[53] = new int[]{-1790832896, 1648496384, 1648496384, -1102967040, -1774055680};
        nArray[54] = new int[]{1, -1774055680, 1799491328};
        nArray2[54] = new int[]{-1757278464, -415101184, -1740501248};
        nArray[55] = nArray[47];
        nArray2[55] = new int[]{-1723724032, -1706946816};
        nArray[56] = new int[]{1, 1741, 1742, 1916931840, 1799491328, 2051149568};
        nArray2[56] = new int[]{-1690169600, 1564610304, 1564610304, -1304293632, -1673392384, -1069412608};
        nArray[57] = new int[]{1, 1447169792, 1648496384, 1799491328};
        nArray2[57] = new int[]{-1656615168, 1833045760, 1849822976, -1639837952};
        nArray[58] = nArray[47];
        nArray2[58] = new int[]{-1623060736, -1606283520};
        nArray[60] = nArray[47];
        nArray2[60] = new int[]{-1555951872, -1539174656};
        nArray[62] = nArray[47];
        nArray2[62] = new int[]{-1488843008, -1472065792};
        nArray[64] = nArray[47];
        nArray2[64] = new int[]{-1371402496, -1354625280};
        nArray[66] = new int[]{1};
        nArray2[66] = new int[]{-1287516416};
        nArray[67] = new int[]{1, 1346506496, -1807610112, 1799491328};
        nArray2[67] = new int[]{-1203630336, 1463947008, -549318912, -1186853120};
        nArray[68] = nArray[1];
        nArray2[68] = new int[]{-1153298688, -1136521472};
        nArray[69] = new int[]{2, 1, 1741, 1742, 1799491328, 2067926784};
        nArray2[69] = new int[]{-1119744256, -2025713920, 1497501440, 1497501440, -2008936704, -616427776};
        nArray[70] = nArray[1];
        nArray2[70] = new int[]{-834531584, -817754368};
        nArray[71] = new int[]{2, 1, -1790832896, 2067926784, -784199936};
        nArray2[71] = new int[]{-800977152, -1522397440, -431878400, -599650560, -129888512};
        nArray[72] = nArray[47];
        nArray2[72] = new int[]{-767422720, -1505620224};
        nArray[75] = new int[]{-1841164544};
        nArray2[75] = new int[]{-733868288};
        nArray[78] = new int[]{1, 2, 2067926784, 1741, 1742, -1891496192};
        nArray2[78] = new int[]{-280883456, -264106240, -247329024, -532541696, -532541696, -230551808};
        nArray[80] = nArray[1];
        nArray2[80] = new int[]{-482210048, -381546752};
        nArray[81] = new int[]{2, 1, 1741, 1742, 1799491328};
        nArray2[81] = new int[]{-465432832, -717091072, -448655616, -448655616, -683536640};
        nArray[82] = new int[]{1, 2, -1891496192};
        nArray2[82] = new int[]{-364769536, -700313856, -347992320};
        nArray[83] = nArray[1];
        nArray2[83] = new int[]{-331215104, -314437888};
        nArray[84] = new int[]{2, 1, 1799491328};
        nArray2[84] = new int[]{-297660672, -1589506304, -1572729088};
        nArray[85] = nArray[47];
        nArray2[85] = new int[]{-515764480, -498987264};
        nArray[88] = nArray[47];
        nArray2[88] = new int[]{-180220160, -163442944};
        nArray[90] = new int[]{1, -1891496192};
        nArray2[90] = new int[]{-146665728, -784199936};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[92][];
        nArrayArray[4] = new int[]{-2092822784, 1866600192};
        nArrayArray[6] = new int[]{1564610304};
        nArrayArray[11] = new int[]{1128402688, 1547833088};
        nArrayArray[26] = new int[]{1581387520};
        nArrayArray[40] = new int[]{-2076045568};
        nArrayArray[41] = new int[]{-1992159488};
        nArrayArray[42] = new int[]{-1774055680, -1757278464, 1531055872, -1958605056};
        nArrayArray[44] = new int[]{-1975382272};
        nArrayArray[45] = new int[]{-1891496192};
        nArrayArray[47] = new int[]{1245843200, 1682050816};
        nArrayArray[48] = new int[]{1413615360, 1698828032};
        nArrayArray[49] = new int[]{1715605248, 1262620416};
        nArrayArray[50] = new int[]{1430392576, 1212288768, 1732382464};
        nArrayArray[51] = new int[]{1749159680, 1178734336};
        nArrayArray[52] = new int[]{-2008936704, 1900154624, 1312952064};
        nArrayArray[53] = new int[]{1665273600, 1296174848};
        nArrayArray[54] = new int[]{-1908273408, 1396838144, 1950486272};
        nArrayArray[55] = new int[]{1229065984, 1765936896, 1447169792};
        nArrayArray[56] = new int[]{1161957120, 1782714112, 1514278656};
        nArrayArray[57] = new int[]{1329729280};
        nArrayArray[58] = new int[]{1346506496};
        nArrayArray[60] = new int[]{1363283712};
        nArrayArray[62] = new int[]{1195511552, 1799491328};
        nArrayArray[64] = new int[]{1497501440};
        nArrayArray[67] = new int[]{1598164736};
        nArrayArray[69] = new int[]{1145179904, -2059268352, 1933709056};
        nArrayArray[71] = new int[]{-2042491136, 1916931840};
        nArrayArray[72] = new int[]{2118258432};
        nArrayArray[74] = new int[]{-1740501248, -2025713920};
        nArrayArray[78] = new int[]{-1841164544, -1857941760, -1925050624};
        nArrayArray[81] = new int[]{-2126377216, -2109600000};
        nArrayArray[82] = new int[]{-1874718976};
        nArrayArray[84] = new int[]{1967263488, 1380060928, 1480724224};
        nArrayArray[85] = new int[]{-1941827840};
        nArrayArray[87] = new int[]{1631719168};
        nArrayArray[88] = new int[]{-1824387328, -1790832896, -1807610112};
        nArrayArray[90] = new int[]{-2143154432};
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

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

