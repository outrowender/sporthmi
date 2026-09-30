/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class EarlyAppsSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EarlyAppsSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[105];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
        nArray[57] = 4;
        nArray[59] = 1;
        nArray[61] = 1;
        nArray[75] = 4;
        nArray[76] = 4;
        nArray[80] = 4;
        nArray[81] = 8;
        nArray[82] = 8;
        nArray[84] = 8;
        nArray[85] = 8;
        nArray[86] = 4;
        nArray[89] = 4;
        nArray[90] = 8;
        nArray[91] = 4;
        nArray[92] = 8;
        nArray[93] = 4;
        nArray[97] = 4;
        nArray[103] = 4;
        nArray[104] = 4;
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[105][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[55] = new int[]{0};
        nArray[57] = new int[]{64, 64};
        nArray[58] = new int[]{64};
        nArray[59] = nArray[55];
        nArray[60] = nArray[55];
        nArray[61] = nArray[55];
        nArray[62] = nArray[55];
        nArray[63] = new int[]{16};
        nArray[64] = nArray[58];
        nArray[65] = nArray[58];
        nArray[66] = nArray[63];
        nArray[67] = nArray[55];
        nArray[68] = nArray[58];
        nArray[69] = nArray[58];
        nArray[70] = nArray[55];
        nArray[71] = nArray[55];
        nArray[72] = nArray[55];
        nArray[73] = nArray[55];
        nArray[74] = new int[]{32};
        nArray[75] = new int[]{8, 8, 0};
        nArray[76] = nArray[75];
        nArray[77] = nArray[55];
        nArray[78] = nArray[55];
        nArray[79] = nArray[55];
        nArray[80] = new int[]{0, 0};
        nArray[81] = new int[]{72};
        nArray[82] = nArray[81];
        nArray[83] = nArray[74];
        nArray[84] = nArray[81];
        nArray[85] = nArray[81];
        nArray[86] = nArray[80];
        nArray[87] = nArray[74];
        nArray[88] = nArray[55];
        nArray[89] = new int[]{8, 8};
        nArray[90] = new int[]{40};
        nArray[91] = new int[]{8, 0};
        nArray[92] = nArray[90];
        nArray[93] = nArray[91];
        nArray[95] = nArray[58];
        nArray[97] = nArray[80];
        nArray[98] = nArray[55];
        nArray[99] = nArray[74];
        nArray[100] = nArray[74];
        nArray[101] = nArray[74];
        nArray[103] = nArray[55];
        nArray[104] = nArray[74];
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[105][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[55] = new int[]{2100067};
        nArray[57] = new int[]{2100043, 2100042};
        nArray[58] = new int[]{2100066};
        nArray[59] = new int[]{-3};
        nArray[60] = new int[]{2100052};
        nArray[61] = new int[]{-4};
        nArray[62] = new int[]{2100053};
        nArray[63] = new int[]{2100044};
        nArray[64] = new int[]{2100059};
        nArray[65] = new int[]{2100060};
        nArray[66] = nArray[63];
        nArray[67] = nArray[58];
        nArray[68] = new int[]{2100047};
        nArray[69] = new int[]{2100049};
        nArray[70] = nArray[58];
        nArray[71] = new int[]{2100064};
        nArray[72] = new int[]{2100050};
        nArray[73] = new int[]{2100051};
        nArray[74] = new int[]{2100068};
        nArray[75] = new int[]{2100055, 2100054, 2100074};
        nArray[76] = nArray[75];
        nArray[77] = nArray[55];
        nArray[78] = new int[]{2100045};
        nArray[79] = nArray[63];
        nArray[80] = new int[]{2100069, 2100067};
        nArray[81] = nArray[62];
        nArray[82] = nArray[73];
        nArray[83] = nArray[74];
        nArray[84] = nArray[60];
        nArray[85] = nArray[72];
        nArray[86] = new int[]{2100056, 2100057};
        nArray[87] = new int[]{2100070};
        nArray[88] = new int[]{2100072};
        nArray[89] = new int[]{2100072, 2100073};
        nArray[90] = new int[]{2100075};
        nArray[91] = new int[]{2100071, 2100065};
        nArray[92] = nArray[90];
        nArray[93] = nArray[91];
        nArray[95] = nArray[55];
        nArray[97] = new int[]{2100078, 2100077};
        nArray[98] = nArray[55];
        nArray[99] = new int[]{2100076};
        nArray[100] = nArray[99];
        nArray[101] = nArray[99];
        nArray[103] = nArray[99];
        nArray[104] = nArray[99];
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

