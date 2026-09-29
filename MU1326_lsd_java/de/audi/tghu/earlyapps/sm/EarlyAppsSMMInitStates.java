/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

public class EarlyAppsSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EarlyAppsSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 81, 1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 3, 0, 0, 1, 7, 1, 0, 9, 6, 6, 15, 6, 3, 6, 14, 6, 1, 15, 1, 0, 0};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1275797504, 1275797504, 1678450688, 1678450688, 255330560, 1594564608, 255330560, 1594564608, 1577787392, 1577787392, 1577787392, 1577787392, 1628119040, 1628119040, 1712005120, 1712005120, -10, 1594564608, 1594564608, 1678450688, 1561010176, 1561010176, 1510678528, 1795891200, 1292574720, 1678450688, -1, 1678450688, -1, 1795891200, 1779113984, 1779113984, 1628119040, -1, 1678450688, 1812668416, 1812668416};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1644896256, 1628119040, -1, -1, 1544232960, 1544232960, 1577787392, 1577787392, 1594564608, 1611341824, 1527455744, 1561010176, 0x200B2000, 1158356992, 1040916480, 1057693696, -1, 1594564608, 1611341824, -1, -1, -1, -1, -1, 1661673472, 1242243072, -1, 1712005120, -1, 0x220B2000, 554377216, 554377216, -1, -1, -1, -1020786432, -551024384};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[79][];
        int[][] nArrayArray2 = new int[79][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[44] = new int[]{1, 1741, 1742};
        nArray2[44] = new int[]{1493901312, 1460346880, 1460346880};
        nArray[45] = new int[]{1};
        nArray2[45] = new int[]{1510678528};
        nArray[46] = new int[]{1741, 1742};
        nArray2[46] = new int[]{1527455744, 1527455744};
        nArray[47] = nArray[46];
        nArray2[47] = new int[]{1544232960, 1544232960};
        nArray[48] = nArray[46];
        nArray2[48] = new int[]{1561010176, 1561010176};
        nArray[49] = nArray[46];
        nArray2[49] = new int[]{1577787392, 1577787392};
        nArray[50] = new int[]{1741, 1742, 0x9290900};
        nArray2[50] = new int[]{1594564608, 1594564608, 1611341824};
        nArray[51] = new int[]{170461440, 1741, 1742};
        nArray2[51] = new int[]{1628119040, 1644896256, 1644896256};
        nArray[52] = new int[]{1741, 1742, -416806656};
        nArray2[52] = new int[]{1661673472, 1661673472, 1678450688};
        nArray[53] = new int[]{-400029440, 1741, 1742};
        nArray2[53] = new int[]{1695227904, 1712005120, 1712005120};
        nArray[58] = nArray[45];
        nArray2[58] = new int[]{1728782336};
        nArray[59] = nArray[46];
        nArray2[59] = new int[]{1745559552, 1745559552};
        nArray[60] = nArray[46];
        nArray2[60] = new int[]{1762336768, 1762336768};
        nArray[61] = new int[]{2};
        nArray2[61] = new int[]{1779113984};
        nArray[65] = new int[]{1, 705372160};
        nArray2[65] = new int[]{1795891200, 1812668416};
        nArray[66] = nArray[46];
        nArray2[66] = new int[]{1829445632, 1829445632};
        nArray[67] = new int[]{839589888, 856367104};
        nArray2[67] = new int[]{1846222848, 1863000064};
        nArray[68] = new int[]{1, 789258240, 806035456, 1741, 1742, 0x2B0B2000, 822812672, 1460346880, 1510678528};
        nArray2[68] = new int[]{1879777280, 1896554496, 1913331712, 1930108928, 1930108928, 1946886144, 1963663360, 2131435520, -2029314048};
        nArray[70] = nArray[44];
        nArray2[70] = new int[]{1980440576, 1997217792, 1997217792};
        nArray[72] = new int[]{554377216};
        nArray2[72] = new int[]{2013995008};
        nArray[74] = new int[]{1, 2};
        nArray2[74] = new int[]{2030772224, 2047549440};
        nArray[75] = new int[]{1, 1741, 0x200B2000};
        nArray2[75] = new int[]{2064326656, 2081103872, 2097881088};
        nArray[76] = new int[]{1, 2, 1741, 1742, 1510678528};
        nArray2[76] = new int[]{-2129977344, -2113200128, -2096422912, -2096422912, -2012536832};
        nArray[77] = new int[]{-332920576};
        nArray2[77] = new int[]{-2079645696};
        nArray[78] = new int[]{237570304};
        nArray2[78] = new int[]{-2062868480};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[79][];
        nArrayArray[65] = new int[]{0x200B2000};
        nArrayArray[68] = new int[]{604708864, 638263296};
        nArrayArray[72] = new int[]{554377216};
        nArrayArray[75] = new int[]{0x220B2000};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[79][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[79][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[79][];
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

