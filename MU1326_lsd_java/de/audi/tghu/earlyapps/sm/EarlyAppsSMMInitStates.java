/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

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
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2100044, 2100044, 2100068, 2100068, 604175, 2100063, 604175, 2100063, 2100062, 2100062, 2100062, 2100062, 2100065, 2100065, 2100070, 2100070, -10, 2100063, 2100063, 2100068, 2100061, 2100061, 2100058, 2100075, 2100045, 2100068, -1, 2100068, -1, 2100075, 2100074, 2100074, 2100065, -1, 2100068, 2100076, 2100076};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2100066, 2100065, -1, -1, 2100060, 2100060, 2100062, 2100062, 2100063, 2100064, 2100059, 2100061, 0x200B20, 2100037, 2100030, 2100031, -1, 2100063, 2100064, -1, -1, -1, -1, -1, 2100067, 2100042, -1, 2100070, -1, 0x200B22, 2100001, 2100001, -1, -1, -1, 600259, 600287};
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
        nArray2[44] = new int[]{2100057, 2100055, 2100055};
        nArray[45] = new int[]{1};
        nArray2[45] = new int[]{2100058};
        nArray[46] = new int[]{1741, 1742};
        nArray2[46] = new int[]{2100059, 2100059};
        nArray[47] = nArray[46];
        nArray2[47] = new int[]{2100060, 2100060};
        nArray[48] = nArray[46];
        nArray2[48] = new int[]{2100061, 2100061};
        nArray[49] = nArray[46];
        nArray2[49] = new int[]{2100062, 2100062};
        nArray[50] = new int[]{1741, 1742, 600329};
        nArray2[50] = new int[]{2100063, 2100063, 2100064};
        nArray[51] = new int[]{600330, 1741, 1742};
        nArray2[51] = new int[]{2100065, 2100066, 2100066};
        nArray[52] = new int[]{1741, 1742, 600295};
        nArray2[52] = new int[]{2100067, 2100067, 2100068};
        nArray[53] = new int[]{600296, 1741, 1742};
        nArray2[53] = new int[]{2100069, 2100070, 2100070};
        nArray[58] = nArray[45];
        nArray2[58] = new int[]{2100071};
        nArray[59] = nArray[46];
        nArray2[59] = new int[]{2100072, 2100072};
        nArray[60] = nArray[46];
        nArray2[60] = new int[]{2100073, 2100073};
        nArray[61] = new int[]{2};
        nArray2[61] = new int[]{2100074};
        nArray[65] = new int[]{1, 2100010};
        nArray2[65] = new int[]{2100075, 2100076};
        nArray[66] = nArray[46];
        nArray2[66] = new int[]{2100077, 2100077};
        nArray[67] = new int[]{2100018, 2100019};
        nArray2[67] = new int[]{2100078, 2100079};
        nArray[68] = new int[]{1, 2100015, 2100016, 1741, 1742, 0x200B2B, 2100017, 2100055, 2100058};
        nArray2[68] = new int[]{2100080, 2100081, 2100082, 2100083, 2100083, 2100084, 2100085, 2100095, 2100103};
        nArray[70] = nArray[44];
        nArray2[70] = new int[]{2100086, 2100087, 2100087};
        nArray[72] = new int[]{2100001};
        nArray2[72] = new int[]{2100088};
        nArray[74] = new int[]{1, 2};
        nArray2[74] = new int[]{2100089, 2100090};
        nArray[75] = new int[]{1, 1741, 0x200B20};
        nArray2[75] = new int[]{2100091, 2100092, 2100093};
        nArray[76] = new int[]{1, 2, 1741, 1742, 2100058};
        nArray2[76] = new int[]{2100097, 2100098, 2100099, 2100099, 2100104};
        nArray[77] = new int[]{600300};
        nArray2[77] = new int[]{2100100};
        nArray[78] = new int[]{600334};
        nArray2[78] = new int[]{2100101};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[79][];
        nArrayArray[65] = new int[]{0x200B20};
        nArrayArray[68] = new int[]{2100004, 2100006};
        nArrayArray[72] = new int[]{2100001};
        nArrayArray[75] = new int[]{0x200B22};
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

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

