/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;

public class InfoSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected InfoSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{7, 3, 0, 593, 593, 593, 593, 593, 265, 14, 271, 1, 6, 14, 15, 6, 3, 83, 7};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{731973376, -10, 564201216, 731973376, 715196160, 849413888, 832636672, 547424000, -10, 681641728, -10, 715196160, 731973376, 715196160, -1, 815859456, -1, 782305024, 782305024};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, 597755648, -1, -1, 614532864, 631310080, -1, 648087296, -1, 648087296, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[19][];
        int[][] nArrayArray2 = new int[19][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[1] = new int[]{1};
        nArray2[1] = new int[]{547424000};
        nArray[3] = new int[]{1, 2, 1741, 1742, 631310080};
        nArray2[3] = new int[]{664864512, 681641728, 648087296, 648087296, 933299968};
        nArray[4] = new int[]{1, 2, -1132068608};
        nArray2[4] = new int[]{950077184, 966854400, 983631616};
        nArray[5] = new int[]{1, 2, 1741, 1742};
        nArray2[5] = new int[]{1033963264, 1050740480, 1067517696, 1067517696};
        nArray[6] = nArray[5];
        nArray2[6] = new int[]{547424000, 782305024, 799082240, 799082240};
        nArray[7] = nArray[5];
        nArray2[7] = new int[]{882968320, 899745536, 916522752, 916522752};
        nArray[8] = new int[]{2, 1, 597755648};
        nArray2[8] = new int[]{698418944, 715196160, 849413888};
        nArray[9] = new int[]{580978432};
        nArray2[9] = new int[]{832636672};
        nArray[10] = new int[]{2, 1, -182843904};
        nArray2[10] = new int[]{564201216, 580978432, 597755648};
        nArray[11] = nArray[1];
        nArray2[11] = new int[]{614532864};
        nArray[12] = new int[]{547424000, 614532864};
        nArray2[12] = new int[]{631310080, 866191104};
        nArray[13] = new int[]{664864512};
        nArray2[13] = new int[]{1000408832};
        nArray[14] = new int[]{1, 2446, -887355904, 698418944};
        nArray2[14] = new int[]{815859456, 1151403776, 1017186048, 1134626560};
        nArray[15] = new int[]{564201216, 1741, 1742};
        nArray2[15] = new int[]{748750592, 731973376, 731973376};
        nArray[16] = nArray[1];
        nArray2[16] = new int[]{765527808};
        nArray[18] = new int[]{2, 1750};
        nArray2[18] = new int[]{1084294912, 1101072128};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[19][];
        nArrayArray[8] = new int[]{597755648};
        nArrayArray[9] = new int[]{547424000};
        nArrayArray[10] = new int[]{564201216};
        nArrayArray[13] = new int[]{580978432};
        nArrayArray[14] = new int[]{631310080};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[19][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[19][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[19][];
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

