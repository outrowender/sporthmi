/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.wirelesscharging.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;

public class WirelessChargingSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected WirelessChargingSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initTransitions() {
        this.initTransFlagList();
        this.initTransTrgtFlagList();
        this.initTransitionTargetStateList();
        this.initTransIncludeJumpList();
    }

    private void initTransFlagList() {
        int[] nArray = new int[5];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[5][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[0] = new int[]{32};
        nArray[1] = new int[]{0};
        nArray[2] = nArray[0];
        nArray[3] = nArray[1];
        nArray[4] = nArray[0];
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[5][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[0] = new int[]{1122054912};
        nArray[1] = new int[]{1105277696};
        nArray[2] = nArray[0];
        nArray[3] = new int[]{1138832128};
        nArray[4] = new int[]{1155609344};
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

