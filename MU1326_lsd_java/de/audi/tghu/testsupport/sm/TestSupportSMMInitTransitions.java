/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.testsupport.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class TestSupportSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TestSupportSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[9];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[9][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[0] = new int[]{0};
        nArray[1] = nArray[0];
        nArray[2] = nArray[0];
        nArray[3] = nArray[0];
        nArray[4] = nArray[0];
        nArray[5] = nArray[0];
        nArray[6] = nArray[0];
        nArray[7] = nArray[0];
        nArray[8] = nArray[0];
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[9][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[0] = new int[]{2400001};
        nArray[1] = new int[]{2400003};
        nArray[2] = nArray[1];
        nArray[3] = new int[]{2400002};
        nArray[4] = nArray[0];
        nArray[5] = new int[]{2400004};
        nArray[6] = nArray[0];
        nArray[7] = new int[]{2400005};
        nArray[8] = nArray[5];
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

