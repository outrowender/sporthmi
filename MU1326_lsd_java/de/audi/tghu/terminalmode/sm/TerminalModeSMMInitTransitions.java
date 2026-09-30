/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class TerminalModeSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TerminalModeSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[25];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
        nArray[0] = 4;
        nArray[4] = 4;
        nArray[5] = 4;
        nArray[7] = 4;
        nArray[9] = 264;
        nArray[10] = 1;
        nArray[14] = 4;
        nArray[16] = 1;
        nArray[18] = 4;
        nArray[19] = 4;
        nArray[20] = 1;
        nArray[21] = 4;
        nArray[22] = 1;
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[25][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[0] = new int[]{0, 0};
        nArray[2] = new int[]{64};
        nArray[3] = new int[]{0};
        nArray[4] = new int[]{64, 64, 64, 0};
        nArray[5] = new int[]{64, 64};
        nArray[7] = nArray[4];
        nArray[9] = new int[]{8};
        nArray[10] = nArray[3];
        nArray[11] = nArray[3];
        nArray[12] = new int[]{32};
        nArray[13] = nArray[3];
        nArray[14] = nArray[0];
        nArray[15] = nArray[2];
        nArray[16] = nArray[3];
        nArray[17] = nArray[12];
        nArray[18] = nArray[0];
        nArray[19] = nArray[0];
        nArray[20] = nArray[3];
        nArray[21] = nArray[0];
        nArray[22] = nArray[3];
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[25][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[0] = new int[]{3200010, 3200012};
        nArray[2] = new int[]{3200003};
        nArray[3] = new int[]{3200004};
        nArray[4] = new int[]{3200006, 3200013, 3200014, 3200000};
        nArray[5] = new int[]{3200002, 3200003};
        nArray[7] = nArray[4];
        nArray[9] = new int[]{3200008};
        nArray[10] = new int[]{-3};
        nArray[11] = new int[]{3200007};
        nArray[12] = new int[]{3200010};
        nArray[13] = nArray[11];
        nArray[14] = new int[]{3200005, 3200004};
        nArray[15] = nArray[11];
        nArray[16] = new int[]{-4};
        nArray[17] = nArray[12];
        nArray[18] = nArray[0];
        nArray[19] = new int[]{3200011, 3200009};
        nArray[20] = nArray[16];
        nArray[21] = nArray[0];
        nArray[22] = nArray[16];
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        hashMap.put(new Integer(9), new Integer(2500006));
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

